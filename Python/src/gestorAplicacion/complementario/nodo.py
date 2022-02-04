'''
 Son los espacios en donde se desarrollan los combates, también hay presencia de dioses y
 enemigos.
 
 Autor: Edwin
 '''

from tkinter import messagebox
import random


class Nodo:
    _nodos = [] #Se almacenan todos los nodos creados.


    def __init__(self, nombre, dioses, conexiones, logro, enemigos, tesoros):
        self._nombre = nombre
        self._dioses = dioses
        self._conexiones = conexiones
        self._abierto = logro
        self._enemigos = enemigos
        self._tesoros = tesoros

    #Permite acceder a un node espec�fico
    def abrirNodo(self, nodo):
        if self._abierto == True and nodo in self._conexiones:
            return nodo
        return self

    def getDioses(self):
        return self._dioses

    def setDioses(self, dioses):
        self._dioses = dioses

    def getConexiones(self):
        return self._conexiones

    def setConexiones(self, conexiones):
        self._conexiones = conexiones

    def isAbierto(self):
        return self._abierto

    def setAbierto(self, logro):
        self._abierto = logro

    def getNombre(self):
        return self._nombre

    @staticmethod
    def getNodos():
        return Nodo._nodos

    def setEnemigos(self, enemigos):
        self._enemigos = enemigos

    def getEnemigos(self):
        return self._enemigos

    def elegirEnemigo(self):
        random.shuffle(self._enemigos) # Reorganiza los enemigos del nodo
        return self._enemigos[0]

    def elegirDios(self):
        random.shuffle(self._dioses) # Reorganiza los dioses del nodo
        return self._dioses[0]

    @staticmethod
    def setNodos(nodos):
        Nodo._nodos = nodos

    def getTesoros(self):
        return self._tesoros

    def setTesoros(self, tesoros):
        self._tesoros = tesoros


#Se elige un tesoro del nodo reorganizando al azar el ArrayList
    def elegirTesoro(self):
        random.shuffle(self.__tesoros)
        premio = self.__tesoros[0]
        random.shuffle(premio.getRecompensas())
        recompensa = premio.getRecompensas()[0]
        return recompensa

    







