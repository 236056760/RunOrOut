package com.lubo.com.need.wexi.dao;

import com.lubo.com.need.common.dao.BaseRepository;
import com.lubo.com.need.common.domian.entity.mysql.WeixinInfo;

public interface WeixinInfoDao extends BaseRepository<WeixinInfo, String> {

	WeixinInfo getByOpenid(String openid);

}
