
<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Библиотека</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;700&display=swap" rel="stylesheet">
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<style>
       <%@include file='../../resources/css/main.css' %>
       <%@include file='../../resources/css/registrationAndLogin.css' %>
    </style>
</head>
<body>
<div class="wallpaper"></div>
<div class="regPlace">
	<div class="logWindow">
		<div class="regFields">
			<form  class="regFields" action="login/process" method="post">
				<h3>Укажите данные для входа</h3>
				<input class="filterField regImpt" placeholder="Логин" authentication-success-handler-ref="fullyAccessHandlerService" type="text" name="login">
				<input class="filterField regImpt" placeholder="Пароль" type="password" name="password">
				<div class="errorWrapperLogin sml">	<span class="errorMessage">${errorMessage}</span>
				</div>
				<button type="submit" href="#" class="btn regBtn">Войти</button>
			</form>
			<form action="registration" method="get" class="redirectButtonEnter ">
	        	<input type="submit" class="link haveAcc" value="Еще нет аккаунта?">
	        </form>
        </div>
	</div>
</div>
</body>
</html>