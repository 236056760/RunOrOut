package com.lubo.com.need.wexi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.lubo.com.need.common.domian.entity.mysql.User;
import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.wexi.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 获取欢迎页面的图片
	 * 
	 * @return
	 */
	@RequestMapping(path = "/getSplashImge")
	Result getSplashImge(WebRequest webRequest) {
		return new Result("img/splash.png");
	}

	/**
	 * 获取验证码
	 * 
	 * @return
	 */
	// @RequestMapping(value = "/getCaptcha", produces =
	// "text/plain;charset=utf-8")
	@RequestMapping(value = "/getCaptcha")
	Result getCaptcha(WebRequest webRequest) {
		return new Result();
	}

	/**
	 * 手机号+验证码登陆
	 * 
	 * @param webRequest
	 * @param phoneNumber
	 * @return
	 */
	@RequestMapping(value = "/loginByCaptcha")
	Result loginByCaptcha(WebRequest webRequest, User user) {
		return new Result();
	}

	/**
	 * 微信登录
	 * 
	 * @param webRequest
	 * @param phoneNumber
	 * @param captcha
	 * @return
	 */
	@RequestMapping(value = "/loginByWx")
	Result loginByWx(WebRequest webRequest, String code) {
		return loginService.wxLogin(code);
	}

	/**
	 * 获取用户信息
	 * 
	 * @param webRequest
	 * @param phoneNumber
	 * @param captcha
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoById")
	Result getUserInfoById(WebRequest webRequest, String id) {
		return loginService.getUserInfoById(id);
	}
}
