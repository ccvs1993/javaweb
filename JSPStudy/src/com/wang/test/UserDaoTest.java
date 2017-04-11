package com.wang.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.wang.dao.UserDao;
import com.wang.dao.impl.UserDaoImpl;
import com.wang.entity.User;
import com.wang.util.ConnectionFactory;

public class UserDaoTest {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			UserDao userDao=new UserDaoImpl();
			User gg=new User();
			gg.setName("gg");
			gg.setPassword("67890");
			gg.setEmail("sdefe@qq.com");
			
			userDao.save(conn, gg);
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
