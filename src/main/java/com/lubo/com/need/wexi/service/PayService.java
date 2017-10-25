package com.lubo.com.need.wexi.service;

import com.lubo.com.need.common.domian.entity.mysql.Order;

/**
 * 支付业务接口
 * 
 * @author Administrator
 *
 */
public interface PayService {

	/**
	 * 统一下单
	 * 
	 * @return
	 */
	String unifiedOrder(Order order);

}
