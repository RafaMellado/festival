package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Controla si el formato de la hora introducida es válido
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
public class FormatoHoraNoValidoException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public FormatoHoraNoValidoException(String message) {
		super(message);
	}
}
