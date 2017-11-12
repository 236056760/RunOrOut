package com.lubo.com.need.wexi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lubo.com.need.common.domian.vo.Result;

@RestController
@RequestMapping("/splash")
public class SplashController {

	@RequestMapping("/getSplashImg")
	Result getSplashImg() {
		return new Result("core/welcome.jpg");
	}
}
