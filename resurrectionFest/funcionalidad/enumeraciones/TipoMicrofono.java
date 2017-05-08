package resurrectionFest.funcionalidad.enumeraciones;

/**
 * Enumeración de tipos de micrófono
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public enum TipoMicrofono {
	/**
	 * Micrófono de la marca Rahget
	 */
	Rahget(30), 
	/**
	 * Micrófono de la marca Behrin
	 */
	Behrin(45.75), 
	/**
	 * Micrófono de la marca Addug
	 */
	Addug(70.5),
	/**
	 * Micrófono de la marca Behringer
	 */
	Behringer(80.5);

	/**
	 * Campo precio
	 */
	private double precio;

	/**
	 * Constructor
	 * @param precio
	 */
	private TipoMicrofono(double precio) {
		setPrecio(precio);
	}

	public double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}
}
