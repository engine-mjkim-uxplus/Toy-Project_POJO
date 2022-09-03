package com.shopping.toyprj;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ModelAndView;

public interface Controller {
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String,Object> pMap);
	public String execute(HttpServletRequest req, HttpServletResponse res);	
	// 로그인
	public Object loginForm(HttpServletRequest req); 				// 로그인 페이지
	public Object login(HttpServletRequest req); 					// 로그인 요청
	// 상품
	public Object productList(HttpServletRequest req); 				// 전체 조회(메인페이지)
	public Object productDetail(HttpServletRequest req); 			// 상품상세 조회
	public Object productSearch(HttpServletRequest req); 			// 상품 검색
	public Object productInsertReview(HttpServletRequest req); 		// 리뷰 등록
	public Object productUpdateReview(HttpServletRequest req); 		// 리뷰 수정
	public Object productUpdateCount(HttpServletRequest req); 		// 사용자가 구매확정 시 구매횟수 증가
	public Object productInsertLike(HttpServletRequest req); 		// 좋아요 등록
	public Object productDeleteLike(HttpServletRequest req); 		// 좋아요 삭제
	// 회원가입
	public Object registerForm(HttpServletRequest req); 			// 회원가입 페이지
	public Object registerSelect(HttpServletRequest req); 			// id 중복검사
	public Object registerInsert(HttpServletRequest req); 			// 회원가입 요청
	
	// 멤버
	public Object memberListPayment(HttpServletRequest req); 		// 구매내역 조회
	public Object memberListLike(HttpServletRequest req);	 		// 좋아요 누른 상품 조회
	public Object memberListReview(HttpServletRequest req);  		// 구매후기 조회
	public Object memberListCoupon(HttpServletRequest req);  		// 보유쿠폰 조회
	public Object memberListP(HttpServletRequest req);		 		// 개인정보 조회
	public Object memberInsertCoupon(HttpServletRequest req);		// 쿠폰 입력		
	public Object memberInsertAddress(HttpServletRequest req); 		// 배송지 등록
	public Object memberUpdateP(HttpServletRequest req); 	 		// 개인정보 수정
	public Object memberUpdateState(HttpServletRequest req); 		// 구매상태(환불, 구매확정, 교환) 수정
	public Object memberDelete(HttpServletRequest req); 	 		// 회원 탈퇴
	// 주문
	public Object orderList(HttpServletRequest req);         		// 주문페이지 이동 (회원 및 비회원 분기처리)
	public Object orderInsert(HttpServletRequest req);		 		// 결제 정보 저장
	public Object orderUpdateCoupon(HttpServletRequest req); 		// 쿠폰 사용 내역
	public Object orderUpdatePoint(HttpServletRequest req);	 		// 적립금 차감  -- 미정.. 조인으로 쿠폰 & 적립금 업데이트 한번에 처리하기
	public Object orderDelete(HttpServletRequest req);		 		// 장바구니에서 주문한 상품 제거
	// 카트
	public Object cartList(HttpServletRequest req);	 			 	// 장바구니 페이지 조회
	public Object cartInsert(HttpServletRequest req); 				// 장바구니 상품추가
	public Object cartUpdate(HttpServletRequest req); 				// 장바구니 수정
	public Object cartDelete(HttpServletRequest req); 				// 장바구니 삭제
	
}