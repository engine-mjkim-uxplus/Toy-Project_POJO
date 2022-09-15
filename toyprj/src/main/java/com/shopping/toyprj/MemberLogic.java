package com.shopping.toyprj;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.MemberDao;
import com.vo.MemberVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao memberdao = new MemberDao();
	
	public MemberVO memberListPayment(String id) {
		logger.info("MemberLogic: memberListPayment 호출");
		MemberVO mVO = memberdao.memberListPayment(id);
		return mVO;
	}

	public int memberUpdateP(Map<String, Object> pMap) {
		logger.info("MemberLogic: memberUpdateP 호출");
		int result = 0;
		result = memberdao.memberUpdateP(pMap);
		return result;
	}

	public int memberDelete(Map<String, Object> pMap) {
		logger.info("MemberLogic: memberDelete 호출");
		int result = 0;
		result = memberdao.memberDelete(pMap);
		return result;
	}

	

}
