package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepción que controla si al añadir un grupo, el nombre no es suficientemente largo.
 * 
 * @author Rafael Mellado Jiménez
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
