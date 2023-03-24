package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.Movie;
import com.entity.Picture;

@Service
public interface PictureService {
	public List<Picture> getAllPic();
	public List<Picture> getAllPicList(Map<String, Object> queryMap);
	public int delete(int pid);
	 public List<Picture> getPicByPoname(String poname);
     public List<Picture> getPicByPoid(int poid);
     public List<Picture> getPicByPdate(String pdate);
     public List<Picture> getPicByPonameID(String poname,int poid);
     public List<Picture> getPicByPonameDate(String poname,String pdate);
     public List<Picture> getPicByPdateID(String pdate,int poid);
     public List<Picture> getPicByThree(String poname,int poid,String pdate);
}
