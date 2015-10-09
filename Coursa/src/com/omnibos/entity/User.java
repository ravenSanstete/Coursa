package com.omnibos.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String uid;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String school;
	private String email;
	private String phone;
	private String intro;
	private String friends;
	private String courses;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public List<String> getFriendList() {
		List<String> friendList = new ArrayList<String>();
		String[] ablumArray = getFriends().split(";");
		for (String s : ablumArray) {
			friendList.add(s);
		}
		return friendList;
	}

	public void setFriendList(List<String> list) {
		String friends = "";
		for (String s : list) {
			friends += s + ";";
		}
		setFriends(friends);
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public List<String> getCourseList() {
		List<String> courseList = new ArrayList<String>();
		String[] courseArray = this.getCourses().split(";");
		for (String s : courseArray) {
			courseList.add(s);
		}
		return courseList;
	}

	public void setCourseList(List<String> list) {
		String courses = "";
		for (String s : list) {
			courses += s + ";";
		}
		setCourses(courses);
	}

}