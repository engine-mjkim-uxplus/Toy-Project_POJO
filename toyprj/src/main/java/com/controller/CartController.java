package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.shopping.toyprj.CartLogic;
import com.shopping.toyprj.Controller;
import com.util.HashMapBinder;
import com.util.ModelAndView;
import com.vo.CartVO;
public class CartController implements Controller {
	Logger logger = Logger.getLogger(CartController.class);
	CartLogic cartLogic = new CartLogic();
	
	/************************ 장바구니 목록조회 ****************************/
	@Override
	public Object cartList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("CartController => cart/cartList.do 호출 ");
		List<CartVO> cartList = null;
		ModelAndView mv = new ModelAndView(req); // req넘겨줘야 mv.addObject 사용가능
		mv.setViewName("cart");
		HttpSession session = req.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		List<CartVO> sCartList = (ArrayList<CartVO>)session.getAttribute("cartList");
		
		// 회원일 경우 db에서 카트조회
		if(mem_id != null) {
			cartList = cartLogic.cartList(mem_id);
			mv.addObject("cartList", cartList);
		}
		return mv;
	}
	
	/************************ 장바구니 담기 ****************************/
	@Override
	public Object cartInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("CartController => cart/carInsert 호출 ");
		
		String select = null;
		int result = 0;
		HttpSession session = req.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		List<CartVO> sCartList = (ArrayList<CartVO>)session.getAttribute("cartList");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		
		// 각 자료형에 맞게 파라미터 값 형변환(비로그인 시 활용)
		String product_no = (String)pMap.get("product_no");
		String product_img = (String)pMap.get("product_img");
		String product_category = (String)pMap.get("product_category");
		String product_name = (String)pMap.get("product_name");
		int product_count = Integer.valueOf((String) pMap.get("product_count"));
		int product_price = Integer.valueOf((String)pMap.get("product_price"));
		String url = (String)pMap.get("url");
		String path = "";

		// 회원 장바구니 담기
		if(mem_id != null) {
			pMap.put("mem_id", mem_id);
			pMap.put("product_count", product_count);
			select = cartLogic.cartSearch(pMap);
			// 이후 cartUpdate로 redirect 하도록 수정 필요	
			// 기존에 장바구니에 있는 상품일 경우 수량 UPDATE
			if(select != null) {
				result = cartLogic.cartUpdate(pMap);
				// 기존 장바구니에 없는 상품일 경우 CART 테이블에 INSERT
			} else {
				result = cartLogic.cartInsert(pMap);
			}
			// 메인페이지에서 장바구니 담기
			if(url.equals("home")) {
				path = "product/productList.do";
			}
			// 상세페이지 장바구니 담기
			else {
				path = "product/productDetail.do?product_no=" + product_no + "&product_category=" + product_category;	
			}
		}
		
		// 비로그인 장바구니 담기
		else if(mem_id == null) {
			// 처음으로 장바구니 담을 시 cart생성
			if(sCartList == null) {
				sCartList = new ArrayList<CartVO>();
				// 파라미터로 넘어온 아이템 추가
				CartVO item= new CartVO(product_name,product_no,product_count,product_img,product_price,product_category);
				sCartList.add(item);
				session.setAttribute("cartList", sCartList);
				// 메인페이지에서 장바구니 담기
				if(url.equals("home")) {
					path = "product/productList.do";
				}
				// 상세페이지 장바구니 담기
				else if(url.equals("detail")) {
					path = "product/productDetail.do?product_no=" + product_no + "&product_category=" + product_category;	
					
				}
			} else {
				// 기존 상품이 아니면 0, 기존 상품이면 1
				int check = 0;
				
				for(CartVO cartList : sCartList) {
					String sProduct_name = cartList.getProduct_name();
					int sProduct_count = cartList.getProduct_count();
					
					// 기존에 장바구니에 있는 상품인지 체크
					if(product_name.equals(sProduct_name)) {
						cartList.setProduct_count(sProduct_count + product_count);
						++check;
						break;
					}
				}				
				if(check == 0) {
					CartVO item= new CartVO(product_name,product_no,product_count,product_img,product_price,product_category);
					sCartList.add(item);
					session.setAttribute("cartList", sCartList);
				}
				// 메인페이지에서 장바구니 담기
				if(url.equals("home")) {
					path = "product/productList.do";
				}
				// 상세페이지 장바구니 담기
				else if(url.equals("detail")) {
					path = "product/productDetail.do?product_no=" + product_no + "&product_category=" + product_category;		
				}
			} // end of else
		} // end of else if
			
		return path;
	}
	
	/************************ 장바구니 수량 변경 ****************************/
	@Override
	public Object cartUpdate(HttpServletRequest req, HttpServletResponse res) {
		logger.info("CartController => cart/cartUpdate.do 호출 ");
		int result = 0;
		String path = "cart/cartList.do";
		HttpSession session = req.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		List<CartVO> sCartList = (ArrayList<CartVO>)session.getAttribute("cartList");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		
		int product_no = Integer.valueOf((String) pMap.get("product_no"));
		pMap.put("product_no", product_no);
		pMap.put("mem_id", mem_id);
		
		// 회원 수량 변경
		if(mem_id != null) {
			result = cartLogic.cartUpdate(pMap);
			
		// 비회원 수량 변경
		} else if(mem_id ==null && sCartList !=null) {
			String btn = (String)pMap.get("btn");
			String no = String.valueOf(product_no);
			
			// 수량 증가할 아이템 list에서 찾은 후 수량 변경
			for(CartVO item : sCartList) {
				if(item.getProduct_no().equals(no)) {
					int count = item.getProduct_count();
					// 수량 증가/감소 분기
					if(btn.equals("plus")) {
						item.setProduct_count(count + 1);
						logger.info("수량 1 증가");
					} else {
						item.setProduct_count(count - 1);
						logger.info("수량 1 감소");
					}
					break;
				}
			}
		}
		return path;
	}
	
	/************************ 장바구니 아이템 삭제 ****************************/
	@Override
	public Object cartDelete(HttpServletRequest req, HttpServletResponse res) {
		logger.info("CartController => cart/cartDelete.do 호출 ");
		
		int result = 0;
		String path = "cart/cartList.do";
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		HttpSession session = req.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		List<CartVO> sCartList = (ArrayList<CartVO>)session.getAttribute("cartList");
		int product_no = Integer.valueOf((String) pMap.get("product_no"));
		pMap.put("product_no", product_no);
		pMap.put("mem_id", mem_id);
		
		// 회원 장바구니 삭제
		if(mem_id != null) {
			result = cartLogic.cartDelete(pMap);
			
		// 비회원 장바구니 삭제
		}else if(mem_id ==null && sCartList !=null) {
			String btn = (String)pMap.get("btn");
			String no = String.valueOf(product_no);
			
			// 장바구니에서 삭제할 아이템 list에서 찾은 후 삭제
			for(CartVO item : sCartList) {
				if(item.getProduct_no().equals(no)) {
					sCartList.remove(item);
					break;
					
				}
			}
		}
		return path;
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
	public Object orderList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object orderInsert(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
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
	public Object logout(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

}
