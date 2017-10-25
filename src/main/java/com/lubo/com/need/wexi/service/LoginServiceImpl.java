package com.lubo.com.need.wexi.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.lubo.com.need.common.domian.entity.mysql.User;
import com.lubo.com.need.common.domian.entity.mysql.WeixinInfo;
import com.lubo.com.need.common.domian.pojo.AccessTokenInfo;
import com.lubo.com.need.common.domian.pojo.UserInfo;
import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.common.tools.FinalQuantity;
import com.lubo.com.need.common.tools.HttpUtils;
import com.lubo.com.need.common.tools.JsonUtils;
import com.lubo.com.need.common.tools.UUIDUtils;
import com.lubo.com.need.wexi.dao.UserDao;
import com.lubo.com.need.wexi.dao.WeixinInfoDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private WeixinInfoDao weixinInfoDao;

	@Override
	public Result wxLogin(String code) {
		Result result = new Result();
		AccessTokenInfo accessTokenInfo = this.getAccessToken(code);
		String accessToken = accessTokenInfo.getAccess_token(), openid = accessTokenInfo.getOpenid(),
				refreshToken = accessTokenInfo.getRefresh_token();
		accessTokenInfo = this.verifyAccessToken(accessToken, openid);
		if (!FinalQuantity._40003.equals(accessTokenInfo.getErrcode())) {
			UserInfo userInfo = this.getUserInfo(accessToken, openid);
			log.info("微信用户信息"+userInfo);
			// 根据openid查找对应的用户id
			User user = this.register(openid, refreshToken, userInfo);
			userInfo.setId(user.getId());
			result.setData(userInfo);
		} else {
			result.setCode(Integer.valueOf(accessTokenInfo.getErrcode()));
			result.setMessage(accessTokenInfo.getErrmsg());
		}
		return result;
	}

	@Override
	public Result getUserInfoById(String userId) {
		Result result = new Result();
		User user = userDao.findById(userId);
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setSex(String.valueOf(user.getSex()));
		userInfo.setHeadimgurl(user.getHead());
		userInfo.setNickname(user.getUserName());
		result.setData(userInfo);
		return result;
	}

	/**
	 * 通过code获取access_token
	 * 
	 * @param code
	 *            用于获取令牌号的code
	 * @return
	 */
	private AccessTokenInfo getAccessToken(String code) {
		AccessTokenInfo accessTokenInfo = new AccessTokenInfo();
		try {
			Map<String, String> params = Maps.newHashMap();
			params.put("appid", FinalQuantity.APPID);
			params.put("secret", FinalQuantity.APPSECRET);
			params.put("code", code);
			params.put("grant_type", "authorization_code");
			String result = HttpUtils.okhttpGet(FinalQuantity.ACCESS_TOKEN_URL, params);
			accessTokenInfo = JsonUtils.JsonToObject(result, accessTokenInfo);
		} catch (Exception e) {
			log.error("", e);
		}
		return accessTokenInfo;
	}

	/**
	 * 刷新或续期access_token使用
	 * 
	 * @param refreshToken
	 * @return
	 */
	private AccessTokenInfo refreshToken(String refreshToken) {
		AccessTokenInfo accessTokenInfo = new AccessTokenInfo();
		try {
			Map<String, String> params = Maps.newHashMap();
			params.put("appid", FinalQuantity.APPID);
			params.put("grant_type", "refresh_token");
			params.put("refresh_token", refreshToken);
			String result = HttpUtils.okhttpGet(FinalQuantity.REFRESH_TOKEN_URL, params);
			accessTokenInfo = JsonUtils.JsonToObject(result, accessTokenInfo);
		} catch (Exception e) {
			log.error("", e);
		}
		return accessTokenInfo;
	}

	/**
	 * 验证access_token
	 * 
	 * @param accessToken
	 * @param openid
	 * @return
	 */
	private AccessTokenInfo verifyAccessToken(String accessToken, String openid) {
		AccessTokenInfo accessTokenInfo = new AccessTokenInfo();
		try {
			Map<String, String> params = Maps.newHashMap();
			params.put("access_token", accessToken);
			params.put("openid", openid);
			String result = HttpUtils.okhttpGet(FinalQuantity.VERIFY_TOKEN_URL, params);
			accessTokenInfo = JsonUtils.JsonToObject(result, accessTokenInfo);
		} catch (Exception e) {
			log.error("", e);
		}
		return accessTokenInfo;
	}

	/**
	 * 获取微信用户信息
	 * 
	 * @param accessToken
	 * @param openid
	 * @return
	 */
	private UserInfo getUserInfo(String accessToken, String openid) {
		UserInfo userInfo = new UserInfo();
		try {
			Map<String, String> params = Maps.newHashMap();
			params.put("access_token", accessToken);
			params.put("openid", openid);
			params.put("lang", "zh_CN");
			String result = HttpUtils.okhttpGet(FinalQuantity.USERINFO_URL, params);
			userInfo = JsonUtils.JsonToObject(result, userInfo);
		} catch (Exception e) {
			log.error("", e);
		}
		return userInfo;
	}

	/**
	 * 注册用户
	 * 
	 * @param openid
	 * @param refreshToken
	 * @return
	 */
	private User register(String openid, String refreshToken,UserInfo userInfo) {
		User user = this.getUserByOpenid(openid);
		if (user == null) {
			user = new User();
			user.setId(UUIDUtils.getUUID());
			WeixinInfo weixinInfo = new WeixinInfo();
			weixinInfo.setId(UUIDUtils.getUUID());
			weixinInfo.setOpenid(openid);
			weixinInfo.setRefreshToken(refreshToken);
			user.setWeixinInfo(weixinInfo);
		}
		user.setHead(userInfo.getHeadimgurl());
		user.setSex(Integer.valueOf(userInfo.getSex()));
		user.setUserName(userInfo.getNickname());
		user = userDao.save(user);
		return user;
	}

	/**
	 * 根据openid查找用户信息
	 * 
	 * @param openid
	 * @return
	 */
	private User getUserByOpenid(String openid) {
		User user = null;
		WeixinInfo weixinInfo = weixinInfoDao.getByOpenid(openid);
		if (weixinInfo != null) {
			user = weixinInfo.getUser();
			if (user == null) {
				user = new User();
				user.setId(UUIDUtils.getUUID());
				user.setWeixinInfo(weixinInfo);
				user = userDao.save(user);
			}
		}
		return user;
	}

}
