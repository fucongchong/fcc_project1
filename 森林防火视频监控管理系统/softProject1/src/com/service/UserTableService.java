package com.service;

import org.springframework.stereotype.Service;


import com.entity.UserTable;

@Service
public interface UserTableService {
	public UserTable findByUID(String UID);
	public int addUser(UserTable user);
}
