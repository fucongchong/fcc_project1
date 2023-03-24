package com.service.impl;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.dao.TopicDao;
import com.entity.Student;
import com.entity.Topic;
import com.po.StuTopic;
import com.po.TopicPo;

import com.service.StudentService;
import com.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicDao topicDao;
	
	@Override
	public List<Topic> getTopicByCID(Map<String,Object> queryMap)
	{
		return topicDao.getTopicByCID(queryMap);
	}
	@Override
	public List<Student> getStudentByTopicID(String TopicID)
	{
		return topicDao.getStudentByTopicID(TopicID);
	}
	@Override
	public int add(TopicPo topicPo)
	{
		return topicDao.add(topicPo);
	}
	
	@Override
	public String getTIDByTN(String TN)
	{
		return topicDao.getTIDByTN(TN);
	}
	@Override
	public List<Topic> ChoosedTopic(Map<String,Object> queryMap)
	{
		return topicDao.ChoosedTopic(queryMap);
	}
	@Override
	public String getStuTopicID(String SNo,String TopicID)
	{
		return topicDao.getStuTopicID(SNo, TopicID);
	}
	@Override
	public int addTopicPaper(Map<String,Object> queryMap)
	{
		return topicDao.addTopicPaper(queryMap);
	}
	@Override
	public int insertStuTopic(StuTopic stuTopic)
	{
		return topicDao.insertStuTopic(stuTopic);
	}
}
