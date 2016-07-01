package libreria.accesobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libreria.negocio.TOUsuarios;

public class GestionUsuariosDAO {
	
	public GestionUsuariosDAO(){
		
	}
	
	public void crearTablaUsuarios() throws Exception{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			//String sqlDelete = ("DROP TABLE TBUSUARIOS");
			String sqlCreate = ("CREATE TABLE IF NOT EXISTS TBUSUARIOS (ID INTEGER IDENTITY PRIMARY KEY, NOMBRE VARCHAR(255) NOT NULL, PASS VARCHAR(255) NOT NULL, "
					+ " EMAIL VARCHAR(255), PROVINCIA VARCHAR(255), TIPO VARCHAR(255), INDBAJA VARCHAR(255), CONSTRAINT CTR_NOMBRE UNIQUE (NOMBRE), CONSTRAINT CTR_MAIL UNIQUE (EMAIL));");
			st.executeUpdate(sqlCreate);
		} catch (ClassNotFoundException e) {
			throw new Exception("Error al crear la clase de conexion");
		}catch(SQLException e){
			throw new Exception("Error en la operación");
		} finally{
			st.close();
			conexion.close();
		}
	}
	
	public TOUsuarios inicioSesion(String nombre, String pass) throws Exception{
		Connection conexion = null;
		TOUsuarios usuarios = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sql = ("SELECT * FROM TBUSUARIOS WHERE NOMBRE = '"+nombre+"' AND PASS = '"+pass+"';");
			rs = st.executeQuery(sql);
			if(rs.next()){ 
				usuarios = new TOUsuarios();
				usuarios.setId(rs.getInt("ID"));
				usuarios.setNombre(rs.getString("NOMBRE"));
				usuarios.setPass(rs.getString("PASS"));
				usuarios.setEmail(rs.getString("EMAIL"));
				usuarios.setProvincia(rs.getString("PROVINCIA"));
				usuarios.setTipoUsuario(rs.getString("TIPO"));
				usuarios.setIndBaja(rs.getString("INDBAJA"));
			}
			
		} catch (ClassNotFoundException e) {
			throw new Exception("Error al crear la clase de conexion"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}	
		return usuarios;
	}
	
	public boolean crearPerfil(String nombre, String pass, String email, String provincia, String tipo) throws Exception{
		Connection conexion = null;
		Statement st = null;
		int i = 0;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sql = ("INSERT INTO TBUSUARIOS (NOMBRE, PASS, EMAIL, PROVINCIA, TIPO, INDBAJA) "
					+ "VALUES('"+nombre+"', '"+pass+"', '"+email+"', '"+provincia+"', '"+tipo+"', 'N');");
			i= st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			throw new Exception("Error al crear la clase de conexion"+e.getMessage());
		}catch(SQLException e){
			if("23505".equals(e.getSQLState())){
				throw new Exception("Algunos de los datos introducidos ya existen en la base de datos");
			}else{
				throw new Exception(e.getMessage());
			}
		} finally{
			st.close();
			conexion.close();
		}	
		return i>=1;
	}
	
	public TOUsuarios getUsuario(int id) throws Exception{
		Connection conexion = null;
		TOUsuarios usuarios = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sql = ("SELECT * FROM TBUSUARIOS WHERE ID = "+id+";");
			rs = st.executeQuery(sql);
			if(rs.next()){ 
				usuarios = new TOUsuarios();
				usuarios.setId(rs.getInt("ID"));
				usuarios.setNombre(rs.getString("NOMBRE"));
				usuarios.setPass(rs.getString("PASS"));
				usuarios.setEmail(rs.getString("EMAIL"));
				usuarios.setProvincia(rs.getString("PROVINCIA"));
				usuarios.setTipoUsuario(rs.getString("TIPO"));
				usuarios.setIndBaja(rs.getString("INDBAJA"));
			}
			
		} catch (ClassNotFoundException e) {
			throw new Exception("Error al crear la clase de conexion"+e.getMessage());
		}catch(SQLException e){
			throw new Exception("Error en la operación"+e.getMessage());
		} finally{
			st.close();
			conexion.close();
		}	
		return usuarios;
	}
	
}
