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
 * 学生信息管理
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
	 * 视频在线播放页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/onlineMovie",method=RequestMethod.GET)
	public ModelAndView onlineMovie(ModelAndView model){	
		//写入日志
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				System.out.println("当前时间是："+dateFormat.format(date));
				Loginfo logi=new Loginfo();
				logi.setLdate(dateFormat.format(date));
				HttpSession session=request.getSession();
				User userPage=(User)session.getAttribute("userPage");
				if(userPage.getUtype().equals("专家"))
				{
				logi.setLlevel(1);//专家1，工作人员2
				}
				else
				{
					logi.setLlevel(2);
				}
				logi.setLcontent("进入视频在线播放页");
				loginfoService.addLogInfo(logi);
		
		Movie mvbean=new Movie();
		mvbean.setMovieArray(movieService.getAllMovie());
		session.setAttribute("mvbean", mvbean);
		model.setViewName("movieManage/onlineMovie");
		return model;
	}
	
	/**
	 * 视频下载页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/downloadMovie",method=RequestMethod.GET)
	public ModelAndView downloadMovie(ModelAndView model){	
		//写入日志
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("当前时间是："+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		HttpSession session=request.getSession();
		User userPage=(User)session.getAttribute("userPage");
		if(userPage.getUtype().equals("专家"))
		{
		logi.setLlevel(1);//专家1，工作人员2
		}
		else
		{
			logi.setLlevel(2);
		}
		logi.setLcontent("进入视频下载页");
		loginfoService.addLogInfo(logi);
		
		Movie mvbean=new Movie();
		mvbean.setMovieArray(movieService.getAllMovie());
		session.setAttribute("mvbean", mvbean);
		model.setViewName("movieManage/downloadMovie");
		return model;
	}
	
	
	/**
	 * 批量删除视频
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deleteMovie",method=RequestMethod.GET)
	public ModelAndView deleteMovie(ModelAndView model){
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("当前时间是："+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		HttpSession session=request.getSession();
		User userPage=(User)session.getAttribute("userPage");
		if(userPage.getUtype().equals("专家"))
		{
		logi.setLlevel(1);//专家1，工作人员2
		}
		else
		{
			logi.setLlevel(2);
		}
		logi.setLcontent("进入批量删除视频页");
		loginfoService.addLogInfo(logi);
		model.setViewName("movieManage/deleteMovie");
		return model;
	}
	
	
	/**
	 * 视频搜索页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchMovie",method=RequestMethod.GET)
	public ModelAndView searchMovie(ModelAndView model){
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("当前时间是："+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		HttpSession session=request.getSession();
		User userPage=(User)session.getAttribute("userPage");
		if(userPage.getUtype().equals("专家"))
		{
		logi.setLlevel(1);//专家1，工作人员2
		}
		else
		{
			logi.setLlevel(2);
		}
		logi.setLcontent("进入视频搜索页");
		loginfoService.addLogInfo(logi);
		
		model.setViewName("movieManage/searchMovie");
		return model;
	}
	
	
	
	/**
	 * 查询已处理报警记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/hadDealedList",method=RequestMethod.GET)
	public ModelAndView hadDealedlist(ModelAndView model){
		model.setViewName("warningManage/hadDealed_list");
		return model;
	}
	
	
	/**
	 * 报警事件确认
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/affirmAlarm",method=RequestMethod.GET)
	public ModelAndView affirmAlarm(ModelAndView model){
		Map<String, Object> ret = new HashMap<String, Object>();
		//需要获取每个视频对应的4张图片的地址
		ret.put("astatus", "空");
		AffirmAlarmPojo aaPojo=new AffirmAlarmPojo();
		aaPojo.setAffirmArray(alarmService.getAllAlarmMovie(ret));
		MoviePicturePojo moviePicPojo=new MoviePicturePojo();
		
		//由mid找paddress  
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
		//aaPojo中的视频地址与moviePicPojo中的每一个list<Integer> pid 一一对应
		session.setAttribute("aaPojo", aaPojo);
		session.setAttribute("moviePicPojo", moviePicPojo);
		model.setViewName("warningManage/affirmWarning");
		return model;
	}
	
	
	
	
	/**
	 * 获取报警事件列表
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
		queryMap.put("astatus", "正"); 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows", alarmService.findList(queryMap));//前端列表行数据 easyUI给的函数
		ret.put("total", alarmService.getTotal(queryMap));
		return ret;
	}
		
	/**
	 * 获取全部视频列表用于给用户删除
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
		
		ret.put("rows",movieService.getAllMovieList(queryMap));//前端列表行数据 easyUI给的函数
		ret.put("total", alarmService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * 获取专家判断后的信息
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
	       //更新数据库中astatus的信息，并写入专家id和留言
	    	AffirmAlarmPojo aaPojo=(AffirmAlarmPojo)session.getAttribute("aaPojo");
	    	User user=(User)session.getAttribute("user");
	    	for(int j=0;j<aaPojo.getAffirmArray().size();j++)
	    	{
	    		int aid=aaPojo.getAffirmArray().get(j).getAid();
	    		updateAlarmPojo udpojo=new updateAlarmPojo();
	    		udpojo.setAid(aid);
	    		udpojo.setAstatus(fire[j]);
	    		udpojo.setAeid(user.getUid());//得到专家的uid
	    		udpojo.setAemessage(mesBox[j]);
	    	    alarmService.updateAlarmByAid(udpojo);
	    	}
	    	
	       session.getAttribute("aaPojo"); 
	       return new ModelAndView("forward:/WEB-INF/views/warningManage/hadDealed_list.jsp");    
	            
	                    
	    }
	
	
	 /**
		 * 搜索视频
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
		    	String poname="空";
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
		    	if(flag1==1&&flag2==0&&flag3==0)//监控点名称查询
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPoname(poname)); 
		    	}else if(flag1==0&&flag2==1&&flag3==0)//监控点ID查询
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPoid(poid));
		    	}
		    	else if(flag1==0&&flag2==0&&flag3==1)//时间查询
		    	{
		    		mvbean.setMovieArray(movieService.getMovByMdate(mdate));
		    	}
		    	else if(flag1==1&&flag2==1&&flag3==0)//名称+ID
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPonameID(poname,poid));
		    	}
		    	else if(flag1==1&&flag2==0&&flag3==1)//名称+时间
		    	{
		    		mvbean.setMovieArray(movieService.getMovByPonameDate(poname,mdate));
		    	}
		    	else if(flag1==0&&flag2==1&&flag3==1)//时间+ID
		    	{
		    		mvbean.setMovieArray(movieService.getMovByMdateID(mdate,poid));
		    	}
		    	else//名称+id+时间
		    	{
		    		mvbean.setMovieArray(movieService.getMovByThree(poname,poid,mdate));
		    	}
		       	    		    	
		       session.setAttribute("mvbean",mvbean); 
		       return new ModelAndView("forward:/WEB-INF/views/movieManage/searchResultMov.jsp");    
		            
		                    
		    }
	 
	 
	
	
	
	
	/**
	 * 添加报警事件
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(AlarmInfo alarmInfo){
		Map<String, String> ret = new HashMap<String, String>();
		
		if(StringUtils.isEmpty(Integer.toString(alarmInfo.getAid()))){
			ret.put("type", "error");
			ret.put("msg", "报警记录编号不能为空！");
			return ret;
		}
		HttpSession session = request.getSession(true);
		int flag=alarmService.add(alarmInfo);
		if(flag <= 0){
			ret.put("type", "error");
			ret.put("msg", "报警事件添加失败！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "报警事件添加成功！");
		return ret;
	}
	
	/**
	 * 编辑学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Student student){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(student.getSN())){
			ret.put("type", "error");
			ret.put("msg", "学生姓名不能为空！");
			return ret;
		}
		if(studentService.edit(student) <= 0){
			ret.put("type", "error");
			ret.put("msg", "学生修改失败！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "学生修改成功！");
		return ret;
	}
	
	/**
	 * 删除视频信息
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
			ret.put("msg", "请选择要删除的数据！");
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
				ret.put("msg", "删除失败！");
				return ret;
			}
		} catch (Exception e) {
			// TODO: handle exception
			ret.put("type", "error");
			ret.put("msg", "删除失败！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "视频删除成功！");
		return ret;
	}
	
}
