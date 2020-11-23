<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="bg-light">
<nav class="navbar navbar-expand-lg navbar-light  container">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">MY SITE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/">Trang chủ<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/productList">Sản phẩm</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath}/userInfo" >Thông tin người dùng</a>
      </li>
    </ul>
    
    <div class="my-2 my-lg-0">  
    <c:if test="${loginedUser != null}">
      Xin chào <b>${loginedUser.userName}</b>,
      <a class="text-dark" href="${pageContext.request.contextPath}/logout"> Đăng xuất </a>
      </c:if>
      <c:if test="${loginedUser == null}">
      <a class="text-dark mr-3" href="${pageContext.request.contextPath}/login"> Đăng nhập </a>
      <a class="text-dark" href="${pageContext.request.contextPath}/register"> Đăng ký </a>
      </c:if>
    </div>
    
  </div>
</nav>
</div>