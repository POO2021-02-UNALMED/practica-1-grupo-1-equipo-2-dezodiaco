package uiMain;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import artefactos.Objeto;
import artefactos.Tesoro;
import complementario.Habilidad;
import complementario.TipoDeObjeto;
import complementario.TipoEfecto;
import complementario.TipoHabilidad;
import personajes.*;

public class Juego {

	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static int read() {
		return sc.nextInt();
	
	}
	static String readStr() {
		return sc2.nextLine();
	}	

	public static void main(String[] args) {

		System.out.println("             Bienvenido al Desafío del Zodiaco               \n"+"\n"+
				 "Los dioses del zodiaco te han encomendado la tarea de derrotar al Asediador de almas.\n"+ 
				 "Un ser oscuro inmune al poder sagrado que busca dominar al mundo estableciendo\n"+ 
				 "un letal ejército de almas pérdidas que ha ido recolectando a lo largo de milenios.\n"+ 
				 "Solo los humanos pueden detener su progreso, pues estos son hijos de la luz y la oscuridad\n");
		
System.out.println("¿Deseas empezar un juego nuevo o cargar la partida guardada?");
		
		System.out.println(1+": Empezar juego nuevo");
		System.out.println(2+": Cargar partida");
		
		System.out.print("Seleccionar: ");
		
		int elegir = read();
		
		File archivo1 = new File(System.getProperty("user.dir")+"/src/baseDatos/temp/personajes.txt");
		File archivo2 = new File(System.getProperty("user.dir")+"/src/baseDatos/temp/nodos.txt");
		
		if(elegir == 1) {
			if(archivo1.exists() && archivo2.exists()) {
				archivo1.delete();
				archivo2.delete();
			}
			
		}
		else {
			if(archivo1.length() == 0L || archivo2.length()== 0L) {
				System.out.println("No hay partidas guardadas\n");
				System.out.println("A continuacion empezaras una nueva\n");
				archivo1.delete();
				archivo2.delete();
			}
			else {
				System.out.println("Cargando partida guardada\n");
			}
				
		}
		File archivos = new File(System.getProperty("user.dir")+"/src/baseDatos/temp/personajes.txt");
		
		
		// CreaciÃ³n del personaje
		Peleador personaje = null;
		
		
		// Objetos sin estadísticas
		Objeto anillo0 = new Objeto("Anillo decorador",0, TipoDeObjeto.ANILLO, 0,0,0,0,0, false);
		Objeto arma01 = new Objeto("Arco roto",0,TipoDeObjeto.ARCO,0,0,0,0,0,false);
		Objeto arma02 = new Objeto("Espada rota",0,TipoDeObjeto.ESPADA,0,0,0,0,5,false);
		Objeto arma03= new Objeto("Varita rota",0,TipoDeObjeto.VARITA,0,0,0,0,0,false);
		Objeto armadura0 = new Objeto("Armadura rota",0,TipoDeObjeto.ARMADURA,0,0,0,0,0,false);
		
		ArrayList<Objeto> objetosNulos = new ArrayList<Objeto>();
		objetosNulos.add(armadura0);
		objetosNulos.add(arma01);
		objetosNulos.add(arma02);
		objetosNulos.add(arma03);
		objetosNulos.add(anillo0);
		
		
		// Objetos con estadisticas

		Objeto arcoT1 = new Objeto("Arco sagrado",10,TipoDeObjeto.ARCO,15,3,0,0,5,true);
		Objeto arcoT2 = new Objeto("Arco del caos",10,TipoDeObjeto.ARCO,20,8,0,0,5,false);
		Objeto espadaT1 = new Objeto("Espada sagrada",10,TipoDeObjeto.ESPADA,17,0,0,0,5,true);
		Objeto espadaT2 = new Objeto("Espada del caos",10,TipoDeObjeto.ESPADA,23,0,0,0,5,false);
		Objeto varitaT1 = new Objeto("Varita sagrada",10,TipoDeObjeto.VARITA,8,14,0,0,5,true);
		Objeto varitaT2 = new Objeto("Varita del caos",10,TipoDeObjeto.VARITA,12,22,0,0,5,false);
		Objeto lanzaT = new Objeto("Lanza del sol",10,TipoDeObjeto.LANZA,17,0,0,0,5,false);
		Objeto ballestaT = new Objeto("Ballesta del sol",10,TipoDeObjeto.BALLESTA,14,4,0,0,5,false);
		Objeto bastonT = new Objeto("Baston del sol",10,TipoDeObjeto.BASTON,6,16,0,0,5,false);
		Objeto armaduraL = new Objeto("Chaleco ligero",10,TipoDeObjeto.ARMADURA,0,0,11,14,5,false);
		Objeto armaduraM = new Objeto("Guardiana celeste",10,TipoDeObjeto.ARMADURA,0,0,16,18,5,true);
		Objeto armaduraP = new Objeto("Coraza de hueso",10,TipoDeObjeto.ARMADURA,0,0,20,22,5,false);
		Objeto anilloL = new Objeto("Anillo de arcoiris",10,TipoDeObjeto.ANILLO,6,3,2,5,5,false);
		Objeto anilloM = new Objeto("Anillo del viento",10,TipoDeObjeto.ANILLO,10,7,5,6,1,true);
		Objeto anilloP = new Objeto("Anillo de cuarzo",10,TipoDeObjeto.ARCO,20,0,0,0,1,false);
		Objeto armaH1 = new Objeto("Arco supremo",10,TipoDeObjeto.ARCO,12,2,0,0,4,false);
		Objeto armaH2 = new Objeto("Espada lunar",10,TipoDeObjeto.ESPADA,14,0,0,0,4,false);
		Objeto armaH3 = new Objeto("Varita curva",10,TipoDeObjeto.VARITA,5,12,0,0,4,false);
		Objeto armaH4 = new Objeto("Lanza de acero",10,TipoDeObjeto.LANZA,14,0,0,0,4,false);
		Objeto armaH5 = new Objeto("Baston igneo",10,TipoDeObjeto.BASTON,4,12,0,0,5,false);
		Objeto armaduraH6 = new Objeto("Placa negra",10,TipoDeObjeto.ARMADURA,0,0,12,13,5,false);
		
		// Materiales
		Objeto material1 = new Objeto("Piedra blanca");
		Objeto material2 = new Objeto("Ojo morado");
		Objeto material3 = new Objeto("Fragmento magico");
		Objeto material4 = new Objeto("Cuarzo verde");
		Objeto material5 = new Objeto("Cromo mejorado");
		Objeto material6 = new Objeto("Tela de mago");
		Objeto material7 = new Objeto("Tierra maligna");
		Objeto material8 = new Objeto("Espiga de acero");
		Objeto material9 = new Objeto("Reliquia sagrada");
		
		
		// Conjuntos de materiales para evolucionar
		ArrayList<Objeto> materiales1 = new ArrayList<Objeto>();
		ArrayList<Objeto> materiales2 = new ArrayList<Objeto>();
		ArrayList<Objeto> materiales3 = new ArrayList<Objeto>();
		
		materiales1.add(material1);
		materiales1.add(material3);
		materiales1.add(material7);
		materiales1.add(material5);
		
		materiales2.add(material2);
		materiales2.add(material4);
		materiales2.add(material7);
		materiales2.add(material6);
		
		materiales3.add(material7);
		materiales3.add(material3);
		materiales3.add(material1);
		materiales3.add(material8);
		
		arcoT1.setMaterialesEvolucion(materiales3);
		espadaT1.setMaterialesEvolucion(materiales2);
		varitaT1.setMaterialesEvolucion(materiales1);
		armaduraM.setMaterialesEvolucion(materiales3);
		anilloM.setMaterialesEvolucion(materiales1);
		
		
		arcoT1.setEvolucion(arcoT2);
		espadaT1.setEvolucion(espadaT2);
		varitaT1.setEvolucion(varitaT2);
		anilloM.setEvolucion(anilloP);
		armaduraM.setEvolucion(armaduraP);
		
		
		ArrayList<Objeto> premios1 = new ArrayList<Objeto>();
		ArrayList<Objeto> premios2 = new ArrayList<Objeto>();
		ArrayList<Objeto> premios3 = new ArrayList<Objeto>();
		
		premios1.add(armaduraL);
		premios1.add(material5);
		premios1.add(lanzaT);
		premios1.add(material3);
		premios1.add(material7);
		premios1.add(armaH2);
		premios1.add(armaH5);
		premios1.add(anilloL);
		
		
		premios2.add(armaduraM);
		premios2.add(material8);
		premios2.add(lanzaT);
		premios2.add(material4);
		premios2.add(material1);
		premios2.add(armaduraH6);
		premios2.add(armaH3);
		premios2.add(espadaT1);
		premios2.add(anilloM);
		
		premios3.add(material2);
		premios3.add(material6);
		premios3.add(material3);
		premios3.add(material9);
		premios3.add(espadaT1);
		premios3.add(arcoT1);
		premios3.add(varitaT1);
		premios3.add(armaduraM);
		premios3.add(anilloM);
		
		
		// Creacion de tesoros
		
		Tesoro tesoro1 = new Tesoro("Vuelo de Onivia",premios1);
		Tesoro tesoro2 = new Tesoro("Serpiente gris",premios2);
		Tesoro tesoro3 = new Tesoro("Cofre divino",premios3);
		
		
		
		// Objetos que vende el herrero
		ArrayList<Objeto> objetosVenta = new ArrayList<Objeto>();
		objetosVenta.add(armaH1);
		objetosVenta.add(armaH2);
		objetosVenta.add(armaH3);
		objetosVenta.add(armaH4);
		objetosVenta.add(armaH5);
		objetosVenta.add(armaduraH6);
		
		
		// Creacion herrero
		Herrero pacho = new Herrero("Pacho",objetosVenta,80,15);
		
		
		// Creacion habilidades
		Habilidad habilidad1 = new Habilidad(TipoHabilidad.DEFENSAFISICA,"Coraza de acero",10,0,3,0, TipoEfecto.NULO, true);
		Habilidad habilidad2 = new Habilidad(TipoHabilidad.SANACION,"Palabra regeneradora",10,0,3,0, TipoEfecto.NULO, true);
		Habilidad habilidad3 = new Habilidad(TipoHabilidad.ATAQUEFISICO,"Ira del trueno",10,0,3,2, TipoEfecto.NULO, false);
		Habilidad habilidad4 = new Habilidad(TipoHabilidad.DEFENSAMAGICA,"Escudo magico",10,0,2,0, TipoEfecto.NULO, true);
		Habilidad habilidad5 = new Habilidad(TipoHabilidad.ATAQUEMAGICO,"Tempestad del Zodiaco",10,0,2,0, TipoEfecto.NULO, false);
		Habilidad habilidad6 = new Habilidad(TipoHabilidad.APOYOFISICO,"Llama interna",10,0,3,0, TipoEfecto.NULO, true);
		Habilidad habilidad7 = new Habilidad(TipoHabilidad.ATAQUEFISICO,"Nova llameante",10,2,4,5, TipoEfecto.QUEMAR, false);
		Habilidad habilidad8 = new Habilidad(TipoHabilidad.ATAQUEFISICO,"Salto fuerte",10,0,2,0, TipoEfecto.NULO, false);
		Habilidad habilidad9 = new Habilidad(TipoHabilidad.ATAQUEMAGICO,"Mordedura de cobra",13,2,4,8, TipoEfecto.ENVENENAR, false);
		Habilidad habilidad10 = new Habilidad(TipoHabilidad.ATAQUEMAGICO,"Flecha venenosa",10,2,3,7, TipoEfecto.ENVENENAR, false);
		Habilidad habilidad11 = new Habilidad(TipoHabilidad.ATAQUEFISICO,"Furia vikinga",10,0,2,0, TipoEfecto.NULO, false);
		Habilidad habilidad12 = new Habilidad(TipoHabilidad.ATAQUEMAGICO,"Bola de fuego",10,2,3,7, TipoEfecto.QUEMAR, false);
		Habilidad habilidad13 = new Habilidad(TipoHabilidad.ATAQUEMAGICO,"Frio de invierno",10,1,3,10, TipoEfecto.CONGELAR, false);
		Habilidad habilidad14 = new Habilidad(TipoHabilidad.APOYOFISICO,"Grito alentador",15,0,3,0, TipoEfecto.NULO, true);
		Habilidad habilidad15 = new Habilidad(TipoHabilidad.DEFENSAFISICA,"Coraza reforzada",15,0,3,1, TipoEfecto.NULO, false);
		Habilidad habilidad16 = new Habilidad(TipoHabilidad.ATAQUEMAGICO,"Cero absoluto",15,1,3,10, TipoEfecto.CONGELAR, false);
		Habilidad habilidad17 = new Habilidad(TipoHabilidad.ATAQUEMAGICO,"Resplandor del caos",20,1,5,6, TipoEfecto.QUEMAR, false);
		Habilidad habilidad18 = new Habilidad(TipoHabilidad.SANACION,"Rejuvenecimiento",23,0,3,0, TipoEfecto.NULO, true);

		
		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>(); //enemigo nodo1
		habilidades.add(habilidad1);
		habilidades.add(habilidad7);
		habilidades.add(habilidad5);
		habilidades.add(habilidad4);
		habilidades.add(habilidad8);

		
		ArrayList<Habilidad> habilidades1 = new ArrayList<Habilidad>(); // enemigo1 nodo2 
		habilidades1.add(habilidad15);
		habilidades1.add(habilidad2);
		habilidades1.add(habilidad8);
		habilidades1.add(habilidad13);
		habilidades1.add(habilidad9);
		
		
		
		ArrayList<Habilidad> habilidades2 = new ArrayList<Habilidad>(); // enemigo2 nodo2 
		habilidades2.add(habilidad15);
		habilidades2.add(habilidad14);
		habilidades2.add(habilidad10);
		habilidades2.add(habilidad2);
		habilidades2.add(habilidad17);
		
		
		ArrayList<Habilidad> habilidades3 = new ArrayList<Habilidad>(); // enemigo1 nodo3 
		habilidades3.add(habilidad15);
		habilidades3.add(habilidad14);
		habilidades3.add(habilidad10);
		habilidades3.add(habilidad16);
		habilidades3.add(habilidad18);
		
		
		ArrayList<Habilidad> habilidades4 = new ArrayList<Habilidad>(); // dioses 1 
		habilidades4.add(habilidad4);
		habilidades4.add(habilidad2);
		habilidades4.add(habilidad14);
		habilidades4.add(habilidad11);
		
		
		ArrayList<Habilidad> habilidades5 = new ArrayList<Habilidad>(); // dioses 2 
		habilidades5.add(habilidad4);
		habilidades5.add(habilidad6);
		habilidades5.add(habilidad14);
		habilidades5.add(habilidad15);

	}

}
