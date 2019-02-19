<%@ include file="common/header.jsp"%>
<title>Dashboard</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>

<div
	style="width: 80%; float: left; padding: 10px; height: auto; background-color: white;">
	<div style="width: 100%; float: left;">
			<h1 class="heading">Welcome ${username}</h1>
	
	
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
	<div
		style="width: 20%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Your Projects</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<ul>
			<c:forEach items="${project}" var = "p">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					<a href="/home/project?projectId=${p.getProjectId()}">
					${p.getProjectName()}
					</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
	
	<div
		style="width: 17%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Your Overdue Tasks</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<ul>
			<c:forEach items="${pastTask}" var = "past">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					<a href="/home/task?taskId=${past.getTaskId()}">
					${past.getTaskName()}
					</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
	
	<div
		style="width: 17%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Today's Tasks</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<ul>
			<c:forEach items="${presentTask}" var = "present">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					<a href="/home/task?taskId=${present.getTaskId()}">
					${present.getTaskName()}
					</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
		
	<div
		style="width: 17%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Your Upcoming Tasks</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<ul>
			<c:forEach items="${futureTask}" var = "future">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					<a href="/home/task?taskId=${future.getTaskId()}">
					${future.getTaskName()}
					</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
	
	
	
	<div
		style="width: 17%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Completed Tasks</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<ul>
			<c:forEach items="${completedTask}" var = "completed">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					<a href="/home/task?taskId=${completed.getTaskId()}">
					${completed.getTaskName()}
					</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
	
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
	
	<div
		style="width: 100%; float: left; padding: 10px; height: auto; background-color: #ddd; margin: 5px;">
		<div style="width: 100%; float: left;">
			<h4 class="heading" style="margin-left: 0px;">Task Reports</h4>
		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; margin: 0.5px; background-color: black; float: left; display: block;">
		<div style="height: auto; width: 100%; padding: 0px; float: left;">
			<script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Number Of Tasks Completed'],
          ['Upcoming Tasks : ${futureTask.size()}',     ${futureTask.size()}],
          ['Overdue Tasks : ${pastTask.size()}',      ${pastTask.size()}],
          ['Todays Tasks : ${presentTask.size()}',  ${presentTask.size()}],
          ['Completed Tasks : ${completedTask.size()}', ${completedTask.size()}],
        ]);

        var options = {
          title: 'My Tasks',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
    <div id="piechart_3d" style="width: 1000px; height: 500px;"></div>
	</div>
	</div>
		
		
	</div>
</div>


<%@ include file="common/footer.jsp"%>