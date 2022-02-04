'''
Las habilidades pueden modificar o revertir las estadísticas de un personaje con 
los métodos modificarEstadística y revertirEstadistica respectivamente.

Autores: Edwin, Camilo.
'''

from functools import partial
from tkinter import messagebox
from gestorAplicacion.complementario.tipoEfecto import TipoEfecto
from gestorAplicacion.complementario.tipoHabilidad import TipoHabilidad
from tkinter import *


class Habilidad:

    def __init__(self, tipo, nombre, modificador, duracion, enfriamiento, danoEfecto, efecto, autoDirigida):
        self._nombre = nombre
        self._modificador = modificador
        self._tipo = tipo
        self._duracion = duracion
        self._enfriamiento = enfriamiento
        self._danoEfecto = danoEfecto
        self._efecto = efecto
        self._autoDirigida = autoDirigida

    
    #modifica las estadisticas del personaje pasado como par�metro.
    #Tiene en cuenta el tipo de habilidad.
    def modificarEstadistica(self,personaje):
        if self.getTipo() ==  TipoHabilidad.APOYOFISICO:
            personaje.setAtaqueFisico(personaje.getAtaqueFisico() + self._modificador)

        elif self.getTipo() ==  TipoHabilidad.APOYOMAGICO:
            personaje.setAtaqueMagico(personaje.getAtaqueMagico() + self._modificador)

        elif self.getTipo() ==  TipoHabilidad.SANACION:
            personaje.setVida(personaje.getVida() + self._modificador)

        elif self.getTipo() ==  TipoHabilidad.DEFENSAFISICA:
            personaje.setDefensaFisica(personaje.getDefensaFisica() + self._modificador)

        elif self.getTipo() ==  TipoHabilidad.DEFENSAMAGICA:
            personaje.setDefensaMagica(personaje.getDefensaMagica() + self._modificador)

        elif self.getTipo() ==  TipoHabilidad.ATAQUEFISICO:
            personaje.setVida(personaje.getVida() - self._modificador)
        else: 
            personaje.setVida(personaje.getVida() - self._modificador)



    def isAutoDirigida(self):
        return self._autoDirigida

    def getEfecto(self):
        return self._efecto


    def getDanoEfecto(self):
        return self._danoEfecto


    #modifica negativamente las estadisticas del personaje pasado como par�metro.
    #Tiene en cuenta el tipo de habilidad.
    def revertirEstadistica(self, personaje):
        if self.getTipo() ==  TipoHabilidad.ATAQUEFISICO:
            personaje.setAtaqueFisico(personaje.getAtaqueFisico() - self._modificador)

        if self.getTipo() ==  TipoHabilidad.ATAQUEMAGICO:
            personaje.setAtaqueFisico(personaje.getAtaqueMagico() - self._modificador)

        if self.getTipo() ==  TipoHabilidad.SANACION:
            personaje.setVida(personaje.getVida() - self._modificador)

        if self.getTipo() ==  TipoHabilidad.DEFENSAFISICA:
            personaje.setDefensaFisica(personaje.getDefensaFisica() - self._modificador)
        
        if self.getTipo() ==  TipoHabilidad.DEFENSAMAGICA:
            personaje.setDefensaFisica(personaje.getDefensaMagica() - self._modificador)


    def getEnfriamiento(self):
        return self._enfriamiento

    def setEnfriamiento(self, enfriamiento):
        self._enfriamiento = enfriamiento

    def getDuracion(self):
        return self._duracion

    def getModificador(self):
        return self._modificador


    def getTipo(self):
        return self._tipo


    def getNombre(self):
        return self._nombre

    #Devuelve una descripción de la habilidad teniendo en cuenta su tipo.
    def __str__(self):
        descripcion = ""
        if self.getTipo() == TipoHabilidad.APOYOFISICO:
            descripcion = self._nombre +": Modifica el ataque fisico del objetivo en "+str(self._modificador)+" puntos"

        elif self.getTipo() ==  TipoHabilidad.APOYOMAGICO:
            descripcion = self._nombre +": Modifica el ataque magico del objetivo en "+str(self._modificador)+" puntos"

        elif self.getTipo() ==  TipoHabilidad.DEFENSAFISICA:
            descripcion = self._nombre +": Modifica la defensa fisica del objetivo en "+str(self._modificador)+" puntos"

        elif self.getTipo() ==  TipoHabilidad.DEFENSAMAGICA:
            descripcion = self._nombre +": Modifica la defensa magica del objetivo en "+str(self._modificador)+" puntos"

        elif self.getTipo() ==  TipoHabilidad.SANACION:
            descripcion = self._nombre +": Aumenta la vida del objetivo en "+str(self._modificador)+" puntos"

        elif self.getTipo() ==  TipoHabilidad.ATAQUEFISICO:
            if self.getEfecto() == TipoEfecto.NULO:  
                descripcion = self._nombre +": Inflige "+str(self._modificador)+" de daño fisico al objetivo"
            else:
                descripcion = self._nombre +": Inflige daño al enemigo y aplica efectos negativos"

        else:
            if self.getEfecto() == TipoEfecto.NULO:
                descripcion = self._nombre +": Inflige "+str(self._modificador)+" de daño mágico al objetivo"
            else:
                descripcion = self._nombre +": Inflige daño al enemigo y aplica efectos negativos"
        return descripcion


