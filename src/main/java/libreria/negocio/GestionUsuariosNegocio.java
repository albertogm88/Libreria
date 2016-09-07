package libreria.negocio;


import java.util.ArrayList;

import libreria.accesobd.GestionUsuariosDAO;

public class GestionUsuariosNegocio {
	
	GestionUsuariosDAO gestionUsuarios = new GestionUsuariosDAO();
	public GestionUsuariosNegocio(){	
	}
	
	public TOUsuario inicioSesion(String nombre, String pass) throws Exception{
		return gestionUsuarios.inicioSesion(nombre, pass);
	}
	
	public boolean crearPerfil(String nombre, String pass, String email, String provincia, String tipo) throws Exception{
		return gestionUsuarios.crearPerfil(nombre, pass, email, provincia, tipo);
	}
	
	public void crearTablaUsuarios() throws Exception{
		gestionUsuarios.crearTablaUsuarios();
	}
	
	public TOUsuario getUsuario(int id) throws Exception{
		return gestionUsuarios.getUsuario(id);
	}
	
	public ArrayList<TOUsuario> getTodosUsuario() throws Exception{
		return gestionUsuarios.getTodosUsuario();
	}
	
	public void darseBaja(long idUsu) throws Exception{
		gestionUsuarios.darseBaja(idUsu);
		GestionLibrosNegocio gestionLibros = new GestionLibrosNegocio();
		gestionLibros.bajaLibrosUsuario(idUsu);
	}
}
