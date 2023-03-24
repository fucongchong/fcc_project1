package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.MovieDao;
import com.entity.Movie;
import com.entity.Picture;
import com.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;
	@Override
	public List<Movie> getAllMovie()
	{
		return movieDao.getAllMovie();
	}
	@Override
	public List<Movie> getAllMovieList(Map<String,Object> queryMap)
	{
		return movieDao.getAllMovieList(queryMap);
	}
	@Override
	public int delete(int mid)
	{
		return movieDao.delete(mid);
	}
	@Override
	public List<Movie> getMovByPoname(String poname)
	{
		return movieDao.getMovByPoname(poname);
	}
	@Override
    public List<Movie> getMovByPoid(int poid)
    {
		return movieDao.getMovByPoid(poid);
    }
	@Override
    public List<Movie> getMovByMdate(String mdate)
    {
		return movieDao.getMovByMdate(mdate);
    }
	@Override
    public List<Movie> getMovByPonameID(String poname,int poid)
    {
		return movieDao.getMovByPonameID(poname, poid);
    }
	@Override
    public List<Movie> getMovByPonameDate(String poname,String mdate)
    {
		return movieDao.getMovByPonameDate(poname, mdate);
    }
	@Override
    public List<Movie> getMovByMdateID(String pdate,int poid)
    {
		return movieDao.getMovByMdateID(pdate, poid);
    }
	@Override
    public List<Movie> getMovByThree(String poname,int poid,String mdate)
    {
		return movieDao.getMovByThree(poname, poid, mdate);
    }
}
