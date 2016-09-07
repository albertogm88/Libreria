package libreria.negocio;

import java.util.ArrayList;

import libreria.accesobd.GestionLibrosDAO;

public class GestionLibrosNegocio {
	
	GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
	
	public GestionLibrosNegocio(){	
		
	}
	
	public ArrayList<TOLibro> cargaInicial(){
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
		return gestionLibros.getDetalle(isbn);
	}

	public ArrayList<TOLibro> buscarLibros(String texto) throws Exception{
		return gestionLibros.buscarLibros(texto);
	}
	
	public TOLibro buscarLibroPorISBN(int isbn) throws Exception{
		return gestionLibros.buscarLibrosPorISBN(isbn);
	}
	
	public ArrayList<TOLibro> getTodosLibrosUsuario(int idUsu) throws Exception{
		return gestionLibros.getTodosLibrosUsuario(idUsu);
	}
	
	public void altaLibro(TOLibro libro, int idUsu) throws Exception{
		int isbn = gestionLibros.altaLibro(libro);
		gestionLibros.altaLibroUsuario(isbn, idUsu);
	} 
	
	public void bajaLibrosUsuario(long idUsu) throws Exception{
		gestionLibros.eliminarLibrosUsuario(idUsu);
	}
}
