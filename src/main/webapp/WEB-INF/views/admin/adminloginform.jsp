<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>login page</title>
<style type="text/css">
#loginform {
	width: 500px;
	height: 200px;
	background: rgb(133, 120, 23);
	margin: 0px auto;
	margin-top: 100px;
}

#loginHeader {
	width: 500px;
	height: 30px;
	background: silver;
	margin: 0px auto;
	margin-top: 100px;
}

#loginFooter {
	width: 500px;
	height: 30px;
	background: silver;
	margin: 0px auto;
	margin-top: 0px;
}
</style>
</head>
<body>
	<div id="loginform">

		<div id="loginHeader">
			<p
				style="width: 200px; margin-left: 40%; margin-top: 5%; color: yellow;">
				<b>Admin Login</b>
			</p>
		</div>
		<form method="post" action="/TicketRaise/login/adminlogin">
			&nbsp;&nbsp;&nbsp;<b style="margin-left: 10%;">UserName:</b> <input
				name="adminId" type="text" name="adminName" size="50"
				style="width: 200px; margin-left: 4%; margin-top: 10%"
				required="true" /> <br> &nbsp;&nbsp;&nbsp;<b
				style="margin-left: 10%;">Password:</b> &nbsp;&nbsp;&nbsp;<input
				name="password" type="password" size="50"
				style="width: 200px; margin-left: 3%; margin-top: 3%;"
				required="true" /> <br> <input type="submit"
				style="width: 100px; margin-left: 30%; background: silver; margin-top: 3%;" />
		</form>

	</div>
</body>

</html>