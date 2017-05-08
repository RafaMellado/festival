package resurrectionFest.funcionalidad.enumeraciones;

/**
 * Enumeraci�n de tipos de micr�fono
 * @author Rafael Mellado Jim�nez
 * @version 1.0
 *
 */
public enum TipoMicrofono {
	/**
	 * Micr�fono de la marca Rahget
	 */
	Rahget(30), 
	/**
	 * Micr�fono de la marca Behrin
	 */
	Behrin(45.75), 
	/**
	 * Micr�fono de la marca Addug
	 */
	Addug(70.5),
	/**
	 * Micr�fono de la marca Behringer
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
