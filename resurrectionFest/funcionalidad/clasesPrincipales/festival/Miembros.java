package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.io.Serializable;
import java.util.regex.Pattern;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;

/**
 * Clase abstracta de Miembros
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
 public abstract class Miembros implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del miembro
	 */
	private String nombre;

	/**
	 * Procedencia del miembro
	 */
	private Procedencia procedencia;

	/**
	 * Patron del nombre (minimo 3 caracteres)
	 */
	private static final Pattern PATRON_NAME = Pattern.compile(".{3,}");

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param procedencia
	 * @throws NombreMiembroNoValidoException
	 */
	public Miembros(String nombre, Procedencia procedencia) throws NombreMiembroNoValidoException {
		setNombre(nombre);
		setProcedencia(procedencia);
	}

	/**
	 * Constructor para buscar por nombre
	 * 
	 * @param nombre
	 * @throws NombreMiembroNoValidoException
	 */
	public Miembros(String nombre) throws NombreMiembroNoValidoException {
		setNombre(nombre);
	}

	/**
	 * Metodo abstracto para calcular el coste de materiales de cada miembro
	 * 
	 * @return
	 */
	public abstract double calcularCoste();

	/**
	 * Comprueba si el nombre es válido. Si lo es, lo asigna
	 * 
	 * @param nombre
	 * @throws NombreMiembroNoValidoException
	 */
	private void setNombre(String nombre) throws NombreMiembroNoValidoException {
		if (!nombreValido(nombre))
			throw new NombreMiembroNoValidoException("El nombre no puede ser inferior a 3 caracteres");
		this.nombre = nombre;
	}
	
	/**
	 * Comprueba si el nombre es válido
	 * @param nombre
	 * @return boolean
	 */
	public static boolean nombreValido(String nombre){
		return PATRON_NAME.matcher(nombre).matches();
	}

	void modificarNombreProcedencia(String nombre, Procedencia procedencia) throws NombreMiembroNoValidoException{
		setNombre(nombre);
		setProcedencia(procedencia);
	}
	public String getNombre() {
		return nombre;
	}

	
	public Procedencia getProcedencia() {
		return procedencia;
	}

	private void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Miembros other = (Miembros) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

}
