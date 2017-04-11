package com.wang.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.wang.dao.UserDao;
import com.wang.dao.impl.UserDaoImpl;
import com.wang.entity.User;
import com.wang.util.ConnectionFactory;

public class CheckUserService {
	private UserDao userDao=new UserDaoImpl();
	
	public boolean check(User user){
		Connection conn=null;
		try {
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=userDao.get(conn, user);
			while(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return false;
		
	}
}
