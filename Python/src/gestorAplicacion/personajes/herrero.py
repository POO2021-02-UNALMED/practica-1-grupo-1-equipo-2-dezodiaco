'''
Se relaciona con el personaje, comercializa, repara y evoluciona objetos

Autores: Camilo, Edwin
'''

from email import message
from functools import partial
import random
import math
from tkinter import *
from tkinter import messagebox
from gestorAplicacion.complementario.tipoDeObjeto import TipoDeObjeto


class Herrero:
    
    def __init__(self, nombre, objetos, eficiencia, impuesto):
        self._nombre = nombre
        self._objetos = objetos
        self._eficiencia = eficiencia
        self._impuesto = impuesto
        self._fondoInicio = PhotoImage(file="./images/herrero1.png")
        self._fondoEvolucionar = PhotoImage(file="./images/evolucion.png")        
        self._fondoComprar = PhotoImage(file="./images/fondoComprar.png")
        self._fondoCofre = PhotoImage(file="./images/fondoCofre.png")
        self._fondoVender = PhotoImage(file="./images/fondoVender.png")
        self._fondoReparar = PhotoImage(file="./images/fondoReparar.png")
        self._fondoAlmacen = PhotoImage(file="./images/evolucion.png")
        self._fondoMateriales = PhotoImage(file="./images/materiales.png")
        self._fondoDesfragmentar = PhotoImage(file="./images/desfragmentar.png")
        self._fondoVacio = PhotoImage(file="./images/vacio.png")
        self._iconosMateriales = []
        for i in range(1,10):
            imagen = PhotoImage(file="./images/iconos/materiales/mat"+str(i)+".png")
            self._iconosMateriales.append(imagen)

    def getFondoVacio(self):
        return self._fondoVacio

    def getFondoInicio(self):
        return self._fondoInicio

    def getFondoEvolucionar(self):
        return self._fondoEvolucionar

    def getFondoCofre(self):
        return self._fondoCofre    

    @staticmethod
    def setCofre(cofre):
        Herrero._cofre = cofre

    def getFondoComprar(self):
        return self._fondoComprar

    def getFondoDesfragmentar(self):
        return self._fondoDesfragmentar

    def getFondoMateriales(self):
        return self._fondoMateriales        

    def getFondoVender(self):
        return self._fondoVender

    def getFondoReparar(self):
        return self._fondoReparar


    def getIconosMateriales(self):
        return self._iconosMateriales    

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getObjetos(self):
        return self._objetos

    def setObjetos(self, objetos):
        self._objetos = objetos

    def getEficiencia(self):
        return self._eficiencia

    def setEficiencia(self, eficiencia):
        self._eficiencia = eficiencia

    def getImpuesto(self):
        return self._impuesto

    def setImpuesto(self, impuesto):
        self._impuesto = impuesto

    @staticmethod
    def setAlmacen(almacen):
        Herrero._almacen = almacen

    @staticmethod
    def getAlmacen():
        return Herrero._almacen    

    #cobro de un impuesto
    def agregarImpuesto(self, objeto):
        return int(math.ceil(objeto.getPrecio()+objeto.getPrecio()*self._impuesto/100))

    #calculo del impuesto
    def retirarImpuesto(self, objeto):
        return int(math.floor(objeto.getPrecio()-objeto.getPrecio()*self._impuesto/100))

    #Repara los objetos
    def reparar(self, personaje, indice):
        personaje.setOro(personaje.getOro()-10)
        objetoElegido = personaje.getInventario()[indice]
        objetoElegido.setDurabilidad(objetoElegido.getDurabilidad()+1)

        return "\nMe ha costado un ojo reparar este objeto, pero aqui lo tienes. Ahora es m�s resistente que la coraza de un drag�n"


    #Evoluciona un objeto, si este evoluciona
    def evolucionar(self, personaje, objeto):

        suerte = random.random()
        probabilidadMejora = self.__eficiencia
        indice = (personaje.getInventario().index(objeto))

        for material in personaje.getInventario()[indice].getMaterialesEvolucion():
            personaje.getMateriales().remove(material)


        if suerte<=probabilidadMejora:
            personaje.getInventario().append(objeto.getEvolucion())
            personaje.getInventario().remove(objeto)
            return "\nFelicidades, tu objeto ha sido evolucionado"
        else:
            personaje.setOro(personaje.getOro()+10)
            personaje.getInventario().remove(objeto)
            return "\nEs una pena, el objeto no resistio el proceso. Toma 10 de oro como compensacion"


