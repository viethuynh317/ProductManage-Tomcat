<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
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
					<form method="POST" action="${pageContext.request.contextPath}/login">
			
						<h2 class="text-center">
							Đăng nhập
						</h2>
				
					<fieldset class="form-group">
						<label for="userName">Tài khoản</label>
						 <input type="text" id="userName"
							name="userName" value="${user.userName}" 
							class="form-control" required="required">
					</fieldset>
	
					<fieldset class="form-group">
						<label for="password">Mật khẩu</label>
						<input type="password" id="password"
							name="password" value="${user.password}" class="form-control">
					</fieldset>
				
					<p style="color: red;">${errorString}</p>
				
					<fieldset class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="check">
   						<label class="form-check-label" for="check">Ghi nhớ tài khoản</label>
					</fieldset>
	
					<button type="submit" class="btn btn-success mr-2">Đăng nhập</button>
					<a style="text-decoration:none; color:white;" href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-danger">Hủy bỏ</button></a>
					</form>
				</div>
			</div>
		</div>
      
   </body>
</html>