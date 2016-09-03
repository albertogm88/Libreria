package libreria.negocio;

import java.util.Date;

public class TOLibro {

	private int isbn;
	private String nombre;
	private String autor;
	private String editorial;
	private Date fecha;
	private String estado;
	private int numPag;
	
	public TOLibro(){
		this.isbn = 0;
		this.nombre = null;
		this.autor = null;
		this.editorial = null;
		this.fecha = null;
		this.estado = null;
		this.numPag = 0;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	
}
