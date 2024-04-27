package ar.edu.unju.fi.ejercicio03.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		List<Double> densidades = new ArrayList();
			Provincia provincia = Provincia.JUJUY;
			
			System.out.println("\n Provincia : "+ provincia);
			System.out.println("Cantidad Poblacion :"+provincia.getCantidadPoblacion());
			System.out.println("Superficie: "+provincia.getSuperficie());
			densidades.add(provincia.calcularDensidad());
			System.out.println("Densidad: "+densidades.get(0));
			
			provincia= Provincia.SALTA;
			System.out.println("\n Provincia : "+ provincia);
			System.out.println("Cantidad Poblacion :"+provincia.getCantidadPoblacion());
			System.out.println("Superficie: "+provincia.getSuperficie());
			densidades.add(provincia.calcularDensidad());
			System.out.println("Densidad: "+densidades.get(1));
			
			provincia= Provincia.TUCUMAN;
			System.out.println("\n Provincia : "+ provincia);
			System.out.println("Cantidad Poblacion :"+provincia.getCantidadPoblacion());
			System.out.println("Superficie: "+provincia.getSuperficie());
			densidades.add(provincia.calcularDensidad());
			System.out.println("Densidad: "+densidades.get(2));
			
			provincia= Provincia.LA_RIOJA;
			System.out.println("\n Provincia : "+ provincia);
			System.out.println("Cantidad Poblacion :"+provincia.getCantidadPoblacion());
			System.out.println("Superficie: "+provincia.getSuperficie());
			densidades.add(provincia.calcularDensidad());
			System.out.println("Densidad: "+densidades.get(3));
		
			provincia= Provincia.SANTIAGO_DEL_ESTERO;
			System.out.println("\n Provincia : "+ provincia);
			System.out.println("Cantidad Poblacion :"+provincia.getCantidadPoblacion());
			System.out.println("Superficie: "+provincia.getSuperficie());
			densidades.add(provincia.calcularDensidad());
			System.out.println("Densidad: "+densidades.get(4));
			
	}
}
