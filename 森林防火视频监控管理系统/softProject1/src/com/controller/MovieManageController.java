package com.controller;

import java.io.File;





import java.io.IOException;
import java.text.SimpleDateFormat;
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

import com.entity.AlarmInfo;
import com.entity.Clazz;
import com.entity.Course;
import com.entity.Grade;
import com.entity.Loginfo;
import com.entity.Movie;
import com.entity.Picture;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.User;
import com.page.Page;
import com.pojo.AffirmAlarmPojo;
import com.pojo.MoviePicturePojo;
import com.pojo.updateAlarmPojo;
import com.service.CourseService;
import com.service.LoginfoService;
import com.service.MovieService;
import com.service.StudentService;
import com.service.AlarmService;
import com.util.StringUtil;
/**
 * ѧ����Ϣ����
 * @author Congchong Fu
 *
 */
@RequestMapping("/movieManage")
@Controller
public class MovieManageController {	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private LoginfoService loginfoService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private AlarmService alarmService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
    HttpServletRequest request;
	/**
	 * ��Ƶ���߲���ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/onlineMovie",method=RequestMethod.GET)
	public ModelAndView onlineMovie(ModelAndView model){	
		//д����־
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
				Loginfo logi=new Loginfo();
				logi.setLdate(dateFormat.format(date));
				HttpSession session=request.getSession();
				User userPage=(User)session.getAttribute("userPage");
				if(userPage.getUtype().equals("ר��"))
				{
				logi.setLlevel(1);//ר��1��������Ա2
				}
				else
				{
					logi.setLlevel(2);
				}
				logi.setLcontent("������Ƶ���߲���ҳ");
				loginfoService.addLogInfo(logi);
		
		Movie mvbean=new Movie();
		mvbean.setMovieArray(movieService.getAllMovie());
		session.setAttribute("mvbean", mvbean);
		model.setViewName("movieManage/onlineMovie");
		return model;
	}
	
	/**
	 * ��Ƶ����ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/downloadMovie",method=RequestMethod.GET)
	public ModelAndView downloadMovie(ModelAndView model){	
		//д����־
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		HttpSession session=request.getSession();
		User userPage=(User)session.getAttribute("userPage");
		if(userPage.getUtype().equals("ר��"))
		{
		logi.setLlevel(1);//ר��1��������Ա2
		}
		else
		{
			logi.setLlevel(2);
		}
		logi.setLcontent("������Ƶ����ҳ");
		loginfoService.addLogInfo(logi);
		
		Movie mvbean=new Movie();
		mvbean.setMovieArray(movieService.getAllMovie());
		session.setAttribute("mvbean", mvbean);
		model.setViewName("movieManage/downloadMovie");
		return model;
	}
	
	
	/**
	 * ����ɾ����Ƶ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deleteMovie",method=RequestMethod.GET)
	public ModelAndView deleteMovie(ModelAndView model){
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		HttpSession session=request.getSession();
		User userPage=(User)session.getAttribute("userPage");
		if(userPage.getUtype().equals("ר��"))
		{
		logi.setLlevel(1);//ר��1��������Ա2
		}
		else
		{
			logi.setLlevel(2);
		}
		logi.setLcontent("��������ɾ����Ƶҳ");
		loginfoService.addLogInfo(logi);
		model.setViewName("movieManage/deleteMovie");
		return model;
	}
	
	
	/**
	 * ��Ƶ����ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchMovie",method=RequestMethod.GET)
	public ModelAndView searchMovie(ModelAndView model){
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		HttpSession session=request.getSession();
		User userPage=(User)session.getAttribute("userPage");
		if(userPage.getUtype().equals("ר��"))
		{
		logi.setLlevel(1);//ר��1��������Ա2
		}
		else
		{
			logi.setLlevel(2);
		}
		logi.setLcontent("������Ƶ����ҳ");
		loginfoService.addLogInfo(logi);
		
		model.setViewName("movieManage/searchMovie");
		return model;
	}
	
	
	
	/**
	 * ��ѯ�Ѵ�������¼
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/hadDealedList",method=RequestMethod.GET)
	public ModelAndView hadDealedlist(ModelAndView model){
		model.setViewName("warningManage/hadDealed_list");
		return model;
	}
	
	
	/**
	 * �����¼�ȷ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/affirmAlarm",method=RequestMethod.GET)
	public ModelAndView affirmAlarm(ModelAndView model){
		Map<String, Object> ret = new HashMap<String, Object>();
		//��Ҫ��ȡÿ����Ƶ��Ӧ��4��ͼƬ�ĵ�ַ
		ret.put("astatus", "��");
		AffirmAlarmPojo aaPojo=new AffirmAlarmPojo();
		aaPojo.setAffirmArray(alarmService.getAllAlarmMovie(ret));
		MoviePicturePojo moviePicPojo=new MoviePicturePojo();
		
		//��mid��paddress  
		List<MoviePicturePojo> l1=new ArrayList<>();
		for(int i=0;i<aaPojo.getAffirmArray().size();i++)
		{
			MoviePicturePojo tempPojo=new MoviePicturePojo();
			tempPojo.setMid(aaPojo.getAffirmArray().get(i).getMid());
			int mid=aaPojo.getAffirmArray().get(i).getMid();
			List<String>temp=alarmService.getPIDArray(mid);
			tempPojo.setPaddress(temp);
			l1.add(tempPojo);
		}
		moviePicPojo.setMoviePicArray(l1);
		
		HttpSession session=request.getSession();
		//aaPojo�е���Ƶ��ַ��moviePicPojo�е�ÿһ��list<Integer> pid һһ��Ӧ
		session.setAttribute("aaPojo", aaPojo);
		session.setAttribute("moviePicPojo", moviePicPojo);
		model.setViewName("warningManage/affirmWarning");
		return model;
	}
	
	
	
	
	/**
	 * ��ȡ�����¼��б�
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_addlist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getList(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		queryMap.put("astatus", "��"); 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows", alarmService.findList(queryMap));//ǰ���б������� easyUI���ĺ���
		ret.put("total", alarmService.getTotal(queryMap));
		return ret;
	}
		
	/**
	 * ��ȡȫ����Ƶ�б����ڸ��û�ɾ��
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_movielist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> get_movielist(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows",movieService.getAllMovieList(queryMap));//ǰ���б������� easyUI���ĺ���
		ret.put("total", alarmService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * ��ȡר���жϺ����Ϣ
	 *
	 * @param page
	 * @return
	 */
	 @RequestMapping(value="/GetAffirmAlarm",method={RequestMethod.POST,RequestMethod.GET}) 
	    public ModelAndView  GetAffirmAlarm() {	     
	    	HttpSession session=request.getSession();
	    	int number=Integer.parseInt(request.getParameter("number"));
	    	String[] fire=new String[1000];
	    	String[] mesBox=new String[1000];
	    	for(int i=0;i<number;i++)
	    	{
	    	fire[i]=request.getParameter("fire"+i);
	    	mesBox[i]=request.getParameter("mesBox"+i);
	    	}
	       //�������ݿ���astatus����Ϣ����д��ר��id������
	    	AffirmAlarmPojo aaPojo=(AffirmAlarmPojo)session.getAttribute("aaPojo");
	    	User user=(User)session.getAttribute("user");
	    	for(int j=0;j<aaPojo.getAffirmArray().size();j++)
	    	{
	    		int aid=aaPojo.getAffirmArray().get(j).getAid();
	    		updateAlarmPojo udpojo=new updateAlarmPojo();
	    		udpojo.setAid(aid);
	    		udpojo.setAstatus(fire[j]);
	    		udpojo.setAeid(user.getUid());//�õ�ר�ҵ�uid
	    		udpojo.setAemessage(mesBox[j]);
	    	    alarmService.updateAlarmByAid(udpojo);
	    	}
	    	
	       session.getAttribute("aaPojo"); 
	       return new ModelAndView("forward:/WEB-INF/views/warningManage/hadDealed_list.jsp");    
	            
	                    
	    }
	
	
	 /**
		 * ������Ƶ
		 *
		 * @param page
		 * @return
		 */
		 @RequestMapping(value="/GetSearchMovie",method={RequestMethod.POST,RequestMethod.GET}) 
		    public ModelAndView  GetSearchMovie() {	     
		    	HttpSession session=request.getSession();
		    	
		    	String[] searchType = request.getParameterValues("searchType");
		    	int flag1=0;
		    	int flag2=0;
		    	int flag3=0;
		    	String poname="��";
		    	int poid=0;
		    	String mdate="0000-00-00";
		    	if(searchType!=null)
		    	{
		    		for(int i=0;i<searchType.length;i++)
		    		{
		    			if(searchType[i].equals("poname"))
		    			{
		    				poname=request.getParameter("searchWord1");
		    				flag1=1;
		    			}
		    			if(searchType[i].equals("poid"))
		    			{
		    				poid=Integer.parseInt(request.getParameter("searchWord2"));
		    				flag2=1;
		    			}
		    			if(searchType[i].equals("mdate"))
		    			{
		    				mdate=request.getParameter("searchWord3");
		    				flag3=1;
		    			}
		    		}
		    	}
		    	
		    
		    	Movie mvbean=new Movie();
		    	if(flag1==1&&flag2==0&&flag3==0)//��ص����Ʋ�ѯ
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPoname(poname)); 
		    	}else if(flag1==0&&flag2==1&&flag3==0)//��ص�ID��ѯ
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPoid(poid));
		    	}
		    	else if(flag1==0&&flag2==0&&flag3==1)//ʱ���ѯ
		    	{
		    		mvbean.setMovieArray(movieService.getMovByMdate(mdate));
		    	}
		    	else if(flag1==1&&flag2==1&&flag3==0)//����+ID
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPonameID(poname,poid));
		    	}
		    	else if(flag1==1&&flag2==0&&flag3==1)//����+ʱ��
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPonameDate(poname,mdate));
		    	}
		    	else if(flag1==0&&flag2==1&&flag3==1)//ʱ��+ID
		    	{
		    		mvbean.setMovieArray(movieService.getMovByMdateID(mdate,poid));
		    	}
		    	else//����+id+ʱ��
		    	{
		    		mvbean.setMovieArray(movieService.getMovByThree(poname,poid,mdate));
		    	}
		       	    		    	
		       session.setAttribute("mvbean",mvbean); 
		       return new ModelAndView("forward:/WEB-INF/views/movieManage/searchResultMov.jsp");    
		            
		                    
		    }
	 
	 
	
	
	
	
	/**
	 * ��ӱ����¼�
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(AlarmInfo alarmInfo){
		Map<String, String> ret = new HashMap<String, String>();
		
		if(StringUtils.isEmpty(Integer.toString(alarmInfo.getAid()))){
			ret.put("type", "error");
			ret.put("msg", "������¼��Ų���Ϊ�գ�");
			return ret;
		}
		HttpSession session = request.getSession(true);
		int flag=alarmService.add(alarmInfo);
		if(flag <= 0){
			ret.put("type", "error");
			ret.put("msg", "�����¼����ʧ�ܣ�");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "�����¼���ӳɹ���");
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
	 * ɾ����Ƶ��Ϣ
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam(value="ids[]",required=true) int[] ids
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
			int mid=ids[i];
			flag=movieService.delete(mid);
			
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
		ret.put("msg", "��Ƶɾ���ɹ���");
		return ret;
	}
	
}
