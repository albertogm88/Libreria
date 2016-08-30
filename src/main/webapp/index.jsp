<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Librería Virtual</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script src="jquery/jquery-1.9.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div id="principal">
		<div id="cabecera">
			<h2>Bienvenido a tu librería virtual</h2>
			<br>	
		</div>
		<div id="acceso">
		<c:if test="${not empty USUARIO}">
			Has iniciado sesión como ${USUARIO.nombre}. <a href="./cerrarSesion">Cerrar sesión</a>
		</c:if>
		<c:if test="${empty USUARIO}">
			<a href="jsp/login.jsp">Inicia sesión / Regístrate</a>
			<a href="./usuarios">Usuarios</a>
		</c:if>
		</div>
		<div id="filtro">
			<p>Búsqueda de libros (Puedes buscar por autor, editorial o título): <input type="text" id="texto">
			<input type="button" value="Buscar" id="buscar" name="buscar">
			<br>
			Si conoces el ISBN, búscalo aquí: <input type="text" id="isbnTexto" placeholder="Búsqueda por ISBN">
			<input type="button" value="Buscar" id="isbnBuscar" name="isbnBuscar"></p>
		</div>
		<div style="clear: both"></div>
		<p>Libros actualmente disponibles:</p>
		<div id="resultado"></div>
		<div id="marco">
			<span id="cerrar">Cerrar [x]</span>
			<div id="detalle">
			</div>
		</div>
		<div style="clear: both"></div>
	</div>
</body>
</html>