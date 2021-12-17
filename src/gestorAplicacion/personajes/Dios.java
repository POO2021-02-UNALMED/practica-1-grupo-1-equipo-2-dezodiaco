/*
Interactua con los peleadores otorgando y enseñando habilidades.

Autor: Yeferson 
*/
package personajes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import complementario.Habilidad;

public class Dios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected final String nombre;
	protected ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
	
	public Dios(String nombre, ArrayList<Habilidad> habilidades) {
		this.nombre = nombre;
		this.habilidades = habilidades;
	}
	
	public Dios(String nombre) {
		this.nombre = nombre;
	}
	//Método para enseñar las habilidades de los dioses al personaje principal y aplicarlas
	public void enseñarHabilidad(Peleador personaje,Habilidad habilidad) {   
		personaje.agregarHabilidad(habilidad);
		habilidad.modificarEstadistica(personaje);
	}
	
	public String getNombre() {
		return nombre;
	}

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}
	
	@Override
	public String toString() {
		return  nombre;
	}

	public void setHabilidades(ArrayList<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}
	
	public Habilidad elegirHabilidad() {
		Collections.shuffle(this.habilidades);  // Reorganiza las habilidades del nodo
		return this.habilidades.get(0);
	}
	
	public String hablar() {
		return "Espero que te adaptes a los cambios, toma buenas decisiones con lo que tienes.";
	}

	
	
}

