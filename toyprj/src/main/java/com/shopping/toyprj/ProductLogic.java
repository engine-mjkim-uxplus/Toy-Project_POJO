package com.shopping.toyprj;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.ProductDao;
import com.vo.ProductVO;

public class ProductLogic {
	Logger logger = Logger.getLogger(ProductLogic.class);
	ProductDao productDao = new ProductDao();

	public List<ProductVO> productList() {
		logger.info("ProductLogic: productList 호출");
		List<ProductVO> productList;
		productList = productDao.productList();
		return productList;
	}
	
	public int addLike(Map<String, Object> pMap) {
		logger.info("ProductLogic: addLike 호출");
		int result = 0;
		
		Map<String,Object> likeList = null;
		likeList = productDao.likeList(pMap);
		
		if (likeList == null) {
			result = productDao.addLike(pMap);
			logger.info("ProductLogic: 좋아요 추가 성공");
		} else {
			logger.info("ProductLogic: 좋아요 추가 실패");
		}
			
		return result;
	}
	
	public ProductVO product(Map<String,Object> pMap) {
		logger.info("ProductLogic: product 호출");
		ProductVO product;
		product = productDao.product(pMap);
		return product;
	}

	public List<ProductVO> getRelatedProducts(Map<String,Object> pMap) {
		logger.info("ProductLogic: getRelatedProducts 호출");
		List<ProductVO> productList = null;
		productList = productDao.getRelatedProducts(pMap);
		return productList;
	}

	public List<ProductVO> productSearch(Map<String, Object> pMap) {
		logger.info("ProductLogic: productSearch 호출");
		List<ProductVO> productList = null;
		productList = productDao.productSearch(pMap);
		return productList;
	}

	public void productInsertReview(Map<String, Object> pMap) {
		logger.info("ProductLogic: productInsertReview 호출");
		productDao.productInsertReview(pMap);
	}

	public List<Map<String, Object>> getReviewList(Map<String, Object> pMap) {
		logger.info("ProductLogic: getReviewList 호출");
		List<Map<String,Object>> reviewList = null;
		reviewList = productDao.getReviewList(pMap);
		return reviewList;
	}
}
