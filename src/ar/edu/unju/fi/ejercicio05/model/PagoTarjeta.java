package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numeroTarjeta;
	private LocalDate fechaDePago;
	private double montoPagado;
//constructor
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaDePago, double montoPagado) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}
//getter y setters
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public LocalDate getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public double getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
//metodos de la interfaz
	@Override
	public void realizarPago(double monto) {
		
	}
	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		
	}
	
	
}
