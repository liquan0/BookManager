<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     
        <!-- 注册 -->
         <form action="regservlet" method="post">
            
          <table  border="1" cellpadding="0" cellspacing="0" align="center" style="margin-top: 4%">
            <tr>
              <td>用户名</td><td><input  type="text"  name="username"/> &nbsp;  <span style="font: 14px;color: red;">  ${regerror }  </span> </td> 
            </tr>
            <tr>
               <td> 密码</td>
               <td><input type="password" name="password"/></td>
            </tr>
         
         <tr>
           <td>性别</td> <td><input  type="radio" name="sex" value="男"/>男  &nbsp; &nbsp;<input  type="radio" name="sex" value="女"/> 女 </td>
         </tr>
         
         <tr>
           <td>生日</td><td><input  type="text"  name="brithday"/></td>
         </tr>
        
        <tr>
           <td><input  type="submit" value="添加"/>  &nbsp;  <input  type="reset" value="重置"/></td>
        
        </tr> 
         </table>
         </form>
     
     
     
     
     
     
     
  </body>
</html>
