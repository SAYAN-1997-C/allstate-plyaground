<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<body>
<h2> Welcome to Book Fest</h2>

<form method="post" action="savebook" modelAttribute="bookattri">
<input type="text" name="bookid" placeholder="enter bookid"><br><br>
<input type="text" name="bookname" placeholder="enter bookname">
<input type="submit">
</form>

	<table border="5">
	
	<tr>
		<td>bookid</td>
		<td>bookname</td>
	</tr>
	
	<c:forEach items="${booklist}" var="bookobj">
	 <tr>
	  <td>${bookobj.bookid}</td>
	 <td>${bookobj.bookname}</td>
	 <td><a href="deletebook?bookid=${bookobj.bookid}">Delete</a>
	
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>
