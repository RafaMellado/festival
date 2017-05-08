package resurrectionFest.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.enumeraciones.Dias;

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
	 * Box de escenarios
	 */
	private JComboBox<Dias> boxDias;
	/**
	 * Botón seleccionar
	 */
	private JButton btnSeleccionar;

	/**
	 * Create the dialog.
	 */
	public MostrarPorDias() {
		configurarDialogo();
	}

	/**
	 * Evento
	 */
	protected void eventoGetGruposDias() {
		/**
		 * Avanza una posición en el iterador de componentes
		 */
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itGroups = Gestion.iteradorDias((Dias) boxDias.getSelectedItem());
				if (itGroups.hasNext()) {
					nextGroup();
					btnAnterior.setEnabled(false);
				} else
					JOptionPane.showMessageDialog(null, "No hay grupos en este dia", "No existen grupos",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	/**
	 * Configura el diálogo
	 */
	protected void configurarDialogo() {
		setTitle("Mostrar por dias");
		btnSiguiente.setEnabled(false);
		limpiar();
		seleccionar = new JLabel("Selecciona el dia");
		seleccionar.setBounds(27, 11, 138, 14);
		contentPane.add(seleccionar);

		boxDias = new JComboBox<Dias>();
		boxDias.setModel(new DefaultComboBoxModel<Dias>(Dias.values()));
		boxDias.setBounds(175, 8, 94, 20);
		contentPane.add(boxDias);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(280, 7, 120, 23);
		contentPane.add(btnSeleccionar);
		eventoGetGruposDias();

	}

}
