package libreria.accesobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusquedaDAO {
	
	
	
	
	private static void crearUsuario() throws SQLException{
		Connection conexion = null;
		Statement st = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:ficherodb", "libreria", "libreria");
			st = conexion.createStatement();
			String sql = ("INSERT INTO TBUSUARIOS VALUES (1, 'Alberto') WHERE NOT EXISTS (SELECT * FROM TBUSUARIOS WHERE id = 1 AND nombre = 'Alberto')"); 
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			st.close();
			conexion.close();
		}
	}
	public static void main(String[] args) throws SQLException{ 
	
	//altaUsuario() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement st = null;
		Statement stSelect = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			//crearConexion();
			connection = DriverManager.getConnection("jdbc:hsqldb:ficherodb", "libreria", "libreria");
			st = connection.createStatement();
			String sqlCreate = ("CREATE TABLE IF NOT EXISTS TBUSUARIOS (id int, nombre varchar(255));");
			st.executeUpdate(sqlCreate);
			String sqlSelect = ("SELECT id, nombre FROM TBUSUARIOS WHERE ID=1");
			stSelect = connection.createStatement();
			ResultSet rs = stSelect.executeQuery(sqlSelect);
			while (rs.next()) {
				System.out.println("SENTENCIA");
				System.out.println(rs.getLong("id"));
				System.out.println(rs.getString("nombre"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			st.close();
			stSelect.close();
			connection.close();
		}
	}

}
