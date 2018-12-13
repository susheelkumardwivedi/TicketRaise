<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>${message}</h3>
	<table border=1 style="margin: 0px auto;">
		<tr>
			<th>Comment Message</th>
			<th>Date of Comment</th>
			<th>Commented By</th>
		</tr>
		<c:forEach var="allComment" items="${requestScope.allComment}">
			<tr>
				<td width="12%" align="center">${allComment.message }</td>
				<td width="10%" align="center">${allComment.timeOfComment}</td>
				<td width="10%" align="center">${allComment.dateOfCommnet}</td>
				<td width="15%" align="center">${allComment.user.email}</td>
			</tr>
			<!-- close the loop -->
		</c:forEach>
		<!-- close table -->
	</table>
	<form action="/TicketRaise/comment/addcomment?ticket_id=${ticket_id }"
		method="post">
		<input type="text" name="message"
			style="width: 500px; margin-top: 10px; margin-left: 50px;"> <input
			type="submit" value="Add Comment">
	</form>
</body>
</html>