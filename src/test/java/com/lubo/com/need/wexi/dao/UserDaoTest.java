package com.lubo.com.need.wexi.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lubo.com.need.common.domian.entity.mysql.User;
import com.lubo.com.need.common.tools.UUIDUtils;

import common.CommonTest;

public class UserDaoTest extends CommonTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void saveTest() {
		User user = new User();
		user.setId(UUIDUtils.getUUID());
		user.setEmail("liangfanyang@163.com");
		user.setSex(1);
		user.setPhone("12345678901");
//		userDao.save(user);
		System.out.println("adfadsf");
	}

}
