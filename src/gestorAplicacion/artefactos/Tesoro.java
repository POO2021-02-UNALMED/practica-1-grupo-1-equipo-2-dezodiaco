package artefactos;
import java.util.ArrayList;

class Tesoro {
	
	private enum rarezas{ //Rarezas en orden creciente de nivel
		NORMAL,
		EPICA,
		LEGENDARIA,
		DEFINITIVA
	}
	
	private final rarezas rareza;
	private final String nombre;
	private final int precio;
	private ArrayList<Objeto> recompensas = new ArrayList<Objeto>();
	
	
	public Tesoro(rarezas rareza,String nombre,int precio) {
		this.rareza = rareza;
		this.nombre = nombre;
		this.precio = precio;
	}
}