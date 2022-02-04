from functools import partial
import math
from tkinter import *
from tkinter import messagebox
from gestorAplicacion.complementario.clases import Clases
from gestorAplicacion.complementario.habilidad import mostrarDescripcion, showHabilidades

       

def cambioVida(frame,peleador):  # Actualiza la barra de vida del peleador
    coordenadas = frame.getCoordenadas()
    if peleador.getClase() == Clases.ENEMIGO: 
        frame.getVidaNueva().place_forget() # Quita la barra anterior 
        proporcion = math.floor(20*(peleador.getVida()/frame.getVidas()[0])) # Actualiza el tamaño de la barra de vida
        if proporcion > 0:  # En el otro caso (<=0) el peleador ha muerto y se deja la barra roja
            label = Label(frame,text=str(peleador.getVida()),width=proporcion,bg="green",fg="white") # Añade la barra con la vida actúal 
            frame.setVidaNueva(label)
            frame.getVidaNueva().place(x=coordenadas[0],y=coordenadas[1])
    else:
        frame.getVidaNueva1().place_forget() # Quita la barra anterior 
        proporcion = math.floor(20*(peleador.getVida()/frame.getVidas()[1])) # Actualiza el tamaño de la barra de vida
        if proporcion > 0:  # En el otro caso (<=0) el peleador ha muerto y se deja la barra roja
            label = Label(frame,text=str(peleador.getVida()),width=proporcion,bg="green",fg="white") # Añade la barra con la vida actúal 
            frame.setVidaNueva1(label)
            frame.getVidaNueva1().place(x=coordenadas[2],y=coordenadas[3]) 
    


def showPociones(combate,personaje):
    pociones = personaje.getPociones()
    combate.getMarcoCombate().place_forget()
    marcoPociones = Frame(combate,bg="#542D70",width=700,height=200)
    marcoPociones.place(x=0,y=400)

    #Botón de regreso
    volverOpciones = Button(marcoPociones,text="Volver",command=lambda: combate.showOpciones(marcoPociones),font=("Arial",11))
    volverOpciones.place(x=620,y=150)

    # Agregando los botones de pociones
    posiciones = [[100,20],[380,20],[100,80],[380,80],[235,140]]  # Hay máximo 5 pociones

    for i in range(len(pociones)):
        pocion = Button(marcoPociones,text=pociones[i].getNombre(),bd=6,width=18,relief=RIDGE,font=("Arial",15),command = lambda: personaje.activarPocion(combate,marcoPociones,pociones[i],combate.getEnemigoNodo()))
        describir = partial(mostrarDescripcion,habilidad = pociones[i].getHechizo())
        pocion.bind("<Button -3>",describir)
        pocion.place(x=posiciones[i][0],y=posiciones[i][1])
          
def consultarAtributos(event,peleador):
    descripcion = peleador.getNombre()+"\nVida: "+str(peleador.getVida())+"\nAtaque físico: "+str(peleador.getAtaqueFisico())+"\nAtaque mágico: "+str(peleador.getAtaqueMagico())+"\nDefensa física: "+str(peleador.getDefensaFisica())+"\nDefensa Mágica: "+str(peleador.getDefensaMagica())
    messagebox.showinfo(title="Atributos",message=descripcion)



