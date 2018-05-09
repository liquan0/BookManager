package com.bwie.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddStudentServlet  extends  HttpServlet {

	   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //处理乱码
		     request.setCharacterEncoding("utf-8");
		     response.setCharacterEncoding("utf-8");
		     response.setContentType("text/html;charset=utf-8");
		   
		        //获取表单的数据
		        String name = request.getParameter("username");
		         String pwd = request.getParameter("password");
		         //性别
		          String sex = request.getParameter("sex");
		          //生日
		          String brithday = request.getParameter("brithday");
		          //学历
		           String stype = request.getParameter("stype");
		           
		          String[] hobby = request.getParameterValues("hobby");
		          
		              
		            String   h="";     
		          for (int i = 0; i < hobby.length; i++) {
					   h+=  ","+hobby[i];
				}
		          System.out.println( h);  
		      
		           h= h.substring(1);
		          
		        
		          
		          
		          
		        //  数据库里面存值       足球、 篮球、  排球  
		          
		          
		           
		           
		           
		           
		      //编号
		          String uid = UUID.randomUUID().toString();   
		          
		          //链接数据库  向数据库里面添加数据
		          
		            try {
						Class.forName("com.mysql.jdbc.Driver");
						//链接数据库
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1601n?characterEncoding=utf-8", "root", "root");
						PreparedStatement stmt = conn.prepareStatement("  insert  into  student  values(?,?,?,?,?,?,?)");
						stmt.setString(1, uid);
						stmt.setString(2, name);
						stmt.setString(3, pwd);
						stmt.setString(4, sex);
						stmt.setString(5, brithday);
						stmt.setString(6, stype);
						stmt.setString(7, h);
						//执行sql
						 int num = stmt.executeUpdate();
						
						if(num>0){
					       //重定向到展示功能中  为什么   你添加了数据是不是要实时查询数据
						     response.sendRedirect("chaxunliebiao");    								
						}else{							
							 request.setAttribute("adderror", "添加失败");
							  request.getRequestDispatcher("add.jsp").forward(request, response);	
						}  
						//释放资源 	`
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
		           
		           
		           
		           
		   
		   
		   
	}
	
	
	
	
	
}
