package com.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class RegisterDao {
	Logger logger = Logger.getLogger(RegisterDao.class);
	// 물리적인 DB서버와 연결
	SqlSessionFactory sqlSessionFactory = null;
	// 쿼리문 요청과 커밋 그리고 롤백 처리
	SqlSession sqlSession = null;

	public RegisterDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}

	public int registerInsert(Map<String, Object> pMap) {
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("registerInsert",pMap);
			sqlSession.commit();
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("회원가입DAO Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public int registerSelect(Map<String, Object> pMap) {
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("registerSelect", pMap);
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("중복체크DAO Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}

}
