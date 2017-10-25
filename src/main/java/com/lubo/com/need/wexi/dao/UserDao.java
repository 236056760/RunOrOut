package com.lubo.com.need.wexi.dao;

import com.lubo.com.need.common.dao.BaseRepository;
import com.lubo.com.need.common.domian.entity.mysql.User;

public interface UserDao extends BaseRepository<User, String> {

	User findById(String id);
	
}
