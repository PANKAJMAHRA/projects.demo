package com.stark.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stark.dao.StudentDAO;
import com.stark.model.StudentBean;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="/student.jsp";
	private static String LIST_STUDENT="/liststudent.jsp";
	String forward;
	StudentDAO dao;
	
    public StudentController() {
        super();
      dao = new StudentDAO(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//response.getWriter().append("Served at: ").append(request.getContextPath());
		
        String action = request.getParameter("action");
        
        if(action.equalsIgnoreCase("list")){
        	
        	forward= LIST_STUDENT;
        	
        	List<StudentBean> list=dao.getAllStudent();
        	request.setAttribute("student", list);
        }
        else if(action.equalsIgnoreCase("edit")){
        	
        	forward=INSERT_OR_EDIT;
        	
        	int id= Integer.parseInt((request.getParameter("stdId")));
        	StudentBean sbean=dao.getStudentById(id);
        	request.setAttribute("sbean", sbean);
        }
        else if(action.equalsIgnoreCase("delete")){
        	forward=INSERT_OR_EDIT;
        	
        	int id=Integer.parseInt((request.getParameter("stdId")));
        	StudentBean sbean=new StudentBean();
        	sbean.setsId(id);
        	dao.deleteStudent(sbean);
        }
        else{
        	forward=INSERT_OR_EDIT;
        }
        RequestDispatcher requestdispatcher=request.getRequestDispatcher(forward);
        requestdispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
