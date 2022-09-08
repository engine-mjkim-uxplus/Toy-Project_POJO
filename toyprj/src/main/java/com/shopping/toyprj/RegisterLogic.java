package com.shopping.toyprj;

import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.RegisterDao;

public class RegisterLogic {
	Logger logger = Logger.getLogger(RegisterLogic.class);
	RegisterDao registerDao = new RegisterDao();
	
	public int registerInsert(Map<String, Object> pMap) {
		logger.info("Logic의 registerInsert호출 성공");
		int result = 0;
		result = registerDao.registerInsert(pMap);
		return result;
	}
}
