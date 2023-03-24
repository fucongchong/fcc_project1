package com.dao;

import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.entity.Teacher;


@Repository
public interface TeacherDao {
	public Teacher GetTNbyUID(String UID);
	public List<Teacher> GetALLTeacher(Map<String,Object> queryMap);
	public int getTotal();
	public int add(Teacher teacher);
	public Teacher GetALLTeacherByTID(String TID);
	public int TeacherCourseNum(String TID);
	//public List<CourseTeacherPojo> AllTCInfo(String TID);
	public int updateTeacher(Teacher teacher);
	public List<Course> getAllCoureseByTID(Map<String,Object> queryMap);
	public int getTotal(Map<String,Object> queryMap);
}
