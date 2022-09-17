package com.shopping.toyprj;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.MemberDao;
import com.vo.CartVO;
import com.vo.MemberVO;
import com.vo.ProductVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao memberdao = new MemberDao();
	
	public List<Map<String,Object>> memberListPayment() {
		List<Map<String,Object>> orderList = null;
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
		logger.info("MemberLogic: 카트 목록 불러오기");
		cartList = memberdao.getCartList(pMap);
		likeList = memberdao.getLikeList(pMap);
		pMap.put("cartList", cartList);
		if(cartList.size() > 0 && cartList != null) {
			logger.info("MemberLogic: 카트 삭제");
			memberdao.deleteCart(pMap);
		}
		if(likeList.size() > 0 && cartList != null) {
			logger.info("MemberLogic: 좋아요 삭제");
			memberdao.deleteLike(pMap);
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

	

}
