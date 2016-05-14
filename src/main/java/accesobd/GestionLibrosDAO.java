package accesobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import negocio.TOLibros;

public class GestionLibrosDAO {

	public GestionLibrosDAO(){
		
	}
	
	public void crearBBDD() throws SQLException{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlCreate = ("CREATE TABLE IF NOT EXISTS TBLIBROS (ISBN int, NOMBRE varchar(255), AUTOR varchar(255), "
					+ " EDITORIAL varchar(255), FECHA Date, ESTADO varchar(255), NUMPAG int);");
			st.executeUpdate(sqlCreate);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			st.close();
			conexion.close();
		}
	}
	
	public void cargaInicial() throws SQLException{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlInsert = ("INSERT INTO TBLIBROS VALUES (1, 'Aprendiendo de los mejores', 'Fco. Alcaide', 'Alienta', '2014/01/29', 'Nuevo', 295)");
			String sqlInsert1 = ("INSERT INTO TBLIBROS VALUES (2, 'Steve Job', 'Walter Isaacson', 'Debate', '2012/10/16', 'Nuevo', 428)");
			String sqlInsert2 = ("INSERT INTO TBLIBROS VALUES (3, 'Un click', 'RICHARD L. BRANDT', 'Gestion 2000', '2015/11/03', 'Nuevo', 232)");
			st.executeUpdate(sqlInsert);
			st.executeUpdate(sqlInsert1);
			st.executeUpdate(sqlInsert2);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			st.close();
			conexion.close();
		}	
	}
	
	public int getCountLibros() throws SQLException{
		int numLibros = 0;
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT COUNT(*) AS CONTADOR FROM TBLIBROS");
			ResultSet rs = st.executeQuery(sqlSelect);
			numLibros = rs.getInt("CONTADOR");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			st.close();
			conexion.close();
		}
		return numLibros;
	} 
	
	public ArrayList<TOLibros> getLibros() throws SQLException{
		ArrayList<TOLibros> listaLibros = new ArrayList<TOLibros>();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS");
			ResultSet rs = st.executeQuery(sqlSelect);
			while (rs.next()) {
				TOLibros libro = new TOLibros();
				libro.setIsbn(rs.getInt("ISBN"));
				libro.setNombre(rs.getString("NOMBRE"));
				libro.setAutor(rs.getString("AUTOR"));
				libro.setEditorial(rs.getString("EDITORIAL"));
				libro.setFecha(rs.getDate("FECHA"));
				libro.setEstado(rs.getString("ESTADO"));
				libro.setNumPag(rs.getInt("NUMPAG"));
				
				listaLibros.add(libro);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			st.close();
			conexion.close();
		}
		return listaLibros;
	}
}
