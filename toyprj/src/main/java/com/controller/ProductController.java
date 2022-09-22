package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.shopping.toyprj.Controller;
import com.shopping.toyprj.ProductLogic;
import com.util.HashMapBinder;
import com.util.ModelAndView;
import com.vo.ProductVO;

public class ProductController implements Controller {
	Logger logger = Logger.getLogger(ProductController.class);
	HttpSession session = null;
	ProductLogic productLogic = new ProductLogic();
	
	/*********************** 전체 상품페이지(홈페이지) 요청 ***********************/
	@Override
	public Object productList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("ProductController: productList 호출");
		ModelAndView mav = new ModelAndView(req);
		mav.setViewName("home");
		
		Map<String,Object> pMap = new HashMap<>();
		session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		
		
		if ( id != null ) {
			pMap.put("member_id", id);
			List<Integer> likeList = null;
			likeList = productLogic.likeList(pMap);
			mav.addObject("likeList", likeList);
		}
		
		List<ProductVO> productList = null;
		productList = productLogic.productList();
		mav.addObject("productList", productList);
		
		return mav;
	}
	
	/*********************** 디테일 상품페이지 요청 ***********************/
	@Override
	public Object productDetail(HttpServletRequest req, HttpServletResponse res) {
		logger.info("ProductController: productDetail 호출");
		
		ModelAndView mav = new ModelAndView(req);
		mav.setViewName("detail");
		
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		
		session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		
		if ( id != null ) {
			pMap.put("member_id", id);
			List<Integer> likeList = null;
			likeList = productLogic.likeList(pMap);
			mav.addObject("likeList", likeList);
		}
		
		List<Map<String,Object>> productList = null;
		productList = productLogic.productDetail(pMap);
		mav.addObject("productList", productList);
		
		return mav;
	}
	
	/*********************** 좋아요 추가 요청 ***********************/
	@Override
	public Object productInsertLike(HttpServletRequest req, HttpServletResponse res) {
		logger.info("ProductController: productInsertLike 호출");
		
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		
		session = req.getSession();
		pMap.put("member_id", session.getAttribute("mem_id"));
		
		productLogic.addLike(pMap);
		
		String page = (String) pMap.get("page");
		
		if(page.equals("productDetail.do")) {
			String no = (String) pMap.get("product_no");
			String category = (String) pMap.get("product_category");
			page = "productDetail.do?product_no="+no+"&product_category="+category;
		}
		
		String path = "product/"+page;
		return path;
	}
	
	/*********************** 좋아요 삭제 요청 ***********************/
	@Override
	public Object productDeleteLike(HttpServletRequest req, HttpServletResponse res) {
		logger.info("ProductController: productInsertLike 호출");
		
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		
		session = req.getSession();
		pMap.put("member_id", session.getAttribute("mem_id"));
		
		productLogic.minusLike(pMap);
		
		String page = (String) pMap.get("page");
		
		if(page.equals("productDetail.do")) {
			String no = (String) pMap.get("product_no");
			String category = (String) pMap.get("product_category");
			page = "productDetail.do?product_no="+no+"&product_category="+category;
		}
		
		String path = "product/"+page;
		return path;
	}
	
	/*********************** 상품 검색 요청 (수정필요) ***********************/
	@Override
	public Object productSearch(HttpServletRequest req, HttpServletResponse res) {
		logger.info("ProductController: productSearch 호출");
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		
		List<ProductVO> productList = null;
		productList = productLogic.productSearch(pMap);
		
		ModelAndView mav = new ModelAndView(req);
		mav.addObject("productList", productList);
		mav.setViewName("home");
		
		return mav;
	}
	
	/*********************** 상품 리뷰 추가 요청 ***********************/
	@Override
	public Object productInsertReview(HttpServletRequest req, HttpServletResponse res) {
		logger.info("ProductController: productInsertReview 호출");
		
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.multiBind(pMap);
		
		productLogic.productInsertReview(pMap);
		String no = (String) pMap.get("product_no");
		String category = (String) pMap.get("product_category");
		
		String path = "product/productDetail.do?product_no="+no+"&product_category="+category;
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

	@Override
	public Object orderUnmemberPage(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object orderUnmemberSelect(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object orderSucess(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

}
