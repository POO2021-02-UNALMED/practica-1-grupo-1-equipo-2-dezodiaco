/*
Se implementa para la creación de los objetos que van a estar presentes en el juego


Autores: Camilo, Yeferson 
*/

package artefactos;
import java.io.Serializable;
import java.util.ArrayList;

import complementario.Habilidad;
import complementario.TipoDeObjeto;

public class Objeto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final TipoDeObjeto tipo;  //Clasificación del objeto segun su tipo
	private final String nombre;      //Nombre del objeto
	private final int precio;	      //Constante con el valor del objeto
	private int ataqueFisico;         //Contribución al ataque físico de quien lo posee
	private int ataqueMagico;         //Contribución al ataque mágico de quien lo posee
	private int defensaFisica;        //Contribución al defensa física de quien lo posee
	private int defensaMagica;        //Contribución al defensa mágica de quien lo posee
	private Habilidad habilidad;      //Habilidad del objeto
	private int durabilidad;          //Numero de turnos que dura el objeto sin deteriorarse
	private boolean evoluciona;       //Determina si el objeto puede o no evolucionar
	private Objeto evolucion;         //Objeto al que evoluciona
	private ArrayList<Objeto> materialesEvolucion = new ArrayList<Objeto>();  //materiales necesarios para evolucionar
	
	
	// Constructor armas,armaduras y anillos
	public Objeto(String nombre,int precio,TipoDeObjeto tipo,int ataqueFisico,int ataqueMagico,int defensaFisica,int defensaMagica,int durabilidad,boolean evoluciona) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.ataqueFisico = ataqueFisico;
		this.ataqueMagico = ataqueMagico;
		this.defensaFisica = defensaFisica;
		this.defensaMagica = defensaMagica;
		this.durabilidad = durabilidad;
		this.evoluciona = evoluciona;
	}
	
	// Constructor pociones
	public Objeto(String nombre,int precio,Habilidad habilidad) {
		this(nombre,precio,TipoDeObjeto.POCION,0,0,0,0,1,false);
		this.habilidad = habilidad;
	
	}
	
	// Constructor de materiales
	public Objeto(String nombre) {
		this(nombre,0,TipoDeObjeto.MATERIAL,0,0,0,0,1,false);
		
	}
	

	public TipoDeObjeto getTipo() {
		return tipo;
	}

	public int getPrecio() {
		return precio;
	}


	public int getAtaqueFisico() {
		return ataqueFisico;
	}

	public void setAtaqueFisico(int ataqueFisico) {
		this.ataqueFisico = ataqueFisico;
	}

	public int getAtaqueMagico() {
		return ataqueMagico;
	}

	public void setAtaqueMagico(int ataqueMagico) {
		this.ataqueMagico = ataqueMagico;
	}

	public Habilidad getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	public int getDurabilidad() {
		return durabilidad;
	}

	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean isEvoluciona() {
		return evoluciona;
	}
	
	public Objeto getEvolucion() {
		return evolucion;
	}
	

	public int getDefensaFisica() {
		return defensaFisica;
	}

	public void setDefensaFisica(int defensaFisica) {
		this.defensaFisica = defensaFisica;
	}

	public int getDefensaMagica() {
		return defensaMagica;
	}

	public void setDefensaMagica(int defensaMagica) {
		this.defensaMagica = defensaMagica;
	}

	public void setEvoluciona(boolean evoluciona) {
		this.evoluciona = evoluciona;
	}

	public void setEvolucion(Objeto evolucion) {
		this.evolucion = evolucion;
	}

	public String toString() {
		return "- " + getNombre() + " : " + getAtaqueFisico() + ", " + getAtaqueMagico()
				+ ", " + getDefensaFisica() + ", " + getDefensaMagica() + ", " + getDurabilidad() ;
				
	}

	public ArrayList<Objeto> getMaterialesEvolucion() {
		return materialesEvolucion;
	}

	public void setMaterialesEvolucion(ArrayList<Objeto> materialesEvolucion) {
		this.materialesEvolucion = materialesEvolucion;
	}
	
	
	
	
	
	
	
	
}
