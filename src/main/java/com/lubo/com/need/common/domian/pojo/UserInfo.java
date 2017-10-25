package com.lubo.com.need.common.domian.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 微信用户信息
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	//用户id
	private String id;
	// 授权用户唯一标识
	private String openid;
	// 普遍用户呢称
	private String nickname;
	// 性别（1=男、2=女）
	private String sex;
	// 语言
	private String language;
	// 省份
	private String province;
	// 城市
	private String city;
	// 国家
	private String country;
	// 用户头像url
	private String headimgurl;
	// 用户特权信息
	private String[] privilege;
	// 用户统一标识
	private String unionid;
	// 错误码
	private String errcode;
	// 错误信息
	private String errmsg;

}
