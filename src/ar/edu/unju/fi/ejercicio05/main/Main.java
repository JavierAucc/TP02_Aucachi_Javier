package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;

public class Main {
	
		static Scanner scanner= new Scanner(System.in);
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<Producto> productos = new ArrayList();
			carga(productos);
			int op=0;
			do {
				op=menu();
				switch(op) {
				case 1:System.out.println("--- PRODUCTOS ---");
					mostrarProductos(productos);
					break;
				case 2:realizarCompra(productos);
					break;
				case 3:System.out.println("FIN DEL PROGRAMA");
					break;
				default: System.out.println("ERROR DE OPCION");
				}
			}while(op!=3);
		
	}
	
	static void carga(List<Producto> productos) {
		productos.add( new Producto("1111","teclado",1200,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,true));
		productos.add( new Producto("2222","mouse",1300,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,false));
		productos.add( new Producto("3333","led",1400,OrigenFabricacion.CHINA,Categoria.INFORMATICA,true));
		productos.add( new Producto("4444","ram",1500,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,false));
		productos.add( new Producto("5555","hdd",1600,OrigenFabricacion.URUGUAY,Categoria.INFORMATICA,true));
		productos.add( new Producto("6666","sdd",1700,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,false));
		productos.add( new Producto("7777","parlante",1800,OrigenFabricacion.CHINA,Categoria.INFORMATICA,true));
		productos.add( new Producto("8888","mousepad",1900,OrigenFabricacion.CHINA,Categoria.INFORMATICA,false));
		productos.add( new Producto("9999","modem",2000,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,true));
		productos.add( new Producto("1122","monitor",2100,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,false));
		productos.add( new Producto("1133","procesador",2200,OrigenFabricacion.URUGUAY,Categoria.INFORMATICA,true));
		productos.add( new Producto("1144","usb",2300,OrigenFabricacion.CHINA,Categoria.INFORMATICA,false));
		productos.add( new Producto("1155","micro sd",2400,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,false));
		productos.add( new Producto("1166","cooler",2500,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,false));
		productos.add( new Producto("1177","fuente",2600,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,true));
		
	}
	static int menu() {
		int op=0;
		try {
			System.out.println("\n 1- ------ MOSTRAR PRODUCTOS ------");
			System.out.println("2-   ------ REALIZAR COMPRA ----");
			System.out.println("3-   ------ SALIR ----");
			System.out.println("\n Ingrese opcion ");
			 op = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("ERROR EN EL TIPO DE DATO INGRESADO");
		}
		scanner.nextLine();
		return op;
	}
	static void mostrarProductos(List<Producto> productos) {
		int i=1;
		for (Producto producto : productos) {
			System.out.println("N°"+i+" | Producto: "+producto.getDescripcion()+"  Precio : "+producto.getPrecio_unitario());
			i++;
		}
	}
	static void productosDisponibles(List<Producto> productos) {
		int i=1;
		for (Producto producto : productos) {
			if(producto.getEstado()) {
				System.out.println("N° "+i+"  Producto: "+producto.getDescripcion()+"  Precio : "+producto.getPrecio_unitario()+"  STOCK DISPONIBLE");
			i++;
			}
			else {
				i++;
			}
				
		}
	}
		
	static void realizarCompra(List<Producto> productos) {
		int cant=0;
		int prod=-1;
		boolean band=false;
		List<Double> comprados = new ArrayList();
					cant=cantiProd();
					while(cant!=0) {
						productosDisponibles(productos);
						prod=selectProd();
						prod--;
							if(prod>=0 && prod<15) {
								band=true;
								if(productos.get(prod).getEstado()==true) {
									comprados.add(productos.get(prod).getPrecio_unitario());
									System.out.println("COMPRA EXITOSA");
									System.out.println("PRODUCTO COMPRADO: "+productos.get(prod).getDescripcion());
									cant--;
								}
								else {
									System.out.println("PRODUCTO :"+productos.get(prod).getDescripcion()+" SIN STOCK ");
								}
							}
							else {
								System.out.println("NUMERO FUERA DE RANGO");
							}
						}
				
			System.out.println("\n PRODUCTOS COMPRADOS: "+comprados.size());
			int c=menuPago();
			double total=0;
			for (Double double1 : comprados) {
				total= total + double1;
			}
			switch(c) {
				case 1: PagoEfectivo efete = new PagoEfectivo(total,LocalDate.now());
						System.out.println(" -- Monto: "+total);
						efete.realizarPago(total);
						efete.imprimirRecibo();
						break;
				case 2:PagoTarjeta tarjet = new PagoTarjeta(codTarjeta(),LocalDate.now(),total);
						System.out.println(" -- Monto: "+total);
						tarjet.realizarPago(total);
						tarjet.imprimirRecibo();
						break;
			}
			
	}
	static int menuPago() {
		int p=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("--1-- PAGO EN EFECTIVO");
				System.out.println("--2-- PAGO CON TARJETA");
				System.out.println("ELIJA OPCION DE PAGO:");
				p=scanner.nextInt();
					if(p==1 || p==2) {
						band=true;
					}
					else {
						System.out.println("OPCION FUERA DE RANGO");
						System.out.println("INGRESE NUEVAMENTE");
					}
				}
				catch(InputMismatchException e) {
					System.out.println("ERROR INGRESO DE DATO");
					System.out.println("INGRESE NUEVAMENTE");
				}
			scanner.nextLine();
		}
		
		return p;
	}
	static int cantiProd() {
		int p=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("\n INGRESE CANTIDAD DE PRODUCTOS A COMPRAR");
				p=scanner.nextInt();
				band=true;
				}
				catch(InputMismatchException e) {
					System.out.println("\n ERROR INGRESO DE DATO");
					System.out.println("INGRESE NUEVAMENTE");
				}
			scanner.nextLine();
		}
		return p;
	}
	static int selectProd() {
		int p=0;
		boolean band=false;
		while(!band) {
			try {
				System.out.println("\n SELECCIONE PRODUCTO");
				p=scanner.nextInt();
				band=true;
				}
				catch(InputMismatchException e) {
					System.out.println("\n ERROR INGRESO DE DATO");
					System.out.println("INGRESE NUEVAMENTE");
				}
			scanner.nextLine();
		}
		return p;
	}
	static String codTarjeta() {
		boolean band=false;
		String cod="";
		while(!band) {
			try {
				System.out.println("\n INGRESE CODIGO DE TARJETA");
					cod=scanner.nextLine();
					band=true;
				}
				catch(InputMismatchException e) {
					System.out.println("\n ERROR INGRESO DE DATO");
					System.out.println("INGRESE NUEVAMENTE");
				}
		}
		return cod;
	}
}
