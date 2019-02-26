<%@ include file="common/header.jsp"%>
<title>Notification</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>

<div
	style="width: 80%; float: left; padding: 10px; height: auto; background-color: white;">
	<div style="width: 100%; float: left;">
			<h1 class="heading">Notifications</h1>
	
	
	<div
		style="width: 100%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Project Notifications</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: 200px; width: 100%; padding: 0px; float: left;overflow-y: auto;">
			<ul>
			<c:forEach items="${projectFeed}" var = "pf">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					<div>
					${pf.getTimestamp()}
					</div>
					<div>
					${pf.getComment()}
					</div>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>	
		
	<div
		style="width: 100%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Task Notifications</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: 200px; width: 100%; padding: 0px; float: left;overflow-y: auto;">
			<ul>
			<c:forEach items="${taskFeed}" var = "tf">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					<div>
					${tf.getTimestamp()}
					</div>
					<div>
					${tf.getComment()}
					</div>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>	
	
	</div>
</div>


<%@ include file="common/footer.jsp"%>