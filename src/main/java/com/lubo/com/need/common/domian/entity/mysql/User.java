package com.lubo.com.need.common.domian.entity.mysql;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户信息表
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "l_b_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	// 用户标识
	@Id
	@Column(name = "u_id")
	private String id;

	// 用户名
	@Column(name = "name")
	private String userName;

	// 性别
	@Column(name = "sex")
	private int sex;

	// 邮件地址
	@Column(name = "email")
	private String email;

	// 手机号
	@Column(name = "phone")
	private String phone;

	// 头像
	@Column(name = "head_img")
	private String head;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "w_id")
	private WeixinInfo weixinInfo;

	@JsonIgnore
	@ManyToMany(mappedBy = "userSet")
	private Set<Act> actSet = Sets.newHashSet();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private Set<Order> orderSet=Sets.newHashSet();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private Set<Track> trackSet=Sets.newHashSet();
	
	
	
	

}
