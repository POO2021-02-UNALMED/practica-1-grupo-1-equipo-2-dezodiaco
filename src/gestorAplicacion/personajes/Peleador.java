/*
Personajes principales y enemigos

Autores: Camilo, Edwin, Yeferson
*/
package personajes;
import java.util.ArrayList;
import java.util.Collections;

import complementario.Clases;
import artefactos.Objeto;
import complementario.Habilidad;
import complementario.TipoDeObjeto;
import complementario.TipoEfecto;
import complementario.TipoHabilidad;

import java.io.Serializable;
import java.lang.Math;
public class Peleador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final Clases clase;   //Tipo de jugador
	private int fragmentos = 0;	  //número de fragmentos, sirven para invocar a los totems
	private int vida;			  //medida cuantitativa de la vida del personaje.
	private final String nombre;  
	private int ataqueFisico;     //Efecto físico sobre el enemigo
	private int ataqueMagico;     //Efecto sobre el enemigo, es más fuerte que el anterior
	private int defensaFisica;	  //Resistencia a los ataques físicos
	private int defensaMagica;	  //Resistencia a los ataques mágicos
	private Objeto arma;
	private Objeto armadura;
	private Objeto anillo; 
 	private ArrayList<Objeto> inventario = new ArrayList<Objeto>();  //Aquí se guardan los objetos disponibles
 	private ArrayList<Objeto> pociones = new ArrayList<Objeto>();    //Almacenamiento de las pociones
	private int oro;
	private Totem totem;
	private ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>(5); //Habilidades del personaje
	private ArrayList<Peleador> enemigosDerrotados = new ArrayList<Peleador>(); //Se almacenan los enemigos que se van derrotando
	private ArrayList<Objeto> materiales = new ArrayList<Objeto>();   //materiales que posee
	
	
 	
		
	
	
	public Peleador(int vida, String nombre, int ataqueFisico, int ataqueMagico, int defensaFisica, 
			int defensaMagica,Objeto arma, Objeto armadura, Objeto anillo,int oro,ArrayList<Habilidad> habilidades,Clases clase) {
		
		this.clase = clase;
		this.nombre = nombre;
		
		if (clase == Clases.ARQUERO) {
			this.vida = 100;
			this.ataqueFisico = 35;
			this.ataqueMagico = 25;
			this.defensaFisica = 15;
			this.defensaMagica = 15;
			this.arma = new Objeto("Arco chino",10,TipoDeObjeto.ARCO,10,0,0,0,1,false);
			this.armadura = new Objeto("Chaleco de oso",10,TipoDeObjeto.ARMADURA,0,0,15,10,1,false);
			this.anillo = new Objeto("Anillo de principiante", 5, TipoDeObjeto.ANILLO, 2, 2,0,0,1, false);
			Objeto pocionSalud = new Objeto("pocionSalud",3,new Habilidad(TipoHabilidad.SANACION,"sanar",10,0,0,0,TipoEfecto.NULO,true));
			this.pociones.add(pocionSalud);
			this.oro = 40; // cambiar
		}
		if (clase == Clases.BRUJO) {
			this.vida = 100;
			this.ataqueFisico = 20;
			this.ataqueMagico = 40;
			this.defensaFisica = 10;
			this.defensaMagica = 17;
			this.arma = new Objeto("Varita de bronce",10,TipoDeObjeto.VARITA,5,15,0,0,5,false);
			this.armadura = new Objeto("Túnica negra",10,TipoDeObjeto.ARMADURA,0,0,7,15,5,false);
			this.anillo = new Objeto("Anillo de principiante", 5, TipoDeObjeto.ANILLO, 2, 2,0,0,5, false);
			Objeto pocionSalud = new Objeto("pocionSalud",3,new Habilidad(TipoHabilidad.SANACION,"sanar",10,0,0,0,TipoEfecto.NULO,true));
			this.pociones.add(pocionSalud);
			this.oro = 40;
		}
		if (clase == Clases.GUERRERO) {
			this.vida = 100;
			this.ataqueFisico = 40;
			this.ataqueMagico = 13;
			this.defensaFisica = 18;
			this.defensaMagica = 12;
			this.arma = new Objeto("Espada larga",10,TipoDeObjeto.ESPADA,10,0,0,0,5,false);
			this.armadura = new Objeto("Malla de acero",10,TipoDeObjeto.ARMADURA,0,0,15,10,5,false);
			this.anillo = new Objeto("Anillo de principiante", 5, TipoDeObjeto.ANILLO, 2, 2,0,0,5, false);			
			Objeto pocionSalud = new Objeto("pocionSalud",3,new Habilidad(TipoHabilidad.SANACION,"sanar",10,0,0,0,TipoEfecto.NULO,true));
			this.pociones.add(pocionSalud);
			this.oro = 40;
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
			this.anillo = anillo;
			this.arma = arma;
			this.armadura = armadura;

		}
		
		

	}
	
	public Peleador(Clases clase,String nombre) {
		this(0, nombre, 0, 0, 0, 0,null, null, null,0,null,clase);
	}

	
	public Clases getClase() {
		return clase;
	}

	public int getFragmentos() {
		return fragmentos;
	}

	public void setFragmentos(int fragmentos) {
		this.fragmentos = fragmentos;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
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

	public Objeto getArma() {
		return arma;
	}

	public void setArma(Objeto arma) {
		this.arma = arma;
	}

	public Objeto getArmadura() {
		return armadura;
	}

	public void setArmadura(Objeto armadura) {
		this.armadura = armadura;
	}

	public Objeto getAnillo() {
		return anillo;
	}

	public void setAnillo(Objeto anillo) {
		this.anillo = anillo;
	}

	public ArrayList<Objeto> getInventario() {
		return inventario;
	}

	public void setInventario(Objeto objeto) {
		this.inventario.add(objeto);
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public Totem getTotem() {
		return totem;
	}

	public void setTotem(Totem totem) {
		this.totem = totem;
	}

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}
	
	//agrega un objeto al inventario
	public void agregarObjeto(Objeto objeto) {
		if (clase == Clases.ARQUERO && (objeto.getTipo() == TipoDeObjeto.BALLESTA || objeto.getTipo() == TipoDeObjeto.ARCO) ) {
			this.inventario.add(objeto);
		}
		
		if (clase == Clases.BRUJO && (objeto.getTipo() == TipoDeObjeto.BASTON || objeto.getTipo() == TipoDeObjeto.VARITA)) {
			this.inventario.add(objeto);
		}
		
		if (clase == Clases.GUERRERO && (objeto.getTipo() == TipoDeObjeto.LANZA || objeto.getTipo() == TipoDeObjeto.ESPADA)) {
			this.inventario.add(objeto);
		}	
	}
	
	//agrega una habilidad
	public void agregarHabilidad(Habilidad habilidad) {
		this.habilidades.add(habilidad);
	}

	public String getNombre() {
		return nombre;
	}
	
	public Objeto seleccionarObjeto(int indiceObjeto) {
		return this.inventario.get(indiceObjeto);
	}
	
	
	//equipa una armadura
	public void equiparArmadura(Objeto armadura) {
		if (armadura.getTipo() == TipoDeObjeto.ARMADURA) {
			inventario.add(this.armadura);
			this.armadura = armadura;
			inventario.remove(armadura);
		}
	}
	
	//equipa un arma
	public String equiparArma(Objeto arma) {
		
		String mensaje = "";
		if (clase == Clases.ARQUERO && (arma.getTipo() == TipoDeObjeto.BALLESTA || arma.getTipo() == TipoDeObjeto.ARCO) ) {
			this.inventario.add(this.arma);
			this.arma = arma;
			inventario.remove(arma);
		}
		else {
				mensaje = "No puedes equiparte este tipo de objeto";
		}
		
		if (clase == Clases.BRUJO && (arma.getTipo() == TipoDeObjeto.BASTON || arma.getTipo() == TipoDeObjeto.VARITA)) {
			this.inventario.add(this.arma);
			this.arma = arma;
			this.inventario.remove(arma);
		}
		else {
			mensaje = "No puedes equiparte este tipo de objeto";
		}
		
		if (clase == Clases.GUERRERO && (arma.getTipo() == TipoDeObjeto.LANZA || arma.getTipo() == TipoDeObjeto.ESPADA)) {
			inventario.add(this.arma);
			this.arma = arma;
			this.inventario.remove(arma);
		}
		else {
			mensaje = "No puedes equiparte este tipo de objeto";
		}
		
		return mensaje;
	}
	
	//Equipa un anillo
	public void equiparAnillo(Objeto anillo) {
		if (anillo.getTipo() == TipoDeObjeto.ANILLO) {
			inventario.add(this.anillo);
			this.anillo = anillo;
			inventario.remove(anillo);
		}
	}
	
	//Reemplazar una habilidad por otra
	public void cambiarHabilidad(int indice, Habilidad habilidad) {
		this.habilidades.set(indice, habilidad);
	}
	
	public String toString() {
		String nombreTotem = "";
		if (getTotem() == null) {
			nombreTotem = "- - - ";
		}else{nombreTotem = getTotem().getNombre() + ", Habilidad: " + getTotem().getHabilidadEspecial().getNombre();}
		return "\nEstadísticas de " + getNombre() + ": \n" + "Clase " + getClase() + "\n" + "Vida: " + getVida() + "\n" +
				"Ataque Físico: " + (getAtaqueFisico()+anillo.getAtaqueFisico()+arma.getAtaqueFisico()+armadura.getAtaqueFisico())+ "\n" + 
				"Ataque Magico: " + (getAtaqueMagico()+anillo.getAtaqueMagico()+arma.getAtaqueMagico()+armadura.getAtaqueMagico()) + "\n" +
				"Defensa Fisica: " + (getDefensaFisica()+anillo.getDefensaFisica()+arma.getDefensaFisica()+armadura.getDefensaFisica()) + "\n" +
				"Defensa Mágica: " + (getDefensaMagica()+anillo.getDefensaMagica()+arma.getDefensaMagica()+armadura.getDefensaMagica())+ "\n" + "Totem: " + nombreTotem;
	}
	
	
	
	//Atacar
	public int atacar(Peleador enemigo) {  // ATAQUE FÍSICO 
		int dañoPropio = ataqueFisico + this.getAnillo().getAtaqueFisico() + this.getArma().getAtaqueFisico() + this.getArmadura().getAtaqueFisico();
		int defensaEnemiga = enemigo.getDefensaFisica();
		int dañoFisicoNeto = (int) Math.floor(dañoPropio-defensaEnemiga*1.5); // Los ataques básicos sufren reducción de daño por la armadura física del enemigo
		if(dañoFisicoNeto>=0) {
			return dañoFisicoNeto;
		}
		else {
			return 0;
		}
	}
	
	
	//Atacar sobrecargado
	public int atacar(Peleador enemigo, Habilidad habilidad) {
		
		int dañoHabilidad = habilidad.getModificador() + this.ataqueMagico + this.anillo.getAtaqueMagico() + this.arma.getAtaqueMagico()+this.armadura.getAtaqueMagico();
		int defensaEnemiga = enemigo.getDefensaMagica();
		int dañoMagicoNeto = (int) Math.floor(dañoHabilidad-defensaEnemiga*1.3); // El daño de habilidades sufre reducción de daño por la armadura mágica del enemigo
		
		if(dañoMagicoNeto>0) {
			return dañoMagicoNeto;
		}
		else {
			return 0;
		}
		
	}
	
	// lanza un ataque
	public String lanzarAtaque(Peleador enemigo) {
		enemigo.setVida(enemigo.getVida()-this.atacar(enemigo));
		return this.nombre+" golpea a "+enemigo.getNombre()+" y le quita "+ this.atacar(enemigo)+" de vida";
		
		
	}

	public void setHabilidades(ArrayList<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}
	
	
	//lanza una habilidad
	public String lanzarHabilidad(Habilidad habilidad,Peleador peleador) {//Habilidades con efectos, describe el nombre del enemigo, efecto de la habilidad y su duración
		if (habilidad.getEfecto() != TipoEfecto.NULO) {
			
			peleador.setVida(peleador.getVida()-this.atacar(peleador, habilidad)); 
			
			return nombre+" lanza la habilidad "+habilidad.getNombre()+" al objetivo "+peleador.getNombre()+"\n"+
			peleador.getNombre()+" recibe "+this.atacar(peleador, habilidad)+" de daño mágico "+		
			"y se le aplica el efecto "+(habilidad.getEfecto().nombreEfecto()).toLowerCase()+"\n"+
			(habilidad.getEfecto().nombreEfecto()).toLowerCase()+": "+habilidad.getEfecto().descripcion(habilidad)+" por cada turno aplicado."+" Se aplica por "+habilidad.getDuracion()+" turnos";
		
		}
		else {
			if (habilidad.isAutoDirigida()) {
				
				habilidad.modificarEstadistica(this);
				return nombre+" lanza la habilidad "+habilidad.getNombre()+" sobre sí mismo\n"+habilidad.toString(); //Habilidades sin efectos, solo indica el nombre del enemigo
			}
			else {
				habilidad.modificarEstadistica(peleador);
				return nombre+" lanza la habilidad "+habilidad.getNombre()+" sobre el enemigo "+peleador.getNombre()+"\n"+habilidad.toString();
			}
		}	
	}
	
	public Habilidad elegirHabilidad() {
		Collections.shuffle(this.habilidades);  // Reorganiza las habilidades del peleador
		return this.habilidades.get(0);
	}

	public ArrayList<Objeto> getPociones() {
		return pociones;
	}

	public void setPociones(ArrayList<Objeto> pociones) {
		this.pociones = pociones;
	}

	public ArrayList<Peleador> getEnemigosDerrotados() {
		return enemigosDerrotados;
	}

	public void setEnemigosDerrotados(ArrayList<Peleador> enemigosDerrotados) {
		this.enemigosDerrotados = enemigosDerrotados;
	}
	
	
	//Aprende una habilidad de un dios
	public String aprenderHabilidad(Dios entidad,Habilidad habilidad){
		 entidad.enseñarHabilidad(this,habilidad);
		 return entidad.hablar();
		}

	public ArrayList<Objeto> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<Objeto> materiales) {
		this.materiales = materiales;
	}
	 
	 
}
	
	

