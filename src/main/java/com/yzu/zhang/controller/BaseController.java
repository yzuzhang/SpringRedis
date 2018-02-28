package com.yzu.zhang.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	public static final String SUCCESS = "success";
	public static final String MESSAGE = "message";
	
	protected ModelAndView toView(final String url, final Map<String, Object> map) {
		ModelAndView view = new ModelAndView(url);
		view.addObject("map", map);
		return view;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView runtimeException(RuntimeException re){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("message", re.getMessage());
		return toView("member/message", map);
	}
}