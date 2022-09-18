package com.shopping.toyprj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.OrderDao;
import com.vo.CouponVO;

public class OrderLogic {
	Logger logger = Logger.getLogger(OrderLogic.class);
	OrderDao orderDao = new OrderDao();
	
	/****************** 멤버 쿠폰 조회(MemberLogig으로 옮겨야함)******************/
	public List<CouponVO> memberCoupon(String mem_id, Map<String,Object> rMap) {
		logger.info("OrderLogic => memberCoupon 호출");
		rMap.clear();
		
		List<CouponVO> couponList = null; 
		int isCoupon = 0; 
		
		// 멤버의 쿠폰 존재여부(0: 없음, 1: 존재)
		isCoupon = orderDao.searchIsCoupon(mem_id);
		
		// 쿠폰이 존재할 경우 쿠폰 정보 가져오기
		if(isCoupon > 0) {
			logger.info("쿠폰이 존재함");
			couponList = orderDao.getCouponList(mem_id);
			rMap.put("result", 1);
		} else {  
			logger.info("쿠폰이 존재하지 않음");
			couponList = new ArrayList();
			rMap.put("result", 0);
		} 
		return couponList; 
	}
	
	/****************** 주문 결제******************/
	public void memOrder(Map<String, Object> pMap) {
		logger.info("OrderLogic => memOrderInsert 호출");
		
		int result = 0;
		// 1. shopping_order update
		result = orderDao.orderMinsert(pMap);
		// 2. cart 에서 제거
		result = 0;
		result = orderDao.cartMdelete(pMap);
		// 3. 쿠폰을 사용 하였거나 point를 사용 하였다면 Update
		
		int coupon = (Integer)pMap.get("coupon");
		int point = (Integer)pMap.get("point");
		
		if(coupon > 0 || point > 0) {
			result = 0;
			result = orderDao.orderMupdate(pMap);
			result = 0;
			result = orderDao.couponDelete(pMap);
		}
	
	}
}
