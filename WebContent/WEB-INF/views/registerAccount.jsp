<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Product</title>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<style>
		.cancel-btn {
			padding: 0.41rem 0.7rem 0.655rem;
			margin-top:5px;
			border-radius: 5px;
			background-color: #ed1010;
			color: #ddd;
			
		}
		
		.cancel-btn:hover {
		background-color: #ca0909;
		}
	</style>
   </head>
   <body>
    
     
      <jsp:include page="_menu.jsp"></jsp:include>
     
      <div class="container col-md-5 mt-4">
		<div class="card">
			<div class="card-body">
				<form method="POST" action="${pageContext.request.contextPath}/register">
		
					<h2 class="text-center">
						Đăng ký
					</h2>

				<fieldset class="form-group">
					<label for="userName">Tài khoản</label>
					 <input type="text" id="userName"
						name="userName" value="${userAccount.userName}" 
						class="form-control" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label for="password">Mật khẩu</label> 
					<input type="password" id="password" name="password" 
						value="${userAccount.password}" class="form-control" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label for="name">Họ và tên</label>
					<input type="text" id="name"
						name="name" value="${userAccount.name}" class="form-control">
				</fieldset>

				<fieldset class="form-group">
					<label for="gender">Giới tính</label>
					<input type="text" id="gender" name="gender" value="${userAccount.gender}" class="form-control" />
				</fieldset>
				
				<fieldset class="form-group">
					<label for="age">Tuổi</label>
					<input type="text" id="age" name="age" value="${userAccount.age}" class="form-control" />
				</fieldset>
				
				<fieldset class="form-group">
					<label for="email">Email</label>
					<input type="text" id="email" name="email" value="${userAccount.email}" class="form-control" />
				</fieldset>

				 <p style="color: red;">${errorString}</p>
		
				<button type="submit" class="btn btn-success mr-2">Đăng ký</button>
				<a style="text-decoration:none; color:white;" href="${pageContext.request.contextPath}/login"><button type="button" class="btn btn-danger">Hủy bỏ</button></a>
				</form>
			</div>
		</div>
	</div>
       
   </body>
</html>