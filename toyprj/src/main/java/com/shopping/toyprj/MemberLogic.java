package com.shopping.toyprj;
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
	

}
