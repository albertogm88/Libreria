<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perfil del usuario</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
<script src="./jquery/jquery-1.9.js"></script>
<style type="text/css">
	#menuLibros{
		text-align: center;
	}
	#menuCliente{
		text-align: center;
	}
	#menuCliente div{
		background-color: #E63946;
		cursor: pointer;
	}
	#menuLibros div{
		cursor: pointer;
	}
</style>
</head>
<body>
	<div id="principal">
		<h2>${USUARIO.nombre} estas en tu área de usuario</h2><span style="text-align: right;"><a href=".">Volver al inicio</a></span>
		<div id="menuLibros">
			<h3>Menú contextual libros:</h3>
			<div class='libro'>Alta de un nuevo libro</div>
			<div class='libro'>Modificación de un libro</div>
			<div class='libro'>Dar de baja un libro</div>
		</div>
		<br><br>
		<div id="menuCliente">
			<h3>Menú contextual usuario:</h3>
			<div class='libro'>Darse de baja en el sistema</div>
			<c:if test="${USUARIO.tipoUsuario != 'R'}">
				<div class='libro'>Dar de baja usuario</div>
			</c:if>
		</div>
	</div>

</body>
</html>