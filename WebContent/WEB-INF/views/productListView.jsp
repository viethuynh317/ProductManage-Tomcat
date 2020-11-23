<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 </head>
 <body>
 

    <jsp:include page="_menu.jsp"></jsp:include>

 		<div class="container mt-4" >
			<h3 class="text-center">Danh sách sản phẩm</h3>
			<hr>
			<div class="container d-flex justify-content-between">
				<a href="createProduct" class="btn btn-success">Thêm mới sản phẩm</a>
				<form action="productList" method="post" class="form-inline">
				<label for="search" class="mr-1">Tìm kiếm:</label>
				 <input id="search" class="form-control mr-1"  type="text" name="infoSearch" 
				 value="<%= session.getAttribute("searchValue") %>" onkeyup="searchProduct()" />
				<input class="btn btn-primary" type="submit" name="action"  value="Tìm" />
				</form>
			</div>
			<br>
			<table class="table table-bordered ">
				<thead>
					<tr>
						<th>Mã sản phẩm</th>
         				<th>Tên sản phẩm</th>
          				<th>Giá sản phẩm</th>
          				<th>Số lượng trong kho</th>
          				<th>Trạng thái</th>
          				<th>Cập nhật/Xóa</th>
          				
					</tr>
				</thead>
				<tbody>
				
					<c:forEach items="${productList}" var="product">

						<tr>
							<td>${product.code}</td>
             				<td>${product.name}</td>
             				<td>${product.price}</td>
             				<td>${product.count}</td>
             				<td>${product.state}</td>
             				<td>
                				<a href="editProduct?code=${product.code}"><i class="fas fa-edit"></i>Cập nhật</a>
                				&nbsp;&nbsp;&nbsp;&nbsp;
                				<a href="deleteProduct?code=${product.code}"><i class="fas fa-trash-alt"></i>Xóa</a>
             				</td>
             				
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
			<p style="color: red;">${errorString}</p>
		</div>
    <script type="text/javascript">
    
    function searchProduct(){
    	const search = document.getElementById("search");
    	search.value = search.value;
    	console.log(search.value)
    }
    
    </script>
 
 </body>
</html>