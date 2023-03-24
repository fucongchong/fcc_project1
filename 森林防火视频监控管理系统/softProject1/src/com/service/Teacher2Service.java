package com.service;

import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.Student;
import com.entity.Teacher;


/**
 * Ñ§Éúservice
 * @author Congchong Fu
 *
 */
@Service
public interface Teacher2Service {
	//public List<Teacher2Pojo> getTeacherByCID(Map<String,Object> queryMap);
	//public int edit(Teacher2Pojo teacher2Pojo);
	//public int updateTeacherName(Teacher2Pojo teacher2Pojo);
	public int delete(String TID,String CID);
	public List<Teacher> findAll();
	//public int add(Teacher2Pojo teacher2Pojo);
}
