package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.io.Serializable;
import java.util.ArrayList;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ErrorAlEliminarException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.MiembroYaExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;
import resurrectionFest.funcionalidad.enumeraciones.TipoMicrofono;

/**
 * Envoltorio de miembros
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Componentes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ArrayList de Miembros
	 */
	private ArrayList<Miembros> componentes = new ArrayList<Miembros>();

	/**
	 * Metodo para añadir cantantes
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param descripcion
	 * @param inalambrico
	 * @param microfono
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public void addCantante(String nombre, Procedencia procedencia, boolean inalambrico, TipoMicrofono microfono)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		Cantante cantante = new Cantante(nombre, procedencia, inalambrico, microfono);
		comprobarMiembro(cantante);
		componentes.add(cantante);
	}

	/**
	 * Metodo para añadir batería
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param bombos
	 * @param platos
	 * @param sampleado
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public void addBateria(String nombre, Procedencia procedencia, int bombos, int platos, boolean sampleado)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		Bateria bateria = new Bateria(nombre, procedencia, bombos, platos, sampleado);
		comprobarMiembro(bateria);
		componentes.add(bateria);
	}

	/**
	 * Método para añadir guitarrista
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param inalambrico
	 * @param microfoneado
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public void addGuitarrista(String nombre, Procedencia procedencia, boolean inalambrico, boolean microfoneado)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		Guitarrista guitarra = new Guitarrista(nombre, procedencia, inalambrico, microfoneado);
		comprobarMiembro(guitarra);
		componentes.add(guitarra);

	}

	/**
	 * Metodo para añadir bajista
	 * 
	 * @param nombre
	 * @param procedencia
	 * @param inalambrico
	 * @param microfoneado
	 * @throws NombreMiembroNoValidoException
	 * @throws MiembroYaExisteException
	 */
	public void addBajista(String nombre, Procedencia procedencia, boolean inalambrico, boolean microfoneado)
			throws NombreMiembroNoValidoException, MiembroYaExisteException {
		Bajista bajista = new Bajista(nombre, procedencia, inalambrico, microfoneado);
		comprobarMiembro(bajista);
		componentes.add(bajista);

	}

	/**
	 * Método para comprobar si el miembro existe
	 * 
	 * @param miembro
	 * @throws MiembroYaExisteException
	 */
	private void comprobarMiembro(Miembros miembro) throws MiembroYaExisteException {
		if (componentes.contains(miembro))
			throw new MiembroYaExisteException("El miembro ya ha sido introducido");
	}

	/**
	 * Metodo para remover miembros
	 * 
	 * @param nombre
	 * @throws NombreMiembroNoValidoException
	 * @throws ErrorAlEliminarException
	 */
	public void removeComponente(String nombre) throws NombreMiembroNoValidoException, ErrorAlEliminarException {
		try {
			componentes.remove(new Cantante(nombre));
		} catch (IndexOutOfBoundsException e) {
			throw new ErrorAlEliminarException("No se ha podido eliminar");
		}
	}

	/**
	 * Calcula el coste total de materiales de los componentes
	 * 
	 * @return coste
	 */
	double getCosteComponentes() {
		double coste = 0;
		for (Miembros miembros : componentes) {
			coste += miembros.calcularCoste();
		}
		return coste;
	}
	

	/**
	 * Devuelve si el arraylist está vacío
	 * 
	 * @return
	 */
	boolean isEmpty() {
		return componentes.isEmpty();
	}

	int size() {
		return componentes.size();
	}

	ArrayList<Miembros> getComponentes() {
		return componentes;
	}

}
