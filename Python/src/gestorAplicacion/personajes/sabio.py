'''
Es esta clase se crea el Sabio, ente que se relaciona con el jugador cuando este los desee.

Dentro de las funciones del sabio está asignar las misiones tanto de lucha como de combate
y además de verificar que se cumplan.

Autores: Yeferson, Edwin
'''

from .dios import Dios

class Sabio(Dios):
    def __init__(self, nombre, habilidades, Objetos, Oponentes, misionesB, misionesL, totems):
        super().__init__(nombre, habilidades)
        self._Objetos = Objetos
        self._Oponentes = Oponentes
        self._misionesB = misionesB
        self._misionesL = misionesL
        self._Totems = totems

    #M�todo para ense�ar una habilidad del Sabio al personaje principal
    def ensenarHabilidad(self, personaje, indice):
        if personaje.getOro() > 20:
            personaje.agregarHabilidad(self.getHabilidades()[indice])
            personaje.setOro(personaje.getOro() - 20)
            return "Has aprendido {}".format(self.getHabilidades()[indice].getNombre())
        else:
            return "No tienes oro suficiente para aprender esta habilidad."
    #Invocar totems teniendo en cuenta los fragmentos del personaje
    def invocarTotems(self, personaje, totem):
        if personaje.getFragmentos() >= 4:
            personaje.setTotem(totem)
            personaje.setFragmentos(personaje.getFragmentos() -4)
            return "\nSe ha invocado a "+ totem.getNombre() +". \n \nHabilidad \n" + totem.getHabilidadEspecial().__str__()
        

    #Se podr�n asignar misiones de b�squeda o de lucha para conseguir fragmentos
    def asignarMisionB(self, objeto):
        self._Objetos.append(objeto)
        self._misionesB += 1
        return "Se te ha asignado una misión, debes encontar " + objeto.getNombre() + ", puedes encontrarlo en un tesoro o como recompensa al vencer un enemigo."

    def asignarMisionC(self, enemigo):
        self._Oponentes.append(enemigo)
        self._misionesL += 1
        return "Se te ha asignado una misión, debes derrotar a " + enemigo.getNombre() + ", puedes enfrentarte a él en los campos de batalla."


    #M�todos para evaluar las misiones comparando ArrayList
    def calificarMisionBusqueda(self, personaje):
        fragmentos = 0
        i = 0
        while i < len(self._Objetos):
            if self._Objetos[i] in personaje.getInventario():
                personaje.setFragmentos(personaje.getFragmentos()+2)
                self._Objetos.remove(self._Objetos[i])
                self._misionesL -= 1
                fragmentos +=2
            i += 1
        return fragmentos

    def calificarMisionCombate(self, personaje):
        fragmentos = 0
        i = 0
        while i < len(self._Oponentes):
            if self._Oponentes[i] in personaje.getEnemigosDerrotados():
                personaje.setFragmentos(personaje.getFragmentos()+2)
                self._Oponentes.remove(self._Oponentes[i])
                self._misionesL -= 1
                fragmentos +=2
            i += 1
        return fragmentos

    def getObjetos(self):
        return self._Objetos

    def setObjetos(self, objetos):
        self._Objetos = objetos

    def getOponentes(self):
        return self._Oponentes

    def setOponentes(self, oponentes):
        self._Oponentes = oponentes

    def getMisionesB(self):
        return self._misionesB

    def setMisionesB(self, misionesB):
        self._misionesB = misionesB

    def getMisionesL(self):
        return self._misionesL

    def setMisionesL(self, misionesL):
        self._misionesL = misionesL

    def getTotems(self):
        return self._Totems

    def setTotems(self, totems):
        self._Totems = totems

    def hablar(self):
        return "Usa la habilidad con prudencia, en tus manos está el futuro de la humanidad."



