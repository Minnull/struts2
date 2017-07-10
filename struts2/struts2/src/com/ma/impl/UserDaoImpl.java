package com.ma.impl;

import java.sql.Connection;

import util.jdbc;

import com.ma.bean.user;
import com.ma.dao.userdao;

public class userdaoimpl implements userdao{

	public user finduserByAdminname(String username) {
		return null;
	}

	public user findAdminByuserid(Integer userID) {
		return null;
	}

	public void adduser(user user) {
		String sql;
		user.setUserID(null);
		user.setUsername("123");
		user.setUserpwd("d");
		sql="insert userID username userpwd into user";
		Connection conn=new jdbc().getConnection();
		jdbc jdbc=new jdbc();
		jdbc.executeUpdate(sql,null);
		
	}

	public void deleteuser(user user) {
		
	}

	public Void updateuser(user user) {
		return null;
	}

}
