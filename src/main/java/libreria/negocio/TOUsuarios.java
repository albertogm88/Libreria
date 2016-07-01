package libreria.negocio;

public class TOUsuarios {
	
	private int id;
	private String nombre;
	private String pass;
	private String email;
	private String provincia;
	private String tipoUsuario;
	private String indBaja;
	
	public TOUsuarios() {
		this.id = 0;
		this.nombre = null;
		this.pass = null;
		this.email = null;
		this.provincia = null;
		this.tipoUsuario = null;
		this.indBaja = null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getIndBaja() {
		return indBaja;
	}
	public void setIndBaja(String indBaja) {
		this.indBaja = indBaja;
	}

}
