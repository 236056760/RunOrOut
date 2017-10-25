package com.lubo.com.need.wexi.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lubo.com.need.common.domian.entity.mysql.Act;
import com.lubo.com.need.common.domian.vo.Result;
import com.lubo.com.need.common.tools.UUIDUtils;

import common.CommonTest;

public class ActServiceTest extends CommonTest {

	@Autowired
	private ActivityService actService;

	@Test
	public void saveActTest() {
		Act act = new Act();
		act.setId(UUIDUtils.getUUID());
		act.setDay(30);
		act.setKm(5);
		act.setStatus(0);
		act.setBegin(new Date());
		act.setEnd(new Date());
		act.setApplication_fee(1.99);
		act.setImg(
				"https://gss0.bdstatic.com/5bVWsj_p_tVS5dKfpU_Y_D3/res/r/image/2017-09-27/297f5edb1e984613083a2d3cc0c5bb36.png");
		act.setActivityWeb("https://www.baidu.com");
		actService.saveAct(act);
	}

	@Test
	public void getAllActivitiesTest() {
		Result result = actService.getAllActivities();
		List<Act> actSet = (List<Act>) result.getData();
		actSet.forEach(item -> {
			System.out.println(item);
		});
	}

}
