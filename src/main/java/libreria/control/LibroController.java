package libreria.control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import libreria.accesobd.GestionLibrosDAO;
import libreria.negocio.GestionLibrosNegocio;
import libreria.negocio.TOLibro;
import libreria.negocio.TOUsuario;

@Controller
public class LibroController {
	
	/**
	 * Visualiza el detalle de un libro
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/detalle", method = RequestMethod.GET)
	public ModelAndView getDetalle(@RequestParam("isbn") int isbn) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		TOLibro libro = gestionLibros.getDetalle(isbn);
		return new ModelAndView("libro", "LIBRO", libro);
	}
	/**
	 * Busca un libro por un texto que puede ser el título, el autor o la editorial
	 * @param texto
	 * @return lista de libros que coinciden con la búsqueda
	 * @throws Exception
	 */
	@RequestMapping(value="/buscar", method = RequestMethod.GET)
	@ResponseBody public ArrayList<TOLibro> buscarLibros(@RequestParam("texto") String texto) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		ArrayList<TOLibro> libros = gestionLibros.buscarLibros(texto);
		return libros;
	}
	/**
	 * Busca un libro por su número ISBN
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/buscarPorISBN", method = RequestMethod.GET)
	@ResponseBody public TOLibro buscarLibros(@RequestParam("isbn") int isbn) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		TOLibro libro = gestionLibros.buscarLibroPorISBN(isbn);
		return libro;
	}
	
	@RequestMapping(value="/buscarPorUsuario", method = RequestMethod.GET)
	@ResponseBody public ArrayList<TOLibro> buscarLibrosPorUsuario(@RequestParam("idUsu") int id) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		ArrayList<TOLibro> libros = gestionLibros.getTodosLibrosUsuario(id);
		return libros;
	}
	
	@RequestMapping(value="/altaLibro", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody public void altaLibro(@RequestParam("nombre") String nombre, @RequestParam("autor")  String autor, @RequestParam("editorial") String editorial,
			@RequestParam("fecha") String fecha, @RequestParam("numPags") int numPags, @RequestParam("estado") String estado, HttpServletRequest req) throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		HttpSession session= req.getSession(true);
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	    Date fechaFormateada = df.parse(fecha);
		//Creamos un objeto libro con los datos obtenidos para al negocio de alta
		TOLibro libro = new TOLibro();
		libro.setNombre(nombre);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libro.setFecha(fechaFormateada);
		libro.setNumPag(numPags);
		libro.setEstado(estado);
		TOUsuario usuario = (TOUsuario) session.getAttribute("USUARIO");
		int idUsu = usuario.getId();
		ArrayList<TOLibro> listadoLibros = gestionLibros.getTodosLibrosUsuario(idUsu);
		if("R".equals(usuario.getTipoUsuario()) && listadoLibros.size()<=10){
			gestionLibros.altaLibro(libro, idUsu);
		}
	}
	
	@RequestMapping(value="/libros",  method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody public String getTodosUsuario() throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		return gestionLibros.getLibrosUsu();
	}
	
}