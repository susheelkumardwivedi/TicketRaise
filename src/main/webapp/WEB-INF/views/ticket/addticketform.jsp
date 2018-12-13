<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="../employee/employeeview.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add ticket</title>
<style type="text/css">
#formposition {
	width: 600px;
	height: 400px;
	margin: 0px auto;
}
</style>
</head>
<body>
<h4 style="margin-left: 530px;">${message}</h4>
<h3 style="margin-left: 530px;">Add Ticket</h3>
<div id="formposition">

<form action="/TicketRaise/ticket/add" method="post" enctype="multipart/form-data">
Select Ticket *&nbsp;&nbsp;&nbsp;<select name="type">
<option value="Stationery Request">Stationery Request</option>
<option value="Attendance Issue">Attendance Issue</option>
<option value="WFH request">WFH request</option>
<option value="Rating issue">Rating issue</option>
<option value="Project issue">Project issue</option>
<option value="Compensation issue">Compensation issue</option>
<option value="Transport Complaint">Transport Complaint</option>
<option value="Transport Request">Transport Request</option>
<option value="Asset Request">Asset Request</option>
<option value="Software issue">Software issue</option>
<option value="Hardware issue">Hardware issue</option>
</select><br>
Select Priority *&nbsp;&nbsp;&nbsp;<select name="priority" style="margin-top: 5px;">
<option value="Normal">Normal</option>
<option value="Urgent">Urgent</option>
<option value="Immediate">Immediate</option>
</select><br>
Title *&nbsp;&nbsp;&nbsp;<input type="text" name="title" style="width: 500px;margin-top: 5px;" required/>
<textarea name="message" style="width:550px; height:250px;margin-top: 5px;">
Message
</textarea>
<br>Attachement &nbsp;&nbsp;&nbsp;<input
				type="file" name="attachement"
				style="margin-top: 5px; background-color: cyan; width: 75%;" /><br>
<input type="submit" value="Add Ticket" style="margin-left: 180px;margin-top: 10px;">
</form>
</div>
</body>
</html>