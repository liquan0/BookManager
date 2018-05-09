<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <div>
     
      <span>商品名称</span>
      <span>商品价格</span>
      <span>商品数量</span>
      <span>操作</span>
      </div>
    
    <c:forEach  items="${jihe }" var="h">
      <form action="Controller?method=add" method="post">
      <table> 
       <tr>
          <td>${h.productname }</td>
           <td>${h.price}</td>
           <td><input  type="text"  value="1"/></td>
           <td><input  type="submit"  value="添加到购物车"/></td>
       </tr>
        </table>
        </form>
    </c:forEach>  
  








</body>
</html>