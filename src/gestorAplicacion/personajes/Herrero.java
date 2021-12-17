/*
Se relaciona con el personaje, comercializa, repara y evoluciona objetos

Autores: Camilo, Edwin
*/
package personajes;
import java.util.ArrayList;
import artefactos.Objeto;



public class Herrero {
	
	private String nombre;
	private ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	private double eficiencia; // Atributo que modifica la probabilidad de mejoras
	private int impuesto;  // Atributo que impacta el valor de un objeto del jugador
	
	
	
	public Herrero(String nombre, ArrayList<Objeto> objetos, double eficiencia, int impuesto) {
		this.nombre = nombre;
		this.objetos = objetos;
		this.eficiencia = eficiencia;
		this.impuesto = impuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}

	public double getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(int eficiencia) {
		this.eficiencia = eficiencia;
	}

	public int getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(int impuesto) {
		this.impuesto = impuesto;
	}
	
	//cobro de un impuesto
	public int agregarImpuesto(Objeto objeto) {
		return  (int) Math.ceil(objeto.getPrecio()+objeto.getPrecio()*this.impuesto/100);
	}
	
	//calculo del impuesto
	public int retirarImpuesto(Objeto objeto) {
		return (int) Math.floor(objeto.getPrecio()-objeto.getPrecio()*this.impuesto/100);
	}
	
	//Vende un objeto de sus disponibles
	public String vender(Peleador personaje,Objeto objeto) {
			this.objetos.remove(objeto);
			personaje.getInventario().add(objeto);
			personaje.setOro(personaje.getOro()-this.agregarImpuesto(objeto));
			
			return "\nFelicidades, has adquirido el objeto "+objeto.getNombre()+"\n";
		}
	
	//Hace ofertas y compra objetos
	public String comprar(Peleador personaje,Objeto objeto) {
		personaje.getInventario().remove(objeto);
		personaje.setOro(personaje.getOro()+this.retirarImpuesto(objeto));
		
		return "\nExcelente, seguramente esta pieza de calidad me sirva en el futuro\n";
		
		}
	
	//Repara los objetos
	public String reparar(Peleador personaje,int indice) {
		personaje.setOro(personaje.getOro()-10);
		Objeto objetoElegido = personaje.getInventario().get(indice);
		objetoElegido.setDurabilidad(objetoElegido.getDurabilidad()+1);
		
		return "\nMe ha costado un ojo reparar este objeto, pero aquí lo tienes. Ahora es más resistente que la coraza de un dragón";
		
		}
	
	//Evoluciona un objeto, si este evoluciona
	public String evolucionar(Peleador personaje,Objeto objeto) {
		
		double suerte = Math.random();
		double probabilidadMejora = eficiencia;
		int indice = personaje.getInventario().indexOf(objeto);
		
		for(Objeto material: personaje.getInventario().get(indice).getMaterialesEvolucion()) {
			personaje.getMateriales().remove(material);
		}
		
		
		if(suerte<=probabilidadMejora) {
			personaje.getInventario().add(objeto.getEvolucion());
			personaje.getInventario().remove(objeto);
			return "\nFelicidades, tu objeto ha sido evolucionado";
		}
		else {
			personaje.setOro(personaje.getOro()+10);
			personaje.getInventario().remove(objeto);
			return "\nEs una pena, el objeto no resistió el proceso. Toma 10 de oro como compensacion";
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	}	