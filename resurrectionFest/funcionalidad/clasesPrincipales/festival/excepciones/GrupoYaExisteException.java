package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepción que controla si al añadir un grupo, ya existe en la colección
 * 
 * @author Rafael Mellado Jiménez
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
