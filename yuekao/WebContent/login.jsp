<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript">
<%--      function reg() {
    	    alert("注册");
    	    location.href="<%=request.getContextPath()%>/add.jsp;
	} --%>
  </script> 


</head>
<body>

${logerror }
     <form action="Controller?method=login"  method="post"  >
       用户名： <input  type="text"  name="name"/> <br>
       密码：  <input  type="password"  name="pwd"/> <br>
        <input  type="submit"  value="登陆"/>   <input  type="button" value="注册"   onclick="reg()"/>
     </form>

</body>

</html>
