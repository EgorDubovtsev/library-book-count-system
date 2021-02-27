<!DOCTYPE html>
	<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en" dir="ltr">
<head>

	<title>Библиотека</title>
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;700&display=swap" rel="stylesheet">
	<style>
           <%@include file='../../resources/css/main.css' %>
           <%@include file='../../resources/css/registrationAndLogin.css' %>
        </style>
</head>
<body>
<div class="wallpaper" ></div>
<div class="regPlace">
	<div class="regWindow">
		<div>
			<form:form action="registration/proceed" method="post" modelAttribute="registrationForm" class="regFields">
				<h3>Зарегестрироваться</h3>
				<form:input path="login" id="check_login" class="filterField regImpt" placeholder="Логин" title="Login" />
				<form:input path="password" id="check_password" class="filterField regImpt" placeholder="Пароль"  type="password" title="Password" />
				<form:input path="name" class="filterField regImpt" placeholder="Имя" title="Имя" />
	            <div class="errorWrapperLogin sml">
	            	<span class="errorMessage">${errorMessage}</span>
				</div>
				<button class="btn regBtn">Зарегестрироваться</button>

			</form:form>
			<form:form action="/login" method="get" class="redirectButtonEnter">
	        	<button class="link"> Уже есть аккаунт?</button>
	        </form:form>
        </div>
	</div>
</div>
</body>
</html>