<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">
							Username or password incorrect
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">
							you Not authorize
					</div>
				</c:if>
				<h2 class="title">Welcome</h2>
				<form action="j_spring_security_check" id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
					</div>

					<div class="auth-form-aside">
						<div class="auth-form-help">
							<a href="" class="auth-form-help-link auth-form-help-link-forget">Quên mật khẩu</a>
							<span class="auth-form-help-separate"></span>
							<a href="" class="auth-form-help-link">Cần trợ giúp ?</a>
						</div>
					</div><br>

					<div class="button"><button type="submit" class="btn btn-primary" >Đăng nhập</button></div><br>
					<div class="back_to_home"><a href="<c:url value='/trang-chu'/>" class="auth-form-help-link">Trở lại</a></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>