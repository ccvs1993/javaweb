package com.wang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCTest {
	
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","user");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public static void insert(){
		String sql="INSERT INTO tbl_user(name,password,email) VALUES('Tom','5678','333@3.com')";
		try {
			Connection conn=getConnection();
			Statement sm=conn.createStatement();
			int count=sm.executeUpdate(sql);
			System.out.println("向用户表插入了"+count+"条数据");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void update(){
		String sql="UPDATE tbl_user SET name='qwerty' WHERE id='1'";
		try {
			Connection conn=getConnection();
			Statement sm=conn.createStatement();
			int count=sm.executeUpdate(sql);
			System.out.println("一共更新了"+count+"条数据");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void delete(){
		String sql="DELETE FROM tbl_user WHERE	name='Tom' ";
		try {
			Connection conn=getConnection();
			Statement sm=conn.createStatement();
			int count=sm.executeUpdate(sql);
			System.out.println("一共删除了"+count+"条数据");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//insert();
		//update();
		delete();
	}
}
