class ErrorAplicacion(Exception):
    
    def __init__(self, mensaje):
        self.error = "Manejo de errores de la Aplicacion" + mensaje
        super().__init__(self.error)

    def mensaje(self, mensaje):
        self.error = "Manejo de errores de la Aplicacion" + mensaje
        return self.error
