<%@ include file="common/header.jsp"%>
<title>Projects</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>

<div
	style="width: 80%; float: left; padding: 10px; height: 800px; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">Projects</h1>

	</div>
	<div>
	<h3>Projects owned</h3>
		${view1}
	</div>
	<br/>
	<div>
	<h3>Projects Managed</h3>
		${view2}
	</div>
	<br/>
	<div>
	<h3>Projects Developed</h3>
		${view3}
	</div>


	<!-- ADD BUTTON -->
	<button type="submit" class="btn btn-primary"
		style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 10%;"
		onclick="document.getElementById('form').style.display='block'">Add</button>

	<div id="form" class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 25px; display: none;">

		<form:form action="/user/projects?add=true" method="post"
			commandName="project">
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="projectName">Project Name:</label>
					<form:input path="projectName" type="text" class="form-control"
						id="projectName" placeholder="Enter Project Name"
						name="projecName" style="width: 60%;" required="required" />
					<form:errors path="projectName" cssClass="text-warning" />
				</div>
			</center>
			<center>
				<div class="form-group">
					<label for="comment">Description:</label>
					<form:textarea path="description" class="form-control" rows="5"
						id="comment" style="resize: none;" required="required"></form:textarea>
					<form:errors path="description" cssClass="text-warning" />
				</div>
			</center>

			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: 60%;">Submit</button>


		</form:form>
	</div>





</div>


<%@ include file="common/footer.jsp"%>