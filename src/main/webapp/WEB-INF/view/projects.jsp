<%@ include file="common/header.jsp"%>
<title>Projects</title>
<%@ include file="common/nav.jsp"%>
<%@ include file="common/userNav.jsp"%>

<div
	style="width: 80%; float: left; padding: 10px; height: 800px; background-color: white;">
	<div style="width: 100%; float: left;">
		<h1 class="heading">Projects</h1>

	</div>
	<hr class="hr"
		style="width: 100%; height: 1px; background-color: black; float: left; display: block;">

	<div class="panel-group" id="accordion"
		style="float: left; width: 100%;">
	
	${project}
	
	<button type="submit" class="btn btn-primary"  style="border: 0px;
    height: 36px;
    display: inline-block;
    border-radius: 4px;
    -webkit-font-smoothing: antialiased;
    padding: 0px 18px;
    font-size: 15px;
    font-weight: bold;
    outline: none;
    box-shadow: none;
    cursor: pointer;
    margin: 10px;
    vertical-align: middle;
    text-align: center;
    color: rgb(255, 255, 255);
    width: 10%;" onclick="document.getElementById('form').style.display='block'">Add</button>
 
  <div  id="form" class="panel panel-default" style="  ;background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px;padding-top: 20px;margin-top:25px; display: none;">

  	<form action="#">
    <center><div class="form-group" style="margin-top: 40px;">
      <label for="email">Project Name:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" style="width: 60%;">
    </div></center>
    <center><div class="form-group" >
      <label for="comment">Description:</label>
  <textarea class="form-control" rows="5" id="comment" style="resize: none;"></textarea>
    </div></center>
    
    <button type="submit" class="btn btn-default" style="border: 0px;
    height: 36px;
    display: inline-block;
    border-radius: 4px;
    -webkit-font-smoothing: antialiased;
    padding: 0px 18px;
    font-size: 15px;
    font-weight: bold;
    outline: none;
    box-shadow: none;
    cursor: pointer;
    margin-top: 10px;
    vertical-align: middle;
    text-align: center;
    background-color: rgb(230, 0, 35);
    color: rgb(255, 255, 255);
    width: 60%;">Submit</button>

   
  </form>
  </div>

	</div>
</div>

<%@ include file="common/footer.jsp"%>








