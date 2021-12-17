/*
Cada totem relaciona con el personaje ofreciendole mejoras en sus atributos, puede ayudarlo una vez o obsequiarle 
un objeto sagrado a cambio de su existencia, desaparecerá al instante.

Autor: Yeferson
*/
package personajes;
import complementario.Habilidad;
import artefactos.Objeto;

public class Totem extends Guardian implements Espiritu{
	
	private final Objeto objeto;   //Objeto que es donado
	private int apoyo = 1;         //Permite controlar las veces en las que apoya al personaje.
	
	public Totem(String nombre,  Habilidad habilidadEspecial, Objeto objeto) {
		super(nombre, habilidadEspecial);
		this.objeto = objeto;
	}

	public Habilidad getHabilidadEspecial() {
		return habilidadEspecial;
	}
	
	public Objeto getObjeto() {
		return objeto;
	}

	
	//Contribuye a las estadísticas del jugado, es un método heredado de Guardian
	@Override
	public String apoyar(Peleador personaje) {               
		if (this.apoyo != 0) {
			habilidadEspecial.modificarEstadistica(personaje);
			this.apoyo = 0;
			
			return "Atributos despues del apoyo de "+ this.getNombre() + "\n" + personaje.toString();
		}else{return "No puedes usar de nuevo esta habilidad.";}
	}

	//Otorga el objeto al jugador, este método es heredado de Espiritu
	@Override
	public String donarObjeto(Peleador personaje) { //Obsequia un arma legendaria al personaje solo una vez y desaparece
		personaje.getInventario().add(this.objeto);
		this.getHabilidadEspecial().revertirEstadistica(personaje);
		personaje.setTotem(null);
		
		return "\nSe te ha otorgado: "+ this.objeto.getNombre();
	}
	
	
}
