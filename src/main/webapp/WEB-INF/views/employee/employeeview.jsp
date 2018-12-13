<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
<style type="text/css">
#container {
	width: 550px;
	height: 100px;
	background: rgb(133, 120, 23);
	margin: 0px auto;
	margin-top: 50px;
}

#addTicket {
	width: 800px;
	height: 100px;
	margin: 0px auto;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div id="addTicket">
		<form action="/TicketRaise/ticket/addticketform" method="get">
			<input type="submit" value="Add Ticket" style="margin-top: 5px;" />
		</form>
		<form action="/TicketRaise/ticket/allTicketOFEmployee" method="post">
			<input type="submit" value="Show All Ticket" style="margin-top: 5px;" />
			 Filter <select name="type">
			<option value="">Select Ticket Type</option>
					<option value="Stationery Request">Stationery Request</option>
					<option value="Attendance Issue">Attendance Issue</option>
					<option value="WFH Request">WFH request</option>
					<option value="Rating Issue">Rating issue</option>
					<option value="Project Issue">Project issue</option>
					<option value="Compensation Issue">Compensation issue</option>
					<option value="Transport Complaint">Transport Complaint</option>
					<option value="Transport Request">Transport Request</option>
					<option value="Asset Request">Asset Request</option>
					<option value="Software Issue">Software issue</option>
					<option value="Hardware Issue">Hardware issue</option>
			</select>
			<select name="status">
			<option value="">Select Ticket Staus</option>
					<option value="Raised">Raised</option>
					<option value="In Progress">In Progress</option>
					<option value="Done">Done</option>
					<option value="Closed">Closed</option>
					<option value="Reopened">Reopened</option>
			</select>
			<select name="priority">
				<option value="">Select Ticket Priority</option>
					<option value="Normal">Normal</option>
					<option value="Urgent">Urgent</option>
					<option value="Immediate">Immediate</option>
				</select>
				Sort By&nbsp;&nbsp;<select name="sort">
				<option value="">Select Sort Order</option>
				<option value="TicketId">TicketId</option>
				<option value="Priority">Priority</option>
				<option value="Status">Status</option>
			</select>
		</form>
		<form action="/TicketRaise/ticket/search" method="post">
			Enter TicketId or Title &nbsp;&nbsp;<input type="text" name="pattern"
				style="margin-top: 5px;" required> </select> <input type="submit"
				value="Search" />
		</form>
	</div>
</body>
</html>