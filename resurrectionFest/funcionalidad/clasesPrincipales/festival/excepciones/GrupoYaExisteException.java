package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepci�n que controla si al a�adir un grupo, ya existe en la colecci�n
 * 
 * @author Rafael Mellado Jim�nez
 * @version 1.0
 */
public class GrupoYaExisteException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param arg0
	 */
	public GrupoYaExisteException(String arg0) {
		super(arg0);
	}
}
