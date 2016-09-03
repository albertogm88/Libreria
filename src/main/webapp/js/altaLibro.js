
function altaLibro(){
	
	var nombre = document.forms["altaLibro"]["nombre"].value;
	var autor = document.forms["altaLibro"]["autor"].value;
	var editorial = document.forms["altaLibro"]["editorial"].value;
	var fecha = document.forms["altaLibro"]["fecha"].value;
	var numPags = document.forms["altaLibro"]["numPags"].value;
	var estado = document.forms["altaLibro"]["estado"].value;
	if(validarDatos(nombre, autor, editorial, numPags, fecha)){
		$.ajax({
			type: "POST",
			url: "../altaLibro",
			dataType: "json",
			data: "nombre="+nombre+"&autor="+autor+"&editorial="+editorial+"&fecha="+fecha+"&numPags="+parseInt(numPags)+"&estado="+estado,
			
		});
	}	
}

function validarDatos(nombre, autor, editorial, numPags, fecha){
	var estadoValidacion = true;
	
	if(nombre == null || nombre == ""){
		alert("Debe rellenar el nombre del libro");
		estadoValidacion = false;
	}
	if(autor == null || autor == ""){
		alert("Debe rellenar el nombre del autor del libro");
		estadoValidacion = false;
	}
	if(editorial == null || editorial == ""){
		alert("Debe rellenar la editorial del libro");
		estadoValidacion = false;
	}
	if(parseInt(numPags) <= 0){
		alert("El número de páginas del libro debe ser mayor a 0");
		estadoValidacion = false;
	}
	var re = /^\d{4}\-\d{1,2}\-\d{1,2}$/;
    if(fecha != '' && !fecha.match(re)) {
    	alert("Formato de la fecha incorrecto");
    	estadoValidacion = false;
    }
	return estadoValidacion;
}
