package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.shopping.toyprj.Controller;
import com.shopping.toyprj.MemberLogic;
import com.util.HashMapBinder;
import com.util.ModelAndView;
import com.vo.CouponVO;
import com.vo.MemberVO;
import com.vo.ProductVO;

public class MemberController implements Controller {
	Logger logger = Logger.getLogger(MemberController.class);
	MemberLogic memberLogic = new MemberLogic();
	
	@Override
	public Object memberListPayment(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberListPayment 호출");
		
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		pMap.put("member_id", id);
		
		Object path = null;
		ModelAndView mav = new ModelAndView(req);
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			MemberVO mVO = memberLogic.Login(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
			mav.setViewName("mypage/orderpage"); 
			path = mav;
		}
		
		List<Map<String,Object>> orderList = null;
		orderList = memberLogic.memberListPayment(pMap);
		mav.addObject("orderList", orderList);
		
		return path;
	}

	@Override
	public Object memberListReview(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberListReview 호출");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		List<Map<String,Object>> memberListReview = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.Login(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
			memberListReview = memberLogic.memberListReview(id);
			mav.addObject("memberListReview", memberListReview);
			mav.setViewName("mypage/reviewpage"); 
			path = mav;
		}
		
		return path;
	}
	
	@Override
	public Object memberListP(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberListP 호출");

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.Login(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
			mav.setViewName("mypage/personalpage"); 
			path = mav;
		}
		
		return path;
	}
	
	@Override
	public Object memberListLike(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberListLike 호출");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		List<ProductVO> memberListLike = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.Login(id);
			mav.addObject("member", mVO);
			memberListLike = memberLogic.memberListLike(id);
			mav.addObject("memberListLike", memberListLike);
			mav.setViewName("mypage/likepage"); 
			path = mav;
		}
		
		return path;
	}


	@Override
	public Object memberListCoupon(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberListCoupon 호출");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		List<CouponVO> memberListCoupon = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.Login(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
			memberListCoupon = memberLogic.memberListCoupon(id);
			mav.addObject("memberListCoupon", memberListCoupon);
			mav.setViewName("mypage/couponpage");
			path = mav;
		}
		
		return path;
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
	/************************ [[ 회원정보 수정 ]] ************************/
	@Override
	public Object memberUpdateP(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberUpdateP 호출");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result = 0;
			result = memberLogic.memberUpdateP(pMap); 
			mav.setViewName("mypage/orderpage"); // 마이페이지의 메인(결제내역)으로 이동하게 한다.
			path = mav;
		}
		
		return path;
	}

	@Override
	public Object memberUpdateState(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberDelete(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberDelete 호출");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result = 0;
			result = memberLogic.memberDelete(pMap); 
			
			if(result == 1) { // 회원 삭제된 경우 
				session.invalidate(); // 세션 삭제 
				path = "product/productList.do"; // 메인페이지로 이동한다. 
			} else { // 회원탈퇴 실패한 경우 
				ModelAndView mav = new ModelAndView(req);
				mav.setViewName("mypage/orderpage");// 마이페이지의 메인으로 이동한다. 
				path = mav;
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

}
