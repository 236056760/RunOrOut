package com.lubo.com.need.common.domian.entity.mysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户微信信息表
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "l_b_wx")
public class WeixinInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	// 主键
	@Id
	@Column(name = "w_id")
	private String id;

	// 微信openid
	@Column(name = "openid")
	private String openid;

	// 微信access_token
	private String refreshToken;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="u_id")
	private User user;

}
