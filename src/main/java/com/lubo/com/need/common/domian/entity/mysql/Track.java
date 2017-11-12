package com.lubo.com.need.common.domian.entity.mysql;

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
@Entity
@Table(name = "l_b_track")
public class Track implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "t_id")
	private String id;

	// 轨迹
	@Lob
	@Column(name = "track")
	private String track;

	// 用户id
	@ManyToOne
	@JoinColumn(name = "u_id")
	private User user;
	

	// 提交时间
	@Column(name = "t_create_time")
	private long createTime;

	//跑步时间
	@Column(name="t_second")
	private long second;
	
	//总计步数
	@Column(name="t_setup")
	private long setup;
	
	//跑了多少米
	@Column(name="t_metre")
	private long metre;
	
	//缩略图地址
	@Column(name="t_thumbnail")
	private String thumbnailUrl;
}
