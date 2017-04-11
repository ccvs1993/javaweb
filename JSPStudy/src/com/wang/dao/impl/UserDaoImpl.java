package com.wang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wang.dao.UserDao;
import com.wang.entity.User;

public class UserDaoImpl implements UserDao {
	/*保存用户信息*/
	@Override
	public void save(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tbl_user(name,password,email) VALUES(?,?,?)";
		PreparedStatement ps=conn.prepareCall(sql);
		ps.setString(1,user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();
	}

	@Override
	public void update(Connection conn, long id, User user)
			throws SQLException {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_user SET name=? WHERE id=?";
		PreparedStatement ps=conn.prepareCall(sql);
		ps.setString(1,user.getName());
		ps.setLong(2, user.getId());		
		ps.execute();
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tbl_user WHERE id=?";
		PreparedStatement ps=conn.prepareCall(sql);
		ps.setLong(1, user.getId());		
		ps.execute();
	}

	@Override
	public ResultSet get(Connection conn, User user) throws Exception {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tbl_user WHERE name=? AND password=?";
		PreparedStatement ps=conn.prepareCall(sql);
		ps.setString(1,user.getName());
		ps.setString(2, user.getPassword());
		return ps.executeQuery();
	}

}
