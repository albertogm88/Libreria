package libreria.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import libreria.negocio.GestionLibrosNegocio;
import libreria.negocio.TOLibros;


@Controller
public class Login {
	
	@RequestMapping(value="/cargaInicial", method = RequestMethod.GET)
	public @ResponseBody ArrayList<TOLibros> getPortada(){
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		return gestionLibros.cargaInicial();
	}
	
}
