<%@ include file="common/header.jsp"%>
<title>Meeting</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/projectNav.jsp"%>

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
	
	<!-- ADD MEETING BUTTON -->
	<button type="submit" class="btn btn-primary"
		style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 25%;"
		onclick="document.getElementById('form').style.display='block'">Add
		meeting</button>

	<div id="form" class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 25px; display: none;">

		<form:form action="/meeting/addMeeting" method="post">
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="date">Meeting Date:</label> <input type="date"
						class="form-control" id="date" name="date"
						style="width: 100%;" required="required" />

				</div>
			</center>
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="topic">Topic:</label> <input type="text"
						class="form-control" id="topic"
						placeholder="Enter topic of meeting" name="topic"
						style="width: 100%;" required="required" />

				</div>
			</center>
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="conclusion">Conclusion:</label> <input type="text"
						class="form-control" id="conclusion"
						placeholder="Enter conclusion" name="conclusion"
						style="width: 100%;" required="required" />

				</div>
			</center>

			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: 60%;">Submit</button>
		</form:form>

		<form action="/meeting">
			<button type="submit" id="cancel" class="btn btn-success"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(30, 250, 35); color: rgb(255, 255, 255); width: 60%;">Cancel</button>
		</form>
	</div>
</div>
<%@ include file="common/footer.jsp"%>