package com.dao;

import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Clazz;
import com.entity.Grade;
import com.entity.Student;


/**
 * Ñ§Éúdao
 * @author Congchong Fu
 *
 */
@Repository
public interface StudentDao {
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
