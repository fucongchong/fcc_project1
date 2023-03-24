package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Movie;
import com.entity.Picture;

@Repository
public interface MovieDao {
     public List<Movie> getAllMovie();
     public List<Movie> getAllMovieList(Map<String,Object> queryMap);
     public int delete(int mid);
     public List<Movie> getMovByPoname(String poname);
     public List<Movie> getMovByPoid(int poid);
     public List<Movie> getMovByMdate(String mdate);
     public List<Movie> getMovByPonameID(String poname,int poid);
     public List<Movie> getMovByPonameDate(String poname,String mdate);
     public List<Movie> getMovByMdateID(String pdate,int poid);
     public List<Movie> getMovByThree(String poname,int poid,String mdate);
}
