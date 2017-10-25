package com.lubo.com.need.common.domian.entity.mysql;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 活动表
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "l_b_act")
public class Act implements Serializable {
	private static final long serialVersionUID = 1L;

	// 活动标识
	@Id
	@Column(name = "a_id")
	private String id;

	// 任务天数
	@Column(name = "day")
	private int day;

	// 每天多少公里
	@Column(name = "km")
	private int km;

	// 任务状态
	@Column(name = "status")
	private int status;

	// 开始日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "begin")
	private Date begin;

	// 结束日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "end")
	private Date end;

	// 参加人数
	@Column(name = "member")
	private int member;

	// 报名费
	@Column(name = "application_fee")
	private double application_fee;

	// 奖金
	@Column(name = "bonus")
	private double bonus;

	// 活动海报
	@Column(name = "img")
	private String img;

	// 失败人数
	@Column(name = "loser_count")
	private int loserCount;

	// 活动网页url
	@Column(name = "activity_web")
	private String activityWeb;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "l_b_act_user", joinColumns = { @JoinColumn(name = "a_id") }, inverseJoinColumns = {
			@JoinColumn(name = "u_id") })
	private Set<User> userSet = Sets.newHashSet();

}
