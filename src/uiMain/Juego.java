package uiMain;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import artefactos.Objeto;
import artefactos.Tesoro;
import baseDatos.Deserializador;
import complementario.Clases;
import complementario.Habilidad;
import complementario.Nodo;
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
				
				ArrayList<Objeto> misionBusqueda = new ArrayList<Objeto>();  //lista de ensayo para las misiones de bÃºsqueda.
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

					
					//ValidaciÃ³n del nombre
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
					conexionesNodo1.add(nodo3);
					nodo1.setConexiones(conexionesNodo1);
					
					// Conexiones desde el nodo 2
					ArrayList<Nodo> conexionesNodo2 = new ArrayList<Nodo>();
					conexionesNodo2.add(nodo3);
					nodo2.setConexiones(conexionesNodo2);
					
								
					// Añadir enemigos a los nodos
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
					
					
					
				}
				

				
				
				System.out.println("Los dioses te han teletransportado al camino de los doce, un lugar magico");
				System.out.println("donde podras acceder a diversos lugares para completar tu mision.\n");

	}

}
