<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de nuevo libro</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
<script src="./jquery/jquery-1.9.js"></script>
</head>
<body>
	<div id="principal">
		<div id="cabecera">
			<h2>Datos del nuevo libro</h2>
			<br>	
		</div>
		<label for="nombre">Nombre del libro</label><input id="nombre" type="text">
		<label for="autor">Autor del libro</label><input id="autor" type="text">
		<label for="editorial">Editorial del libro</label><input id="editorial" type="text">
		<label for="numPags">Número de páginas</label><input id="numPags" type="text">
		<label for="estado">Estado del libro</label>
		<select id="estado">
			<option>Nuevo</option>
			<option>Seminuevo</option>
			<option>Signos de uso</option>
		</select>
		<input type="button" value="Dar de alta">
	</div>

</body>
</html>