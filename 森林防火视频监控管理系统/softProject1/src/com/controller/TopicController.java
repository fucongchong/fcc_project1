package com.controller;

import java.io.File;





import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Clazz;
import com.entity.Course;
import com.entity.Grade;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.Topic;
import com.page.Page;
import com.po.TopicPo;


import com.service.CourseService;

import com.service.StudentService;
import com.service.TopicService;
import com.util.StringUtil;
/**
 * ѡ�����
 * @author Congchong Fu
 *
 */
@RequestMapping("/topic")
@Controller
public class TopicController {	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
    HttpServletRequest request;
	/**
	 * ѡ���б�ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("topic/topic_list");
		return model;
	}
	
	/**
	 * ��ȡѡ���б�
	 * @param dataCID
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_list",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getList(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		String CID=(String)session.getAttribute("dataCID");
		request.getSession().setAttribute("CIDsession",CID);
		queryMap.put("CID",CID);		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows", topicService.getTopicByCID(queryMap));//ǰ���б������� easyUI���ĺ���
		ret.put("total", courseService.getTotal(queryMap));
		return ret;
	}
		
		
	
	
	/**
	 * �鿴��������
	 * 
	 * @return
	 */
	/*@RequestMapping(value="/detailed",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView detailed(@RequestParam(
			value="dataTopicID",required=true) String TopicID
			){
		System.out.println("TopicID is:"+TopicID);
		Student stuBean=new Student();//��ȡѡ�������ѧ���б�,��ȡÿ��ѧ���ϴ��ĸ����������б�
		stuBean.setStuArray(topicService.getStudentByTopicID(TopicID)); 
		int StudentNum=topicService.getStudentByTopicID(TopicID).size();
		Map<String, Object> ret = new HashMap<String, Object>();
		List<PaperPojo> tempList_Paper=new ArrayList<>();
		for(int j=0;j<StudentNum;j++)
		{
			tempList_Paper=studentService.getDetailedPaperInfo(TopicID,topicService.getStudentByTopicID(TopicID).get(j).getSNo());//һ���������ж���ƪ����
			ret.put("PaperList"+j,tempList_Paper);
		}
		PaperPojo paperpj=new PaperPojo();
		paperpj.setRetMap(ret);
		HttpSession sessionCBean=request.getSession();
		sessionCBean.setAttribute("stuBean", stuBean); 
		sessionCBean.setAttribute("paperpjBean", paperpj);
		System.out.println("��תһ��");
		return new ModelAndView("forward:/WEB-INF/views/topic/topicDetailed.jsp");
	}*/
	
	/**
	 * ���һ������
	 * 
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Topic topic){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(topic.getTopicID())){
			ret.put("type", "error");
			ret.put("msg", "����ID����Ϊ�գ�");
			return ret;
		}
		HttpSession session = request.getSession(true);
		String TN=topic.getTN();
		String TID=topicService.getTIDByTN(TN);
		TopicPo topicPo=new TopicPo();
		topicPo.setTopicID(topic.getTopicID());
		String CID=(String)session.getAttribute("CIDsession");
		topicPo.setCID(CID);
		topicPo.setTID(TID);
		topicPo.setTopicName(topic.getTopicName());
		topicPo.setKeyWord(topic.getKeyWord());
		topicPo.setCreateTime(topic.getCreateTime());
		topicPo.setPeopleNumber(topic.getPeopleNumber());
		int flag=topicService.add(topicPo);//��topic���в�������Ϣ
				
		if(flag <= 0){
			ret.put("type", "error");
			ret.put("msg", "�������ʧ�ܣ�");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "������ӳɹ���");
		return ret;
	}
	
	/**
	 * �༭ѧ����Ϣ
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Student student){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(student.getSN())){
			ret.put("type", "error");
			ret.put("msg", "ѧ����������Ϊ�գ�");
			return ret;
		}
		if(studentService.edit(student) <= 0){
			ret.put("type", "error");
			ret.put("msg", "ѧ���޸�ʧ�ܣ�");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ѧ���޸ĳɹ���");
		return ret;
	}
	
	/**
	 * ɾ��ѧ����Ϣ
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam(value="ids[]",required=true) String[] ids
			){
		Map<String, String> ret = new HashMap<String, String>();
		if(ids == null || ids.length == 0){
			ret.put("type", "error");
			ret.put("msg", "��ѡ��Ҫɾ�������ݣ�");
			return ret;
		}
		try {
			
			int flag=0;
			for(int i=0;i<ids.length;i++)
			{
			String SNo=ids[i];
			flag=studentService.delete(SNo);//ɾ��ѧ����ѧ�����Ѿ�sc���е���Ϣ
			studentService.deleteSC(SNo);
			if(flag<0)
				break;
			}
			if( flag<= 0){
				ret.put("type", "error");
				ret.put("msg", "ɾ��ʧ�ܣ�");
				return ret;
			}
		} catch (Exception e) {
			// TODO: handle exception
			ret.put("type", "error");
			ret.put("msg", "ɾ��ʧ�ܣ�");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ѧ��ɾ���ɹ���");
		return ret;
	}
	
}
