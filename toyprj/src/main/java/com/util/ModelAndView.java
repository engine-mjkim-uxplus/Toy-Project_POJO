package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class ModelAndView {
	Logger logger  = Logger.getLogger(ModelAndView.class);
	HttpServletRequest req = null;

	private String viewName = null;
	List<Map<String,Object>> reqList = new ArrayList<>();

	public ModelAndView() {}

	public ModelAndView(HttpServletRequest req) {
		this.req = req;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getViewName() {
		return viewName;
	}
	public void addObject(String name, Object obj) {
		logger.info(name+","+obj);
		Map<String,Object> pMap = new HashMap<>();
		pMap.put(name, obj);

		req.setAttribute(name, obj);
		reqList.add(pMap);
	}
}
