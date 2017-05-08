package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;

/**
 * Clase guitarrista
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Guitarrista extends Miembros {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Campo que indica si el guitarrista utiliza equipo inalambrico
	 */
	private boolean inalambrico;
	/**
	 * Campo que indica si el guitarrista utiliza micrófono
	 */
	private boolean microfoneado;

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param descripcion
	 * @throws NombreMiembroNoValidoException
	 */
	public Guitarrista(String nombre, Procedencia procedencia, boolean inalambrico, boolean microfoneado) throws NombreMiembroNoValidoException {
		super(nombre, procedencia);
		setInalambrico(inalambrico);
		setMicrofoneado(microfoneado);
	}

	/**
	 * Método heredado para calcular el coste de material
	 */
	@Override
	public double calcularCoste() {
		double coste = 0;
		if (isInalambrico())
			coste += 70;
		if (isMicrofoneado())
			coste += 50;
		return coste;
	}

	private boolean isInalambrico() {
		return inalambrico;
	}

	private void setInalambrico(boolean inalambrico) {
		this.inalambrico = inalambrico;
	}

	private boolean isMicrofoneado() {
		return microfoneado;
	}

	private void setMicrofoneado(boolean microfoneado) {
		this.microfoneado = microfoneado;
	}

}
