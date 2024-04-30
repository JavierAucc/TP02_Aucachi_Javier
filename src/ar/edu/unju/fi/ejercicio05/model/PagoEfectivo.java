package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private Double montoPagado;
	private LocalDate fechaDePago;
	
	
	public PagoEfectivo(Double montoPagado, LocalDate fechaDePago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaDePago = fechaDePago;
	}
	
	public Double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	@Override
	public void realizarPago(double monto) {
		setMontoPagado(this.montoPagado-(this.montoPagado*10/100));
	}

	@Override
	public void imprimirRecibo() {
		System.out.println(" -- Fecha de Pago: "+this.fechaDePago);
		System.out.println(" -- Monto a Pagar con Descuento: "+this.montoPagado);
		
	}
	
}
