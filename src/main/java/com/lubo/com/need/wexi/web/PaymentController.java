package com.lubo.com.need.wexi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.lubo.com.need.common.domian.vo.Result;

@RestController
@RequestMapping("/pay")
public class PaymentController {

	/**
	 * 支付
	 * @return
	 */
	@RequestMapping("/payByOrderId")
	Result payByOrderId(WebRequest webRequest){
		return new Result();
	}
	
	/**
	 * 获取订单信息
	 * @param userId
	 * @param webRequest
	 * @return
	 */
	@RequestMapping("/getOrder")
	String getOrder(String userId,WebRequest webRequest){
		return "";
	}
}
