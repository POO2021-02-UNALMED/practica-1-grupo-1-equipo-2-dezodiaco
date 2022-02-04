from .errorAplicacion import ErrorAplicacion

class ValoresInconsistentes(ErrorAplicacion):
    
    def __init__(self):
        super().__init__("\nSe ha encontrado un valor inconsistente")

    def mensaje(self, mensaje):
        self.error = "\nNo se puede acceder con un valor inconsistente" + mensaje
        super().mensaje(self.error)
