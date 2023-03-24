package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.MovieDao;
import com.dao.PictureDao;
import com.entity.Movie;
import com.entity.Picture;
import com.service.MovieService;
import com.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {
	@Autowired
	private PictureDao pictureDao;
	@Override
	public List<Picture> getAllPic()
	{
		return pictureDao.getAllPic();
	}
	@Override
	public List<Picture> getAllPicList(Map<String, Object> queryMap)
	{
		return pictureDao.getAllPicList(queryMap);
				
	}
	@Override
	public int delete(int pid)
	{
		return pictureDao.delete(pid);
	}
	@Override
	 public List<Picture> getPicByPoname(String poname)
	 {
		return pictureDao.getPicByPoname(poname);
	 }
	@Override
     public List<Picture> getPicByPoid(int poid)
     {
		return pictureDao.getPicByPoid(poid);
     }
	@Override
     public List<Picture> getPicByPdate(String pdate)
     {
		return pictureDao.getPicByPdate(pdate);
     }
     public List<Picture> getPicByPonameID(String poname,int poid)
     {
    	 return pictureDao.getPicByPonameID(poname, poid);
     }
     @Override
     public List<Picture> getPicByPonameDate(String poname,String pdate)
     {
    	 return pictureDao.getPicByPonameDate(poname, pdate);
     }
     @Override
     public List<Picture> getPicByPdateID(String pdate,int poid)
     {
    	 return pictureDao.getPicByPdateID(pdate, poid);
     }
     @Override
     public List<Picture> getPicByThree(String poname,int poid,String pdate)
     {
    	 return pictureDao.getPicByThree(poname, poid, pdate);
     }
}
