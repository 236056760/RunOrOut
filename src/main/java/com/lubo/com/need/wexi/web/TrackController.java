package com.lubo.com.need.wexi.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.lubo.com.need.common.domian.entity.mysql.Track;
import com.lubo.com.need.common.domian.entity.mysql.User;
import com.lubo.com.need.common.domian.vo.RequestParameter;
import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.common.tools.UUIDUtils;
import com.lubo.com.need.wexi.service.ActivityService;
import com.lubo.com.need.wexi.service.TrackService;

@RestController
@RequestMapping("/track")
public class TrackController {

	@Autowired
	private TrackService trackService;

	/**
	 * 保存跑步轨迹
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save")
	Result save(RequestParameter parameter) {

		User mUser = new User();
		mUser.setId(parameter.getUserId());
		Track mTrack = new Track();
		mTrack.setId(UUIDUtils.getUUID());
		mTrack.setCreateTime(System.currentTimeMillis());
		mTrack.setUser(mUser);
		mTrack.setTrack(parameter.getTrack());
		return trackService.saveTrack(mTrack);
	}

	/**
	 * 根据用户id获取用户的所以轨迹记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getTrackSetByUserId")
	Result getTrackSetByUserId(RequestParameter parameter) {

		return trackService.getTrackSetByUserId(parameter.getUserId());
	}
	
	/**
	 * 根据用户id获取用户的所以轨迹记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getTrackDetailById")
	Result getTrackDetailById(RequestParameter parameter) {

		return trackService.getTrackDetailById(parameter.getTrackId());
	}

}
