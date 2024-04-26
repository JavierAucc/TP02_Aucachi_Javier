package ar.edu.unju.fi.ejercicio01.main;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Producto> productos = new ArrayList();
		int op=0;
		
		do {
			op=menu();
			switch(op) {
			case 1:System.out.println("CREACION DE PRODUCTO :");
					Producto producto = crearProducto();
					if(productos.add(producto)){
						System.out.println("PRODUCTO AGREGADO CON EXITO");
						System.out.println("CANTIDAD: "+productos.size());
					}
					else {
						System.out.println("ERROR AL AGREGAR");
					}
				break;
			case 2:System.out.println("MOSTRAR PRODUCTO");
					mostrarProducto(productos);
				break;
			case 3:System.out.println("MODIFICAR PRODUCTO");
					modificarProducto(productos);
				break;
			case 4:System.out.println("FIN DEL PROGRAMA");
				break;
			default: System.out.println("ERROR DE OPCION");
			}
		}while(op != 4);
	}
	// MENUS
	static int menu() {
		int op=0;
		try {
			System.out.println("\n 1-   ------ Crear Producto ------");
			System.out.println("2-   ------ Mostrar Producto ----");
			System.out.println("3-   ------ Modificar Producto ----");
			System.out.println("4-    -------- SALIR ---------");
			System.out.println("\n Ingrese opcion ");
			 op = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("ERROR EN EL TIPO DE DATO INGRESADO");
		}
		scanner.nextLine();
		return op;
	}
	static String Codigo(){
		System.out.println("Ingrese Codigo:");
		return scanner.nextLine();
	}
	static String Descripcion() {
		System.out.println("Ingrese Descripcion : ");
		return scanner.nextLine();
	}
	static double PrecioUnitario() {
		double p=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("ingrese Precio Unitario");
				p=scanner.nextDouble();
				
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
	static Producto crearProducto() {
		return new Producto(Codigo(),Descripcion(),PrecioUnitario(),obtenerOrigenFabricacion(),obtenerCategoria());
	}
	static OrigenFabricacion obtenerOrigenFabricacion() {
		int op=menuOrigen();
		switch(op) {
		case 1: return OrigenFabricacion.ARGENTINA;
		case 2: return OrigenFabricacion.CHINA;
		case 3: return OrigenFabricacion.BRASIL;
		case 4: return OrigenFabricacion.URUGUAY;
		default: return null;
		}
	}
	static Categoria obtenerCategoria() {
		int op=menuCategoria();
		switch(op) {
		case 1: return Categoria.TELEFONIA;
		case 2: return Categoria.INFORMATICA;
		case 3: return Categoria.ELECTROHOGAR;
		case 4: return Categoria.HERRAMIENTAS;
		default: return null;
		}
	}
	static int menuOrigen() {
		int o=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("----- Origen de Fabricacion ----");
				System.out.println("1- ARGENTINA");
				System.out.println("2- CHINA");
				System.out.println("3- BRASIL");
				System.out.println("4- URUGUAY");
				System.out.println("\n INGRESE OPCION");
				o=scanner.nextInt();
				band=true;
					if(o!= 1 && o!=2 && o!= 3 && o!=4) {
						band=false;
						System.out.println("ERROR DE OPCION");
						System.out.println("INGRESE NUEVAMENTE");
						}
				}
				catch(InputMismatchException e ) {
					System.out.println("ERROR EN TIPO DE DATO INGRESADO");
					System.out.println("INGRESE NUEVAMENTE");
				}
		}
		scanner.nextLine();
		return o;
	}
	static int menuCategoria() {
		int o=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("----- CATEGORIA ----");
				System.out.println("1- TELEFONIA");
				System.out.println("2- INFORMATICA");
				System.out.println("3- ELECTRO HOGAR");
				System.out.println("4- HERRAMIENTAS");
				System.out.println("\n INGRESE OPCION");
				o=scanner.nextInt();
				band=true;
					if(o!= 1 && o!=2 && o!= 3 && o!=4) {
						band=false;
						System.out.println("ERROR DE OPCION");
						System.out.println("INGRESE NUEVAMENTE");
						}
				}
				catch(InputMismatchException e ) {
					System.out.println("ERROR EN TIPO DE DATO INGRESADO");
					System.out.println("INGRESE NUEVAMENTE");
				}
		}
		scanner.nextLine();
		return o;
	}
	static void mostrarProducto(List <Producto> productos) {
		System.out.println("\n INGRESE CODIGO DEL PRODUCTO A MOSTRAR:");
		String cod=scanner.nextLine();
		boolean band=false;
		for (Producto producto : productos) {
			if(producto.getCodigo().equals(cod)) {
				System.out.println("\n Codigo Producto: "+producto.getCodigo());
				System.out.println("Descripcion Producto: "+producto.getDescripcion());
				System.out.println("Precio: "+producto.getPrecio_unitario());
				System.out.println("Origen de Fabricacion: "+producto.getOrigen());
				System.out.println("Categoria: "+producto.getCategoria());
				band=true;
			}
		}
		if(band==false) {
			System.out.println("PRODUCTO INEXISTENTE");
		}
	}
	static void modificarProducto(List <Producto> productos) {
		System.out.println("\n INGRESE CODIGO DEL PRODUCTO A MODIFICAR");
		String cod=scanner.nextLine();
		boolean band=false;
		int pos=0,i=0;
		
		for (i=0;i<productos.size();i++) {
			if(productos.get(i).getCodigo().equals(cod)) {
				band=true;
				pos=i;
			}
		}
		if(band) {
			int op=opModificar();
				switch(op) {
				case 1:productos.get(pos).setDescripcion(Descripcion());
						System.out.println("MODIFICADO CON EXITO");
						break;
				case 2:productos.get(pos).setPrecio_unitario(PrecioUnitario());
						System.out.println("MODIFICADO CON EXITO");
						break;
				case 3:productos.get(pos).setOrigen(obtenerOrigenFabricacion());
						System.out.println("MODIFICADO CON EXITO");
						break;
				case 4:productos.get(pos).setCategoria(obtenerCategoria());
						System.out.println("MODIFICADO CON EXITO");
						break;
					default: System.out.println("ERROR DE OPCION");
				}
		}
		else {
			System.out.println("Producto no encontrado . . . ");
		}
		
	}
	static int opModificar() {
		System.out.println("\n 1- DESCRIPCION ");
		System.out.println(" 2- PRECION UNITARIO ");
		System.out.println(" 3- ORIGEN ");
		System.out.println(" 4- CATEGORIA");
		System.out.println("ingrese op");
		int op=scanner.nextInt();
		scanner.nextLine();
		return op;
	}
}//parentesis de la clase
