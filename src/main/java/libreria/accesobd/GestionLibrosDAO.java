package libreria.accesobd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libreria.negocio.TOLibros;

public class GestionLibrosDAO {

	public GestionLibrosDAO(){
		
	}
	
	public void crearTablaLibros() throws Exception{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			//String sqlDelete = ("DROP TABLE TBLIBROS");
			String sqlCreate = ("CREATE TABLE IF NOT EXISTS TBLIBROS (ISBN INTEGER IDENTITY PRIMARY KEY, NOMBRE VARCHAR(255) NOT NULL, AUTOR VARCHAR(255) NOT NULL, "
					+ " EDITORIAL VARCHAR(255), FECHA DATE, ESTADO VARCHAR(255), NUMPAG INTEGER);");
			st.executeUpdate(sqlCreate);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			throw new Exception("Error en la operación");
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
			String sqlInsert = ("INSERT INTO TBLIBROS VALUES (1, 'Aprendiendo de los mejores', 'Fco. Alcaide', 'Alienta', '2014-01-02', 'Nuevo', 295)");
			String sqlInsert1 = ("INSERT INTO TBLIBROS VALUES (2, 'Steve Job', 'Walter Isaacson', 'Debate', '2012-10-12', 'Nuevo', 428)");
			String sqlInsert2 = ("INSERT INTO TBLIBROS VALUES (3, 'Un click', 'RICHARD L. BRANDT', 'Gestion 2000', '2015-11-03', 'Nuevo', 232)");
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
	
	public ArrayList<TOLibros> getLibros() throws Exception{
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
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return listaLibros;
	}
	
	public TOLibros getDetalle(int isbn) throws Exception{
		TOLibros libro = new TOLibros();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS WHERE ISBN="+isbn+";");
			ResultSet rs = st.executeQuery(sqlSelect);
			while (rs.next()) {
				libro.setIsbn(rs.getInt("ISBN"));
				libro.setNombre(rs.getString("NOMBRE"));
				libro.setAutor(rs.getString("AUTOR"));
				libro.setEditorial(rs.getString("EDITORIAL"));
				libro.setFecha(rs.getDate("FECHA"));
				libro.setEstado(rs.getString("ESTADO"));
				libro.setNumPag(rs.getInt("NUMPAG"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return libro;
	}
	
	public ArrayList<TOLibros> buscarLibros(String texto) throws Exception{
		ArrayList<TOLibros> listaLibros = new ArrayList<TOLibros>();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS WHERE (UPPER(NOMBRE) LIKE UPPER('%"+texto+"%') OR UPPER(AUTOR) LIKE UPPER('%"+texto+"%') OR UPPER(EDITORIAL) LIKE UPPER('%"+texto+"%'))");
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
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return listaLibros;
	}
	
	public ArrayList<TOLibros> buscarLibrosPorISBN(int isbn) throws Exception{
		ArrayList<TOLibros> listaLibros = new ArrayList<TOLibros>();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS WHERE ISBN = "+isbn+";");
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
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return listaLibros;
	}
	
	public void altaLibro(int isbn, String nombre, String autor, String editorial, Date fecha, String estado, int numPag) throws Exception{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlInsert = ("INSERT INTO TBLIBROS VALUES ("+isbn+", '"+nombre+"', '"+autor+"', '"+editorial+"', '"+fecha+"', '"+estado+"', "+numPag+")");
			st.executeUpdate(sqlInsert);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
	}
	//TODO falta meter la relacion en la tabla TBLIBROSUSU
}
