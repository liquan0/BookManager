package com.bwie.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Regservlet   extends  HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		     request.setCharacterEncoding("utf-8");
		     response.setCharacterEncoding("utf-8");
		     response.setContentType("text/html;charset=utf-8");

		    String   name= request.getParameter("username");
		    String password = request.getParameter("password");
		    String sex = request.getParameter("sex");
		    String  brithday=  request.getParameter("brithday");
		        //链接数库		    
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1601n?characterEncoding=utf-8", "root", "root");
				  PreparedStatement stmt = conn.prepareStatement("select  *  from  student   where   name=?");
				  stmt.setString(1, name);   
				   ResultSet rs = stmt.executeQuery();
				   
				   if(rs.next()){
					   request.setAttribute("regerror", "用户名已存在，请您重新注册"); 
					    request.getRequestDispatcher("reg.jsp").forward(request, response);
					     return;
				   }/*else{*/
				   
				  PreparedStatement stmts = conn.prepareStatement("insert  into  student  values(?,?,?,?,?,?,?)"); 
				        String uid = UUID.randomUUID().toString(); 
				          stmts.setString(1, uid);
				          stmts.setString(2, name);
				          stmts.setString(3,password );
				          stmts.setString(4, sex);
				          stmts.setString(5, brithday);
				          stmts.setString(6, "");
				          stmts.setString(7, "");
				          int num = stmts.executeUpdate();
				          if(num>0){   
				             request.getRequestDispatcher("login.jsp").forward(request, response);	  
				          }else{
				             request.getRequestDispatcher("reg.jsp").forward(request, response);	  
				          }    
				     //释放资源
				          stmts.close();
				          stmt.close();
				          rs.close();
				          conn.close();    
				 /*  }*/
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    
		        
		    
		    
		    
		    
		    
		    
		    
		            
		
		
		
		
		
		
		
		
		
	}
	
	

}
