package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepci�n que controla si se ha producido un error al eliminar
 * 
 * @author Rafael Mellado Jim�nez
 * @version 1.0
 */
public class ErrorAlEliminarException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public ErrorAlEliminarException(String message) {
		super(message);
	}
}
