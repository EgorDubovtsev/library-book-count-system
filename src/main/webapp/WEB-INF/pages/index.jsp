<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html dir="ltr">
<head>
	<title>Библиотека</title>
    <c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/searchBook.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/main.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/saveBookChanges.js"></script>
	<style>
         <%@include file='../../resources/css/main.css' %>
         <%@include file='../../resources/css/registrationAndLogin.css' %>
    </style>
</head>
<body>
<div class="wallpaper" 
	style="background-color:#EDFDF4"></div>
		<div class="mainName">Библиотека</div>
	<div class="userMenu">
		<span class="name" id="login">
			 ${name}
		</span>
		<div class="menuButtonWrapper">
	        <form action="/createBook" method="get" class="menuButton">
	            <button>Добавить книгу</button>
	        </form>
			<form action="/logout" method="post" class="menuButton">
				<button>Выйти</button>
			</form>
		</div>
	</div>

	<div class="search">
		<input type="text" placeholder="Укажите название книги" name="search" id="searchLine">
		<a id="searchButton">Поиск</a>
	</div>
	<div class="filters">
		<div class="filterColumn">
			<label>Автор: <input type="text" id="author" class="filterField"></label>
		</div>
		<div class="filterColumn">
			<label>Жанр:
				<select class="filterField" id="genre">
					<option value="" selected="selected">Выберите жанр</option>
					<option value="Детектив">Детектив</option>
					<option value="Роман">Роман</option>
					<option value="Драма">Драма</option>
					<option value="Научная фантастика">Научная фантастика</option>
				</select>
			</label>
		</div>

	</div>
	<div class="allBooks">
		<div class="booksList">
            <div class="bookExample">
                 <p style="width:200px; padding-left:20px;">Название книги</p>
                 <p >Автор</p>
                 <p >Жанр</p>
                 <p >Статус</p>
                 <p>Кем занята</p>
                 <p>Дата возврата</p>
                 <a href="#" style="visibility:hidden" class="bookSaveButton btn">Сохранить</a>
             </div>
			 <c:forEach items="${booksList}" var="book">

	                	<div class="book" id="book-${book.getName()}">
			                 <p class="bookName">${book.getName()}</p>
			                 <p class="bookStatus">${book.getAuthor()}</p>
			                 <p class="bookStatus">${book.getGenre()}</p>
			                 <input type="hidden" path="name" value="${book.getName()}"/>
                            <p class="bookStatus">  ${book.isOccupied()?"занята":"свободна"}</p>
                            <input type="text" class="bookUser" path="ownerName" value="${book.getOwnerName()}" />
                            <input type="date" class="bookReturnDate" path="returnDate" value="${book.getFormattedDate()}"/>

			                 <a  class="bookSaveButton btn" id="${book.getName()}">Сохранить</a>
		                 </div>

			 </c:forEach>
		</div>
	</div>
</body>
</html>