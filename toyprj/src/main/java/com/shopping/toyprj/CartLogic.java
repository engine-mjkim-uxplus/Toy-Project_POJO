package com.shopping.toyprj;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.CartDao;
import com.vo.CartVO;

public class CartLogic {
	Logger logger = Logger.getLogger(CartLogic.class);
	CartDao cartDao = new CartDao();
	
	public List<CartVO> cartList(String mem_id) {
		logger.info("CartLogic ===> cartList 호출 성공");
		List<CartVO> cartList = new ArrayList<>();
		cartList = cartDao.getCartList(mem_id);
		return cartList;
	}
}
