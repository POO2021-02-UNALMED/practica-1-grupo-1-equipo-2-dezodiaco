'''
Interfaz del usuario, se crean las instancias bases para el desarrollo del juego 
y se presentan los distintos menus del juego.

Autores: Yeferson, Camilo, Edwin.
'''

from functools import partial
import math
import os
from tkinter import *
from tkinter import messagebox
import tkinter.font as tkFont
from tkinter.ttk import Combobox
import random
import pickle as pk
from gestorAplicacion.complementario.combate import Combate
from gestorAplicacion.personajes.herrero import Herrero
from gestorAplicacion.personajes.peleador import Peleador
from gestorAplicacion.complementario.habilidad import Habilidad
from gestorAplicacion.personajes.dios import Dios
from gestorAplicacion.complementario.nodo import Nodo
from gestorAplicacion.artefactos.objeto import Objeto
from gestorAplicacion.artefactos.tesoro import Tesoro
from gestorAplicacion.complementario.tipoDeObjeto import TipoDeObjeto
from gestorAplicacion.complementario.clases import Clases
from gestorAplicacion.complementario.tipoHabilidad import TipoHabilidad
from gestorAplicacion.complementario.tipoEfecto import TipoEfecto
from gestorAplicacion.personajes.totem import Totem
from gestorAplicacion.personajes.sabio import Sabio
from uiMain.eventos import *



