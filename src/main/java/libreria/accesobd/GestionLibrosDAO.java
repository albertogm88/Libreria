package libreria.accesobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import libreria.negocio.TOLibro;

public class GestionLibrosDAO {

	public GestionLibrosDAO(){
		
	}
	
	public void crearTablaLibros() throws Exception{
		Connection conexion = null;
		Statement st = null;
		Statement st1 = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			st1 = conexion.createStatement();
			//String sqlDelete = ("DROP TABLE TBLIBROS");
			//String sqlDeleteRel = ("DROP TABLE TBLIBROUSU");
			String sqlCreate = ("CREATE TABLE IF NOT EXISTS TBLIBROS (ISBN INTEGER IDENTITY PRIMARY KEY, NOMBRE VARCHAR(255) NOT NULL, AUTOR VARCHAR(255) NOT NULL, "
					+ " EDITORIAL VARCHAR(255), FECHA DATE, ESTADO VARCHAR(255), NUMPAG INTEGER);");
			String sqlCreateLibrosUsu = ("CREATE TABLE IF NOT EXISTS TBLIBROUSU (ISBN INTEGER IDENTITY NOT NULL, IDUSU INTEGER NOT NULL);");
			st.executeUpdate(sqlCreate);
			st1.executeUpdate(sqlCreateLibrosUsu);
		} catch (ClassNotFoundException e) {
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación");
		} finally{
			st.close();
			st1.close();
			conexion.close();
		}
	}
	
	public void cargaInicial() throws Exception{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlInsert = ("INSERT INTO TBLIBROS VALUES (1, 'Aprendiendo de los mejores', 'Fco. Alcaide', 'Alienta', '2014-01-02', 'Nuevo', 295)");
			String sqlInsertRel = ("INSERT INTO TBLIBROUSU VALUES(1, 0)");
			String sqlInsert1 = ("INSERT INTO TBLIBROS VALUES (2, 'Steve Job', 'Walter Isaacson', 'Debate', '2012-10-12', 'Nuevo', 428)");
			String sqlInsert1Rel = ("INSERT INTO TBLIBROUSU VALUES(2, 0)");
			String sqlInsert2 = ("INSERT INTO TBLIBROS VALUES (3, 'Un click', 'RICHARD L. BRANDT', 'Gestion 2000', '2015-11-03', 'Nuevo', 232)");
			String sqlInsert2Rel = ("INSERT INTO TBLIBROUSU VALUES(3, 0)");
			st.executeUpdate(sqlInsert);
			st.executeUpdate(sqlInsert1);
			st.executeUpdate(sqlInsert2);
			st.executeUpdate(sqlInsertRel);
			st.executeUpdate(sqlInsert1Rel);
			st.executeUpdate(sqlInsert2Rel);
		
		} catch (ClassNotFoundException e) {
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}	
	}
	
	public ArrayList<TOLibro> getLibros() throws Exception{
		ArrayList<TOLibro> listaLibros = new ArrayList<TOLibro>();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS");
			ResultSet rs = st.executeQuery(sqlSelect);
			while (rs.next()) {
				TOLibro libro = new TOLibro();
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
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return listaLibros;
	}
	
	public String getLibrosUsu() throws Exception{
		Connection conexion = null;
		Statement st = null;
		String result = new String();
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROUSU");
			ResultSet rs = st.executeQuery(sqlSelect);
			while (rs.next()) {
				result += rs.getInt("ISBN")+"/";
				result += rs.getInt("IDUSU")+"/";
			}
			
		} catch (ClassNotFoundException e) {
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return result;
	}
	
	public TOLibro getDetalle(int isbn) throws Exception{
		TOLibro libro = new TOLibro();
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
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return libro;
	}
	
	public ArrayList<TOLibro> buscarLibros(String texto) throws Exception{
		ArrayList<TOLibro> listaLibros = new ArrayList<TOLibro>();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS WHERE (UPPER(NOMBRE) LIKE UPPER('%"+texto+"%') OR UPPER(AUTOR) LIKE UPPER('%"+texto+"%') OR UPPER(EDITORIAL) LIKE UPPER('%"+texto+"%'))");
			ResultSet rs = st.executeQuery(sqlSelect);
			while (rs.next()) {
				TOLibro libro = new TOLibro();
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
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return listaLibros;
	}
	
	public TOLibro buscarLibrosPorISBN(int isbn) throws Exception{
		TOLibro libro = new TOLibro();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS WHERE ISBN = "+isbn+";");
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
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return libro;
	}
	
	public int altaLibro(TOLibro libro) throws Exception{
		Connection conexion = null;
		Statement st = null;
		int isbnInsertado = 0;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			String fecha = df.format(libro.getFecha());
			String sqlInsert = ("INSERT INTO TBLIBROS (NOMBRE, AUTOR, EDITORIAL, FECHA, ESTADO, NUMPAG) VALUES ('"+libro.getNombre()+"', '"+libro.getAutor()+"', "
					+ "'"+libro.getEditorial()+"', '"+fecha+"', '"+libro.getEstado()+"', "+libro.getNumPag()+")");
			//String sqlNext = ("CALL IDENTITY();");
			st.executeUpdate(sqlInsert);
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
	            isbnInsertado = rs.getInt(1);
	        }
		
		} catch (ClassNotFoundException e) {
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return isbnInsertado;
	}
	
	public void altaLibroUsuario(int isbn, int idUsu) throws Exception{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlInsert = ("INSERT INTO TBLIBROUSU VALUES ("+isbn+", '"+idUsu+")");
			st.executeUpdate(sqlInsert);
		
		} catch (ClassNotFoundException e) {
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
	}
	
	public ArrayList<TOLibro> getTodosLibrosUsuario(int idUsu) throws Exception{
		ArrayList<TOLibro> listaLibros = new ArrayList<TOLibro>();
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlSelect = ("SELECT * FROM TBLIBROS WHERE ISBN IN (SELECT ISBN FROM TBLIBROUSU WHERE IDUSU = "+idUsu+");");
			ResultSet rs = st.executeQuery(sqlSelect);
			while (rs.next()) {
				TOLibro libro = new TOLibro();
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
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
		return listaLibros;
	}
	
	
	public void eliminarLibrosUsuario(long idUsu) throws Exception{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sqlDelete = ("DELETE FROM TBLIBROS WHERE ISBN IN (SELECT ISBN FROM TBLIBROUSU WHERE IDUSU = "+idUsu+");");
			String sqlDeleteRel = ("DELETE FROM TBLIBROUSU WHERE IDUSU = "+idUsu+";");
			st.executeUpdate(sqlDelete);
			st.executeUpdate(sqlDeleteRel);
			
		} catch (ClassNotFoundException e) {
			throw new Exception("Error en la operación"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}
	}
}
