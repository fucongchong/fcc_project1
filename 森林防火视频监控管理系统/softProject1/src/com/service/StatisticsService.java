package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.StastisticsPo;

@Service
public interface StatisticsService {
	public int getCountFire(String astaus);
	public int getStatusRight(String astaus);
	public int getStatusWrong(String astaus);
	public int getStatusNull(String astaus);
	public List<StastisticsPo> getAllTime();
}
