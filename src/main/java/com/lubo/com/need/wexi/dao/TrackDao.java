package com.lubo.com.need.wexi.dao;



import java.util.Set;

import com.lubo.com.need.common.dao.BaseRepository;
import com.lubo.com.need.common.domian.entity.mysql.Track;
import com.lubo.com.need.common.domian.entity.mysql.User;

public interface TrackDao extends BaseRepository<Track, String> {
	Track  findById(String id);
	Set<Track>  findByUser(String u);
}
