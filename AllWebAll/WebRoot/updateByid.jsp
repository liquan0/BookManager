<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateByid.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script></head>
  
  <body>
   
        <form action="toupdate" method="post">
            <table>
            
              <tr>
                <td>
                  <input type="hidden"  name="id"  value="${st.id }"/>
                </td>
              </tr>
             <tr>
               <td>用户名</td><td><input type="text"  name="username"  value="${st.name }"/></td>
             </tr>
              <tr>
               <td>密码</td><td><input type="text"  name="pwd" value="${st.password }"/></td>
             </tr>
              <tr>     
               <td>性别</td><td><input type="radio"  name="sex"      ${st.sex=="男"? "checked":"" }     value="男"/> 男 &nbsp;<td><input type="radio"  name="sex"  ${st.sex=="女"? "checked":"" }     value="女"/> 女</td>
             </tr>
              <tr>
               <td>日期</td><td><input type="text"  name="brithday"  value="${st.brithday}"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
             </tr>
              <tr>
               <td>学历</td>
               <td>
                 <select  name="stype"> 
                    <option    ${st.stype=="大学生"? "selected='selected'":"" }    value="大学生" >大学生</option>
                    <option    ${st.stype=="小学生"? "selected='selected'":"" }    value="初中生" >初中生</option>
                    <option    ${st.stype=="中学生"? "selected='selected'":"" }    value="小学生" >小学生 </option>
                 </select>
               </td>
             </tr>
             <tr>
               <td>
                                   爱好
               </td>
               <td>
                  <input  type="checkbox"    <c:if test="${fn:contains(st.hobby,'足球')}"> checked</c:if> name="hobby" value="足球"> 足球 &nbsp;
                  <input  type="checkbox"    <c:if test="${fn:contains(st.hobby,'篮球')}"> checked</c:if> name="hobby" value="篮球"> 篮球 &nbsp;
                  <input  type="checkbox"    <c:if test="${fn:contains(st.hobby,'排球')}"> checked</c:if> name="hobby" value="排球"> 排球 &nbsp;
                  <input  type="checkbox"    <c:if test="${fn:contains(st.hobby,'乒乓球')}"> checked</c:if> name="hobby" value="乒乓球"> 乒乓球 &nbsp;
                  
               </td>
             </tr>
             <tr>
               <td colspan="2">  <input  type="submit" value="确认修改"/> &nbsp;&nbsp;&nbsp;<a href="chaxunliebiao">  <input type="button" value="返回" /></a> </td>  <!--  -->
             </tr>
            </table>
        </form>

  </body>
</html>
