package com.lubo.com.need.wexi.service;

import com.lubo.com.need.common.domian.entity.mysql.Act;
import com.lubo.com.need.common.domian.vo.Result;

/**
 * 活动处理接口
 * 
 * @author Administrator
 *
 */
public interface ActivityService {
	
	Result saveAct(Act act);

	/**
	 * 获取所有活动
	 * 
	 * @return
	 */
	Result getAllActivities();

	/**
	 * 获取用户报名的活动
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	Result getUserActivities(String userId);

}
