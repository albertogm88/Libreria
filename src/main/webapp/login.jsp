<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicia sesión/Darse de alta</title>
<script src="jquery/jquery-1.9.js"></script>
</head>
<body>
	<div>Aquí puedes iniciar sesión con tu usuario o si eres nuevo puedes darte de alta para poder publicar tus libros</div>
	<div><h3>Inicia sesión</h3>
		Nombre: <input type="text" id="nombre" name="nombre">
		Password: <input type="password" id="pass" name="pass">
		<input type="button" id="inicio" value="Inicia sesión">
	</div>
	<div>
		<h3>Crea un nuevo perfil</h3>
		Nombre: <input type="text" id="nombreNuevo" name="nombreNuevo">
		Password: <input type="password" id="passNuevo" name="passNuevo">
		Repite tu password: <input type="password" id="passNuevo2" name="passNuevo2">
		Email: <input type="text" id="email" name="email">
		Provincia: <input type="text" id="provincia" name="provincia">
		<input type="button" id="alta" value="Darse de alta">
	</div>
	
	
	<script type="text/javascript">
	$(function(){
        $("#inicio").click(validaUsuario);
    });
     
    function validaUsuario(){
        var name = $("#inicio").val();                
        $.get("/Libreria/login.do", { }, 
            preparaRespuesta
        );
    }
     
    function preparaRespuesta(data){
                alert("ppppp");
            }
	
	
	</script>
</body>
</html>