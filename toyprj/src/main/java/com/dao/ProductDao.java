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
	
	public List<ProductVO> productList() {
		logger.info("ProductDao: productList 호출 성공");
		
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
	
	public int addLike(Map<String,Object> pMap) {
		logger.info("ProductDao: addLike 호출 성공");
		
		int result = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("likeUpdate", pMap);
			if (result == 1) {
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

	public ProductVO product(Map<String,Object> pMap) {
		logger.info("ProductDao: product 호출 성공");
		ProductVO product = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			product = sqlSession.selectOne("getProduct",pMap); //ProductVO			
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return product;
	}
	
	public List<ProductVO> getRelatedProducts(Map<String,Object> pMap) {
		logger.info("ProductDao: getRelatedProducts 호출 성공");

		List<ProductVO> productList = null;
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

}
