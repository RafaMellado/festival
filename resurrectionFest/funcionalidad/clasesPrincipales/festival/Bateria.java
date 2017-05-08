package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;

/**
 * Clase Batería
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Bateria extends Miembros {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Numero de platos de la batería
	 */
	private int platos;
	/**
	 * Numero de bombos de la bateria
	 */
	private int bombos;
	/**
	 * Campo que nos indica si el batería utiliza sampleado
	 */
	private boolean sampleado;

	/**
	 * Constructor
	 * @param nombre
	 * @param procedencia
	 * @param descripcion
	 * @param platos
	 * @param bombos
	 * @param sampleado
	 * @throws NombreMiembroNoValidoException
	 */
	public Bateria(String nombre, Procedencia procedencia, int platos, int bombos, boolean sampleado)
			throws NombreMiembroNoValidoException {
		super(nombre, procedencia);
		setPlatos(platos);
		setBombos(bombos);
		setSampleado(sampleado);
	}

	/**
	 * Método heredado para calcular el coste de material
	 */
	@Override
	public double calcularCoste() {
		int costeSample = 0;
		if(isSampleado())
			costeSample = 200;
		return (getPlatos()*50)+ (getBombos()*100) + costeSample;
	}

	private int getBombos() {
		return bombos;
	}

	private void setBombos(int bombos) {
		this.bombos = bombos;
	}

	public int getPlatos() {
		return platos;
	}

	private void setPlatos(int platos) {
		this.platos = platos;
	}

	private boolean isSampleado() {
		return sampleado;
	}

	private void setSampleado(boolean sampleado) {
		this.sampleado = sampleado;
	}

}
