package resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones;

/**
 * Excepción que controla si no existen componentes en el grupo
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
public class ComponentesVacioException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param arg0
	 */
	public ComponentesVacioException(String arg0) {
		super(arg0);
	}
}
