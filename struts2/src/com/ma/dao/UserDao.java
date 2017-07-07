package com.ma.dao;

import com.ma.bean.user;

public interface userdao {
	public user finduserByAdminname(String username);

	public user findAdminByuserid(Integer userID);
	
	public void adduser(user user);
	
	public void deleteuser(user user);

	public Void updateuser(user user);
}
