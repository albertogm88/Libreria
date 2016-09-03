package libreria.negocio;

import java.util.ArrayList;

import libreria.accesobd.GestionLibrosDAO;

public class GestionLibrosNegocio {
	
	public GestionLibrosNegocio(){	
	}
	
	public ArrayList<TOLibro> cargaInicial(){
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		ArrayList<TOLibro> listaLibros = new ArrayList<TOLibro>();
		try {
			gestionLibros.crearTablaLibros();
			listaLibros = gestionLibros.getLibros();
			if(listaLibros.size()<=0){
				gestionLibros.cargaInicial();
				listaLibros = gestionLibros.getLibros();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibros;
	}
	
	
	public TOLibro getDetalle(int isbn) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		return gestionLibros.getDetalle(isbn);
	}

	public ArrayList<TOLibro> buscarLibros(String texto) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		return gestionLibros.buscarLibros(texto);
	}
	
	public TOLibro buscarLibroPorISBN(int isbn) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		return gestionLibros.buscarLibrosPorISBN(isbn);
	}
	
	public ArrayList<TOLibro> getTodosLibrosUsuario(int idUsu) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		return gestionLibros.getTodosLibrosUsuario(idUsu);
	}
	
	public void altaLibro(TOLibro libro, int idUsu) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		int isbn = gestionLibros.altaLibro(libro);
		gestionLibros.altaLibroUsuario(isbn, idUsu);
	} 
}
