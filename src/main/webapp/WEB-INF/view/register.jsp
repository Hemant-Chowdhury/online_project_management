<%@ include file="common/header.jsp"%>
<title>Registration</title>
<div class="container-fluid"
	style="background-image: url('Elegant_Background-18.jpg'); height: 750px;">

	<div class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 125px;">
		<h2 style="text-align: center;">REGISTER</h2>
		<hr style="background-color: gray; width: 100%; height: 1px;">

		${message}
		
		<form:form action="/register" method="post" commandName="user">
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="username">Create Username:</label>
					<form:input path="username" type="text" class="form-control"
						placeholder="Enter username" name="username" style="width: 60%;"
						required="required" />
					<form:errors path="username" cssClass="text-warning" />
				</div>
			</center>
			
			<center>
				<div class="form-group">
					<label for="pwd">Create Password:</label>
					<form:input path="password" type="password" class="form-control"
						id="pwd" placeholder="Enter password" name="password"
						style="width: 60%;" required="required" />
					<form:errors path="password" cssClass="text-warning"></form:errors>
				</div>
			</center>
			
			<center>
				<div class="form-group">
					<label for="name">Name:</label>
					<form:input path="name" type="text" class="form-control"
						id="name" placeholder="Enter full name" name="name"
						style="width: 60%;" required="required" />
					<form:errors path="name" cssClass="text-warning"></form:errors>
				</div>
			</center>
			
			<center>
				<div class="form-group">
					<label for="email">Email:</label>
					<form:input path="email" type="email" class="form-control"
						id="email" placeholder="Enter valid email" name="email"
						style="width: 60%;" required="required" />
					<form:errors path="email" cssClass="email-warning"></form:errors>
				</div>
			</center>
			
			<center>
				<div class="form-group">
					<label for="cmp">Company:</label>
					<form:input path="company" type="text" class="form-control"
						id="cmp" placeholder="Enter company name" name="company"
						style="width: 60%;" required="required" />
					<form:errors path="company" cssClass="text-warning"></form:errors>
				</div>
			</center>

			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(100,189,22); color: rgb(255, 255, 255); width: 60%;">Register</button>
		</form:form>
		
		<form action="/login">
			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230,0,35); color: rgb(255, 255, 255); width: 60%;">Cancel</button>
		</form>
	</div>

</div>




<%@ include file="common/footer.jsp"%>