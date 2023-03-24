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
 * ϵͳ��ҳ������
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
	 * ��½ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView model){
		model.setViewName("system/login");
		return model;
	}
	
	
	/**
	 * ע����¼ 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login_out",method=RequestMethod.GET)
	public String loginOut(HttpServletRequest request){
		request.getSession().setAttribute("user", null);
		return "redirect:login";
	}
	
	/**
	 * ��¼���ύ
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
			ret.put("msg", "�û�������Ϊ��!");
			return ret;
		}
		if(StringUtils.isEmpty(password)){
			ret.put("type", "error");
			ret.put("msg", "���벻��Ϊ��!");
			return ret;
		}
		if(StringUtils.isEmpty(vcode)){
			ret.put("type", "error");
			ret.put("msg", "��֤�벻��Ϊ��!");
			return ret;
		}
		String loginCpacha = (String)request.getSession().getAttribute("loginCpacha");
		if(StringUtils.isEmpty(loginCpacha)){
			ret.put("type", "error");
			ret.put("msg", "��ʱ��δ�������Ự��ʧЧ����ˢ�º�����!");
			return ret;
		}
		if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "��֤�����!");
			return ret;
		}
		request.getSession().setAttribute("loginCpacha", null);
		//�����ݿ���ȥ�����û�
		User user = userService.findByUID(uid);
		HttpSession sessionPage=request.getSession();
		sessionPage.setAttribute("userPage", user);
		//ͨ��uid��utype
		
		if(type == 1){
			//����Ա
			
			if(user == null){
				ret.put("type", "error");
				ret.put("msg", "�����ڸ��û�!");
				return ret;
			}
			if(user.getUtype().equals("ר��")||user.getUtype().equals("������Ա"))
			{
				ret.put("type", "error");
				ret.put("msg", "�û����Ͳ���ȷ");
				return ret;
			}
			if(!password.equals(user.getPwd())){
				ret.put("type", "error");
				ret.put("msg", "������˺Ŵ���!");
				return ret;
			}
			//ͨ��UID�ҵ���ʦ������
			
			request.getSession().setAttribute("user", user);
			Teacher LoginUser=new Teacher();
			//LoginUser=teacherService.GetTNbyUID(user.getUid());
			request.getSession().setAttribute("LoginUser", LoginUser);
		}
		if(type == 2){
			//ר��
			
			if(user == null){
				ret.put("type", "error");
				ret.put("msg", "�����ڸ�ר��!");
				return ret;
			}
			if(user.getUtype().equals("����Ա")||user.getUtype().equals("������Ա"))
			{
				ret.put("type", "error");
				ret.put("msg", "�û����Ͳ���ȷ");
				return ret;
			}
			if(!password.equals(user.getPwd())){
				ret.put("type", "error");
				ret.put("msg", "������˺Ŵ���!");
				return ret;
			}
			request.getSession().setAttribute("user", user);
			//ͨ��UID��ר�ҵ����֣�
			//Teacher LoginUser=new Teacher();
			//LoginUser=teacherService.GetTNbyUID(user.getUid());
			//request.getSession().setAttribute("LoginUser", LoginUser);
			
			
		}
		if(type == 3){
			//������Ա
			//UserTable user = userTableService.findByUID(UID);
			if(user == null){
				ret.put("type", "error");
				ret.put("msg", "�����ڸù�����Ա!");
				return ret;
			}
			if(user.getUtype().equals("ר��")||user.getUtype().equals("����Ա"))
			{
				ret.put("type", "error");
				ret.put("msg", "�û����Ͳ���ȷ");
				return ret;
			}
			if(!password.equals(user.getPwd())){
				ret.put("type", "error");
				ret.put("msg", "��������˺Ŵ���!");
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
		ret.put("msg", "��¼�ɹ�!");
		return ret;
	}
	
	/**
	 * 
	 * ��ת��ע��ҳ��
	 * */
	@RequestMapping(value = "/goRegister",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView register(ModelAndView model){
		model.setViewName("system/registerWorker");
		return model;
	}
	
	/**
	 * ע����ύ
	 * @return
	 */
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> register(			
			HttpServletRequest request
			){
		Map<String, String> ret = new HashMap<String, String>();		
			ret.put("type", "goRegister");		
			ret.put("msg", "ȥע��");			
		return ret;
	}
	
	
	//������Ϣ
    @RequestMapping(value = "/GetRegisterWorker",method= {RequestMethod.GET,RequestMethod.POST}) 
    public ModelAndView  GetRegisterWorker(WaitUser waituser) {   	
        int flag=userService.RegisterWorker(waituser);
        
        if(flag<=0)//ע��ʧ��
        {       
        	return new ModelAndView("forward:/WEB-INF/views/system/registerFailed.jsp");
        }
        else
        {      	
        	return new ModelAndView("forward:/WEB-INF/views/system/registerSuccess.jsp");
        }               
    }
	
	
	
	
	/**
	 * ע����ύ
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
			ret.put("msg", "�û�������Ϊ��!");
			return ret;
		}
		if(StringUtils.isEmpty(password)){
			ret.put("type", "error");
			ret.put("msg", "���벻��Ϊ��!");
			return ret;
		}
		if(StringUtils.isEmpty(vcode)){
			ret.put("type", "error");
			ret.put("msg", "��֤�벻��Ϊ��!");
			return ret;
		}
		String loginCpacha = (String)request.getSession().getAttribute("loginCpacha");
		if(StringUtils.isEmpty(loginCpacha)){
			ret.put("type", "error");
			ret.put("msg", "��ʱ��δ�������Ự��ʧЧ����ˢ�º�����!");
			return ret;
		}
		if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "��֤�����!");
			return ret;
		}
		request.getSession().setAttribute("loginCpacha", null);
		//ע���û�����usertable�в���һ����¼
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
			ret.put("msg", "ע��ɹ�!");			
		}
		else
		{
			ret.put("type", "error");		
			ret.put("msg", "ע��ʧ��!");
		}		
		return ret;
	}*/
	
	
	
	
	
	/**
	 * ��ȡ��ʦ�γ��б�
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
	 * ��ȡѧ���γ��б�
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
		queryMap.put("status", "������ʦ");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", courseService.findListByStudent(queryMap));
		ret.put("total", courseService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * ��ӿγ���Ϣ
	 * @param course
	 * @return
	 */
	@RequestMapping(value="/add6",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> add(Course course){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(course.getCID())){
			ret.put("type", "error");
			ret.put("msg", "�γ�ID����Ϊ�գ�");
			return ret;
		}
		if(courseService.add(course) <= 0){
			ret.put("type", "error");
			ret.put("msg", "�γ����ʧ�ܣ�");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "�γ���ӳɹ���");
		return ret;
	}
	
	
	
	/**
	 * ��ʾ ��֤��
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
