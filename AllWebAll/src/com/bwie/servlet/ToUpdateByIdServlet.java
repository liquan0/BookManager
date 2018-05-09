package com.bwie.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToUpdateByIdServlet   extends  HttpServlet {

	
	   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  
		      //处理乱码
		      request.setCharacterEncoding("utf-8");
		      response.setCharacterEncoding("utf-8");
		      response.setContentType("text/html;charset=utf-8");
		   
		   
		        //获取 表单的数据
		         //获取id
		          String id = request.getParameter("id");
		         //  获取 用户名
		           String name = request.getParameter("username");
		           //获取密码
		            String pwd = request.getParameter("pwd");
		            //获取性别
		              String sex = request.getParameter("sex");
		              //获取 日期
		               String bday = request.getParameter("brithday");
		              //获取学历
		                 String stype = request.getParameter("stype");
		              
		                   
		                 
		                 
		                 
		                 
		                 
		          //链接数据库
		                 try {
							Class.forName("com.mysql.jdbc.Driver");
						
						 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1601n?characterEncoding=utf-8", "root", "root");
						  PreparedStatement stmt = conn.prepareStatement(" update  student  set name=?,password=?,sex=?, brithday=?,stype=?  where id=? ");         
		                     stmt.setString(1, name);
		                     stmt.setString(2, pwd);
		                     stmt.setString(3, sex);
		                     stmt.setString(4, bday);
		                     stmt.setString(5, stype);
		                     stmt.setString(6, id);
						   int num = stmt.executeUpdate();
						   
						   if(num>0){
							   
							//  重定向到 查询功能中   查询数据库的数据   
							   response.sendRedirect("chaxunliebiao");  
						   }else{
							    request.setAttribute("updateerror", "修改失败");
							     request.getRequestDispatcher("updateByid.jsp").forward(request, response);   
						   }
						   
						   //释放资源

						  
		                 } catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
		                 
		   
	}
	
	
	
	
}
