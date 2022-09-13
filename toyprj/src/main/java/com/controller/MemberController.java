package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.shopping.toyprj.Controller;
import com.shopping.toyprj.MemberLogic;
import com.util.ModelAndView;
import com.vo.MemberVO;

public class MemberController implements Controller {
	Logger logger = Logger.getLogger(MemberController.class);
	MemberLogic memberLogic = new MemberLogic();
	
	@Override
	public Object memberListPayment(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberListPayment 호출");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.memberListPayment(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
			mav.setViewName("mypage/orderpage"); 
			path = mav;
		}
		
		return path;
	}

	@Override
	public Object memberListReview(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController: memberListReview 호출");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("mem_id");
		logger.info(id);
		
		Object path = null;
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.memberListPayment(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
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
			MemberVO mVO = memberLogic.memberListPayment(id);
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
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.memberListPayment(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
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
		
		if (id == null) {
			path = "login/loginForm.do";
		}else {
			ModelAndView mav = new ModelAndView(req);
			MemberVO mVO = memberLogic.memberListPayment(id);
			logger.info("ID :"+mVO.getMember_id()+", NAME: "+mVO.getMember_name());
			mav.addObject("member", mVO);
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
