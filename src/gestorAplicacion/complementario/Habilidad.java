/*
Las habilidades pueden modificar o revertir las estadísticas de un personaje con 
los métodos modificarEstadística y revertirEstadistica respectivamente.

Autores: Edwin, Camilo.
*/


package complementario;
import java.io.Serializable;

import personajes.Peleador;



public class Habilidad implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private final TipoEfecto efecto;         //Tipo de efecto de las habilidades
	private final TipoHabilidad tipo;        //Tipo de habilidad
	private final String nombre;             
	private final boolean autoDirigida;      //Define si una habiliad se puede usar sobre sí mismo.
	private final int modificador;			 //Cantidad de contribución a las estadísticas del personaje
	private final int danoEfecto;            //Valor que se tiene en cuenta a la hora de atacar
	private final int duracion ;             //Número de veces que se puede utilizar le objeto.
	private int enfriamiento = 1;            //Permite dejar en reposos ciertas habilidades, para no saturar el combate
	private boolean efectoActivado = false;  //Permite identificar si la habilidad está siendo utilizada.
	

	public Habilidad(TipoHabilidad tipo, String nombre, int modificador,int duracion,int enfriamiento,int danoEfecto,TipoEfecto efecto,boolean autoDirigida) {

		this.nombre = nombre;
		this.modificador = modificador;
		this.tipo = tipo;
		this.duracion = duracion;
		this.enfriamiento = enfriamiento;
		this.danoEfecto = danoEfecto;
		this.efecto = efecto;
		this.autoDirigida = autoDirigida;

	}
	
	//modifica las estadisticas del personaje pasado como parámetro.
	//Tiene en cuenta el tipo de habilidad.
	public void modificarEstadistica(Peleador personaje) {
		if(tipo == TipoHabilidad.APOYOFISICO) {
			personaje.setAtaqueFisico(personaje.getAtaqueFisico() + modificador);
			
		}
		if(tipo == TipoHabilidad.APOYOMAGICO) {
			personaje.setAtaqueMagico(personaje.getAtaqueMagico() + modificador);
			
		}
		if(tipo == TipoHabilidad.SANACION) {
			personaje.setVida(personaje.getVida() + modificador);

		}
    
		if(tipo == TipoHabilidad.DEFENSAFISICA) {
			personaje.setDefensaFisica(personaje.getDefensaFisica() + modificador);
		}
    
		if(tipo == TipoHabilidad.DEFENSAMAGICA) {
			personaje.setDefensaMagica(personaje.getDefensaMagica() + modificador);
		}
		
		if (tipo == TipoHabilidad.ATAQUEFISICO) {
			personaje.setVida(personaje.getVida() - modificador);  
		}
		if (tipo == TipoHabilidad.ATAQUEMAGICO) {
			personaje.setVida(personaje.getVida() - modificador);  
		}
		
	}
	
	
	public boolean isAutoDirigida() {
		return autoDirigida;
	}

	public TipoEfecto getEfecto() {
		return efecto;
	}


	public int getDanoEfecto() {
		return danoEfecto;

	}

	//modifica negativamente las estadisticas del personaje pasado como parámetro.
	//Tiene en cuenta el tipo de habilidad.
	public void revertirEstadistica(Peleador personaje) {
		if(tipo == TipoHabilidad.APOYOFISICO) {
			personaje.setAtaqueFisico(personaje.getAtaqueFisico() - modificador);
			
		}
		if(tipo == TipoHabilidad.APOYOMAGICO) {
			personaje.setAtaqueFisico(personaje.getAtaqueMagico() - modificador);
			
		}
		if(tipo == TipoHabilidad.SANACION) {
			personaje.setVida(personaje.getVida() - modificador);
		}
		if(tipo == TipoHabilidad.DEFENSAFISICA) {
			personaje.setDefensaFisica(personaje.getDefensaFisica() - modificador);
		}
		if(tipo == TipoHabilidad.DEFENSAMAGICA) {
			personaje.setDefensaFisica(personaje.getDefensaMagica() - modificador);
		}
		
	}

	public int getEnfriamiento() {
		return enfriamiento;
	}

	public void setEnfriamiento(int enfriamiento) {
		this.enfriamiento = enfriamiento;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getModificador() {
		return modificador;
	}
	

	public TipoHabilidad getTipo() {
		return tipo;
	}
	

	public String getNombre() {
		return nombre;
	}
	
	//Devuelve una descripción de la habilidad teniendo en cuenta su tipo.
	public String toString() {
		String descripcion = "";
		if(this.tipo == TipoHabilidad.APOYOFISICO) {
			descripcion = this.nombre +": modifica el ataque fisico del objetivo en "+this.modificador+" puntos";
		}
		if(this.tipo == TipoHabilidad.APOYOMAGICO) {
			descripcion = this.nombre +": modifica el ataque magico del objetivo en "+this.modificador+" puntos";
		}
		if(this.tipo == TipoHabilidad.DEFENSAFISICA) {
			descripcion = this.nombre +": modifica la defensa fisica del objetivo en "+this.modificador+" puntos";
		}
		if(this.tipo == TipoHabilidad.DEFENSAMAGICA){
			descripcion = this.nombre +": modifica la defensa magica del objetivo en "+this.modificador+" puntos";
		}
		if(this.tipo == TipoHabilidad.SANACION) {
			descripcion = this.nombre +": aumenta la vida del objetivo en "+this.modificador+" puntos";
		}
		
		if (this.tipo == TipoHabilidad.ATAQUEFISICO ) {
			descripcion = this.nombre +": inflige "+this.modificador+" de dano fisico al objetivo"; // 
		}
		if (this.tipo == TipoHabilidad.ATAQUEMAGICO ) {
			descripcion = this.nombre +": inflige "+this.modificador+" de dano magico al objetivo";
		}
		
		
		
		return descripcion;
		
		
	}
	
	

	
	
	
	
}