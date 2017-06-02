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
public class Bajista extends Miembros {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Boolean para comprobar si utiliza el pedal atenuador
	 */
	private boolean pedalAtenuador;

	/**
	 * Boolean para comprobar si usa equipo inalámbrico
	 */
	private boolean inalambrico;

	/**
	 * Boolean para comprobar si utiliza micrófono
	 */
	private boolean microfoneado;

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param inalambrico
	 * @param microfoneado
	 * @throws NombreMiembroNoValidoException
	 */
	public Bajista(String nombre, Procedencia procedencia, boolean inalambrico, boolean microfoneado,
			boolean pedalAtenuador) throws NombreMiembroNoValidoException {
		super(nombre, procedencia);
		setInalambrico(inalambrico);
		setMicrofoneado(microfoneado);
		setPedalAtenuador(pedalAtenuador);
	}

	@Override
	public double calcularCoste() {
		double coste = 0;
		if (isInalambrico())
			coste += 70;
		if (isMicrofoneado())
			coste += 50;
		if (isPedalAtenuador())
			coste += 60;
		return coste;
	}

	private boolean isPedalAtenuador() {
		return pedalAtenuador;
	}

	private void setPedalAtenuador(boolean pedalAtenuador) {
		this.pedalAtenuador = pedalAtenuador;
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
