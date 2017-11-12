package com.lubo.com.need.wexi.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
		User u=new User();
		u.setId(userId);
		
		return new Result(mTrackDao.findByJPQL("select new com.lubo.com.need.common.domian.vo.TrackVo(t.id,t.createTime,t.second,t.setup,t.metre,t.thumbnailUrl) from Track t where t.user=\'"+userId+"\'"));
	}

	@Override
	public Result getTrackDetailById(String trackId) {
		// TODO Auto-generated method stub
		Track trackDetail=mTrackDao.findById(trackId);
		return new Result(trackDetail);
	}

}
