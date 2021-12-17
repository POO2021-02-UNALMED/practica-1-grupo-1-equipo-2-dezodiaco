/*
Implementación de la clase abstracta. define el método apoyar

Autor: Yeferson
*/
package personajes;

import complementario.Habilidad;

public abstract class Guardian {
	
	protected final String nombre;
	protected Habilidad habilidadEspecial;
	
	//Constructor para las clases hijas
	protected Guardian(String nombre, Habilidad habilidadEspecial) {
		this.nombre = nombre;
		this.habilidadEspecial = habilidadEspecial;
	}
	
	public abstract String apoyar(Peleador personaje);

	public String getNombre() {
		return nombre;
	}
	
	
}

