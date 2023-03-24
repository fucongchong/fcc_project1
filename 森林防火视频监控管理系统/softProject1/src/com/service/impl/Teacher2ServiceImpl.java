package com.service.impl;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.dao.Teacher2Dao;
import com.entity.Student;
import com.entity.Teacher;

import com.service.StudentService;
import com.service.Teacher2Service;
@Service
public class Teacher2ServiceImpl implements Teacher2Service {

	@Autowired
	private Teacher2Dao teacher2Dao;
	
	
	
	
	@Override
	public int delete(String TID,String CID)
	{
		return teacher2Dao.delete(TID, CID);
	}
	@Override
	public List<Teacher> findAll()
	{
		return teacher2Dao.findAll();
	}
	
}
