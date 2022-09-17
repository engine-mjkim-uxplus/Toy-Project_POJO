package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.shopping.toyprj.Controller;
import com.shopping.toyprj.MemberLogic;
import com.shopping.toyprj.OrderLogic;
import com.util.HashMapBinder;
import com.util.ModelAndView;
import com.vo.CartVO;
import com.vo.CouponVO;
import com.vo.MemberVO;

public class OrderController implements Controller {
	Logger logger = Logger.getLogger(OrderController.class);
	OrderLogic orderLogic = new OrderLogic();
	MemberLogic memberLogic = new MemberLogic();
	
	
	@Override
	public Object orderList(HttpServletRequest req, HttpServletResponse res) {
	logger.info("OrderController => order/orderList.do 호출 ");
	ModelAndView mv = new ModelAndView(req);
	HashMapBinder hmb = new HashMapBinder(req);
	Map<String,Object> pMap = new HashMap<>();
	hmb.bind(pMap);
	
	// 상품이 한가지 품목만 넘어 왔을 경우, 여러 품목이 넘어 왔을 경우에 대해 분기처리
	// pMap.get(key)값이 여러개면 ? pMap.get(key)값이 하나면?
	List cartList = new ArrayList();
	CartVO cartVO = null;
	
	// pMap에 저장된 상품이 하나일 경우
	if(pMap.get("product_name") instanceof String) {
		String product_name = (String)pMap.get("product_name");
		String product_img = (String)pMap.get("product_img");
		String product_no =  (String)pMap.get("product_no");
		int product_price = Integer.valueOf((String)pMap.get("product_price"));
		int product_count = Integer.valueOf((String)pMap.get("product_count"));
		// 상품정보 1건 VO를 통해 List에 담기
		cartVO = new CartVO(product_name, product_img, product_no, product_price, product_count);
		cartList.add(cartVO);
		
	// pMap에 저장된 상품이 여러개일 경우(배열)	
	} else {
		String[] product_name = (String[])pMap.get("product_name");
		String[] product_img = (String[])pMap.get("product_img");
		String[] product_no = (String[])pMap.get("product_no");
		int[] product_price = Arrays.stream((String[])pMap.get("product_price"))
								.mapToInt(Integer::parseInt).toArray();
		int[] product_count = Arrays.stream((String[])pMap.get("product_count"))
								.mapToInt(Integer::parseInt).toArray();
		// 상품정보 N건 VO를 통해 List에 담기
		for(int i =0; i < product_name.length; i++) {
			cartVO = new CartVO(product_name[i], product_img[i]
					, product_no[i], product_price[i], product_count[i]);
			cartList.add(cartVO);
		}
		
	}
	HttpSession session = req.getSession();
	String mem_id = (String)session.getAttribute("mem_id");
	MemberVO member = null;
	List<CouponVO> couponList = null;
	// 회원일 경우 회원테이블에서 주소 가져오기
	if(mem_id != null) {
		mv.setViewName("memPayment");
		
		member = new MemberVO();
		member = memberLogic.Login(mem_id); // 멤버의 주소 및 휴대폰 번호
		mv.addObject("member", member);
		
		Map<String,Object> rMap = new HashMap(); // 결과값 받아올 Map
		// 쿠폰 여부조회 및 쿠포정보 가져오기
		couponList = orderLogic.memberCoupon(mem_id,rMap);
		
		// 조회한 쿠폰 결과가 있으면 추가(List 자료형이면 결과값이 있는 것)
		if((int)rMap.get("result") > 0 ) {
			logger.info("Controller 쿠폰 => " + couponList);
			mv.addObject("couponList",couponList);
		} else {
			couponList = null;
		}
		
	// 비회원
	} else if(mem_id == null) {
		mv.setViewName("payment");
	}
	mv.addObject("cartList", cartList);
	return mv;
	}
	
	@Override
	public Object orderInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("OrderController => order/orderInsert.do 호출 ");
		ModelAndView mv = new ModelAndView(req);
		HashMapBinder hmb = new HashMapBinder(req);
		HttpSession session = req.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		Map<String,Object> pMap = new HashMap<>();
		hmb.bind(pMap);
		pMap.put("mem_id", mem_id);
		
		// 주문번호(날짜생성 ex.20220522)
		String orderNumber = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
		String strToday2 = sdf.format(c1.getTime());
		pMap.put("order_date", strToday2); // 테이블에 저장할 날짜(yyyy-mm-dd)
		
		String uuid = UUID.randomUUID().toString();
		// 하이픈 제외
		String resultUuid = uuid.toString().replaceAll("-", "");
		orderNumber = strToday + resultUuid.substring(0,10);
		mv.addObject("orderNumber", orderNumber);
		mv.addObject("name", (String)pMap.get("name"));
		pMap.put("orderNumber", orderNumber);
		logger.info(orderNumber);
		
		// 회원 주문
		if(mem_id != null) {
			List<Map<String,Object>> productList = null;
			HashMap<String,Object> lMap = null;
			// 상품이 단건일 경우
			if(pMap.get("product_name") instanceof String) {
				logger.info("상품이 하나 입니다");
				orderLogic.memOrder(pMap);
				
			// pMap에 저장된 상품이 여러개일 경우(배열)	
			} else {
				logger.info("상품이 여러개 입니다");
				try {
					productList = new ArrayList<>();
					String[] product_name = (String[])pMap.get("product_name");
					String[] product_no = (String[])pMap.get("product_no");
					int[] product_price = Arrays.stream((String[])pMap.get("product_price"))
											.mapToInt(Integer::parseInt).toArray();
					int[] product_count = Arrays.stream((String[])pMap.get("product_count"))
											.mapToInt(Integer::parseInt).toArray();	
					
					for(int i = 0; i < product_name.length; i++) {
						logger.info("여기타니");
						lMap = new HashMap<>();
						lMap.put("product_name", product_name[i]); 
						lMap.put("product_no", product_no[i]); 
						lMap.put("product_price", product_price[i]); 
						lMap.put("product_count", product_count[i]); 
						productList.add(lMap);
					}
					pMap.put("productList", productList);
					orderLogic.memOrder(pMap);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
		} 
		// 비회원 주문
		else {
			
		}
		
		mv.setViewName("sucessPayment");
		
		return mv;
	}
	
	@Override
	public Object orderUpdateCoupon(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object orderUpdatePoint(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object orderDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object loginForm(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productDetail(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productSearch(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productInsertReview(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productUpdateReview(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productUpdateCount(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productInsertLike(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object productDeleteLike(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object registerForm(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object registerSelect(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object registerInsert(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberListPayment(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberListLike(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberListReview(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberListCoupon(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberListP(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberInsertCoupon(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberInsertAddress(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberUpdateP(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberUpdateState(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object cartList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object cartInsert(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object cartUpdate(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object cartDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object logout(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

}
