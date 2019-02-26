<%@ include file="common/header.jsp"%>
<title>Meeting</title>
<%@ include file="common/guestNav.jsp"%>
<%@ include file="common/guestProjectNav.jsp"%>

<div
	style="width: 85%; float: left; padding: 10px; height: 100%; background-color: white;">
	
	<div style="width: 100%; float: left;">
		<h1 class="heading">Meetings</h1>
	</div>
		<script type="text/javascript">
      google.charts.load('current', {'packages':['table']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Date');
        data.addColumn('string', 'Topic');
        data.addColumn('string', 'Conclusion');
        data.addRows([
         ${data}
        ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));

        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
    </script>
	<div
			style="height: auto; width: 100%; padding: 0px; float: left; overflow-x: auto;">
			<div id="table_div"></div>
	</div>
	
	
</div>
<%@ include file="common/footer.jsp"%>