package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AlarmDao;
import com.dao.LoginfoDao;
import com.entity.Loginfo;
import com.service.LoginfoService;
@Service
public class LoginfoServiceImpl implements LoginfoService {
	@Autowired
	private LoginfoDao loginfoDao;
	
	@Override
	public int addLogInfo(Loginfo logi)
	{
		return loginfoDao.addLogInfo(logi);
	}
	@Override
	 public List<Loginfo> getAllLog(Map<String,Object> queryMap)
	 {
		return loginfoDao.getAllLog(queryMap);
				
	 }
	@Override
	public int getTotal(Map<String,Object> queryMap)
	{
		return loginfoDao.getTotal(queryMap);
	}
}
