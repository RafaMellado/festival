package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.io.Serializable;
import java.util.ListIterator;
import java.util.regex.Pattern;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ComponentesVacioException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ErrorAlEliminarException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FormatoHoraNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreGrupoNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Dias;
import resurrectionFest.funcionalidad.enumeraciones.Escenarios;
import resurrectionFest.funcionalidad.enumeraciones.Estilo;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;

/**
 * Clase grupo
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Grupo implements Serializable, Comparable<Grupo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del grupo
	 */
	private String nombre;

	/**
	 * Procedencia del grupo
	 */
	private Procedencia procedencia;

	/**
	 * Escenario en el que actuará el grupo
	 */
	private Escenarios escenario;

	/**
	 * Día en el que actuará el grupo
	 */
	private Dias dia;

	/**
	 * Hora a la que actuará el grupo
	 */
	private String hora;

	/**
	 * Estilo de música del grupo
	 */
	private Estilo estilo;

	/**
	 * Componentes que forman el grupo
	 */
	private Componentes componentes;

	/**
	 * Patrón para comprobar que el nombre sea de al menos 2 caracteres
	 */
	private static final Pattern PATRON_NAME = Pattern.compile(".{2,}");

	/**
	 * Patrón para comprobar que la hora introducida sea válida
	 */
	private static final Pattern PATRON_HORA = Pattern.compile("2[0-3]\\:[0-5]\\d|1\\d\\:[0-5]\\d|0?\\d\\:[0-5]\\d");

	/**
	 * Método para añadir grupo
	 * 
	 * @param estilo
	 * @param nombre
	 * @param procedencia
	 * @param escenario
	 * @param dia
	 * @param hora
	 * @param componentes
	 * @throws NombreGrupoNoValidoException
	 * @throws FormatoHoraNoValidoException
	 * @throws ComponentesVacioException
	 */
	public Grupo(Estilo estilo, String nombre, Procedencia procedencia, Escenarios escenario, Dias dia, String hora,
			Componentes componentes)
					throws NombreGrupoNoValidoException, FormatoHoraNoValidoException, ComponentesVacioException {
		setEstilo(estilo);
		setNombre(nombre);
		setProcedencia(procedencia);
		setEscenario(escenario);
		setDia(dia);
		setHora(hora);
		setComponentes(componentes);
	}

	/**
	 * Constructor por nombre para buscar por nombre
	 * 
	 * @param nombre
	 * @throws NombreGrupoNoValidoException
	 */
	public Grupo(String nombre) throws NombreGrupoNoValidoException {
		setNombre(nombre);
	}

	/**
	 * Comprueba si el nombre es válido. Si lo es, lo asigna
	 * 
	 * @param nombre
	 * @throws NombreGrupoNoValidoException
	 */
	private void setNombre(String nombre) throws NombreGrupoNoValidoException {
		if (!comprobarNombre(nombre))
			throw new NombreGrupoNoValidoException("El nombre del grupo debe tener al menos 2 caracteres.");
		this.nombre = nombre;
	}

	/**
	 * Comprueba si la hora introducida es válida. Si lo es, la asigna.
	 * 
	 * @param hora
	 * @throws FormatoHoraNoValidoException
	 */
	private void setHora(String hora) throws FormatoHoraNoValidoException {
		if (!comprobarHora(hora))
			throw new FormatoHoraNoValidoException("El formato de la hora no es correcto (hh:mm)");
		this.hora = hora;
	}

	/**
	 * Comprueba si los componentes introducidos tienen, al menos, un miembro.
	 * Si lo tiene, lo asigna
	 * 
	 * @param componentes
	 * @throws ComponentesVacioException
	 */
	private void setComponentes(Componentes componentes) throws ComponentesVacioException {
		if (componentes.isEmpty())
			throw new ComponentesVacioException("Debes introducir al menos un componente");
		this.componentes = componentes;
	}

	/**
	 * Método para borrar un componente
	 * 
	 * @param nombre
	 * @throws NombreMiembroNoValidoException
	 * @throws ErrorAlEliminarException
	 */
	public void borrarComponente(String nombre) throws NombreMiembroNoValidoException, ErrorAlEliminarException {
		componentes.removeComponente(nombre);
	}

	/**
	 * Devuelve el listIterator de los componentes
	 * 
	 * @return listIterator
	 */
	public ListIterator<Miembros> getComponentesIterator() {
		return componentes.getComponentes().listIterator();
	}

	/**
	 * Devuelve el coste total del grupo
	 * 
	 * @return
	 */
	public double getCosteGrupo() {
		return componentes.getCosteComponentes();
	}

	/**
	 * Devuelve el nombre del escenario
	 * 
	 * @return cadena
	 */
	public String getNombreEscenario() {
		return escenario.getNombre();
	}

	/**
	 * Devuelve el numero de componentes del arraylist
	 * @return size
	 */
	public int getSizeComponentes() {
		return componentes.size();
	}
	
	/**
	 * Comprueba el nombre
	 * @param nombre
	 * @return boolean
	 */
	public static boolean comprobarNombre(String nombre){
		return PATRON_NAME.matcher(nombre).matches();
	}
	
	/**
	 * Comprueba la hora
	 * @param hora
	 * @return boolean
	 */
	public static boolean comprobarHora(String hora){
		return PATRON_HORA.matcher(hora).matches();
	}

	public String getNombre() {
		return nombre;
	}

	public Escenarios getEscenario() {
		return escenario;
	}

	private void setEscenario(Escenarios escenario) {
		this.escenario = escenario;
	}

	public Dias getDia() {
		return dia;
	}

	private void setDia(Dias dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public Procedencia getProcedencia() {
		return procedencia;
	}

	private void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	private void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public Componentes getComponentes() {
		return componentes;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Grupo o) {
		if (this.getCosteGrupo() > o.getCosteGrupo())
			return 1;
		if (this.getCosteGrupo() < o.getCosteGrupo())
			return -1;
		return 0;

	}

}
