package com.lubo.com.need.common.domian.entity.mysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 广告信息实体类
 * 
 * @author Administrator
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "l_b_ads")
public class Ads implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "a_id")
	private Integer id;

	// 广告地址
	@Column(name = "url")
	private String url;
}
