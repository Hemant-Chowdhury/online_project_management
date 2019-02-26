<%@ include file="common/header.jsp"%>
<title>Milestones</title>
<%@ include file="common/guestNav.jsp"%>
<%@ include file="common/guestProjectNav.jsp"%>

<div
	style="width: 90%; float: left; padding: 10px; height: 1400px; background-color: white; overflow-y: auto;">
	<div style="width: 100%; float: left;">
		<h1 class="heading" style="margin-right: 5px; width: 160px;">Milestone</h1>
		<h1 class="heading" style="margin-right: 5px; width: 180px;">Date Created</h1>
		<h1 class="heading" style="margin-right: 5px; width: 180px;">Start
			Date</h1>
		<h1 class="heading" style="margin-right: 5px; width: 180px;">End
			Date</h1>
		<h1 class="heading" style="margin-right: 5px; width: 180px;">Status
		</h1>
	</div>

	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
	<div class="panel-group" id="accordion"
		style="float: left; width: 100%;">
		${view}
</div>
<%@ include file="common/footer.jsp"%>

