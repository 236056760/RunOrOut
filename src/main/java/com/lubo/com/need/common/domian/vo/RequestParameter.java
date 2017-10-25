package com.lubo.com.need.common.domian.vo;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestParameter implements Serializable{

	private String userId;
	
	private String track;
	
	private String code;
	
	private String trackId;
}
