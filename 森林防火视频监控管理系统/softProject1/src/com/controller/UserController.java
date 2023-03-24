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
 * ѧ����Ϣ����
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
	 * �û�����
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userManageList",method=RequestMethod.GET)
	public ModelAndView userManageList(ModelAndView model){		
		HttpSession session=request.getSession();
		//д����־
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		logi.setLlevel(3);//ר��1��������Ա2,����Ա3
		logi.setLcontent("�����û�����ҳ");
		loginfoService.addLogInfo(logi);
		Picture picbean=new Picture();
		picbean.setPicArray(pictureService.getAllPic());
		session.setAttribute("picbean", picbean);
		model.setViewName("userManage/userInfoPage");
		return model;
	}
	
	/**
	 * �����û�
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userFindList",method=RequestMethod.GET)
	public ModelAndView userFindList(ModelAndView model){		
		HttpSession session=request.getSession();
		//д����־
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		logi.setLlevel(3);//ר��1��������Ա2,����Ա3
		logi.setLcontent("��������û�ҳ");
		loginfoService.addLogInfo(logi);
		Picture picbean=new Picture();
		picbean.setPicArray(pictureService.getAllPic());
		session.setAttribute("picbean", picbean);
		model.setViewName("userManage/findUserPage");
		return model;
	}
	
	/**
	 * ����û�
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userWaitList",method=RequestMethod.GET)
	public ModelAndView userWaitList(ModelAndView model){		
		HttpSession session=request.getSession();
		//д����־
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
		Loginfo logi=new Loginfo();
		logi.setLdate(dateFormat.format(date));
		logi.setLlevel(3);//ר��1��������Ա2,����Ա3
		logi.setLcontent("�������ע��ҳ");
		loginfoService.addLogInfo(logi);
		
		
		model.setViewName("userManage/userWaitPage");
		return model;
	}
	
	
	
	/**
	 * ��־��ѯ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/loginfoList",method=RequestMethod.GET)
	public ModelAndView loginfoList(ModelAndView model){		
		HttpSession session=request.getSession();
		//д����־
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				System.out.println("��ǰʱ���ǣ�"+dateFormat.format(date));
				Loginfo logi=new Loginfo();
				logi.setLdate(dateFormat.format(date));
				logi.setLlevel(3);//ר��1��������Ա2
				logi.setLcontent("��־��ѯ");
				loginfoService.addLogInfo(logi);
		
		model.setViewName("loginfoPage/loginfoList");
		return model;
	}
	
	
	
	
	/**
	 * ��ȡ��־�б�
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
		
		ret.put("rows", loginfoService.getAllLog(queryMap));//ǰ���б������� easyUI���ĺ���
		ret.put("total", loginfoService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * ��ȡ�����û��б�
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
		
		ret.put("rows", userService.getAllUserdetail());//ǰ���б������� easyUI���ĺ���
		ret.put("total", loginfoService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * ��ȡ������û��б�
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
		
		ret.put("rows", userService.getAllwaitUser());//ǰ���б������� easyUI���ĺ���
		ret.put("total", loginfoService.getTotal(queryMap));
		return ret;
	}
		
	/**
	 * ��ȡȫ����Ƶ�б����ڸ��û�ɾ��
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
		
		ret.put("rows",pictureService.getAllPicList(queryMap));//ǰ���б������� easyUI���ĺ���
		ret.put("total", alarmService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 * �����ѯ
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
	 * �༭�û���Ϣ
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(UserDetail userDet){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(userDet.getUname())){
			ret.put("type", "error");
			ret.put("msg", "�û�������Ϊ�գ�");
			return ret;
		}
		int flag=userService.editUser(userDet);
		if( flag<= 0){
			ret.put("type", "error");
			ret.put("msg", "�û��޸�ʧ�ܣ�");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "�û��޸ĳɹ���");
		return ret;
	}
	
	
	
	/**
	 * ͨ�����
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
			ret.put("msg", "��ѡ��Ҫ��˵����ݣ�");
			return ret;
		}
		try {
			
			int flag=0;
			for(int i=0;i<ids.length;i++)
			{
			int uid=ids[i];
			//ͨ��uid�õ�ȫ��ע����Ϣ
			WaitUser waituser=userService.getWaitByUID(uid);
			
			//����user userdetail��  ɾ����waituser�м�¼
			flag=userService.insertUser(waituser);
			userService.insertUserdetail(waituser);
			userService.deleteWaitUser(uid);
			if(flag<0)
				break;
			}
			if( flag<= 0){
				ret.put("type", "error");
				ret.put("msg", "���ʧ�ܣ�");
				return ret;
			}
		} catch (Exception e) {
			// TODO: handle exception
			ret.put("type", "error");
			ret.put("msg", "���ʧ�ܣ�");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "��˳ɹ���");
		return ret;
	}
	
	
	/**
	 * ɾ���û�
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
			ret.put("msg", "��ѡ��Ҫɾ�������ݣ�");
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
		ret.put("msg", "ɾ���ɹ���");
		return ret;
	}
	
}
