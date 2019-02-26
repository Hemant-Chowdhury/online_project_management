<%@ include file="common/header.jsp"%>
<title>Projects</title>
<%@ include file="common/guestNav.jsp"%>
<%@ include file="common/guestSidebar.jsp"%>

<div
	style="width: 80%; float: left; padding: 10px; height: 100%; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">Projects</h1>

	</div>
	<div
		style="width: 99%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 10px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">All Projects</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<c:forEach items="${projects}" var="project">
				<div
					style="border-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; border: 1px solid #ddd; background-color: #f5f5f5; padding: 5px; margin-top: 10px; width: 100%; float: left;">
					<h3 style="margin: 3px;">
						<a href="/guest/home/project?projectId=${project.getProjectId()}">${project.getProjectName()}</a>
						<form action="/guest/home/project?projectId=${project.getProjectId()}" method="post"
							style="float: right; width: auto; height: auto;">
							<button type="submit" class="btn btn-default"
								style="border: 0px; border-radius: 4px; -webkit-font-smoothing: antialiased; font-weight: bold; padding: 4px; margin-right: 10px; vertical-align: middle; text-align: center; background-color: #3367d6; color: rgb(255, 255, 255); width: auto; float: right;">More
								Info</button>
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
</div>


<%@ include file="common/footer.jsp"%>