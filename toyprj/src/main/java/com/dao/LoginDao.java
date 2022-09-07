package com.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mybatis.mapper.MyBatisCommonFactory;

public class LoginDao {
	Logger logger = Logger.getLogger(LoginDao.class);
	// 물리적인 DB서버와 연결
	SqlSessionFactory sqlSessionFactory = null;
	// 쿼리문 요청과 커밋 그리고 롤백 처리
	SqlSession sqlSession = null;

	public LoginDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	// 쿼리문의 아이디와 메소드 이름은 통일함
	public String getId(Map<String, Object> pMap) {
		String result = null;
		logger.info("LoginDao ===> getId 호출 성공");
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("getId", pMap);
			logger.info("조회된 사용자 id는 " + result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
		
		
	}
	
}
