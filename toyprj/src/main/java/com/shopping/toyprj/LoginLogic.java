package com.shopping.toyprj;

import java.util.Map;

import org.apache.log4j.Logger;
import com.dao.LoginDao;

public class LoginLogic {
	Logger logger = Logger.getLogger(LoginLogic.class);
	LoginDao loginDao = new LoginDao();
	public Object login(Map<String, Object> pMap){
		logger.info("login 호출 성공");
		String mem_id = null;
		mem_id = loginDao.getId(pMap);
		return mem_id; 
	}
	
	
	
}
