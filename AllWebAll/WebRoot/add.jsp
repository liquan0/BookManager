<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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

  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script></head>
  
  <body>
  
         <!-- 添加的表单 -->
  
    <hr  style="margin-top: 5%;margin-bottom: 2%">
    
      <form action="addservlet"  method="post">
         <table  border="1" cellpadding="0" cellspacing="0" align="center" style="margin-top: 4%">
            <tr>
              <td>用户名</td><td><input  type="text"  name="username"/></td> 
            </tr>
            <tr>
                     <td> 密码</td>
                     <td><input type="password" name="password"/></td>
            
            </tr>
         
         <tr>
           <td>性别</td> <td><input  type="radio" name="sex" value="男"/>男  &nbsp; &nbsp;<input  type="radio" name="sex" value="女"/> 女 </td>
         </tr>
         
         <tr>    <!--onclick  点击  事件  -->
           <td>生日</td><td><input  type="text"  name="brithday"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  /></td>
         </tr>
         <tr>
          <td> 学历   </td>  
          <td>
            <select name="stype">
               <option selected="selected">====请选择====</option>
               <option selected="selected">大学生 </option>
               <option selected="selected">高中生</option>
               <option selected="selected">初中生</option> 
            </select>
          
          </td>
         </tr>
         
         <tr>
            <td>爱好</td>
         
           <td>
              <input  type="checkbox"    name="hobby"   value="足球">足球 &nbsp;
              <input  type="checkbox"    name="hobby"   value="篮球">篮球 &nbsp;
              <input  type="checkbox"    name="hobby"   value="排球">排球 &nbsp;
              <input  type="checkbox"    name="hobby"   value="乒乓球">乒乓球 &nbsp;
           </td>
         
         </tr>
        <tr>
           <td><input  type="submit" value="添加"/>  &nbsp;  <input  type="reset" value="重置"/></td>
        
        </tr> 
         
         
         
         </table>
      
      
      
      
      
      </form>
  
  
  
  
  
  
  
  
  
  
  </body>
</html>
