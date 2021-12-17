package baseDatos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import complementario.Nodo;
import personajes.Peleador;

public class Serializador {
	
	public static void serializar(Peleador personaje) {
		try {
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\personajes.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(personaje);
			out.close();
			fileOut.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void serializarNodos(ArrayList<Nodo> nodos) {
		try {
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\nodos.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(nodos);
			out.close();
			fileOut.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
