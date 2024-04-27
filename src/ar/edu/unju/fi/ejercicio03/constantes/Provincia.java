package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY,SALTA,TUCUMAN,LA_RIOJA,SANTIAGO_DEL_ESTERO;
	
	private long cantidadPoblacion;
	private double superficie;
	
	private Provincia() {
		// TODO Auto-generated constructor stub
	}
	private Provincia(long cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public long getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(long cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	} 
	
	
}
