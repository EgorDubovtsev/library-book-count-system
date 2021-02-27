<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Библиотека</title>
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="${staticRoot}/resources/js/main.js"></script>
	<script type="text/javascript" src="${staticRoot}/resources/js/validation.js"></script>
	<style>
       <%@include file='../../resources/css/main.css' %>
        <%@include file='../../resources/css/createBook.css' %>
        <%@include file='../../resources/css/cart.css' %>
    </style>
</head>
<body>
<div class="wallpaper" ></div>
	<div class="userMenu">
		<span class="name">
			 ${name}
		</span>
		<div class="menuButtonWrapper">
			<form action="/logout" method="post" class="menuButton">
				<button>Выйти</button>
			</form>
		</div>
	</div>
	<div class="userMenu">
	<form class="menuButton" action="/" method="get">
        <button>
          Вернуться на главную
        </button>
	</form>
	</div>
	<div class="cartName">Добавить новую книгу</div>
	<div class="cartListOuter">
		<form:form class="cartListInner" action="/createBook/proceed" method="post" modelAttribute="createBookForm" >
			<div class="paramBook">
				<label>Название: </label>
				<form:input id="name-createBook" type="text" class="filterField" path="name"/>
			</div>
			<div class="paramBook">
				<label>Автор: </label>
				<form:input type="text" id="author-createBook"  class="filterField" path="author"/>
			</div>
			<div class="paramBook">
				<label>Жанр: </label>
				<form:select class="select" path="genre" id="genre-createBook">
					<option value="null" selected>Выберите жанр</option>
					<option value="Детектив">Детектив</option>
					<option value="Роман">Роман</option>
					<option value="Драма">Драма</option>
					<option value="Научная фантастика">Научная фантастика</option>
				</form:select>
			</div>
			<div class="saveWrapper">
				<div class="errorWrapperLogin">
					<span class="errorMessage">${errorMessage}</span>
				</div>
				<button class="btn saveBtn">Сохранить</button>
			</div>
		</form:form>
	</div>
</body>
</html>