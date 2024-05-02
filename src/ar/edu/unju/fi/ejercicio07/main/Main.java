package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {
	static Scanner scanner= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Producto> productos = new ArrayList<>();
		carga(productos);
			int op=0;
			do {
				op=menu();
				switch(op) {
				case 1: mostrarProductos(productos);
					break;
				case 2:	mostrarFaltantes(productos);
					break;
				case 3:productosAumentos(productos);
					break;
				case 4:categoriaDisponibilidad(productos);
					break;
				case 5:productosOrdenados(productos);
					break;
				case 6:prodmayus(productos);
					break;
				case 7:System.out.println("FIN DEL PROGRAMA");
					break;
				default: System.out.println("ERROR DE OPCION");
				}
			}while(op!=7);
	
	
	
	}
	static void prodmayus(List<Producto> productos) {
		System.out.println("----- PRODUCTOS CON NOMBRES EN MAYUSCULAS -----");
		Function<Producto,Producto> cambio = (c)-> {
			c.setDescripcion(c.getDescripcion().toUpperCase());
			return c;
		};
		productos.stream().map(cambio).collect(Collectors.toList());
		Consumer<Producto> nn = (n)-> System.out.println("Producto : "+n.getDescripcion());
		productos.forEach(nn);
	}
	static void productosOrdenados(List<Producto> productos) {
		System.out.println("----- PRODUCTOS ORDENADOS DE FORMA DESCENDENTE ----");
		Consumer<Producto> precios = (p)-> System.out.println(" Producto: "+p.getDescripcion()
		+" Precio: "+p.getPrecio_unitario());
		productos.sort(Comparator.comparing(Producto::getPrecio_unitario).reversed());
		productos.forEach(precios);
	}
	static void categoriaDisponibilidad(List<Producto> productos) {
		System.out.println("----- PRODUCTOS POR CATEGORIA Y DISPONIBILIDAD ----");
		Consumer<Producto> nomb = (n)-> System.out.println("Producto : "+n.getDescripcion()
		+" Categoria: "+n.getCategoria()+" Stock: "+n.getEstado());
		Predicate<Producto> categoriaEstado= (e)-> e.getEstado()==true && e.getCategoria().equals(Categoria.ELECTROHOGAR);
		productos.stream().filter(categoriaEstado).forEach(nomb);
	}
	static void productosAumentos(List<Producto> productos) {
		System.out.println("---- PRODUCTOS CON AUMENTO ----");
		Consumer<Producto> nombree = (n)-> System.out.println("Producto : "+n.getDescripcion()+" Precio Incrementado: "+n.getPrecio_unitario());
		List<Producto> productosIncrementados = new ArrayList<>();
		Function<Producto,Producto> incremento = (p)-> {
			p.setPrecio_unitario(p.getPrecio_unitario()+p.getPrecio_unitario()*0.2);
			return p;
		};
		productosIncrementados = productos.stream().map(incremento).collect(Collectors.toList());
		productosIncrementados.forEach(nombree);
	}
	static void mostrarFaltantes(List<Producto> productos) {
		System.out.println("--- PRODUCTOS FALTANTES -----");
		Consumer<Producto> nom = (n)-> System.out.println("Producto : "+n.getDescripcion()+" Estado: "+n.getEstado());
 		Predicate<Producto> stock = (s)-> s.getEstado()==false; //!s.isEstado()
 		productos.stream().filter(stock).forEach(nom);
	}
	static void mostrarProductos(List<Producto> productos) {
		System.out.println("--- PRODUCTOS ---");
		Consumer<Producto> nombre = (n)-> System.out.println("Producto : "+n.getDescripcion());
		productos.forEach(nombre);
	}
	static void carga(List<Producto> productos) {
		productos.add(new Producto("1111","teclado",1200,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,true));
		productos.add(new Producto("2222","batidora",1300,OrigenFabricacion.BRASIL,Categoria.ELECTROHOGAR,false));
		productos.add(new Producto("3333","led",1400,OrigenFabricacion.CHINA,Categoria.INFORMATICA,true));
		productos.add(new Producto("4444","Celular",1500,OrigenFabricacion.ARGENTINA,Categoria.TELEFONIA,false));
		productos.add(new Producto("5555","hdd",1600,OrigenFabricacion.URUGUAY,Categoria.INFORMATICA,true));
		productos.add(new Producto("6666","plancha",1700,OrigenFabricacion.BRASIL,Categoria.ELECTROHOGAR,true));
		productos.add(new Producto("7777","parlante",1800,OrigenFabricacion.CHINA,Categoria.INFORMATICA,true));
		productos.add(new Producto("8888","destornillador",1900,OrigenFabricacion.CHINA,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("9999","modem",2000,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,true));
		productos.add(new Producto("1122","secarropas",2100,OrigenFabricacion.ARGENTINA,Categoria.ELECTROHOGAR,false));
		productos.add(new Producto("1133","procesador",2200,OrigenFabricacion.URUGUAY,Categoria.INFORMATICA,true));
		productos.add(new Producto("1144","usb",2300,OrigenFabricacion.CHINA,Categoria.INFORMATICA,false));
		productos.add(new Producto("1155","taladro",2400,OrigenFabricacion.BRASIL,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("1166","televisor",2500,OrigenFabricacion.BRASIL,Categoria.ELECTROHOGAR,false));
		productos.add(new Producto("1177","Lavarropas",2600,OrigenFabricacion.ARGENTINA,Categoria.ELECTROHOGAR,true));
	}
	static int menu() {
		int op=0;
		try {
			System.out.println("\n");
			System.out.println("-1-    ------ MOSTRAR PRODUCTOS ------");
			System.out.println("-2-   ------ PRODUCTOS FALTANTES ----");
			System.out.println("-3-   ------ PRODUCTOS CON AUMENTO DEL %20 ----");
			System.out.println("-4-    ----- PRODUCTOS POR CATEGORIA Y DISPONIBILIDAD ----");
			System.out.println("-5    ----- PRODUCTOS ORDENADOS DE FORMA DESCENDENTE ----");
			System.out.println("-6-  ----- PRODUCTOS CON NOMBRES EN MAYUSCULAS -----");
			System.out.println("-7-  ----- SALIR ----");
			System.out.println("\n Ingrese opcion ");
			 op = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("ERROR EN EL TIPO DE DATO INGRESADO");
		}
		scanner.nextLine();
		return op;
	}
}
