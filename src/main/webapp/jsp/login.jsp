<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicia sesión/Darse de alta</title>
<link rel="stylesheet" type="text/css" href="../style/style.css">
<script src="../jquery/jquery-1.9.js"></script>
</head>
<body>
	<div id="principal">
		<div>Aquí puedes iniciar sesión con tu usuario o si eres nuevo puedes darte de alta para poder publicar tus libros</div>
		<div id="inicio"><h3>Inicia sesión</h3>
			<label for="nombre">Nombre: </label><input type="text" id="nombre" name="nombre">
			<label for="pass">Password: </label><input type="password" id="pass" name="pass">
			<input type="button" id="inicio" value="Inicia sesión" onclick="validaInicio();">
		</div>
		<div id="nuevoPerfil">
			<h3>Crea un nuevo perfil</h3>
			<label for="nombreNuevo">Nombre: </label><input type="text" id="nombreNuevo" name="nombreNuevo">
			<br>
			<label for="passNuevo">Password: </label><input type="password" id="passNuevo" name="passNuevo">
			<br>
			<label for="password">Repite tu password: </label><input type="password" id="passNuevo2" name="passNuevo2">
			<br>
			<label for="email">Email: </label><input type="text" id="email" name="email">
			<br>
			<label for="provincia">Provincia: </label><input type="text" id="provincia" name="provincia">
			<br>
			<label for="tipo">Tipo usuario: </label>
			<br>
			<select id="tipo">
				<option value="R" selected>Usario Registrado</option>
				<option value="A">Usario administrador</option>
				<option value="L">Librería</option>
			</select>
			<input type="button" id="alta" value="Darse de alta" onclick="validaCrear();">
		</div>
		<div style="clear: both"></div>
	</div>
	
	<script type="text/javascript">
	function validaInicio(){
		if($("#nombre").val() && $("#pass").val()){
			$.ajax({
				type: "POST",
				url: "../inicioSesion",
				data: "nombre="+$("#nombre").val()+"&pass="+$("#pass").val(),
				dataType: "text",
				success: function(data){
					window.location ="../consultaPerfil?id="+data;
				},
				error:function(){
					alert('Usuario o contraseña incorrectos');
				}
			});
		}	
		return;
	}
	
	function validaCrear(){
		if($("#nombreNuevo").val() && $("#passNuevo").val() && $("#passNuevo2").val() && $("#email").val() && $("#provincia").val()){
			if($("#passNuevo").val() == $("#passNuevo2").val()){
				$.ajax({
					type: "POST",
					url: "../crearPerfil",
					dataType: "json",
					data: "nombre="+$("#nombreNuevo").val()+"&pass="+$("#passNuevo").val()+"&email="+$("#email").val()+"&provincia="+$("#provincia").val()+"&tipo="+$("#tipo").val(),
					success: function(data) {
						if(data){
							alert("Ha sido dado de alta correctamente. Prueba a iniciar sesión.");
						}
					},
					error:function(jqXHR, textStatus, errorThrown){
						if (jqXHR.status == 500) {
						    alert('Algunos de los datos introducidos ya existen en la base de datos');
						  }
					}
				});
			}
		}
	}
	
	</script>
</body>
</html>