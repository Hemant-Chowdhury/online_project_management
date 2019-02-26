<%@ include file="common/header.jsp"%>
<title>Project</title>
<%@ include file="common/guestNav.jsp"%>
<%@ include file="common/guestProjectNav.jsp"%>

<div
	style="width: 90%; float: left; padding: 10px; height: 800px; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">${project.getProjectName()}</h1>

	</div>
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
	<div
		style="width: 32%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Project
				Participants</h4>

		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<ul>
				<c:forEach var="user" items="${participants}">
					<li class="list-group-item" style="margin: 2px; height: auto;">
						<img src="${pageContext.request.contextPath}${user.getImage()}"
						alt="default" style="width: 10%; height: 30px; margin-top: 4px;">
						${user.getName()} (${user.getCompany()}) 
					</li>
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
				<li class="list-group-item" style="margin: 2px;"><b>Created
						by:</b> ${project.getOwner()}</li>
				<li class="list-group-item" style="margin: 2px;"><b>Date
						Created:</b> ${project.getTimestamp()}</li>
				<li class="list-group-item" style="margin: 2px;">
					<div class="form-group">
						<label for="comment">Project Description:</label>
						<textarea class="form-control" rows="5" id="comment"
							style="border-radius: 1px; resize: none;" disabled>${project.getDescription() } </textarea>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div
		style="width: 32%; float: left; padding: 10px; height: 500px; background-color: #ddd; margin: 5px; overflow-y: auto;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Forum</h4>
			<div id="displayarea" name="displayarea">
			
			</div>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
	</div>
	
	
	
<script type="text/javascript" id = "projectChat">
var url = '/guest/project/getChat'
 
$(document).ready(function() {
 
$.ajaxSetup({ cache: false }); 
 
setInterval(function() {
	$("#displayarea").load(url);
	}, 2000);
 
});
 
</script>
	
</div>

<%@ include file="common/footer.jsp"%>