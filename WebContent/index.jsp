<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">	 
.card { 
 text-align:center; 
 background: orange;
 margin-top : 50px;
} 
body {
	background: orange;
}
.card a {
	color: black;
	text-align: center;
}

</style>
</head>

<body>
	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	
		<div class="card">
    	<div class="card-body bt">
    	  <h4 class="card-title">Welcome to Student Management System</h4>
      
     <div class="row"> <a href="<%=request.getContextPath()%>/insert">Add new Student</a></div>
     <div class="row"><a href="<%=request.getContextPath()%>/list"  >List Of Students</a></div>
    
     
    
     
    </div>
  </div>
	
	</div>
	<div class="col-md-3"></div>
  
  
  
</div>
</body>
</html>