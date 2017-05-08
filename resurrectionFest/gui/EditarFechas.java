package resurrectionFest.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Fecha;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaNoValidaException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaPosteriorException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.time.LocalDate;
import java.time.Month;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Dialogo para editar las fechas del festival
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 */
public class EditarFechas extends JDialog {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * ComboBox de meses para la fecha de inicio
	 */
	private JComboBox<String> boxMesInicio;
	/**
	 * ComboBox de años para la fecha de inicio
	 */
	private JComboBox<Integer> boxAnnoInicio;
	/**
	 * ComboBox de dias para la fecha de inicio
	 */
	private JComboBox<Integer> boxDiasInicio;
	/**
	 * ComboBox de días para la fecha de final
	 */
	private JComboBox<Integer> boxDiasFinal;
	/**
	 * ComboBox de años para la fecha de final
	 */
	private JComboBox<Integer> boxAnnoFinal;
	/**
	 * ComboBox de meses para la fecha de final
	 */
	private JComboBox<String> boxMesFinal;
	/**
	 * Label con la fecha del final del festival en formato cadena
	 */
	private JLabel lblFechaDelFinal;
	/**
	 * Label con la fecha de inicio del festival en formato cadena
	 */
	private JLabel lblFechaDeInicio;
	/**
	 * Titulo de los box de fecha final
	 */
	private JLabel lblFechaFinal;
	/**
	 * Titulo de los box de la fecha de inicio
	 */
	private JLabel lblFechaInicio;
	/**
	 * Boton de modificar la fecha de inicio
	 */
	private JButton btnModificarInicio;
	/**
	 * Botón de modificar la fecha de final
	 */
	private JButton btnModificarFinal;

	/**
	 * Create the dialog.
	 */
	public EditarFechas() {
		configuracion();
		eventos();
	}

	/**
	 * Actualiza los días de la fecha de inicio en funcion del mes y año
	 * seleccionado
	 */
	private void actualizarInicio() {
		int dia = (Integer) boxDiasInicio.getSelectedItem();
		boxDiasInicio.setModel(new DefaultComboBoxModel<Integer>(
				Fecha.getDias(getMesSeleccionadoInicio(), (Integer) boxAnnoInicio.getSelectedItem())));
		boxDiasInicio.setSelectedItem(dia);
	}

	/**
	 * Actualiza los días de la fecha de final en funcion del mes y año
	 * seleccionado
	 */
	private void actualizarFinal() {
		int dia = (Integer) boxDiasFinal.getSelectedItem();
		boxDiasFinal.setModel(new DefaultComboBoxModel<Integer>(
				Fecha.getDias(getMesSeleccionadoFinal(), (Integer) boxAnnoFinal.getSelectedItem())));
		boxDiasFinal.setSelectedItem(dia);
	}

	/**
	 * Devuelve el mes seleccionado de la fecha de inicio
	 * 
	 * @return mes
	 */
	private Month getMesSeleccionadoInicio() {
		return Month.values()[boxMesInicio.getSelectedIndex()];
	}

	/**
	 * Devuelve el mes seleccionado de la fecha de final
	 * 
	 * @return mes
	 */
	private Month getMesSeleccionadoFinal() {
		return Month.values()[boxMesFinal.getSelectedIndex()];
	}

