<%@ include file="common/header.jsp"%>
<title>Contact</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>


<div
	style="width: 80%; float: left; padding: 10px; height: 800px; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">Contact</h1>
	</div>
	<div
		style="height: auto; width: 100%; padding: 0px; float: left; overflow-y: auto;">
		<ul>
			<c:forEach var="comp" items="${complain}">
				<li class="list-group-item" style="margin: 2px; height: auto;">
					${comp.getComplain()}
					 <c:choose>
						<c:when test="${ comp.getStatus()=='open'}">
							<span class="label label-warning" style="height:auto ; float: right;font-size: 12px; ">Open</span>
						</c:when>
						<c:otherwise>
							<span class="label label-success" style="height:auto ; float: right;font-size: 12px; ">Resolved</span>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<!-- ADD COMPLAIN BUTTON -->
	<button type="submit" class="btn btn-primary"
		style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 35%;"
		onclick="document.getElementById('form').style.display='block'">Add
		Complain</button>

	<div id="form" class="panel panel-default"
		style="background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 25px; display: none;">

		<form:form action="/contact/addComplain" method="post">
			<center>
				<div class="form-group" style="margin-top: 40px;">
					<label for="complain">Complain:</label> <input type="text"
						class="form-control" id="complain"
						placeholder="Enter your complain" name="complain"
						style="width: 100%;" required="required" />

				</div>
			</center>

			<button type="submit" class="btn btn-default"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: 60%;">Submit</button>
		</form:form>

		<form action="/contact">
			<button type="submit" id="cancel" class="btn btn-success"
				style="border: 0px; height: 36px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(30, 250, 35); color: rgb(255, 255, 255); width: 60%;">Cancel</button>
		</form>
	</div>
	</div>
	<%@ include file="common/footer.jsp"%>