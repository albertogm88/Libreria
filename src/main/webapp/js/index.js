$(document).ready(function(){
		$.ajax({
			type: "GET",
			url: "./cargaInicial",
			dataType: "json",
			success: function(data) {
				$(data).each(function(index, item) {
					$("#resultado").append("<div class='libro'><input type='hidden' value='"+item.isbn+"'><p><h3>"+item.nombre+"</h3></p><p>Escrito por: "+item.autor+"</p><p>Editorial: "+item.editorial+"</p></span></div>");	
				});	
	 	  	}
		});
		$(document).on('click', ".libro", function(){
			$("#marco").hide();
			$("#detalle").empty();
			$.ajax({
				type: "GET",
				url: "./detalle",
				data: "isbn="+$(this).find("input").val(),
				success: function(data) {
					$("#detalle").append(data);
					$("#marco").show();
				}
			});
		});
		$(document).on('click', "#cerrar", function(){
			$("#marco").hide();
			$("#detalle").empty();
		});
		$(document).on('click', "#buscar", function(){
			if($("#texto").val()!=""){
				$.ajax({
					type: "GET",
					url: "./buscar",
					data: "texto="+$("#texto").val(),
					dataType: "json",
					success: function(data) {
						$("#resultado").empty();
						$(data).each(function(index, item) {
							$("#resultado").append("<div class='libro'><input type='hidden' value='"+item.isbn+"'><p><h3>"+item.nombre+"</h3></p><p>Escrito por: "+item.autor+"</p><p>Editorial: "+item.editorial+"</p></span></div>");	
						});	
			 	  	}
				});
			}else{
				alert("Debes escribir algo");
			}
		});
		$(document).on('click', "#isbnBuscar", function(){
			if($("#isbnTexto").val()!=""){
				if(!isNaN($("#isbnTexto").val())){
					$.ajax({
						type: "GET",
						url: "./buscarPorISBN",
						data: "isbn="+$("#isbnTexto").val(),
						dataType: "json",
						success: function(data) {
							$("#resultado").empty();
							$(data).each(function(index, item) {
								$("#resultado").append("<div class='libro'><input type='hidden' value='"+item.isbn+"'><p><h3>"+item.nombre+"</h3></p><p>Escrito por: "+item.autor+"</p><p>Editorial: "+item.editorial+"</p></span></div>");	
							});	
				 	  	}
					});
				}
			}else{
				alert("Debes escribir algo");
			}
		});
	});
