package libreria.negocio;

import java.util.ArrayList;

import libreria.accesobd.GestionLibrosDAO;

public class GestionLibrosNegocio {
	
	
	public GestionLibrosNegocio(){
		
	}
	
	public ArrayList<TOLibros> cargaInicial(){
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		ArrayList<TOLibros> listaLibros = new ArrayList<TOLibros>();
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
	
	
	public TOLibros getDetalle(int isbn) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		return gestionLibros.getDetalle(isbn);
	}

	public ArrayList<TOLibros> buscarLibros(String texto) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		ArrayList<TOLibros> listaLibros = new ArrayList<TOLibros>();
		listaLibros = gestionLibros.buscarLibros(texto);
		return listaLibros;
	}
	
	public ArrayList<TOLibros> buscarLibroPorISBN(int isbn) throws Exception{
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		ArrayList<TOLibros> listaLibros = new ArrayList<TOLibros>();
		listaLibros = gestionLibros.buscarLibrosPorISBN(isbn);
		return listaLibros;
	}
}
