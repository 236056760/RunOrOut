package com.lubo.com.need.wexi.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import common.CommonTest;

public class LoginServiceTest extends CommonTest {

	@Autowired
	private LoginService loginService;

	@Test
	public void wxLoginTest() {
		String code = "011Den8c2xivCQ0xhK8c2qmv8c2Den8M";
		System.out.println(loginService.wxLogin(code));
	}

}
