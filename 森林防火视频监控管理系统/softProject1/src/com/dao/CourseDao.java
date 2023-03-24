package com.dao;

import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.entity.Grade;


@Repository
public interface CourseDao {
	public List<Course> findList(Map<String,Object> queryMap);
	public List<Course> findList2(Map<String,Object> queryMap);
	public List<Course> findList3(Map<String,Object> queryMap);
	public List<Course> findListByStudent(Map<String,Object> queryMap);
	public int getTotal(Map<String,Object> queryMap);
	public int add(Course course);
	public Course getAllCourse(String CID);
	public int getTeacherNum(String CID);
	//public List<CourseTeacherPojo> getAllCourseTeacInfo(String CID);
	public int updateCourse(Course course);
	public List<Course> getAllCourse2();
}
