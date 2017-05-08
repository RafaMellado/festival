package resurrectionFest.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.enumeraciones.Escenarios;

/**
 * Clase para mostrar por escenario
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
public class MostrarPorEscenario extends MostrarFestival {

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
	private JComboBox<String> boxEscenarios;
	/**
	 * Botón seleccionar
	 */
	private JButton btnSeleccionar;


	/**
	 * Create the dialog.
	 */
	public MostrarPorEscenario() {
		configurarDialogo();
	}

	/**
	 * Evento
	 */
	protected void eventoGetGruposEscenarios() {
		/**
		 * Avanza una posición en el iterador de componentes
		 */
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itGroups = Gestion.iteradorEscenarios(getEscenario());
				if (itGroups.hasNext()) {
					nextGroup();
					btnAnterior.setEnabled(false);
				} else
					JOptionPane.showMessageDialog(null, "No hay grupos en este escenario", "No existen grupos",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	/**
	 * Devuelve el escenario
	 * @return escenario
	 */
	protected Escenarios getEscenario() {
		if (boxEscenarios.getSelectedItem().equals(Escenarios.MS.getNombre()))
			return Escenarios.MS;
		if (boxEscenarios.getSelectedItem().equals(Escenarios.RS.getNombre()))
			return Escenarios.RS;
		if (boxEscenarios.getSelectedItem().equals(Escenarios.CS.getNombre()))
			return Escenarios.CS;
		return Escenarios.DS;
	}
	

	/**
	 * Configura el diálogo
	 */
	protected void configurarDialogo() {
		btnSiguiente.setEnabled(false);
		limpiar();
		seleccionar = new JLabel("Selecciona el escenario");
		seleccionar.setBounds(27, 11, 138, 14);
		contentPane.add(seleccionar);
		
		boxEscenarios = new JComboBox<String>();
		boxEscenarios.setModel(new DefaultComboBoxModel<String>(Escenarios.nombreEscenarios()));
		boxEscenarios.setBounds(175, 8, 94, 20);
		contentPane.add(boxEscenarios);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(280, 7, 120, 23);
		contentPane.add(btnSeleccionar);
		
		eventoGetGruposEscenarios();
	}

}
