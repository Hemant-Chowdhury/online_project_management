<%@ include file="common/header.jsp"%>
<title>Dashboard</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/projectNav.jsp"%>
<div
	style="width: 80%; float: left; padding: 10px; height: 800px; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">File Name: ${filename}</h1>

	</div>
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">
	<div style="width: 502px; float: left;"></div>
	<div class="form-group">
		<form method="post" action="/task/file?filename=${filename}">
			<label for="comment">Comment:</label>
			<textarea name="content" class="form-control" rows="25" style="resize: none;"
				id="comment">${content}  
 			</textarea>
			<br>
			<center>
				<button type="submit" class="btn btn-success">Save</button>
			</center>
		</form>
	</div>
</div>


<%@ include file="common/footer.jsp"%>