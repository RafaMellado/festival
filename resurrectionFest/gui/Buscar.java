package resurrectionFest.gui;

/**
 * Diálogo para buscar por nombre
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
public class Buscar extends MostrarGrupo {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Buscar() {
		configurar();
	}

	/**
	 * Configura el diálogo
	 */
	private void configurar() {
		setBounds(100, 100, 450, 408);
		setTitle("Buscar");
		defaultButton.setEnabled(false);
		defaultButton.setVisible(false);
		cancButton.setText("Salir");
	}

}
