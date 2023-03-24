package com.service.impl;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.entity.Student;

import com.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> getStudentByCID(Map<String,Object> queryMap)
	{
		return studentDao.getStudentByCID(queryMap);
	}
	
	@Override
	public int stuTopicNumber(String SNo)
	{
		return studentDao.stuTopicNumber(SNo);
	}

	@Override
	public List<String> getTopicPaperNum(String SNo)
	{
		return studentDao.getTopicPaperNum(SNo);
	}
	
	
	@Override
	public int add(Student student)
	{
		return studentDao.add(student);
	}
	@Override
	public int updateSC(String CID,String SNo)
	{
		return studentDao.updateSC(CID, SNo);
	}
	@Override
	public int edit(Student student)
	{
		return studentDao.edit(student);
	}
	@Override
	public int delete(String ids)
	{
		return studentDao.delete(ids);
	}
	@Override
	public int deleteSC(String ids)
	{
		return studentDao.deleteSC(ids);
	}
	@Override
	public Student GetSNbyUID(String SNo)
	{
		return studentDao.GetSNbyUID(SNo);
	}
}
