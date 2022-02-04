'''
Clase para manejar el ingreso del nombre

autor: Camilo
'''


from uiMain.valoresInconsistentes import ValoresInconsistentes


class NombresVacios(ValoresInconsistentes):

    def  __init__(self):
        super().__init__("No se ha ingresado el nombre.")
        

    def corregir():
        return  "Ingrese un nombre."

    def mensaje():
        super().mensaje("No se ha ingresado el nombre.")