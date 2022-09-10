package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.CartVO;

public class CartDao {
	Logger logger = Logger.getLogger(CartDao.class);
	
	SqlSessionFactory sqlSessionFactory = null;
	
	SqlSession sqlSession = null;
	
	public CartDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public List<CartVO> getCartList(String mem_id) {
		List<CartVO> result = null;
		logger.info("CartDao ===> getCartList 호출 성공");
		logger.info("사용자 id는 " + mem_id);
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectList("getCartList", mem_id);
			logger.info("조회된 cartList " + result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		
		return result;
	}

}
