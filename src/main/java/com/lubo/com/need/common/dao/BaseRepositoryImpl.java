package com.lubo.com.need.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends
		SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	private final EntityManager em;

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public int getCountByHql(final String hql,
			final Map<String, Object> parameters) {
		Query query = em.createQuery(hql);
		if (parameters != null && !parameters.isEmpty()) {
			for (Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey().toString(), entry.getValue());
			}
		}
		Long count = (Long) query.getSingleResult();
		return count.intValue();
	}

	@Override
	public List<T> findByJPQL(final String jpql) {
		return findByJPQL(jpql, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByJPQL(final String jpql,
			final Map<String, Object> parameters) {
		Query query = em.createQuery(jpql);
		if (parameters != null && !parameters.isEmpty()) {
			for (Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey().toString(), entry.getValue());
			}
		}
		return query.getResultList();
	}

	@Override
	public void save(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			this.save(list.get(i));
			if (i % 100 == 0) {
				this.em.flush();
				this.em.clear();
			}
		}
	}

}
