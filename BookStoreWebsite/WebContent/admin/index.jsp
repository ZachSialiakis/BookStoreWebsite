<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bookstore Administration</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageheading">Administrative Dashboard</h2>
	</div>


	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Quick Actions:</h2>
		<b> <a href="create book">New Book</a> &nbsp; <a
			href="create user">New User</a> &nbsp; <a href="create category">New
				Category</a> &nbsp; <a href="create customer">New Customer</a> &nbsp;
		</b>
	</div>

	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Recent Sales:</h2>
	</div>
	<div align="center">

		<h2 class="pageheading">Recent Reviews:</h2>
	</div>
	<div align="center">

		<h2 class="pageheading">Statistics:</h2>
		<hr width="60%" />
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>