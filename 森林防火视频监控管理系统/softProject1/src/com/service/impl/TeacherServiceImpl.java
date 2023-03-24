package com.service.impl;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.Course;
import com.entity.Student;
import com.entity.Teacher;

import com.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService  {
	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public Teacher GetTNbyUID(String UID) {
		// TODO Auto-generated method stub
		return teacherDao.GetTNbyUID(UID);
	}
	@Override
	public List<Teacher> GetALLTeacher(Map<String,Object> queryMap)
	{
		return teacherDao.GetALLTeacher(queryMap);
	}
	@Override
	public int getTotal()
	{
		return teacherDao.getTotal();
	}
	@Override
	public int add(Teacher teacher)
	{
		return teacherDao.add(teacher);
	}
	@Override
	public Teacher GetALLTeacherByTID(String TID)
	{
		return teacherDao.GetALLTeacherByTID(TID);
	}
	@Override
	public int TeacherCourseNum(String TID)
	{
		return teacherDao.TeacherCourseNum(TID);
	}
	
	@Override
	public int updateTeacher(Teacher teacher)
	{
		return teacherDao.updateTeacher(teacher);
	}
	@Override
	public List<Course> getAllCoureseByTID(Map<String,Object> queryMap)
	{
		return teacherDao.getAllCoureseByTID(queryMap);
	}
	@Override
	public int getTotal(Map<String,Object> queryMap)
	{
		return teacherDao.getTotal(queryMap);
	}
}
