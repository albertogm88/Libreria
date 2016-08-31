package libreria.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import libreria.negocio.GestionLibrosNegocio;
import libreria.negocio.TOLibros;

@Controller
public class LibroController {
	
	@RequestMapping(value="/detalle", method = RequestMethod.GET)
	public ModelAndView getDetalle(@RequestParam("isbn") int isbn) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		TOLibros libro = gestionLibros.getDetalle(isbn);
		return new ModelAndView("libro", "LIBRO", libro);
	}

	@RequestMapping(value="/buscar", method = RequestMethod.GET)
	@ResponseBody public ArrayList<TOLibros> buscarLibros(@RequestParam("texto") String texto) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		ArrayList<TOLibros> libros = gestionLibros.buscarLibros(texto);
		return libros;
	}
	
	@RequestMapping(value="/buscarPorISBN", method = RequestMethod.GET)
	@ResponseBody public ArrayList<TOLibros> buscarLibros(@RequestParam("isbn") int isbn) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		ArrayList<TOLibros> libros = gestionLibros.buscarLibroPorISBN(isbn);
		return libros;
	}
	
	@RequestMapping(value="/buscarPorUsuario", method = RequestMethod.GET)
	@ResponseBody public ArrayList<TOLibros> buscarLibrosPorUsuario(@RequestParam("isbn") int isbn) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		ArrayList<TOLibros> libros = gestionLibros.buscarLibroPorISBN(isbn);
		return libros;
	}
}
