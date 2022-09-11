package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	// cart 페이지 조회
	public List<CartVO> getCartList(String mem_id) {
		logger.info("CartDao ===> getCartList 호출 성공");
		logger.info("사용자 id는 " + mem_id);
		List<CartVO> cartList = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			cartList = sqlSession.selectList("getCartList", mem_id);
			logger.info("조회된 cartList " + cartList);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		
		return cartList;
	}
	// cart 상품 수량 변경(Update)
	public int cartUpdate(Map<String, Object> pMap) {
		logger.info("CartDao ===> cartUpdate 호출 성공");
		int result = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("cartUpdate", pMap);
			logger.info("수량변경 결과 " + result);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			logger.info("cart 업데이트 결과 " + result);
			
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	// cart 상품 삭제(Delete)
	public int cartDelete(Map<String, Object> pMap) {
		logger.info("CartDao ===> cartDelete 호출 성공");
		int result = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("cartDelete", pMap);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			sqlSession.rollback();
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	// 장바구니 담기
	public int cartInsert(Map<String, Object> pMap) {
		logger.info("CartDao ===> cartInsert 호출 성공");
		String select = null;
		int result =0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			select = sqlSession.selectOne("cartSearch", pMap);
			if (select == null) {
				result = sqlSession.update("cart");
			} else {
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			sqlSession.rollback();
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return null;
	}

}
