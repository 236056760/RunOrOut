package com.lubo.com.need.wexi.dao;


import com.lubo.com.need.common.dao.BaseRepository;
import com.lubo.com.need.common.domian.entity.mysql.Track;

public interface TrackDao extends BaseRepository<Track, String> {
	Track  findById(String id);
	
}
