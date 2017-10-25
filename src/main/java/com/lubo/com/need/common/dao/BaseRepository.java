package com.lubo.com.need.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends
		JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

	int getCountByHql(String hql, Map<String, Object> parameters);

	/**
	 * 
	 * @author liangyuyang
	 * @date 2015年9月17日下午9:05:56
	 * @description 批量保存
	 * @param list
	 *            批量对象
	 */
	void save(List<T> list);

	/**
	 * 
	 * @author liangyuyang
	 * @date 2015年11月25日下午9:44:16
	 * @description 根据传入的jpql查询,无参数
	 * @param jpql
	 *            jpql语句
	 * @return 查询结果集
	 */
	List<T> findByJPQL(String jpql);

	/**
	 * 
	 * @author liangyuyang
	 * @date 2015年11月25日下午9:44:16
	 * @description 根据传入的jpql查询
	 * @param jpql
	 *            jpql语句
	 * @param parameters
	 *            参数
	 * @return 查询结果集
	 */
	List<T> findByJPQL(String hql, Map<String, Object> parameters);

}
