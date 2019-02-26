<%@ include file="common/header.jsp"%>
<title>Dashboard</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/projectNav.jsp"%>

<div
	style="width: 85%; float: left; padding: 10px; height: 100%; background-color: white;">
	<div style="width: 100%; float: left;">
			<h1 class="heading">Gantt Chart</h1>
		
		${view}
		<div style="height: auto; width: 100%; padding: 0px; float: left;overflow-x: auto;">
	 	<div id="chart_div"></div>
	 	<br/>
	 	<div id="chart_div"></div>
	 	</div>
</div>			
</div>
<%@ include file="common/footer.jsp"%>