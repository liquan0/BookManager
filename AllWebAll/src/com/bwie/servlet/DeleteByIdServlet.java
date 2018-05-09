package com.bwie.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteByIdServlet   extends  HttpServlet{
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		     //获取表单的数据
		     //获取  id 的值
		   String id = request.getParameter("ids");
		   
		     //链接数据库
		      try {
				Class.forName("com.mysql.jdbc.Driver");
				
				  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1601n?characterEncoding=utf-8", "root", "root");
				
				  PreparedStatement stmt = conn.prepareStatement("delete  from    student  where   id=? ");
				      stmt.setString(1, id);
				     int num = stmt.executeUpdate();
				  
				     if(num>0){
					  
				    	 System.out.println("删除成功");
					       response.sendRedirect("chaxunliebiao");
				  }else{
					  System.out.println("删除失败");
					  
					
					  
					  
				  }
				     
				     
				     
				     
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		   
		   
		   
		   
		
		
		
		
		
		
	}
	
	

}
