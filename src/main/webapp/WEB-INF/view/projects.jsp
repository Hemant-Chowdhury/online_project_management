<%@ include file="common/header.jsp"%>
<title>Projects</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>

<div
	style="width: 80%; float: left; padding: 10px; height: 100%; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">Projects</h1>

	</div>
	<div
		style="width: 99%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 10px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Projects Created
				by you:</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<c:forEach items="${owned}" var="project">
				<div
					style="border-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; border: 1px solid #ddd; background-color: #f5f5f5; padding: 5px; margin-top: 10px; width: 100%; float: left;">
					<h3 style="margin: 3px;">
						<a href="/projects/moreInfo?projectId=${project.getProjectId()}">${project.getProjectName()}</a>
						<form action="/projects/moreInfo?projectId=${project.getProjectId()}" method="post"
							style="float: right; width: auto; height: auto;">
							<button type="submit" class="btn btn-default"
								style="border: 0px; border-radius: 4px; -webkit-font-smoothing: antialiased; font-weight: bold; padding: 4px; margin-right: 10px; vertical-align: middle; text-align: center; background-color: #3367d6; color: rgb(255, 255, 255); width: auto; float: right;">More
								Info</button>
						</form>
						<form action="/projects/delete?projectId=${project.getProjectId()}" method="post"
							style="float: right; width: auto; height: auto;">
							<button type="submit" class="btn btn-default"
								style="border: 0px; border-radius: 4px; -webkit-font-smoothing: antialiased; font-weight: bold; padding: 4px; margin-right: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: auto; float: right;">Delete</button>
						</form>
					</h3>
				</div>
				<div
					style="border-radius: 5px; border-top-right-radius: 0px; border-top-left-radius: 0px; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; border-left: 1px solid #ddd; padding: 5px; display: block;">
					<p>${project.getDescription()}</p>
				</div>
			</c:forEach>
		</div>
	</div>
	<div
		style="width: 99%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 10px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Projects Managed
				by you:</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<c:forEach items="${managed}" var="project">
				<div
					style="border-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; border: 1px solid #ddd; background-color: #f5f5f5; padding: 5px; margin-top: 10px; width: 100%; float: left;">
					<h3 style="margin: 3px;">
						<a href="/projects/moreInfo?projectId=${project.getProjectId()}">${project.getProjectName()}</a>
						<form action="/projects/moreInfo?projectId=${project.getProjectId()}" method="post"
							style="float: right; width: auto; height: auto;">
							<button type="submit" class="btn btn-default"
								style="border: 0px; border-radius: 4px; -webkit-font-smoothing: antialiased; font-weight: bold; padding: 4px; margin-right: 10px; vertical-align: middle; text-align: center; background-color: #3367d6; color: rgb(255, 255, 255); width: auto; float: right;">More
								Info</button>
						</form>
						<form action="/projects/delete?projectId=${project.getProjectId()}" method="post"
							style="float: right; width: auto; height: auto;">
							<button type="submit" class="btn btn-default"
								style="border: 0px; border-radius: 4px; -webkit-font-smoothing: antialiased; font-weight: bold; padding: 4px; margin-right: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: auto; float: right;">Delete</button>
						</form>
					</h3>
				</div>
				<div
					style="border-radius: 5px; border-top-right-radius: 0px; border-top-left-radius: 0px; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; border-left: 1px solid #ddd; padding: 5px; display: block;">
					<p>${project.getDescription()}</p>
				</div>
			</c:forEach>
		</div>
	</div>

	<div
		style="width: 99%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 10px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Projects Developed
				by you:</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<c:forEach items="${developed}" var="project">
				<div
					style="border-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; border: 1px solid #ddd; background-color: #f5f5f5; padding: 5px; margin-top: 10px; width: 100%; float: left;">
					<h3 style="margin: 3px;">
						<a href="/projects/moreInfo?projectId=${project.getProjectId()}">${project.getProjectName()}</a>
						<form action="/projects/moreInfo?projectId=${project.getProjectId()}" method="post"
							style="float: right; width: auto; height: auto;">
							<button type="submit" class="btn btn-default"
								style="border: 0px; border-radius: 4px; -webkit-font-smoothing: antialiased; font-weight: bold; padding: 4px; margin-right: 10px; vertical-align: middle; text-align: center; background-color: #3367d6; color: rgb(255, 255, 255); width: auto; float: right;">More
								Info</button>
						</form>
						<form action="/projects/delete?projectId=${project.getProjectId()}" method="post"
							style="float: right; width: auto; height: auto;">
							<button type="submit" class="btn btn-default"
								style="border: 0px; border-radius: 4px; -webkit-font-smoothing: antialiased; font-weight: bold; padding: 4px; margin-right: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: auto; float: right;">Delete</button>
						</form>
					</h3>
				</div>
				<div
					style="border-radius: 5px; border-top-right-radius: 0px; border-top-left-radius: 0px; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; border-left: 1px solid #ddd; padding: 5px; display: block;">
					<p>${project.getDescription()}</p>
				</div>
			</c:forEach>
		</div>
	</div>


<!-- ADD BUTTON -->
<button type="submit" class="btn btn-primary"
	style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 10%;"
	onclick="document.getElementById('form').style.display='block'">Add</button>

<div id="form" class="panel panel-default"
	style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 25px; display: none;">

	<form:form action="/projects?add=true" method="post"
		commandName="project">
		<center>
			<div class="form-group" style="margin-top: 40px;">
				<label for="projectName">Project Name:</label>
				<form:input path="projectName" type="text" class="form-control"
					id="projectName" placeholder="Enter Project Name" name="projecName"
					style="width: 60%;" required="required" />
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