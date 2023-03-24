package com.service.impl;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CourseDao;
import com.entity.Clazz;
import com.entity.Course;
import com.entity.Grade;

import com.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	@Override
	public List<Course> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return courseDao.findList(queryMap);
	}
	@Override
	public List<Course> findList2(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return courseDao.findList2(queryMap);
	}
	@Override
	public List<Course> findList3(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return courseDao.findList3(queryMap);
	}
	@Override
	public List<Course> findListByStudent(Map<String,Object> queryMap)
	{
		return courseDao.findListByStudent(queryMap);
	}
	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return courseDao.getTotal(queryMap);
	}
	@Override
	public int add(Course course) {
		// TODO Auto-generated method stub
		return courseDao.add(course);
	}
	@Override
	public Course getAllCourse(String CID) {
		// TODO Auto-generated method stub
		return courseDao.getAllCourse(CID);
	}
	@Override
	public int getTeacherNum(String CID) {
		// TODO Auto-generated method stub
		return courseDao.getTeacherNum(CID);
	}
	
	@Override
	public int updateCourse(Course course)
	{
		return courseDao.updateCourse(course);
	}
	@Override
	public List<Course> getAllCourse2()
	{
		return courseDao.getAllCourse2();
	}
	
}
