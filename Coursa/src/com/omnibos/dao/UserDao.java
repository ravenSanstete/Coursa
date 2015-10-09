package com.omnibos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.omnibos.entity.User;
import com.omnibos.util.JDBCUtil;;

public class UserDao {

	private JDBCUtil util;

	public UserDao() {
		util = new JDBCUtil();
	}

	public void userSave(User user) {
		Connection conn = util.getConnection();
		String sql = "insert into user(username,password,name,gender,school,email,phone)" + " values('"
				+ user.getUsername() + "','" + user.getPassword() + "','" + user.getName() + "','" + user.getGender()
				+ "','" + user.getSchool() + "','" + user.getEmail() + "','" + user.getPhone() + "')";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, st, rs);
		}
	}

	public void userDel(User user) {
		Connection conn = util.getConnection();
		String sql = "delete from user where uid='" + user.getUid() + "'";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, st, rs);
		}
	}

	public void userUpdate(User user) {
		Connection conn = util.getConnection();
		String sql = "update user set username='" + user.getUsername() + "', password='" + user.getPassword()
				+ "', name='" + user.getName() + "', gender='" + user.getGender() + "', school='" + user.getSchool()
				+ "', email='" + user.getEmail() + "', phone='" + user.getPhone() + "', intro='" + user.getIntro()
				+ "', friends='" + user.getFriends() + "', courses='" + user.getCourses() + "' where uid='"
				+ user.getUid() + "'";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, st, rs);
		}
	}

	public List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		Connection conn = util.getConnection();
		String sql = "select uid,username,password,name,gender,school,email,phone,intro,friends,courses from user";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getString("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setGender(rs.getString("gender"));
				u.setSchool(rs.getString("school"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setIntro(rs.getString("intro"));
				u.setFriends(rs.getString("friends"));
				u.setCourses(rs.getString("courses"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, st, rs);
		}
		return list;
	}

	public User getUserByUid(String uid) {
		User u = null;
		Connection conn = util.getConnection();
		String sql = "select uid,username,password,name,gender,school,email,phone,intro,friends,courses from user where uid='"
				+ uid + "'";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				u = new User();
				u.setUid(rs.getString("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setGender(rs.getString("gender"));
				u.setSchool(rs.getString("school"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setIntro(rs.getString("intro"));
				u.setFriends(rs.getString("friends"));
				u.setCourses(rs.getString("courses"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, st, rs);
		}
		return u;
	}

	public User getUserByUsername(String username) {
		User u = null;
		Connection conn = util.getConnection();
		String sql = "select uid,username,password,name,gender,school,email,phone,intro,friends,courses from user where username='"
				+ username + "'";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				u = new User();
				u.setUid(rs.getString("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setGender(rs.getString("gender"));
				u.setSchool(rs.getString("school"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setIntro(rs.getString("intro"));
				u.setFriends(rs.getString("friends"));
				u.setCourses(rs.getString("courses"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, st, rs);
		}
		return u;
	}

	public List<User> getUserByKeyword(String keyword) {
		List<User> list = new ArrayList<User>();
		User u = null;
		Connection conn = util.getConnection();
		String sql = "select uid,username,password,name,gender,school,email,phone,intro,friends,courses from user where username LIKE '%"
				+ keyword + "%' LIMIT 10";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				u = new User();
				u.setUid(rs.getString("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setGender(rs.getString("gender"));
				u.setSchool(rs.getString("school"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setIntro(rs.getString("intro"));
				u.setFriends(rs.getString("friends"));
				u.setCourses(rs.getString("courses"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, st, rs);
		}
		return list;
	}
}