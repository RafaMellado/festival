package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ListIterator;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ComponentesVacioException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ErrorAlEliminarException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaNoValidaException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaPosteriorException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FormatoHoraNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.GrupoNoExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.GrupoYaExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.MiembroYaExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreGrupoNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Dias;
import resurrectionFest.funcionalidad.enumeraciones.Escenarios;
import resurrectionFest.funcionalidad.enumeraciones.Estilo;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;
import resurrectionFest.funcionalidad.enumeraciones.TipoMicrofono;

/**
 * Gestión del Festival
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */

public class Gestion {

	/**
	 * Nombre del festival
	 */
	private static String nombre = "Sin título - Resurrection Fest";
	/**
	 * Festival
	 */
	public static Festival festival = new Festival();
	/**
	 * Modificado
	 */
	public static boolean modificado = false;
	/**
	 * Componentes del grupo actual
	 */
	public static Componentes componentes = new Componentes();

	/**
	 * Abre un fichero nuevo
	 * 
	 * @param ruta
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void abrir(String ruta) throws ClassNotFoundException, FileNotFoundException, IOException {
		festival = Fichero.abrir(ruta);
		File file = new File(ruta);
		setModificado(false);
		setNombre(file.getName() + " - Resurrection Fest");
	}

	/**
	 * Guarda un fichero
	 * 
	 * @param ruta
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void guardar(String ruta) throws FileNotFoundException, IOException {
		File file = new File(ruta);
		Fichero.guardar(festival, ruta);
		setModificado(false);
		setNombre(file.getName() + ".fes - Resurrection Fest");
	}

	/**
	 * Añade un grupo
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
	 */
	public static void addGrupo(Estilo estilo, String nombre, Procedencia procedencia, Escenarios escenario, Dias dia,
			String hora, Componentes componentes) throws NombreGrupoNoValidoException, FormatoHoraNoValidoException,
					GrupoYaExisteException, ComponentesVacioException {
		festival.addGrupo(estilo, nombre, procedencia, escenario, dia, hora, componentes);
		setModificado(true);
	}

	/**
	 * Añade un cantante
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param inalambrico
	 * @param microfono
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public static void addCantante(String nombre, Procedencia procedencia, boolean inalambrico, TipoMicrofono microfono)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		componentes.addCantante(nombre, procedencia, inalambrico, microfono);
	}

	/**
	 * Añade un batería
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param bombos
	 * @param platos
	 * @param sampleado
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public static void addBateria(String nombre, Procedencia procedencia, int bombos, int platos, boolean sampleado)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		componentes.addBateria(nombre, procedencia, bombos, platos, sampleado);
	}

	/**
	 * Añade un guitarrista
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param inalambrico
	 * @param microfoneado
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public static void addGuitarrista(String nombre, Procedencia procedencia, boolean inalambrico, boolean microfoneado)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		componentes.addGuitarrista(nombre, procedencia, inalambrico, microfoneado);
	}

	/**
	 * Añade un bajista
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param inalambrico
	 * @param microfoneado
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public static void addBajista(String nombre, Procedencia procedencia, boolean inalambrico, boolean microfoneado)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		componentes.addBajista(nombre, procedencia, inalambrico, microfoneado);
	}

	/**
	 * Borra un grupo
	 * 
	 * @param nombre
	 * @throws ErrorAlEliminarException
	 * @throws NombreGrupoNoValidoException
	 */
	public static void removeGrupo(String nombre) throws ErrorAlEliminarException, NombreGrupoNoValidoException {
		festival.removeGrupo(nombre);
		setModificado(true);
	}

	/**
	 * Busca y devuelve un grupo
	 * 
	 * @param nombre
	 * @return grupo
	 * @throws NombreGrupoNoValidoException
	 * @throws GrupoNoExisteException
	 */
	public static Grupo buscarGrupo(String nombre) throws NombreGrupoNoValidoException, GrupoNoExisteException {
		return festival.buscarGrupo(nombre);
	}

