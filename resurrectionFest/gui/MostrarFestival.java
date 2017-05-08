package resurrectionFest.gui;

import java.util.ListIterator;

import javax.swing.JButton;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Grupo;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

abstract class MostrarFestival extends MostrarGrupo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Botón anterior del iterador del festival
	 */
	protected JButton btnAnterior;
	/**
	 * Botón siguiente del iterador del festival
	 */
	protected JButton btnSiguiente;
	/**
	 * Campo de texto para ver o introducir la posición del grupo en el
	 * arraylist
	 */
	protected JLabel lblPosicion;
	/**
	 * Muestra el total de grupos del festival
	 */
	protected ListIterator<Grupo> itGroups = Gestion.getGruposIterator();
	/**
	 * Create the dialog.
	 */
	public MostrarFestival() {
		configurar();
		eventos();
	}

	/**
	 * Avanza una posición en el iterador de grupos si es posible
	 */
	protected void nextGroup() {
		if (itGroups.hasNext()) {
			group = itGroups.next();
			if (group.getNombre().equals(lblMostrarGrupoName.getText()) && itGroups.hasNext())
				group = itGroups.next();
		}
		renovarDatos();
		if (!itGroups.hasNext())
			btnSiguiente.setEnabled(false);
		else
			btnSiguiente.setEnabled(true);
		if (!itGroups.hasPrevious())
			btnAnterior.setEnabled(false);
		else
			btnAnterior.setEnabled(true);
	}

	/**
	 * Retrasa una posición en el iterador de grupos si es posible
	 */
	protected void previousGroup() {
		if (itGroups.hasPrevious()) {
			group = itGroups.previous();
			if (group.getNombre().equals(lblMostrarGrupoName.getText()) && itGroups.hasPrevious())
				group = itGroups.previous();
		}
		renovarDatos();
		if (!itGroups.hasPrevious())
			btnAnterior.setEnabled(false);
		else
			btnAnterior.setEnabled(true);
		if (!itGroups.hasNext())
			btnSiguiente.setEnabled(false);
		else
			btnSiguiente.setEnabled(true);
	}

	/**
	 * Configura los eventos
	 */
	private void eventos() {
		/**
		 * Retrasa una posición en el iterador de grupos
		 */
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousGroup();
			}
		});

		/**
		 * Avanza una posición en el iterador de grupos
		 */
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextGroup();
			}
		});



	}	
	/**
	 * Configura el diálogo
	 */
	private void configurar() {
		btnBuscar.setEnabled(false);
		btnBuscar.setVisible(false);
		fieldBuscar.setEnabled(false);
		fieldBuscar.setVisible(false);
		lblBuscar.setEnabled(false);
		lblBuscar.setVisible(false);
		btnAnterior = new JButton("Anterior");
		setBounds(100, 100, 450, 450);
		defaultButton.setEnabled(false);
		defaultButton.setVisible(false);
		cancButton.setBounds(341, 385, 91, 23);
		cancButton.setText("Salir");

		btnAnterior.setBounds(94, 348, 91, 23);
		getContentPane().add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(229, 348, 91, 23);
		getContentPane().add(btnSiguiente);

		lblPosicion = new JLabel();
		lblPosicion.setBounds(188, 161, 24, 20);
		getContentPane().add(lblPosicion);


		nextGroup();
		btnAnterior.setEnabled(false);
	}

}
