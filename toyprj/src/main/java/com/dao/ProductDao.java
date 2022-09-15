package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

import com.vo.ProductVO;

public class ProductDao {
	Logger logger = Logger.getLogger(ProductDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	
	public ProductDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	/*********************** 전체 상품페이지(홈페이지) 쿼리 ***********************/
	public List<ProductVO> productList() {
		logger.info("ProductDao : productList 호출 성공");
		
		List<ProductVO> productList = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			productList = sqlSession.selectList("productList");
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return productList;
	}
	
	/*********************** 디테일 상품페이지 쿼리 ***********************/
	public List<Map<String,Object>> getProduct(Map<String,Object> pMap) {
		logger.info("ProductDao: product 호출 성공");
		List<Map<String,Object>> productList = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			productList = sqlSession.selectList("getProduct",pMap); //ProductVO			
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return productList;
	}
	
	public List<Map<String,Object>> getRelatedProducts(Map<String,Object> pMap) {
		logger.info("ProductDao: getRelatedProducts 호출 성공");

		List<Map<String,Object>> productList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			productList = sqlSession.selectList("getRelatedProducts",pMap); //List<ProductVO>
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return productList;
	}
	
	public List<Map<String, Object>> getReviewList(Map<String, Object> pMap) {
		logger.info("ProductDao: getReviewList 호출");
		List<Map<String,Object>> reviewList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			reviewList = sqlSession.selectList("getReviewList",pMap); //List<ProductVO>
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return reviewList;
	}
	
	public int addLike(Map<String,Object> pMap) {
		logger.info("ProductDao : addLike 호출 성공");
		
		int result = 0;
		int result2 = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("likeUpdate", pMap);
			result2 = sqlSession.update("MemberLikeUpdate",pMap);
			if (result == 1 && result2 == 1) {
				sqlSession.commit();
			}
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public int minusLike(Map<String,Object> pMap) {
		logger.info("ProductDao : addLike 호출 성공");
		
		int result = 0;
		int result2 = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("likeDelete", pMap);
			result2 = sqlSession.delete("MemberLikeDelete",pMap);
			
			if (result == 1 && result2 == 1) {
				sqlSession.commit();
			}
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
	


	public List<ProductVO> productSearch(Map<String, Object> pMap) {
		logger.info("ProductDao: productSearch 호출 성공");

		List<ProductVO> productList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			productList = sqlSession.selectList("Searchproduct",pMap); //List<ProductVO>
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return productList;
	}

	public void productInsertReview(Map<String, Object> pMap) {
		logger.info("ProductDao: productInsertReview 호출 성공");
		int insert = 0;
		int update = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			insert = sqlSession.insert("InsertReview",pMap);
			update = sqlSession.update("InsertReviewCount",pMap);
			
			if (insert == 1 && update == 1 ) {
				sqlSession.commit();
			}
			
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
	}


	public List<Integer> likeList(Map<String, Object> pMap) {
		logger.info("ProductDao: likeList 호출");
		logger.info("ProductDao: "+pMap.toString());
		List<Integer> likeList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			likeList = sqlSession.selectList("likeList",pMap);
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return likeList;
	}

}
