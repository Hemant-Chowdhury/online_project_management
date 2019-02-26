<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />


<title>Month View - Demos | FullCalendar</title>






<link href='${pageContext.request.contextPath}/assets/demo-topbar.css'
	rel='stylesheet' />

<link
	href='${pageContext.request.contextPath}/resources/fullcalendar-3.10.0/fullcalendar.min.css'
	rel='stylesheet' />
<link
	href='${pageContext.request.contextPath}/fullcalendar-3.10.0/fullcalendar.print.css'
	rel='stylesheet' media='print' />



<script
	src='${pageContext.request.contextPath}/resources/fullcalendar-3.10.0/lib/moment.min.js'></script>
<script
	src='${pageContext.request.contextPath}/resources/fullcalendar-3.10.0/lib/jquery.min.js'></script>
<script
	src='${pageContext.request.contextPath}/resources/fullcalendar-3.10.0/fullcalendar.min.js'></script>


<div class="head">
	<div class="home">
	<button class="btn btn-success"
			style="border: 0px; height: 28px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 10px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 6px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 10%;">
		<a href="/home" style="color: black; text-decoration-line: none;"><font
			size="5" style="padding: 10px;">Home</font></a>
	</button>
	</div>
</div>

<body>

	<style>
html, body {
	margin: 0;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 40px auto;
}
</style>


	<script>

  $(function() {
    $('#calendar').fullCalendar({
  events: [
   ${data}
  ]
});

  });

</script>

	<div class='demo-topbar'></div>

	<div id='calendar'></div>

</body>

</html>
