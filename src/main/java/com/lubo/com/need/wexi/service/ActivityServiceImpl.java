package com.lubo.com.need.wexi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubo.com.need.common.domian.entity.mysql.Act;
import com.lubo.com.need.common.domian.entity.mysql.User;
import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.wexi.dao.ActDao;
import com.lubo.com.need.wexi.dao.UserDao;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActDao actDao;
	@Autowired
	private UserDao userDao;

	@Override
	public Result saveAct(Act act) {
		actDao.save(act);
		return new Result();
	}

	@Override
	public Result getAllActivities() {
		return new Result(actDao.findAll());
	}

	@Override
	public Result getUserActivities(String userId) {
		User user = userDao.findById(userId);
		return new Result(user.getActSet());
	}

}
