package com.bwie.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	

	        protected void service(HttpServletRequest  request , HttpServletResponse response)
	        		throws ServletException, IOException {
	        	//处理乱码
	        	  request.setCharacterEncoding("utf-8");
	        	  response.setCharacterEncoding("utf-8");
                //获取表单的数据
	        	  String name = request.getParameter("username");
	        	  System.out.println(name);
	        	    String pwd = request.getParameter("password");
	        	    
	        	   //获取  cookie   获取的是您的  做的 那个标记    问问你是否选中了 七天免登陆
	        	     String ck = request.getParameter("iscookie"); 
	        	      //判断  ck里面是否有值
	        	      if(ck!=null){	   
	        	    Cookie    names= new   Cookie("username", URLEncoder.encode(name,"utf-8" ));
	        	    Cookie    pwds=  new   Cookie("password",URLEncoder.encode(pwd, "UTF-8"));
	        	    
	        	            names.setMaxAge(60*60*24*7);
	        	            pwds.setMaxAge(60*60*24*7);
	        	            //响应到浏览器中
	        	            response.addCookie(names);
	        	            response.addCookie(pwds);
	        	      } 

	        	      
	        	   /* 
	        	    String[] ck = request.getParameterValues("iscookie");   

	        	        if(ck!=null){
	        	        //调用  cookie  对象
	        	          Cookie  uname = new   Cookie("username", URLEncoder.encode(name, "utf-8"));
	        	          Cookie upwd = new  Cookie("upassword",URLEncoder.encode(pwd, "utf-8"));	        
	        	          //cookie   这个对象的生命周期特点：  瞬时
	        	                uname.setMaxAge(60);               //单位是秒   
	        	                upwd.setMaxAge(90);
	        	               // 响应到浏览器中
	        	             response.addCookie(upwd); 
	        	             response.addCookie(uname);
	        	        	
	        	        }*/
	        	  
	              //链接数据库
	        	      try {
						Class.forName("com.mysql.jdbc.Driver");
						 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1601n?characterEncoding=utf-8", "root", "root");
						  PreparedStatement stmt = conn.prepareStatement("select  *  from  student   where   name=? and password=?");
						  stmt.setString(1, name);
						  stmt.setString(2, pwd);
						  ResultSet rs = stmt.executeQuery();						  
						  if(rs.next()){ 
							  System.out.println("登陆成功"); 							  
							      HttpSession session = request.getSession();						  
							     session.setAttribute("unames", name);
							       session.setMaxInactiveInterval(10);    //一分钟       默认是30 分钟   
						  //  重定向
							    response.sendRedirect("chaxunliebiao");
  
						  }else{ 
							  request.setAttribute("error", "登陆失败");  
							  request.getRequestDispatcher("login.jsp").forward(request, response);  
							  
						  }
	
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	
	        	      
	        	      
	        	      
	        }
	
	 
	
	        
	        
	        
	        
	        
	        

}
