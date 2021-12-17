package uiMain;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import artefactos.Objeto;
import complementario.TipoDeObjeto;
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

	}

}
