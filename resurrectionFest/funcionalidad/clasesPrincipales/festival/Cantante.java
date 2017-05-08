package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;
import resurrectionFest.funcionalidad.enumeraciones.TipoMicrofono;

/**
 * Clase cantante
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Cantante extends Miembros {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Campo que indica si el cantante utiliza equipo inalambrico
	 */
	private boolean inalambrico;
	/**
	 * Tipo de micrófono que utiliza
	 */
	private TipoMicrofono microfono;

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param descripcion
	 * @param inalambrico
	 * @param microfono
	 * @throws NombreMiembroNoValidoException
	 */
	public Cantante(String nombre, Procedencia procedencia, boolean inalambrico,
			TipoMicrofono microfono) throws NombreMiembroNoValidoException {
		super(nombre, procedencia);
		setInalambrico(inalambrico);
		setMicrofono(microfono);
	}

	/**
	 * Constructor para buscar por nombre
	 * 
	 * @param nombre
	 * @throws NombreMiembroNoValidoException
	 */
	public Cantante(String nombre) throws NombreMiembroNoValidoException {
		super(nombre);
	}

	/**
	 * Método heredado para calcular el coste de material
	 */
	@Override
	public double calcularCoste() {
		double equipo = 0;
		equipo += microfono.getPrecio();
		if (isInalambrico())
			equipo += 70;
		return equipo;
	}

	private boolean isInalambrico() {
		return inalambrico;
	}

	private void setInalambrico(boolean inalambrico) {
		this.inalambrico = inalambrico;
	}

	public TipoMicrofono getMicrofono() {
		return microfono;
	}

	private void setMicrofono(TipoMicrofono microfono) {
		this.microfono = microfono;
	}

}
