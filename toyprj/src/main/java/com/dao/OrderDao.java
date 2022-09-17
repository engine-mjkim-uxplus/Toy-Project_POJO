package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.CouponVO;

public class OrderDao {
	Logger logger = Logger.getLogger(OrderDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	
	SqlSession sqlSession = null;
	/************************** 쿠폰 존재여부 확인 *****************************/
	public OrderDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public int searchIsCoupon(String mem_id) {
		logger.info("OrderDao ===> searchIsCoupon 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("searchIsCoupon", mem_id);
			logger.info("쿠폰 존재 여부 : " + result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	/************************보유쿠폰 정보 가져오기 ***********************/
	public List<CouponVO> getCouponList(String mem_id) {
		logger.info("OrderDao ===> getCouponList 호출");
		List<CouponVO> couponList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			couponList = sqlSession.selectList("getCouponList", mem_id);
			logger.info("조회된 couponList " + couponList);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		
		return couponList;
	}

}
