<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>SpringBoot-Task</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<style>
.footer-bottom-text {
	position: fixed;
 	 left: 0;
  	 bottom: 0;
 	 width: 100%;
	 background-color:rgba(164, 191, 255);
 	 color: white;
 	 text-align: center;
}
</style>
</head>
<body style="padding: 0; margin: 0; height: 2px;">
<nav class="navbar navbar-expand-sm" style=" background-color:rgba(164, 191, 255);">
<div class="container-fluid">
	 <div class="navbar-header">
		<a class="navbar-brand" href="#"><strong style="color:rgb(254, 64, 118);font-size:40px;">X-WORKZ</strong></a>
	</div>
	<ul class="nav navbar-nav navbar-right">
         <li><a href="appinfo.jsp"><button type="button" class="btn btn-outline-primary">App Info</button></a>
     </ul>	</div>
</nav>
	<form action="saveMessage" method="get">
		<div class="container-fluid mt-5">
		<div style="height: 500px">
			<div class="form-group row">
				<label class="col-sm-1 col-form-label"><b><i>From:</i></b></label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="name" placeholder="Enter your name" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-1 col-form-label"><b><i>Message:</i></b></label>
				<div class="col-sm-2">
				 	<textarea class="form-control" rows="3" id="comment" name="message"  placeholder="Enter your message"></textarea>
				</div>
			</div>
			<div class="container">
			<button type="submit" class="btn btn-primary">Submit</button>
			</div>
			</div>
		</div>
		<h2 style="text-align: center;">
		<i>${name}</i></h2>
		<h2 style="text-align: center;">
		<i>${message}</i></h2>
	</form>
<div class="footer-copyright py-3 text-center">
	<div class="footer-bottom-text" style="color:black">
			© 2020 Copyright: <a href="#"> <strong style="color:rgb(254, 64, 118);">X-WORKZ.com </strong></a>
	</div>
</div>
</body>
</html>