package com.shopping.toyprj;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.MemberDao;
import com.vo.CartVO;
import com.vo.CouponVO;
import com.vo.MemberVO;
import com.vo.ProductReviewVO;
import com.vo.ProductVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao memberdao = new MemberDao();
	
	public List<Map<String,Object>> memberListPayment(Map<String,Object> pMap) {
		List<Map<String,Object>> orderList = null;
		orderList = memberdao.memberListPayment(pMap);
		return orderList;
	}

	public int memberUpdateP(Map<String, Object> pMap) {
		logger.info("MemberLogic: memberUpdateP 호출");
		int result = 0;
		result = memberdao.memberUpdateP(pMap);
		return result;
	}

	public int memberDelete(Map<String, Object> pMap) {
		logger.info("MemberLogic: memberDelete 호출");
		int result = 0;
		List<CartVO> cartList = new ArrayList<>();
		List<ProductVO> likeList = new ArrayList<>();
		List<ProductReviewVO> reviewList = new ArrayList<>();
		List<Map<String,Object>> couponList = null;
		logger.info("MemberLogic: 카트 목록 불러오기");
		cartList = memberdao.getCartList(pMap);
		likeList = memberdao.getLikeList(pMap);
		reviewList = memberdao.getReviewList(pMap);
		couponList = memberdao.getCouponList(pMap);
		pMap.put("cartList", cartList);
		pMap.put("likeList", likeList);
		pMap.put("reviewList", reviewList);
		pMap.put("couponList", couponList);
		if(cartList.size() > 0 && cartList != null) {
			logger.info("MemberLogic: 카트 삭제");
			memberdao.deleteCart(pMap);
		}
		if(likeList.size() > 0 && cartList != null) {
			logger.info("MemberLogic: 좋아요 삭제");
			memberdao.deleteLike(pMap);
		}
		if(reviewList.size() > 0 && reviewList != null) {
			logger.info("MemberLogic: 리뷰 삭제");
			memberdao.deleteReview(pMap);
		}
		if(couponList.size() > 0 && couponList != null) {
			logger.info("MemberLogic: 쿠폰 삭제");
			memberdao.deleteCoupon(pMap);
		}
		result = memberdao.memberDelete(pMap);
		return result;
	}

	public List<ProductVO> memberListLike(String id) {
		logger.info("MemberLogic: memberListLike 호출");
		List<ProductVO> likeList = new ArrayList<>();
		likeList = memberdao.getMemberListLike(id);
		return likeList;
	}


	public MemberVO Login(String id) {
		logger.info("MemberLogic: memberListPayment 호출");
		MemberVO mVO = memberdao.login(id);
		return mVO;
	}

	public List<Map<String, Object>> memberListReview(String id) {
		logger.info("MemberLogic: memberListReview 호출");
		List<Map<String, Object>> memberListReview = new ArrayList<>();
		memberListReview = memberdao.memberListReview(id);
		return memberListReview;

	}


	public int memberUpdateState(Map<String, Object> pMap) {
		logger.info("MemberLogic: memberUpdateState 호출");
		int result = 0;
		result = memberdao.memberUpdateState(pMap);
		
		if (pMap.get("state").equals("buy") ) {
			logger.info("구매확정 선택");
			memberdao.pointUpdate(pMap);
		}
		
		return result;
	}

	public List<CouponVO> memberListCoupon(String id) {
		logger.info("MemberLogic: memberListCoupon 호출");
		List<CouponVO> memberListCoupon = new ArrayList<>();
		memberListCoupon = memberdao.memberListCoupon(id);
		return memberListCoupon;

	}


}
