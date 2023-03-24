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
import com.entity.Student;
import com.entity.Teacher;
import com.entity.User;
import com.page.Page;
import com.pojo.AffirmAlarmPojo;
import com.pojo.MoviePicturePojo;
import com.pojo.updateAlarmPojo;
import com.service.CourseService;
import com.service.LoginfoService;
import com.service.StudentService;
import com.service.AlarmService;
import com.util.StringUtil;
/**
 * 学生信息管理
 * @author Congchong Fu
 *
 */
@RequestMapping("/warningManage")
@Controller
public class WarningManageController {	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private LoginfoService loginfoService;
	
	@Autowired
	private AlarmService alarmService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
    HttpServletRequest request;
	/**
	 * 增加报警记录列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addlist",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
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
				logi.setLcontent("增加报警记录列表页");
				loginfoService.addLogInfo(logi);
		
		
		model.setViewName("warningManage/addWarning_list");
		return model;
	}
	
	
	/**
	 * 查询未处理报警记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/notDealList",method=RequestMethod.GET)
	public ModelAndView notDealList(ModelAndView model){
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
		logi.setLcontent("查询未处理报警记录");
		loginfoService.addLogInfo(logi);
		
				
		model.setViewName("warningManage/notDeal_list");
		return model;
	}
	
	/**
	 * 查询已处理报警记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/hadDealedList",method=RequestMethod.GET)
	public ModelAndView hadDealedlist(ModelAndView model){
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
				logi.setLcontent("查询已处理报警记录");
				loginfoService.addLogInfo(logi);
	
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
		logi.setLcontent("确认报警事件");
		loginfoService.addLogInfo(logi);
		
		
		
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
	 * 获取未处理报警事件列表
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_notDealList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> get_notDealList(
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		queryMap.put("astatus", "空"); 	
		
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		
		ret.put("rows", alarmService.findList(queryMap));//前端列表行数据 easyUI给的函数
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
	 * 查看学生选题信息
	 * @param course
	 * @return
	 */
	/*@RequestMapping(value="/detailed",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView detailed(@RequestParam(
			value="dataSNO",required=true) String dataSNO
			){
		System.out.println("dataSNO is:"+dataSNO);
		String SNo=dataSNO;
		StuTopicPojo stpjBean=new StuTopicPojo();//获取学生的选题信息
		stpjBean.setStutpArray(studentService.getStuTopicBySNO(SNo));
		stpjBean.setStuTopicNum(studentService.stuTopicNumber(SNo));//获取学生选题的数量
		//学生为哪些主题提交了论文：
		PaperPojo paperpj=new PaperPojo();
		List<String> PaperNum=studentService.getTopicPaperNum(SNo);
		paperpj.setTopicIDArray(PaperNum);//获取TopicID组成的数组
		
		List<PaperPojo> tempList_Paper=new ArrayList<>();
		Map<String, Object> ret = new HashMap<String, Object>();
		for(int i=0;i<PaperNum.size();i++)
		{
			tempList_Paper=studentService.getDetailedPaperInfo(PaperNum.get(i),SNo);//一个主题下有多少篇论文
			ret.put("PaperList"+i,tempList_Paper);
		}
			paperpj.setPapjoArray(tempList_Paper);
		    paperpj.setRetMap(ret);
		HttpSession sessionCBean=request.getSession();
		sessionCBean.setAttribute("stpjBean", stpjBean); 
		sessionCBean.setAttribute("paperpjBean", paperpj);
		System.out.println("跳转一次");
		return new ModelAndView("forward:/WEB-INF/views/student/studentDetailed.jsp");
	}*/
	
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
	 * 删除学生信息
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
			ret.put("msg", "请选择要删除的数据！");
			return ret;
		}
		try {
			
			int flag=0;
			for(int i=0;i<ids.length;i++)
			{
			String SNo=ids[i];
			flag=studentService.delete(SNo);//删除学生在学生表已经sc表中的信息
			studentService.deleteSC(SNo);
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
		ret.put("msg", "学生删除成功！");
		return ret;
	}
	
}
