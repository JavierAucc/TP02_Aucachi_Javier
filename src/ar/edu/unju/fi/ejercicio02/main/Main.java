package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Efemeride> efes = new ArrayList();
		int op=0;
		do {
			op=menu();
			switch(op) {
			case 1:System.out.println("CREACION DE EFEMERIDE:");
					Efemeride efemeride = crearEfemeride();
						if(efes.add(efemeride)) {
							System.out.println("AGREGADO CON EXITO !");
							System.out.println("CANTIDAD: "+efes.size());
						}
						else {
							System.out.println("NO SE PUDO AGREGAR");
						}
				break;
			case 2:System.out.println("---- EFEMERIDE A MOSTRAR ----");
					mostrarEfemeride(efes);
				break;
			case 3:System.out.println("---- ELIMINACION DE EFEMERIDE----");
					eliminarEfemeride(efes);
				break;
			case 4:System.out.println("---- MODIFICACION DE EFEMERIDE----");
					modificarEfemeride(efes);
				break;
			case 5:System.out.println("FIN DEL PROGRAMA");
				break;
			default: System.out.println("ERROR DE OPCION");
			}
		}while(op != 5);
		
	}//LAVES DEL MAIN
	static int menu() {
		int op=0;
		try {
			System.out.println("\n 1-   ------ Crear Efemeride ------");
			System.out.println("2-   ------ Mostrar Efemeride ----");
			System.out.println("3-   ------ Eliminar Efemeride ----");
			System.out.println("4-   ------ Modificar Efemeride ----");
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
	static Efemeride crearEfemeride() {
		return new Efemeride(Codigo(),mes(),Dia(),Detalle());
	}
	static String Codigo() {
		System.out.println("\n INGRESE CODIGO :");
		return scanner.nextLine();
	}
	static int Dia() {
		boolean band=false;
		int p=0;
		while(!band) {
			try {
				System.out.println("Ingrese Dia");
				p=scanner.nextInt();
				band=true;
				if(p<1 || p>31) {
					band=false;
					System.out.println("Dias NO Validos");
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
	static String Detalle() {
		System.out.println("INGRESE DETALLES");
		return scanner.nextLine();
	}
	static int  menuMes() {
		int m=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("----- MESES DEL AÑO ----");
				System.out.println("1- ENERO");
				System.out.println("2- FEBRERO");
				System.out.println("3- MARZO");
				System.out.println("4- ABRIL");
				System.out.println("5- MAYO");
				System.out.println("6- JUNIO");
				System.out.println("7- JULIO");
				System.out.println("8- AGOSTO");
				System.out.println("9- SEPTIEMBRE");
				System.out.println("10- OCTUBRE");
				System.out.println("11- NOVIEMBRE");
				System.out.println("12- DICIEMBRE");
				System.out.println("\n INGRESE OPCION");
				m=scanner.nextInt();
				band=true;
					if(m<1 || m>12) {
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
		return m;
	}
	static Mes mes() {
		int m=menuMes();
		switch(m) {
			case 1:return Mes.ENERO;
			case 2:return Mes.FEBRERO;
			case 3:return Mes.MARZO;
			case 4:return Mes.ABRIL;
			case 5:return Mes.MAYO;
			case 6:return Mes.JUNIO;
			case 7:return Mes.JULIO;
			case 8:return Mes.AGOSTO;
			case 9:return Mes.SEPTIEMBRE;
			case 10:return Mes.OCTUBRE;
			case 11:return Mes.NOVIEMBRE;
			case 12:return Mes.DICIEMBRE;
			default: return null;
		}
	}
	static int posicion(List<Efemeride> efes) {
		System.out.println("Ingrese Codigo");
		String cod=scanner.nextLine();
		boolean band=false;
		int pos=-1;
		for (int i=0;i<efes.size() && band==false;i++) {
			if(efes.get(i).getCodigo().equals(cod)) {
				band=true;
				pos=i;
			}
		}
		return pos;
	}
	static void mostrarEfemeride(List<Efemeride> efes) {
		int pos=posicion(efes);
		if(pos!=-1) {
			efes.get(pos).mostrarDatos();
		}
		else {
			System.out.println("NO SE ENCONTRO EFEMERIDE");
		}
	}
	static void modificarEfemeride(List<Efemeride> efes) {
		int pos=posicion(efes);
		if(pos!=-1) {
				try {
					System.out.println("\n 1- MODIFICAR DIA ");
					System.out.println(" 2- MODIFICAR MES ");
					System.out.println(" 3- MODIFICAR DETALLE ");
					int op=scanner.nextInt();
					scanner.nextLine();
					switch(op) {
					case 1:efes.get(pos).setDia(Dia());
							System.out.println("MODIFACION EXITOSA");
					break;
					case 2:efes.get(pos).setMes(mes());
							System.out.println("MODIFACION EXITOSA");
					break;
					case 3:efes.get(op).setDetalle(Detalle());
							System.out.println("MODIFACION EXITOSA");
					break;
					default:System.out.println("ERROR DE OPCION");
							System.out.println("NO SE PUDO MODIFICAR");
					}
				}
				catch(InputMismatchException e) {
					System.out.println("ERROR EN EL TIPO DE DATO");
				}
		}
		else {
			System.out.println("NO EXISTE EFEMERIDE");
		}
	}
	static void eliminarEfemeride(List<Efemeride> efes) {
		int pos=posicion(efes);
		if(pos!=-1) {
			efes.remove(pos);
			System.out.println("BORRADO EXITOSO!");
			System.out.println("CANTIDAD: "+efes.size());
		}
		else {
			System.out.println("NO SE ENCONTRO EFEMERIDE");
		}
	}
}//LLAVE DE LA CLASE
