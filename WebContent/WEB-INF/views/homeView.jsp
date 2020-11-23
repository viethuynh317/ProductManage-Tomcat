<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </head>
  <body>
 
    
     <jsp:include page="_menu.jsp"></jsp:include>
    <div class="container mt-4">
      <h3>Trang chủ</h3>
      
      Ứng dụng sử dụng JSP, Servlet, JDBC kết nối với MySQL, và xây dựng theo mô hình MVC <br><br>
      <b>Ứng dụng gồm các chức năng dưới đây:</b>
      <ul>
         <li>
        	 Đăng nhập
	         <ul>
		         <li>
		         	Để tham gia quản lý sản phẩm thì người dùng cần phải đăng nhập trước khi thực hiện:
		         </li>
		         <li>
		         	Có thể đăng nhập bằng tài khoản khởi tạo sẵn: username: viet, password: 123456.
		         </li>
		         <li>
		         	Có thể đăng ký tài khoản để đăng nhập.
		         </li>
		          <li>
		         	Chọn mục "Đăng nhập" -> Hiển thị trang đăng nhập
		         </li>
	         </ul> 
         </li>
         <li>
         	Đăng ký
         	<ul>
         		<li>Đăng ký thêm tài khoản để đăng nhập</li>
	         	<li>Chọn mục "Đăng ký" -> Hiển thị trang đăng ký</li>
	         </ul>
         </li>
         
         <li>
         	Hiển thị thông tin người dùng
         	<ul>
         		<li>Đăng nhập trước khi muốn hiển thị thông tin người dùng</li>
	         	<li>Khi chưa đăng nhập: Chọn mục "Thông tin người dùng" -> Trang đăng nhập
	         	 -> Đăng nhập thành công -> Trang thông tin người dùng</li>
	         	 <li>Khi đã đăng nhập: Chọn mục "Thông tin người dùng" -> Trang thông tin người dùng</li>
	         </ul>
         </li>
         
         <li>
         	Hiển thị danh sách sản phẩm
         	<ul>
         		<li>Người dùng có thể xem danh sách sản phẩm khi chưa đăng nhập</li>
	         	<li>Chọn mục "Sản phẩm" -> Hiển thị trang danh sách sản phẩm</li>
	         </ul>
         </li>
         <li>
         	Tìm kiếm sản phẩm
	         <ul>
	         	<li>Người dùng có thể Tìm kiếm sản phẩm khi chưa đăng nhập</li>
	         	<li>Chọn mục "Sản phẩm" -> Hiển thị trang danh sách sản phẩm</li>
	         	<li>Tại trang danh sách sản phẩm -> Tìm kiếm sản phẩm</li>
	         </ul>
         </li>
         
         <li>
         	Thêm sản phẩm
         	<ul>
	         	<li>Để thực hiện được chức năng Thêm sản phẩm thì cần phải đăng nhập trước</li>
	         	<li>Nếu chưa đăng nhập thì khi chọn vào Thêm sản phẩm ở trang 
	         	danh sách sản phẩm thì sẽ hiển thị toast "Bạn phải đăng nhập trước khi Thêm sản phẩm"</li>
	         	<li>Nếu mà đã đăng nhập thì sẽ chuyển đến trang thêm sản phẩm</li>
	         	<li>Chọn mục "Sản phẩm" -> Trang danh sách sản phẩm -> Chọn thêm sản phẩm -> Trang thêm sản phẩm</li>
	         </ul>
         </li>
         <li>	
         	Cập nhật sản phẩm
         	<ul>
	         	<li>Để thực hiện được chức năng Cập nhật sản phẩm thì cần phải đăng nhập trước</li>
	         	<li>Nếu chưa đăng nhập thì khi chọn vào Cập nhập ở trang danh sách sản phẩm
	         	 thì sẽ hiển thị toast "Bạn phải đăng nhập trước khi Cập nhật sản phẩm"</li>
	         	<li>Nếu mà đã đăng nhập thì sẽ chuyển đến trang Cập nhật sản phẩm</li>
	         	<li>Chọn mục "Sản phẩm" -> Trang danh sách sản phẩm -> Chọn "Cập nhật" ở Cột "Cập nhật/Xóa"
	         	 -> Trang cập nhật sản phẩm</li>
	         </ul>
         </li>
         <li>
        	 Xóa sản phẩm
        	 <ul>
	         	<li>Để thực hiện được chức năng Xóa sản phẩm thì cần phải đăng nhập trước</li>
	         	<li>Nếu chưa đăng nhập thì khi chọn vào Xóa ở trang danh sách sản phẩm
	         	 thì sẽ hiển thị toast "Bạn phải đăng nhập trước khi Xóa sản phẩm"</li>
	         	<li>Nếu mà đã đăng nhập thành công thì có thể xóa sản phẩm</li>
	         	<li>Chọn mục "Sản phẩm" -> Trang danh sách sản phẩm -> Chọn "Xóa" ở Cột "Cập nhật/Xóa" 
	         	-> Cập nhật danh sách sản phẩm sau khi xóa</li>
	         </ul>
       	</li>
      </ul>
 	</div>
     
 
  </body>
</html>