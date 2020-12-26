<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">
.card {
	text-align: center;
	background: orange;
	margin-top: 50px;
}

.dd {
	width: 100%;
}

.bt {
	margin-top: 10px;
}

.sex {
	font-size: 15px;
	size: a4;
}

body {
	background: orange;
}

.row {
	margin: 0px !important;
	padding: 0px !important;
}

.form-control {
	margin-top: 2px;
}
</style>

</head>
<body>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="card">
				<div class="card-body">

					<form action="<%=request.getContextPath()%>/update" method="post">

						<center>
							<h2>Update details of student</h2>
						</center>

						<c:if test="${student != null}">
							<input type="hidden" name="id"
								value="<c:out value='${student.id}' />" />
						</c:if>


						<div class="row">
							<div class="col-sm-4">
								<label>Name</label>
							</div>
							<div class="col-sm-6">
								<input type="text" value="<c:out value='${student.name}' />"
									class="form-control " name="name" required="required">
							</div>
						</div>

						<div class=" row form-group">
							<div class="col-sm-4">
								<label>Marks</label>
							</div>
							<div class="col-sm-6">
								<input type="text" value="<c:out value='${student.marks}' />"
									class="form-control" name="marks" required="required">
							</div>
						</div>

						<div class=" row form-group">
							<div class="col-sm-4">
								<label>Email</label>
							</div>
							<div class="col-sm-6">
								<input type="email" value="<c:out value='${student.email}' />"
									class="form-control" name="email">
							</div>
						</div>

						<div class=" row form-group">
							<div class="col-sm-4">
								<label>DOB</label>
							</div>
							<div class="col-sm-6">
								<input type="Date" value="<c:out value='${student.dob}' />"
									class="form-control" name="dob" required="required">
							</div>
						</div>


						<div class=" row form-group">
							<div class="col-sm-4">
								<label>Gender</label>
							</div>
							<div class="col-sm-6 sex">
								<input type="radio" name="gender" 
									value="male" />Male <input
									type="radio" name="gender"
									value="female" />Female

							</div>
						</div>


						<div class=" row form-group">
							<div class="col-sm-4">
								<label>Course</label>
							</div>
							<div class="col-sm-6">
								<select name="course-name" class="dd">
									<option value="null">Select</option>
									<option value="MCA">MCA</option>
									<option value="B.tech">B.tech</option>
									<option value="BCA">BCA</option>
									<option value="BBA">BBA</option>
									<option value="M.tecch">M.tech</option>

								</select>
							</div>
						</div>


						<div class="form-group bt">
							<button type="submit" class="btn btn-success">Save</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>
</body>
</html>