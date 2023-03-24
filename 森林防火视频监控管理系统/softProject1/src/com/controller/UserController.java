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
import com.entity.UserDetail;
import com.page.Page;
import com.po.WaitUser;
import com.pojo.AffirmAlarmPojo;
import com.pojo.MoviePicturePojo;
import com.pojo.updateAlarmPojo;
import com.service.CourseService;
import com.service.LoginfoService;
import com.service.MovieService;
import com.service.PictureService;
import com.service.StudentService;
import com.service.UserService;
import com.service.AlarmService;
import com.util.StringUtil;
/**
 * 学生信息管理
 * @author Congchong Fu
 *
 */
@RequestMapping("/userc")
@Controller
public class UserController {	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
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
	 * 用户管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userManageList",method=RequestMethod.GET)
	public ModelAndView userManageList(ModelAndView model){		
		HttpSession session=request.getSession();
		//写入日志
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("当前时间是："+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		logi.setLlevel(3);//专家1，工作人员2,管理员3
		logi.setLcontent("进入用户管理页");
		loginfoService.addLogInfo(logi);
		Picture picbean=new Picture();
		picbean.setPicArray(pictureService.getAllPic());
		session.setAttribute("picbean", picbean);
		model.setViewName("userManage/userInfoPage");
		return model;
	}
	
	/**
	 * 查找用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userFindList",method=RequestMethod.GET)
	public ModelAndView userFindList(ModelAndView model){		
		HttpSession session=request.getSession();
		//写入日志
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("当前时间是："+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		logi.setLlevel(3);//专家1，工作人员2,管理员3
		logi.setLcontent("进入查找用户页");
		loginfoService.addLogInfo(logi);
		Picture picbean=new Picture();
		picbean.setPicArray(pictureService.getAllPic());
		session.setAttribute("picbean", picbean);
		model.setViewName("userManage/findUserPage");
		return model;
	}
	
	/**
	 * 审核用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userWaitList",method=RequestMethod.GET)
	public ModelAndView userWaitList(ModelAndView model){		
		HttpSession session=request.getSession();
		//写入日志
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("当前时间是："+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		logi.setLlevel(3);//专家1，工作人员2,管理员3
		logi.setLcontent("进入审核注册页");
		loginfoService.addLogInfo(logi);
		
		
		model.setViewName("userManage/userWaitPage");
		return model;
	}
	
	
	
	/**
	 * 日志查询
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/loginfoList",method=RequestMethod.GET)
	public ModelAndView loginfoList(ModelAndView model){		
		HttpSession session=request.getSession();
		//写入日志
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				System.out.println("当前时间是："+dateFormat.format(date));
				Loginfo logi=new Loginfo();
				logi.setLdate(dateFormat.format(date));
				logi.setLlevel(3);//专家1，工作人员2
				logi.setLcontent("日志查询");
				loginfoService.addLogInfo(logi);
		
		model.setViewName("loginfoPage/loginfoList");
		return model;
	}
	
	
	
	
	/**
	 * 获取日志列表
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_loginfolist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getloginfolist(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows", loginfoService.getAllLog(queryMap));//前端列表行数据 easyUI给的函数
		ret.put("total", loginfoService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * 获取所有用户列表
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_alluserlist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getalluserlist(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows", userService.getAllUserdetail());//前端列表行数据 easyUI给的函数
		ret.put("total", loginfoService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * 获取待审核用户列表
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_waitlist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getwaitlist(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		WaitUser waituser=new WaitUser(); 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows", userService.getAllwaitUser());//前端列表行数据 easyUI给的函数
		ret.put("total", loginfoService.getTotal(queryMap));
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
	 * 处理查询
	 *
	 * @param page
	 * @return
	 */
	 @RequestMapping(value="/GetFindUser",method={RequestMethod.POST,RequestMethod.GET}) 
	    public ModelAndView  GetFindUser() {	     
	    	HttpSession session=request.getSession();
	    	
	    	int uid = Integer.parseInt(request.getParameter("findUID"));
	    	UserDetail userDet=new UserDetail();
	    	userDet=userService.UserDetailByUID(uid);    		    	
	       session.setAttribute("userDet",userDet); 
	       return new ModelAndView("forward:/WEB-INF/views/userManage/userFindResult.jsp");    
	            
	                    
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
	 * 编辑用户信息
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(UserDetail userDet){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(userDet.getUname())){
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空！");
			return ret;
		}
		int flag=userService.editUser(userDet);
		if( flag<= 0){
			ret.put("type", "error");
			ret.put("msg", "用户修改失败！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "用户修改成功！");
		return ret;
	}
	
	
	
	/**
	 * 通过审核
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
			ret.put("msg", "请选择要审核的数据！");
			return ret;
		}
		try {
			
			int flag=0;
			for(int i=0;i<ids.length;i++)
			{
			int uid=ids[i];
			//通过uid得到全部注册信息
			WaitUser waituser=userService.getWaitByUID(uid);
			
			//插入user userdetail表  删除在waituser中记录
			flag=userService.insertUser(waituser);
			userService.insertUserdetail(waituser);
			userService.deleteWaitUser(uid);
			if(flag<0)
				break;
			}
			if( flag<= 0){
				ret.put("type", "error");
				ret.put("msg", "审核失败！");
				return ret;
			}
		} catch (Exception e) {
			// TODO: handle exception
			ret.put("type", "error");
			ret.put("msg", "审核失败！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "审核成功！");
		return ret;
	}
	
	
	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteUser(
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
			int uid=ids[i];
			
			flag=userService.deleteUser(uid);
			userService.deleteUserdetail(uid);
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
		ret.put("msg", "删除成功！");
		return ret;
	}
	
}
