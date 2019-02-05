<%@ include file="common/header.jsp"%>
<div class="container-fluid"
	style="background-image: url('Elegant_Background-18.jpg'); height: 750px;">


	<div class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 125px;">
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
		<form action="/guest-login">
			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(100, 189, 22); color: rgb(255, 255, 255); width: 60%;">Login
				as Guest</button>
		</form>
	</div>
</div>

<%@ include file="common/footer.jsp"%>



