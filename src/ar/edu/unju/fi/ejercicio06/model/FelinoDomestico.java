package ar.edu.unju.fi.ejercicio06.model;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;

public class FelinoDomestico implements Converter{
	private String nombre;
	private int edad;
	private float peso;
	
	public FelinoDomestico() {
		// TODO Auto-generated constructor stub
	}
	public FelinoDomestico(String nombre, int edad, float peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "FelinoDomestico [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	@Override
	public Object convert(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
