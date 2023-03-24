package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.po.StastisticsPo;

@Repository
public interface StatisticsDao {
	public int getCountFire(String astaus);
	public int getStatusRight(String astaus);
	public int getStatusWrong(String astaus);
	public int getStatusNull(String astaus);
	public List<StastisticsPo> getAllTime();
}
