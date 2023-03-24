package com.service;

import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.Student;
import com.entity.Topic;
import com.po.StuTopic;
import com.po.TopicPo;


/**
 * Ñ§Éúservice
 * @author Congchong Fu
 *
 */
@Service
public interface TopicService {
	public List<Topic> getTopicByCID(Map<String,Object> queryMap);
	public List<Topic> ChoosedTopic(Map<String,Object> queryMap);
	public List<Student> getStudentByTopicID(String TopicID);
	public int add(TopicPo topicPo);
	//public int addPaper(UploadPaperPojo uplp);
	public String getTIDByTN(String TN);
	public String getStuTopicID(String SNo,String TopicID);
	public int addTopicPaper(Map<String,Object> queryMap);
	public int insertStuTopic(StuTopic stuTopic);
}
