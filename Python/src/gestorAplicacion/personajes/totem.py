'''
Cada totem relaciona con el personaje ofreciendole mejoras en sus atributos, puede ayudarlo una vez o obsequiarle 
un objeto sagrado a cambio de su existencia, desaparecerá al instante.

Autor: Yeferson, Camilo, Edwin
'''

from .guardian import Guardian
from .espiritu import Espiritu

class Totem(Guardian, Espiritu):
    _apoyo = 1

    def __init__(self, nombre, habilidadEspecial, objeto):
        super().__init__(nombre, habilidadEspecial)
        self._objeto = objeto

    def getHabilidadEspecial(self):
        return self.habilidadEspecial

    def getObjeto(self):
        return self._objeto
    
    def getApoyo(self):
        return self._apoyo


    #Contribuye a las estad�sticas del jugado, es un m�todo heredado de Guardian
    def apoyar(self, personaje):
        if self._apoyo != 0:
            self.habilidadEspecial.modificarEstadistica(personaje)
            self._apoyo = 0
            return "Has activado la habilidad\n"+ self.habilidadEspecial.__str__()
        else:
            return "Solo puedes usar esta habilidad una vez"

    #Otorga el objeto al jugador, este m�todo es heredado de Espiritu
    def donarObjeto(self, personaje):
        personaje.getInventario().append(self._objeto)
        self.getHabilidadEspecial().revertirEstadistica(personaje)
        personaje.setTotem(None)

        return "\nSe te ha otorgado: "+ self._objeto.getNombre()


