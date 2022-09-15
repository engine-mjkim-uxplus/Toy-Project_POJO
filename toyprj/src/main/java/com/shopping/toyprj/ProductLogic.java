package com.shopping.toyprj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.ProductDao;
import com.util.ModelAndView;
import com.vo.ProductVO;

public class ProductLogic {
	Logger logger = Logger.getLogger(ProductLogic.class);
	ProductDao productDao = new ProductDao();

	/*********************** 전체 상품페이지(홈페이지) 로직 ***********************/
	public List<ProductVO> productList() {
		logger.info("ProductLogic: productList 호출");
		List<ProductVO> productList;
		productList = productDao.productList();
		return productList;
	}
	
	/*********************** 디테일 상품페이지 로직 ***********************/
	public List<Map<String,Object>> productDetail(Map<String, Object> pMap) {
		logger.info("ProductLogic: productDetail 호출");
		
		/* 사용자가 선택한 상품의 정보 */
		List<Map<String,Object>> product = null;
		product = productDao.getProduct(pMap);
		
		/* 선택한 상품과 관련된 4건의 상품 정보 (기준:LIKE)*/
		List<Map<String,Object>> productList = null;
		productList = productDao.getRelatedProducts(pMap);
		
		/* 선택한 상품의 리뷰 목록 */
		List<Map<String,Object>> reviewList = null;
		reviewList = productDao.getReviewList(pMap);

		/* index -> 
		 * 0:[사용자가 선택한 상품] 
		 * 1~4:[관련 상품], 
		 * 5~X :[상품 리뷰]
		 */
		List<Map<String,Object>> resultList = new ArrayList<>();
		resultList.addAll(product);
		resultList.addAll(productList);
		resultList.addAll(reviewList);
		
		return resultList;
	}
	
	/*********************** 좋아요 추가 로직 ***********************/
	public int addLike(Map<String, Object> pMap) {
		logger.info("ProductLogic: addLike 호출");
		int result = 0;
		result = productDao.addLike(pMap);	
		return result;
	}
	
	/*********************** 좋아요 삭제 로직 ***********************/
	public int minusLike(Map<String, Object> pMap) {
		logger.info("ProductLogic: addLike 호출");
		int result = 0;
		result = productDao.minusLike(pMap);	
		return result;
	}
	
	/*********************** 회원 좋아요 리스트 로직 ***********************/
	public List<Integer> likeList(Map<String, Object> pMap) {
		List<Integer> likeList = null;
		likeList = productDao.likeList(pMap);
		return likeList;
	}
	
	/*********************** 상품 검색 로직(수정필요) ***********************/
	public List<ProductVO> productSearch(Map<String, Object> pMap) {
		logger.info("ProductLogic: productSearch 호출");
		List<ProductVO> productList = null;
		productList = productDao.productSearch(pMap);
		return productList;
	}

	/*********************** 상품 리뷰 추가 로직 ***********************/
	public void productInsertReview(Map<String, Object> pMap) {
		logger.info("ProductLogic: productInsertReview 호출");
		productDao.productInsertReview(pMap);
	}


}