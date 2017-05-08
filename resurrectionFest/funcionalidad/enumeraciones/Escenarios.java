package resurrectionFest.funcionalidad.enumeraciones;

/**
 * Enumeración de escenarios
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public enum Escenarios {

	/**
	 * Escenario principal
	 */
	MS("Main Stage"), 
	/**
	 * Escenario secundario, Chaos Stage
	 */
	CS("Chaos Stage"), 
	/**
	 * Escenario secundario, Ritual Stage
	 */
	RS("Ritual Stage"), 
	/**
	 * Escenario secundario, Desert Stage
	 */
	DS("Desert Stage");

	/**
	 * Campo nombre
	 */
	private String nombre;

	/**
	 * Constructor
	 * @param nombre
	 */
	private Escenarios(String nombre) {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static String[] nombreEscenarios(){
		String[] escenarios = new String[values().length];
		int i = 0;
		for (Escenarios escenario : values()) {
			escenarios[i++] = escenario.getNombre();
		}
		return escenarios;
		
	}
}
