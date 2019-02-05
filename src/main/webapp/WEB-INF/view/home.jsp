<%@ include file="common/header.jsp"%>
<%@ include file="common/nav.jsp"%>

<body style="background-color: #bdbdbd;">
	
	<div style="height: auto; width: 20%; padding: 0px; float: left;">
		<ul>
			<li><a href="home.html ">Dashbord</a></li>
			<li><a href="pro.html">Projects</a></li>
			<li><a href="#contact">Contact</a></li>
			<li><a href="#about">About</a></li>
		</ul>

	</div>
	<div
		style="width: 80%; float: left; padding: 10px; height: 800px; background-color: white;">
		<div style="width: 100%; float: left;">
			<h1 class="heading">Dashboard</h1>

		</div>
		<hr class="hr"
			style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
		<div style="width: 502px; float: left;"></div>
		<div class="card" style="width: 400px; float: left; margin-top: 10px;">
			<img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/img_avatar1.png" alt="Card image">
			<div class="card-body">
				<h4 class="card-title">John Doe</h4>
				<p class="card-text">Some example text.</p>
				<a href="#" class="btn btn-primary">See Profile</a>
			</div>
		</div>
	</div>
	</div>



	<%@ include file="common/footer.jsp"%>