package com.wang.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory factory=new ConnectionFactory();
	private Connection conn;
	static{
		Properties prop=new Properties();
		try {
			InputStream in=ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		driver=prop.getProperty("driver");
		dburl=prop.getProperty("dburl");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
	}
	
	private ConnectionFactory(){}//私有构造函数，单例模式，在程序运行期间，只有一个ConnectionFactory实例
	
	public static ConnectionFactory getInstance(){
		return factory;
	}
	
	public Connection makeConnection()
	{
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl,user,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
