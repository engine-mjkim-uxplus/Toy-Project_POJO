package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.shopping.toyprj.MemberLogic;
import com.util.MyBatisCommonFactory;
import com.vo.CartVO;
import com.vo.MemberVO;
import com.vo.ProductReviewVO;
import com.vo.ProductVO;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberLogic.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;

	public MemberDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public List<Map<String,Object>> memberListPayment(Map<String,Object> pMap) {
		logger.info("MemberDao: memberListPayment 호출 성공");
		List<Map<String,Object>> orderList = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			orderList = sqlSession.selectList("getOrderList", pMap); 	
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		
		return orderList;
	}

	public int memberUpdateP(Map<String, Object> pMap) {
		logger.info("MemberDao: memberUpdateP 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("memberUpdateP",pMap);
			sqlSession.commit();
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public int memberDelete(Map<String, Object> pMap) {
		logger.info("MemberDao: memberDelete 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("memberDelete",pMap);
			sqlSession.commit();
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public List<CartVO> getCartList(Map<String, Object> pMap) {
		logger.info("MemberDao: getCartList 호출 성공");
		List<CartVO> cartList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			cartList = sqlSession.selectList("getCart",pMap);
			logger.info(cartList);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return cartList;
	}

	public int deleteCart(Map<String, Object> pMap) {
		logger.info("MemberDao: deleteCart 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("delCart",pMap);
			sqlSession.commit();
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public List<ProductVO> getLikeList(Map<String, Object> pMap) {
		logger.info("MemberDao: getLikeList 호출 성공");
		List<ProductVO> likeList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			likeList = sqlSession.selectList("getLike",pMap);
			logger.info(likeList);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return likeList;
	}

	public int deleteLike(Map<String, Object> pMap) {
		logger.info("MemberDao: deleteLike 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("delLike",pMap);
			sqlSession.commit();
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public List<ProductVO> getMemberListLike(String id) {
		logger.info("MemberDao: getMemberListLike 호출 성공");
		List<ProductVO> likeList = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			likeList = sqlSession.selectList("memberListLike",id);
			logger.info(id+", "+likeList);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return likeList;
	}


	public MemberVO login(String id) {
		MemberVO mVO = null;
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("id", id);
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			mVO = sqlSession.selectOne("getMember",pMap); //ProductVO			
			// insert here
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		
		return mVO;
	}

	public List<Map<String, Object>> memberListReview(String id) {
		logger.info("MemberDao: memberListReview 호출 성공");
		List<Map<String, Object>> memberListReview = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			memberListReview = sqlSession.selectList("memberListReview",id);
			logger.info(id+", "+memberListReview);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return memberListReview;

	}

	public int memberUpdateState(Map<String, Object> pMap) {
		logger.info("MemberDao: memberUpdateState 호출 성공");
		
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("UpdateState",pMap);
			sqlSession.commit();
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}

}