def mostrarDescripcion(event,habilidad):
    mensaje = habilidad.__str__()
    messagebox.showinfo(title="Descripción",message=mensaje)

def verificarHabilidad(personaje,habilidad):
    indice = personaje.getHabilidades().index(habilidad)
    if personaje.getEnfriamientos()[indice] == 0:
        return NORMAL
    else:
        return DISABLED    

def showHabilidades(combate,personaje): 

    habilidades = personaje.getHabilidades()
    nombresHabilidades = []
    for i in personaje.getHabilidades():
        nombresHabilidades.append(i.getNombre())

    combate.getMarcoCombate().place_forget()
    marcoHabis = Frame(combate,bg="#542D70",width=700,height=200,name="marcoHabis")
    marcoHabis.place(x=0,y=400)
    
    habilidad0 = Button(marcoHabis,bd=6,relief=RIDGE,width=18,text=nombresHabilidades[0],font=("Arial",15),state=verificarHabilidad(personaje,habilidades[0]),command=lambda: personaje.lanzarHabilidad(combate,marcoHabis,habilidades[0],combate.getEnemigoNodo()))
    evento0 = partial(mostrarDescripcion,habilidad = habilidades[0])
    habilidad0.bind("<Button -3>",evento0)
    habilidad0.place(x=100,y=20)

    habilidad1 = Button(marcoHabis,bd=6,relief=RIDGE,width=18,text=nombresHabilidades[1],font=("Arial",15),state=verificarHabilidad(personaje,habilidades[1]),command=lambda: personaje.lanzarHabilidad(combate,marcoHabis,habilidades[1],combate.getEnemigoNodo()))
    evento1 = partial(mostrarDescripcion,habilidad = habilidades[1])
    habilidad1.bind("<Button -3>",evento1)
    habilidad1.place(x=380,y=20)

    habilidad2 = Button(marcoHabis,bd=6,width=18,relief=RIDGE,text=nombresHabilidades[2],font=("Arial",15),state=verificarHabilidad(personaje,habilidades[2]),command=lambda: personaje.lanzarHabilidad(combate,marcoHabis,habilidades[2],combate.getEnemigoNodo()))
    evento2 = partial(mostrarDescripcion,habilidad = habilidades[2])
    habilidad2.bind("<Button -3>",evento2)
    habilidad2.place(x=100,y=80)

    habilidad3 = Button(marcoHabis,bd=6,width=18,relief=RIDGE,text=nombresHabilidades[3],font=("Arial",15),state=verificarHabilidad(personaje,habilidades[3]),command=lambda: personaje.lanzarHabilidad(combate,marcoHabis,habilidades[3],combate.getEnemigoNodo()))
    evento3 = partial(mostrarDescripcion,habilidad = habilidades[3])
    habilidad3.bind("<Button -3>",evento3)
    habilidad3.place(x=380,y=80)

    habilidad4 = Button(marcoHabis,bd=6,width=18,relief=RIDGE,text=nombresHabilidades[4],font=("Arial",15),state=verificarHabilidad(personaje,habilidades[4]),command=lambda: personaje.lanzarHabilidad(combate,marcoHabis,habilidades[4],combate.getEnemigoNodo()))
    evento4 = partial(mostrarDescripcion,habilidad = habilidades[4])
    habilidad4.bind("<Button -3>",evento4)
    habilidad4.place(x=235,y=140)

    volverOpciones = Button(marcoHabis,text="Volver",font=("Arial",11),command=lambda: combate.showOpciones(marcoHabis))
    volverOpciones.place(x=620,y=150)    








