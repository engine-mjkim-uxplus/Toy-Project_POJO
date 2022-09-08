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
		result = productDao.addLike(pMap);
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
}
