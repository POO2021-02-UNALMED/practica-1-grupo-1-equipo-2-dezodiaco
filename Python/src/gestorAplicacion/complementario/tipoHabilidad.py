'''
Enumerador para clasificar a las habilidades por tipo

Autor: Edwin
'''

from enum import Enum

class TipoHabilidad(Enum):
    
    SANACION = 0
    APOYOFISICO = 1
    APOYOMAGICO = 2
    DEFENSAFISICA = 3
    DEFENSAMAGICA = 4
    ATAQUEFISICO = 5
    ATAQUEMAGICO = 6

