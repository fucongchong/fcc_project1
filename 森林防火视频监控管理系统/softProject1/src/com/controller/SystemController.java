package com.controller;

import java.awt.image.BufferedImage;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Course;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.User;
import com.entity.UserTable;
import com.page.Page;
import com.po.WaitUser;
import com.pojo.LoginTypePojo;
import com.service.CourseService;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.UserService;
import com.service.UserTableService;
import com.util.CpachaUtil;


/**
 * 系统主页控制器
 * @author Congchong Fu
 *
 */

@RequestMapping("/system")
@Controller
public class SystemController {
	
	
	@Autowired
	private UserTableService userTableService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
    HttpServletRequest request;
	
	@RequestMapping(value = "/indexDBA",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView indexDBA(ModelAndView model){
		model.setViewName("system/index");
		return model;
	}
		
	
	@RequestMapping(value = "/index",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(ModelAndView model){		
		model.setViewName("system/index");
		return model;
	}
	
	@RequestMapping(value = "/teacherIndex",method=RequestMethod.GET)
	public ModelAndView hello(ModelAndView model){
		model.setViewName("system/teacherIndex");
		return model;
	}
		
	@RequestMapping(value = "/studentIndex",method=RequestMethod.GET)
	public ModelAndView studentIndex(ModelAndView model){
		model.setViewName("system/studentIndex");
		return model;
	}
	
	@RequestMapping(value = "/registerIndex",method=RequestMethod.GET)
	public ModelAndView registerIndex(ModelAndView model){
		model.setViewName("system/register");
		return model;
	}
	
	/**
	 * 登陆页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView model){
		model.setViewName("system/login");
		return model;
	}
	
	
	/**
	 * 注销登录 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login_out",method=RequestMethod.GET)
	public String loginOut(HttpServletRequest request){
		request.getSession().setAttribute("user", null);
		return "redirect:login";
	}
	
	/**
	 * 登录表单提交
	 * @return
	 */
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(
			@RequestParam(value="UID",required=true) String UID,
			@RequestParam(value="password",required=true) String password,
			@RequestParam(value="vcode",required=true) String vcode,
			@RequestParam(value="type",required=true) int type,
			HttpServletRequest request
			){
		Map<String, String> ret = new HashMap<String, String>();
		int uid=Integer.parseInt(UID);
		if(StringUtils.isEmpty(UID)){			
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空!");
			return ret;
		}
		if(StringUtils.isEmpty(password)){
			ret.put("type", "error");
			ret.put("msg", "密码不能为空!");
			return ret;
		}
		if(StringUtils.isEmpty(vcode)){
			ret.put("type", "error");
			ret.put("msg", "验证码不能为空!");
			return ret;
		}
		String loginCpacha = (String)request.getSession().getAttribute("loginCpacha");
		if(StringUtils.isEmpty(loginCpacha)){
			ret.put("type", "error");
			ret.put("msg", "长时间未操作，会话已失效，请刷新后重试!");
			return ret;
		}
		if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "验证码错误!");
			return ret;
		}
		request.getSession().setAttribute("loginCpacha", null);
		//从数据库中去查找用户
		User user = userService.findByUID(uid);
		HttpSession sessionPage=request.getSession();
		sessionPage.setAttribute("userPage", user);
		//通过uid找utype
		
		if(type == 1){
			//管理员
			
			if(user == null){
				ret.put("type", "error");
				ret.put("msg", "不存在该用户!");
				return ret;
			}
			if(user.getUtype().equals("专家")||user.getUtype().equals("工作人员"))
			{
				ret.put("type", "error");
				ret.put("msg", "用户类型不正确");
				return ret;
			}
			if(!password.equals(user.getPwd())){
				ret.put("type", "error");
				ret.put("msg", "密码或账号错误!");
				return ret;
			}
			//通过UID找到教师的名字
			
			request.getSession().setAttribute("user", user);
			Teacher LoginUser=new Teacher();
			//LoginUser=teacherService.GetTNbyUID(user.getUid());
			request.getSession().setAttribute("LoginUser", LoginUser);
		}
		if(type == 2){
			//专家
			
			if(user == null){
				ret.put("type", "error");
				ret.put("msg", "不存在该专家!");
				return ret;
			}
			if(user.getUtype().equals("管理员")||user.getUtype().equals("工作人员"))
			{
				ret.put("type", "error");
				ret.put("msg", "用户类型不正确");
				return ret;
			}
			if(!password.equals(user.getPwd())){
				ret.put("type", "error");
				ret.put("msg", "密码或账号错误!");
				return ret;
			}
			request.getSession().setAttribute("user", user);
			//通过UID找专家的名字：
			//Teacher LoginUser=new Teacher();
			//LoginUser=teacherService.GetTNbyUID(user.getUid());
			//request.getSession().setAttribute("LoginUser", LoginUser);
			
			
		}
		if(type == 3){
			//工作人员
			//UserTable user = userTableService.findByUID(UID);
			if(user == null){
				ret.put("type", "error");
				ret.put("msg", "不存在该工作人员!");
				return ret;
			}
			if(user.getUtype().equals("专家")||user.getUtype().equals("管理员"))
			{
				ret.put("type", "error");
				ret.put("msg", "用户类型不正确");
				return ret;
			}
			if(!password.equals(user.getPwd())){
				ret.put("type", "error");
				ret.put("msg", "密码或者账号错误!");
				return ret;
			}			
			request.getSession().setAttribute("user", user);
			Student LoginStudent=new Student();
			//String SNo=user.getUID();
			//LoginStudent=studentService.GetSNbyUID(SNo);
			request.getSession().setAttribute("LoginStudent", LoginStudent);
			
		}
		request.getSession().setAttribute("userType", type);
		LoginTypePojo ptp=new LoginTypePojo();
		ptp.setUserType(type);
		HttpSession sessionType=request.getSession();
		sessionType.setAttribute("ptp", ptp); 
		ret.put("Utype",user.getUtype());
		ret.put("type", "success");
		ret.put("msg", "登录成功!");
		return ret;
	}
	
