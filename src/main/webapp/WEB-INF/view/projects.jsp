<%@ include file="common/header.jsp"%>
<title>Projects</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>

<div
	style="width: 80%; float: left; padding: 10px; height: 800px; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">Projects</h1>

	</div>
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">

	<div class="panel-group" id="accordion"
		style="float: left; width: 100%;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse2">Project Heading 1</a> <a href="#"><button
							type="button" class="btn btn-danger"
							style="float: right; line-height: 1.3;">Delete</button></a>
				</h4>

			</div>
			<div id="collapse2" class="panel-collapse collapse in">
				<div class="panel-body">
					<script ::after="display=none;"> </script>
					project Details
				</div>
				<a href="project.html"><button type="button"
						class="btn btn-info"
						style="margin: 6px; margin-top: -3px; margin-left: 15px;">More
						Info</button></a>
			</div>
		</div>

	</div>
</div>
</div>
