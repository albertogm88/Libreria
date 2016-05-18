package libreria.accesobd;

public class CrearConexion {

	
	public CrearConexion() throws ClassNotFoundException{
		Class.forName("org.hsqldb.jdbcDriver");
	}
}
