<%@ include file="common/header.jsp"%>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>
<title>Profile of ${username}</title>
<div
	style="width: 80%; float: left; padding: 10px; height: 100%; background-color: white;">
	<div style="width: 100%; float: left;">
	
		<h1 class="heading">Profile</h1>
			
	</div>
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
	<center>
		<div class="card" style="width: 250px; margin-top: 10px;">
			<img class="card-img-top" src="${pageContext.request.contextPath}${user.image}" alt="Card image">
			<div class="card-body">
				<form action="profile/upload-image?username=${username}" method="post" enctype="multipart/form-data">
					<h4>Select Image to Upload:</h4>
					<input type="file" name="fileToUpload" id="fileToUpload"
						style="margin-top: 10px;"><br> <input type="submit"
						value="Upload Image" name="submit" class="btn btn-success">
					
				</form>

			</div>

		</div>
	</center>
	<div class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; width: 40%; margin: auto; min-height: initial; float: left; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 30px; padding-top: 20px; margin: 50px; margin-top: 10px; height: 60%">
		<h4>Profile Details:</h4>
		
		<form:form action="/profile/updateProfile" method="post" commandName="user">
			<div class="form-group">
				<label for="username">Username:</label> <form:input path="username" type="text"
					class="form-control" disabled="true"/>
			</div>
			<div class="form-group">
				<label for="name">Name:</label> <form:input path="name" type="text"
					class="form-control" id="name"/>
				<form:errors path="name" cssClass="text-warning" />
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <form:input path="email" type="email"
					class="form-control" id="email"/>
				<form:errors path="email" cssClass="email-warning" />
			</div>
			<div class="form-group">
				<label for="company">Company:</label> <form:input path="company" type="text"
					class="form-control" id="company"/>
				<form:errors path="company" cssClass="text-warning" />
			</div>
			<button type="submit" class="btn btn-success"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 60%;">Update</button>
			
		</form:form>
	</div>

	<div class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; width: 400px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 30px; float: left; padding-top: 20px; margin: 30px; margin-top: 10px; height: 60%;">
		<h4>Update Password:</h4>
		
		<form action="/profile/updatePassword" method="post">
		
			<div class="form-group">
				<label for="o_password">Old Password:</label> <input name="oldPassword" type="password"
					class="form-control" id="o_pass">
			</div>
			<div class="form-group">
				<label for="n_password">New Password:</label> <input name="newPassword" type="password"
					class="form-control" id="n_pass">
			</div>
			
			
			<button type="submit" class="btn btn-success"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 110px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 60%;">Update</button>

		</form>
	</div>

</div>

		
		<%
		
	    String error = (String) request.getAttribute("errorMessage");
	    if (error != null && error.equals("true"))
	    {
	        out.println("<script>window.alert(error)</script>");
	    }
	    
	    String success = (String) request.getAttribute("successMessage");
	   
	    if (success != null && success.equals("true"))
	    {
	        out.println("<script>window.alert(success)</script>");
	    }
	     
		%>

<%@ include file="common/footer.jsp"%>





