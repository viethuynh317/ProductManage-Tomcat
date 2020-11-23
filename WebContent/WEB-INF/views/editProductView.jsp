<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Product</title>
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
			<c:if test="${not empty product}">
				<form method="POST" action="${pageContext.request.contextPath}/editProduct">
		
					<h2>
						Cập nhật sản phẩm
					</h2>
			 	<input type="hidden" name="code" value="${product.code}" />
				<fieldset class="form-group">
					<label for="code">Mã sản phẩm</label>
					<input type="text" name="name" id="name" 
						value="${product.code}" class="form-control" disabled>
				</fieldset>

				<fieldset class="form-group">
					<label for="name">Tên sản phẩm</label> 
					<input type="text" id="name" name="name" value="${product.name}" class="form-control" />
				</fieldset>

				<fieldset class="form-group">
					<label for="price">Giá sản phẩm</label>
					<input type="text" id="price" name="price" value="${product.price}" class="form-control" />
				</fieldset>
				
				<fieldset class="form-group">
					<label for="count">Số lượng trong kho</label>
					<input type="text" id="count" name="count" value="${product.count}" class="form-control" />
				</fieldset>
				
				<fieldset class="form-group">
					<label for="state">Trạng thái</label>
					<input type="text" id="state" name="state" value="${product.state}" class="form-control" />
				</fieldset>
				
				<p style="color: red;">${errorString}</p>

				<button type="submit" class="btn btn-success mr-2">Cập nhật</button>
				<a style="text-decoration:none; color:white;" href="${pageContext.request.contextPath}/productList"><button type="button" class="btn btn-danger">Hủy bỏ</button></a>
				</form>
				</c:if>
			</div>
		</div>
	</div>
 
   </body>
</html>