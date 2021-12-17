/*
Los tesoros aparecen al ganar una batalla y al azar se te otorga un objeto,
que puede ser de cualquier tipo. En los nodos superiores aparecen tesoros 
que contienen objetos con mejores atributos

Autor : Camilo


*/
package artefactos;
import java.io.Serializable;
import java.util.ArrayList;

public class Tesoro implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private final String nombre;
	private ArrayList<Objeto> recompensas = new ArrayList<Objeto>();  //Objetos disponibles en un tesoror
	
	
	public Tesoro(String nombre,ArrayList<Objeto> recompensas) {
		this.nombre = nombre;
		this.recompensas = recompensas;
	}


	public ArrayList<Objeto> getRecompensas() {
		return recompensas;
	}


	public void setRecompensas(ArrayList<Objeto> recompensas) {
		this.recompensas = recompensas;
	}



	public String getNombre() {
		return nombre;
	}

	
	
	
}