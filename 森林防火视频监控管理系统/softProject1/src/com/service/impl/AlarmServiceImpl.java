package com.service.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AlarmDao;

import com.entity.AlarmInfo;
import com.pojo.AffirmAlarmPojo;
import com.pojo.updateAlarmPojo;
import com.service.AlarmService;
@Service
public class AlarmServiceImpl implements AlarmService {
	@Autowired
	private AlarmDao alarmDao;
	
	@Override
	public List<AlarmInfo> findList(Map<String,Object> queryMap)
	{
		return alarmDao.findList(queryMap);
	}
	@Override
	public int getTotal(Map<String,Object> queryMap)
	{
		return alarmDao.getTotal(queryMap);
	}
	@Override
	public int add(AlarmInfo alarmInfo)
	{
		return alarmDao.add(alarmInfo);
	}
	@Override
	public List<AffirmAlarmPojo> getAllAlarmMovie(Map<String,Object> queryMap)
	{
		return alarmDao.getAllAlarmMovie(queryMap);				
	}
	@Override
	public List<String> getPIDArray(int mid)
	{
		return alarmDao.getPIDArray(mid);
	}
	@Override
	public int updateAlarmByAid(updateAlarmPojo udpojo)
	{
		return alarmDao.updateAlarmByAid(udpojo);
	}
}
