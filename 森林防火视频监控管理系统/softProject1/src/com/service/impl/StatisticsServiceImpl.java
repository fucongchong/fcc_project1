package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginfoDao;
import com.dao.StatisticsDao;
import com.po.StastisticsPo;
import com.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	@Autowired
	private StatisticsDao statisticsDao;
	@Override
	public int getCountFire(String astaus)
	{
		return statisticsDao.getCountFire(astaus);				
	}
	@Override
	public int getStatusRight(String astaus)
	{
		return statisticsDao.getStatusRight(astaus);
	}
	@Override
	public int getStatusWrong(String astaus)
	{
		return statisticsDao.getStatusWrong(astaus);
	}
	@Override
	public int getStatusNull(String astaus)
	{
		return statisticsDao.getStatusNull(astaus);
	}
	@Override
	public List<StastisticsPo> getAllTime()
	{
		return statisticsDao.getAllTime();
	}
}
