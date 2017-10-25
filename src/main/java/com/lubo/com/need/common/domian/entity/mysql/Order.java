package com.lubo.com.need.common.domian.entity.mysql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单信息表
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "l_b_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	// 订单号
	@Id
	@Column(name = "o_id")
	private String id;

	// 订单号
	@Column(name = "o_sn")
	private String sn;


	// 订单生成时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "o_create_time")
	private Date createTime;

	// 订单结束时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "o_pay_time")
	private Date payTime;

	//用户id
	@ManyToOne
	@JoinColumn(name="u_id")
	private User user;
	
	//活动id
	@Column(name = "act_id")
	private String activityId;
	
	
	
}
