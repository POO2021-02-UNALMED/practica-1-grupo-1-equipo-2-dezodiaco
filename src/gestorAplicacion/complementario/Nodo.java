/*
 Son los espacios en donde se desarrollan los combates, también hay presencia de dioses y
 enemigos.
 
 Autor: Edwin
 */


package complementario;
import personajes.Peleador;
import artefactos.Objeto;
import artefactos.Tesoro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import personajes.Dios;

public class Nodo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Nodo> nodos = new ArrayList<Nodo>(); //Se almacenn todos los nodos creados.
	private final String nombre;                                  
	private ArrayList<Dios> dioses = new ArrayList<Dios>();       //dioses presentes en el nodo
	private ArrayList<Nodo> conexiones = new ArrayList<Nodo>();   //nodos a los que se puede acceder desde el actual
	private boolean abierto;									  //permite saber si el nodo está o no disponible.
	private ArrayList<Peleador> enemigos = new ArrayList<Peleador>();  //Enemigos presentes en el modelo.
	private ArrayList<Tesoro> tesoros = new ArrayList<Tesoro>();       //tesoros que están "ocultos" en el nodo
 
	
	public Nodo(String nombre, ArrayList<Dios> dioses, ArrayList<Nodo> conexiones, boolean logro,ArrayList<Peleador> enemigos,ArrayList<Tesoro> tesoros) {
		this.nombre = nombre;
		this.dioses = dioses;
		this.conexiones = conexiones;
		this.abierto = logro;
		this.tesoros = tesoros;
		Nodo.nodos.add(this);
	}

	public Nodo(String nombre, ArrayList<Nodo> conexiones, boolean logro) { 
		this.nombre = nombre;
		this.conexiones = conexiones;
		this.abierto = logro;
	}
	
	//Permite acceder a un node específico
	public Nodo abrirNodo(Nodo nodo) {
		if(this.abierto == true && this.getConexiones().contains(nodo)) {

			return nodo;
		}return this;
	}

	public ArrayList<Dios> getDioses() {
		return dioses;
	}

	public void setDioses(ArrayList<Dios> dioses) {
		this.dioses = dioses;
	}

	public ArrayList<Nodo> getConexiones() {
		return conexiones;
	}

	public void setConexiones(ArrayList<Nodo> conexiones) {
		this.conexiones = conexiones;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean logro) {
		this.abierto = logro;
	}

	public String getNombre() {
		return nombre;
	}
	
	public static ArrayList<Nodo> getNodos(){
		return Nodo.nodos;
	}
	
	public void setEnemigos(ArrayList<Peleador> enemigos) {
		this.enemigos = enemigos;
	}
	
	public ArrayList<Peleador> getEnemigos(){
		return this.enemigos;
	}
	 
	public Peleador elegirEnemigo() {
		Collections.shuffle(this.enemigos);  // Reorganiza los enemigos del nodo 
		return this.enemigos.get(0);  
		 
	}
	
	public Dios elegirDios() {
		Collections.shuffle(this.dioses); // Reorganiza los dioses del nodo
		return this.dioses.get(0);
	}
	
	public static void setNodos(ArrayList<Nodo> nodos){
		Nodo.nodos = nodos;
	}

	public ArrayList<Tesoro> getTesoros() {
		return tesoros;
	}

	public void setTesoros(ArrayList<Tesoro> tesoros) {
		this.tesoros = tesoros;
	}
	
	
	//Se elige un tesoro del nodo reorganizando al azar el ArrayList
	public Objeto elegirTesoro() {
		Collections.shuffle(tesoros);
		Tesoro premio = tesoros.get(0);
		Collections.shuffle(premio.getRecompensas());
		Objeto recompensa = premio.getRecompensas().get(0);
		
		return recompensa;
		
		
	}
	
	
	
	
	
		
}
