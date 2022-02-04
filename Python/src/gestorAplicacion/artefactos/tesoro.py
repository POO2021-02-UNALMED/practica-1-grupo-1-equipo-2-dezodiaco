
import random
import time
from tkinter import *



class Tesoro:
    
    def __init__(self, nombre, recompensas,ventana):
        self._nombre = nombre
        self._recompensas = recompensas


        #Ventana de tesoro
        self._marcoTesoro = Frame(ventana,width=700,height=600)

        #Imágenes de los cofres
        self._imagen0 = PhotoImage(file="./images/dorado.png")
        self._imagen1 = PhotoImage(file="./images/cofre1.png")
        self._imagen2 = PhotoImage(file="./images/cofre2.png")
        self._imagen3 = PhotoImage(file="./images/cofre3.png")
        self._imagen4 = PhotoImage(file="./images/cofre4.png")
        self._imagen5 = PhotoImage(file="./images/cofre5.png")

        self._tesoroFondo = Label(self._marcoTesoro,image=self._imagen0,bd=0)
        self._tesoroFondo.place(x=0,y=0)
        self._cofre1 = Label(self._marcoTesoro,image=self._imagen1,bd=0)
        self._cofre2 = Label(self._marcoTesoro,image=self._imagen2,bd=0)
        self._cofre3 = Label(self._marcoTesoro,image=self._imagen3,bd=0)
        self._cofre4 = Label(self._marcoTesoro,image=self._imagen4,bd=0)
        self._cofre5 = Label(self._marcoTesoro,image=self._imagen5,bd=0)
        self._imagenRecompensa = None
        self._imagenCerrar = PhotoImage(file="./imagenes/cerrar.png")    


    def getRecompensas(self):
        return self._recompensas


    def setRecompensas(self, recompensas):
        self._recompensas = recompensas



    def getNombre(self):
        return self._nombre

    def getMarcoTesoro(self):
        return self._marcoTesoro    


    def getImagenRecompensa(self):
        return self._imagenRecompensa

    def setImagenRecompensa(self,imagen):
        self._imagenRecompensa = imagen    



def mostrarTesoro(combate,personaje):
    tesoro = combate.getTesorosNodo()
    marco = tesoro.getMarcoTesoro()
    combate.place_forget()
    tesoro._cofre1.place(x=200,y=100)
    marco.place(x=0,y=0)
    abrir = Button(marco,text="ABRIR",font=("Arial",15),command=lambda: abrirCofre(combate,personaje,combate.getNodo(),tesoro,abrir))
    abrir.place(x=320,y=380)
    



def abrirCofre(combate,personaje,nodo,tesoro,boton):
    boton.config(state=DISABLED)
    tesoro._cofre1.place_forget()
    time.sleep(0.5)
    tesoro._cofre2.place(x=200,y=100)
    tesoro._marcoTesoro.update()
    time.sleep(0.5)
    tesoro._cofre2.place_forget()
    tesoro._cofre3.place(x=200,y=100)
    tesoro._marcoTesoro.update()
    time.sleep(0.5)
    tesoro._cofre3.place_forget()
    tesoro._cofre4.place(x=200,y=100)
    tesoro._marcoTesoro.update()
    time.sleep(0.5)
    tesoro._cofre4.place_forget()
    tesoro._cofre5.place(x=200,y=100)
    tesoro._marcoTesoro.update()
    time.sleep(0.5)
    tesoro._cofre5.place_forget()

    #Marco de recompensa
    tesoros = nodo.getTesoros().getRecompensas()
    elegirRecompensa = random.randint(0,len(tesoros)-1)
    recompensa = tesoros[elegirRecompensa]
    marcoRecompensa = Frame(combate.getVentana(),width=700,height=600,bg="black")
    mensaje = Label(marcoRecompensa,text="¡Felicidades has conseguido "+recompensa.getTipo().value[1]+": "+recompensa.getNombre()+"!",font=("Arial",15),bg="black",fg="white")
    mensaje.place(x=90,y=170)
    imagen = PhotoImage(file="./images/iconos/"+recompensa.getIcono())
    tesoro.setImagenRecompensa(imagen)
    icono = Label(marcoRecompensa,image=tesoro.getImagenRecompensa())
    icono.place(x=300,y=270)
    tesoro._marcoTesoro.place_forget()
    marcoRecompensa.place(x=0,y=0)
    personaje.agregarObjeto(recompensa)

    ventana = combate.getVentana()
    frameCamino = ventana.nametowidget("camino")
    frameNodo = ventana.nametowidget("frameNodos")
    menu = ventana.nametowidget("menubar")
    menu2 = menu.nametowidget("archivo")
    
    

    def regresar():
        marcoRecompensa.place_forget()
        frameCamino.place(x=0,y=0)
        menu.entryconfig("Acciones",state=NORMAL)
        menu2.entryconfig("Guardar",state=NORMAL)

    volverRecompensa = Button(marcoRecompensa, text="X", image=tesoro._imagenCerrar,command= regresar, bg="black")
    volverRecompensa.place(x=650, y=15)

   
    conexionesNodo = nodo.getConexiones()
    random.shuffle(conexionesNodo)
    nombre = conexionesNodo[0].getNombre().lower()
    labelNodo = frameNodo.nametowidget(nombre)
    abrir = random.randint(0,3)
    if abrir < 3:
        conexionesNodo[0].setAbierto(True)
        labelNodo.config(fg="#34E718")
    else:
        conexionesNodo[0].setAbierto(False)
        labelNodo.config(fg="yellow")

    

    
    
    
    

