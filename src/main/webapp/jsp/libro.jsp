<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalle libro</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
<script src="./jquery/jquery-1.9.js"></script>
</head>
<body>
	<div id="principal">
		<h2>${LIBRO.nombre}</h2>
		<p><strong>Autor:</strong> ${LIBRO.autor}. <strong>Año de publicación:</strong> (${LIBRO.fecha})</p>
		<p><strong>Editorial:</strong> ${LIBRO.editorial}</p>
		<p><strong>Número de páginas:</strong> ${LIBRO.numPag}</p>
		<p><strong>Estado del libro:</strong> ${LIBRO.estado}</p>
		<p><input type="button" name="Comprar" value="Comprar"></p>
	</div>
</body>
</html>