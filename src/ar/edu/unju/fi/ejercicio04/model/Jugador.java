package ar.edu.unju.fi.ejercicio04.model;

	import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

	public class Jugador {
			private String nombre;
			private String apellido;
			private LocalDate fechaNacimiento;
			private String nacionalidad;
			private float estatura;
			private float peso;
			private Posicion posicion;
			
			public Jugador() {
				// TODO Auto-generated constructor stub
			}

			public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, float estatura,
					float peso, Posicion posicion) {
				super();
				this.nombre = nombre;
				this.apellido = apellido;
				this.fechaNacimiento = fechaNacimiento;
				this.nacionalidad = nacionalidad;
				this.estatura = estatura;
				this.peso = peso;
				this.posicion = posicion;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getApellido() {
				return apellido;
			}

			public void setApellido(String apellido) {
				this.apellido = apellido;
			}

			public LocalDate getFechaNacimiento() {
				return fechaNacimiento;
			}

			public void setFechaNacimiento(LocalDate fechaNacimiento) {
				this.fechaNacimiento = fechaNacimiento;
			}

			public String getNacionalidad() {
				return nacionalidad;
			}

			public void setNacionalidad(String nacionalidad) {
				this.nacionalidad = nacionalidad;
			}

			public float getEstatura() {
				return estatura;
			}

			public void setEstatura(float estatura) {
				this.estatura = estatura;
			}

			public float getPeso() {
				return peso;
			}

			public void setPeso(float peso) {
				this.peso = peso;
			}

			public Posicion getPosicion() {
				return posicion;
			}

			public void setPosicion(Posicion posicion) {
				this.posicion = posicion;
			}
			
			public void mostrarDatos() {
				System.out.println("\n Nombre del Jugador : "+this.nombre);
				System.out.println("Apellido del Jugador : "+this.apellido);
				System.out.println("Fecha de Nacimiento del Jugador : "+this.fechaNacimiento);
				System.out.println("Nacionalidad del Jugador : "+this.nacionalidad);
				System.out.println("Edad : "+calcularEdad());
				System.out.println("Estatura del Jugador : "+this.estatura);
				System.out.println("Peso del Jugador : "+this.peso);
				System.out.println("Posicion del Jugador : "+this.posicion);

			}
			public int calcularEdad() {
				Period period = Period.between(this.fechaNacimiento,LocalDate.now());
				int edad= period.getYears();
				return edad;
			}
}