	/**
	 * Eventos
	 */
	private void eventos() {
		/**
		 * Actualiza el numero de días de la fecha final si el box del mes
		 * cambia
		 */
		boxMesFinal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				actualizarFinal();
			}
		});

		/**
		 * Actualiza el numero de días de la fecha final si el box del año
		 * cambia
		 */
		boxAnnoFinal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				actualizarFinal();
			}
		});

		/**
		 * Actualiza el numero de días de la fecha del inicio si el box del mes
		 * cambia
		 */
		boxMesInicio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				actualizarInicio();
			}
		});

		/**
		 * Actualiza el numero de días de la fecha del inicio si el año del mes
		 * cambia
		 */
		boxAnnoInicio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				actualizarInicio();
			}
		});

		/**
		 * Evento para modificar la fecha de inicio
		 */
		btnModificarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gestion.setFechaInicio((Integer) boxDiasInicio.getSelectedItem(),
							getMesSeleccionadoInicio().getValue(), (Integer) boxAnnoInicio.getSelectedItem());
					lblFechaDeInicio.setText("Fecha de inicio actual: " + Gestion.getFechaInicioString());

				} catch (FechaNoValidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Fecha no valida", JOptionPane.ERROR_MESSAGE);
				} catch (FechaPosteriorException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Fecha posterior", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		/**
		 * Evento para modificar la fecha del final
		 */
		btnModificarFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gestion.setFechaFinal((Integer) boxDiasFinal.getSelectedItem(),
							getMesSeleccionadoFinal().getValue(), (Integer) boxAnnoFinal.getSelectedItem());
					lblFechaDelFinal.setText("Fecha de final actual: " + Gestion.getFechaFinalString());
				} catch (FechaNoValidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Fecha no valida", JOptionPane.ERROR_MESSAGE);
				} catch (FechaPosteriorException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Fecha no valida", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Configuracion
	 */
	private void configuracion() {
		setModal(true);
		setTitle("Editar fechas");
		setBounds(100, 100, 450, 294);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(255, 250, 205));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblFechaInicio = new JLabel("Fecha Inicio");
			lblFechaInicio.setBounds(162, 11, 105, 14);
			contentPanel.add(lblFechaInicio);
		}

		boxMesInicio = new JComboBox<String>();

		boxAnnoInicio = new JComboBox<Integer>();

		boxAnnoInicio.setModel(new DefaultComboBoxModel<Integer>(Fecha.getAnnos()));
		boxAnnoInicio.setSelectedItem(Gestion.getFechaInicio().getYear());
		boxAnnoInicio.setBounds(263, 66, 64, 22);
		contentPanel.add(boxAnnoInicio);

		boxMesInicio.setModel(new DefaultComboBoxModel<String>(Fecha.getMeses()));
		boxMesInicio.setSelectedItem(Fecha.getMesCastellano(Gestion.getFechaInicio()));
		boxMesInicio.setBounds(148, 66, 105, 22);
		contentPanel.add(boxMesInicio);

		boxDiasInicio = new JComboBox<Integer>();
		boxDiasInicio.setModel(new DefaultComboBoxModel<Integer>(
				Fecha.getDias(getMesSeleccionadoInicio(), LocalDate.now().getYear())));
		boxDiasInicio.setSelectedItem(Gestion.getFechaInicio().getDayOfMonth());
		boxDiasInicio.setBounds(81, 66, 57, 22);
		contentPanel.add(boxDiasInicio);
	
		btnModificarInicio = new JButton("Modificar");
		
		btnModificarInicio.setBounds(341, 66, 91, 23);
		contentPanel.add(btnModificarInicio);

		lblFechaDeInicio = new JLabel("Fecha de inicio actual: " + Gestion.getFechaInicioString());
		lblFechaDeInicio.setBounds(81, 41, 246, 14);
		contentPanel.add(lblFechaDeInicio);

		boxMesFinal = new JComboBox<String>();
		boxMesFinal.setBounds(148, 174, 105, 22);
	
		boxMesFinal.setModel(new DefaultComboBoxModel<String>(Fecha.getMeses()));
		boxMesFinal.setSelectedItem(Fecha.getMesCastellano(Gestion.getFechaFinal()));
		contentPanel.add(boxMesFinal);

		boxAnnoFinal = new JComboBox<Integer>();
		boxAnnoFinal.setBounds(263, 174, 64, 22);
	
		boxAnnoFinal.setModel(new DefaultComboBoxModel<Integer>(Fecha.getAnnos()));
		boxAnnoFinal.setSelectedItem(Gestion.getFechaFinal().getYear());
		contentPanel.add(boxAnnoFinal);

		boxDiasFinal = new JComboBox<Integer>();
		boxDiasFinal.setBounds(81, 174, 57, 22);
		boxDiasFinal
				.setModel(new DefaultComboBoxModel<Integer>(Fecha.getDias(Month.JANUARY, LocalDate.now().getYear())));
		boxDiasFinal.setSelectedItem(Gestion.getFechaFinal().getDayOfMonth());
		contentPanel.add(boxDiasFinal);
		
		
		btnModificarFinal = new JButton("Modificar");
		btnModificarFinal.setBounds(341, 174, 91, 23);
		contentPanel.add(btnModificarFinal);

		lblFechaDelFinal = new JLabel("Fecha del final actual: " + Gestion.getFechaFinalString());
		lblFechaDelFinal.setBounds(81, 149, 231, 14);
		contentPanel.add(lblFechaDelFinal);
		
		lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setBounds(162, 112, 105, 14);
		contentPanel.add(lblFechaFinal);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 250, 205));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Gestion.getFechaInicio().isAfter(Gestion.getFechaFinal()))
								JOptionPane.showMessageDialog(null, "La fecha de final no puede ser antes que la de inicio","Error en la fecha del final",
										JOptionPane.ERROR_MESSAGE);
						else
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
