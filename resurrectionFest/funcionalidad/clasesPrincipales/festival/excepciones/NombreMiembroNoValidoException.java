package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 *  Excepci�n que controla si al a�adir un componente, el nombre no es suficientemente largo.
 * 
 * @author Rafael Mellado Jim�nez
 * @version 1.0
 */
public class NombreMiembroNoValidoException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param arg0
	 */
	public NombreMiembroNoValidoException(String arg0) {
		super(arg0);
	}
}
