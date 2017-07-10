package com.ma.dao;

import com.ma.bean.User;

public interface UserDao {
	public User finduserByAdminname(String username);

	public User findAdminByuserid(Integer userID);
	
	public void adduser(User user);
	
	public void deleteuser(User user);

	public Void updateuser(User user);
}
