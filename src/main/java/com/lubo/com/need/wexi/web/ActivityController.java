package com.lubo.com.need.wexi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.wexi.service.ActivityService;

@RestController
@RequestMapping("/act")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	/**
	 * 报名活动
	 * 
	 * @return
	 */
	@RequestMapping("/signUpActivity")
	String signUpActivity() {

		return "";
	}

	/**
	 * 获取订单信息
	 * 
	 * @param userId
	 * @param webRequest
	 * @return
	 */
	@RequestMapping("/getOrder")
	String getOrder(String userId, WebRequest webRequest) {
		return "";
	}

	@RequestMapping("/getAllActivity")
	Result getAllActivity(String userId, WebRequest webRequest) {
		return activityService.getAllActivities();
	}
}
