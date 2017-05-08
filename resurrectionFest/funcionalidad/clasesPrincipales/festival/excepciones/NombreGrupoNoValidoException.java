package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepci�n que controla si al a�adir un grupo, el nombre no es suficientemente largo.
 * 
 * @author Rafael Mellado Jim�nez
 * @version 1.0
 */
public class NombreGrupoNoValidoException extends Exception {


	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public NombreGrupoNoValidoException(String message) {
		super(message);
	}

}
