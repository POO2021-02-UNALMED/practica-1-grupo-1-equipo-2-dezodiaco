'''
Se guardan las constantes como mensajes y valores del juego

autor: Edwin
'''


from tkinter import *
from tkinter import messagebox

Andres = ("Yeferson Andres Velazco Galvis.\n" + 
            "Estudiante de estadística en la UNAL - Medellín,\n"+
            "nació el 5 de junio de 2003, cursa actualmente \n"+
            "cuarto semestre, Técnico en Servicios y \n"+
            "operaciones Microfinancieras, amante de la \n"+
            "economía, la musica y los idiomas. ")

Camilo = ("Camilo Montoya Arango.\n" + 
            "Estudiante de Ciencias de la Computación en la \n" +
            "UNAL - Medellín, cursa actualmente cuarto semestre,\n"+
            "Amante a los videojuegos, el tenis de mesa y la\n"+
            "teoría de grafos.")

Edwin = ("Edwin R. Jiménez Gómez.\n"+
            "Estudiante de Ingeniería de Sistemas e Informática\n"+
            "en la UNAL - Medellín, actualmente me encuentro \n"+
            "cursando el 6 semestre. Mi pasión es el deporte,\n"+
            "me considero una persona descomplicada, sociable,\n"+
            "luchadora. Tengo buenos principos y valores los\n"+
            "cuales trato de aplicar en todo lo que me propongo.")

Bienvenida=("                            ¡¡¡ Bienvenido !!!                \n"+
			"Los dioses del zodiaco te han encomendado la tarea \n"+
            "de derrotar al Asediador de almas, Un ser oscuro \n"+
            "inmune al poder sagrado que busca dominar al mundo \n"+ 
			"estableciendo un letal ejercito de almas perdidas que \n"+
            "ha ido recolectando a lo largo de milenios. Solo los \n"+
            "humanos pueden detener su progreso, pues estos son \n"+
            "hijos de la luz y la oscuridad.")

TextoTotem = ("Bienvenido al bosque sagrado, hogar de los espíritus guardianes, aquí\n"+
            "podras interactuar con tu Totem, ten en cuenta que puedes solicitarle \n"+
            "apoyo cuando lo necesites, te ofrecerá por única vez su habilidad\n"+
            "especial o puedes pedirle que te entregue a cambio de su propia\n"+
            "existencia un objeto sagrado que podrás utilizar en batalla, pero no \n"+
            "te preocupes, puedes invocar otro en cualquier momento.")

TextoSantuario = ("Bienvenido al santuario, aquí podrás aceptar misiones\npara conseguir fragmentos, " +
                "estos son necesarios para\ninvocar a los Totems, espíritus guías que te\nacompañaran "+
                "en todo el recorrido. También te puedo\nenseñar habilidades que te ayudaran en la "+
                "batalla o\nmejoraran tus estadísticas considerablemente.")

TextoMisiones = ("Puedes hacer misiones de búsqueda o derrotar enemigos "+
                "específicos, como \nrecompensa te daré dos fragmentos por "+
                "cada misión realizada con éxito. \n¿Qué misión deseas aceptar?")

AplicacionTexto = ("Es un juego para una persona donde se realizan combates por turnos contra seres "+ 
				"mitológicos, presenta cinco acciones principales ubicadas en el menú de acciones:\n"+
                "- Ir al campo de Batalla: Aquí se puede entrar a cada uno de los nodos en donde se encuentran "+
                "distribuidos cada uno de los enemigos a derrotar.\n"+
                "- Consultar estadísticas del personaje.\n"+
                "- Consultar Inventario: Se pueden observar tanto los objetos equipados como los que se guardan en el inventario.\n"+
                "- Visitar al herrero: Se interactúa con Pacho, el herrero del juego, aquí se pueden evolucionar, reparar, "+
                "vender o comprar objetos. \n-Visitar al sabio: En esta opción se pueden obtener misiones y recompensas "+
                "así como invocar Totems y aprender habilidades.")

class Inicio(Menu):
    def ___init___(self, window):
        super().___init___(window)

        menu1= Menu()
        self.add_cascade(menu = menu1, label="Inicio")
        menu1.add_command(label="Descripción", command= self.descripcion)
        menu1.add_command(label="Salir", command= self.salir)
    
    def salir():
        exit()

    def descripcion():
        messagebox.showinfo(title="Descripción del Juego",message="                    Desafio del Zodiaco               \n"+"\n"+
				 "Es un juego para una persona donde se realizan combates por turnos contra seres "+ 
				 "mitológicos. Recrea una aventura donde el usuario debe pasar una serie de nodos "+ 
				 "para superar el juego. Además podrá interactuar con entes del juego como los dioses, "+
                 "el sabio y el herrero, que le permitirán aprender habilidades, invocar totems. hacer misiones o "+
                 "comprar, vender y mejorar sus objetos respectivamente.")
