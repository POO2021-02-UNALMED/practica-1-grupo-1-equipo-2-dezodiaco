from enum import Enum

class TipoEfecto(Enum):
    QUEMAR = 1
    ENVENENAR = 2
    NULO = 3

    def descripcion(habilidad):
        texto = ""
        if habilidad.getEfecto() == "QUEMAR":
            texto = "incinera al objetivo y le inflige "+ str(habilidad.getDanoEfecto()) +" de daño"
        else:
            texto = "envenena al enemigo y le inflige "+ str(habilidad.getDanoEfecto()) +" de daño"

        return texto

    
