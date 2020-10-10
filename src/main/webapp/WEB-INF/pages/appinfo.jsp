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
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
   
<style>
#addcss {
	margin-top: 2%;
	margin-left: 20%;
	margin-right: 20%;
}
#input {
	padding: 3%;
	background:rgba(201, 76, 76, 0.3);
	margin-left: 20%;
	margin-right: 20%;
}
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
	</div></div>
</nav>

<div id="addcss">
	<div id="input">
	<form action="saveAppInfoDetails" method="post">
	
		<div class="form-group row">
            <div class="container">
                <!-- Button to Open the Modal -->
                <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#myModal"> Add Environment </button>
              
                <div id="displayEnvironmentData"></div>
                
		          <!-- The Modal -->
		          <div class="modal" id="myModal">
		          <div class="modal-dialog modal-dialog-scrollable">
                      <div class="modal-content">
                        <!-- Modal Header -->
                          <div class="modal-header">
                            <h2 class="modal-title">Add Environment</h2>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">X</button>
                          </div>
                          <!-- Modal body -->
                          <div class="modal-body">
                          <div class="form-group row">
                              <label class="col-sm-3"><b><i>Environment:</i></b></label>
                              <div class="col-sm-8">
                                  <select id="environment" class="form-control">
                                      <option selected> </option>
                                      <option>Devlopment</option>
                                      <option>SIT</option>
                                      <option>UAT</option>
                                      <option>Production</option>
					              </select>
					           </div>
				          </div>
                          <div class="form-group row">
                              <label class="col-sm-3"><b><i>URL:</i></b></label>
                              <div class="col-sm-8">
                                  <input type="text" class="form-control" id="url" placeholder="Enter URL">
                              </div>
				         </div>
                         <fieldset class="form-group">
				            <div class="row">
                                <label class="col-sm-3" ><b><i>Accessible:</i></b></label>
                                    <div class="col-sm-8">
                                    <div class="form-check form-check-inline">
						              <label class="form-check-label">
						              <input class="form-check-input" type="radio" name="isAccessible" value="true"> Yes
						              </label>
                                    </div>
					                <div class="form-check form-check-inline">
						              <label class="form-check-label">
                                      <input class="form-check-input" type="radio" name="isAccessible" value="false"> No
						              </label>
					                </div>
					                </div>
				            </div>
				        </fieldset>
                        <!-- Modal footer -->
				        <div class="modal-footer d-flex justify-content-right">
					       <button type="button" id="entry" class="btn btn-success" onclick="addEnv()">Save</button>
					       <button type="submit" class="btn btn" data-dismiss="modal">Close</button>
				        </div>
                        </div>
		              </div>
		          </div>
		          </div>
	       </div>
           </div>
		
			<div class="form-group row">
				<label class="col-sm-6"><i class="fas fa-file"></i>&nbsp;&nbsp;&nbsp;<b><i>Project Name:</i></b></label>
				<div class="col-sm-6">
				<input type="text" class="form-control" name="projectName" placeholder="Enter Project name">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-6"><i class="fa fa-user"></i>&nbsp;&nbsp;&nbsp;<b><i>Team Manager:</i></b></label>
				<div class="col-sm-6">
				<input type="text" class="form-control" name="teamManager" placeholder="Enter Team Manager name">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-6"><i class="fa fa-envelope"></i>&nbsp;&nbsp;&nbsp;<b><i>Team Contact Email:</i></b></label>
				<div class="col-sm-6">
				<input type="email" class="form-control" name="teamEmail" placeholder="Enter Team Contact Email">
				</div>
			</div>
			<fieldset class="form-group">
				<div class="row">
					<label class="col-sm-6" ><i class="fa fa-check-circle"></i>&nbsp;&nbsp;&nbsp;<b><i>De-Comissined:</i></b></label>
					<div class="col-sm-6">
					<div class="form-check form-check-inline">
						<label class="form-check-label">
						<input class="form-check-input" type="radio" name="isDeComissined" value="true"> Yes
						</label>
					</div>
					<div class="form-check form-check-inline">
						<label class="form-check-label">
						<input class="form-check-input" type="radio" name="isDeComissined" value="false"> No
						</label>
					</div>
					</div>
				</div>
			</fieldset>
			<div class="form-group row">
				<label class="col-sm-6"><i class="fa fa-calendar"></i>&nbsp;&nbsp;&nbsp;<b><i>Developed Date:</i></b></label>
				<div class="col-sm-6">
				<input type="date" class="form-control" name="developedDate">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-6"><i class="fa fa-spinner fa-pulse fa-x fa-fw"></i>&nbsp;&nbsp;&nbsp;<b><i>Version:</i></b></label>
				<div class="col-sm-6">
				<input type="text" class="form-control" name="appVersion" placeholder="Application Version">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-6"><i class="fa fa-calendar"></i>&nbsp;&nbsp;&nbsp;<b><i>Last Release:</i></b></label>
				<div class="col-sm-6">
				<input type="date" class="form-control" name="lastRelease">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-6"><i class="fa fa-calendar"></i>&nbsp;&nbsp;&nbsp;<b><i>Next Release:</i></b></label>
				<div class="col-sm-6">
				<input type="date" class="form-control" name="nextRelease">
				</div>
			</div>
			<div class="modal-footer d-flex justify-content-right">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
	</form>
</div>
</div>

<h2 style="text-align: center;">
		<i>${projectName}</i></h2>
<h2 style="text-align: center;">
		<i>${teamContactEmail}</i></h2>
<h2 style="text-align: center;">
		<i>${dbDetails}</i></h2>
<h2 style="text-align: center;">
		<i>${dbErrorMsg}</i></h2>

<div class="footer-copyright py-3 text-center">
	<div class="footer-bottom-text" style="color:black">
			© 2020 Copyright: <a href="#"> <strong style="color:rgb(254, 64, 118);">X-WORKZ.com </strong></a>
	</div>
</div>

<script>
	var envDetails=[];
    
    function addEnv(){
        var env = document.getElementById("environment");
        var result=env.options[env.selectedIndex].text;
        
        var url = document.getElementById("url").value;
        console.log(result);
        console.log(url);
        
        var isAccessibleData=document.getElementsByName("isAccessible");
        console.log(isAccessibleData);
        console.log("isAccessibleData:>>> ",isAccessibleData[0].checked);
        
        var environmentDetails={
            'environment': result,
            'url': url,
            'accessible':isAccessibleData[0].checked
        };
        
        console.log(environmentDetails);
        envDetails.push(environmentDetails);
        displayTable();
    }
    
    function displayTable(){
        var envData=" "
        
        envData="<table border='1' class='table table-striped'><tr> <th>Environment</th> <th>URL</th> <th>Accessible</th> </tr> ";
        
        for(var i=0;i<envDetails.length;i++){
            envData = envData + "<tr> <td><input type='hidden' name='environmentList["+i+"].environment' value='"+envDetails[i].environment+"' />"+envDetails[i].environment+"</td> <td><input type='hidden' name='environmentList["+i+"].url' value='"+envDetails[i].url+"' /> "+envDetails[i].url+" </td> <td><input type='hidden' name='environmentList["+i+"].isAccessible' value='"+envDetails[i].accessible+"' />"+envDetails[i].accessible+" </td></tr>"
        }
        envData = envData + "</table>";
        console.log(envData);
        document.getElementById("displayEnvironmentData").innerHTML=envData;
        document.getElementById("closeModal").click();
    }  
</script>

</body>
</html>