package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(700881,53244.2),SALTA(1424397,155340.5),TUCUMAN(1694656,22592.1),LA_RIOJA(393531,91493.7),
	SANTIAGO_DEL_ESTERO(978313,136934.3);
	
	private double cantidadPoblacion;
	private double superficie;
	
	private Provincia() {
		// TODO Auto-generated constructor stub
	}
	private Provincia(double cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public double getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}
	
	public Double calcularDensidad() {
		return this.cantidadPoblacion/this.superficie;
	}
}
