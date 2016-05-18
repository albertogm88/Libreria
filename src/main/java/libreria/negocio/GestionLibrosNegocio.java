package libreria.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import libreria.accesobd.GestionLibrosDAO;

public class GestionLibrosNegocio {
	
	
	public GestionLibrosNegocio(){
		
	}
	
	public ArrayList<TOLibros> cargaInicial(){
		GestionLibrosDAO gestionLibros = new GestionLibrosDAO();
		ArrayList<TOLibros> listaLibros = new ArrayList<TOLibros>();
		try {
			if(gestionLibros.getCountLibros() <= 0){
				gestionLibros.crearBBDD();
				gestionLibros.cargaInicial();
			}
			listaLibros = gestionLibros.getLibros();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibros;
	}

}
