package resurrectionFest.gui;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;

/**
 * Clase para mostrar por coste
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
public class MostrarPorCoste extends MostrarFestival {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MostrarPorCoste() {
		setTitle("Mostrar ordenado por coste");
		itGroups = Gestion.iteratorCoste();
		nextGroup();
		btnAnterior.setEnabled(false);
	}

}
