package com.service;

import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.Student;


/**
 * Ñ§Éúservice
 * @author Congchong Fu
 *
 */
@Service
public interface StudentService {
	public List<Student> getStudentByCID(Map<String,Object> queryMap);
	//public List<StuTopicPojo> getStuTopicBySNO(String SNo);
	public int stuTopicNumber(String SNo);
	public List<String> getTopicPaperNum(String SNo);
	//public List<PaperPojo> getDetailedPaperInfo(String TopicID,String SNo);
	public int add(Student student);
	public int updateSC(String CID,String SNo);
	public int edit(Student student);
	public int delete(String ids);
	public int deleteSC(String ids);
	public Student GetSNbyUID(String SNo);
}
