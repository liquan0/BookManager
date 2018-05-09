<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <%-- <%
  
     Cookie[]   c=  request.getCookies();
     
       for( Cookie  co:c){
           if("username".equals(co.getName())){
              String   cname=  URLDecoder.decode(co.getValue(),"utf-8");
                request.setAttribute("uname", cname);
                  System.out.print(cname+"  用户名是");
           }
          
          if("upassword".equals(co.getName())){
          
             String cpwd=   URLDecoder.decode(co.getValue(),"utf-8");
             request.setAttribute("cpwd", cpwd);
               System.out.print(cpwd+"   密码是");    
          }          
        }

   %>
   --%>
   
   <%
           //获取 cookie对象
            Cookie[]   cos=request.getCookies();            
              if(cos!=null){
                   for(Cookie  c:cos){
                          if("username".equals(c.getName())){
                          //解码
                              String   name  = URLDecoder.decode(c.getValue(), "utf-8");
                              request.setAttribute("names", name);
                          }                             
                         if("password".equals(c.getName())){
                              String   password=     URLDecoder.decode(c.getValue(), "utf-8");
                             request.setAttribute("pwds", password);
                         }
                   }

              }   
    %>
   
  <body>
      ${error }
          <form action="login"  method="post">
                           用户名：<input  type="text"  name="username"    value="${names }"  /><br>
                             密码：<input  type="text" name="password" value="${pwds}" /><br> 
              <input  type="checkbox"   name="iscookie" value="binggan" />七天免登陆           
              <input  type="submit" value="登陆"/>  &nbsp;<a  href="reg.jsp"><input type="button"   value="注册"/></a> 
          </form>  

  </body>
</html>
