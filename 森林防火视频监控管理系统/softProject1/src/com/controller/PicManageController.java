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
import com.service.PictureService;
import com.service.StudentService;
import com.service.AlarmService;
import com.util.StringUtil;
/**
 * 学生信息管理
 * @author Congchong Fu
 *
 */
@RequestMapping("/picManage")
@Controller
public class PicManageController {	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private PictureService pictureService;
	
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
	 * 图片在线播放页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/onlinePic",method=RequestMethod.GET)
	public ModelAndView onlineMovie(ModelAndView model){		
		HttpSession session=request.getSession();
		
		//写入日志
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("当前时间是："+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		User userPage=(User)session.getAttribute("userPage");
		if(userPage.getUtype().equals("专家"))
		{
		logi.setLlevel(1);//专家1，工作人员2
		}
		else
		{
			logi.setLlevel(2);
		}
		logi.setLcontent("进入图片在线查看页");
		loginfoService.addLogInfo(logi);
		Picture picbean=new Picture();
		picbean.setPicArray(pictureService.getAllPic());
		session.setAttribute("picbean", picbean);
		model.setViewName("picManage/onlinePic");
		return model;
	}
	
	/**
	 * 图片在下载页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/downloadPic",method=RequestMethod.GET)
	public ModelAndView downloadPic(ModelAndView model){		
		HttpSession session=request.getSession();
		//写入日志
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				System.out.println("当前时间是："+dateFormat.format(date));
				Loginfo logi=new Loginfo();
				logi.setLdate(dateFormat.format(date));
				User userPage=(User)session.getAttribute("userPage");
				if(userPage.getUtype().equals("专家"))
				{
				logi.setLlevel(1);//专家1，工作人员2
				}
				else
				{
					logi.setLlevel(2);
				}
				logi.setLcontent("进入图片下载页");
				loginfoService.addLogInfo(logi);
		Picture picbean=new Picture();
		picbean.setPicArray(pictureService.getAllPic());
		session.setAttribute("picbean", picbean);
		model.setViewName("picManage/downloadPic");
		return model;
	}
	
	/**
	 * 图片在搜索页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchPic",method=RequestMethod.GET)
	public ModelAndView searchPic(ModelAndView model){	
		HttpSession session=request.getSession();
		//写入日志
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				System.out.println("当前时间是："+dateFormat.format(date));
				Loginfo logi=new Loginfo();
				logi.setLdate(dateFormat.format(date));
				User userPage=(User)session.getAttribute("userPage");
				if(userPage.getUtype().equals("专家"))
				{
				logi.setLlevel(1);//专家1，工作人员2
				}
				else
				{
					logi.setLlevel(2);
				}
				logi.setLcontent("进入图片搜索页");
				loginfoService.addLogInfo(logi);
		
		model.setViewName("picManage/searchPic");
		return model;
	}
	
	
	
	/**
	 * 批量删除视频
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletePic",method=RequestMethod.GET)
	public ModelAndView deleteMovie(ModelAndView model){
		
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
				logi.setLcontent("进入图片删除页");
				loginfoService.addLogInfo(logi);
		model.setViewName("picManage/deletePic");
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
	@RequestMapping(value="/get_piclist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> get_movielist(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows",pictureService.getAllPicList(queryMap));//前端列表行数据 easyUI给的函数
		ret.put("total", alarmService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * 搜索
	 *
	 * @param page
	 * @return
	 */
	 @RequestMapping(value="/GetSearchPic",method={RequestMethod.POST,RequestMethod.GET}) 
	    public ModelAndView  GetSearchPic() {	     
	    	HttpSession session=request.getSession();
	    	
	    	String[] searchType = request.getParameterValues("searchType");
	    	int flag1=0;
	    	int flag2=0;
	    	int flag3=0;
	    	String poname="空";
	    	int poid=0;
	    	String pdate="0000-00-00";
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
	    			if(searchType[i].equals("pdate"))
	    			{
	    				pdate=request.getParameter("searchWord3");
	    				flag3=1;
	    			}
	    		}
	    	}
	    	
	    
	    	Picture picbean=new Picture();
	    	if(flag1==1&&flag2==0&&flag3==0)//监控点名称查询
	    	{
	    		picbean.setPicArray(pictureService.getPicByPoname(poname)); 
	    	}else if(flag1==0&&flag2==1&&flag3==0)//监控点ID查询
	    	{
	    		picbean.setPicArray(pictureService.getPicByPoid(poid));
	    	}
	    	else if(flag1==0&&flag2==0&&flag3==1)//时间查询
	    	{
	    		picbean.setPicArray(pictureService.getPicByPdate(pdate));
	    	}
	    	else if(flag1==1&&flag2==1&&flag3==0)//名称+ID
	    	{
	    		picbean.setPicArray(pictureService.getPicByPonameID(poname,poid));
	    	}
	    	else if(flag1==1&&flag2==0&&flag3==1)//名称+时间
	    	{
	    		picbean.setPicArray(pictureService.getPicByPonameDate(poname,pdate));
	    	}
	    	else if(flag1==0&&flag2==1&&flag3==1)//时间+ID
	    	{
	    		picbean.setPicArray(pictureService.getPicByPdateID(pdate,poid));
	    	}
	    	else//名称+id+时间
	    	{
	    		picbean.setPicArray(pictureService.getPicByThree(poname,poid,pdate));
	    	}
	       	    		    	
	       session.setAttribute("picbean",picbean); 
	       return new ModelAndView("forward:/WEB-INF/views/picManage/searchResult.jsp");    
	            
	                    
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
	 * 删除图片信息
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
			int pid=ids[i];
			flag=pictureService.delete(pid);
			
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
		ret.put("msg", "图片删除成功！");
		return ret;
	}
	
}
