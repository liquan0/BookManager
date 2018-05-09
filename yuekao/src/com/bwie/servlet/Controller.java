package com.bwie.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bwie.entity.Product;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		        String method = request.getParameter("method");
		          //判断
		          if(method!=null && !"".equals(method)){
		        	  if(method.equals("login")){
		        		  login(request,response);
		        	  }else if(method.equals("tosearch")){
		        		    searche(request,response);
		        		  
		        	  }       
		          }   
	}
    //展示查询数据
	private void searche(HttpServletRequest request,
			HttpServletResponse response) {
		
		//链接jdbc代码
		//jdbc代码
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 创建链接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1606c?characterEncoding=utf-8","root", "123456");
			// 创建预编译对象 验证 此用户是否被注册过 就要查询
			ps = conn.prepareStatement("select   *  from  product ");
			rs = ps.executeQuery();
			//调用集合
			   ArrayList<Product> list = new  ArrayList<Product>();
			//循环数据
			   while(rs.next()){
				     //调用javaBean
				      Product p = new  Product();
				       //赋值
				        p.setId(rs.getInt(1));
				        p.setProductname(rs.getString(2));
				        p.setPrice(rs.getInt(3));
				        //向集合中添加数据
				          list.add(p);  
			   }
			   //向作用域中存值
			     request.setAttribute("jihe", list);
				// 转发
				request.getRequestDispatcher("show.jsp").forward(request,response);
			}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		
		
		
		
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		   //获取参数
		//设置编码
		  req.setCharacterEncoding("utf-8");
		   resp.setCharacterEncoding("utf-8");
		   
		   String name = req.getParameter("name");
		   String uname = new String(name.getBytes("ISO-8859-1"), "utf-8");
		   String pwd = req.getParameter("pwd");
		   String password = new  String( pwd.getBytes("ISO-8859-1"),"utf-8");
		   
		   //jdbc代码
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// 创建链接
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1606c?characterEncoding=utf-8","root", "123456");
				// 创建预编译对象 验证 此用户是否被注册过 就要查询
				ps = conn.prepareStatement("select   *  from  user  where  name=? and password=? ");
				// 赋值
				ps.setString(1, uname);
				ps.setString(2, password);
				// 执行sql语句
				rs = ps.executeQuery();
				// 判断
				if (rs.next()) {
					// 获取session
					HttpSession session = req.getSession();
					// 向session 中存值
					session.setAttribute("username", name);
					// 重定向
					resp.sendRedirect("Controller?method=tosearch");
				} else {
					// 提示
					req.setAttribute("logerror", "登陆失败用户名或密码错误");
					// 转发
					req.getRequestDispatcher("login.jsp").forward(req,resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		   
		   
		   
		 
		   
	}

}
