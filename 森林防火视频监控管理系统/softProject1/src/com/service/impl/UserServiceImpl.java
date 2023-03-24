package com.service.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;
import com.entity.UserDetail;
import com.po.WaitUser;
import com.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByUID(int uid)
	{
		return userDao.findByUID(uid);
	}
	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}
	@Override
	public List<User> findList(Map<String,Object> queryMap) {
		// TODO Auto-generated method stub
		return userDao.findList(queryMap);
	}
	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return userDao.getTotal(queryMap);
	}
	@Override
	public int edit(User user) {
		// TODO Auto-generated method stub
		return userDao.edit(user);
	}
	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return userDao.delete(ids);
	}
	@Override
	public String getUtypeByUID(int uid)
	{
		return userDao.getUtypeByUID(uid);
	}
	@Override
	public List<WaitUser> getAllwaitUser()
	{
		return userDao.getAllwaitUser();
	}
	@Override
	public WaitUser getWaitByUID(int uid)
	{
		return userDao.getWaitByUID(uid);
	}
	@Override
	public int insertUser(WaitUser waituser)
	{
		return userDao.insertUser(waituser);
	}
    @Override
    public int insertUserdetail(WaitUser waituser)
    {
    	return userDao.insertUserdetail(waituser);
    }
    @Override
    public int deleteWaitUser(int uid)
    {
    	return userDao.deleteWaitUser(uid);
    }
    @Override
    public List<UserDetail> getAllUserdetail()
    {
    	return userDao.getAllUserdetail();
    }
    @Override
    public int deleteUser(int uid)
    {
    	return userDao.deleteUser(uid);
    }
    @Override
    public int deleteUserdetail(int uid)
    {
    	return userDao.deleteUserdetail(uid);
    }
    @Override
    public UserDetail UserDetailByUID(int uid)
    {
    	return userDao.UserDetailByUID(uid);
    }
    @Override
    public int editUser(UserDetail userDet)
    {
    	return userDao.editUser(userDet);
    }
    @Override
    public int RegisterWorker(WaitUser waituser)
    {
    	return userDao.RegisterWorker(waituser);
    }
}
