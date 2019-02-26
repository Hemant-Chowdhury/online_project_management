<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:include="layout :: head(title=~{::title},links=~{})">

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

<title>Please Login</title>
<div class="container-fluid"
	style="background-image: url(${pageContext.request.contextPath}/resources/images/background1.jpg) ; height: 750px;">

	<div class="panel panel-default"
style="background-color: rgba(255, 255, 255, 0.76);border-radius: 8px;position: relative;text-align: center;width: 440px;margin: auto;min-height: initial;box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px;padding: 55px;padding-top: 20px;margin-top: 125px;"/>		
		<h2 style="text-align: center;">LOGIN</h2>
		<hr style="background-color: gray; width: 100%; height: 1px;">
		
		${message}
				
		<form action="/login" method="post">
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="username">Username:</label> <input type="text"
						class="form-control" placeholder="Enter username" name="username"
						style="width: 60%;"></input>
				</div>
			</center>
			<center>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" placeholder="Enter password"
						name="password" style="width: 60%;">
				</div>
			</center>
			<div class="checkbox">
				<label><input type="checkbox" name="remember">
					Remember me</label>
			</div>
			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: 60%;">Login</button>

		</form>
		<form action="/register">
			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(66, 133, 244); color: rgb(255, 255, 255); width: 60%;">Register</button>
		</form>

		</form>
		<form action="/guest/login">
			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(100, 189, 22); color: rgb(255, 255, 255); width: 60%;">Login
				as Guest</button>
		</form>
	</div>
</div>

<%@ include file="common/footer.jsp"%>



