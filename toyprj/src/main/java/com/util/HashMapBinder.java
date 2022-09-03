package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*
 * 텍스트 파일 처리(문자열 처리) - 숫자도 문자열 처리 - 숫자도 문자열로 처리 후 변경해서 
 * 사용자가 화면에 입력하는 값을 받아오기 위해서 공통 코드를 만듦
 * 오라클 테이블의 컬럼의 수가 50개이면 req.getParameter()를 50번 써야하는 것임
 */
public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	
	public HashMapBinder (HttpServletRequest req) {
		this.req = req;
	}
	// 사용자의 요청파라미터 값 처리 메서드
	public void bind(Map<String,Object> pMap) {
		pMap.clear(); // 초기화하고 사용
		// html화면에 정의된 input name값들을 모두 담아줌
		Enumeration<String> em = req.getParameterNames();
		while(em.hasMoreElements()) {
			// key값 꺼내기
			String key = em.nextElement(); // b_title, b_writer, b_content, b_pw등
			pMap.put(key, req.getParameter(key));
		}
		logger.info(pMap);
	}/////////// end of bind
}
