package personajes;

import java.util.ArrayList;
import artefactos.Objeto;
import complementario.Clases;
import complementario.Habilidad;
import complementario.TipoDeObjeto;
import personajes.Totem;

public class Peleador {

	
	private final Clases clase;
	private int fragmentos = 0;
	private int vida;
	private final String nombre;
	private int ataqueFisico;
	private int ataqueMagico;
	private int defensaFisica;
	private int defensaMagica;
	private Objeto arma;
	private Objeto armadura;
	private Objeto anillo; 
 	private ArrayList<Objeto> inventario = new ArrayList<Objeto>();
	private int oro;
	private Totem totem;
	private ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>(5);
	
	
	public Peleador(int vida, String nombre, int ataqueFisico, int ataqueMagico, int defensaFisica, 
			int defensaMagica,Objeto arma, Objeto armadura, Objeto anillo,int oro,ArrayList<Habilidad> habilidades,Clases clase) {
		
		this.clase = clase;
		this.nombre = nombre;
		
		if (clase == Clases.ARQUERO) {
			this.vida = 100;
			this.ataqueFisico = 25;
			this.ataqueMagico = 15;
			this.defensaFisica = 10;
			this.defensaMagica = 10;
			this.arma = new Objeto("Arco chino",10,TipoDeObjeto.ARCO,10,0,0,0,null,5,false);
			this.armadura = new Objeto("Chaleco de oso",10,TipoDeObjeto.ARMADURA,0,0,15,10,null,5,false);
			this.anillo = new Objeto("Anillo de principiante", 5, TipoDeObjeto.ANILLO, 2, 2,0,0,null, 5, false);
			Objeto pocionSalud = new Objeto("pocionSalud",3);
			this.inventario.add(pocionSalud);
			this.oro = 0;
		}
		if (clase == Clases.BRUJO) {
			this.vida = 100;
			this.ataqueFisico = 5;
			this.ataqueMagico = 30;
			this.defensaFisica = 7;
			this.defensaMagica = 15;
			this.arma = new Objeto("Varita de bronce",10,TipoDeObjeto.VARITA,5,15,0,0,null,5,false);
			this.armadura = new Objeto("Túnica negra",10,TipoDeObjeto.ARMADURA,0,0,7,15,null,5,false);
			this.anillo = new Objeto("Anillo de principiante", 5, TipoDeObjeto.ANILLO, 2, 2,0,0,null, 5, false);
			Objeto pocionSalud = new Objeto("pocionSalud",3);
			this.inventario.add(pocionSalud);
			this.oro = 0;
		}
		if (clase == Clases.GUERRERO) {
			this.vida = 100;
			this.ataqueFisico = 40;
			this.ataqueMagico = 5;
			this.defensaFisica = 15;
			this.defensaMagica = 8;
			this.arma = new Objeto("Espada larga",10,TipoDeObjeto.ESPADA,10,0,0,0,null,5,false);
			this.armadura = new Objeto("Malla de acero",10,TipoDeObjeto.ARMADURA,0,0,15,10,null,5,false);
			this.anillo = new Objeto("Anillo de principiante", 5, TipoDeObjeto.ANILLO, 2, 2,0,0,null, 5, false);
			Objeto pocionSalud = new Objeto("pocionSalud",3);
			this.inventario.add(pocionSalud);
			this.oro = 0;
		}
		
		if (clase == Clases.ENEMIGO) {
			this.vida = vida;
			this.ataqueFisico = ataqueFisico;
			this.ataqueMagico = ataqueMagico;
			this.defensaFisica = defensaFisica;
			this.defensaMagica = defensaMagica;
			this.habilidades = habilidades;
			this.inventario = null;
			this.totem = null;

		}
		
		

	}
	
	public Peleador(Clases clase,String nombre) {
		this(0, nombre, 0, 0, 0, 0,null, null, null,0,null,clase);
	}
	
}	