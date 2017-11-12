package com.lubo.com.need.common.domian.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lubo.com.need.common.domian.entity.mysql.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 轨迹表
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrackVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;


	// 提交时间
	private long createTime;

	//跑步时间
	private long second;
	
	//总计步数
	private long setup;
	
	//跑了多少米
	private long metre;
	
	//缩略图地址
	private String thumbnailUrl;
}
