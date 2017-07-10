package com.ma.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ma.bean.User;
import com.ma.dao.UserDao;
import com.sun.glass.ui.CommonDialogs.Type;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import util.BeanToMapUtil;
import util.jdbc;

public class UserDaoImpl implements UserDao {

	public User finduserByAdminname(String username) {

		String sql = "select * from user where username=?";
		jdbc jdbc = new jdbc();
		Connection conn = new jdbc().getConnection();
		User user = new User();
		Object[] params = { username };
		List<Object> itemList = jdbc.excuteQuery(sql, params);

		Map<String, Object> users = null;
		for (int j = 0; j < itemList.size(); j++) {

			users = (Map<String, Object>) itemList.get(j);

		}
		try {
			System.out.println("到这里了");
			user = (User) BeanToMapUtil.convertMap(User.class, users);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;

	}

	public User findAdminByuserid(Integer userID) {
		return null;
	}

	public void adduser(User user) {
		String sql;
		user.setUserID(null);
		user.setUsername("123");
		user.setUserpwd("d");
		sql = "insert userID username userpwd into user";
		Connection conn = new jdbc().getConnection();
		jdbc jdbc = new jdbc();
		jdbc.executeUpdate(sql, null);

	}

	public void deleteuser(User user) {

	}

	public Void updateuser(User user) {
		return null;
	}

}
