<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>${title}</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="head">
		<div class="home">
			<a href="home.html" style="color: black; text-decoration-line: none;"><font
				size="5" style="padding: 10px;">Home</font></a>
		</div>


		<div class="dropdown"
			style="float: right; margin-top: 10px; margin-right: 50px;">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown">
				<span class="glyphicon glyphicon-user"></span>
			</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">Link 1</a> <a
					class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
					href="#">Link 3</a>
			</div>
		</div>
		<div class="dropdown"
			style="float: right; margin-top: 10px; margin-right: 20px;">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown">
				<span class="glyphicon glyphicon-bell"></span>
			</button>
			<div class="dropdown-menu">
				<div class="panel-heading">Notifications</div>
				<div class="panel-body">
					<ul>
						<li class="dropdown-item">First item</li>
						<li class="dropdown-item">Second item</li>
						<li class="dropdown-item">Third item</li>
					</ul>
				</div>
			</div>
		</div>

	</div>