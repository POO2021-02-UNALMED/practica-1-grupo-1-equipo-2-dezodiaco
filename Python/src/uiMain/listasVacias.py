from uiMain.valoresInconsistentes import ValoresInconsistentes


class ListasVacias(ValoresInconsistentes):

    def  __init__(self):
        super().__init__("Se encontró una lista vacía.")
        

    def corregir():
        return  "No tengo más habilidades que enseñarte"

    def mensaje():
        super().mensaje("Se encontró una lista vacia")