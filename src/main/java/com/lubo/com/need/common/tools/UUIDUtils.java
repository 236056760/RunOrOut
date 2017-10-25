package com.lubo.com.need.common.tools;

import java.util.Map;
import java.util.UUID;

import com.google.common.collect.Maps;

public class UUIDUtils {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String newUUID = "";
		for (String part : uuid.toString().split(FinalQuantity.DIVIDE12)) {
			newUUID += part;
		}
		return newUUID;
	}

	public static String getOrderIdByUUId() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);
	}

	/**
	 * 获取6位验证码
	 * 
	 * @return
	 */
	public static int getCaptcha() {
		int number = 0;
		String currMilli = String.valueOf(System.currentTimeMillis());
		number = (int) (Math.random() * Integer.valueOf(currMilli.substring(currMilli.length() - 6)));
		return number;
	}

	public static void main(String[] args) {
		Map<String, Integer> map = Maps.newHashMap();
		for (int i = 0; i < 1000000; i++) {
			String captcha = String.valueOf(UUIDUtils.getCaptcha());
			if (map.containsKey(captcha)) {
				map.put(captcha, map.get(captcha) + 1);
			}else{
				map.put(captcha, 1);
			}
		}
		System.out.println(map.size());
	}

}
