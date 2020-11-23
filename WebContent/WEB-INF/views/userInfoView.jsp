<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 </head>
 <style>
	.card-header {
		font-size: 1.5rem;
		font-style: uppercase;
		text-align: center;
	}
	.margin-auto {
		margin: 0 auto;
	}
</style>
 <body>
 
    <jsp:include page="_menu.jsp"></jsp:include>
 
 	
    <div class="container col-6 col-xl-6 col-lg-6 float-center mt-4 ">
	     <div class="card border-dark mb-3 margin-auto" style="max-width: 25rem;">
			  <div class="card-header">Thông tin người dùng</div>
			  <div class="card-body text-dark">
			   <p class="card-text">Tài khoản: ${user.userName}</p>
			    <p class="card-text">Tên: ${user.name}</p>
			    <p class="card-text">Giới tính: ${user.gender }</p>
			    <p class="card-text">Tuổi: ${user.age}</p>
			    <p class="card-text">Email: ${user.email}</p>			    
			  </div>
		</div>
</div>

    
 
 </body>
</html>