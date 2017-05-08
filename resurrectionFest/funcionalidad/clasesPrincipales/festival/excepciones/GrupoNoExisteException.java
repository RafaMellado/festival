package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepci�n que salta si no existe un grupo al buscarlo 
 * 
 * @author Rafael Mellado Jim�nez
 * @version 1.0
 */
public class GrupoNoExisteException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param arg0
	 */
	public GrupoNoExisteException(String arg0) {
		super(arg0);
	}

}
