package libreria.control;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import libreria.negocio.GestionLibrosNegocio;
import libreria.negocio.GestionUsuariosNegocio;
import libreria.negocio.TOLibros;
import libreria.negocio.TOUsuarios;


@Controller
public class UsuarioController {
	
	@RequestMapping(value="/cargaInicial", method = RequestMethod.GET)
	@ResponseBody public ArrayList<TOLibros> getPortada() throws Exception{
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		GestionUsuariosNegocio gestionUsuarios = new GestionUsuariosNegocio();
		gestionUsuarios.crearTablaUsuarios();
		ArrayList<TOLibros> libros = gestionLibros.cargaInicial();
		return libros;
	}
	
	@RequestMapping(value="/inicioSesion", method = RequestMethod.POST)
	@ResponseBody public int inicioSesion(@RequestParam("nombre") String nombre, @RequestParam("pass") String pass) throws Exception{
		GestionUsuariosNegocio gestionUsuarios = new GestionUsuariosNegocio();
		TOUsuarios usuario = gestionUsuarios.inicioSesion(nombre, pass);
		return usuario!=null?usuario.getId():null;
	}
	
	@RequestMapping(value="/cerrarSesion", method = {RequestMethod.POST, RequestMethod.GET})
	public String cerrarSesion(HttpServletRequest request) throws Exception{
 		HttpSession session= request.getSession(true);
		session.invalidate();
		return "../index";
	}
	
	@RequestMapping(value="/crearPerfil", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody public boolean crearPerfil(@RequestParam("nombre") String nombre, @RequestParam("pass") String pass,
			@RequestParam("email") String email, @RequestParam("provincia") String provincia, @RequestParam("tipo") String tipo) throws Exception{
		GestionUsuariosNegocio gestionUsuarios = new GestionUsuariosNegocio();
		boolean creado = gestionUsuarios.crearPerfil(nombre, pass, email, provincia, tipo);
		return creado;
	}
	
	@RequestMapping(value="/consultaPerfil", method = {RequestMethod.POST, RequestMethod.GET})
	public String getPerfil(@RequestParam("id") int id, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		GestionUsuariosNegocio gestionUsuarios = new GestionUsuariosNegocio();
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		HttpSession session= request.getSession(true);
		TOUsuarios usuario = gestionUsuarios.getUsuario(id);
		model.addAttribute("USUARIO", usuario);
		model.addAttribute("LIBROS", gestionLibros.getTodosLibrosUsuario(id));
		session.setAttribute("USUARIO",usuario);
		return "perfil";
	}
	@RequestMapping(value="/usuarios",  method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody public ArrayList<TOUsuarios> getTodosUsuario() throws Exception{
		GestionUsuariosNegocio gestionUsuarios = new GestionUsuariosNegocio();
		return gestionUsuarios.getTodosUsuario();
	}
	
}
