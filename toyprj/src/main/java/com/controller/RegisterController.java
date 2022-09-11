package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.shopping.toyprj.Controller;
import com.shopping.toyprj.RegisterLogic;
import com.util.HashMapBinder;
import com.util.ModelAndView;

public class RegisterController implements Controller {
	Logger logger = Logger.getLogger(RegisterController.class);
	RegisterLogic registerLogic = new RegisterLogic();
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
		logger.info("registerForm 호출 성공");
		ModelAndView mav = new ModelAndView(req);
		mav.setViewName("register");
		return mav;
	}

	@Override
	public Object registerSelect(HttpServletRequest req, HttpServletResponse res) {
		logger.info("Controller의 registerSelect 호출 성공");
		Object _return = null;
		int result = 0;
		String path = null;
		ModelAndView mav = new ModelAndView();
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		result = registerLogic.registerSelect(pMap);
		if(result == 0) { // 사용가능한 id일 경우
			mav.setViewName("register");
			_return = mav;
		} else if(result == 1) { // 중복된 id일 경우
			path = "register/registerSelect";
		}
		return _return;
	}

	@Override
	public Object registerInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("Controller의 registerInsert 호출 성공");
		int result = 0;
		String path = null;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		result = registerLogic.registerInsert(pMap); 
		logger.info("컨트롤러의 result: " +result);
		if(result == 1) { // 회원가입 성공하면 Insert
			path = "login/loginForm";
		} else { 
			path = "register/registerForm";
		}
		return path;
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

}
