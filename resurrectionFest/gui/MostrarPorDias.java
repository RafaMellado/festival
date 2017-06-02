package resurrectionFest.gui;

import javax.swing.JLabel;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;

public class MostrarPorDias extends MostrarFestival {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Label seleccionar
	 */
	private JLabel seleccionar;

	/**
	 * Create the dialog.
	 */
	public MostrarPorDias() {
		configurarDialogo();
	}

	/**
	 * Configura el diálogo
	 */
	protected void configurarDialogo() {
		itGroups = Gestion.iteradorDias();
		renovarDatos();
		setTitle("Mostrar por dias");
		seleccionar = new JLabel("Selecciona el dia");
		seleccionar.setBounds(27, 11, 138, 14);
		contentPane.add(seleccionar);
	}

}
