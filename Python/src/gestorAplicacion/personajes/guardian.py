class Guardian:


    #Constructor para las clases hijas
    def __init__(self, nombre, habilidadEspecial):
        self.nombre = nombre
        self.habilidadEspecial = habilidadEspecial

    def apoyar(self, personaje):
        pass

    def getNombre(self):
        return self.nombre



