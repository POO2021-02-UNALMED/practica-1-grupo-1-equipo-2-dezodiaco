'''
Implementación de la clase abstracta. define el método apoyar

Autor: Yeferson, Camilo, Edwin
'''

class Guardian:


    #Constructor para las clases hijas
    def __init__(self, nombre, habilidadEspecial):
        self.nombre = nombre
        self.habilidadEspecial = habilidadEspecial

    def apoyar(self, personaje):
        pass

    def getNombre(self):
        return self.nombre



