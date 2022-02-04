'''
Personajes principales y enemigos

Autores: Camilo, Edwin, Yeferson
'''

from functools import partial
import random
from gestorAplicacion.personajes.dios import castigar
from gestorAplicacion.artefactos.tesoro import mostrarTesoro
from tkinter import *
from tkinter import messagebox
from gestorAplicacion.complementario.clases import Clases
from gestorAplicacion.complementario.combate import cambioVida
from gestorAplicacion.artefactos.objeto import Objeto
from gestorAplicacion.complementario.tipoDeObjeto import TipoDeObjeto
from gestorAplicacion.complementario.tipoHabilidad import TipoHabilidad
from gestorAplicacion.complementario.habilidad import Habilidad
from gestorAplicacion.complementario.tipoEfecto import TipoEfecto
import math
from gestorAplicacion.personajes.herrero import Herrero
from uiMain.totemNulo import TotemNulo



class Peleador:

    _enemigosDerrotados = []
    _cofre = []
    _almacen = []
    _materiales = {"Fuente magna":8,"Cuarzo blanco":8,"Runa mítica":8,"Ojo encantado":8,"Cromo mejorado":8,"Lagrima de dios":8,"Protección arcana":8,"Zafiro refinado":8,"Reliquia sagrada":8}
    
    def __init__(self, clase, nombre,vida = 0, ataqueFisico = 0, ataqueMagico = 0, defensaFisica = 0, defensaMagica = 0, arma = None, armadura = None, anillo = None, oro = 0,habilidades = None, fragmentos =4):
        self._clase = clase
        self._fragmentos = fragmentos
        pocionSalud = Objeto("Poción de salud",Habilidad(TipoHabilidad.SANACION,"Sanar",10,0,0,0,TipoEfecto.NULO,True),0,TipoDeObjeto.POCION,0,0,0,0,0,False,None)
        self._nombre = nombre
        self._habilidades = habilidades
        self._pociones = [pocionSalud,pocionSalud]
        self._materiales = []
        self._inventario = []
        self._enfriamientos = [0,0,0,0,0]
        self._totem = None
        self._efectos = [0,0,0,0,0]
        
        anillo = Objeto("Anillo de principiante",None, 5, TipoDeObjeto.ANILLO, 2,2,0,0,1, False,"anillo5.png")

        if clase == Clases.ARQUERO:
            self._vida = 13
            self._ataqueFisico = 25
            self._ataqueMagico = 25
            self._defensaFisica = 15
            self._defensaMagica = 15
            self._estadoInicial = [100,25,25,15,15]            
            self._arma = Objeto("Chino",None,10,TipoDeObjeto.ARCO,10,0,0,0,3,False,"arco4.png")
            self._armadura = Objeto("Chaleco de oso",None,10,TipoDeObjeto.ARMADURA,0,0,15,10,3,False,"arm1.png")
            self._anillo = anillo 
            self._oro = 100
        elif clase == Clases.BRUJO:
            self._vida = 100
            self._ataqueFisico = 20
            self._ataqueMagico = 40
            self._defensaFisica = 10
            self._defensaMagica = 17
            self._estadoInicial = [100,20,40,10,17]
            self._arma = Objeto("Altimor",None,10,TipoDeObjeto.VARITA,5,15,0,0,5,False,"varita1.png")
            self._armadura = Objeto("Túnica negra",None,10,TipoDeObjeto.ARMADURA,0,0,7,15,3,False,"arm1.png")
            self._anillo = anillo
            self._oro = 100
        elif clase == Clases.GUERRERO:
            self._vida = 131
            self._ataqueFisico = 352
            self._ataqueMagico = 13
            self._defensaFisica = 18
            self._defensaMagica = 12
            self._estadoInicial = [100,35,13,18,12]
            self._arma = None#Objeto("Draco",None,10,TipoDeObjeto.LANZA,10,0,0,0,3,False,"lanza1.png")
            self._armadura = None#Objeto("Malla de acero",None,10,TipoDeObjeto.ARMADURA,0,0,15,10,3,False,"arm1.png")
            self._anillo = anillo
            self._oro = 100
        else: #clase == Clases.ENEMIGO:
            self._vida = vida
            self._ataqueFisico = ataqueFisico
            self._ataqueMagico = ataqueMagico
            self._defensaFisica = defensaFisica
            self._defensaMagica = defensaMagica
            self._anillo = anillo
            self._arma = arma
            self._armadura = armadura
            self._estadoInicial = [vida,ataqueFisico,ataqueMagico,defensaFisica,defensaMagica]


    def getClase(self):
        return self._clase

    def getFragmentos(self):
        return self._fragmentos

    def setFragmentos(self, fragmentos):
        self._fragmentos = fragmentos

    def setInventario(self,inventario):
        self._inventario = inventario

    @staticmethod
    def getCofre():
        return Peleador._cofre

    @staticmethod
    def getAlmacen():
        return Peleador._almacen

    def getVida(self):
        return self._vida

    def setVida(self, vida):
        self._vida = vida

    @staticmethod
    def setCofre(cofre):
        Peleador._cofre = cofre

    @staticmethod
    def setAlmacen(almacen):
        Peleador._almacen = almacen

    @staticmethod
    def getMateriales():
        return Peleador._materiales    

    def getAtaqueFisico(self):
        return self._ataqueFisico

    def setAtaqueFisico(self, ataqueFisico):
        self._ataqueFisico = ataqueFisico

    def getAtaqueMagico(self):
        return self._ataqueMagico

    def setAtaqueMagico(self, ataqueMagico):
        self._ataqueMagico = ataqueMagico

    def getDefensaFisica(self):
        return self._defensaFisica

    def setDefensaFisica(self, defensaFisica):
        self._defensaFisica = defensaFisica

    def getDefensaMagica(self):
        return self._defensaMagica

    def setDefensaMagica(self, defensaMagica):
        self._defensaMagica = defensaMagica

    def getArma(self):
        return self._arma

    def setArma(self, arma):
        self._arma = arma

    def getArmadura(self):
        return self._armadura

    def setArmadura(self, armadura):
        self._armadura = armadura

    def getAnillo(self):
        return self._anillo

    def setAnillo(self, anillo):
        self._anillo = anillo

    def getOro(self):
        return self._oro

    def setOro(self, oro):
        self._oro = oro

    def getHabilidades(self):
        return self._habilidades
    
    def agregarHabilidad(self,habilidad):
        self._habilidades.append(habilidad)

    def setHabilidad(self,habilidades):
        self._habilidades = habilidades

    def getNombre(self):
        return self._nombre

    def setNombre(self,nombre):
        self._nombre = nombre    

    def getInventario(self):
        return self._inventario

    def agregarObjeto(self, objeto):
        if len(self._inventario) < 12:
            self._inventario.append(objeto)
        else:
            Peleador._cofre.append(objeto)
            messagebox.showinfo(title="Notificación",message="No tienes suficiente espacio para recibir este objeto\n"+"Pacho te hace el favor de guardarlo en su cofre")


    def getPociones(self):
        return self._pociones

    def getEnfriamientos(self):
        return self._enfriamientos    

    def agregarPocion(self, pocion):
        self._pociones.append(pocion)
    
    def seleccionarObjeto(self, indiceObjeto ):
        return self._inventario[indiceObjeto]

    def getEstadoInicial(self):
        return self._estadoInicial    

    #equipa un arma
    def equiparArma(self, arma):
        mensaje = ""
        if self._clase == Clases.ARQUERO and (arma.getTipo() == TipoDeObjeto.BALLESTA or arma.getTipo() == TipoDeObjeto.ARCO):
            self._inventario.append(arma)
            self._arma = arma
            self._inventario.remove(arma)
        elif self._clase == Clases.BRUJO and (arma.getTipo() == TipoDeObjeto.BASTON or arma.getTipo() == TipoDeObjeto.VARITA):
            self._inventario.append(arma)
            self._arma = arma
            self._inventario.remove(arma)
        elif self._clase == Clases.GUERRERO and (arma.getTipo() == TipoDeObjeto.LANZA or arma.getTipo() == TipoDeObjeto.ESPADA):
            self._inventario.append(self.arma)
            self._arma = arma
            self._inventario.remove(arma)
        else:
            mensaje = "No puedes equiparte este tipo de objeto"
        return mensaje
    
    #equipa una armadura
    def equiparArmadura(self, armadura):
        if armadura.getTipo() == TipoDeObjeto.ARMADURA:
            self._inventario.append(self.armadura)
            self._armadura = armadura
            self._inventario.remove(armadura)
	
	#Equipa un anillo
    def equiparAnillo(self, anillo):
        if anillo.getTipo() == TipoDeObjeto.ANILLO: 
            self._inventario.append(self.anillo)
            self._anillo = anillo
            self._inventario.remove(anillo)
    
    def getTotem(self):
        return self._totem

    def setTotem(self, totem):
        self._totem= totem
	
	#Reemplazar una habilidad por otra
    def cambiarHabilidad(self, indice, habilidad):
        self._habilidades[indice] == habilidad
    
    def __str__(self):
        nombreTotem = ""
        try:
            if self.getTotem() is None:
                raise TotemNulo
            else:
                nombreTotem = self.getTotem().getNombre()
        except TotemNulo:
            nombreTotem = TotemNulo.corregir()

        af = self.getAtaqueFisico()
        am = self.getAtaqueMagico()
        df = self.getDefensaFisica()
        dm = self.getDefensaMagica()

        if self._anillo != None:
            af += self._anillo.getAtaqueFisico()
            am += self._anillo.getAtaqueMagico()
            df += self._anillo.getDefensaFisica()
            dm += self._anillo.getDefensaMagica()

        if self._arma != None:
            af += self._arma.getAtaqueFisico()
            am += self._arma.getAtaqueMagico()
            df += self._arma.getDefensaFisica()
            dm += self._arma.getDefensaMagica()
        
        if self._armadura != None:
            af += self._armadura.getAtaqueFisico()
            am += self._armadura.getAtaqueMagico()
            df += self._armadura.getDefensaFisica()
            dm += self._armadura.getDefensaMagica()

        texto = ("Estadísticas de \n" + self._nombre + ":\n \n" + "Clase " + self.getClase().name + "\n" + "Vida: " + str(self.getVida()) + 
        "\nAtaque Físico: " + str(af)+ "\n" + "Ataque Magico: " + str(am) + "\n" +"Defensa Fisica: " + str(df) + "\n" +"Defensa Mágica: " + str(dm)+ "\n" + 
        "Totem: " + nombreTotem + "\nOro: "+ str(self.getOro()))
	
        return texto

	
    def turnoEnemigo(self,combate,personaje):

        messagebox.showinfo(title="Cambio",message="Turno del enemigo")
        personaje.aplicarEfectos(combate,self)

        if self.getVida() <=0:   # Verifica si los efectos mataron al enemigo 
            personaje.verificarMuerte(combate,self)
            return

        elegir = random.randint(1,10)

        if elegir >= 7: # 40% de las veces el enemigo ejecuta un ataque básico
            self.ataqueFisico(combate,personaje)
            
        else:

            disponibles = []
            for i in range(5):
                if self._enfriamientos[i] == 0:
                    disponibles.append(i)
            print(disponibles)
            if len(disponibles) != 0:
                random.shuffle(disponibles)
                indiceHabilidad = disponibles[0]
                habilidad = self._habilidades[indiceHabilidad]
                self.ataqueMagico(combate,personaje,habilidad)
            else:
                self.ataqueFisico(combate,personaje)

        if combate.getTerminar() == False:
            messagebox.showinfo(title="Cambio",message="Es tu turno")
            marcoCombate = combate.getMarcoCombate()
            hijosCombate = marcoCombate.winfo_children()
            for i in hijosCombate:
                if type(i) == Button:
                    i.config(state=NORMAL)
            self.aplicarEfectos(combate,personaje)
            if personaje.getVida() <= 0:
                self.verificarMuerte(combate,personaje)
                

    def aplicarEfectos(self,combate,enemigo):
        suma = 0
        if self._efectos.count(0) != 5:     
            for i in range(5):
                if self._efectos[i] != 0:
                    suma += self._habilidades[i].getDanoEfecto()

            messagebox.showinfo(title="Aplicación de efectos",message=enemigo.getNombre()+ " sufre "+ str(suma)+" de daño por efectos")
            enemigo.setVida(enemigo.getVida()-suma)
            cambioVida(combate,enemigo)

            for i in range(5):  # Resta 1 a la duración de todos los efectos
                if self._efectos[i] != 0:
                    self._efectos[i] += -1                   
        

    def revivir(self):
        self._vida = self._estadoInicial[0]
        self._ataqueFisico = self._estadoInicial[1]
        self._ataqueMagico = self._estadoInicial[2]
        self._defensaFisica = self._estadoInicial[3]
        self._defensaFisica = self._estadoInicial[4]
        self._efectos = [0,0,0,0,0]
        self._enfriamientos = [0,0,0,0,0]


    def verificarMuerte(self,combate,enemigo):

        if  enemigo.getClase() == Clases.ENEMIGO:
            messagebox.showinfo(title="Fin combate",message="Has matado al enemigo "+enemigo.getNombre()+"\n Como agradecimiento, los dioses te permitirán abrir un tesoro del zodiaco")            
            self.revivir()
            enemigo.revivir()
            mostrarTesoro(combate,self)
            

        else:
            messagebox.showinfo(title="Fin combate",message="Te han derrotado\n"+"Los dioses se enfurecen y desatan su ira sobre tu equipo")
            self.revivir()
            enemigo.revivir()
            combate.setTerminar(True)
            castigar(combate,enemigo)

	
	#Ataque físico
    def ataqueFisico(self,combate,enemigo):   
        marcoCombate = combate.getMarcoCombate()
        hijosCombate = marcoCombate.winfo_children()
        for i in hijosCombate:
            if type(i) == Button:
                i.config(state=DISABLED)

        try:
            ataqueAnillo = self._anillo.getAtaqueFisico()        
        except AttributeError:
            ataqueAnillo = 0

        try:
            ataqueArma = self._arma.getAtaqueFisico()        
        except AttributeError:
            ataqueArma = 0    

        try:
            ataqueArmadura= self._armadura.getAtaqueFisico()        
        except AttributeError:
            ataqueArmadura = 0

        dañoPropio = self.getAtaqueFisico() + ataqueAnillo + ataqueArma + ataqueArmadura
        defensaEnemiga = enemigo.getDefensaFisica()
        dañoFisicoNeto = math.floor(dañoPropio-(defensaEnemiga*1.5)) # Los ataques básicos sufren reducción de daño por la armadura física del enemigo
        if dañoFisicoNeto>0:
            enemigo.setVida(enemigo.getVida()-dañoFisicoNeto)
            messagebox.showinfo(title="Daño ataque",message=self.getNombre()+" golpea a "+enemigo.getNombre()+" y le inflige "+str(dañoFisicoNeto)+" de daño")
            cambioVida(combate,enemigo)   # Aquí termina el turno del atacante
        else:
            messagebox.showinfo(title="Daño ataque",message=self.getNombre() +" lanza un ataque pero "+enemigo.getNombre()+" lo bloquea")


        if enemigo.getVida() <=0:
            self.verificarMuerte(combate,enemigo)
            return

        reducirEnfriamiento(enemigo)   #  Modifica los enfriamientos del enemigo, pues ya sigue su turno    
        if enemigo.getClase() == Clases.ENEMIGO: 
            enemigo.turnoEnemigo(combate,self)

        
           
               


	#Ataque mágico
    def ataqueMagico(self,combate, enemigo, habilidad):

        indice = self._habilidades.index(habilidad)

        if habilidad.isAutoDirigida():
            habilidad.modificarEstadistica(self)
            messagebox.showinfo(title="Lanzamiento",message=self.getNombre()+" se lanza la habilidad "+habilidad.getNombre()+"\n"+habilidad.__str__())
            if habilidad.getTipo() == TipoHabilidad.SANACION:
                cambioVida(combate,self)

        elif habilidad.getEfecto() != TipoEfecto.NULO:
            
            anilloAtaque = 0
            armaAtaque = 0
            armaduraAtaque = 0
            if self._anillo != None:
                anilloAtaque = self._anillo.getAtaqueMagico()
            if self._arma != None:
                armaAtaque = self._arma.getAtaqueMagico()
            if self._armadura != None:
                armaduraAtaque = self._armadura.getAtaqueMagico()    

            dañoHabilidad = habilidad.getModificador() + self._ataqueMagico + anilloAtaque + armaduraAtaque + armaAtaque
            defensaEnemiga = enemigo.getDefensaMagica()
            dañoMagicoNeto = math.floor(dañoHabilidad-(defensaEnemiga*1.3)) # El daño de habilidades sufre reducción de daño por la armadura mágica del enemigo
            
            if habilidad.getEfecto() == TipoEfecto.QUEMAR or habilidad.getEfecto() == TipoEfecto.ENVENENAR: 
                self._efectos[indice] = habilidad.getDuracion()

            if dañoMagicoNeto>0: 
                enemigo.setVida(enemigo.getVida()-dañoMagicoNeto)
                messagebox.showinfo(title="Daño habilidad",message=self.getNombre()+" lanza la habilidad "+habilidad.getNombre()+" sobre "+enemigo.getNombre()+" causando "+str(dañoMagicoNeto)+" de daño y aplica un efecto negativo")
                cambioVida(combate,enemigo)
                
            else:
                messagebox.showinfo(title="Daño habilidad",message=self.getNombre()+" lanza la habilidad "+habilidad.getNombre()+", pero "+enemigo.getNombre()+" resiste el daño de la habilidad, aunque recibe su efecto")    
                

        else:
            messagebox.showinfo(title="Lanzamiento",message=self.getNombre()+" lanza la habilidad "+habilidad.getNombre()+"\n"+habilidad.__str__())
            habilidad.modificarEstadistica(enemigo)
            cambioVida(combate,enemigo)


        if enemigo.getVida() <=0:
            self.verificarMuerte(combate,enemigo)
            return

        self._enfriamientos[indice] = habilidad.getEnfriamiento() # Pone la habilidad en enfriamiento

        reducirEnfriamiento(enemigo)    # Reduce el enfriamiento del siguiente peleador

        if enemigo.getClase() == Clases.ENEMIGO:   # Si ataca el usuario sigue el turno del enemigo
            enemigo.turnoEnemigo(combate,self)
            
            

	
	# lanza un ataque
    def lanzarAtaque(self, enemigo):
        enemigo.setVida(enemigo.getVida()-self.atacar(enemigo))
        messagebox
	
        
  
    def lanzarHabilidad(self,combate,marcoHabis,habilidad,enemigo):
        botones = marcoHabis.winfo_children()
        for i in botones:
            i.config(state=DISABLED)
        self.ataqueMagico(combate,enemigo,habilidad)
        marcoHabis.place_forget()
        combate.getMarcoCombate().place(x=0,y=400)

    def activarPocion(self,combate,marcoPociones,pocion,enemigo):
        hijos = marcoPociones.winfo_children()
        for i in hijos:
            i.config(state=DISABLED)
        self.usarPocion(combate,pocion,enemigo)
        self.getPociones().remove(pocion)
        marcoPociones.place_forget()
        combate.getMarcoCombate().place(x=0,y=400)    


    def getPociones(self):
        return self._pociones
	

    def setPociones(self, pociones):
        self._pociones = pociones
    
    def usarPocion(self,combate,pocion,enemigo):
        if pocion.getHechizo().isAutoDirigida():
            messagebox.showinfo(title="Efecto de poción",message=self.getNombre()+" emplea "+pocion.getNombre()+" sobre sí mismo y libera el hechizo que contiene\n"+pocion.getHechizo().__str__())
            pocion.getHechizo().modificarEstadistica(self)
            cambioVida(combate,self)
            enemigo.turnoEnemigo(combate,self)
            
        else:
            messagebox.showinfo(title="Efecto de poción",message=self.getNombre()+" emplea la "+pocion.getNombre()+" sobre "+enemigo.getNombre +" y libera el hechizo que contiene\n"+pocion.getHechizo().__str__())
            pocion.getHechizo().modificarEstadistica(enemigo)    
            cambioVida(combate,enemigo)
            enemigo.turnoEnemigo(combate,self)

    def getEnemigosDerrotados(self):
        return self._enemigosDerrotados
	

    def setEnemigosDerrotados(self, enemigosDerrotados):
        self._enemigosDerrotados = enemigosDerrotados
        

	#Aprende una habilidad de un dios
    def aprenderHabilidad(self, entidad, habilidad):
        entidad.enseñarHabilidad(self,habilidad)
        return entidad.hablar()
	
	

    def setMateriales(self, materiales):
        self.materiales = materiales
	
	#agrega un objeto al inventario
    def equiparObjeto(self, objeto):
        if self.__clase == Clases.ARQUERO and (objeto.getTipo() == TipoDeObjeto.BALLESTA or objeto.getTipo() == TipoDeObjeto.ARCO):
            self._inventario.append(objeto)
		
        if self._clase == Clases.BRUJO and (objeto.getTipo() == TipoDeObjeto.BASTON or objeto.getTipo() == TipoDeObjeto.VARITA):
            self._inventario.append(objeto)
        
        if self._clase == Clases.GUERRERO and (objeto.getTipo() == TipoDeObjeto.LANZA or objeto.getTipo() == TipoDeObjeto.ESPADA):
            self._inventario.append(objeto)
	
	

def reducirEnfriamiento(personaje):
    if personaje._enfriamientos.count(0) != 5:
        for i in range(5):
            if personaje._enfriamientos[i] != 0:
                personaje._enfriamientos[i] += -1

    

def volverCamino(ventana,marcoInventario):
    marcoInventario.place_forget()
    listaFrames = ventana.winfo_children()
    listaFrames[2].place(x=0,y=0)