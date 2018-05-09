<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  contentType="text/html; charset=utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib    uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
	
	</script>
	
	
	
<style type="text/css">

  a{text-decoration: none;}


</style>

  </head>
  
  <body>
    <%-- <c:if test="${empty  sessionScope.name}"> ${name}   </c:if> --%>
      
        <%--  ${fn:contains("Tomcat",'Tomcat') }  --%>
         
          ${fn:containsIgnoreCase("TomCat",'c') }
         
   
      
      
      <%--  ${fn:contains("tomcat","cat") }
       ${fn:containsIgnoreCase("Tomcat",'TOMCA') } --%>
       
       
       
   
   
       <%
          HttpSession  sessions=  request.getSession();
           String   name=(String) sessions.getAttribute("unames");
           
             if(name!=null){
              out.print(name);
             
             }else{
                request.setAttribute("chaoshiname", "会话超时，请您去登陆");
             
             
             }
        %>
   
      ${chaoshiname }
      
   欢迎您  &nbsp;    ${unames }  登陆
           <table   border="1" cellpadding="0" cellspacing="0">
             <tr>
               <td>编号</td>
               <td>名称</td>
               <td>密码</td>
               <td>性别</td>
               <td>生日</td>
               <td>学历</td>
               <td>爱好</td>
               <td>操作  【<a   style="text-decoration: none;" href="add.jsp">添加</a>】    </td>

             </tr>
             <c:forEach   items="${jihe}" var="j"  varStatus="v"    begin="2"   step="1"  end="4">
                 <tr>
                  <td>${v.index}</td>
                  <%--  <td>${j.id}</td>   --%>
                   <td>${j.name}</td>
                   <td>${j.password}</td>
                   <td>${j.sex}</td>
                    <td>${j.brithday }</td>
                   <td>${j.stype}</td>
                   <td>${j.hobby }</td>
                   <td>
                      <a href="updateByid?id=${j.id }">修改</a> 
                    <!--  <a href="updateByid.jsp">修改</a>  -->
                      <a  href="deleteByid?ids=${j.id}"> <input  type="button"  value="删除"/></a>              
                   </td>      
                 </tr>  
             </c:forEach>
    
           </table>
  </body>
</html>
