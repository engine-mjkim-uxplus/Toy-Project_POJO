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
public class DispatcherServlet extends HttpServlet {
	Logger logger = Logger.getLogger(DispatcherServlet.class);

	private void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doservice 호출 성공");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		int end = command.indexOf(".");
		command = command.substring(0, end);
		String upmu[] = null;
		upmu = command.split("/");
		logger.info(upmu[0] + "," + upmu[1]);
		Object obj = null;
		try {
			obj = HandlerMapping.getController(upmu, req, res);
		} catch (Exception e) {
			logger.info("Exception :" + e.toString());
		}
		if (obj != null) {
			String path = null;
			ModelAndView mav = null;
			// ModelAndView forward			
			if (obj instanceof ModelAndView) {
				mav = (ModelAndView) obj;
				path = mav.getViewName(); // login/loginForm
				logger.info("path===>" + path);
				// WEB-INF 밑에 접근하려면 포워드로만 가능
				RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp");
				view.forward(req, res);
			}
			// String이면 무조건 리다이렉트			
			else if (obj instanceof String) {
				logger.info("String page===>" + path);
				path = (String)obj;
				res.sendRedirect("/" + path + ".do"); // /login/loginForm.do
			}
		} // end of 출력페이지 호출 URL패턴 조립하기
	} ///// end of 컨트롤 계층 리턴결과
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
