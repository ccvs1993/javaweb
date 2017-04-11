package com.wang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsp_db", "root", "user");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

	public static void insertUserDate(Connection conn) throws SQLException {
		String sql = "INSERT INTO tbl_user(id,name,password,email) VALUES('10','xiaohong','1234','444@44.com')";

		Statement sm = conn.createStatement();
		int count = sm.executeUpdate(sql);
		System.out.println("插入了" + count + "条记录");

	}

	public static void insertAddressDate(Connection conn) throws SQLException {
		String sql = "INSERT INTO tbl_address(id,city,country,user_id) VALUES('1','chengdu','china','10')";

		Statement sm = conn.createStatement();
		int count = sm.executeUpdate(sql);
		System.out.println("插入了" + count + "条记录");

	}
	public static void main(String[] args) {
		Connection conn=getConnection();
		try {
			
			conn.setAutoCommit(false);
			insertUserDate(conn);
			insertAddressDate(conn);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("-----------捕获到异常-------------");
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("---------------事物回滚------------");
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}finally {
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
	}
}
