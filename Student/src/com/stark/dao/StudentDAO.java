package com.stark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stark.model.StudentBean;
import com.stark.util.DbUtil;

public class StudentDAO {
	private Connection connection;
	ResultSet rs;

	public StudentDAO() {
		connection = DbUtil.getConnetion();
	}

	public void addStudent(StudentBean student) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into student(id, f_name, l_name, class, city) values (?, ?, ?, ?,? )");
			preparedStatement.setInt(1, student.getsId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setInt(4, student.getsClass());
			preparedStatement.setString(5, student.getCity());
			int res=preparedStatement.executeUpdate();
			
			if (res>0){
				System.out.println("Student data inserted");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(StudentBean student){
		try{
			PreparedStatement preparedStatement = connection
					.prepareStatement("update student set id=?, f_name=?, l_name=?, class=?, city=? where id=?");
			//preparedStatement.setInt(1, student.getsId());
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setInt(3, student.getsClass());
			preparedStatement.setString(4, student.getCity());
			int res=preparedStatement.executeUpdate();
			
			if (res>0){
				System.out.println("Student updated");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void deleteStudent(StudentBean student){
		try{PreparedStatement preparedStatement = connection
				.prepareStatement("delete from student  where id=?");
		preparedStatement.setInt(1, student.getsId());
		
		int res=preparedStatement.executeUpdate();
		
		if (res>0){
			System.out.println("Student deleted");
		}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public List<StudentBean> getAllStudent(){
		
	List<StudentBean> student=new ArrayList<StudentBean>();
	try{
		
		PreparedStatement preparedstatement=connection.prepareStatement("select * from student");
		ResultSet resultset = preparedstatement.executeQuery();
		
		while(rs.next()){
			
			StudentBean sbean=new StudentBean();
			
			sbean.setsId(resultset.getInt(1));
			sbean.setFirstName(resultset.getString(2));
			sbean.setLastName(resultset.getString(3));
			sbean.setsClass(resultset.getInt(4));
			sbean.setCity(resultset.getString(5));
			
			student.add(sbean);
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
		return student;
	}
	
	public StudentBean getStudentById(int id){
		
		StudentBean sbean=null;
		
		try{
			PreparedStatement preparedstatement=connection.prepareStatement("select * from student where id=?");
			preparedstatement.setInt(1, id);
			ResultSet resultset=preparedstatement.executeQuery();
		
			while(resultset.next()){
				sbean=new StudentBean();
			
				sbean.setsId(resultset.getInt(1));
				sbean.setFirstName(resultset.getString(2));
				sbean.setLastName(resultset.getString(3));
				sbean.setsClass(resultset.getInt(4));
				sbean.setCity(resultset.getString(5));
			
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return sbean;
	}
}

