package com.omnibos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.omnibos.entity.Course;
import com.omnibos.util.JDBCUtil;


public class CourseDao {
	private JDBCUtil jdbc;
	
	public CourseDao(){
		jdbc=new JDBCUtil();
	}
	
	public Course selectCourseById(String courseId){
		Course aCourse=new Course();
		String sql="select * from course where courseId='?'";
		Connection conn=jdbc.getConnection();
		try{
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setString(1, courseId);
			ResultSet outcome=stm.executeQuery();
			
//set course info
			while(outcome.next()){
				aCourse.setCourseId(outcome.getString("courseId"));
				aCourse.setCourseName(outcome.getString("courseName"));
				aCourse.setCredit(outcome.getString("credit"));
				aCourse.setTutors(outcome.getString("tutors"));
				aCourse.setPost(outcome.getString("post"));
				aCourse.setStdNumLimit(outcome.getString("stdNumLimit"));
				aCourse.setLocation(outcome.getString("location"));
				aCourse.setDuration(outcome.getString("duration"));
				aCourse.setExamInfo(outcome.getString("examInfo"));
				aCourse.setExtraInfo(outcome.getString("extraInfo"));
				aCourse.setClassBelong(outcome.getString("classBelong"));
				aCourse.setRestriction(outcome.getString("restriction"));
				aCourse.setModuleId(outcome.getString("moduleId"));
			}
			
			
		
		}catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
		
		return aCourse;
	}
	
	
	
}
