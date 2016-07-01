package libreria.negocio;


import libreria.accesobd.GestionUsuariosDAO;

public class GestionUsuariosNegocio {
	
	GestionUsuariosDAO gestionUsuarios = new GestionUsuariosDAO();
	public GestionUsuariosNegocio(){	
	}
	
	public TOUsuarios inicioSesion(String nombre, String pass) throws Exception{
		return gestionUsuarios.inicioSesion(nombre, pass);
	}
	
	public boolean crearPerfil(String nombre, String pass, String email, String provincia, String tipo) throws Exception{
		return gestionUsuarios.crearPerfil(nombre, pass, email, provincia, tipo);
	}
	
	public void crearTablaUsuarios() throws Exception{
		gestionUsuarios.crearTablaUsuarios();
	}
	
	public TOUsuarios getUsuario(int id) throws Exception{
		return gestionUsuarios.getUsuario(id);
	}
	
}
