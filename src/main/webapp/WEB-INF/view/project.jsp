<%@ include file="common/header.jsp"%>
<title>Project</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/projectNav.jsp"%>

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
			${listParticipant}

			<button class="btn btn-warning" style="width: 100%"
				data-toggle="collapse" data-target="#demo">Add Participant</button>

			<form action="/project/addParticipant" method="post">

				<div class="input-group" style="margin-top: 3px;">
					<span class="input-group-addon" style="width: auto; height: 34px;"><div
							style="margin-top: 2px;">Participant Name</div></span> <input
						id="username" type="text" class="form-control" name="username"
						placeholder="Enter username" style="height: auto;">
				</div>
				<div class="input-group" style="margin-top: 3px;">
					<span class="input-group-addon" style="width: auto; height: 34px;"><div
							style="margin-top: 2px;">Type</div></span> <input id="Type" type="text"
						class="form-control" placeholder="Enter Manager/Developer"
						name="type" style="height: auto;">
				</div>
				<button type="submit" class="btn btn-default"
					style="border: 0px; height: 18px; width: auto; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 12px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: right; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255);">Submit</button>
			</form>
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
	
	
	
<script type="text/javascript">
var url = '/project/getChat'
 
$(document).ready(function() {
 
$.ajaxSetup({ cache: false }); 
 
setInterval(function() {$("#displayarea").load(url); }, 1000);
 
});
 
 
 
 
</script>
	<form name="sendMessage" action="/project/sendMessage" method="post"
		style="float: right; width: 32%; margin-right: 20px;">

		<div class="input-group" style="margin-top: 3px;">

			<textarea id="message" name="message" class="form-control" rows="0" placeholder = "Enter message"
				style="border-radius: 10px; margin-top: 5px; margin-left: -7px; resize: none;"></textarea>
			<button type="submit"  class="btn btn-success"
				style="width: 12%; height: 30px; margin-top: 8px; margin-left: 4px; margin-right: 5px; padding: 2px;">
				<span class="glyphicon glyphicon-send " style="margin: 2px;"></span>
			</button>
		</div>
	</form>
</div>






<%@ include file="common/footer.jsp"%>