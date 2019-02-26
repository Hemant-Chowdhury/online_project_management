<%@ include file="common/header.jsp"%>
<title>User Report</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>
		
		
<div
	style="width: 80%; float: left; padding: 10px; height: 800px; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">User Report</h1>
	</div>

    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {
        var data = new google.visualization.arrayToDataTable([
         ${data}
        ]);

        var options = {
          width: 800,
          chart: {
            title: 'Reports Graph',
            subtitle: 'Tasks on the left, Milestones on the right'
          },
          bars: 'vertical', // Required for Material Bar Charts.
          series: {
            0: { axis: 'milestone' }, // Bind series 0 to an axis named 'distance'.
            1: { axis: 'tasks' } // Bind series 1 to an axis named 'brightness'.
          },
          axes: {
            x: {
              milestone: {label: 'parsecs'}, // Bottom x-axis.
              tasks: {side: 'top', label: 'apparent magnitude'} // Top x-axis.
            }
          }
        };

      var chart = new google.charts.Bar(document.getElementById('dual_x_div'));
      chart.draw(data, options);
    };
    </script>
    
 	<div id="dual_x_div" style="width: 900px; height: 500px;float: left;"></div>
 </div>
 
<%@ include file="common/footer.jsp"%>