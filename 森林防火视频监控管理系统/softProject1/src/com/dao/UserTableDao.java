package com.dao;

import org.springframework.stereotype.Repository;


import com.entity.UserTable;
@Repository
public interface UserTableDao {
	public UserTable findByUID(String UID);
	public int addUser(UserTable user);
}
