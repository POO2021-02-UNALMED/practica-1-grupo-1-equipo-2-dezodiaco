'''
Se implementa para la creación de los objetos que van a estar presentes en el juego


Autores: Camilo, Yeferson, Edwin
'''



from tkinter import PhotoImage
from turtle import width


class Objeto:

    def __init__(self, nombre, habilidad = None, precio = 0, tipo = 0, ataqueFisico = 0, ataqueMagico = 0, defensaFisica = 0, defensaMagica = 0, durabilidad = 0, evoluciona = False,icono = None):
        self._nombre = nombre
        self._precio = precio
        self._tipo = tipo
        self._ataqueFisico = ataqueFisico
        self._ataqueMagico = ataqueMagico
        self._defensaFisica = defensaFisica
        self._defensaMagica = defensaMagica
        self._durabilidad = durabilidad
        self._evoluciona = evoluciona
        self._hechizo = habilidad
        self._evolucion = None
        self._materialesEvolucion = None
        self._icono = icono
            


    def getTipo(self):
        return self._tipo

    def getPrecio(self):
        return self._precio

    def getIcono(self):
        return self._icono

    def setIcono(self,icono):
        self._icono = icono

    def getAtaqueFisico(self):
        return self._ataqueFisico

    def setAtaqueFisico(self, ataqueFisico):
        self._ataqueFisico = ataqueFisico

    def getAtaqueMagico(self):
        return self._ataqueMagico   

    def setAtaqueMagico(self, ataqueMagico):
        self._ataqueMagico = ataqueMagico

    def setHechizo(self,hechizo):
        self._hechizo = hechizo

    def getHechizo(self):
        return self._hechizo       

    def getDurabilidad(self):
        return self._durabilidad

    def setDurabilidad(self, durabilidad):
        self._durabilidad = durabilidad

    def getNombre(self):
        return self._nombre

    def isEvoluciona(self):
        return self._evoluciona

    def getEvolucion(self):
        return self._evolucion


    def getDefensaFisica(self):
        return self._defensaFisica

    def setDefensaFisica(self, defensaFisica):
        self._defensaFisica = defensaFisica

    def getDefensaMagica(self):
        return self._defensaMagica

    def setDefensaMagica(self, defensaMagica):
        self._defensaMagica = defensaMagica


    def setEvolucion(self, evolucion):
        self._evolucion = evolucion

    def __str__(self):
        texto = "- " + self.getNombre() + " : " + str(self.getAtaqueFisico()) + ", " + str(self.getAtaqueMagico()) + ", " + str(self.getDefensaFisica()) + ", " + str(self.getDefensaMagica()) + ", " + str(self.getDurabilidad())
        return texto

    def getMaterialesEvolucion(self):
        return self._materialesEvolucion

    def setMaterialesEvolucion(self, materialesEvolucion):
        self._materialesEvolucion = materialesEvolucion









