/*
Es esta clase se crea el Sabio, ente que se relaciona con el jugador cuando este los desee.

Dentro de las funciones del sabio está asignar las misiones tanto de lucha como de combate
y además de verificar que se cumplan.

Autores: Yeferson, Edwin
*/
package personajes;
import java.util.ArrayList;

import artefactos.Objeto;
import complementario.Habilidad;

public class Sabio extends Dios{
	
	private ArrayList<Objeto> Objetos = new ArrayList<Objeto>();   		//Lista para guardar los objetos a buscar
	private ArrayList<Totem> Totems = new ArrayList<Totem>();  			//Lista para guardar los posibles Totems a invocar
	private ArrayList<Peleador> Oponentes = new ArrayList<Peleador>();  //Lista para guardar los enemigos a derrotar
	private int misionesB = 0;
	private int misionesL = 0;
		
	public Sabio(String nombre, ArrayList<Habilidad> habilidades, ArrayList<Objeto> Objetos, ArrayList<Peleador> Oponentes, 
			int misionesB, int misionesL, ArrayList<Totem> totems) {
		super(nombre, habilidades);
		this.Objetos = Objetos;
		this.Oponentes = Oponentes;
		this.misionesB = misionesB;
		this.misionesL = misionesL;     
		this.Totems = totems;
	}
	
	//Método para enseñar una habilidad del Sabio al personaje principal
	public void ensenarHabilidad(Peleador personaje, Habilidad habilidad) { 
		personaje.agregarHabilidad(habilidad);
	}	
	
	//Invocar totems teniendo en cuenta los fragmentos del personaje
	public String invocarTotems(Peleador personaje, Totem totem) {      
		if (personaje.getFragmentos() >= 4) {
			personaje.setTotem(totem);
			personaje.setFragmentos(personaje.getFragmentos() -4);
			return "\nSe ha invocado a "+ totem.getNombre() +", Habilidad: " + totem.getHabilidadEspecial().toString();
		}else {
			return "Te faltan " + (4-personaje.getFragmentos()) + " fragmentos para poder invocar un Totem.";
		}
		
	}
	
	
	//Se podrán asignar misiones de búsqueda o de lucha para conseguir fragmentos
	public void asignarMision(Objeto objeto) {      
		this.Objetos.add(objeto);
		this.misionesB += 1;
	}
	
	public void asignarMision(Peleador enemigo) {
		this.Oponentes.add(enemigo);
		this.misionesL += 1;
	}
	
	
	//Métodos para evaluar las misiones comparando ArrayList
	public int calificarMisionBusqueda(Peleador personaje) {
		int fragmentos = 0;
		for (int i=0; i < this.Objetos.size(); i++) {
			if (personaje.getEnemigosDerrotados().contains(this.Objetos.get(i))) {
				personaje.setFragmentos(personaje.getFragmentos()+2);
				this.Objetos.remove(this.Objetos.get(i));
				this.misionesL -= 1;
				fragmentos +=2;
			}
		}
		return fragmentos;
	}
	
	public int calificarMisionCombate(Peleador personaje) {
		int fragmentos = 0;
		for (int i=0; i < this.Oponentes.size(); i++) {
			if (personaje.getEnemigosDerrotados().contains(this.Oponentes.get(i))) {
				personaje.setFragmentos(personaje.getFragmentos()+2);
				this.Oponentes.remove(this.Oponentes.get(i));
				this.misionesL -= 1;
				fragmentos +=2;
			}
		}
		return fragmentos;
	}

	public ArrayList<Objeto> getObjetos() {
		return Objetos;
	}

	public void setObjetos(ArrayList<Objeto> objetos) {
		Objetos = objetos;
	}

	public ArrayList<Peleador> getOponentes() {
		return Oponentes;
	}

	public void setOponentes(ArrayList<Peleador> oponentes) {
		Oponentes = oponentes;
	}

	public int getMisionesB() {
		return misionesB;
	}

	public void setMisionesB(int misionesB) {
		this.misionesB = misionesB;
	}

	public int getMisionesL() {
		return misionesL;
	}

	public void setMisionesL(int misionesL) {
		this.misionesL = misionesL;
	}

	public ArrayList<Totem> getTotems() {
		return Totems;
	}

	public void setTotems(ArrayList<Totem> totems) {
		Totems = totems;
	}
	
	public String hablar() {
		return "Usa la habilidad con prudencia, en tus manos está el futuro de la humanidad.";
	}
	
	
	
}
