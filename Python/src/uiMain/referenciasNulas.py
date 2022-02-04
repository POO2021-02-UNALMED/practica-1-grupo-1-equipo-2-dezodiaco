from .errorAplicacion import ErrorAplicacion

class ReferenciasNulas(ErrorAplicacion):
    
    def __init__(self, mensaje):
        super().__init__("\nNo se puede hacer referencia a objetos nulos" + mensaje)

    def mensaje(self, mensaje):
        self.error = "\nNo se puede hacer referencia a objetos nulos" + mensaje
        super().mensaje(self.error)
