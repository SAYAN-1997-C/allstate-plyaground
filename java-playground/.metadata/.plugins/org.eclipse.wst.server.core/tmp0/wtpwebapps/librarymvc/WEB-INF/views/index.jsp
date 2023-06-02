<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<body>
<h2>Welcome to Book Fest!!!!</h2>

<form method="post" action="savebook" modelAttribute="bookattri">
<input type=text name="bookid" placeholder="enter bookid"/> <br>
<input type=text name="bookname" placeholder="enter bookname"/> <br>
<input type=submit>

</form>


	${status}


</body>
 
