package com.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.shopping.toyprj.MemberLogic;
import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;
import com.vo.ProductVO;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberLogic.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;

	public MemberDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public MemberVO memberListPayment(String id) {
		logger.info("MemberDao: memberListPayment 호출 성공");
		MemberVO mVO = null;
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("id", id);
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			mVO = sqlSession.selectOne("getMember",pMap); //ProductVO			
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		
		return mVO;
	}

}
