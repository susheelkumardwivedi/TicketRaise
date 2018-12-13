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
	<%@ include file="employeeview.jsp"%>
	<table border=1 style="margin: 0px auto">
		<!-- iterate over the collection using forEach loop -->
		<tr>
			<th>Ticket Type</th>
			<th>Priority</th>
			<th>Title</th>
			<th>Message</th>
			<th>Date of Rase</th>
			<th>Assign To</th>
			<th>Date of Accept</th>
			<th>Date of Solve</th>
			<th>Ticket Status</th>
			<th>Attachement</th>
			<th>Comments</th>
		<tr>
			<c:forEach var="allTicket" items="${requestScope.allTicket}">
				<tr>
					<td width="12%" align="center">${allTicket.type }</td>
					<td width="10%" align="center">${allTicket.priority}</td>
					<td width="15%" align="center">${allTicket.title}</td>
					<td width="15%" align="center">${allTicket.message}</td>
					<td width="10%" align="center">${allTicket.dateOfRaise}</td>
					<td width="10%" align="center">${allTicket.assignedTo.email}</td>
					<td width="10%" align="center">${allTicket.dateofAccept}</td>
					<td width="10%" align="center">${allTicket.dateofSolve}</td>
					<td width="15%" align="center">${allTicket.status}</td>
					<td width="15%" align="center"><a
						href="/TicketRaise/ticket/getAttachement?id=${allTicket.attachement.id}">${allTicket.attachement.name}</a>
					</td>
					<td width="15%" align="center"><a
						href="/TicketRaise/comment/allcomment?id=${allTicket.id}">Comments</a>
				</tr>
				<!-- close the loop -->
			</c:forEach>
			<!-- close table -->
	</table>
</body>
</html>