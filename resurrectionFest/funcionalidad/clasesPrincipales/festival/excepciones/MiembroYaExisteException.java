package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepción que controla si ya se ha introducido un miembro en el mismo grupo
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
public class MiembroYaExisteException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param arg0
	 */
	public MiembroYaExisteException(String arg0) {
		super(arg0);
	}
}
