package com.shopping.toyprj;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ModelAndView;

public interface Controller {
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String,Object> pMap);
	public String execute(HttpServletRequest req, HttpServletResponse res);	
	
	// 로그인
	public Object loginForm(HttpServletRequest req, HttpServletResponse res); 				// 로그인 페이지
	public Object login(HttpServletRequest req, HttpServletResponse res); 					// 로그인 요청
	public Object logout(HttpServletRequest req, HttpServletResponse res); 					// 로그아웃 요청
	
	// 상품
	public Object productList(HttpServletRequest req, HttpServletResponse res); 			// 전체 조회(메인페이지)
	public Object productDetail(HttpServletRequest req, HttpServletResponse res); 			// 상품상세 조회
	public Object productSearch(HttpServletRequest req, HttpServletResponse res); 			// 상품 검색
	public Object productInsertReview(HttpServletRequest req, HttpServletResponse res); 	// 리뷰 등록
	public Object productUpdateReview(HttpServletRequest req, HttpServletResponse res); 	// 리뷰 수정
	public Object productUpdateCount(HttpServletRequest req, HttpServletResponse res); 		// 사용자가 구매확정 시 구매횟수 증가
	public Object productInsertLike(HttpServletRequest req, HttpServletResponse res); 		// 좋아요 등록
	public Object productDeleteLike(HttpServletRequest req, HttpServletResponse res); 		// 좋아요 삭제
	
	// 회원가입
	public Object registerForm(HttpServletRequest req, HttpServletResponse res); 			// 회원가입 페이지
	public Object registerSelect(HttpServletRequest req, HttpServletResponse res); 			// id 중복검사
	public Object registerInsert(HttpServletRequest req, HttpServletResponse res); 			// 회원가입 요청
	
	// 멤버
	public Object memberListPayment(HttpServletRequest req, HttpServletResponse res); 		// 구매내역 조회
	public Object memberListLike(HttpServletRequest req, HttpServletResponse res);	 		// 좋아요 누른 상품 조회
	public Object memberListReview(HttpServletRequest req, HttpServletResponse res);  		// 구매후기 조회
	public Object memberListCoupon(HttpServletRequest req, HttpServletResponse res);  		// 보유쿠폰 조회
	public Object memberListP(HttpServletRequest req, HttpServletResponse res);		 		// 개인정보 조회
	public Object memberInsertCoupon(HttpServletRequest req, HttpServletResponse res);		// 쿠폰 입력		
	public Object memberInsertAddress(HttpServletRequest req, HttpServletResponse res); 	// 배송지 등록
	public Object memberUpdateP(HttpServletRequest req, HttpServletResponse res); 	 		// 개인정보 수정
	public Object memberUpdateState(HttpServletRequest req, HttpServletResponse res); 		// 구매상태(환불, 구매확정, 교환) 수정
	public Object memberDelete(HttpServletRequest req, HttpServletResponse res); 	 		// 회원 탈퇴
	
	// 주문
	public Object orderList(HttpServletRequest req, HttpServletResponse res);         		// 주문페이지 이동 (회원 및 비회원 분기처리)
	public Object orderInsert(HttpServletRequest req, HttpServletResponse res);		 		// 결제 정보 저장
	public Object orderUpdateCoupon(HttpServletRequest req, HttpServletResponse res); 		// 쿠폰 사용 내역
	public Object orderUpdatePoint(HttpServletRequest req, HttpServletResponse res);	 	// 적립금 차감  -- 미정.. 조인으로 쿠폰 & 적립금 업데이트 한번에 처리하기
	public Object orderDelete(HttpServletRequest req, HttpServletResponse res);		 		// 장바구니에서 주문한 상품 제거
	public Object orderUnmemberPage(HttpServletRequest req, HttpServletResponse res);		// 비회원 주문조회
	public Object orderUnmemberSelect(HttpServletRequest req, HttpServletResponse res);		// 비회원 구매상태 변경
	
	// 카트
	public Object cartList(HttpServletRequest req, HttpServletResponse res);	 			// 장바구니 페이지 조회
	public Object cartInsert(HttpServletRequest req, HttpServletResponse res); 				// 장바구니 상품추가
	public Object cartUpdate(HttpServletRequest req, HttpServletResponse res); 				// 장바구니 수정
	public Object cartDelete(HttpServletRequest req, HttpServletResponse res); 				// 장바구니 삭제
	
}