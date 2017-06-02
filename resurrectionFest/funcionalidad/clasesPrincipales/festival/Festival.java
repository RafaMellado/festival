package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ListIterator;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Componentes;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Grupo;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ComponentesVacioException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ErrorAlEliminarException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.EscenarioHoraNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaNoValidaException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaPosteriorException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FormatoHoraNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.GrupoNoExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.GrupoYaExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreGrupoNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Escenarios;
import resurrectionFest.funcionalidad.enumeraciones.Estilo;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;

/**
 * Envoltorio de grupos
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Festival implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ArrayList de grupos
	 */
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();

	// /**
	// * Fecha de inicio del festival
	// */
	// private LocalDate fechaInicio = LocalDate.now();
	//
	// /**
	// * Fecha del final del festival
	// */
	// private LocalDate fechaFinal = LocalDate.now();
	private Fecha fecha = new Fecha();

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
	 * @throws GrupoYaExisteException
	 * @throws ComponentesVacioException
	 * @throws EscenarioHoraNoValidoException
	 */
	void addGrupo(Estilo estilo, String nombre, Procedencia procedencia, Escenarios escenario, Date date,
			Componentes componentes, int duracion) throws NombreGrupoNoValidoException, FormatoHoraNoValidoException,
			GrupoYaExisteException, ComponentesVacioException, EscenarioHoraNoValidoException {
		Grupo grupo = new Grupo(estilo, nombre, procedencia, escenario, date, componentes, duracion);
		if (grupos.contains(grupo))
			throw new GrupoYaExisteException("El grupo ya existe");
		if (!comprobarEscenarioDuracion(grupo))
			throw new EscenarioHoraNoValidoException(
					"No puedes introducir un grupo en el mismo escenario que otro grupo que toca en ese tramo horario");

		grupos.add(grupo);
	}

	/**
	 * Método para eliminar grupo
	 * 
	 * @param nombre
	 * @throws ErrorAlEliminarException
	 * @throws NombreGrupoNoValidoException
	 */
	void removeGrupo(String nombre) throws ErrorAlEliminarException, NombreGrupoNoValidoException {
		try {
			grupos.remove(new Grupo(nombre));
		} catch (IndexOutOfBoundsException e) {
			throw new ErrorAlEliminarException("No se ha podido eliminar");
		}
	}

	/**
	 * Método para buscar grupo
	 * 
	 * @param nombre
	 * @return
	 * @throws NombreGrupoNoValidoException
	 * @throws GrupoNoExisteException
	 */
	Grupo buscarGrupo(String nombre) throws NombreGrupoNoValidoException, GrupoNoExisteException {
		try {
			return grupos.get(grupos.indexOf(new Grupo(nombre)));
		} catch (IndexOutOfBoundsException e) {
			throw new GrupoNoExisteException("No existe grupo con ese nombre");
		}
	}

	/**
	 * Método para modificar grupo
	 * 
	 * @param nombreActual
	 * @param nuevoNombre
	 * @param estilo
	 * @param procedencia
	 * @param escenario
	 * @param dia
	 * @param hora
	 * @param componentes
	 * @throws NombreGrupoNoValidoException
	 * @throws FormatoHoraNoValidoException
	 * @throws ComponentesVacioException
	 */
	void modificarGrupo(String nombreActual, String nuevoNombre, Estilo estilo, Procedencia procedencia,
			Escenarios escenario, Date date, Componentes componentes, int duracion)
			throws NombreGrupoNoValidoException, FormatoHoraNoValidoException, ComponentesVacioException {
		Grupo grupo = new Grupo(estilo, nuevoNombre, procedencia, escenario, date, componentes, duracion);
		grupos.set(grupos.indexOf(new Grupo(nombreActual)), grupo);

	}

	/**
	 * Devuelve el listIterator de grupos
	 * 
	 * @return listIterator
	 */
	ListIterator<Grupo> getIterator() {
		return grupos.listIterator();
	}

	/**
	 * Devuelve el listIterator de grupos en la posición indicada
	 * 
	 * @param index
	 * @return listIterator
	 */
	ListIterator<Grupo> getIterator(int index) {
		return grupos.listIterator(index);
	}

	/**
	 * Devuelve el indice del grupo en el arraylist
	 * 
	 * @param grupo
	 * @return entero
	 * @throws NombreGrupoNoValidoException
	 */
	int getGrupoIndex(Grupo grupo) {
		return grupos.indexOf(grupo);
	}

	/**
	 * Devuelve el grupo del índice introducido
	 * 
	 * @param index
	 * @return grupo
	 */

	Grupo getGrupo(int index) {
		return grupos.get(index);
	}

	/**
	 * Devuelve el tamaño del arraylist
	 * 
	 * @return size
	 */
	int size() {
		return grupos.size();
	}

	/**
	 * Devuelve si el festival está vacío o no
	 * 
	 * @return boolean
	 */
	boolean isEmpty() {
		return grupos.isEmpty();
	}

	/**
	 * Comprueba si la fecha de inicio del festival es correcta y la asigna.
	 * 
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	void setInicioFestival(int dia, int mes, int anno) throws FechaPosteriorException, FechaNoValidaException {
		fecha.setFechaInicio(dia, mes, anno);
	}

	/**
	 * Comprueba si la fecha de final del festival es correcta y la asigna.
	 * 
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	void setFinalFestival(int dia, int mes, int anno) throws FechaPosteriorException, FechaNoValidaException {
		fecha.setFechaFinal(dia, mes, anno);
	}

	/**
	 * Devuelve los días restantes del festival para que este empiece
	 * 
	 * @return
	 */
	long getDiasRestantes() {
		return fecha.getDiasRestantes();
	}

	/**
	 * Get fecha de inicio en cadena
	 * 
	 * @return cadena
	 */
	String getFechaInicioString() {
		return fecha.getFechaEspanola(fecha.getFechaInicio());
	}

	/**
	 * Get fecha de final en cadena
	 * 
	 * @return cadena
	 */
	String getFechaFinalString() {
		return fecha.getFechaEspanola(fecha.getFechaFinal());
	}

	/**
	 * Crea un arrayList ordenado por coste y devuelve el iterador
	 * 
	 * @return iterador
	 */
	ListIterator<Grupo> iteradorCoste() {
		ArrayList<Grupo> arrayList = new ArrayList<Grupo>();
		for (Grupo grupo : grupos) {
			arrayList.add(grupo);
		}
		Collections.sort(arrayList);
		return arrayList.listIterator();
	}

	/**
	 * ArrayList de grupos filtrados por escenario
	 * 
	 * @param escenario
	 * @return arraylist
	 */
	private ArrayList<Grupo> arrayEscenario(Escenarios escenario) {
		ArrayList<Grupo> arrayList = new ArrayList<Grupo>();
		for (Grupo grupo : grupos) {
			if (grupo.getEscenario() == escenario)
				arrayList.add(grupo);
		}
		return arrayList;
	}

	/**
	 * ArrayList de grupos filtrados por dias
	 * 
	 * @param escenario
	 * @return arraylist
	 */
	public ListIterator<Grupo> iteratorDias() {
		ArrayList<Grupo> arrayList = new ArrayList<Grupo>();
		for (Grupo grupo : grupos) {
			arrayList.add(grupo);
		}
		Collections.sort(arrayList, new Comparator<Grupo>() {
			public int compare(Grupo arg0, Grupo arg1) {
				if (arg0.getDate().after(arg1.getDate()))
					return 1;
				else if (arg0.getDate().before(arg1.getDate()))
					return -1;
				return 0;
			}

		});
		return arrayList.listIterator();
	}

	/**
	 * Devuelve el listiterator de grupos por escenario
	 * 
	 * @param escenario
	 * @return listiterador
	 */
	ListIterator<Grupo> iteradorEscenarios(Escenarios escenario) {
		return arrayEscenario(escenario).listIterator();
	}

	/**
	 * Devuelve la fecha de inicio
	 * 
	 * @return fecha
	 */
	LocalDate getFechaInicio() {
		return fecha.getFechaInicio();
	}

	/**
	 * Devuelve la fecha del final
	 * 
	 * @return fecha
	 */
	LocalDate getFechaFinal() {
		return fecha.getFechaFinal();
	}

	/**
	 * Devuelve un array de fechas disponibles
	 * 
	 * @return fechas
	 */
	LocalDate[] getFechas() {
		return fecha.getFechas();
	}

	/**
	 * Devuelve una array de las fechas disponibles en formato string
	 * 
	 * @return array de cadenas
	 */
	String[] getFechasString() {
		return fecha.getFechasString();
	}

	@SuppressWarnings("deprecation")
	private boolean comprobarEscenarioDuracion(Grupo grupo) {
		if (grupos.isEmpty())
			return true;
		for (Grupo group : grupos) {
			Date fecha = (Date) group.getDate().clone();
			fecha.setMinutes(group.getDate().getMinutes() + group.getDuracion());
			if (group.getEscenario() == grupo.getEscenario() && 
					(group.getHora().equals(grupo.getHora())
					|| (!grupo.getDate().before(group.getDate()) && !grupo.getDate().after(fecha))))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Festival [grupos=" + grupos + "]";
	}

}
