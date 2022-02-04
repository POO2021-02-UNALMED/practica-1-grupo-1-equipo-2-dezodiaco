'''
Interactua con los peleadores otorgando y enseñando habilidades.

Autor: Yeferson, Camilo, Edwin
'''

import random
from tkinter import *
from tkinter import messagebox
from gestorAplicacion.artefactos.objeto import Objeto
from gestorAplicacion.complementario.combate import cambioVida
from gestorAplicacion.complementario.tipoDeObjeto import TipoDeObjeto
from gestorAplicacion.personajes.herrero import Herrero




class Dios:

      

    def __init__(self, nombre, habilidades = None):
        self._nombre = nombre
        self._habilidades = habilidades
        

    #Método para enseñar las habilidades de los dioses al personaje principal y aplicarlas
    def ensenarHabilidad(self, personaje, habilidad):
        personaje.agregarHabilidad(habilidad)
        habilidad.modificarEstadistica(personaje)

    def getNombre(self):
        return self._nombre

    def getHabilidades(self):
        return self._habilidades

    def __str__(self):
        return self._nombre

    def setHabilidades(self, habilidades):
        self._habilidades = habilidades

    def hablar(self):
        return "Espero que te adaptes a los cambios, toma buenas decisiones con lo que tienes."

    def elegirHabilidad(self):
        random.shuffle(self._habilidades) # Reorganiza las habilidades del nodo
        return self._habilidades[0]
    

    @staticmethod
    def intervenirDios(nodo,combate,personaje,enemigo):
        diosElegido = nodo.elegirDios()
        habilidadElegida = diosElegido.elegirHabilidad()
        elegirObjetivo = random.randint(0,1)
        if elegirObjetivo == 0:
            habilidadElegida.modificarEstadistica(personaje)
            messagebox.showinfo(title="Inicio del combate",message="El dios "+diosElegido.getNombre()+" lanza la habilidad "+habilidadElegida.getNombre()+" sobre el peleador "+personaje.getNombre()+"\n"+habilidadElegida.__str__())
            cambioVida(combate,personaje)
            
        else:
            habilidadElegida.modificarEstadistica(enemigo)
            messagebox.showinfo(title="Inicio del combate",message="El dios "+diosElegido.getNombre()+" lanza la habilidad "+habilidadElegida.getNombre()+" sobre el peleador "+enemigo.getNombre()+"\n"+habilidadElegida.__str__())
            cambioVida(combate,enemigo)
            
       



def castigar(combate,personaje):

    combate.place_forget()
    marcoCastigo = Frame(combate.getVentana(),width=700,height=600)
    marcoHabilidad = Frame(combate.getVentana(),width=700,height=600)
    marcoHabilidad.place(x=0,y=0)

    imagen = combate.getImagenMuerte()
    imagenOxidar = combate.getImagenOxidar()
    imagenMalo = combate.getImagenMalo()

    # Enfria una habilidad por 4 turnos
    elegirHabilidad = random.randint(0,4)
    habilidad = personaje.getHabilidades()[elegirHabilidad]
    enfriamientos = personaje.getEnfriamientos()
    enfriamientos[elegirHabilidad] = 4

    fondoMuerte = Label(marcoHabilidad,image=imagen)
    fondoMuerte.place(x=0,y=0)
    mensajeCastigo = Label(marcoHabilidad,bg="black",fg="white",font=("Arial",24),text="Los dioses se enfurecen y ponen "+"\nen enfriamiento tu habilidad \n"+habilidad.getNombre()+" durante 4 turnos")
    mensajeCastigo.place(x=120,y=90)


    ventana = combate.getVentana()
    menu = ventana.nametowidget("menubar")
    menu2 = menu.nametowidget("archivo")
    frameCamino = ventana.nametowidget("camino")

    def regresar():
        frameCamino.place(x=0,y=0)
        marcoCastigo.place_forget()
        menu.entryconfig("Acciones",state = NORMAL)
        menu2.entryconfig("Guardar",state=NORMAL)

    inventario = personaje.getInventario()
    equipados = []


    if personaje.getAnillo() != None:
        equipados.append(personaje.getAnillo())
       

    if personaje.getArma() != None:
        equipados.append(personaje.getArma())
     

    if personaje.getArmadura() != None:
        equipados.append(personaje.getArmadura())
   

    totalObjetos = equipados + inventario
    
    if len(totalObjetos) > 0:   # Selecciona un objeto y lo oxida (reduce su durabilidad por 1)
        
        
        elegirObjeto = random.randint(0,len(totalObjetos)-1)

        elegido = totalObjetos[elegirObjeto]
        
        elegido.setDurabilidad(elegido.getDurabilidad()-1)

        fondoOxidar = Label(marcoCastigo,image=imagenOxidar)
        mensajeOxidar = Label(marcoCastigo,bg="black",fg="white",text="El objeto "+elegido.getTipo().value[1]+" "+elegido.getNombre()+"\nse oxida y pierde durabilidad",font=("Arial",19))
        

        fondoMalo = Label(marcoCastigo,image=imagenMalo)

        def cambiarMarco():
            marcoHabilidad.place_forget()
            marcoCastigo.place(x=0,y=0)

            if elegido.getDurabilidad() != 0:
                mensajeOxidar.place(x=100,y=120)
                fondoOxidar.place(x=0,y=0)

            else:
                #mensajeOxidar.place_forget()
                fondoMalo.place(x=0,y=0)
                almacenHerrero = personaje.getAlmacen()
                if len(almacenHerrero) == 12:   # Elimina un objeto porque tiene el límite de objetos 
                    almacenHerrero[0] = elegido
                else:
                    almacenHerrero.append(elegido)

                if elegido in equipados:
                    tipo = elegido.getTipo().value[0]
                    if tipo == 3:
                        personaje.setAnillo(None)
                    elif tipo == 5:
                        personaje.setArmadura(None)
                    else:
                        personaje.setArma(None)
                
        continuar = Button(marcoHabilidad,text="CONTINUAR",font=("Arial",15),bg="black",fg="white",command=cambiarMarco)
        continuar.place(x=550,y=550)

    volver = Button(marcoCastigo, text="X", image=combate.getImagenCerrar(),command= regresar, bg="black")
    volver.place(x=650, y=15)    


    