class Combate(Frame):

    def __init__(self,ventana,image,nodo,personaje,enemigo,coordenadas):
        super().__init__(ventana,width=700,height=600)
        self._imagen = PhotoImage(file="./images/"+image) #Imagen es el nombre del archivo con su extesión
        self._fondo = Label(self,image=self._imagen)
        self._fondo.place(x=0,y=0)

        self._terminar = False
        self._imagenMuerte = PhotoImage(file="./images/muerte.png")
        self._imagenOxidar = PhotoImage(file="./images/oxidar.png")
        self._imagenMalo = PhotoImage(file="./images/equipoRoto.png") 
        self._imagenCerrar = PhotoImage(file="./imagenes/cerrar.png") 
        self._ventana = ventana
        self._nodo = nodo
        self._tesorosNodo = nodo.getTesoros()

        self._coordenadas = coordenadas
        self._posxEnemigo = coordenadas[0]
        self._posyEnemigo = coordenadas[1]
        self._posxUsuario = coordenadas[2]
        self._posyUsuario = coordenadas[3]


        self._enemigoNodo = enemigo

        self._marcoCombate = Frame(self,bg="#542D70",width=700,height=200)
        self._marcoCombate.place(x=0,y=400)

        self._opciones = Label(self._marcoCombate,name="opciones",text="Opciones de combate",font=("Arial",20),bg="#542D70",fg="white")
        self._opciones.place(x=200,y=5)

        self._vidaInicial = [self._enemigoNodo.getVida(),personaje.getVida()]

        # Opciones de combate
        self._opcion1 = Button(self._marcoCombate,name="ataque",text="Ataque básico",bg="#542D70",fg="white",font=("Arial",18),command=lambda: personaje.ataqueFisico(self,self._enemigoNodo))
        self._opcion1.place(x=140,y=60)

        self._opcion2 = Button(self._marcoCombate,name="habilidad",text="Lanzar habilidad",bg="#542D70",fg="white",font=("Arial",18),command=lambda: showHabilidades(self,personaje))
        self._opcion2.place(x=370,y=60)

        self._opcion3 = Button(self._marcoCombate,name="pocion",text="Emplear poción",bg="#542D70",fg="white",font=("Arial",18),command=lambda: showPociones(self,personaje))
        self._opcion3.place(x=250,y=120)  


        verEnemigo = partial(consultarAtributos,peleador=self._enemigoNodo)
        verUsuario = partial(consultarAtributos,peleador = personaje)
        self._botonEnemigo = Label(self,text="",bg="red",padx=10,activebackground="red",relief=RAISED,bd=4)
        self._botonEnemigo.bind("<Button -1>",verEnemigo)
        self._botonEnemigo.place(x=self._posxEnemigo-30,y=self._posyEnemigo-2)

        self._botonUsuario = Label(self,text="",bg="blue",padx=10,relief=RAISED,bd=4)
        self._botonUsuario.bind("<Button -1>",verUsuario)
        self._botonUsuario.place(x=self._posxUsuario-30,y=self._posyUsuario-2)

        #Enemigo
        self._vidaEnemiga = Label(self,text="",width=20,bg="red")
        self._vidaEnemiga.place(x=self._posxEnemigo,y=self._posyEnemigo)
        self._vidaNueva = Label(self,text=self._vidaInicial[0],width=20,bg="green",fg="white")
        self._vidaNueva.place(x=self._posxEnemigo,y=self._posyEnemigo)

        #Personaje
        self._vidaPersonaje = Label(self,text="",width=20,bg="red")
        self._vidaPersonaje.place(x=self._posxUsuario,y=self._posyUsuario)
        self._vidaNueva1 = Label(self,text=self._vidaInicial[1],width=20,bg="green",fg="white")
        self._vidaNueva1.place(x=self._posxUsuario,y=self._posyUsuario)
        
        

    def getImagenMalo(self):
        return self._imagenMalo

    def getImagenOxidar(self):
        return self._imagenOxidar
        
    def showOpciones(self,marcoHabis):
        marcoHabis.place_forget()
        self.getMarcoCombate().place(x=0,y=400)


    def getImagenCerrar(self):
        return self._imagenCerrar

    def getImagenMuerte(self):
        return self._imagenMuerte

    def getTerminar(self):
        return self._terminar

    def getVentana(self):
        return self._ventana

    def getNodo(self):
        return self._nodo

    def setTerminar(self,valor):
        self._terminar = valor

    def getTesorosNodo(self):
        return self._tesorosNodo

    def getVidaNueva(self):
        return self._vidaNueva

    def getVidaNueva1(self):
        return self._vidaNueva1    

    def getVidas(self):
        return self._vidaInicial

    def setVidaNueva(self,label):
        self._vidaNueva = label

    def setVidaNueva1(self,label):
        self._vidaNueva1 = label

    def getMarcoCombate(self):
        return self._marcoCombate    
   
    def getEnemigoNodo(self):
        return self._enemigoNodo

    def getPosxEnemigo(self):
        return self._posxEnemigo

    def getPosyEnemigo(self):
        return self._posyEnemigo

    def getPosxUsuario(self):
        return self._posxUsuario            

    def getPosyUsuario(self):
        return self._posyUsuario

    def getCoordenadas(self):
        return self._coordenadas                



