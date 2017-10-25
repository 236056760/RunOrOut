package com.lubo.com.need.common.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author liangyuyang
 * @date 2014年5月5日上午9:09:57
 * @description 提示信息类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int code = 200;
	private String message = "ok";
	private Object data;

	public Result(Object data) {
		this.data = data;
	}

}
