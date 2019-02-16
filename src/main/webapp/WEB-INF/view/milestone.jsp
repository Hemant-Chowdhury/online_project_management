<%@ include file="common/header.jsp"%>
<title>Milestones</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/projectNav.jsp"%>




<div
	style="width: 90%; float: left; padding: 10px; height: 1400px; background-color: white; overflow-y: auto;">
	<div style="width: 100%; float: left;">
		<h1 class="heading" style="margin-right: 5px; width: 180px;">Milestone</h1>
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


	<!-- ADD MILESTONE BUTTON -->
	<button type="submit" class="btn btn-primary"
		style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 25%;"
		onclick="document.getElementById('form').style.display='block'">Add
		Milestone</button>

	<div id="form" class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 25px; display: none;">

		<form:form action="/milestone/addMilestone" method="post">
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="milestoneName">Milestone Name:</label> <input type="text"
						class="form-control" id="milestoneName"
						placeholder="Enter Milestone Name" name="milestoneName"
						style="width: 60%;" required="required" />

				</div>
			</center>

			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: 60%;">Submit</button>
		</form:form>

		<form action="/milestone">
			<button type="submit" id="cancel" class="btn btn-success"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(30, 250, 35); color: rgb(255, 255, 255); width: 60%;">Cancel</button>
		</form>
	</div>
	
</div>
<%@ include file="common/footer.jsp"%>

