/*
Enumerador para los distinto efectos que puede tener una habilidad.

Autor: Edwin
*/

package complementario;

public enum TipoEfecto {
	CONGELAR,
	QUEMAR,
	ENVENENAR,
	NULO;
	
	public String nombreEfecto() {
		return this.toString();
	}
	
	//Devuelve una descripci�n teniendo en cuenta el tipo de efecto.
	public String descripcion(Habilidad habilidad) {
		if (this == CONGELAR ) {
			
			return "reduce permanentemente la defensa f�sica y m�gica del objetivo en "+habilidad.getDanoEfecto(); 
		}
		
		else if(this == QUEMAR) {
			return "incinera al objetivo y le inflige "+habilidad.getDanoEfecto()+" de da�o";
		}
		else {
			return "envenena al enemigo y le inflige "+habilidad.getDanoEfecto()+" de da�o";
		}
	}
	
}
