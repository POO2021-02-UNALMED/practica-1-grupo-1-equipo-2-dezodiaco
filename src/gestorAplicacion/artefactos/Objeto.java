package artefactos;

import complementario.Habilidad;
import complementario.TipoDeObjeto;

public class Objeto {
	
	
	private final TipoDeObjeto tipo;  
	private final String nombre;
	private final int precio;	 
	private int ataqueFisico;
	private int ataqueMagico;
	private int defensaFisica;
	private int defensaMagica;
	private Habilidad habilidad;
	private int durabilidad;
	private boolean evoluciona;
	private Objeto evolucion;
	
	public Objeto(String nombre,int precio,TipoDeObjeto tipo,int ataqueFisico,int ataqueMagico,int defensaFisica,int defensaMagica,Habilidad habilidad,int durabilidad,boolean evoluciona) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.ataqueFisico = ataqueFisico;
		this.ataqueMagico = ataqueMagico;
		this.defensaFisica = defensaFisica;
		this.defensaMagica = defensaMagica;
		this.habilidad = habilidad;
		this.durabilidad = durabilidad;
	}
	
	public Objeto(String nombre,int precio) {
		this(nombre,precio,TipoDeObjeto.POCION,0,0,0,0,null,1,false);
	
	}
	
}
