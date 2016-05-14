package accesobd;

public class CrearConexion {

	
	public CrearConexion() throws ClassNotFoundException{
		Class.forName("org.hsqldb.jdbcDriver");
	}
}
