package com.service;

import java.util.List;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.entity.UserDetail;
import com.po.WaitUser;

@Service
public interface UserService {
	public User findByUID(int uid);
	public User findByUserName(String username);
	public int add(User user);
	public int edit(User user);
	public int delete(String ids);
	public List<User> findList(Map<String,Object> queryMap);
	public int getTotal(Map<String,Object> queryMap);
	public String getUtypeByUID(int uid);
	public List<WaitUser> getAllwaitUser();
	public WaitUser getWaitByUID(int uid);
	public int insertUser(WaitUser waituser);
	public int insertUserdetail(WaitUser waituser);
	public int deleteWaitUser(int uid);
	public List<UserDetail> getAllUserdetail();
	public int deleteUser(int uid);
	public int deleteUserdetail(int uid);
	public UserDetail UserDetailByUID(int uid);
	public int editUser(UserDetail userDet);
	public int RegisterWorker(WaitUser waituser);
}
