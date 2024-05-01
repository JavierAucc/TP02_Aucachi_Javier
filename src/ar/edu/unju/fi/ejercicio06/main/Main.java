package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//EJEMPLO DEL TRABAJO PRACTICO
		FelinoDomestico gato= new FelinoDomestico("Garfield",(byte)45,12f);
		
		Converter<FelinoDomestico,FelinoSalvaje> converter = x-> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjetos(felino1);
		//ITEM
		//FelinoSalvaje tigron=null;
		FelinoSalvaje tigron=new FelinoSalvaje("Tanner",(byte)20,186f);
		boolean band = Converter.isNotNull(tigron);
		if(band) {
			Converter<FelinoSalvaje,FelinoDomestico> converter2 = x-> new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
			FelinoDomestico gato2 = converter2.convert(tigron);
			converter2.mostrarObjetos(gato2);
		}
		else {
			System.out.println("EL OBJETO A CONVERTIR ES NULLO");
		}
			
	}


}
