<%@ include file="common/header.jsp"%>
<title>Projects</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/taskNav.jsp"%>

<div
	style="width: 90%; float: left; padding: 10px; height: 800px; background-color: white; height: 100%;">
	<div style="width: 100%; float: left;">

		<div class="dropdown"
			style="float: left; margin-top: 5px; margin-right: 10px; width: auto;">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">TASKS</button>
			<ul class="dropdown-menu">
				<c:forEach var="tasks" items="${tasks}">
					<li><a
						href="${pageContext.request.contextPath}/changeTask?taskId=${tasks.getTaskId()}">${tasks.getTaskName()}</a></li>
				</c:forEach>
			</ul>

		</div>


	</div>
	<h1 class="heading"
		style="float: left; margin-left: 0px; margin-right: 15px; width: auto; float: left;">
		Task Name : ${task.getTaskName()}</h1>
	<h1 class="heading"
		style="float: left; margin-right: 15px; width: auto;">Milestone
		Name : ${milestone.getMilestoneName() }</h1>
	<h1 class="heading"
		style="float: left; margin-right: 0px; width: auto;">Status :</h1>
	<h4 class="heading" style="float: left; margin-right: 0px; width: 12%">
		<c:choose>
			<c:when test="${ task.getStatus()=='completed'}">
				<button class="btn btn-success"
					style="border: 0px; height: 28px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 10px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 6px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 60%;">
					Completed</button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-warning"
					style="border: 0px; height: 28px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 10px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 6px; vertical-align: middle; text-align: center;; color: rgb(255, 255, 255); width: 60%;">
					Open</button>
			</c:otherwise>
		</c:choose>
	</h4>

	<h4 class="heading"
		style="margin-right: 0px; margin-top: 0px; margin-bottom: 10px; width: 25%;">
		<c:choose>
			<c:when test="${ task.getStatus()=='completed'}">
				<form action="/task/changeStatus" method="post">
					<button type="submit" class="btn btn-warning"
						style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 0px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 60%;">
						Mark as open</button>
				</form>
			</c:when>
			<c:otherwise>
				<form action="/task/changeStatus" method="post">
					<button type="submit" class="btn btn-success"
						style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 0px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center;; color: rgb(255, 255, 255); width: 60%;">
						Mark as completed</button>
				</form>
			</c:otherwise>
		</c:choose>
	</h4>
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
	<div
		style="width: 32%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Task Participants</h4>

		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div
			style="height: 405px; width: 100%; padding: 0px; float: left; overflow-y: auto;">
			<ul>
				<c:forEach var="user" items="${participants}">
					<li class="list-group-item" style="margin: 2px; height: auto;">
						<img src="${pageContext.request.contextPath}${user.getImage()}"
						alt="default" style="width: 10%; height: 30px; margin-top: 4px;">
						${user.getName()} <a
						href="/task/removeParticipant?username=${user.getUsername()}"
						style="float: right; padding: 0px;"><button type="button"
								class="btn btn-danger">Remove</button></a>
					</li>
				</c:forEach>
			</ul>


		</div>
		<div class="dropdown"
			style="float: left; margin-top: 5px; margin-right: 5px; width: auto;">
			<button class="btn btn-warning dropdown-toggle" type="button"
				data-toggle="dropdown">ADD PARTICIPANT</button>
			<ul class="dropdown-menu">
				<c:forEach var="user" items="${newParticipants}">
					<li><a
						href="/task/addParticipant?username=${user.getUsername()}"> <img
							src="${pageContext.request.contextPath}${user.getImage()}"
							alt="default" style="width: 20%; height: 20px; margin-top: 4px;">
							${user.getName()}
					</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div
		style="width: 32%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Project Details</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<ul>
				<li class="list-group-item" style="margin: 2px;"><b>Start
						Date:</b> ${task.getStartDate()}</li>
				<li class="list-group-item" style="margin: 2px;"><b>End
						Date:</b> ${task.getEndDate()}</li>
				<li class="list-group-item" style="margin: 2px;"><b>Days
						Left:</b> ${daysLeft}</li>
				<li class="list-group-item" style="margin: 2px;"><div
						class="form-group">
						<label for="comment">Project Description:</label>
						<textarea class="form-control" rows="18" id="comment"
							style="border-radius: 1px; resize: none;" disabled>${task.getDescription()}</textarea>
					</div></li>
			</ul>
		</div>



	</div>

	<div>
		<div
			style="width: 32%; float: left; padding: 10px; height: 500px; background-color: #ddd; margin: 5px; overflow-y: auto;">
			<div style="width: 100%; float: left;">
				<h4 class="heading" style="margin-left: 0px;">Forum</h4>
			<hr class="hr"
				style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">

				
				<div id="displayarea" name="displayarea"></div>
			</div>
			<hr class="hr"
				style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">








			<script type="text/javascript">
				var url = '/task/getChat'

				$(document).ready(function() {

					$.ajaxSetup({
						cache : false
					});

					setInterval(function() {
						$("#displayarea").load(url);
					}, 1000);

				});
			</script>


			<form method="post" action="/task/sendMessage"
				style="float: right; float: down; width: 100%; margin-right: 0px;">

				<div class="input-group" style="margin-top: 3px;">

					<textarea id="message" name="message" class="form-control" rows="0"
						style="border-radius: 10px; margin-top: 5px; margin-left: -6px; resize: none;"></textarea>
					<button class="btn btn-success"
						style="width: 12%; height: 30px; margin-top: 8px; margin-left: 4px; margin-right: 10px; padding: 2px;">
						<span class="glyphicon glyphicon-send " style="margin: 2px;"></span>
					</button>
				</div>
			</form>
		</div>

	</div>

	<div
		style="width: 32%; float: left; float: top; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Task Dependencies</h4>

		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div
			style="height: 300px; width: 100%; padding: 0px; float: left; overflow-y: auto;">
			<ul>
				<c:forEach var="user" items="${dependencies}">
					<li class="list-group-item" style="margin: 2px; height: auto;">
						${user.getTaskName()} <a
						href="/task/removeDependency?taskId=${user.getTaskId()}"
						style="float: right; padding: 0px;"><button type="button"
								class="btn btn-danger">Remove</button></a>
					</li>
				</c:forEach>
			</ul>


		</div>
		<div class="dropdown"
			style="float: left; margin-top: 5px; margin-right: 5px; width: auto;">
			<button class="btn btn-warning dropdown-toggle" type="button"
				data-toggle="dropdown">ADD DEPENDENCY</button>
			<ul class="dropdown-menu">
				<c:forEach var="user" items="${newDependencies}">
					<li><a
						href="/task/addDependency?taskId=${user.getTaskId()}"> 
							${user.getTaskName()}
					</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>



	<div
		style="width: 32%; float: left; float: top; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">


		<h4 class="heading" style="margin-left: 0px;">Files</h4>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div
			style="height: auto; width: 100%; padding: 0px; float: left; overflow-y: auto;">
			<ul>
				<c:forEach var="file" items="${files}">
					<li class="list-group-item" style="margin: 2px; height: 35px;">${file.getFileName()}<a
						href="/task/file?filename=${file.getFileName()}" style="float: right; padding: 0px; margin-top: 0px;"><button
								type="button" class="btn btn-success">
								<span class="glyphicon glyphicon-folder-open"
									style="float: left;"></span>
							</button></a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<br>

		<div class="card-body"">
			<form action="task/upload-file?taskId=${task.getTaskId()}" method="post"
				enctype="multipart/form-data">
				<h5>Select File to Upload:</h5>
				<hr class="hr"
					style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
				<input type="file" name="file" style="margin-top: 10px;"><br />
				<input type="submit" value="upload" name="submit"
					class="btn btn-success">
			</form>
		</div>

	</div>
</div>

<%@ include file="common/footer.jsp"%>
