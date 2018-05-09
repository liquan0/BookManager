package com.bwie.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwie.entity.Student;

public class SearchServlet   extends  HttpServlet{

	
	
	   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1601n?characterEncoding=utf-8", "root", "root");
		    PreparedStatement stmt = conn.prepareStatement("select  *  from  student ");
		     ResultSet rs = stmt.executeQuery();
		      ArrayList<Student> list = new   ArrayList<Student>();     
		      Student s =null;
		     while(rs.next()){
		       //调用对象
		    	  s = new   Student();
		    	   s.setId(rs.getString(1));
		    	   s.setName(rs.getString(2));
		    	   s.setPassword(rs.getString(3));
		    	   s.setSex(rs.getString(4));
		    	   s.setBrithday(rs.getDate(5));
		    	   s.setStype(rs.getString(6));
		    	   s.setHobby(rs.getString(7));
                    list.add(s); 
 
		     }
		     
		   
		        request.setAttribute("jihe", list);
		        
		        //转发  到展示的 jsp页面上
		         request.getRequestDispatcher("show.jsp").forward(request, response);
		     
			/* for (Student student : list) {
				
			}*/
		         
		         
		         
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
		   
		   
		   
		   
		   
		   
		   
		   
		   
	}
	
	
	
}
