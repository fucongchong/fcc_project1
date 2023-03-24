package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dao.UserTableDao;
import com.entity.UserTable;
import com.service.UserTableService;
@Service
public class UserTableServiceImpl implements UserTableService  {
	@Autowired
	private UserTableDao userTableDao;
	
	@Override
	public UserTable findByUID(String UID)
	{
		return userTableDao.findByUID(UID);
	}
	@Override
	public int addUser(UserTable user)
	{
		return userTableDao.addUser(user);
	}
}
