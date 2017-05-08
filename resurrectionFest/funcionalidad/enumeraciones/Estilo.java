package resurrectionFest.funcionalidad.enumeraciones;

/**
 * Enumeración de estilos
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public enum Estilo {
	/**
	 * Metal standard
	 */
	M("Metal"),
	/**
	 * Metalcore
	 */
	MC("Metalcore"), 
	/**
	 * Death Metal
	 */
	DM("Death Metal"), 
	/**
	 * Black Metal
	 */
	BM("Black Metal"), 
	/**
	 * Hard Rock
	 */
	HR("Hard Rock"),
	/**
	 * Punk
	 */
	P("Punk"), 
	/**
	 * Rock Alternativo
	 */
	RA("Rock Alternativo"), 
	/**
	 * Industrial metal
	 */
	IN("Industrial");
	
	/**
	 * Campo nombre
	 */
	private String nombre;

	/**
	 * Constructor
	 * @param nombre
	 */
	private Estilo(String nombre){
		setNombre(nombre);
	}
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString(){
		return getNombre();
	}
	
}
