/*
Interfaz del usuario, se crean las instancias bases para el desarrollo del juego 
y se presentan los distintos menus del juego.

Autores: Yeferson, Camilo, Edwin.
*/

package uiMain;
import personajes.*;
import artefactos.*;
import complementario.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.io.File;
import java.lang.Math;
import baseDatos.*;

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
		
		
		System.out.println("             Bienvenido al Desafio del Zodiaco               \n"+"\n"+
				 "Los dioses del zodiaco te han encomendado la tarea de derrotar al Asediador de almas.\n"+ 
				 "Un ser oscuro inmune al poder sagrado que busca dominar al mundo estableciendo\n"+ 
				 "un letal ejercito de almas perdidas que ha ido recolectando a lo largo de milenios.\n"+ 
				 "Solo los humanos pueden detener su progreso, pues estos son hijos de la luz y la oscuridad\n");
		

		System.out.println("øDeseas empezar un juego nuevo o cargar la partida guardada?");
		
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
		
		
		// Creacion del personaje
		Peleador personaje = null;
		
		
		// Objetos sin estadÌsticas
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
		Herrero pacho = new Herrero("Pacho",objetosVenta,0.8,15);
		
		
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
		Habilidad habilidad15 = new Habilidad(TipoHabilidad.DEFENSAFISICA,"Coraza reforzada",15,0,3,1, TipoEfecto.NULO, true);
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
		
		
		ArrayList<Habilidad> habilidadesPeleadores = new ArrayList<Habilidad>();
		habilidadesPeleadores.add(habilidad2);
		habilidadesPeleadores.add(habilidad6);
		habilidadesPeleadores.add(habilidad12);
		
	
		
		
		//Creacion de dioses
		Dios aries = new Dios("Aries");
		Dios virgo = new Dios("Virgo");
		Dios escorpio = new Dios("Escorpio");
		Dios tauro = new Dios("Tauro");
		Dios geminis = new Dios("Geminis");
		Dios cancer = new Dios("Cancer");
		Dios leo = new Dios("Leo");
		Dios libra = new Dios("Libra");
		Dios sagitario = new Dios("Sagitario");
		Dios capricornio = new Dios("Capricornio");
		Dios acuario = new Dios("Acuario");
		Dios piscis = new Dios("Piscis");
		
		//Asignar habilidades a los dioses
		tauro.setHabilidades(habilidades4);
		aries.setHabilidades(habilidades5);
		geminis.setHabilidades(habilidades5);
		cancer.setHabilidades(habilidades4);
		leo.setHabilidades(habilidades5);
		virgo.setHabilidades(habilidades4);
		libra.setHabilidades(habilidades5);
		escorpio.setHabilidades(habilidades4);
		sagitario.setHabilidades(habilidades5);
		capricornio.setHabilidades(habilidades4);
		acuario.setHabilidades(habilidades5);
		piscis.setHabilidades(habilidades4);
		
		
		
		ArrayList<Dios> dioses = new ArrayList<Dios>();
		dioses.add(tauro);
		dioses.add(aries);
		dioses.add(geminis);
		dioses.add(cancer);
		dioses.add(leo);
		dioses.add(virgo);
		dioses.add(escorpio);
		dioses.add(sagitario);
		dioses.add(capricornio);
		dioses.add(acuario);
		dioses.add(piscis);
		dioses.add(libra);
		
		

		//Asignacion de dioses a las listas para los nodos
		ArrayList<Dios> diosesNodo1 = new ArrayList<Dios>();
		diosesNodo1.add(leo);
		diosesNodo1.add(libra);
		diosesNodo1.add(cancer);
		diosesNodo1.add(sagitario);
		
		ArrayList<Dios> diosesNodo2 = new ArrayList<Dios>();
		diosesNodo2.add(aries);
		diosesNodo2.add(acuario);
		diosesNodo2.add(virgo);
		diosesNodo2.add(piscis);
		
		ArrayList<Dios> diosesNodo3 = new ArrayList<Dios>();
		diosesNodo3.add(escorpio);
		diosesNodo3.add(geminis);
		diosesNodo3.add(capricornio);
		diosesNodo3.add(tauro);
		
		
		//Enemigos nodo1
		Peleador enemigo1n1 = new Peleador(100, "Manticora", 15, 10, 16, 12, armaH2, armaduraH6, anillo0, 0, null, Clases.ENEMIGO);
		
		// Enemigos nodo 2
		Peleador enemigo1n2 = new Peleador(130, "Martiwax", 17, 13, 20, 14, armaH4, armaduraL, anilloL, 0, null, Clases.ENEMIGO);
		Peleador enemigo2n2 = new Peleador(130, "Reaper", 16, 17, 17, 13, armaH3, armaduraM, anilloL, 0, null, Clases.ENEMIGO);
		
		//Enemigo nodo 3
		Peleador enemigo1n3 = new Peleador(160, "Asediador de almas", 21, 20, 22, 16, espadaT1, armaduraM, anilloM, 0, null, Clases.ENEMIGO);
		

		
		enemigo1n1.setHabilidades(habilidades);
		enemigo1n2.setHabilidades(habilidades1);
		enemigo2n2.setHabilidades(habilidades2);
		enemigo1n3.setHabilidades(habilidades3);
		
		
		// Creacion de totems
		Totem totem1 = new Totem("Kali", habilidad1, ballestaT);
		Totem totem2 = new Totem("Hathor", habilidad2, lanzaT);
		Totem totem3 = new Totem("Horus", habilidad4, armaduraM);
		Totem totem4 = new Totem("Lugh", habilidad6, anilloM);
		Totem totem5 = new Totem("Lakshmi", habilidad14, bastonT);
		
		ArrayList<Totem> Totems = new ArrayList<Totem>();    
		Totems.add(totem1);		
		Totems.add(totem2);
		Totems.add(totem3);
		Totems.add(totem4);
		Totems.add(totem5);
		
		
		Sabio sabio = new Sabio("Sabio", habilidades, new ArrayList<Objeto>(), new ArrayList<Peleador>(), 0, 0, Totems);       
		
		
		ArrayList<Peleador> misionCombate = new ArrayList<Peleador>();  //lista de ensayo para las misiones de combate.
		misionCombate.add(enemigo1n1);
		misionCombate.add(enemigo1n2);
		misionCombate.add(enemigo1n3);
		
		ArrayList<Objeto> misionBusqueda = new ArrayList<Objeto>();  //lista de ensayo para las misiones de b√∫squeda.
		misionBusqueda.add(anilloL);
		misionBusqueda.add(armaduraM);
		misionBusqueda.add(varitaT1);
		
		
		File archivo = new File(System.getProperty("user.dir")+"/src/baseDatos/temp/personajes.txt");
		if(archivo.isFile()) {  
			personaje = Deserializador.deserializarPersonaje();
			ArrayList<Nodo> nodoSerializados = Deserializador.deserializarNodos();
			Nodo.setNodos(nodoSerializados);
			
			
		}
		else{
			Hashtable<Integer,String> clasesNumeradas = new Hashtable<Integer,String>();
			clasesNumeradas.put(1, "Guerrero" );
			clasesNumeradas.put(2, "Arquero" );
			clasesNumeradas.put(3, "Brujo");
			Hashtable<Integer,Clases> numeroClase = new Hashtable<Integer,Clases>(); 
			numeroClase.put(1,Clases.GUERRERO);
			numeroClase.put(2,Clases.ARQUERO);
			numeroClase.put(3,Clases.BRUJO);
			
			System.out.println("Estas son las clases de personaje que puedes elegir "+"\n");
			System.out.println("1: Guerrero");
			System.out.println("2: Arquero");
			System.out.println("3: Brujo\n");
			
			boolean verificadorClase = false;
			int claseUsuario = 0;
			do {
				System.out.print("Seleccionar la clase: " );
				claseUsuario = read();
				verificadorClase = (claseUsuario == 1 || claseUsuario == 2 || claseUsuario == 3);
				if (verificadorClase == true) {
					System.out.println("Has seleccionado la clase "+clasesNumeradas.get(claseUsuario));
					break;
				}
				else {
					System.out.println("Selecciona alguna de las clases");
				}
			}while (verificadorClase == false);
			
		
			//Scanner prueba = new Scanner(System.in);
			boolean verificadorNombre = true;
			String nombreUsuario ; 

			
			//Validaci√≥n del nombre
			do {
				System.out.print("Escribe tu nombre: ");
				nombreUsuario = readStr();
				verificadorNombre = !nombreUsuario.isEmpty();
				if (verificadorNombre == true) {
					System.out.println("Tu personaje es un "+clasesNumeradas.get(claseUsuario)+" llamado "+nombreUsuario+"\n" );
					break;
				}
				else {
					System.out.println("Por favor ingrese un nombre para el personaje");
				}
			}while (verificadorNombre == false);
			
			
			personaje = new Peleador(numeroClase.get(claseUsuario),nombreUsuario);
			personaje.setHabilidades(habilidadesPeleadores);
			personaje.setFragmentos(4);
			
			Nodo nodo0 = new Nodo("Zona inicial",null,new ArrayList<Nodo>(),false,new ArrayList<Peleador>(),new ArrayList<Tesoro>());
			Nodo nodo1 = new Nodo("Valle de las sombras",diosesNodo1,new ArrayList<Nodo>(),true,new ArrayList<Peleador>(),new ArrayList<Tesoro>());
			Nodo nodo2 = new Nodo("Monte helado",diosesNodo2,new ArrayList<Nodo>(),false,new ArrayList<Peleador>(),new ArrayList<Tesoro>());
			Nodo nodo3 = new Nodo("Laguna de los gritos",diosesNodo3,new ArrayList<Nodo>(),false,new ArrayList<Peleador>(),new ArrayList<Tesoro>());
			
			//Conexiones desde el nodo 1
			ArrayList<Nodo> conexionesNodo1 = new ArrayList<Nodo>();
			conexionesNodo1.add(nodo2);
			nodo1.setConexiones(conexionesNodo1);
			
			// Conexiones desde el nodo 2
			ArrayList<Nodo> conexionesNodo2 = new ArrayList<Nodo>();
			conexionesNodo2.add(nodo3);
			nodo2.setConexiones(conexionesNodo2);
			
						
			// AÒadir enemigos a los nodos
			ArrayList<Peleador> enemigosN1= new ArrayList<Peleador>();
			enemigosN1.add(enemigo1n1);
			nodo1.setEnemigos(enemigosN1);
			
			ArrayList<Peleador> enemigosN2 = new ArrayList<Peleador>();
			enemigosN2.add(enemigo1n2);
			enemigosN2.add(enemigo2n2);
			nodo2.setEnemigos(enemigosN2);
			
			ArrayList<Peleador> enemigosN3 = new ArrayList<Peleador>();
			enemigosN3.add(enemigo1n3);
			nodo3.setEnemigos(enemigosN3);
			
			nodo1.setDioses(diosesNodo1);
			nodo2.setDioses(diosesNodo2);
			nodo3.setDioses(diosesNodo3);
			
			nodo1.getTesoros().add(tesoro1);
			nodo2.getTesoros().add(tesoro2);
			nodo3.getTesoros().add(tesoro3);
			
			personaje.getInventario().add(espadaT1);
			personaje.getInventario().add(varitaT1);
			personaje.getInventario().add(arcoT1);
			
			personaje.getMateriales().add(material1);
			personaje.getMateriales().add(material2);
			personaje.getMateriales().add(material3);
			personaje.getMateriales().add(material4);
			personaje.getMateriales().add(material5);
			personaje.getMateriales().add(material6);
			personaje.getMateriales().add(material7);
			personaje.getMateriales().add(material8);
			
			
			
		}
		

		
		
		System.out.println("Los dioses te han teletransportado al camino de los doce, un lugar magico");
		System.out.println("donde podras acceder a diversos lugares para completar tu mision.\n");
		
		
				
		
		
		int opcion = 0;
		
		
		//Primer men√∫
		do {
			
			System.out.println("\n   Camino de los doce\n");
			System.out.println("1: Ir al campo de batalla");
			System.out.println("2: Consultar atributos del personaje");
			System.out.println("3: Revisar inventario");
			System.out.println("4: Visitar al sabio");
			System.out.println("5: Visitar al herrero");
			System.out.println("6: Terminar juego\n");
			System.out.print("Selecciona una opcion:");
			opcion = read();			
			
			switch(opcion) {
				//Ir al campo de batalla
				case 1:    	
							boolean verificadorNodo = false;
							do {
							System.out.println("\n"+"Nodos de batalla disponibles\n");
							System.out.println(0+":Regresar al camino de los doce");
							
							ArrayList<Nodo> nodosDisponibles = new ArrayList<Nodo>();
							
							for(Nodo nodo: Nodo.getNodos()) {
								if(nodo.isAbierto()) {
									nodosDisponibles.add(nodo);
								}
							}
							
							for(int i = 1;i<Nodo.getNodos().size();i++) {
								if (Nodo.getNodos().get(i).isAbierto()) {
									System.out.println(nodosDisponibles.indexOf(Nodo.getNodos().get(i))+1+":"+Nodo.getNodos().get(i).getNombre());
								}
							}	
							
							
							int eleccionNodo = 0;
							System.out.print("Selecciona el nodo al que deseas desplazarte: ");
							eleccionNodo = read();
							
							int indiceNodo = 0;
							
							if(eleccionNodo != 0) {
							indiceNodo = Nodo.getNodos().indexOf(nodosDisponibles.get(eleccionNodo-1));
							}
							
							if (eleccionNodo == 0) {
								verificadorNodo = true;
							
							}
							
		
							else if (Nodo.getNodos().get(indiceNodo).isAbierto() == true) {
								verificadorNodo = true;
								Nodo nodoElegido = Nodo.getNodos().get(indiceNodo);
								System.out.println("\nHas ingresado al "+Nodo.getNodos().get(indiceNodo).getNombre());
								Peleador enemigoNodo = Nodo.getNodos().get(indiceNodo).elegirEnemigo(); // Selecciona un enemigo aleatorio del nodo
								System.out.println("\nTe has encontrado al enemigo "+enemigoNodo.getNombre());
								System.out.println("\nEn un momento comenzara la batalla\n");
								Dios diosParticipante = Nodo.getNodos().get(indiceNodo).elegirDios(); // Elegimos un dios aleatorio del nodo 
								Habilidad habilidadActivada = diosParticipante.elegirHabilidad(); // Tomamos una habilidad aleatoria del dios elegido
								// La habilidad escogida se va a activar por una vez al principio de cada combate 
								
								
								ArrayList<Integer> estadoInicialEnemigo = new ArrayList<Integer>();
								estadoInicialEnemigo.add(enemigoNodo.getVida());
								estadoInicialEnemigo.add(enemigoNodo.getAtaqueFisico());
								estadoInicialEnemigo.add(enemigoNodo.getAtaqueMagico());
								estadoInicialEnemigo.add(enemigoNodo.getDefensaFisica());
								estadoInicialEnemigo.add(enemigoNodo.getDefensaMagica());
								
								ArrayList<Integer> estadoInicialUsuario = new ArrayList<Integer>();
								estadoInicialUsuario.add(personaje.getVida());
								estadoInicialUsuario.add(personaje.getAtaqueFisico());
								estadoInicialUsuario.add(personaje.getAtaqueMagico());
								estadoInicialUsuario.add(personaje.getDefensaFisica());
								estadoInicialUsuario.add(personaje.getDefensaMagica());
								
								ArrayList<Integer> listaEnfriamientosUsuario = new ArrayList<Integer>(5);
								listaEnfriamientosUsuario.add(0);
								listaEnfriamientosUsuario.add(0);
								listaEnfriamientosUsuario.add(0);
								listaEnfriamientosUsuario.add(0);
								listaEnfriamientosUsuario.add(0);
								
								ArrayList<Integer> listaEnfriamientosEnemigo = new ArrayList<Integer>(5);
								listaEnfriamientosEnemigo.add(0);
								listaEnfriamientosEnemigo.add(0);
								listaEnfriamientosEnemigo.add(0);
								listaEnfriamientosEnemigo.add(0);
								listaEnfriamientosEnemigo.add(0);
								
								ArrayList<Integer> listaDuracionUsuario = new ArrayList<Integer>();
								listaDuracionUsuario.add(0);
								listaDuracionUsuario.add(0);
								listaDuracionUsuario.add(0);
								listaDuracionUsuario.add(0);
								listaDuracionUsuario.add(0);
								
								ArrayList<Integer> listaDuracionEnemigo = new ArrayList<Integer>();
								listaDuracionEnemigo.add(0);
								listaDuracionEnemigo.add(0);
								listaDuracionEnemigo.add(0);
								listaDuracionEnemigo.add(0);
								listaDuracionEnemigo.add(0);
								
								
								ArrayList<Peleador> peleadores = new ArrayList<Peleador>();
								peleadores.add(enemigoNodo);
								peleadores.add(personaje);
								Collections.shuffle(peleadores);
								Peleador peleadorElegido = peleadores.get(0);  // El dios elegido lanza su habilidad sobre el usuario o el enemigo
								System.out.println("El dios "+ diosParticipante.getNombre()+" lanza la habilidad "+habilidadActivada.getNombre()+" sobre el peleador "+peleadorElegido.getNombre()+"\n");
								System.out.println(habilidadActivada);
								habilidadActivada.modificarEstadistica(peleadorElegido);
								
								
								boolean abandonarCombate = false;
								boolean estanVivos = true;
								boolean aplicarEfectoEnemigo = false;
								boolean aplicarEfectoUsuario = false;
							
								do{
									
									
									boolean regresar = false;

									
									// Aplicacion de efectos de habilidades lanzadas por el enemigo
								if(aplicarEfectoEnemigo == true) {
									for(int i=0;i<5;i++) {
										if(listaDuracionEnemigo.get(i)!=0) {
											if (enemigoNodo.getHabilidades().get(i).getEfecto() == TipoEfecto.ENVENENAR  ||  enemigoNodo.getHabilidades().get(i).getEfecto() == TipoEfecto.QUEMAR ) {
												personaje.setVida(personaje.getVida()-enemigoNodo.getHabilidades().get(i).getDanoEfecto());
												System.out.println(personaje.getNombre()+" recibe "+enemigoNodo.getHabilidades().get(i).getDanoEfecto()+" de dano por efecto "+enemigoNodo.getHabilidades().get(i).getEfecto().nombreEfecto().toLowerCase());

											}	
											else {
												personaje.setDefensaFisica(personaje.getDefensaFisica()-enemigoNodo.getHabilidades().get(i).getDanoEfecto());
												personaje.setDefensaMagica(personaje.getDefensaMagica()-enemigoNodo.getHabilidades().get(i).getDanoEfecto());
												System.out.println("Defensa fisica y magica de "+personaje.getNombre()+" se reduce en "+enemigoNodo.getHabilidades().get(i).getDanoEfecto()+" durante todo el combate");

												}
											}
										
										
										}// Fin ciclo
									aplicarEfectoEnemigo = false;
									
									for(int i=0;i<5;i++) {
										if(listaDuracionEnemigo.get(i) != 0) {
											listaDuracionEnemigo.set(i,listaDuracionEnemigo.get(i)-1);
										}
									}
									
									
								}
															
								if(personaje.getVida()>0) {	
									System.out.println("\n"+"Es tu turno para atacar al enemigo\n");								
									System.out.println("1: Realizar ataque basico");
									System.out.println("2: Lanzar habilidad");
									System.out.println("3: Consultar estado propio");
									System.out.println("4: Consultar estado del enemigo");
									System.out.println("5: Emplear pociones");
									System.out.println("6: Abandonar combate");
									

									System.out.print("Seleccionar la opcion: ");
									int decision = read();
									
									
									
									switch(decision) {
									
										 //Lanzar ataque basico 
									
									case 1:	
											System.out.println("\n"+personaje.lanzarAtaque(enemigoNodo));
											
											// Resta de enfriamiento de habilidades
											for(int i=0;i<5;i++) {
												if(listaEnfriamientosUsuario.get(i) != 0) {
													listaEnfriamientosUsuario.set(i,listaEnfriamientosUsuario.get(i)-1);
												}
											}
											
											aplicarEfectoUsuario = true;
											break;
										
										
										
//								
										// Lanzar habilidad	
									case 2: System.out.println("\nHabilidades disponibles\n");				
											if(personaje.getHabilidades().size()!=0) {
												for(int i=0;i<personaje.getHabilidades().size();i++) {   // Imprime nombre de las habilidades
													System.out.println(i+1+":"+personaje.getHabilidades().get(i).getNombre());
												}
											}
											
											int valorRegresar = personaje.getHabilidades().size();
											System.out.println(valorRegresar+1+":Regresar");
											
											System.out.print("Seleccionar: ");
											int elegirHabilidad = read() -1;
											
											if (elegirHabilidad == valorRegresar) {
												regresar = true;
												aplicarEfectoEnemigo = false;
												aplicarEfectoUsuario = false;
												break;
											}
											else {
											
												if(listaEnfriamientosUsuario.get(elegirHabilidad) == 0) {
													Habilidad habilidadElegida = personaje.getHabilidades().get(elegirHabilidad);
													System.out.println("\n"+personaje.lanzarHabilidad(habilidadElegida, enemigoNodo));
													
													
													if(habilidadElegida.getEfecto() != TipoEfecto.NULO) {
														listaDuracionUsuario.set(elegirHabilidad,habilidadElegida.getDuracion());
													}
													
													
													// Resta 1 a todos los elementos de la lista de enfriamientos, siempre que est√©n en enfriamiento 
													for(int i=0;i<5;i++) {
														if(listaEnfriamientosUsuario.get(i) != 0) {
															listaEnfriamientosUsuario.set(i,listaEnfriamientosUsuario.get(i)-1);
														}
													}
													
													// Pone en enfriamiento la habilidad empleada
													listaEnfriamientosUsuario.set(elegirHabilidad,habilidadElegida.getEnfriamiento());
													
													aplicarEfectoUsuario = true;
													break;
												}
												else {
													System.out.println("\n La habilidad esta en enfriamiento, debes esperar "+listaEnfriamientosUsuario.get(elegirHabilidad)+" turnos para volver a lanzarla");
													regresar = true;
													aplicarEfectoEnemigo = false;
													aplicarEfectoUsuario = false;
													break;
													}
												}// Fin case 2
											
											
									case 3: System.out.println("    Atributos del usuario    ");
											System.out.println("Vida: "+personaje.getVida());
											System.out.println("Ataque fisico: "+personaje.getAtaqueFisico());
											System.out.println("Ataque magico: "+personaje.getAtaqueMagico());
											System.out.println("Defensa fisica: "+personaje.getDefensaFisica());
											System.out.println("Defensa magica: "+personaje.getDefensaMagica());
											
											System.out.println("Efectos aplicados");
											for(int i=0;i<5;i++) {
												if(listaDuracionEnemigo.get(i) != 0 ) {
													System.out.println("Efecto "+enemigoNodo.getHabilidades().get(i).getEfecto().nombreEfecto().toLowerCase()+" aplicado por "+listaDuracionEnemigo.get(i)+" turnos");
												}
											}
											
											System.out.println(1+":Regresar");
											System.out.print("Seleccionar: ");
											int elegirVolver1 = read();
											while(elegirVolver1!=1) {
												System.out.println("Seleccionar: ");
												elegirVolver1 = read();
											}
											regresar = true;
											aplicarEfectoEnemigo = false;
											aplicarEfectoUsuario = false;
											break;
											
											
											
									case 4: System.out.println("    Atributos del enemigo    ");
											System.out.println("Vida: "+enemigoNodo.getVida());
											System.out.println("Ataque Fisico: "+enemigoNodo.getAtaqueFisico());
											System.out.println("Ataque Magico: "+enemigoNodo.getAtaqueMagico());
											System.out.println("Defensa Fisica: "+enemigoNodo.getDefensaFisica());
											System.out.println("Defensa Magica: "+enemigoNodo.getDefensaMagica());
											
											System.out.println("Efectos aplicados");
											for(int i=0;i<5;i++) {
												if(listaDuracionUsuario.get(i) != 0 ) {
													System.out.println("Efecto "+personaje.getHabilidades().get(i).getEfecto().nombreEfecto().toLowerCase()+" aplicado por "+listaDuracionUsuario.get(i)+" turnos");
												}
											}
											
											System.out.println(1+":Regresar");
											System.out.print("Seleccionar: ");
											int elegirVolver = read();
											while(elegirVolver!=1) {
												System.out.println("Seleccionar: ");
												elegirVolver = read();
											}
											regresar = true;
											aplicarEfectoEnemigo = false;
											aplicarEfectoUsuario = false;
											break;
									
											
									 case 5: System.out.println("     Pociones del usuario     ");
									 	     for(int i=0;i<personaje.getPociones().size();i++) {
									 	    	 System.out.println(i+1+":"+personaje.getPociones().get(i).getNombre()+" tiene la habilidad "+personaje.getPociones().get(i).getHabilidad().getNombre()+"\n"+personaje.getPociones().get(i).getHabilidad().toString());
									 	    	
									 	     }
									 	     System.out.println(personaje.getPociones().size()+1+":Regresar");
									 	     System.out.print("Seleccionar: ");
									 	     int elegirPocion = read();
									 	     
									 	     
									 	     //Objeto pocionElegida = personaje.getPociones().get(elegirPocion-1);
									 	     
									 	     
									 	     if(elegirPocion != personaje.getPociones().size()+1) {
									 	    	Objeto pocionElegida = personaje.getPociones().get(elegirPocion-1);
									 	    	 if(pocionElegida.getHabilidad().isAutoDirigida()) {
									 	    		 System.out.println("\n"+personaje.lanzarHabilidad(pocionElegida.getHabilidad(),personaje));
									 	    		 aplicarEfectoUsuario = true;
									 	    		 break;
									 	    	 }
									 	    	 else {
									 	    		 System.out.println("\n"+personaje.lanzarHabilidad(pocionElegida.getHabilidad(), enemigoNodo));
									 	    		 aplicarEfectoUsuario = true;
									 	    		 break;
									 	    	 	} 
									 	    	
									 	     }
									 	     else {
									 	    	  regresar = true;
									 	    	  aplicarEfectoEnemigo = false;
									 	    	  aplicarEfectoUsuario = false;
									 	    	  break; 
									 	     }
									 	     
									 
									 case 6: System.out.println("Te rindes ante el enemigo. Perderas oro y puede que alguno de tus objetos reduzca su duracion.");
									 		 
									 		if(personaje.getOro() >20) {
									 			personaje.setOro(personaje.getOro()-20);
									 			regresar = true;
									 			estanVivos = false;
									 		}
									 		else {
									 			estanVivos = false;
									 			regresar = true;
									 			personaje.setOro(0);
									 			int elegirObjeto = (int)Math.floor((Math.random()*3));
									 			if(elegirObjeto ==0) {
									 				
									 				if(personaje.getArma()!= arma01 && personaje.getArma()!= arma02 && personaje.getArma()!= arma03) {
									 					personaje.getArma().setDurabilidad(personaje.getArma().getDurabilidad()-1);
									 					System.out.println("Tu arma paga por tus pecados");
									 				
										 				if(personaje.getArma().getDurabilidad()==0) {
										 					if(personaje.getClase() == Clases.ARQUERO) {
										 						personaje.equiparArma(arma01);
										 						if(personaje.getInventario().contains(arma01)) {
										 							personaje.getInventario().remove(arma01);
										 							}
										 						}
										 					}
										 					else if(personaje.getClase() == Clases.GUERRERO) {
										 						personaje.equiparArma(arma02);
										 						if(personaje.getInventario().contains(arma02)) {
										 							personaje.getInventario().remove(arma02);
										 							}
										 						
										 					}
										 					else {
										 							personaje.equiparArma(arma03);
										 							if(personaje.getInventario().contains(arma03)) {
											 							personaje.getInventario().remove(arma03);
											 							}
										 					}
										 				}
									 			}
									 			else if(elegirObjeto == 1) {
									 				if(personaje.getArmadura()!=armadura0) {
										 				personaje.getArmadura().setDurabilidad(personaje.getArmadura().getDurabilidad()-1);
										 				System.out.println("Tu armadura paga por tus pecados");
										 				
										 				if(personaje.getArmadura().getDurabilidad()==0) {
										 					personaje.equiparArmadura(armadura0);
										 					if(personaje.getInventario().contains(armadura0)) {
								 							personaje.getInventario().remove(armadura0);
								 							}
										 				}
									 				}
									 			}	
									 			else{
									 				if(personaje.getAnillo() != anillo0) {
									 				personaje.getAnillo().setDurabilidad(personaje.getAnillo().getDurabilidad()-1);
									 				System.out.println("Tu anillo paga por tus pecados");
									 				
									 				if(personaje.getAnillo().getDurabilidad()==0) {
									 					personaje.equiparAnillo(anillo0);
									 					if(personaje.getInventario().contains(anillo0)) {
									 						personaje.getInventario().remove(anillo0);
							 								}
									 					}
									 				}
									 			}
									 			
									 		}
									 		
									 		
											
									}	// Fin switch combate
								}
								else {
									 System.out.println("\nHas muerto\n");
									 regresar = true;
									 if(personaje.getEnemigosDerrotados().size()>0) {
											System.out.println("\nEl dios Cancer se ha enfurecido por tu derrota");
											System.out.println("Como castigo se reduce tu contador de enemigos asesinados");
											personaje.getEnemigosDerrotados().remove(0);
											}
											else{
												System.out.println("\nEl dios Capricornio se ha enfurecido por tu derrota.");
												System.out.println("Como castigo pierdes permanentemente 10 de vida");
												estadoInicialUsuario.set(0,estadoInicialUsuario.get(0)-10);
												
											}
									 
								} //Fin switch combate 
								
 
								// Si el jugador derrota al enemigo lo agrega a la lista de enemigosDerrotados 
									
								if(regresar == false) {	
									if(enemigoNodo.getVida()<= 0){
										personaje.getEnemigosDerrotados().add(enemigoNodo);
										boolean verificador = false;
										
											for(Peleador enemigo : Nodo.getNodos().get(eleccionNodo).getEnemigos()) {
												if(personaje.getEnemigosDerrotados().contains(enemigo)) {
													verificador = true;
												}
												else {
													verificador = false;
													break;
												}
											}	
											
											if(verificador == true) {
												
											// Elige aleatoriamente un nodo conectado y lo abre
													Collections.shuffle(nodoElegido.getConexiones());
													
												if(nodoElegido.getConexiones().size()>0) {	
													if(nodoElegido.getConexiones().get(0).isAbierto() == false) {
														nodoElegido.getConexiones().get(0).setAbierto(true);
														System.out.println("\nEl dios sagitario ha abierto el camino hacia el nodo "+nodoElegido.getConexiones().get(0).getNombre());
														System.out.println("Puedes acceder a el desde el camino de los doce");
														}
													 		
													
												}
											}
											
											
											regresar = true;
											Objeto premio = nodoElegido.elegirTesoro();
											if(premio.getTipo() == TipoDeObjeto.MATERIAL) {
												personaje.getMateriales().add(premio);
											}
											else {
												personaje.getInventario().add(premio);
											}
											System.out.println("\nFelicidades has obtenido el objeto "+premio.getNombre());
											System.out.println("Continua derrotando enemigos para completar tu mision");
										}
									}	
									 
								
									if(enemigoNodo.getVida()>0) {		
										if(aplicarEfectoUsuario == true) {	
											for(int i=0;i<5;i++) {
												if(listaDuracionUsuario.get(i)!=0) {
													if (personaje.getHabilidades().get(i).getEfecto() == TipoEfecto.ENVENENAR  ||  personaje.getHabilidades().get(i).getEfecto() == TipoEfecto.QUEMAR ) {
														enemigoNodo.setVida(enemigoNodo.getVida()-personaje.getHabilidades().get(i).getDanoEfecto());
														System.out.println(enemigoNodo.getNombre()+" recibe "+personaje.getHabilidades().get(i).getDanoEfecto()+" de dano por efecto "+personaje.getHabilidades().get(i).getEfecto().nombreEfecto().toLowerCase());
													}
													else {
														enemigoNodo.setDefensaFisica(enemigoNodo.getDefensaFisica()-personaje.getHabilidades().get(i).getDanoEfecto());
														enemigoNodo.setDefensaMagica(enemigoNodo.getDefensaMagica()-personaje.getHabilidades().get(i).getDanoEfecto());
														System.out.println("Defensa fisica y magica de "+enemigoNodo.getNombre()+" se reduce en "+personaje.getHabilidades().get(i).getDanoEfecto()+" durante todo el combate");
													}
												}
//												
											}// Fin ciclo
											for(int i=0;i<5;i++) {
												if(listaDuracionUsuario.get(i) != 0) {
													listaDuracionUsuario.set(i,listaDuracionUsuario.get(i)-1);
												}
											}
											
										}
										if(enemigoNodo.getVida()<=0) {
											regresar = false;
											Objeto premio = nodoElegido.elegirTesoro();
											personaje.getInventario().add(premio);
											System.out.println("Felicidades has obtenido el objeto "+premio.getNombre());
											System.out.println("Continua derrotando enemigos para completar tu mision");
										}
										
									}
								
								
					
									if (regresar == false) {
										System.out.println("\nTurno del enemigo\n");
										
						
										double decisionEnemigo = Math.random();
										
										
										if (decisionEnemigo >=0.6) {
											System.out.println(enemigoNodo.lanzarAtaque(personaje));
											
											
											for(int i=0;i<5;i++) {
												if(listaEnfriamientosEnemigo.get(i) != 0) {
													listaEnfriamientosEnemigo.set(i,listaEnfriamientosEnemigo.get(i)-1);
												}
											}
											
											 }
										else {
											// El enemigo lanza una habilidad aleatoria,
											int habilidadAleatoria = (int)Math.floor((Math.random()*5)); // Elige un entero entre 0 y 4
											if(listaEnfriamientosEnemigo.get(habilidadAleatoria) == 0) {
												Habilidad habilidadElegida = enemigoNodo.getHabilidades().get(habilidadAleatoria);
												System.out.println("\n"+enemigoNodo.lanzarHabilidad(habilidadElegida, personaje));
												
												
												if(habilidadElegida.getEfecto() != TipoEfecto.NULO) {
													listaDuracionEnemigo.set(habilidadAleatoria,habilidadElegida.getDuracion());
												}
												
												
												// Resta 1 a todos los elementos de la lista de enfriamientos, siempre que est√©n en enfriamiento 
												for(int i=0;i<5;i++) {
													if(listaEnfriamientosEnemigo.get(i) != 0) {
														listaEnfriamientosEnemigo.set(i,listaEnfriamientosEnemigo.get(i)-1);
													}
												}
												
												// Pone en enfriamiento la habilidad empleada
                        
												listaEnfriamientosEnemigo.set(habilidadAleatoria,habilidadElegida.getEnfriamiento());
												
												for(int i=0;i<5;i++) {
													if(listaEnfriamientosEnemigo.get(i) != 0 && enemigoNodo.getHabilidades().get(i).getEfecto() != TipoEfecto.NULO ) {
														aplicarEfectoEnemigo = true;
														break;
														}
													}

												
											}
											// En caso de que la habilidad est√© en enfriamiento, busca si hay alguna habilidad disponible y elige la primera que aparezca
											else if(listaEnfriamientosEnemigo.contains(0)){
												habilidadAleatoria = listaEnfriamientosEnemigo.indexOf(0);
												Habilidad habilidadElegida = enemigoNodo.getHabilidades().get(habilidadAleatoria);
												System.out.println("\n"+enemigoNodo.lanzarHabilidad(habilidadElegida, personaje));
												
												if(habilidadElegida.getEfecto() != TipoEfecto.NULO) {
													listaDuracionEnemigo.set(habilidadAleatoria,habilidadElegida.getDuracion());
												}

												
												// Resta 1 a todos los elementos de la lista de enfriamientos, siempre que est√©n en enfriamiento 
												for(int i=0;i<5;i++) {
													if(listaEnfriamientosEnemigo.get(i) != 0) {
														listaEnfriamientosEnemigo.set(i,listaEnfriamientosEnemigo.get(i)-1);
													}
												}
												
												// Pone en enfriamiento la habilidad empleada

												listaEnfriamientosEnemigo.set(habilidadAleatoria,habilidadElegida.getEnfriamiento());	
												
												for(int i=0;i<5;i++) {
													if(listaEnfriamientosEnemigo.get(i) != 0 && enemigoNodo.getHabilidades().get(i).getEfecto() != TipoEfecto.NULO ) {
														aplicarEfectoEnemigo = true;
														break;
														}
													}
							
												
											} // Si no hay habilidades disponibles resta el enfriamiento de todas en -1 y activa el ataque b√°sico 
											else {
												
												for(int i=0;i<5;i++) {
													listaEnfriamientosEnemigo.set(i,listaEnfriamientosEnemigo.get(i)-1);
													}
												
												System.out.println(enemigoNodo.lanzarAtaque(personaje));
												
												for(int i=0;i<5;i++) {
													if(listaEnfriamientosEnemigo.get(i) != 0 && enemigoNodo.getHabilidades().get(i).getEfecto() != TipoEfecto.NULO ) {
														aplicarEfectoEnemigo = true;
														break;
														}
													}
												
												}
											
											 
											}
										
										
										if(personaje.getVida()<0) {
											System.out.println("\nHas muerto\n");
											if(personaje.getEnemigosDerrotados().size()>0) {
											System.out.println("El dios Cancer se ha enfurecido por tu derrota");
											System.out.println("Como castigo se reduce tu contador de enemigos asesinados");
											personaje.getEnemigosDerrotados().remove(0);
											}
											else{
												System.out.println("El dios Capricornio se ha enfurecido por tu derrota.");
												System.out.println("Como castigo pierdes permanentemente 10 de vida");
												estadoInicialUsuario.set(0, estadoInicialUsuario.get(0)-10);
												
											}
										}
										
										
										
									} // Fin turno enemigo
									
									if (personaje.getVida() <= 0 || enemigoNodo.getVida() <= 0) {
										estanVivos = false;
									}
									
									// Recuperaci√≥n de atributos iniciales
									if(estanVivos == false) {
									personaje.setVida(estadoInicialUsuario.get(0));
									personaje.setAtaqueFisico(estadoInicialUsuario.get(1));
									personaje.setAtaqueMagico(estadoInicialUsuario.get(2));
									personaje.setDefensaFisica(estadoInicialUsuario.get(3));
									personaje.setDefensaMagica(estadoInicialUsuario.get(4));
									
									enemigoNodo.setVida(estadoInicialEnemigo.get(0));
									enemigoNodo.setAtaqueFisico(estadoInicialEnemigo.get(1));
									enemigoNodo.setAtaqueMagico(estadoInicialEnemigo.get(2));
									enemigoNodo.setDefensaFisica(estadoInicialEnemigo.get(3));
									enemigoNodo.setDefensaMagica(estadoInicialEnemigo.get(4));
								
									}

										
								}while(estanVivos == true);
								
							}
							else {
								verificadorNodo = false;
								System.out.println("\n"+"Aun no puedes ingresar a este nodo, completa otros nodos para desbloquearlo.\n");
							}
						}while(verificadorNodo == false);
					break; // Regresa al menu principal
						
						
				//Consultar estadisticas del personaje
				case 2: 
							int decision = 0;
							do{
								System.out.println(personaje);
								System.out.println("\n"+ 0+": Volver al menu principal");
								
								
								System.out.print("\nSeleccionar la opcion: ");
								decision = (int) read();
								
								if(decision == 0) {
									decision = 1;
								}
								
							}while(decision != 1);
				break;
				
				//Consultar inventario
				case 3: 
							decision = 0; 
							do{
								System.out.println("\n" + 1+": Ver los objetos equipados");
								System.out.println(2+": Ver objetos en el inventario");
								System.out.println(3+": Volver al menu principal");
 
								System.out.print("\nSeleccione una opcion: ");
								decision =  read();
                
								switch(decision) {
									//Objetos equipados
									case 1:  
										decision = 0; 
										do{
											System.out.println("\nEstos son los objetos que tienes equipados:"
													+ "\n(Nombre: AtaqueFisico, AtaqueMagico, DefensaFisica, DefensaMagica, Durabilidad)\n");
											System.out.println(personaje.getArma());
											System.out.println(personaje.getArmadura());
											System.out.println(personaje.getAnillo());
											System.out.println("\n"+0+ ": Volver al menu anterior.");
											System.out.print("\nSeleccione una opcion: ");
											decision = read();
												
											if(decision == 0) {
												decision = 2;
											}
											
										}while(decision != 2);
										break;
									
									//Objetos no equipados (en inventario)
									case 2: 																				
										decision = 2; 
										do{
											System.out.println("\nEstos son los objetos disponibles que tienes en tu inventario:"
													+ "\n(Nombre: AtaqueFisico, AtaqueMagico, DefensaFisica, DefensaMagica, Durabilidad)\n");
											for (int i=0; i<personaje.getInventario().size(); i++) {
												if (personaje.getInventario().get(i).getDurabilidad() > 0) {
													System.out.println(i+1 + " " + personaje.getInventario().get(i));
												}
											}
											System.out.print("\nIngrese el numero del elemento que quiere equipar o ingrese 0 para regresar: ");
											decision = read();
											
											if (decision != 0) {
												if (personaje.getInventario().get(decision-1).getTipo() == TipoDeObjeto.ESPADA ||
														personaje.getInventario().get(decision-1).getTipo() == TipoDeObjeto.LANZA ||
														personaje.getInventario().get(decision-1).getTipo() == TipoDeObjeto.ARCO ||
														personaje.getInventario().get(decision-1).getTipo() == TipoDeObjeto.BALLESTA ||
														personaje.getInventario().get(decision-1).getTipo() == TipoDeObjeto.VARITA ||
														personaje.getInventario().get(decision-1).getTipo() == TipoDeObjeto.BASTON) {
														personaje.equiparArma(personaje.getInventario().get(decision-1));
													
													
												}
												else if (personaje.getInventario().get(decision-1).getTipo() == TipoDeObjeto.ANILLO ) {
													personaje.equiparAnillo(personaje.getInventario().get(decision-1));
													
													
												}
												else {  
													personaje.equiparArmadura(personaje.getInventario().get(decision-1));
													
													
												}
												
												
												System.out.println("\nEstos son tus objetos actuales despues de equipar "+personaje.getInventario().get(decision-1).getNombre() +":"
														+ "\n(Nombre: AtaqueFisico, AtaqueMagico, DefensaFisica, DefensaMagica, Durabilidad)\n");
												System.out.println(personaje.getArma());
												System.out.println(personaje.getArmadura());
												System.out.println(personaje.getAnillo());
												
												decision = 0;
											}
													
										}while(decision != 0);
										break;
									//Volver al men√∫ principal
									case 3: decision = 1;
									break;
								}	
							}while(decision != 1);
				break;
				
				//SAbio
				case 4: 
					decision = 1; 
					do{
					
						System.out.println("\nBienvenido al santuario, aqui podras aceptar misiones para conseguir fragmentos,"
									+ "\nestos son necesarios para invocar a los Totems, espiritus guias que te acompanaran en todo el recorrido."+
									"\nTambien te puedo ensenar habilidades que te ayudaran en la batalla o mejoraran tus estadisticas\n"+
									"øQue deseas hacer?");
						
						System.out.println("\n" +1+ ": Recibir mision.");
						System.out.println(2+ ": Aprender habilidades.");
						System.out.println(3+ ": Recoger recompensa.");
						System.out.println(4+ ": Ver Totems.");
						System.out.println(5+": Hablar con los dioses"); 
						System.out.println(6+ ": Volver al menu anterior.");
						
						
						System.out.print("\nSeleccionar la opcion: ");
						decision = read();
						
						switch (decision) {
							
							//Recibir misiones
							case 1: 
								decision = 0; 
								do{
								
									System.out.println("\nPuedes hacer misiones de busqueda o derrotar enemigos especificos. "
											+ "\nComo recompensa te dare dos fragmentos\n");
									System.out.println(1+ ": Mision de busqueda.");
									System.out.println(2+ ": Mision de lucha.");
									System.out.println(3+ ": Volver al menu anterior.");
									
									System.out.print("\nSeleccionar la opcion: ");
									decision = (int) read();
									
									switch (decision) {
										case 1:
											decision = 0;
											do {
												System.out.println("\nEste es el objeto que debes conseguir: ");
												Objeto objetoMision = misionBusqueda.get((int) Math.floor(Math.random()*(misionBusqueda.size())));

												boolean verificador = false;
												do{
													if (sabio.getObjetos().contains(objetoMision)) {
														objetoMision = misionBusqueda.get((int) Math.floor(Math.random()*(misionBusqueda.size())));
													}else {verificador = true;}
													
												}while(verificador != true);
												
												System.out.println("-" + objetoMision.getNombre() + "\n" +
														"\nPuedes encontrarlo en un tesoro, regresa cuando lo tengas y reclama tu recompensa.\n");
							
												
												System.out.println(1+ ": Aceptar.");
												System.out.println(2+ ": Rechazar.");
												
												System.out.print("\nSeleccionar la opcion: ");
												decision = (int) read();
												
												if (decision == 1) {
													sabio.asignarMision(objetoMision);
													System.out.println("\nMision Aceptada, Encontar: " + objetoMision.getNombre());
													decision = 2;
												}								
												
												
											}while (decision != 2 );
											break;
											
										case 2:
											decision = 0;
											do {
												
												Peleador enemigoMision = misionCombate.get((int) Math.floor(Math.random()*(misionCombate.size())));
												
												boolean verificador = false;
												do{
													if (sabio.getOponentes().contains(enemigoMision)) {
														enemigoMision = misionCombate.get((int) Math.floor(Math.random()*(misionCombate.size())));
													}else {verificador = true;}
													
												}while(verificador != true);
												
												System.out.println("\nEste es el oponente que debes derrotar: " + enemigoMision.getNombre() +
														"\nPodras luchar con el a lo largo de tu recorrido, cuando lo derrotes, ven y cobra tu recompensa.\n");
												
												System.out.println(1+ ": Aceptar.");
												System.out.println(2+ ": Rechazar.");
												
												System.out.print("\nSeleccionar la opcion: ");
												decision = read();
												
												if (decision == 1) {
													sabio.asignarMision(enemigoMision);
													System.out.println("\nMision Aceptada, Derrotar a " + enemigoMision.getNombre());
													decision = 2;
												}								
												
												
											}while (decision != 2 );
											break;
											
										case 3: break;
									}
									
								}while(decision != 3); 
								break;
							
							//Aprender Habilidades del sabio
							case 2: 
								decision = 1; 
								
								do{
								
									System.out.println("\nEstas son las habilidades que te puedo ensenar: ");
									
									for (int i=0; i<sabio.getHabilidades().size(); i++) {
										if (!personaje.getHabilidades().contains(sabio.getHabilidades().get(i))){
											System.out.println(i+1 +"- " + sabio.getHabilidades().get(i).toString());
										}
									}
									
									System.out.print("\nSelecciona la habilidad que quieres aprender o ingresa 0 para regresar: ");
									int decision1 =  read();
									
									if (decision1 ==0) {
										decision=0;
									}else {
										if (personaje.getHabilidades().size() ==5) {
											System.out.println("\nSolo puedes tener 5 habilidades equipadas, escoge una para cambiarla por la aprendida."+
														"\nEstas son tus habilidades actuales: \n");
											for (int i=0; i<5; i++) {
												System.out.println(i+1 +"- " + personaje.getHabilidades().get(i).toString());
											}
											
											System.out.print("\nSelecciona la habilidad que quieres reemplazar por "+ sabio.getHabilidades().get(decision1-1).getNombre()+ " o ingresa 0 para regresar: ");
											decision =  read();
											
											if (decision != 0) {
												personaje.cambiarHabilidad(decision-1, sabio.getHabilidades().get(decision1-1));
												
												System.out.println("\nEstas son tus habilidades actuales: \n");
												for (int i=0; i<personaje.getHabilidades().size(); i++) {
													System.out.println(i+1 +"- " + personaje.getHabilidades().get(i).toString());
												}
												System.out.println("\n øDeseas aprender otra habilidad? \n");

											}
										}else {
											System.out.println(personaje.aprenderHabilidad(sabio, sabio.getHabilidades().get(decision1-1)));
											System.out.println("\nEstas son tus habilidades actuales: \n");
											for (int i=0; i<personaje.getHabilidades().size(); i++) {
												System.out.println(i+1 +"- " + personaje.getHabilidades().get(i).toString());

											}
											
											System.out.println("\n øDeseas aprender otra habilidad? \n");

										}
									}
									
									
								}while(decision != 0); 
								break;
							
							//Reclamar recompensas
							case 3:	
								decision = 0;
								do {
									if (sabio.getMisionesB()==0 && sabio.getMisionesL() == 0) {
										System.out.println("\nNo tienes misiones activas");
										decision = 3;
										break;
									}
									System.out.println("Tienes al menos una mision activa. øQue deseas hacer?");									
									System.out.println("\n" + 1 +": Entregar objeto y reclamar recompensa.");									
									System.out.println(2 +": Reclamar recompensa por combate.");									
									System.out.println(3 + ": Regresar");
									
									System.out.print("\nSeleccionar la opcion: ");
									decision =  read();
									
									switch (decision) {
										case 1:
											if (sabio.getMisionesB() > 0 ) {
												System.out.println("\nEstos son los objetos que deberas buscar: ");											
											
												for (int i = 0; i < sabio.getObjetos().size(); i++) {
													System.out.println("-"+ sabio.getObjetos().get(i).getNombre());
												}
												System.out.println("\nHas recibido " +sabio.calificarMisionBusqueda(personaje)+ " fragmentos");
												decision = 3;
												break;
											}else {
												System.out.println("\nNo tienes misiones de busqueda activas. \n");
												break;
											}

											
											
										case 2:
											if (sabio.getMisionesL() > 0 ) {
												System.out.println("\nEstos son los enemigos que deberas derrotar: ");
												
												for (int i = 0; i < sabio.getOponentes().size(); i++) {
													System.out.println("-"+ sabio.getOponentes().get(i).getNombre());
												}
												
												System.out.println("\nHas recibido " +sabio.calificarMisionCombate(personaje)+ " fragmentos");
												
												decision = 3;
												break;
											}else {
												System.out.println("\nNo tienes misiones de combate activas. \n");
												break;
											}
											
										case 3: break;
	
									}
									
									
								}while (decision != 3);
								break;
							
							//Ver totem
							case 4: 
								
								decision = 0;
								do {
									
									if (personaje.getTotem() == null) {
										
											
											System.out.println("\nBienvenido al mundo espiritual este es el hogar de los descendientes de los espiritus guardianes, \n"
												+ "los Totems, aqui podras interactuar con ellos una vez sean invocados por el sabio; te  otorgaran compaÒia \n"
												+ "y cuando lo decidas entregaran su vida para convertirse en un objeto sagrado de uso unico que podras equipar \n"
												+ "en cualquier momento. \n"
												+ "\nPor el momento no te acompaÒa ningun Totem, vuelve cuando hayas conseguido uno, puedes hacerlo recibiendo \n"
												+ "misiones de busqueda o combate que te otorgar·n los fragmentos necesarios para invocarlos. \n"
												+ "\nøDeseas invocar un Totem?");
											
											System.out.println("1: Invocar.");
											System.out.println("2: Regresar.");
										
											System.out.print("\nSeleccionar la opcion: ");
											decision = (int) read();
											
											switch (decision) {
												case 1: 
													if (personaje.getFragmentos() < 4) {
														System.out.println(sabio.invocarTotems(personaje, sabio.getTotems().get((int) Math.floor(Math.random()*(sabio.getTotems().size())))));
														decision = 3;
													}else {
														System.out.println(sabio.invocarTotems(personaje, sabio.getTotems().get((int) Math.floor(Math.random()*(sabio.getTotems().size())))));
														break;
													}
													
													
												case 2:
													decision = 3;
													break;

											}
											
									}else {
										System.out.println("\nBienvenido al mundo espiritual este es el hogar de los descendientes de los espiritus guardianes, \n"
												+ "los Totems, aqui podras interactuar con ellos una vez sean invocados por el sabio; te  otorgaran compaÒia \n"
												+ "y cuando lo decidas entregaran su vida para convertirse en un objeto sagrado de uso unico que podras equipar \n"
												+ "en cualquier momento. \n"
												+ "øQue deseas hacer?");
										
										System.out.println("\n1: Pedir Apoyo.");
										System.out.println("2: Solicitar el objeto sagrado.");
										System.out.println("3: Volver al menu anterior.");
										
										System.out.print("\nSeleccionar la opcion: ");
										decision =  read();
										
										switch (decision) {
											
											//Solicitar apoyo
											case 1:
												decision =0;
												do {
																								
													System.out.println("\nSolo puedes usarlo una vez, el Totem usar· su habilidad especial sobre ti.\n"
															+ "øQuieres utilizarla?\n");
													
													System.out.println("1: Aceptar.");
													System.out.println("2: Cancelar.");
													
													System.out.print("\nSelecciona una opciÛn: ");
													decision = (int) read();
													
													if (decision ==1) {
														System.out.println( personaje.getTotem().apoyar(personaje));
														decision = 2;
													}
													
												}while(decision != 2);
												break;
											
											//Objeto sagrado
											case 2:
												decision =0;
												do {
																								
													System.out.println("\nSolo puedes usarlo una vez, el Totem se convertir· en un objeto sagrado.\n"
															+ "A cambio se te quitar·n las ayudas que te brindÛ anteriormente y el Totem se desvanecer·."
															+ "\nøQuieres utilizarla?\n");
													
													System.out.println("1: Aceptar.");
													System.out.println("2: Cancelar.");
													
													System.out.print("\nSelecciona una opciÛn: ");
													decision = (int) read();
													
													if (decision ==1) {
														System.out.println(personaje.getTotem().donarObjeto(personaje));
														decision = 2;
													}
													
												}while(decision != 2);
												break;
											
											case 3: break;
										}
										
									}
								}while(decision != 3);
								break;
						
						case 5: 
							decision =0;
							if (personaje.getInventario().contains(material9)) {
								do{
									System.out.println("\nAquÌ podr·s ponerte en contacto con los dioses, solo uno de ellos se comunicar· contigo.\n"
										+ "Ten cuidado, si te ofrecen obsequios no siempre ser·n de ayuda, tambiÈn te pueden perjudicar,"
										+ "algunos dioses desprecian a los humanos, tu decides.\n");
									
									System.out.println("øDeseas continuar?");
									System.out.println("1: Continuar");
									System.out.println("2: Regresar");

									
									System.out.print("\nSelecciona una opciÛn: ");
									decision = (int) read();
									
									if (decision == 1) {
										decision = 0;
										Dios dios = dioses.get((int) Math.floor(Math.random()*(dioses.size())));
										Habilidad habilidad = dios.getHabilidades().get((int) Math.floor(Math.random()*(dios.getHabilidades().size())));
										System.out.println("Soy " + dios.getNombre() + ", vine desde el Olimpo a ofrecerte mi ayuda, ødeseas aceptarla?");
										System.out.println("\n1: Aceptar");
										System.out.println("2: Rechazar");
										
										System.out.print("\nSelecciona una opciÛn: ");
										decision = (int) read();
										
										if(decision ==1) {
											System.out.println(dios.getNombre() + " Te ha otorgado " + habilidad.toString());
											System.out.println( personaje.aprenderHabilidad(dios, habilidad));
										}
										

									}
									
								}while(decision != 2);
							}else {System.out.println("No puedes comunicarte con los dioses hasta que tengas al menos una " + material9.getNombre());}
							
							
						case 6:	break;
						} 
					
					
					}while(decision != 6); // Fin case 4(Sabio)
					break;
					
					
				
				case 5: boolean verificadorHerrero = false;	
						
					do {
						
						System.out.println("\nHola, me llamo Pacho y soy el herrero predilecto de los dioses.\nEstos son los servicios que puedo ofrecerte por un modico precio\n");
						System.out.println(1+": Comprar objetos");
						System.out.println(2+": Vender objetos");
						System.out.println(3+": Reparar objetos");
						System.out.println(4+": Evolucionar objetos");
						System.out.println(5+": Regresar");
						
						System.out.print("Seleccionar: ");
						int tomarDecision = read();
						
						switch(tomarDecision) {
						
						
						case 1: 
							System.out.println("\n\n Por el momento te puedo ofrecer estos objetos\n");
							System.out.println("  Nombre: "+"Precio: \n");
							
							System.out.println(0+". Regresar");
							
							for(int i=0;i<pacho.getObjetos().size();i++) {
								System.out.println(i+1+". "+(pacho.getObjetos().get(i).getNombre()+": "+pacho.getObjetos().get(i).getPrecio()));
							}
							
							
							System.out.print("Seleccionar: ");
							int elegirCompra = read();
							
							if(elegirCompra == 0) {
								break;
							}
							else{
								if(personaje.getOro() >= pacho.agregarImpuesto(pacho.getObjetos().get(elegirCompra-1))) {
									System.out.println(pacho.vender(personaje, pacho.getObjetos().get(elegirCompra-1)));
									break;
								}
								else{
									System.out.println("Lo siento, no tienes suficiente oro para pagar por este objeto");
									break;
								}
							}
							
						
						case 2: 
								System.out.println("Esto es lo que te ofrece Pacho por tus objetos ");
								
								System.out.println(0+": Regresar");
								if(personaje.getInventario().size()>0) {	
										for(int i=0;i<personaje.getInventario().size();i++) {
											System.out.println(i+1+". "+personaje.getInventario().get(i).getNombre()+": "+pacho.retirarImpuesto(personaje.getInventario().get(i)));
										}
										
								}
								else {
									System.out.println("\nNo tienes objeto para ofrecer");
									break;
								}
							
								System.out.print("Seleccionar: ");
								int objetoVenta = read();
								
								if(objetoVenta == 0) {
									break;
								}
								else{
									System.out.println(pacho.comprar(personaje, personaje.getInventario().get(objetoVenta-1)));
									break;
						}
								
								
						case 3:  
							System.out.println("Selecciona el objeto que deseas reparar");
							System.out.println(0+": Regresar");
							if(personaje.getInventario().size()>0) {	
								for(int i=0;i<personaje.getInventario().size();i++) {
									if(personaje.getInventario().get(i).getDurabilidad()<5) {
										if(objetosNulos.contains(personaje.getInventario().get(i))) {
											break;
											
										}
										else{
											System.out.println(i+1+": "+personaje.getInventario().get(i).getNombre());
										}
									}
									
								}
							}
							
							System.out.println("Seleccionar: ");
							int decidirObjeto = read();
							
							if(decidirObjeto !=0) {
									int precioReparacion = (int) (10 + Math.floor((personaje.getInventario().get(decidirObjeto-1).getPrecio()/3)));
									System.out.println("Reparar este objeto te cuesta: "+ precioReparacion +" de oro");
									
									
									System.out.print("øDeseas repararlo?: ");
									System.out.println(1+": SÌ");
									System.out.println(2+": No");
									
									int eleccionFinal = read();
									
									if(eleccionFinal == 0) {
										break;
									}
									else{
										if(personaje.getOro() >= precioReparacion ) {
											System.out.println(pacho.reparar(personaje,decidirObjeto-1));
											
										}
										else{
											System.out.println("Lo siento, no tienes suficiente oro para reparar el objeto");
										}
									}
									
							}
							else{
								break;
							}
						
						case 4:	System.out.println("Recuerda que primero debes desequiparte el objeto para evolucionarlo\n");
						
								ArrayList<Objeto> evolucionables = new ArrayList<Objeto>();
								
								for(int i=0;i<personaje.getInventario().size();i++) {
									if(personaje.getInventario().get(i).isEvoluciona()){
										evolucionables.add(personaje.getInventario().get(i));
										
									}
								}
								
								
								
								if(evolucionables.size() >0) {
									System.out.println("Estos son los objetos que tienes para evolucionar");
									for (int i=0;i<evolucionables.size();i++) {
										System.out.println(i+1+": "+evolucionables.get(i).getNombre());
										
									}
									System.out.println(evolucionables.size()+1+": Regresar");
									System.out.print("Seleccionar: ");
									int elegirEvolucion = read();
									
									if(elegirEvolucion != evolucionables.size()+1) {
										System.out.println("Este objeto evoluciona a "+evolucionables.get(elegirEvolucion-1).getEvolucion().getNombre());
										System.out.println("\nNecesitas los siguientes materiales para evolucionarlo");
										for(Objeto objeto : evolucionables.get(elegirEvolucion-1).getMaterialesEvolucion()) {
											System.out.println(objeto.getNombre());
										}
										
										System.out.println("Es posible que el proceso de evolucion falle y pierdas el objeto");
										
										System.out.println("øDeseas evolucionar el objeto?");
										System.out.println("1: SÌ");
										System.out.println("2: No");
										System.out.print("Seleccionar: ");
										int evolucionar = read();
										
										if(evolucionar == 1) {
											boolean puedeEvolucionar = false;
											
											for(Objeto material: evolucionables.get(elegirEvolucion-1).getMaterialesEvolucion()) {
												if(personaje.getMateriales().contains(material)){
													puedeEvolucionar = true;
													
												}
												else {
													puedeEvolucionar = false;
													System.out.println("No cuentas con los materiales suficientes para evolucionar el objeto");
													break;
													
												}
											}
											
											if(puedeEvolucionar) {
												System.out.println("Voy a iniciar la evolucion, enfoca tus oraciones al dios virgo para que el proceso sea exitoso");
												System.out.println(pacho.evolucionar(personaje,evolucionables.get(elegirEvolucion-1)));
												break;
											}
											
										}
										else {
											break;
										}
										
									}
									else {
										break;	
									}
									
									
									
								}
								else{
									System.out.println("No tienes objetos que evolucionen");
									break;
								}// Fin case Evolucion
								
							
						case 5: verificadorHerrero = true;
						
							}// Fin switch Herrero
						
							
				}while(verificadorHerrero == false); // Fin case 5 global (Herrero)
				break; 
					
				case 6: salirJuego(personaje,Nodo.getNodos());
						
					
			}

		}while (opcion!=6);  // Do-while global
	}
	
	public static void salirJuego(Peleador personaje,ArrayList<Nodo> nodos) {
		System.out.println("Esperamos que hayas disfrutado del juego, nos vemos en otra ocasion");
		Serializador.serializar(personaje);
		Serializador.serializarNodos(nodos);
		System.exit(0);
	}
}