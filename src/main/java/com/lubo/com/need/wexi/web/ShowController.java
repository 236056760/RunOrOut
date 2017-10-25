package com.lubo.com.need.wexi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.wexi.service.ActivityService;

@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private ActivityService activityService;

	/**
	 * 获取最新的show
	 * 
	 * @return
	 */
	@RequestMapping("/getLatesShow")
	String getLatesShow() {

		return "";
	}
	
	/**
	 * 获取最新的show
	 * 
	 * @return
	 */
	@RequestMapping("/getDetailByShowId")
	String getDetailByShowId() {

		return "";
	}

	
}
