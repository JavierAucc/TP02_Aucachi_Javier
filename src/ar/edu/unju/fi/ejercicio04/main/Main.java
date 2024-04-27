package ar.edu.unju.fi.ejercicio04.main;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
	static Scanner scanner= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Jugador> jugadores = new ArrayList();
		int op=0;
		
		do {
			op=menu();
			switch(op) {
			case 1:System.out.println("ALTA JUGADOR :");
					Jugador jugador = crearJugador();
					if(jugadores.add(jugador)) {
						System.out.println("JUGADOR AGREGADO CON EXITO");
						System.out.println("Cantidad : "+jugadores.size());
						jugador.mostrarDatos();
					}
					else {
						System.out.println("error al crear jugador");
					}
				break;
			case 2:System.out.println("---- TODOS LOS JUGADORES ----");
					mostrarJugadores(jugadores);
				break;
			case 3:System.out.println("---- MODIFICAR POSICION DE JUGADOR ----");
					modificarPosicion(jugadores);
				break;
			case 4:System.out.println("---- ELIMINACION DE JUGADOR ----");
					eliminarJugador(jugadores);
				break;
			
			case 5:System.out.println("FIN DEL PROGRAMA");
				break;
			default: System.out.println("ERROR DE OPCION");
			}
		}while(op != 5);
	}

			
//de la clase
	static int menu() {
		int op=0;
		try {
			System.out.println("\n 1-   ------ ALTA JUGADOR ------");
			System.out.println("2-   ------ MOSTRAR TODOS LOS JUGADORES ----");
			System.out.println("3-   ------ MODIFICAR POSICION DEL JUGADOR ----");
			System.out.println("4-   ------ ELIMINAR JUGADOR ----");
			System.out.println("5-    -------- SALIR ---------");
			System.out.println("\n Ingrese opcion ");
			 op = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("ERROR EN EL TIPO DE DATO INGRESADO");
		}
		scanner.nextLine();
		return op;
	}
	static Jugador crearJugador() {
		return new Jugador(nombre(),apellido(),fechaNacimiento(),nacionalidad(),estatura(),peso(),posicion());
	}
	static String nombre(){
		System.out.println("Ingrese Nombre: ");
		return scanner.nextLine();
	}
	static String apellido() {
		System.out.println("Ingrese Apellido: ");
		return scanner.nextLine();
	}
	static LocalDate fechaNacimiento() {
		LocalDate fecha=null;
		boolean band=false;
		int dia=0,mes=0,anio=0;
			while(!band) {
				try {
					System.out.println("FECHA DE NACIMIENTO:");
					System.out.println("\n INGRESE AÑO");
					anio =scanner.nextInt();
					System.out.println("INGRESE MES");
					mes = scanner.nextInt();
					System.out.println("INGRESE DIA");
					dia = scanner.nextInt();
				}
				catch(java.util.InputMismatchException ex) {
					System.out.println("DATOS INGRESADOS DE DISTINTO TIPO");
					}
			try {
				fecha = LocalDate.of(anio, mes, dia);
				band=true;
			}
			catch(DateTimeException e) {
				System.out.println("ERROR EN PARAMETROS DE FECHA");
			}
			scanner.nextLine();
		}
		return fecha;
	}
	static String nacionalidad() {
		System.out.println("Ingrese Nacionalidad: ");
		return scanner.nextLine();
	}
	static float estatura() {
		boolean band=false;
		float p=0;
		while(!band) {
			try {
				System.out.println("Ingrese Estatura");
				p=scanner.nextFloat();
				band=true;
				}
				catch(InputMismatchException e ) {
					System.out.println("ERROR EN TIPO DE DATO INGRESADO");
					System.out.println("INGRESE NUEVAMENTE");
				}
			scanner.nextLine();
		}
		return p;
	}
	static float peso() {
		boolean band=false;
		float p=0;
		while(!band) {
			try {
				System.out.println("Ingrese Peso");
				p=scanner.nextFloat();
				band=true;
				}
				catch(InputMismatchException e ) {
					System.out.println("ERROR EN TIPO DE DATO INGRESADO");
					System.out.println("INGRESE NUEVAMENTE");
				}
			scanner.nextLine();
		}
		return p;
	}
	static int posMenu() {
		int p=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("\n ----- POSICIONES ----");
				System.out.println("1- DELANTERO");
				System.out.println("2- MEDIO");
				System.out.println("3- DEFENSA");
				System.out.println("4- ARQUERO");
				System.out.println("\n INGRESE OPCION");
				p=scanner.nextInt();
				band=true;
					if(p<1 || p>4) {
						band=false;
						System.out.println("ERROR DE OPCION");
						System.out.println("INGRESE NUEVAMENTE");
						}
				}
				catch(InputMismatchException e ) {
					System.out.println("ERROR EN TIPO DE DATO INGRESADO");
					System.out.println("INGRESE NUEVAMENTE");
				}
			scanner.nextLine();
		}	
		return p;
	}
	static Posicion posicion() {
		int pos=posMenu();
		switch(pos) {
		case 1:return Posicion.DELANTERO;
		case 2:return Posicion.MEDIO;
		case 3:return Posicion.DEFENSA;
		case 4:return Posicion.ARQUERO;
		default:return null;
		}
	}
	static void mostrarJugadores(List <Jugador> jugadores) {
		for (Jugador jugador : jugadores) {
			System.out.println("Jugador : "+jugador.getApellido()+" "+jugador.getNombre()+"  Posicion: "+jugador.getPosicion());
		}
	}
	static int posJugador(List <Jugador> jugadores) {
		System.out.println("Ingrese Nombre del Jugador");
		String nombre=scanner.nextLine();
		System.out.println("Ingrese Apellido del Jugador");
		String apellido=scanner.nextLine();
		int pos=-1;
		boolean band=false;
			for(int i=0;i<jugadores.size() && band == false ;i++) {
				if(jugadores.get(i).getNombre().equals(nombre) && jugadores.get(i).getApellido().equals(apellido)){
					pos=i;
					band=true;
				}
			}
		return pos;
	}
	static void modificarPosicion(List <Jugador> jugadores) {
		int pos=posJugador(jugadores);
		if(pos!=-1) {
			jugadores.get(pos).setPosicion(posicion());
			System.out.println("MODIFICACION EXITOSA");
		}
		else {
			System.out.println("JUGADOR INEXISTENTE ! !");
		}
	}
	static void eliminarJugador(List <Jugador> jugadores) {
		System.out.println("Ingrese Nombre del Jugador");
		String nombre=scanner.nextLine();
		System.out.println("Ingrese Apellido del Jugador");
		String apellido=scanner.nextLine();
		Boolean band=false;
		//USO DE ITERADOR
		Iterator<Jugador> iterador = jugadores.iterator();
		while(iterador.hasNext()) {
			Jugador j =(Jugador)iterador.next();
			if(j.getApellido().equals(apellido) && j.getNombre().equals(nombre)) {
				iterador.remove();
				band=true;
			}
		}
		if(band) {
			System.out.println("BORRADO EXITOSO!");
			System.out.println("CANTIDAD: "+jugadores.size());
		}
		else {
			System.out.println("NO SE PUDO BORRAR");
		}
	}
}
