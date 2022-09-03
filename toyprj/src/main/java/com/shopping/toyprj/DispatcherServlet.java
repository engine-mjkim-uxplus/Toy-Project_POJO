package com.shopping.toyprj;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.util.ModelAndView;
// .do로 끝나는 모든것을 DispatcherServlet이 처리
public class DispatcherServlet extends HttpServlet{
	Logger logger = Logger.getLogger(DispatcherServlet.class);
	private void doService(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		logger.info("doservice 호출 성공");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length()+1); 
		int end = command.indexOf("."); 
		command = command.substring(0, end); 
		String upmu[] = null; 
		upmu = command.split("/"); 
		logger.info(upmu[0]+","+upmu[1]);
		Object obj = null;
		try {
			obj = HandlerMapping.getController(upmu,req);		
		} catch (Exception e) {
			logger.info("Exception :" + e.toString()); 
		}
		if(obj != null) {
			String pageMove[] = null;
			ModelAndView mav = null;
			if(obj instanceof String) {
				if(((String)obj).contains(":")) {
					logger.info(":콜론이 포함되어 있어요");
					pageMove = obj.toString().split(":");
				}else {
					logger.info(":콜론이 포함되어 있지않아요");
					pageMove = obj.toString().split("/");
				}
				logger.info("pageMove==>" + pageMove[0]+ "," + pageMove[1]);
			} // end of String
			// Model(데이터-안 List있다)과 View의 혼합
			else if(obj instanceof ModelAndView) {
				mav = (ModelAndView) obj;
				pageMove = new String[2];
				pageMove[0] = "forward";
				pageMove[1] = mav.getViewName(); // board3/boardList
				logger.info("pageMove===>" + pageMove[0] +","+pageMove[1]);
			}
			
			if(pageMove != null) { // forward:board/boardList
				String path = pageMove[1]; // board/boardList담김
				if("redirect".equals(pageMove[0])) { // 너 select 아니야?
					res.sendRedirect(path);
				}else if("forward".equals(pageMove[0])) { // 난 유지하게 해줄래
					RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp"); // /board3/boardList.jsp
					// URL 입력은 boar3/boardList.pj이지만 실제 경로는 board3/boardList.jsp로 이동한다(URL 변경되지 않음)
					view.forward(req, res);
					
				}
				// Board2Controller에 리턴값이 return "board2:boardList"일 때
				else{ // redirect나 forward문자열이 없는 경우라면? 
					path = pageMove[0]+"/"+pageMove[1];
					RequestDispatcher view = 
								req.getRequestDispatcher("/WEB-INF/jsp/"+path+".jsp"); 
					view.forward(req, res);
				}
			}// end of 출력페이지 호출 URL패턴 조립하기
		} ///// end of 컨트롤 계층 리턴결과
	} ///////// end of doService
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet 호출 성공");
		doService(req, res);
	}


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doPost 호출 성공");
		doService(req, res);
	}
}
