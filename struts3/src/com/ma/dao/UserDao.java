package com.ma.dao;

import com.ma.bean.User;


/**
 * 
 *
 * @version 
 * @author 马伟杰
 * @date 2017年7月30日 下午6:01:41
 * @Description: UserDao的接口
 */
public interface UserDao {
	
	public User finduserByAdminname(String username);

	public User findAdminByuserid(Integer userID);
	
	public void adduser(User user);
	
	public void deleteuser(User user);

	public Void updateuser(User user);
}
