
from uiMain.referenciasNulas import ReferenciasNulas


class TotemNulo(ReferenciasNulas):

    def  __init__(self):
        super().__init__("\nTotem no invocado")
        

    def corregir():
        return  "No invocado"
    
    def mensaje():
        super().mensaje("Totem no invocado")