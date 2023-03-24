package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Loginfo;

@Repository
public interface LoginfoDao {
     public int addLogInfo(Loginfo logi);
     public List<Loginfo> getAllLog(Map<String,Object> queryMap);
     public int getTotal(Map<String,Object> queryMap);
}
