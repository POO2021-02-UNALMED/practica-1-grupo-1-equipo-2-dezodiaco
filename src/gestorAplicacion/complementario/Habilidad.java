package complementario;
import personajes.Peleador;

public class Habilidad {

	
	private final TipoHabilidad tipo;
	private final String nombre;
	private final int modificador;
	private final int duracion ;
	
	public Habilidad(TipoHabilidad tipo, String nombre, int modificador,int duracion) {
		this.nombre = nombre;
		this.modificador = modificador;
		this.tipo = tipo;
		this.duracion = duracion;
	}
	
}	