	/**
	 * 
	 * 跳转到注册页面
	 * */
	@RequestMapping(value = "/goRegister",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView register(ModelAndView model){
		model.setViewName("system/registerWorker");
		return model;
	}
	
	/**
	 * 注册表单提交
	 * @return
	 */
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> register(			
			HttpServletRequest request
			){
		Map<String, String> ret = new HashMap<String, String>();		
			ret.put("type", "goRegister");		
			ret.put("msg", "去注册");			
		return ret;
	}
	
	
	//控制信息
    @RequestMapping(value = "/GetRegisterWorker",method= {RequestMethod.GET,RequestMethod.POST}) 
    public ModelAndView  GetRegisterWorker(WaitUser waituser) {   	
        int flag=userService.RegisterWorker(waituser);
        
        if(flag<=0)//注册失败
        {       
        	return new ModelAndView("forward:/WEB-INF/views/system/registerFailed.jsp");
        }
        else
        {      	
        	return new ModelAndView("forward:/WEB-INF/views/system/registerSuccess.jsp");
        }               
    }
	
	
	
	
	/**
	 * 注册表单提交
	 * @return
	 */
	/*@RequestMapping(value = "/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> register(
			@RequestParam(value="UID",required=true) String UID,
			@RequestParam(value="password",required=true) String password,
			@RequestParam(value="vcode",required=true) String vcode,
			@RequestParam(value="type",required=true) int type,
			HttpServletRequest request
			){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(UID)){			
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空!");
			return ret;
		}
		if(StringUtils.isEmpty(password)){
			ret.put("type", "error");
			ret.put("msg", "密码不能为空!");
			return ret;
		}
		if(StringUtils.isEmpty(vcode)){
			ret.put("type", "error");
			ret.put("msg", "验证码不能为空!");
			return ret;
		}
		String loginCpacha = (String)request.getSession().getAttribute("loginCpacha");
		if(StringUtils.isEmpty(loginCpacha)){
			ret.put("type", "error");
			ret.put("msg", "长时间未操作，会话已失效，请刷新后重试!");
			return ret;
		}
		if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "验证码错误!");
			return ret;
		}
		request.getSession().setAttribute("loginCpacha", null);
		//注册用户，往usertable中插入一条记录
		String userType="DBA";
		if(type==2)
			userType="teacher";
		if(type==3)
			userType="student";
		UserTable user = new UserTable();
		user.setUID(UID);
		user.setPassword(password);
		user.setUserType(userType);
		int flag=userTableService.addUser(user);	
		if(flag>0)
		{
			ret.put("type", "success");		
			ret.put("msg", "注册成功!");			
		}
		else
		{
			ret.put("type", "error");		
			ret.put("msg", "注册失败!");
		}		
		return ret;
	}*/
	
	
	
	
	
	/**
	 * 获取教师课程列表
	 * @param CN
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_clist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getList(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Teacher teac=new Teacher();
		teac=(Teacher)session.getAttribute("LoginUser");		
		queryMap.put("TID", teac.getTID());
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", courseService.findList2(queryMap));
		ret.put("total", courseService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * 获取学生课程列表
	 * @param CN
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_slist",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getList_student(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Student stu=new Student();
		stu=(Student)session.getAttribute("LoginStudent");		
		queryMap.put("SNo", stu.getSNo());
		queryMap.put("status", "主讲教师");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", courseService.findListByStudent(queryMap));
		ret.put("total", courseService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * 添加课程信息
	 * @param course
	 * @return
	 */
	@RequestMapping(value="/add6",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> add(Course course){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(course.getCID())){
			ret.put("type", "error");
			ret.put("msg", "课程ID不能为空！");
			return ret;
		}
		if(courseService.add(course) <= 0){
			ret.put("type", "error");
			ret.put("msg", "课程添加失败！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "课程添加成功！");
		return ret;
	}
	
	
	
	/**
	 * 显示 验证码
	 * @param request
	 * @param vl
	 * @param w
	 * @param h
	 * @param response
	 */
	@RequestMapping(value="/get_cpacha",method=RequestMethod.GET)
	public void getCpacha(HttpServletRequest request,
			@RequestParam(value="vl",defaultValue="4",required=false) Integer vl,
			@RequestParam(value="w",defaultValue="98",required=false) Integer w,
			@RequestParam(value="h",defaultValue="33",required=false) Integer h,
			HttpServletResponse response){
		CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
		String generatorVCode = cpachaUtil.generatorVCode();
		request.getSession().setAttribute("loginCpacha", generatorVCode);
		BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
		try {
			ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