if __name__ == "__main__":

    #Creación de la ventana principal
    Ventana_inicio = Tk()
    Ventana_inicio.resizable(width=0, height=0)
    Ventana_inicio.title("Desafio del Zodiaco")
    Ventana_inicio.iconbitmap('./imagenes/Icono_principal.ico')
    Ventana_inicio.option_add('*tearOff', False)


    #Fuentes para el juego
    Fuente1 = tkFont.Font(family="Times New Roman", size=14, weight="bold", slant="italic")
    Fuente_base = tkFont.Font(family="Comic Sans MS", size=11 )
    Fuente_base2 = tkFont.Font(family="Calibri", size=13, slant="italic")
    Fuente_base3 = tkFont.Font(family="Times New Roman", size=14, weight="bold", slant="italic")
    Fuente_botones = tkFont.Font(family="Arial", size=10, weight="bold",slant="italic")
    Fuente_botones2 = tkFont.Font(family="Arial", size=16, weight="bold",slant="italic")


    #Frame bases ventana principal
    P1 = Frame(master = Ventana_inicio,borderwidth=1,relief="solid",bg="ivory3")
    P2 = Frame(master = Ventana_inicio,borderwidth=1,relief="solid",bg="ivory3")
    P1.grid(row=0,column=0,columnspan=2,padx=5, pady= 10)
    P2.grid(row=0,column=2,columnspan=2,padx=5, pady= 10)

    #Frame bienvenida y hojas de vida
    P3 = Frame(master = P1,height=206,width=398,borderwidth=1,relief="solid")
    P4 = Frame(master = P1,height=300,width=398,borderwidth=1,relief="solid")
    P3.grid(row=0,column=0,padx=5, pady= 5)
    P4.grid(row=1,column=0, pady= 5)

    #Frame fotos e imágenes
    P5 = Frame(master = P2,height=206,width=398,borderwidth=1,relief="solid")
    P6 = Frame(master = P2,height=300,width=398,borderwidth=1,relief="solid")

    P5.grid(row=0,column=0,padx=5, pady= 5)
    P6.grid(row=1,column=0, pady= 5)

    #Imágenes P6
    label1_1 = Label(P6)
    imagen1_1 = PhotoImage(file='.\imagenes\imagenC1.png')
    label1_1['image'] = imagen1_1
    label1_1.grid(row=0,column=0, padx=35, pady=2)

    label1_2 = Label(P6)
    imagen1_2 = PhotoImage(file='.\imagenes\imagenC2.png')
    label1_2['image'] = imagen1_2
    label1_2.grid(row=0,column=1, padx=35, pady=2)

    label1_3 = Label(P6)
    imagen1_3 = PhotoImage(file='.\imagenes\imagenC3.png')
    label1_3['image'] = imagen1_3
    label1_3.grid(row=1,column=0, padx=35, pady=2)

    label1_4 = Label(P6)
    imagen1_4= PhotoImage(file='.\imagenes\imagenC4.png')
    label1_4['image'] = imagen1_4
    label1_4.grid(row=1,column=1, padx=35, pady=2)


    label2_1 = Label(P6)
    imagen2_1 = PhotoImage(file='.\imagenes\imagenA1.png')
    label2_1['image'] = imagen2_1

    label2_2 = Label(P6)
    imagen2_2 = PhotoImage(file='.\imagenes\imagenA2.png')
    label2_2['image'] = imagen2_2

    label2_3 = Label(P6)
    imagen2_3 = PhotoImage(file='.\imagenes\imagenA3.png')
    label2_3['image'] = imagen2_3

    label2_4 = Label(P6)
    imagen2_4= PhotoImage(file='.\imagenes\imagenA4.png')
    label2_4['image'] = imagen2_4

    label3_1 = Label(P6)
    imagen3_1 = PhotoImage(file='.\imagenes\imagenE1.png')
    label3_1['image'] = imagen3_1

    label3_2 = Label(P6)
    imagen3_2 = PhotoImage(file='.\imagenes\imagenE2.png')
    label3_2['image'] = imagen3_2

    label3_3 = Label(P6)
    imagen3_3 = PhotoImage(file='.\imagenes\imagenE3.png')
    label3_3['image'] = imagen3_3

    label3_4 = Label(P6)
    imagen3_4= PhotoImage(file='.\imagenes\imagenE4.png')
    label3_4['image'] = imagen3_4


    Mensaje_Bienvenida = Label(P3,text=Bienvenida , justify=LEFT,width=43,height=9, font=Fuente_base)
    Mensaje_Bienvenida.place(x=0,y=0)

    #Funciones para el cambio de hoja de vida
    def cambioHoja1():
        boton1.place_forget()
        boton2.place(x=0,y=0)
        label1_1.grid_forget()
        label1_2.grid_forget()
        label1_3.grid_forget()
        label1_4.grid_forget()
        label2_1.grid(row=0, column=0, padx=35, pady=2)
        label2_2.grid(row=0, column=1, padx=35, pady=2)
        label2_3.grid(row=1, column=0, padx=35, pady=2)
        label2_4.grid(row=1, column=1, padx=35, pady=2)

    def cambioHoja2():
        boton2.place_forget()
        boton3.place(x=0,y=0)
        label2_1.grid_forget()
        label2_2.grid_forget()
        label2_3.grid_forget()
        label2_4.grid_forget()
        label3_1.grid(row=0, column=0, padx=35, pady=2)
        label3_2.grid(row=0, column=1, padx=35, pady=2)
        label3_3.grid(row=1, column=0, padx=35, pady=2)
        label3_4.grid(row=1, column=1, padx=35, pady=2)

    def cambioHoja3():
        boton3.place_forget()
        boton1.place(x=0,y=0)
        label3_1.grid_forget()
        label3_2.grid_forget()
        label3_3.grid_forget()
        label3_4.grid_forget()
        label1_1.grid(row=0, column=0, padx=35, pady=2)
        label1_2.grid(row=0, column=1, padx=35, pady=2)
        label1_3.grid(row=1, column=0, padx=35, pady=2)
        label1_4.grid(row=1, column=1, padx=35, pady=2)

    #hojas de vida individuales
    boton1 = Button(P5, text=Camilo, command=cambioHoja1, justify=LEFT,width=43,height=9, font=Fuente_base2)
    boton2 = Button(P5, text=Andres, command=cambioHoja2, justify=LEFT,width=43,height=9, font=Fuente_base2)
    boton3 = Button(P5, text=Edwin, command=cambioHoja3, justify=LEFT,width=43,height=9,font =Fuente_base2)

    boton1.place(x=0,y=0)

    #funciones para el cambio de las imágenes del juego
    def cambiarImagen1():
        BotonP4_1.place_forget()
        BotonP4_2.place(x=15,y=2)

    def cambiarImagen2():
        BotonP4_2.place_forget()
        BotonP4_3.place(x=15,y=2)

    def cambiarImagen3():
        BotonP4_3.place_forget()
        BotonP4_4.place(x=15,y=2)

    def cambiarImagen4():
        BotonP4_4.place_forget()
        BotonP4_5.place(x=15,y=2)

    def cambiarImagen5():
        BotonP4_5.place_forget()
        BotonP4_1.place(x=15,y=2)

    #Imágenes del juego
    labelP4_1 = Label(P4)
    imagenP4_1 = PhotoImage(file='.\imagenes\p41.png')
    BotonP4_1 = Button(P4, text="", image=imagenP4_1, command= cambiarImagen1)
    BotonP4_1.place(x=15,y=2)

    labelP4_2 = Label(P4)
    imagenP4_2 = PhotoImage(file='.\imagenes\p42.png')
    BotonP4_2 = Button(P4, text="", image=imagenP4_2, command= cambiarImagen2)

    labelP4_3 = Label(P4)
    imagenP4_3 = PhotoImage(file='.\imagenes\p43.png')
    BotonP4_3 = Button(P4, text="", image=imagenP4_3, command= cambiarImagen3)

    labelP4_4 = Label(P4)
    imagenP4_4 = PhotoImage(file='.\imagenes\p44.png')
    BotonP4_4 = Button(P4, text="", image=imagenP4_4, command= cambiarImagen4)

    labelP4_5 = Label(P4)
    imagenP4_5 = PhotoImage(file='.\imagenes\p45.png')
    BotonP4_5 = Button(P4, text="", image=imagenP4_5, command= cambiarImagen5)

    #lectura de las imágenes para los fondos
    fondoSabio = PhotoImage(file='./imagenes/sabio0.png')
    imagenCamino = PhotoImage(file="./imagenes/caminoDoce.png")
    imagenFondo = PhotoImage(file="./imagenes/fondoInicial.png")
    fondoNombre = PhotoImage(file="./imagenes/fondoNombre2.png")
    fondoSabio2 = PhotoImage(file='./imagenes/sabio01.png')
    fondoSabio3 = PhotoImage(file='./imagenes/sabio2.png')
    fondoSabio4 = PhotoImage(file='./imagenes/sabio3.png')
    fondoAtributos = PhotoImage(file='./imagenes/fondoAtributos.png')
    fondoMisiones = PhotoImage(file='./imagenes/fondoMisiones.png')
    fondoInventario = PhotoImage(file="./images/inventario.png")
    imagenFondo = PhotoImage(file="./images/fondoInicial.png")
    imagenNombre = PhotoImage(file="./images/fondoNombre2.png")
    imagenCamino = PhotoImage(file="./images/caminoDoce.png")
    imagenNodo = PhotoImage(file='./images/fondonodo.png')
    cerrar = PhotoImage(file='.\imagenes\cerrar.png')

    #lectura de las imágenes de los Totems
    imagenTotem1 = PhotoImage(file='.\imagenes\Totem1.png')
    imagenTotem2 = PhotoImage(file='.\imagenes\Totem2.png')
    imagenTotem3 = PhotoImage(file='.\imagenes\Totem3.png')
    imagenTotem4 = PhotoImage(file='.\imagenes\Totem4.png')
    imagenTotem5 = PhotoImage(file='.\imagenes\Totem5.png')
    Lista_imagenesTotems = [imagenTotem1,imagenTotem2,imagenTotem3,imagenTotem4,imagenTotem5]

    personaje = None
    numClase = 0




    def e1():

        Ventana_inicio.iconify()
        ventana = Toplevel()
        ventana.resizable(width=0, height=0)


        dicImages = {}
        llaves = ["anillo","espada","lanza","arm","arco","ballesta","baston","varita"]
        for i in llaves:
            for j in ["1","2","3","4"]:
                dicImages[i+j+".png"] = PhotoImage(file="./images/iconos/"+i+j+".png")

        dicImages["anillo5.png"] = PhotoImage(file="./images/iconos/anillo5.png")

        def consultarInventario(personaje,ventana,frameActual,imagen):
            
            
            menu = ventana.nametowidget("menubar")
            menu.entryconfig("Acciones",state=DISABLED)

            posiciones = [[40,417],[149,417],[258,417],[367,417],[476,417],[585,417],[40,505],[149,505],[258,505],[367,505],[476,505],[585,505]]
            frameActual.place_forget()    
            marcoInventario = Frame(ventana,width=700,height=600)
            marcoInventario.place(x=0,y=0)

            
            fondo = Label(marcoInventario,image=imagen)
            fondo.place(x=0,y=0)

            botonVolver = Button(marcoInventario, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver2(frameActual,marcoInventario), bg="black")
            botonVolver.place(x=650, y=15)

            

            # Labels atributos
            
            nombreObjeto = Label(marcoInventario,text="",fg="white",bg="blue",font=("Arial",12))
            nombreObjeto.place(x=183,y=100)
            atributo1 = Label(marcoInventario,text="",fg="white",bg="blue",font=("Arial",17))
            atributo1.place(x=313,y=130)
            atributo2 = Label(marcoInventario,text="",fg="white",bg="blue",font=("Arial",17))
            atributo2.place(x=313,y=166)
            atributo3 = Label(marcoInventario,text="",fg="white",bg="blue",font=("Arial",17))
            atributo3.place(x=313,y=201)
            atributo4 = Label(marcoInventario,text="",fg="white",bg="blue",font=("Arial",17))
            atributo4.place(x=313,y=238)
            atributo5 = Label(marcoInventario,text="",fg="white",bg="blue",font=("Arial",17))
            atributo5.place(x=313,y=268)
             
            
            armaduraPuesta = personaje.getArmadura()
            armaduraInicial = armaduraPuesta

            armaPuesta = personaje.getArma()
            armaInicial = armaPuesta

            anilloPuesto = personaje.getAnillo()
            anilloInicial = anilloPuesto

            
            if armaduraInicial == None:
                armadura = Label(marcoInventario,bg="black")
            else:
                armadura = Label(marcoInventario,bd=0,image= dicImages[armaduraInicial.getIcono()])

            armadura.place(x=526,y=129)

            if armaInicial == None:
                arma = Label(marcoInventario,bg="black")
            else:
                arma = Label(marcoInventario,bd=0,image=dicImages[armaInicial.getIcono()])     
            arma.place(x=445,y=227)

            if anilloInicial == None:
                anillo = Label(marcoInventario,bg = "black")
            else:    
                anillo = Label(marcoInventario,bd=0,image=dicImages[anilloInicial.getIcono()])
            anillo.place(x=607,y=227)

            


            def verAtributos(event,objeto):
                if objeto != None: 
                    if objeto.getTipo().value[0] <=2:
                        nombre = objeto.getTipo().value[1] +" "+ objeto.getNombre()
                    else:
                        nombre = objeto.getNombre()    
                    ataque1 = objeto.getAtaqueFisico()
                    ataque2 = objeto.getAtaqueMagico()
                    defensa1 = objeto.getDefensaFisica()
                    defensa2 = objeto.getDefensaMagica()
                    durabilidad = objeto.getDurabilidad()
                    nombreObjeto.configure({"text":nombre})
                    atributo1.configure({"text":str(ataque1)})
                    atributo2.configure({"text":str(ataque2)})
                    atributo3.configure({"text":str(defensa1)})
                    atributo4.configure({"text":str(defensa2)})
                    atributo5.configure({"text":str(durabilidad)})
                

            verArma = partial(verAtributos,objeto = armaInicial)
            verArmadura = partial(verAtributos,objeto = armaduraInicial)
            verAnillo = partial(verAtributos,objeto = anilloInicial)

            arma.bind("<Button -1>",verArma)
            armadura.bind("<Button -1>",verArmadura)
            anillo.bind("<Button -1>",verAnillo)


            iconos = []


            if len(personaje.getInventario()) >0:
                for i in range(len(personaje.getInventario())):
                    objetoInventario = personaje.getInventario()[i]
                    imobjeto = Label(marcoInventario,bd=0,image=dicImages[objetoInventario.getIcono()])
                    imobjeto.place(x=posiciones[i][0],y=posiciones[i][1])
                    iconos.append([imobjeto,objetoInventario])

                
                for i in range(len(iconos)):
                    ver = partial(verAtributos,objeto = personaje.getInventario()[i])   
                    iconos[i][0].bind("<Button -1>",ver)

            
            objetos = [[arma,armaInicial],[armadura,armaduraInicial],[anillo,anilloInicial]] + iconos
            



            def cambioAnillo(event,anilloDeseado):
                xpos = int(anilloDeseado[0].place_info()["x"])
                ypos= int(anilloDeseado[0].place_info()["y"])

                anilloActual = objetos[2]
                imagenActual = anilloActual[0]
                imagenActual.place_forget()
                imagenActual.place(x=xpos,y=ypos)
                anilloDeseado[0].place_forget()
                anilloDeseado[0].place(x=607,y=227)
                indiceNuevo = objetos.index(anilloDeseado)
                objetos[2]=objetos[indiceNuevo]
                objetos[indiceNuevo] = anilloActual
                personaje.setAnillo(anilloDeseado[1])
                if anilloActual[1] != None:
                    personaje.getInventario()[indiceNuevo-3]=anilloActual[1]
                else: 
                    personaje.getInventario().remove(anilloDeseado[1])
                    

            def cambioArma(event,armaDeseada):
                if armaDeseada[1].getTipo().value[0]== personaje._clase.value:
                    xpos = int(armaDeseada[0].place_info()["x"])
                    ypos= int(armaDeseada[0].place_info()["y"])

                    armaActual = objetos[0]
                    imagenActual = armaActual[0]
                    imagenActual.place_forget()
                    imagenActual.place(x=xpos,y=ypos)
                    armaDeseada[0].place_forget()
                    armaDeseada[0].place(x=445,y=227)
                    indiceNuevo = objetos.index(armaDeseada)
                    objetos[0]=objetos[indiceNuevo]
                    objetos[indiceNuevo] = armaActual
                    personaje.setArma(armaDeseada[1])

                    if armaActual[1] != None:
                        personaje.getInventario()[indiceNuevo-3]=armaActual[1]
                    else:
                        personaje.getInventario().remove(armaDeseada[1])            
                else:
                    messagebox.showinfo(title="Informar",message="¡No puedes equiparte este tipo de objeto!")
                
                    



            def cambioArmadura(event,armaduraDeseada):
                xpos = int(armaduraDeseada[0].place_info()["x"])
                ypos= int(armaduraDeseada[0].place_info()["y"])

                armaduraActual = objetos[1]
                imagenActual = armaduraActual[0]
                imagenActual.place_forget()
                imagenActual.place(x=xpos,y=ypos)
                armaduraDeseada[0].place_forget()
                armaduraDeseada[0].place(x=526,y=129)
                indiceNuevo = objetos.index(armaduraDeseada)
                objetos[1]=objetos[indiceNuevo]
                objetos[indiceNuevo] = armaduraActual
                personaje.setArmadura(armaduraDeseada[1])
                if armaduraActual[1] != None:  # Si no es nulo pone el objeto equipado en el inventario 
                    personaje.getInventario()[indiceNuevo-3]=armaduraActual[1]
                else:
                    personaje.getInventario().remove(armaduraDeseada[1])   # Si es nulo remueve el objeto del inventario porque no hay objeto equipado

               

            # Binding los objetos equipados y del inventario
            for i in range(len(objetos)):
                if objetos[i][1] != None:    
                    if objetos[i][1].getTipo() == TipoDeObjeto.ANILLO:
                        cambiarAnillo = partial(cambioAnillo,anilloDeseado = objetos[i])
                        objetos[i][0].bind("<Button -3>",cambiarAnillo)
                    elif objetos[i][1].getTipo() == TipoDeObjeto.ARMADURA:
                        cambiarArmadura = partial(cambioArmadura,armaduraDeseada = objetos[i])
                        objetos[i][0].bind("<Button -3>",cambiarArmadura)    
                    else:
                        cambiarArma = partial(cambioArma,armaDeseada = objetos[i])
                        objetos[i][0].bind("<Button -3>",cambiarArma)


        def mostrarObjetos(marcoInventario,almacen,lista,verificador):  
        
            posiciones = [[40,417],[149,417],[258,417],[367,417],[476,417],[585,417],[40,505],[149,505],[258,505],[367,505],[476,505],[585,505]]
            if len(almacen) >0:
                for i in range(len(almacen)):
                    objetoInventario = almacen[i]
                    imobjeto = Label(marcoInventario,bd=0,image=dicImages[objetoInventario.getIcono()])
                    imobjeto.place(x=posiciones[i][0],y=posiciones[i][1])
                    lista.append([imobjeto,objetoInventario])
           
        def volver(marcoHerrero, marcoActual): 
            marcoHerrero.place(x=0,y=0)
            marcoActual.place_forget()

        def volver2(marcoHerrero, marcoActual): 
            marcoHerrero.place(x=0,y=0)
            marcoActual.place_forget()    
            activarMenu()

        def comprar(ventana,marcoHerrero,herrero,personaje):
            
            
            marcoHerrero.place_forget()
            marcoComprar = Frame(ventana,width=700,height=600)
            marcoComprar.place(x=0,y=0)


            imagenComprar = herrero.getFondoComprar()
            fondo = Label(marcoComprar,image=imagenComprar)
            fondo.place(x=0,y=0)

            botonVolver = Button(marcoComprar, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver(marcoHerrero, marcoComprar), bg="black")
            botonVolver.place(x=650, y=15)

            nombreObjeto = Label(marcoComprar,text="",bg="#82137d",fg="white",font=("Arial",12))
            nombreObjeto.place(x=215,y=104)

            ataqueFisico = Label(marcoComprar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            ataqueFisico.place(x=350,y=137)

            ataqueMagico = Label(marcoComprar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            ataqueMagico.place(x=350,y=171)

            defensaFisica = Label(marcoComprar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            defensaFisica.place(x=350,y=208)

            defensaMagica = Label(marcoComprar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            defensaMagica.place(x=350,y=245)

            durabilidad = Label(marcoComprar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            durabilidad.place(x=350,y=280)

            precio = Label(marcoComprar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            precio.place(x=350,y=315)

            listaLabels = []


            def comprarObjeto(event,label,objeto):
                confirmarCompra = messagebox.askyesno(title="Verificación",message="¿Seguro que deseas comprar este objeto por "+str(objeto.getPrecio())+" de oro?")

                if confirmarCompra:
                    
                    if personaje.getOro() < objeto.getPrecio():
                        messagebox.showinfo(title="Alerta",message="No tienes oro suficiente para comprar este objeto")

                    elif len(personaje.getInventario()) == 12: # Revisar tema de materiales
                        messagebox.showwarning(title="Alerta",message="Tienes el inventario lleno, no puedes comprar este objeto")
                    
                    else:
                        personaje.getInventario().append(objeto)
                        personaje.setOro(personaje.getOro()-objeto.getPrecio())
                        herrero.getObjetos().remove(objeto)        
                        label.place_forget()


            def verAtributos(event,objeto):
                if objeto.getTipo().value[0] <=2:
                    nombre = objeto.getTipo().value[1] +" "+ objeto.getNombre()
                else:
                    nombre = objeto.getNombre()    
                ataque1 = objeto.getAtaqueFisico()
                ataque2 = objeto.getAtaqueMagico()
                defensa1 = objeto.getDefensaFisica()
                defensa2 = objeto.getDefensaMagica()
                duracion = objeto.getDurabilidad()
                valor = objeto.getPrecio()
                nombreObjeto.configure({"text":nombre})
                ataqueFisico.configure({"text":str(ataque1)})
                ataqueMagico.configure({"text":str(ataque2)})
                defensaFisica.configure({"text":str(defensa1)})
                defensaMagica.configure({"text":str(defensa2)})
                durabilidad.configure({"text":str(duracion)})
                precio.configure({"text":str(valor)})

            mostrarObjetos(marcoComprar,herrero.getObjetos(),listaLabels,False)


            for i in range(len(listaLabels)):

                compra = partial(comprarObjeto,label = listaLabels[i][0],objeto = listaLabels[i][1])
                ver = partial(verAtributos,objeto = listaLabels[i][1])   
                listaLabels[i][0].bind("<Button -1>",ver)
                listaLabels[i][0].bind("<Button -3>",compra)



        # FUNCIONES HERRERO

        def vender(ventana,marcoHerrero,herrero,personaje):

            marcoHerrero.place_forget()
            marcoVender = Frame(ventana,width=700,height=600)
            marcoVender.place(x=0,y=0)


            imagenVenta = herrero.getFondoVender()
            fondo = Label(marcoVender,image = imagenVenta)
            fondo.place(x=0,y=0)

            botonVolver = Button(marcoVender, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver(marcoHerrero, marcoVender), bg="black")
            botonVolver.place(x=650, y=15)                

            def venderObjeto(event,label,objeto):
                precioRefinado = math.ceil(objeto.getPrecio()*herrero.getImpuesto()/100)
                confirmarVenta = messagebox.askyesno(title="Venta",message="¿Deseas vender este objeto por "+str(precioRefinado)+" de oro?")

                if confirmarVenta:
                    label.place_forget()
                    messagebox.showinfo(title="Pacho",message="         ¡Gracias por tu venta!        " + "\nEsta pieza de calidad me servirá en mis futuros trabajos")
                    personaje.setOro(personaje.getOro()+precioRefinado)
                    personaje.getInventario().remove(objeto)  


            listaLabels = []
            mostrarObjetos(marcoVender,personaje.getInventario(),listaLabels,False)

            for i in range(len(listaLabels)):
                
                consulta = partial(consultar,objeto = listaLabels[i][1])
                vender = partial(venderObjeto,label= listaLabels[i][0],objeto = listaLabels[i][1])
                listaLabels[i][0].bind("<Button -3>",vender)
                listaLabels[i][0].bind("<Button -1>",consulta)



        def desfragmentar(ventana,marcoHerrero,herrero,personaje):

            marcoHerrero.place_forget()

            marcoFundir = Frame(ventana,width=700,height=600)
            marcoFundir.place(x=0,y=0)


            fondoFundir = herrero.getFondoDesfragmentar()
            imagenFundir = Label(marcoFundir,image=fondoFundir)
            imagenFundir.place(x=0,y=0)

            botonVolver = Button(marcoFundir, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver(marcoHerrero, marcoFundir), bg="black")
            botonVolver.place(x=650, y=15)


            irMateriales = Button(marcoFundir,text="Ver materiales",font=("Arial",15),command=lambda: verMateriales(ventana,marcoFundir,herrero))
            irMateriales.place(x=540,y=350)

            listaLabels = []
            mostrarObjetos(marcoFundir,personaje.getInventario(),listaLabels,False)

            def fundir(event,objeto,label):
                confirmar = messagebox.askyesno(title="Confirmación",message="¿Deseas fundir este objeto para obtener fragmentos de materiales?")

                if confirmar:
                    label.place_forget()
                    personaje.getInventario().remove(objeto)
                    nombresMateriales = list(Peleador.getMateriales())
                    

                    elegir1 = random.randint(0,8)
                    elegir2 = random.randint(0,8)
                    elegir3 = random.randint(0,8)
                    Peleador.getMateriales()[nombresMateriales[elegir1]] += 1
                    Peleador.getMateriales()[nombresMateriales[elegir2]] += 1
                    Peleador.getMateriales()[nombresMateriales[elegir3]] += 1


                    messagebox.showinfo(title="Resultado",message="Has obtenido: \n"+ nombresMateriales[elegir1]+ "\n"+nombresMateriales[elegir2]+"\n"+nombresMateriales[elegir3])
                 

            for i in range(len(listaLabels)):
                fundicion = partial(fundir,objeto=listaLabels[i][1],label = listaLabels[i][0])
                listaLabels[i][0].bind("<Button -3>",fundicion)


        def reparar(ventana,marcoHerrero,herrero,personaje):

            marcoHerrero.place_forget()

            marcoReparar = Frame(ventana,width=700,height=600)
            marcoReparar.place(x=0,y=0)

            fondoReparar = herrero.getFondoReparar()
            fondo = Label(marcoReparar,image=fondoReparar)
            fondo.place(x=0,y=0)

            botonVolver = Button(marcoReparar, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver(marcoHerrero, marcoReparar), bg="black")
            botonVolver.place(x=650, y=15)

            nombreObjeto = Label(marcoReparar,text="",bg="#82137d",fg="white",font=("Arial",12))
            nombreObjeto.place(x=215,y=104)

            ataqueFisico = Label(marcoReparar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            ataqueFisico.place(x=350,y=137)

            ataqueMagico = Label(marcoReparar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            ataqueMagico.place(x=350,y=171)

            defensaFisica = Label(marcoReparar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            defensaFisica.place(x=350,y=208)

            defensaMagica = Label(marcoReparar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            defensaMagica.place(x=350,y=245)

            durabilidad = Label(marcoReparar,text= "",bg="#82137d",fg="white",font=("Arial",17))
            durabilidad.place(x=350,y=280)

            listaLabels = []
            mostrarObjetos(marcoReparar,Peleador.getAlmacen(),listaLabels,False)


            def verAtributos(event,objeto):
                
                if objeto.getTipo().value[0] <=2:
                    nombre = objeto.getTipo().value[1] +" "+ objeto.getNombre()
                else:
                    nombre = objeto.getNombre()    
                ataque1 = objeto.getAtaqueFisico()
                ataque2 = objeto.getAtaqueMagico()
                defensa1 = objeto.getDefensaFisica()
                defensa2 = objeto.getDefensaMagica()
                duracion = objeto.getDurabilidad()
                nombreObjeto.configure({"text":nombre})
                ataqueFisico.configure({"text":str(ataque1)})
                ataqueMagico.configure({"text":str(ataque2)})
                defensaFisica.configure({"text":str(defensa1)})
                defensaMagica.configure({"text":str(defensa2)})
                durabilidad.configure({"text":str(duracion)})
                

            def reparacion(event,label,objeto):
                
                confirmar = messagebox.askyesno(title="Confirmar",message="¿Deseas reparar este objeto por 20 de oro?")

                if personaje.getOro()<20:
                    messagebox.showinfo(title="Verificación",message="No tienes suficiente oro para reparar este objeto")
                else:
                    if len(personaje.getInventario()) < 12:
                        label.place_forget()
                        Peleador.getAlmacen().remove(objeto)
                        personaje.getInventario().append(objeto)
                        personaje.setOro(personaje.getOro()-20)
                        messagebox.showinfo(title="Pacho",message="He logrado reparar este objeto, procura no volver a dañarlo")
                    else:
                        messagebox.showwarning(title="Inventario",message="No tienes suficiente espacio en el inventario para almacenar este objeto")
            

            for i in range(len(listaLabels)):

                ver = partial(verAtributos,objeto = listaLabels[i][1])
                arreglar = partial(reparacion,label = listaLabels[i][0],objeto = listaLabels[i][1])
                listaLabels[i][0].bind("<Button -1>",ver)
                listaLabels[i][0].bind("<Button -3>",arreglar)




        def verMateriales(ventana,marcoFundir,herrero):

            marcoFundir.place_forget()

            marcoMateriales = Frame(ventana,width=700,height=600)
            marcoMateriales.place(x=0,y=0)


            fondo = herrero.getFondoMateriales()
            
            fondoMateriales = Label(marcoMateriales,image=fondo)
            fondoMateriales.place(x=0,y=0)

            botonVolver = Button(marcoMateriales, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver(marcoFundir, marcoMateriales), bg="black")
            botonVolver.place(x=650, y=15)

            posiciones = [[88,134],[261,134],[434,134],[88,276],[261,276],[434,276],[88,418],[261,418],[434,418]]

            labels = []

            llaves = list(Peleador.getMateriales())

            def material(event,indice):
                messagebox.showinfo(title="Datos del material",message=llaves[indice]+"\nFragmentos = "+str(Peleador.getMateriales()[llaves[indice]]))

            for i in range(9):
                informar = partial(material,indice = i)
                iconos = herrero.getIconosMateriales()
                fondo = Label(marcoMateriales,image=iconos[i],bd=0)
                fondo.bind("<Button -3>",informar)
                fondo.place(x=posiciones[i][0],y=posiciones[i][1])
        

        
        def verCofre(ventana,marcoHerrero,herrero,personaje):

            marcoHerrero.place_forget()

            marcoCofre = Frame(ventana,width=700,height=600)
            marcoCofre.place(x=0,y=0)

            imagen = herrero.getFondoCofre()
            fondo = Label(marcoCofre,image=imagen)
            fondo.place(x=0,y=0)

            botonVolver = Button(marcoCofre, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver(marcoHerrero, marcoCofre), bg="black")
            botonVolver.place(x=650, y=15)

            labels = []
            mostrarObjetos(marcoCofre,Peleador.getCofre(),labels,False)

            def intercambiar(event,label,objeto):
                pregunta = messagebox.askyesno(title="Confirmación",message="¿Deseas llevarte este objeto?")

                if pregunta:
                    if len(personaje.getInventario()) < 12:
                        label.place_forget()
                        Peleador.getCofre().remove(objeto)
                        personaje.getInventario().append(objeto)
                    else:
                        messagebox.showwarning(title="Pacho",message="No tienes suficiente espacio en el inventario para llevar este objeto")
                
            

            for i in range(len(labels)):

                consulta = partial(consultar,objeto = labels[i][1])
                intercambio = partial(intercambiar,label=labels[i][0],objeto=labels[i][1])

                labels[i][0].bind("<Button -1>",consulta)
                labels[i][0].bind("<Button -3>",intercambio)

        

        def consultar(event,objeto):
                
                nombre = objeto.getNombre()
                ataque1 = objeto.getAtaqueFisico()
                ataque2 = objeto.getAtaqueMagico()
                defensa1 = objeto.getDefensaFisica()
                defensa2 = objeto.getDefensaMagica()
                duracion = objeto.getDurabilidad()
                mensaje = "Nombre: "+nombre +"\nAtaque Físico: "+str(ataque1)+"\nAtaque Mágico: "+str(ataque2)+"\nDefensa Física: "+str(defensa1) +"\nDefensa Mágica: "+str(defensa2) +"\nDurabilidad: "+str(duracion)

                messagebox.showinfo(title="Estadísticas",message=mensaje)
                
               

        def evolucionar(ventana,marcoHerrero,personaje,herrero):

            marcoHerrero.place_forget()
            marcoEvolucionar = Frame(ventana,width=700,height=600)
            marcoEvolucionar.place(x=0,y=0)

            imagen = herrero.getFondoEvolucionar()
            fondo = Label(marcoEvolucionar,image=imagen)
            fondo.place(x=0,y=0)

            botonVolver = Button(marcoEvolucionar, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver(marcoHerrero, marcoEvolucionar), bg="black")
            botonVolver.place(x=650, y=15)

            listaObjetos = [personaje.getArma(),personaje.getArmadura(),personaje.getAnillo()]+personaje.getInventario() 

            listaEvoluciones = []
            valores = [personaje.getClase().value,3,5] # Valores de Objetos que el usuario puede usar

            for i in range(len(listaObjetos)):
                if listaObjetos[i] != None:
                    if listaObjetos[i].isEvoluciona():
                        if valores.count(listaObjetos[i].getTipo().value[0]) == 1:
                            listaEvoluciones.append(listaObjetos[i])

            labels = []

            mostrarObjetos(marcoEvolucionar,listaEvoluciones,labels,False)


            def consultarMateriales(event,objeto):
                consultar(event,objeto)
                materiales = objeto.getMaterialesEvolucion()

                mensaje = "Materiales requeridos: "

                for key,value in materiales.items():
                    mensaje = mensaje + "\n"+key +" : "+ str(value)  

                messagebox.showinfo(title="Materiales de evolución",message=mensaje)    



            def evolucion(event,label,objeto):
                
                confirmacion = messagebox.askyesno(title="Confirmación",message="¿Deseas evolucionar este objeto?")

                if confirmacion:
                    materialesEvolucion = objeto.getMaterialesEvolucion()
                    global continuar 
                    continuar = True
                    for key,value in materialesEvolucion.items():
                        if Peleador.getMateriales()[key] < value:
                            messagebox.showwarning(title="Falta de materiales",message="Te faltan materiales para evolucionar el objeto")
                            continuar = False
                            break

                    if continuar:
                        
                        for key,value in materialesEvolucion.items():
                            Peleador.getMateriales()[key] -= value          #Retiro los materiales empleados
                            decision = random.randint(0,10)
                            label.place_forget()

                        if decision <= herrero.getEficiencia():
                            if personaje.getInventario().count(objeto)>0: #Si tiene el objeto en el inventario o alguna replica, la evolución la añade al inventario
                                personaje.getInventario().remove(objeto)
                                personaje.getInventario().append(objeto.getEvolucion())

                            else:    
                                if objeto.getTipo() == TipoDeObjeto.ANILLO:
                                    personaje.setAnillo(objeto.getEvolucion())
                                elif objeto.getTipo() == TipoDeObjeto.ARMADURA:
                                    personaje.setArmadura(objeto.getEvolucion())
                                else:
                                    personaje.setArma(objeto.getEvolucion())
                            messagebox.showinfo(title="Pacho",message="Felicidades, la evolución ha funcionado") 

                        else:
                            messagebox.showinfo(title="Pacho",message="Lo siento mucho, el proceso no ha tenido éxito")

                        

                    
                            
            for i in range(len(labels)):
                mejorar = partial(evolucion,label=labels[i][0],objeto=labels[i][1])
                consultaMaterial = partial(consultarMateriales,objeto=labels[i][1])
                labels[i][0].bind("<Button -1>",consultaMaterial)
                labels[i][0].bind("<Button -3>",mejorar)
    

        #Lista de materiales

        materiales = list(Peleador.getMateriales())


        #Objetos equipables

        arcoT1 = Objeto( "Fuego sagrado",None,25,TipoDeObjeto.ARCO,15,3,0,0,5,True,"arco1.png")
        arcoT2 = Objeto( "Tifón del caos",None,40,TipoDeObjeto.ARCO,20,8,0,0,5,False,"arco2.png")
        espadaT1 = Objeto( "Fuego sagrado",None,25,TipoDeObjeto.ESPADA,17,0,0,0,5,True,"espada1.png")
        espadaT2 = Objeto( "Tifón del caos",None,40,TipoDeObjeto.ESPADA,23,0,0,0,5,False,"espada2.png")
        varitaT1 = Objeto( "Fuego sagrado",None,25,TipoDeObjeto.VARITA,8,14,0,0,5,True,"varita1.png")
        varitaT2 = Objeto( "Tifón del caos",None,40,TipoDeObjeto.VARITA,12,22,0,0,5,False,"varita2.png")
        lanzaT = Objeto( "Solaris",None,20,TipoDeObjeto.LANZA,17,0,0,0,5,False,"lanza2.png")
        ballestaT = Objeto( "Solaris",None,20,TipoDeObjeto.BALLESTA,14,4,0,0,5,False,"ballesta2.png")
        bastonT = Objeto( "Solaris",None,20,TipoDeObjeto.BASTON,6,16,0,0,5,False,"baston2.png")
        armaduraL = Objeto( "Chaleco ligero",None,15,TipoDeObjeto.ARMADURA,0,0,11,14,5,False,"arm1.png")
        armaduraM = Objeto( "Guardiana celeste",None,25,TipoDeObjeto.ARMADURA,0,0,16,18,5,True,"arm2.png")
        armaduraP = Objeto( "Coraza de hueso",None,40,TipoDeObjeto.ARMADURA,0,0,20,22,5,False,"arm3.png")
        anilloL = Objeto( "Arcoiris",None,15,TipoDeObjeto.ANILLO,6,3,2,5,5,False,"anillo1.png")
        anilloM = Objeto( "Multiverso",None,25,TipoDeObjeto.ANILLO,10,7,5,6,1,True,"anillo2.png")
        anilloP = Objeto( "Taurino",None,40,TipoDeObjeto.ANILLO,20,0,0,0,1,False,"anillo3.png")
        armaH1 = Objeto( "Supremo",None,18,TipoDeObjeto.ARCO,12,2,0,0,4,False,"arco3.png")
        armaH2 = Objeto( "Luna Negra",None,18,TipoDeObjeto.ESPADA,14,0,0,0,4,False,"espada3.png")
        armaH3 = Objeto( "Curvatriz",None,18,TipoDeObjeto.VARITA,5,12,0,0,4,False,"varita3.png")
        armaH4 = Objeto( "Acero firme",None,18,TipoDeObjeto.LANZA,14,0,0,0,4,False,"lanza3.png")
        armaH5 = Objeto( "Igneo",None,18,TipoDeObjeto.BASTON,4,12,0,0,5,False,"baston3.png")
        armaduraH6 = Objeto("Placa negra",None,18,TipoDeObjeto.ARMADURA,0,0,12,13,5,False,"arm4.png")
        lanzaG = Objeto( "Plutonian",None,30,TipoDeObjeto.LANZA,20,0,0,0,5,False,"lanza4.png")


        #Materiales para evolucionar

        mates5 = {materiales[2]:5,materiales[6]:6,materiales[7]:8}
        mates4 = {materiales[1]:5,materiales[2]:6,materiales[3]:8}
        mates3 = {materiales[6]:5,materiales[5]:6,materiales[4]:8}
        mates2 = {materiales[7]:5,materiales[8]:6,materiales[0]:8}
        mates1 = {materiales[5]:5,materiales[3]:6,materiales[1]:8}

        arcoT1.setMaterialesEvolucion(mates1)
        arcoT1.setEvolucion(arcoT2)

        espadaT1.setMaterialesEvolucion(mates2)
        espadaT1.setEvolucion(espadaT2)

        varitaT1.setMaterialesEvolucion(mates3)
        varitaT1.setEvolucion(varitaT2)

        armaduraM.setMaterialesEvolucion(mates4)
        armaduraM.setEvolucion(armaduraP)

        anilloM.setMaterialesEvolucion(mates5)
        anilloM.setEvolucion(anilloP)




        objetosAlmacen = [arcoT1,espadaT2,armaduraH6,anilloM]
        Peleador.setAlmacen(objetosAlmacen)
        Peleador.setCofre(objetosAlmacen)

        #Dioses
        aries = Dios("Aries")
        tauro = Dios("Tauro")
        geminis = Dios("Geminis")
        cancer = Dios("Cancer")
        leo = Dios("Leo")
        virgo = Dios("Virgo")
        libra = Dios("Libra")
        escorpio = Dios("Escorpio")
        sagitario = Dios("Sagitario")
        capricornio = Dios("Capricornio")
        acuario = Dios("Acuario")
        piscis = Dios("Piscis")

        #Dioses de los nodos
        diosesNodo1 = [leo,libra,cancer,sagitario]
        diosesNodo2 = [aries,acuario,virgo,piscis]
        diosesNodo3 = [escorpio,geminis,capricornio,tauro]

        # Enemigos
        enemigo1n1 = Peleador(Clases.ENEMIGO,"Manticora",100,20,14,15,12,armaH2,armaduraH6,anilloL,0)

        enemigo1n2 = Peleador(Clases.ENEMIGO,"Martiwax",130, 17, 17, 20, 14, lanzaG, armaduraM, anilloL, 0)
        enemigo2n2 = Peleador(Clases.ENEMIGO,"Medusa",130, 16, 21, 17, 13, armaH3, armaduraM, anilloL, 0)

        enemigo1n3 = Peleador(Clases.ENEMIGO,"Asediador de almas",160, 21, 30, 22, 16, espadaT2, armaduraP, anilloM, 0)

        #Enemigos nodos

        enemigosN1 = [enemigo1n1]
        enemigosN2 = [enemigo1n2,enemigo2n2]
        enemigosN3 = [enemigo1n3]

        # Habilidades
        habilidad1 = Habilidad(TipoHabilidad.DEFENSAFISICA,"Coraza de acero",10,0,3,0, TipoEfecto.NULO, True)
        habilidad2 = Habilidad(TipoHabilidad.SANACION,"Palabra regeneradora",10,0,3,0, TipoEfecto.NULO, True)
        habilidad3 = Habilidad(TipoHabilidad.ATAQUEFISICO,"Ira del Trueno",10,0,3,2, TipoEfecto.NULO, False)
        habilidad4 = Habilidad(TipoHabilidad.DEFENSAMAGICA,"Escudo magico",15,0,3,0, TipoEfecto.NULO, True)
        habilidad5 = Habilidad(TipoHabilidad.ATAQUEMAGICO,"Tempestad del Zodiaco",20,0,2,0, TipoEfecto.NULO, False)
        habilidad6 = Habilidad(TipoHabilidad.APOYOFISICO,"Llama interna",10,0,3,0, TipoEfecto.NULO, True)
        habilidad7 = Habilidad(TipoHabilidad.ATAQUEFISICO,"Nova llameante",10,2,4,5, TipoEfecto.QUEMAR, False)
        habilidad8 = Habilidad(TipoHabilidad.ATAQUEFISICO,"Salto fuerte",15,0,2,0, TipoEfecto.NULO, False)
        habilidad9 = Habilidad(TipoHabilidad.ATAQUEMAGICO,"Mordedura de cobra",15,2,4,8, TipoEfecto.ENVENENAR, False)
        habilidad10 = Habilidad(TipoHabilidad.ATAQUEMAGICO,"Flecha venenosa",10,2,3,7, TipoEfecto.ENVENENAR, False)
        habilidad11 = Habilidad(TipoHabilidad.ATAQUEFISICO,"Furia vikinga",10,0,2,0, TipoEfecto.NULO, False)
        habilidad12 = Habilidad(TipoHabilidad.ATAQUEMAGICO,"Bola de fuego",15,2,3,7, TipoEfecto.QUEMAR, False)
        habilidad13 = Habilidad(TipoHabilidad.ATAQUEMAGICO,"Frio de invierno",15,1,3,10, TipoEfecto.NULO, False)
        habilidad14 = Habilidad(TipoHabilidad.APOYOFISICO,"Grito alentador",15,0,3,0, TipoEfecto.NULO, True)
        habilidad15 = Habilidad(TipoHabilidad.DEFENSAFISICA,"Coraza reforzada",15,0,3,0, TipoEfecto.NULO, True)
        habilidad16 = Habilidad(TipoHabilidad.ATAQUEMAGICO,"Cero absoluto",15,1,3,10, TipoEfecto.NULO, False)
        habilidad17 = Habilidad(TipoHabilidad.ATAQUEMAGICO,"Resplandor del caos",20,1,5,10, TipoEfecto.QUEMAR, False)
        habilidad18 = Habilidad(TipoHabilidad.SANACION,"Rejuvenecimiento",23,0,4,0, TipoEfecto.NULO, True)

        # Grupos de habilidades

        habilidades = [habilidad1,habilidad6,habilidad7,habilidad13,habilidad10]
        habilidades1 = [habilidad4,habilidad2,habilidad8,habilidad13,habilidad12]
        habilidades2 = [habilidad15,habilidad14,habilidad9,habilidad2,habilidad16]
        habilidades3 = [habilidad15,habilidad14,habilidad17,habilidad12,habilidad18]
        habilidades4 = [habilidad4,habilidad6,habilidad16,habilidad11, habilidad3]
        habilidades5 = [habilidad4,habilidad6,habilidad5,habilidad2, habilidad3]
        
        

        # Asignación habilidades a dioses

        aries.setHabilidades(habilidades4)
        tauro.setHabilidades(habilidades5)
        geminis.setHabilidades(habilidades4)
        cancer.setHabilidades(habilidades5)
        leo.setHabilidades(habilidades4)
        virgo.setHabilidades(habilidades5)
        libra.setHabilidades(habilidades4)
        escorpio.setHabilidades(habilidades5)
        sagitario.setHabilidades(habilidades4)
        capricornio.setHabilidades(habilidades5)
        acuario.setHabilidades(habilidades4)
        piscis.setHabilidades(habilidades5)
 

        # Asignación habilidades a enemigos

        enemigo1n1.setHabilidad(habilidades)
        enemigo1n2.setHabilidad(habilidades1)
        enemigo2n2.setHabilidad(habilidades2)
        enemigo1n3.setHabilidad(habilidades3)

        # Recompensas
        recompensa1 = [armaduraL, anilloL, armaH1, armaH2, armaH3, armaH5]
        recompensa2 = [armaduraL, armaduraH6, espadaT1, arcoT1, varitaT1, anilloM, anilloL]
        recompensa3 = [armaduraM, anilloM, lanzaG, lanzaT, ballestaT, bastonT, espadaT1, arcoT1, varitaT1]

        #tesoros
        tesoro1 = Tesoro("Baúl de Dragón",recompensa1,ventana)
        tesoro2 = Tesoro("Baúl de Tigre",recompensa2,ventana)
        tesoro3 = Tesoro("Baúl de Serpiente",recompensa3,ventana)

        # Nodos
        nodo3 = Nodo("Castillo oscuro",diosesNodo3,None,False,enemigosN3,tesoro3)
        nodo2 = Nodo("Bosque encantado",diosesNodo2,None,False,enemigosN2,tesoro2)
        nodo1 = Nodo("Valle de las sombras",diosesNodo1,[nodo2],True,enemigosN1,tesoro1)
        
        nodo3.setConexiones([nodo3])
        nodo2.setConexiones([nodo2,nodo3])

        
        # Herrero
        
        pacho = Herrero("pacho",[arcoT1,arcoT2,espadaT1],8,80)

        # Creacion de totems
        totem1 = Totem("Kali", habilidad1, ballestaT)
        totem2 = Totem("Hathor", habilidad2, lanzaT)
        totem3 = Totem("Horus", habilidad4, armaduraM)
        totem4 = Totem("Lugh", habilidad6, anilloM)
        totem5 = Totem("Lakshmi", habilidad14, bastonT)

        Totems = []    
        Totems.append(totem1)
        Totems.append(totem2)
        Totems.append(totem3)
        Totems.append(totem4)
        Totems.append(totem5)


        salud = Objeto("Fuente de vida", 0, TipoDeObjeto.POCION, 20, 0,0,0,1,False)
        fuerza = Objeto("Elixir de Titán", 0, TipoDeObjeto.POCION, 0,0,15,0,1,False)
        poder = Objeto("Sangre de dioses", 0, TipoDeObjeto.POCION, 0,10,0,5,1,False)
        defensa = Objeto("Savia divina", 0, TipoDeObjeto.POCION, 0, 0,0,15,1,False)
        Pociones = [salud, fuerza, poder, defensa]

        misionCombate = []  #lista de ensayo para las misiones de combate.
        misionCombate.append(enemigo1n1)
        misionCombate.append(enemigo1n2)
        misionCombate.append(enemigo1n3)

        misionBusqueda = []  #lista de ensayo para las misiones de búsqueda.
        misionBusqueda.append(anilloL)
        misionBusqueda.append(armaduraM)
        misionBusqueda.append(varitaT1)

        sabio = Sabio("Sabio", habilidades3, [], [], 0, 0, Totems)

        # Ventana de juego
        ventana.title("Desafío del Zodiaco")
        ventana.geometry("700x600")
        ventana.option_add('*tearOff',False) # Elimina el underscore de los menús
        


        #Menú principal (Barra de menús)
        menubar = Menu(ventana,name="menubar") # Barra de menú base para los demás
        ventana['menu'] = menubar #Asignamos el menú a la ventana 

        #Menús de interacción
        menu_archivo = Menu(menubar,name="archivo")
        menu_acciones = Menu(menubar)
        menu_ayuda = Menu(menubar)

        # Añadimos los menús a la barra
        menubar.add_cascade(label="Archivo",menu=menu_archivo)
        menubar.add_cascade(label="Acciones",state=DISABLED,menu=menu_acciones)
        menubar.add_cascade(label="Ayuda",menu=menu_ayuda)

        def volverCamino():
            frames = ventana.winfo_children()
            for i in range (len(frames)):
                frames[i].place_forget()
            frameCamino.place(x=0,y=0)
            activarMenu()
            

        def activarMenu():
            menubar.entryconfig("Acciones",state=NORMAL)

        def desactivarMenu():
            menubar.entryconfig("Acciones",state=DISABLED)    



        #Frame Inicial

        frameInicio = Frame(ventana,width=700,height=600)
        frameInicio.place(x=0,y=0)
        
        fondo = Label(frameInicio,image=imagenFondo)
        
        


        def nuevoJuego():
            frameInicio.place_forget()
            frameNombre.place(x=0,y=0)
            if os.path.exists("serializacion"):
                os.remove("serializacion")
            

        def cargarPartida():
            global personaje,numClase
            if os.path.exists("serializacion"): 
                lecturaFichero = open("serializacion","rb")
                lista = pk.load(lecturaFichero)
                personaje = lista[0]
                nodo2.setAbierto(lista[1])
                nodo3.setAbierto(lista[2])
                sabio.setHabilidades(lista[3])
                pacho.setObjetos(lista[4])
                numClase = personaje.getClase().value
                frameInicio.place_forget()
                lecturaFichero.close()

                if nodo2.isAbierto():
                    nombreNodo2.config(fg="#34E718")
                if nodo3.isAbierto():
                    nombreNodo3.config(fg="#34E718")

                frameCamino.place(x=0,y=0)
                menubar.entryconfig(index="Acciones", state= "normal")
                
            else:
                messagebox.showerror(message="No hay partidas guardadas, ahora iniciaras una nueva.")
                nuevoJuego()
        
        fondo.place(x=0,y=0)
        mensaje0 = Button(frameInicio,text="Nuevo juego" ,fg="white",bg="black",command=nuevoJuego,font=("Arial",20))
        mensaje0.place(x=260,y=270)
        mensaje1 = Button(frameInicio,text="Cargar partida",fg="white",bg="black",font=("Arial",20), command = cargarPartida)
        mensaje1.place(x=250,y=390)

        

        def showCamino():
            nombrePersonaje = entradaNombre.get()
            clasePersonaje = None

            if elegirClase.current() == 0:
                clasePersonaje = Clases.GUERRERO
            elif elegirClase.current() == 1:
                clasePersonaje = Clases.ARQUERO
            else:
                clasePersonaje = Clases.BRUJO        
             
            global personaje,numClase
            personaje = Peleador(clasePersonaje,nombrePersonaje)
            numClase = personaje.getClase().value
            personaje.setHabilidad(habilidades2)
            #personaje.setInventario([espadaT1,anilloM,arcoT2,armaduraP,varitaT1,armaduraH6,anilloL])
            
            frameNombre.place_forget()
            frameCamino.place(x=0,y=0)
            activarMenu()
            

        
         
        # Frame nombre y clase
        frameNombre = Frame(ventana,width=700,height=600,name="nombre")
        
        elegirNombre = Label(frameNombre,image=imagenNombre)
        elegirNombre.place(x=0,y=0)
        entradaNombre = Entry(frameNombre,font=("Arial",18),width=15)
        entradaNombre.place(x=300,y=150)

        ventana.nametowidget("nombre")

        elegirClase = Combobox(frameNombre,values=["Guerrero","Arquero","Brujo"],state="readonly",width=8,font=("Arial",14))
        elegirClase.current(0)
        elegirClase.place(x=476,y=260)

        avanzar = Button(frameNombre,text="Avanzar",font=("Arial",15),fg="green",command=showCamino)
        avanzar.place(x=460,y=400)
        

        # Frame camino de los doce
        frameCamino = Frame(ventana,width=700,height=600,name = "camino")
        
        fondoCamino = Label(frameCamino,image=imagenCamino)
        fondoCamino.place(x=0,y=0)

        
        def elegirEnemigo(nodo):
            random.shuffle(nodo.getEnemigos())
            enemigo = nodo.getEnemigos()[0]
            return enemigo

        def showCombate1():
            menu_archivo.entryconfig("Guardar",state=DISABLED)
            combate1 = Combate(ventana,"valleSombras"+str(numClase)+".png",nodo1,personaje,enemigo1n1,[470,130,90,145])
            combate1.setTerminar(False)
            frameNodo.place_forget()
            desactivarMenu()
            
            combate1.place(x=0,y=0)
            notaEncuentro(combate1.getEnemigoNodo())
            Dios.intervenirDios(nodo1,combate1,personaje,enemigo1n1)
            messagebox.showinfo(title="Turno usuario",message="Es tu turno")

        def showCombate2():
            menu_archivo.entryconfig("Guardar",state=DISABLED)
            enemigo = elegirEnemigo(nodo2)
            numero = 0

            if enemigo.getNombre() == "Medusa":
                numero = 1
            
            combate2 = Combate(ventana,"bosque"+str(numClase)+str(numero)+".png",nodo2,personaje,enemigo,[500,58,80,115])
            combate2.setTerminar(False)
            frameNodo.place_forget()
            desactivarMenu()
            
            combate2.place(x=0,y=0)
            notaEncuentro(combate2.getEnemigoNodo())
            Dios.intervenirDios(nodo2,combate2,personaje,enemigo)
            messagebox.showinfo(title="Turno usuario",message="Es tu turno")    


        def showCombate3():
            menu_archivo.entryconfig("Guardar",state=DISABLED)
            combate3 = Combate(ventana,"castilloOscuro"+str(numClase)+".png",nodo2,personaje,enemigo1n3,[500,58,140,155])
            combate3.setTerminar(False)
            frameNodo.place_forget()
            desactivarMenu()
            
            combate3.place(x=0,y=0)
            notaEncuentro(combate3.getEnemigoNodo())
            Dios.intervenirDios(nodo3,combate3,personaje,enemigo1n3)
            messagebox.showinfo(title="Turno usuario",message="Es tu turno") 


        

        # Funciones de los botones de ingreso a los nodos
        def clickNodo1():
            quitarBotones()
            confirmarNodo = messagebox.askyesno(
            title = "Confirmar elección",
            message = "¿Seguro que deseas ingresar a este nodo?"  
            )
            if confirmarNodo == True:
                showCombate1()

            mostrarBotones()
        


        def clickNodo2():
            quitarBotones()
            if nodo2.isAbierto() == True:
                confirmarNodo = messagebox.askyesno(
                title = "Confirmar elección",
                message = "¿Seguro que deseas ingresar a este nodo?"  
                )
                if confirmarNodo == True:
                    showCombate2()       
            else:
                mensaje = messagebox.showinfo(title="Notificación",message="Aún no puede ingresar a este nodo")

            mostrarBotones()    


        def clickNodo3():
            quitarBotones()
            if nodo3.isAbierto() == True:
                confirmarNodo = messagebox.askyesno(
                title = "Confirmar elección",
                message = "¿Seguro que deseas ingresar a este nodo?"  
                )
                if confirmarNodo == True:
                    showCombate3()
            else:
                messagebox.showinfo(title="Notificación",message="Aún no puede ingresar a este nodo") 

            mostrarBotones()



        # Notificar encuentro
        def notaEncuentro(enemigo):
            messagebox.showinfo(title="Encuentro",message="Te has encontrado al enemigo " + enemigo.getNombre() +"\n"+"La batalla está por comenzar")

        

        #Frame elegir nodo
        frameNodo = Frame(ventana,width=700,height=600,name = "frameNodos")
        
        fondoNodo = Label(frameNodo,image=imagenNodo)
        fondoNodo.place(x=0,y=0)

            

        #Etiquetas de los nodos y selección

        nombreNodo1 = Label(frameNodo,text="Valle de las sombras",font=("Arial",16),fg="#34E718",bg="#242c1f") #INICIA ACTIVO
        nombreNodo1.place(x=40,y=190)
        nombreNodo2 = Label(frameNodo,text="Bosque encantado",font=("Arial",16),fg="yellow",bg="#242c1f",name="bosque encantado") #INICIA APAGADO
        nombreNodo2.place(x=254,y=190)
        nombreNodo3 = Label(frameNodo,text="Castillo oscuro",font=("Arial",16),fg= "yellow",bg="#242c1f",name="castillo oscuro") #INICIA APAGADO
        nombreNodo3.place(x=474,y=190)

        #Botón volver

        volverNodo = Button(frameNodo, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver2(frameCamino,frameNodo), bg="black")
        volverNodo.place(x=650, y=15)


        #Botones de ingreso
        botonNodo1 = Button(frameNodo,text="Ingresar",font=("Arial",12),fg="white",bg="#242c1f",command = clickNodo1,name="ingreso1")
        botonNodo1.place(x=100,y=300)
        botonNodo2 = Button(frameNodo,text="Ingresar",font=("Arial",12),fg="white",bg="#242c1f",command= clickNodo2,name="ingreso2")
        botonNodo2.place(x=310,y=300)
        botonNodo3 = Button(frameNodo,text="Ingresar",font=("Arial",12),fg="white",bg="#242c1f",command= clickNodo3,name="ingreso3")
        botonNodo3.place(x=500,y=300)


        def quitarBotones():
            botonNodo1.config(state=DISABLED)
            botonNodo2.config(state=DISABLED)
            botonNodo3.config(state=DISABLED)

        def mostrarBotones():
            botonNodo1.config(state=NORMAL)
            botonNodo2.config(state=NORMAL)
            botonNodo3.config(state=NORMAL)    




        def showNodos():
            frameCamino.place_forget()
            desactivarMenu()
            frameNodo.place(x=0,y=0)

    

    


        def mostrarHerrero(herrero):

            desactivarMenu()
            frameCamino.place_forget()
            marcoHerrero = Frame(ventana,width=700,height=600)
            fondoInicio = herrero.getFondoInicio()
            inicio = Label(marcoHerrero,image=fondoInicio)
            inicio.place(x=0,y=0)

            botonVolver = Button(marcoHerrero, text="X", image=cerrar, font=Fuente_botones2, command= lambda: volver2(frameCamino, marcoHerrero), bg="black")
            botonVolver.place(x=650, y=15)
            
            opcion1 = Button(marcoHerrero,text="Comprar",font=("Arial",15),width=13,command = lambda: comprar(ventana,marcoHerrero,pacho,personaje))
            opcion1.place(x=300,y=400)
            
            
            opcion2 = Button(marcoHerrero,text="Evolucionar",font=("Arial",15),width=13,command=lambda: evolucionar(ventana,marcoHerrero,personaje,pacho))
            opcion2.place(x=500,y=400)

            
            opcion3 = Button(marcoHerrero,text="Vender",font=("Arial",15),width=13,command = lambda: vender(ventana,marcoHerrero,pacho,personaje))
            opcion3.place(x=300,y=470)

            
            opcion4 = Button(marcoHerrero,text="Reparar",font=("Arial",15),width=13,command= lambda: reparar(ventana,marcoHerrero,pacho,personaje))
            opcion4.place(x=500,y=470)
            
            opcion5 = Button(marcoHerrero,text="Ver cofre",font=("Arial",15),width=13,command= lambda: verCofre(ventana,marcoHerrero,pacho,personaje))
            opcion5.place(x=300,y=540)

            opcion6 = Button(marcoHerrero,text="Desfragmentar",font=("Arial",15),width=13,command= lambda: desfragmentar(ventana,marcoHerrero,pacho,personaje) )
            opcion6.place(x=500,y=540)

            marcoHerrero.place(x=0,y=0)

        def AcercaDE():
            messagebox.showinfo(message= "Autores: \n- Camilo Montoya Arango \n- Yeferson Andres Velazco \n- Edwin Rafael Jimenez", title = "Autores")

        menu_ayuda.add_command(label="Acerca de", command= AcercaDE)

        menubar.entryconfig(index= "Acciones", state = "disabled")

        def salirVentana():
            ventana.destroy()
            Ventana_inicio.deiconify()

        def Guardar():
            fichero = open("serializacion", "wb")
            pk.dump([personaje,nodo2.isAbierto(), nodo3.isAbierto(), sabio.getHabilidades(), pacho.getObjetos()], fichero)
            fichero.close()


        def Aplicacion():
            messagebox.showinfo(message = AplicacionTexto, title = "Información")

        #Modificando el menú de Archivo
        menu_archivo.add_command(label="Aplicación", command= Aplicacion)
        menu_archivo.add_command(label="Guardar", command=Guardar)
        menu_archivo.add_separator()
        menu_archivo.add_command(label="Salir",command = salirVentana)

    
        #Abrir la ventana del sabio
        def ventanaSabio():
        
            frameCamino.place_forget()
            menubar.entryconfig(index="Acciones", state= "disabled")
            labelSabio = Label(ventana, image=fondoSabio)
            labelSabio.place(x=0,y=0)
            
            #Mensaje de bienvenida al santuario (Sabio)
            labelSabio_inferior = Label(ventana, text=TextoSantuario, justify=LEFT, font=Fuente1, bg="white")
            labelSabio_inferior.place(x=15,y=410)
            
            label_sabio2 = Label(ventana, image=fondoSabio2)
                
            def Siguiente():
                labelSabio_inferior.place_forget()
                labelSabio.place_forget()
                siguiente.place_forget()
                label_sabio2.place(x=0,y=0)
                frameSabio.place(x=0,y=400)

            def Volver():
                label_sabio2.place_forget()
                frameSabio.place_forget()
                fondoCamino.place(x=0,y=0)
                frameCamino.grid(row=0, column=0)
                menubar.entryconfig(index="Acciones", state= "normal")

            def invocarTotem():
                
                #Verifica la existencia de un Totem
                if personaje.getTotem() == None:
                    texto="Para invocar un Totem se necesitan cuatro fragmentos, "
                    if personaje.getFragmentos() < 4:
                        if personaje.getFragmentos() ==1:
                            messagebox.showerror(message = texto +"tienes " + str(personaje.getFragmentos()) + ", puedes conseguir más completando misiones.")
                        else:
                            messagebox.showerror(message = texto +"tienes " + str(personaje.getFragmentos()) + ", puedes conseguir más completando misiones.")
                    else:
                        #elección del Totem
                        indice = random.choice([h for h in range(len(Lista_imagenesTotems))])
                        totemInv = sabio.getTotems()[indice]
                        sabio.getTotems().remove(sabio.getTotems()[indice])
                        imagenTotem = Lista_imagenesTotems[indice]
                        Lista_imagenesTotems.remove(Lista_imagenesTotems[indice])

                        label_sabio4 = Label(ventana, image=imagenTotem)

                        label_sabio2.place_forget()
                        frameSabio.place_forget()
                        label_sabio4.place(x=0, y=0)
                        frameSabio4.place(x=0, y=400)

                        textoInvocacion = Label(frameSabio4, text=sabio.invocarTotems(personaje, totemInv),
                            justify=LEFT, font=("Arial", 15, "bold", "italic"), bg="azure3")
                        textoInvocacion.place(x=0, y=0)

                        def Volver2():
                            label_sabio2.place(x=0, y=0)
                            frameSabio.place(x=0, y=400)
                            label_sabio4.place_forget()
                            frameSabio4.place_forget()
                            textoInvocacion.place_forget()

                        botonVolver = Button(label_sabio4, text="X", image=cerrar, font=Fuente_botones2, command=Volver2, bg="black")
                        botonVolver.place(x=650, y=15)
                else:
                    label_sabio2.place_forget()
                    frameSabio.place_forget()
                    label_sabio4 = Label(ventana, image=fondoSabio4)
                    label_sabio4.place(x=0, y=0) 
                    frameSabio4.place(x=0, y=400)
                    
                    def Volver2():
                        label_sabio2.place(x=0, y=0)
                        frameSabio.place(x=0, y=400)
                        label_sabio4.place_forget()
                        frameSabio4.place_forget()
                        textoTotem.place_forget()

                    def Siguiente2():
                        textoTotem.place_forget()
                        botonVolver2.place_forget()
                        textoTotem2.place(x=0,y=0)
                        botonHabilidad.place(x=100, y=110)
                        botonObjeto.place(x=400, y=110)

                    botonVolver = Button(label_sabio4, text="X", image=cerrar, font=Fuente_botones2, command=Volver2, bg="black")
                    botonVolver.place(x=650, y=15)
                    textoTotem = Label(frameSabio4, text= TextoTotem, justify=LEFT, font=("Arial", 15, "bold", "italic"), bg="azure3")
                    textoTotem.place(x=0, y=0)
                    
                    botonVolver2 = Button(ventana, text="Siguiente", font=Fuente_botones, command=Siguiente2, bg="azure3")
                    botonVolver2.place(x=600, y=540)

                    textoTotem2 = Label(frameSabio4, text="Totem Actual: " + personaje.getTotem().getNombre() + "\n\nHabilidad\n"+ personaje.getTotem().getHabilidadEspecial().__str__(),
                                        justify=LEFT, font=("Arial", 14, "bold", "italic"), bg="azure3")
                    
                    def habilidadTotem():
                        if personaje.getTotem().getApoyo() != 0:
                            respuesta = messagebox.askyesno(message=("¿Deseas activar la habilidad de " + personaje.getTotem().getNombre()+ " ?\n"+
                                                                    "Recuerda que solo puedes usar esta habilidad una vez y solo será útil en tu proxima batalla. \n\nHabilidad\n" +
                                                                    personaje.getTotem().getHabilidadEspecial().__str__() + "."), title="Recibir Habilidad")
                            if respuesta:
                                messagebox.showinfo(message=personaje.getTotem().apoyar(personaje), title="Recibir Habilidad")
                        else:
                            messagebox.showerror(message=personaje.getTotem().apoyar(personaje), title="Recibir Habilidad")       

                    def objetoTotem():
                        respuesta = messagebox.askyesno(message="¿Deseas recibir el objeto sagrado?\nRecuerda que al hacerlo tu Totem desaparecerá.", title="Recibir Objeto Sagrado")
                        if respuesta:
                            messagebox.showinfo(message=personaje.getTotem().donarObjeto(personaje), title="Recibir Objeto Sagrado")
                            Volver2()

                        
                    botonHabilidad = Button(frameSabio4, text="Usar Habilidad", font=Fuente_botones2, bg="azure3", command=habilidadTotem)
                    botonObjeto = Button(frameSabio4, text="Invocar Objeto", font=Fuente_botones2, bg="azure3", command= objetoTotem)


            def aprenderHabilidad():
                if sabio.getHabilidades() == []:
                    messagebox.showinfo(message="No tengo más habilidades que enseñarte", title="Aprender Habilidades")
                else:
                    label_sabio2.place_forget()
                    frameSabio.place_forget()
                    label_sabio3.place(x=0, y=0)
                    frameSabio3.place(x=0, y=400)

                    botonVolver = Button(label_sabio3, text="X", image=cerrar, font=Fuente_botones2, command=Volver2, bg="black")
                    botonVolver.place(x=650, y=15)

                    lista = []
                    for h in sabio.getHabilidades():
                        lista.append(h.__str__())

                    
                    textoHabilidades = Label(frameSabio3, text="Selecciona la habilidad que deseas aprender:", font=Fuente_botones2, justify=LEFT, bg="azure3")
                    textoHabilidades.place(x=10, y=10)

                    def eleccionHabilidad(self):
                        if len(personaje.getHabilidades()) >= 5:
                            messagebox.showinfo(message="Solo puedes tener 5 habilidades equipadas, selecciona una para cambiarla.")
                            lista2 = []
                            for h in personaje.getHabilidades():
                                lista2.append(h.__str__())
                            textoHabilidades = Label(frameSabio3, text="Selecciona la habilidad que vas a eliminar:", font=Fuente_botones2, justify=LEFT, bg="azure3")
                            textoHabilidades.place(x=10, y=90)
                            cambiarHabilidad = Combobox(frameSabio3,values=lista2,state="readonly",width=55,font=("Arial",13,"bold","italic"))
                            cambiarHabilidad.place(x=10,y=130)
                            
                            def cambioHabilidad(self):
                                eleccion = messagebox.askokcancel(message="¿Desea cambiar la habilidad " + personaje.getHabilidades()[cambiarHabilidad.current()].getNombre() +" por " + sabio.getHabilidades()[elegirHabilidad.current()].getNombre() + "?", title="Aprender Habilidad")
                                if eleccion:
                                    messagebox.showinfo(message= sabio.ensenarHabilidad(personaje, elegirHabilidad.current()), title="Aprender Habilidad")
                                    sabio.getHabilidades().remove(sabio.getHabilidades()[elegirHabilidad.current()])
                                    personaje.getHabilidades().remove(personaje.getHabilidades()[cambiarHabilidad.current()])
                                    textoHabilidades.place_forget()
                                    cambiarHabilidad.place_forget()
                                    Volver2() 

                            cambiarHabilidad.bind("<<ComboboxSelected>>", cambioHabilidad)
                            

                        else:
                            eleccion = messagebox.askokcancel(message="¿Desea aprender la habilidad " + sabio.getHabilidades()[elegirHabilidad.current()].getNombre() + "?", title="Aprender Habilidad")
                            if eleccion:
                                messagebox.showinfo(message= "     ¡¡¡Felicitaciones!!!\n" + sabio.ensenarHabilidad(personaje, elegirHabilidad.current()) , title="Aprender Habilidad")
                                sabio.getHabilidades().remove(sabio.getHabilidades()[elegirHabilidad.current()])
                                Volver2()

                    elegirHabilidad = Combobox(frameSabio3,values=lista,state="readonly",width=55,font=("Arial",13,"bold","italic"))
                    elegirHabilidad.place(x=10,y=50)
                    elegirHabilidad.bind("<<ComboboxSelected>>", eleccionHabilidad)

                

            def Volver2():
                label_sabio2.place(x=0, y=0)
                frameSabio.place(x=0, y=400)
                label_sabio3.place_forget()
                frameSabio3.place_forget()

            botonVolver = Button(label_sabio2, text="X", image=cerrar, font=Fuente_botones2, command=Volver2, bg="black")
            botonVolver.place(x=650, y=15)

            label_misiones = Label(ventana, image= fondoMisiones)
            frameSabioMisiones = Frame(ventana, borderwidth=3, relief="ridge", width=700, height=220, bg="azure3")
            frameSabioMisiones2 = Frame(ventana, borderwidth=3, relief="ridge", width=700, height=220, bg="azure3")


            def recibirMision():
                label_sabio2.place_forget()
                frameSabio.place_forget()
                label_misiones.place(x=0, y=0)
                frameSabioMisiones.place(x=0, y=400)
                
                def VolverMision():
                    label_sabio2.place(x=0, y=0)
                    frameSabio.place(x=0, y=400)
                    label_misiones.place_forget()
                    frameSabioMisiones.place_forget()
                    
                botonVolver = Button(label_misiones, text="X", image=cerrar, font=Fuente_botones2, command=VolverMision, bg="black")
                botonVolver.place(x=650, y=15)

                label_misionesTexto = Label(frameSabioMisiones, text=TextoMisiones, justify=LEFT, font=("Times New Roman", 16, "bold", "italic"), bg="azure3")
                label_misionesTexto.place(x=10, y=10)

                def asignarBusqueda():
                    if sabio.getMisionesB() != 0:
                        messagebox.showinfo(message= "Ya tienes una misión de búsqueda activa, regresa cuando la hayas completado.")
                    else:
                        indice = random.choice([h for h in range(len(misionBusqueda))])
                        objeto = misionBusqueda[indice]
                        messagebox.showinfo(message=sabio.asignarMisionB(objeto))
                
                def asignarEnemigo():
                    if sabio.getMisionesL() != 0:
                        messagebox.showinfo(message= "Ya tienes una misión de combate activa, regresa cuando la hayas completado.")
                    else:
                        indice = random.choice([h for h in range(len(misionCombate))])
                        enemigo = misionCombate[indice]
                        messagebox.showinfo(message=sabio.asignarMisionC(enemigo))

                botonBusqueda = Button(frameSabioMisiones, text="Misión de búsqueda", font=Fuente_botones2, bg="azure3", command=asignarBusqueda)
                botonBusqueda.place(x=120, y=100)
                botonCombate = Button(frameSabioMisiones, text="Misión de combate", font=Fuente_botones2, bg="azure3", command= asignarEnemigo)
                botonCombate.place(x=400, y=100)

            def recogerRecompensa():
                if sabio.getMisionesB() == 0 and sabio.getMisionesL() == 0:
                    messagebox.showerror(message="No tienes misiones activas, regresa cuando hayas recibido por lo menos una misión.")
                else:
                    label_sabio2.place_forget()
                    frameSabio.place_forget()
                    label_misiones.place(x=0, y=0)
                    frameSabioMisiones2.place(x=0, y=400)

                    indice = random.choice([h for h in range(len(Pociones))])
                    pocion = Pociones[indice]
                    Pociones.remove(Pociones[indice])
                    
                    def VolverMision():
                        label_sabio2.place(x=0, y=0)
                        frameSabio.place(x=0, y=400)
                        label_misiones.place_forget()
                        frameSabioMisiones2.place_forget()
                        label_misionesTexto2.place_forget()

                    botonVolver = Button(label_misiones, text="X", image=cerrar, font=Fuente_botones2, command=VolverMision, bg="black")
                    botonVolver.place(x=650, y=15)

                    texto ="Misiones Actuales:"
                    try:
                        if sabio.getMisionesL() > 0:
                            texto += "\n- Derrotar a " + sabio.getOponentes()[0].getNombre() +"."
                    except Exception:
                        texto = ""

                    try:
                        if sabio.getMisionesB() > 0:
                            texto += "\n- Encontrar " + sabio.getObjetos()[0].getNombre() +"."
                    except Exception:
                        texto = ""

                    label_misionesTexto = Label(frameSabioMisiones2, text=texto, justify=LEFT, font=("Times New Roman", 18, "bold", "italic"), bg="azure3")
                    label_misionesTexto.place(x=10, y=10)
                    
                    label_misionesTexto2 = Label(frameSabioMisiones2, text="", justify=LEFT, font=("Times New Roman", 18, "bold", "italic"), bg="azure3", fg = "red")
                    

                    def cobrarRecompensa():
                        texto1=""
                        fragmentos = sabio.calificarMisionBusqueda(personaje) + sabio.calificarMisionCombate(personaje)
                        if fragmentos == 0:
                            texto1 = "No has cumplido ninguna misión, regresa cuando hayas completado \nal menos una para poder reclamar recompensas."
                        else:
                            texto1 = "Has recibido "+ str(fragmentos) +" fragmentos por cumplir misiones."
                            personaje.agregarPocion(pocion)
                            messagebox.showinfo(message="Los dioses te han obsequiado " + pocion.getNombre() + " por cumplir esta misión")
                            
                        label_misionesTexto2.config(text=texto1)
                            
                    
                    label_misionesTexto2.place(x=10, y=100)



                    botonReclamar = Button(frameSabioMisiones2, text="Cobrar recompensas", font=Fuente_botones2, command=cobrarRecompensa, bg="azure3")
                    botonReclamar.place(x=400, y=25)



            siguiente = Button(ventana, text="Siguiente", font=Fuente_botones, command=Siguiente)
            siguiente.place(x=370,y=540)

            frameSabio = Frame(ventana, borderwidth=3, relief="ridge", width=700, height=220, bg="azure3")

            mensajeSabio = Label(label_sabio2, text="¿Qué deseas hacer?", bg="white", font=Fuente_botones2)
            mensajeSabio.place(x=220, y=65)

            #Botones Sabio
            botonTotem = Button(frameSabio, text="Invocar Totems   ", font=Fuente_botones2, bg="ivory3", command=invocarTotem)
            botonTotem.place(x=400, y=100)

            botonHabilidades = Button(frameSabio, text="Aprender Habilidades  ", font=Fuente_botones2, bg="ivory3", command=aprenderHabilidad)
            botonHabilidades.place(x=80, y=100)

            botonMisiones = Button(frameSabio, text="Recibir misiones", font=Fuente_botones2, bg="ivory3",command=recibirMision)
            botonMisiones.place(x=400, y=30)

            botonRecompensas = Button(frameSabio, text="Recoger recompensas", font=Fuente_botones2, bg="ivory3", command=recogerRecompensa)
            botonRecompensas.place(x=80, y=30)

            
            atras = Button(label_sabio2, text="X", image=cerrar, font=Fuente_botones2, command=Volver, bg="black")
            atras.place(x=650, y=15)

            
            label_sabio3 = Label(ventana, image=fondoSabio3)
            frameSabio3 = Frame(ventana, borderwidth=3, relief="ridge", width=700, height=220, bg="azure3")
            frameSabio4 = Frame(ventana, borderwidth=3, relief="ridge", width=700, height=220, bg="azure3")

        def ventanaAtributos():
            menubar.entryconfig(index="Acciones", state= "disabled")
            label_atributos = Label(ventana, image=fondoAtributos)
            
            label_texto = Label(label_atributos, text = personaje.__str__(), justify=LEFT, font= Fuente_base3, bg="white")
            
            frameCamino.place_forget()

            def Volver():
                label_texto.place_forget()
                label_atributos.place_forget()
                frameCamino.place(x=0,y=0)
                menubar.entryconfig(index="Acciones", state= "normal")

            
            label_atributos.place(x=0,y=0)
            label_texto.place(x=65, y=55)
            atras = Button(label_atributos, text="X", image=cerrar, font=Fuente_botones2, command=Volver, bg="black")
            atras.place(x=650, y=15)


        #Modificando el menú de Acciones
        menu_acciones.add_command(label="Ir al campo de batalla",command=showNodos)
        menu_acciones.add_command(label="Consultar inventario",command = lambda : consultarInventario(personaje,ventana,frameCamino,fondoInventario))
        menu_acciones.add_command(label="Consultar estadísticas del personaje", command= ventanaAtributos)
        menu_acciones.add_command(label="Visitar el herrero",command = lambda : mostrarHerrero(pacho))
        menu_acciones.add_command(label="Visitar el sabio", command = ventanaSabio)

        
    boton = Button(P4, text= "Empezar el Desafio del Zodiaco", width=32,height=2,font=Fuente_base3, command= e1, bg="ivory3")
    boton.place(x=15, y=220)

    menu = Menu(Ventana_inicio)
    menu2 = Menu()
    menu.add_cascade(label="Inicio", menu=menu2)
    menu2.add_command(label="Descripción", command= Inicio.descripcion)
    menu2.add_command(label="Salir", command= Inicio.salir)


    Ventana_inicio['menu'] = menu
    Ventana_inicio.mainloop()

