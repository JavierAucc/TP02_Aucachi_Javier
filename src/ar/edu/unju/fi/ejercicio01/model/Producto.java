package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precio_unitario;
	private OrigenFabricacion origen;
	private Categoria categoria;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String codigo, String descripcion, double precio_unitario, OrigenFabricacion origen,
			Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio_unitario = precio_unitario;
		this.origen = origen;
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	
	public OrigenFabricacion getOrigen() {
		return origen;
	}

	public void setOrigen(OrigenFabricacion origen) {
		this.origen = origen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	// TIPOS ENUMERADOS SOLO NO PUEDEN SER SETEADOS
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR,HERRAMIENTAS
	}
	@Override
	public String toString() {
		return "Codigo = " + codigo + ", descripcion=" + descripcion + ", precio_unitario=" + precio_unitario
				+ ", origen=" + origen + ", categoria=" + categoria + "]";
	}
	
	
}
