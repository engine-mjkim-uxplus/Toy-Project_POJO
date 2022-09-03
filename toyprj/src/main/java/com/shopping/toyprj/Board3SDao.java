package com.shopping.toyprj;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board3SDao {
	Logger logger = Logger.getLogger(Board3SDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public Board3SDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public int boardSInsert(Map<String, Object> pMap) {
		int result = 0;
		logger.info("boardSInsert 호출 성공");
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardSInsert", pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

