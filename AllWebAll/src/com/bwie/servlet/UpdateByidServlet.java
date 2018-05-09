package com.bwie.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwie.entity.Student;

public class UpdateByidServlet extends HttpServlet {
	
	
	   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		       //获取数据  id  值
		      String id = request.getParameter("id");
		      
		      
		      
		      
		      //链接数据库
		        try {
					Class.forName("com.mysql.jdbc.Driver");
					 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1601n?characterEncoding=utf-8", "root", "root");
					  PreparedStatement stmt = conn.prepareStatement(" select    *  from   student  where   id=?");
					   stmt.setString(1, id);
					  ResultSet rs = stmt.executeQuery(); 
					  
					  
					     Student   s=null;
					  while(rs.next()){
						   s = new   Student();
						   s.setId(rs.getString(1));
						   s.setName(rs.getString(2));
						   s.setPassword(rs.getString(3));
						   s.setSex(rs.getString(4));
						   s.setBrithday(rs.getDate(5));
						   s.setStype(rs.getString(6)); 
						   s.setHobby(rs.getString(7));
					  }
				   request.setAttribute("st", s);	    
				     //转发    update.jsp 页面  显示出  在数据库查询的数据   	
				   
				     request.getRequestDispatcher("updateByid.jsp").forward(request, response);
					  
                   //释放资源
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		      
		      
		      
		      
		      
		       
		   
		   
		   
		   
		   
		   
		   
	}
	
	
	
	
	
	
	
	
	
	

}
