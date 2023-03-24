package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.Loginfo;

@Service
public interface LoginfoService {
	public int addLogInfo(Loginfo logi);
	 public List<Loginfo> getAllLog(Map<String,Object> queryMap);
	 public int getTotal(Map<String,Object> queryMap);
}
