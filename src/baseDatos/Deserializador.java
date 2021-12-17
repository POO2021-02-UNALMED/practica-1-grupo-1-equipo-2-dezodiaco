package baseDatos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import complementario.Clases;
import complementario.Nodo;
import personajes.Peleador;




public class Deserializador {
	
	public static Peleador deserializarPersonaje() {
		
		try {
		FileInputStream fileIn;		// Archivo para entrar los datos
		fileIn = new FileInputStream(System.getProperty("user.dir") + "/src/baseDatos/temp/personajes.txt"); // Toma el archivo del personaje	
		ObjectInputStream in = new ObjectInputStream(fileIn);
		
		return (Peleador) in.readObject();
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	public static ArrayList<Nodo> deserializarNodos() {
		
			try {
			FileInputStream fileIn;	// Archivo para entrar los datos
			fileIn = new FileInputStream(System.getProperty("user.dir") + "/src/baseDatos/temp/nodos.txt"); // Toma el archivo del personaje	
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			ArrayList<Nodo> listaNodos =  new ArrayList<Nodo>();
			
			listaNodos = (ArrayList<Nodo>) in.readObject();
			
			return listaNodos;
			
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
		}
	
	
}
