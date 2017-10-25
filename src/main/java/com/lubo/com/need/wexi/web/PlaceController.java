package com.lubo.com.need.wexi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.wexi.service.ActivityService;

@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	private ActivityService activityService;

	/**
	 * 获取附近的跑场
	 * 
	 * @return
	 */
	@RequestMapping("/getNearbyPlaces")
	String getNearbyPlaces() {

		return "";
	}
	
	
	/**
	 * 根据跑场Id获取跑场详情
	 * 
	 * @return
	 */
	@RequestMapping("/getDetailByPlaceId")
	String getDetailByPlaceId() {

		return "";
	}
	
}
