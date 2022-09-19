package com.dao;

import java.util.List;
import java.util.Map;

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
	/************************ 결제 후 회원 주문 테이블 등록***********************/
	public int orderMinsert(Map<String, Object> pMap) {
		logger.info("OrderDao ===> orderMinsert 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			logger.info(pMap.get("productList"));
			result = sqlSession.insert("orderMinsert", pMap);
			logger.info("Insert 결과 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	/************************ 결제 후 결제상품 장바구니 삭제 ***********************/
	public int cartMdelete(Map<String, Object> pMap) {
		logger.info("OrderDao ===> orderMdelete 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("cartMdelete", pMap);
			logger.info("delete 결과 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	/************************ 결제 후 회원 쿠폰 / 포인트 사용시 업데이트 ***********************/
	public int orderMupdate(Map<String, Object> pMap) {
		logger.info("OrderDao ===> orderMupdate 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("orderMupdate", pMap);
			logger.info("update 결과 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	/************************ 쿠폰 사용시 사용한 쿠폰 coupon_zip에서 삭제 ***********************/
	public int couponDelete(Map<String, Object> pMap) {
		logger.info("OrderDao ===> couponDelete 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("couponDelete", pMap);
			logger.info("couponDelete 결과 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	/************************** 결제후 비회원 주문 테이블 등록***************************/
	public int orderInsert(Map<String, Object> pMap) {
		logger.info("OrderDao ===> orderInsert 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			logger.info(pMap.get("productList"));
			result = sqlSession.insert("orderInsert", pMap);
			logger.info("Insert 결과 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
}

