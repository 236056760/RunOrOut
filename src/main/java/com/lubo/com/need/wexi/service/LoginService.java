package com.lubo.com.need.wexi.service;

import com.lubo.com.need.common.domian.vo.Result;

/**
 * 登陆处理接口
 * 
 * @author Administrator
 *
 */
public interface LoginService {

	/**
	 * 微信登陆
	 * 
	 * @param code
	 * @return
	 */
	Result wxLogin(String code);

	/**
	 * 获取用户登陆的信息
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	Result getUserInfoById(String userId);

}
