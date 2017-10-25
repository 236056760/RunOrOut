package com.lubo.com.need.common.domian.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccessTokenInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 接口调用凭证
	private String access_token;
	// access_token接口调用凭证超时时间，单位（秒）
	private String expires_in;
	// 用户刷新access_token
	private String refresh_token;
	// 授权用户唯一标识
	private String openid;
	// 用户授权的作用域，使用逗号（,）分隔
	private String scope;
	// 当且仅当该移动应用已获得该用户的userinfo授权时，才会出现该字段
	private String unionid;
	// 错误码
	private String errcode;
	// 错误信息
	private String errmsg;

}
