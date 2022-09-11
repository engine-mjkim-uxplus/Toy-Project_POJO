package com.shopping.toyprj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.CartDao;
import com.vo.CartVO;

public class CartLogic {
	Logger logger = Logger.getLogger(CartLogic.class);
	CartDao cartDao = new CartDao();
	
	public List<CartVO> cartList(String mem_id) {
		logger.info("CartLogic ===> cartList 호출");
		List<CartVO> cartList = new ArrayList<>();
		cartList = cartDao.getCartList(mem_id);
		return cartList;
	}

	public int cartUpdate(Map<String, Object> pMap) {
		logger.info("CartLogic ===> cartUpdate 호출");
		int result = 0;
		result = cartDao.cartUpdate(pMap);
		return result;
	}

	public int cartDelete(Map<String, Object> pMap) {
		logger.info("CartLogic ===> cartDelete 호출");
		int result = 0;
		result = cartDao.cartDelete(pMap);
		return result;
	}

	public String cartSearch(Map<String, Object> pMap) {
		logger.info("CartLogic ===> cartSearch 호출");
		String result = null;
		result = cartDao.cartSearch(pMap);
		return result;
	}

	public int cartInsert(Map<String, Object> pMap) {
		logger.info("CartLogic ===> cartInsert 호출");
		int result = 0;
		result = cartDao.cartInsert(pMap);
		return result;
	}
	
	
}
