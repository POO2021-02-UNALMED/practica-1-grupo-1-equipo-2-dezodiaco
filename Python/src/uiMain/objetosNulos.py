'''
Excepción para controlar referencias a objetos nulos.

autor: Camilo
'''
from uiMain.referenciasNulas import ReferenciasNulas


class ObjetosNulos(ReferenciasNulas):

    def  __init__(self):
        super().__init__("\nObjeto Nulo")
        

    def corregir():
        return  "Objeto no encontrado."
    
    def mensaje():
        super().mensaje("Se ha encontrado un objeto nulo.")