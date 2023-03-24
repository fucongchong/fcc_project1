package com.dao;

import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Clazz;
import com.entity.Grade;
import com.entity.Student;
import com.entity.Teacher;


/**
 * Ñ§Éúdao
 * @author Congchong Fu
 *
 */
@Repository
public interface Teacher2Dao {
	//public List<Teacher2Pojo> getTeacherByCID(Map<String,Object> queryMap);
	//public int edit(Teacher2Pojo teacher2Pojo);
	//public int updateTeacherName(Teacher2Pojo teacher2Pojo);
	public int delete(String TID,String CID);
	public List<Teacher> findAll();
	//public int add(Teacher2Pojo teacher2Pojo);
}
