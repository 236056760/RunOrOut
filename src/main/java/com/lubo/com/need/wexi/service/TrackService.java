package com.lubo.com.need.wexi.service;

import com.lubo.com.need.common.domian.entity.mysql.Track;
import com.lubo.com.need.common.domian.vo.Result;

/**
 * 跑步轨迹处理接口
 * 
 * @author Administrator
 *
 */
public interface TrackService {
	
	/**
	 * 保存轨迹
	 * @param track
	 * @return
	 */
	Result saveTrack(Track track);
	
	/**
	 * 获取用户的所有轨迹
	 * @param userId
	 * @return
	 */
	Result getTrackSetByUserId(String userId);

	/**
	 * 根据轨迹id获取轨迹详情
	 * @param trackId
	 * @return
	 */
	Result getTrackDetailById(String trackId);
	

}
