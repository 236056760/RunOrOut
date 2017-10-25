package com.lubo.com.need.wexi.service;

import com.lubo.com.need.common.domian.entity.mysql.Order;
import com.lubo.com.need.common.domian.vo.Result;

/**
 * 订单处理接口
 * 
 * @author Administrator
 *
 */
public interface OrderService {
	
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	Result saveOrder(Order order);

	/**
	 * 获取所有活动
	 * 
	 * @return
	 */
	Result getAllOrders();

	/**
	 * 获取用户生成的订单
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	Result getUserOrders(String userId);

}
