package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.AlarmInfo;
import com.pojo.AffirmAlarmPojo;
import com.pojo.updateAlarmPojo;

@Service
public interface AlarmService {
	public List<AlarmInfo> findList(Map<String,Object> queryMap);
	public int getTotal(Map<String,Object> queryMap);
	public int add(AlarmInfo alarmInfo);
	public List<AffirmAlarmPojo> getAllAlarmMovie(Map<String,Object> queryMap);
	public List<String> getPIDArray(int mid);
	public int updateAlarmByAid(updateAlarmPojo udpojo);
}
