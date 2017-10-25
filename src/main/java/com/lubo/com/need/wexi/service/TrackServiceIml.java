package com.lubo.com.need.wexi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubo.com.need.common.domian.entity.mysql.Track;
import com.lubo.com.need.common.domian.entity.mysql.User;
import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.wexi.dao.TrackDao;
import com.lubo.com.need.wexi.dao.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrackServiceIml implements TrackService {

	@Autowired
	private TrackDao mTrackDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public Result saveTrack(Track track) {
		// TODO Auto-generated method stub
		try {
			if(null ==mTrackDao.save(track)) {
				return new Result(false);
			}else {
				return new Result(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false);
		}
	}

	@Override
	public Result getTrackSetByUserId(String userId) {
		// TODO Auto-generated method stub
		User mUser=userDao.findById(userId);
		return new Result(mUser.getTrackSet());
	}

	@Override
	public Result getTrackDetailById(String trackId) {
		// TODO Auto-generated method stub
		Track trackDetail=mTrackDao.findById(trackId);
		return new Result(trackDetail);
	}

}