	/**
	 * Modifica un grupo
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
	public static void modificarGrupo(String nombreActual, String nuevoNombre, Estilo estilo, Procedencia procedencia,
			Escenarios escenario, Dias dia, String hora, Componentes componentes)
					throws NombreGrupoNoValidoException, FormatoHoraNoValidoException, ComponentesVacioException {
		festival.modificarGrupo(nombreActual, nuevoNombre, estilo, procedencia, escenario, dia, hora, componentes);
		setModificado(true);
	}

	/**
	 * Devuelve el iterador de grupos
	 * 
	 * @return listiterator
	 */
	public static ListIterator<Grupo> getGruposIterator() {
		return festival.getIterator();
	}

	/**
	 * Devuelve el listIterator de grupos en la posición indicada
	 * 
	 * @param index
	 * @return listIterator
	 */
	public static ListIterator<Grupo> getGruposIteratorIndex(int index) {
		return festival.getIterator(index);
	}

	/**
	 * Devuelve el índice del grupo introducido
	 * 
	 * @param grupo
	 * @return indice
	 */
	public static int getIndexGrupo(Grupo grupo) {
		return festival.getGrupoIndex(grupo);
	}

	/**
	 * Devuelve el grupo del índice introducido
	 * 
	 * @param index
	 * @return grupo
	 */
	public static Grupo getGrupo(int index) {
		return festival.getGrupo(index);
	}

	/**
	 * Devuelve si el festival está vacío o no
	 * 
	 * @return boolean
	 */
	public static boolean isEmpty() {
		return festival.isEmpty();
	}

	/**
	 * Asigna la fecha de inicio al festival si es correcta
	 * 
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	public static void setFechaInicio(int dia, int mes, int anno)
			throws FechaNoValidaException, FechaPosteriorException {
		festival.setInicioFestival(dia, mes, anno);
		setModificado(true);
	}

	/**
	 * Asigna la fecha de final al festival si es correcta
	 * 
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	public static void setFechaFinal(int dia, int mes, int anno)
			throws FechaNoValidaException, FechaPosteriorException {
		festival.setFinalFestival(dia, mes, anno);
		setModificado(true);
	}

	/**
	 * Devuelve los días restantes del festival para que empiece
	 * 
	 * @return long
	 */
	public static long getDiasRestantes() {
		return festival.getDiasRestantes();
	}

	/**
	 * Devuelve la fecha de inicio del festival en formato castellano
	 * 
	 * @return fecha inicio
	 */
	public static String getFechaInicioString() {
		return festival.fechaInicioString();
	}

	/**
	 * Devuelve la fecha de final del festival en formato castellano
	 * 
	 * @return fecha final
	 */
	public static String getFechaFinalString() {
		return festival.fechaFinalString();
	}

	/**
	 * Devuelve el listiterador de grupos por coste
	 * 
	 * @return listiterator
	 */
	public static ListIterator<Grupo> iteratorCoste() {
		return festival.iteradorCoste();
	}

	/**
	 * Devuelve el listiterador de grupos por escenarios
	 * 
	 * @return listiterator
	 */
	public static ListIterator<Grupo> iteradorEscenarios(Escenarios escenario) {
		return festival.iteradorEscenarios(escenario);
	}

	/**
	 * Devuelve el listiterador de grupos por dias
	 * 
	 * @return listiterator
	 */
	public static ListIterator<Grupo> iteradorDias(Dias dia) {
		return festival.iteradorDias(dia);
	}

	public static LocalDate getFechaInicio() {
		return festival.getFechaInicio();
	}

	public static LocalDate getFechaFinal() {
		return festival.getFechaFinal();
	}

	public static String getNombre() {
		return nombre;
	}

	private static void setNombre(String nombre) {
		Gestion.nombre = nombre;
	}

	public static boolean isModificado() {
		return modificado;
	}

	static void setModificado(boolean modificado) {
		Gestion.modificado = modificado;
	}

}
