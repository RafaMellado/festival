package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;

/**
 * Clase bajista
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Bajista extends Guitarrista {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param nombre
	 * @param procedencia
	 * @param inalambrico
	 * @param microfoneado
	 * @throws NombreMiembroNoValidoException
	 */
	public Bajista(String nombre, Procedencia procedencia, boolean inalambrico, boolean microfoneado) throws NombreMiembroNoValidoException {
		super(nombre, procedencia, inalambrico, microfoneado);
	}


}
