package resurrectionFest.gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;
import resurrectionFest.funcionalidad.enumeraciones.TipoMicrofono;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Componentes;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Fecha;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Grupo;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Miembros;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ComponentesVacioException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.EscenarioHoraNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FormatoHoraNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.GrupoYaExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.MiembroYaExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreGrupoNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreMiembroNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Escenarios;
import resurrectionFest.funcionalidad.enumeraciones.Estilo;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Clase GUI para Añadir grupo
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class AnnadirGrupo extends JDialog {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Contenedor
	 */
	private JPanel contentPane;
	/**
	 * TextField del nombre del grupo
	 */
	protected JTextField fieldName;
	/**
	 * Grupo de botones para los escenarios
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Botón del Desert Stage
	 */
	private JRadioButton desertButton;
	/**
	 * Botón del Ritual Stage
	 */
	private JRadioButton ritualButton;
	/**
	 * Botón del Main Stage
	 */
	private JRadioButton mainButton;
	/**
	 * Boton del Chaos Stage
	 */
	private JRadioButton chaosButton;
	/**
	 * Label del nombre del grupo
	 */
	private JLabel lblName;
	/**
	 * Label de Procedencia del grupo
	 */
	private JLabel lblProcedencia;
	/**
	 * Label del Escenario del grupo
	 */
	private JLabel lblEscenario;
	/**
	 * Label del día en el que tocará el grupo
	 */
	private JLabel lblDia;
	/**
	 * Label de la hora de actuación
	 */
	private JLabel lblHora;
	/**
	 * TextField de la hora
	 */
	private JTextField fieldHora;
	/**
	 * Label del estilo del grupo
	 */
	private JLabel lblEstilo;
	/**
	 * ComboBox que contiene el estilo del grupo
	 */
	private JComboBox<Estilo> boxEstilo;
	/**
	 * TextField del nombre del componente
	 */
	private JTextField nameComponente;
	/**
	 * Label del tipo de microfono para cantantes
	 */
	private JLabel lblTipoMicrofono;
	/**
	 * Label para el número de bombos para el batería
	 */
	private JLabel lblBombos;
	/**
	 * Label para el número de platos para el batería
	 */
	private JLabel lblPlatos;
	/**
	 * Spinner para seleccionar el número de platos del batería
	 */
	private JSpinner platosSpin;
	/**
	 * Spinner para seleccionar el número de bombos del batería
	 */
	private JSpinner bombosSpin;
	/**
	 * ComboBox para seleccionar que tipo de miembro es: si batería, cantante...
	 */
	private JComboBox<String> tipoMiembroBox;
	/**
	 * ComboBox para seleccionar el tipo de micrófono para el cantante
	 */
	private JComboBox<TipoMicrofono> boxMicrofono;
	/**
	 * CheckBox para seleccionar si se utiliza sampleado
	 */
	private JCheckBox checkSampleado;
	/**
	 * ComoBox para seleccionar la procedencia del grupo
	 */
	private JComboBox<Procedencia> boxProcedencia;
	/**
	 * Botón para añadir el grupo
	 */
	private JButton btnAdd;
	/**
	 * Botón cancelar
	 */
	private JButton btnCancelar;
	/**
	 * Label que contiene el título de grupo
	 */
	private JLabel lblGrupo;
	/**
	 * Label que contiene el título de componentes
	 */
	private JLabel lblComponentes;
	/**
	 * Label que contiene el nombre del grupo
	 */
	private JLabel lblNombre;
	/**
	 * Label que contiene la procedencia del componente
	 */
	private JLabel lblProcedencia_1;
	/**
	 * ComboBox que contiene la procedencia del componente
	 */
	private JComboBox<Procedencia> boxProcComp;
	/**
	 * Botón para añadir el componente
	 */
	private JButton btnAadirComponente;
	/**
	 * Boton para activar la vista de componentes
	 */
	private JButton btnVerComponentes;
	/**
	 * Comprueba si el equipo es inalambrico
	 */
	private JCheckBox checkInalambrico;
	/**
	 * Comprueba si el miembro está microfoneado
	 */
	private JCheckBox checkMicrofoneado;
	private JCheckBox chckbxPedalAtenuador;
	private JComboBox<String> boxDia;
	private JComboBox<String> boxDuracion;

	/**
	 * Create the Dialog.
	 */
	public AnnadirGrupo() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AnnadirGrupo.class.getResource("/resurrectionFest/imagenes/logo.png")));
		configuracion();
		eventos();

	}

	/**
	 * Configura los eventos
	 */
	private void eventos() {

		/**
		 * Evento para comprobar si el nombre del componente es válido
		 */
		nameComponente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Miembros.nombreValido(nameComponente.getText()))
					nameComponente.setForeground(Color.RED);
				else
					nameComponente.setForeground(Color.BLACK);
				if (nameComponente.getText() == "")
					nameComponente.setForeground(Color.BLACK);
			}
		});

		/**
		 * Evento para comprobar el nombre del grupo
		 */
		fieldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!Grupo.comprobarNombre(fieldName.getText()))
					fieldName.setForeground(Color.RED);
				else
					fieldName.setForeground(Color.BLACK);
				if (fieldName.getText() == "")
					fieldName.setForeground(Color.BLACK);
			}
		});

		/**
		 * Evento para comprobar la hora válida
		 */
		fieldHora.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!Fecha.comprobarHora(fieldHora.getText()))
					fieldHora.setForeground(Color.RED);
				else
					fieldHora.setForeground(Color.BLACK);
				if (fieldHora.getText() == "")
					fieldHora.setForeground(Color.BLACK);
			}
		});

		/**
		 * Evento del comboBox del tipo de miembro
		 */
		tipoMiembroBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				actualizarCamposComponentes();
			}
		});

		/**
		 * Evento del botón añadir
		 */
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gestion.addGrupo((Estilo) boxEstilo.getSelectedItem(), fieldName.getText(),
							(Procedencia) boxProcedencia.getSelectedItem(), getEscenario(),
							Gestion.getFechaGrupo(Gestion.getFechas()[boxDia.getSelectedIndex()], fieldHora.getText()),
							Gestion.componentes, getDuracion());
					limpiarCampos();
				} catch (NombreGrupoNoValidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error al añadir nombre",
							JOptionPane.ERROR_MESSAGE);
				} catch (FormatoHoraNoValidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error al añadir hora",
							JOptionPane.ERROR_MESSAGE);
				} catch (GrupoYaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Ya existe el grupo",
							JOptionPane.ERROR_MESSAGE);
				} catch (ComponentesVacioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error al añadir componentes",
							JOptionPane.ERROR_MESSAGE);
				} catch (EscenarioHoraNoValidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error en tramo horario",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		/**
		 * Evento del botón cancelar
		 */
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		/**
		 * Evento del botón añadir componente
		 */
		btnAadirComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (tipoMiembroBox.getSelectedItem().equals("Cantante")) {

						Gestion.addCantante(nameComponente.getText(), (Procedencia) boxProcedencia.getSelectedItem(),
								checkInalambrico.isSelected(), (TipoMicrofono) boxMicrofono.getSelectedItem());
						nameComponente.setText("");
					} else if (tipoMiembroBox.getSelectedItem().equals("Bateria")) {
						Gestion.addBateria(nameComponente.getText(), (Procedencia) boxProcedencia.getSelectedItem(),
								(Integer) bombosSpin.getValue(), (Integer) platosSpin.getValue(),
								checkSampleado.isSelected());
					} else if (tipoMiembroBox.getSelectedItem().equals("Guitarrista")) {
						Gestion.addGuitarrista(nameComponente.getText(), (Procedencia) boxProcedencia.getSelectedItem(),
								checkInalambrico.isSelected(), checkMicrofoneado.isSelected());
					} else
						Gestion.addBajista(nameComponente.getText(), (Procedencia) boxProcedencia.getSelectedItem(),
								checkInalambrico.isSelected(), checkMicrofoneado.isSelected(),
								chckbxPedalAtenuador.isSelected());
					limpiarCamposComponentes();
				} catch (NombreMiembroNoValidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error en nombre", JOptionPane.ERROR_MESSAGE);
				} catch (MiembroYaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Miembro ya existente",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		);

		/**
		 * Evento del botón ver componentes
		 */
		btnVerComponentes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				actualizarCamposComponentes();
			}

		});
	}

	/**
	 * Oculta los campos de los componentes
	 */
	private void ocultar() {
		platosSpin.setVisible(false);
		bombosSpin.setVisible(false);
		lblBombos.setVisible(false);
		lblPlatos.setVisible(false);
		lblTipoMicrofono.setVisible(false);
		boxMicrofono.setVisible(false);
		platosSpin.setEnabled(false);
		bombosSpin.setEnabled(false);
		lblBombos.setEnabled(false);
		lblPlatos.setEnabled(false);
		lblTipoMicrofono.setEnabled(false);
		boxMicrofono.setEnabled(false);
		checkSampleado.setEnabled(false);
		checkSampleado.setVisible(false);
		checkInalambrico.setEnabled(false);
		checkInalambrico.setVisible(false);
		checkMicrofoneado.setEnabled(false);
		checkMicrofoneado.setVisible(false);
		chckbxPedalAtenuador.setEnabled(false);
		chckbxPedalAtenuador.setVisible(false);
	}

	/**
	 * Nos devuelve el escenario seleccionado
	 * 
	 * @return escenario
	 */
	private Escenarios getEscenario() {
		if (mainButton.isSelected())
			return Escenarios.MS;
		if (chaosButton.isSelected())
			return Escenarios.CS;
		if (ritualButton.isSelected())
			return Escenarios.RS;
		return Escenarios.DS;
	}

	/**
	 * Limpia los campos
	 */
	private void limpiarCampos() {
		Gestion.componentes = new Componentes();
		fieldName.setText("");
		fieldHora.setText("");
		boxDia.setSelectedItem(Gestion.getFechas()[0]);
		boxEstilo.setSelectedItem(Estilo.values()[0]);
		boxProcedencia.setSelectedItem(Procedencia.values()[0]);
		mainButton.setSelected(true);
		nameComponente.setText("");
	}

	/**
	 * Nos devuelve los componentes
	 * 
	 * @return componentes
	 */
	protected Componentes getComponentes() {
		return Gestion.componentes;
	}

	private void limpiarCamposComponentes() {
		tipoMiembroBox.setSelectedItem("Bateria");
		checkInalambrico.setSelected(false);
		checkMicrofoneado.setSelected(false);
		checkSampleado.setSelected(false);
		chckbxPedalAtenuador.setSelected(false);
		bombosSpin.setValue(0);
		platosSpin.setValue(0);
		boxMicrofono.setSelectedIndex(0);
		nameComponente.setText("");
		boxProcComp.setSelectedIndex(0);

	}

	/**
	 * Actualiza los campos de componentes en funcion del combobox
	 */
	private void actualizarCamposComponentes() {
		if (tipoMiembroBox.getSelectedItem().equals("Bateria")) {
			ocultar();
			lblBombos.setVisible(true);
			lblPlatos.setVisible(true);
			platosSpin.setVisible(true);
			bombosSpin.setVisible(true);
			lblBombos.setEnabled(true);
			lblPlatos.setEnabled(true);
			platosSpin.setEnabled(true);
			bombosSpin.setEnabled(true);
			checkSampleado.setEnabled(true);
			checkSampleado.setVisible(true);
		} else if (tipoMiembroBox.getSelectedItem().equals("Cantante")) {
			ocultar();
			lblTipoMicrofono.setVisible(true);
			lblTipoMicrofono.setEnabled(true);
			boxMicrofono.setVisible(true);
			boxMicrofono.setEnabled(true);
			checkInalambrico.setEnabled(true);
			checkInalambrico.setVisible(true);
		} else if (tipoMiembroBox.getSelectedItem().equals("Guitarrista")) {
			ocultar();
			checkInalambrico.setEnabled(true);
			checkInalambrico.setVisible(true);
			checkMicrofoneado.setEnabled(true);
			checkMicrofoneado.setVisible(true);
		} else {
			ocultar();
			checkInalambrico.setEnabled(true);
			checkInalambrico.setVisible(true);
			checkMicrofoneado.setEnabled(true);
			checkMicrofoneado.setVisible(true);
			chckbxPedalAtenuador.setEnabled(true);
			chckbxPedalAtenuador.setVisible(true);
		}
	}

	/**
	 * Configura el contenido del diálogo
	 */
	private void configuracion() {
		setTitle("A\u00F1adir grupo");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getSize().getWidth()) / 3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getSize().getHeight()) / 3, 674, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblName = new JLabel("Nombre");
		lblName.setBounds(21, 41, 75, 14);
		contentPane.add(lblName);

		fieldName = new JTextField();
		fieldName.setBounds(86, 38, 86, 20);
		contentPane.add(fieldName);
		fieldName.setColumns(10);

		lblProcedencia = new JLabel("Procedencia");
		lblProcedencia.setBounds(10, 87, 75, 14);
		contentPane.add(lblProcedencia);

		boxProcedencia = new JComboBox<Procedencia>();
		boxProcedencia.setModel(new DefaultComboBoxModel<Procedencia>(Procedencia.values()));
		boxProcedencia.setBounds(86, 83, 86, 22);
		contentPane.add(boxProcedencia);

		lblEscenario = new JLabel("Escenario");
		lblEscenario.setBounds(297, 83, 59, 14);
		contentPane.add(lblEscenario);

		mainButton = new JRadioButton("Main Stage");
		mainButton.setSelected(true);
		buttonGroup.add(mainButton);
		mainButton.setBounds(265, 104, 94, 23);
		mainButton.setBackground(new Color(102, 204, 153));
		contentPane.add(mainButton);

		chaosButton = new JRadioButton("Chaos Stage");
		buttonGroup.add(chaosButton);
		chaosButton.setBounds(265, 130, 110, 23);
		chaosButton.setBackground(new Color(102, 204, 153));
		contentPane.add(chaosButton);

		ritualButton = new JRadioButton("Ritual Stage");
		buttonGroup.add(ritualButton);
		ritualButton.setBounds(265, 156, 109, 23);
		ritualButton.setBackground(new Color(102, 204, 153));
		contentPane.add(ritualButton);

		desertButton = new JRadioButton("Desert Stage");
		buttonGroup.add(desertButton);
		desertButton.setBounds(265, 187, 107, 23);
		desertButton.setBackground(new Color(102, 204, 153));
		contentPane.add(desertButton);

		lblDia = new JLabel("Dia");
		lblDia.setBounds(55, 132, 38, 14);
		contentPane.add(lblDia);

		lblHora = new JLabel("Hora");
		lblHora.setBounds(250, 41, 46, 14);
		contentPane.add(lblHora);

		btnAdd = new JButton("A\u00F1adir");
		btnAdd.setBounds(101, 260, 91, 23);
		contentPane.add(btnAdd);

		btnCancelar = new JButton("Salir");
		btnCancelar.setBounds(248, 260, 91, 23);
		contentPane.add(btnCancelar);

		fieldHora = new JTextField();
		fieldHora.setBounds(289, 38, 86, 20);
		contentPane.add(fieldHora);
		fieldHora.setColumns(10);

		lblEstilo = new JLabel("Estilo");
		lblEstilo.setBounds(46, 176, 46, 14);
		contentPane.add(lblEstilo);

		boxEstilo = new JComboBox<Estilo>();
		boxEstilo.setModel(new DefaultComboBoxModel<Estilo>(Estilo.values()));
		boxEstilo.setBounds(86, 172, 86, 22);
		contentPane.add(boxEstilo);

		lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(187, 11, 46, 14);
		contentPane.add(lblGrupo);

		lblComponentes = new JLabel("Componentes");
		lblComponentes.setBounds(502, 11, 86, 14);
		contentPane.add(lblComponentes);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(457, 41, 46, 14);
		contentPane.add(lblNombre);

		nameComponente = new JTextField();
		nameComponente.setBounds(538, 38, 86, 20);
		contentPane.add(nameComponente);
		nameComponente.setColumns(10);

		lblProcedencia_1 = new JLabel("Procedencia");
		lblProcedencia_1.setBounds(438, 87, 75, 14);
		contentPane.add(lblProcedencia_1);

		boxProcComp = new JComboBox<Procedencia>();
		boxProcComp.setModel(new DefaultComboBoxModel<Procedencia>(Procedencia.values()));
		boxProcComp.setBounds(538, 83, 86, 22);
		contentPane.add(boxProcComp);

		lblTipoMicrofono = new JLabel("Micr\u00F3fono");
		lblTipoMicrofono.setVisible(false);
		lblTipoMicrofono.setEnabled(false);
		lblTipoMicrofono.setBounds(449, 187, 99, 14);
		contentPane.add(lblTipoMicrofono);

		boxMicrofono = new JComboBox<TipoMicrofono>();
		boxMicrofono.setEnabled(false);
		boxMicrofono.setVisible(false);
		boxMicrofono.setModel(new DefaultComboBoxModel<TipoMicrofono>(TipoMicrofono.values()));
		boxMicrofono.setBounds(422, 212, 141, 22);
		contentPane.add(boxMicrofono);

		lblPlatos = new JLabel("Platos");
		lblPlatos.setVisible(false);
		lblPlatos.setEnabled(false);
		lblPlatos.setBounds(438, 189, 46, 14);
		contentPane.add(lblPlatos);

		lblBombos = new JLabel("Bombos");
		lblBombos.setVisible(false);
		lblBombos.setEnabled(false);
		lblBombos.setBounds(518, 189, 61, 14);
		contentPane.add(lblBombos);

		platosSpin = new JSpinner();
		platosSpin.setEnabled(false);
		platosSpin.setVisible(false);
		platosSpin.setBounds(438, 216, 26, 18);
		contentPane.add(platosSpin);

		bombosSpin = new JSpinner();
		bombosSpin.setEnabled(false);
		bombosSpin.setVisible(false);
		bombosSpin.setBounds(517, 216, 26, 18);
		contentPane.add(bombosSpin);

		btnAadirComponente = new JButton("A\u00F1adir Componente");
		btnAadirComponente.setBounds(468, 245, 170, 23);
		contentPane.add(btnAadirComponente);

		tipoMiembroBox = new JComboBox<String>();
		tipoMiembroBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Bateria", "Cantante", "Guitarrista", "Bajista" }));
		tipoMiembroBox.setBounds(457, 128, 86, 22);
		contentPane.add(tipoMiembroBox);

		btnVerComponentes = new JButton("Ver");
		btnVerComponentes.setBounds(565, 128, 91, 23);
		contentPane.add(btnVerComponentes);

		checkSampleado = new JCheckBox("Sampleado");
		checkSampleado.setVisible(false);
		checkSampleado.setEnabled(false);
		checkSampleado.setBounds(559, 212, 97, 23);
		checkSampleado.setBackground(new Color(102, 204, 153));
		contentPane.add(checkSampleado);

		checkInalambrico = new JCheckBox("Inalambrico");
		checkInalambrico.setEnabled(false);
		checkInalambrico.setVisible(false);
		checkInalambrico.setBounds(569, 212, 97, 23);
		checkInalambrico.setBackground(new Color(102, 204, 153));
		contentPane.add(checkInalambrico);

		checkMicrofoneado = new JCheckBox("Microfoneado");
		checkMicrofoneado.setVisible(false);
		checkMicrofoneado.setEnabled(false);
		checkMicrofoneado.setBounds(422, 212, 110, 23);
		checkMicrofoneado.setBackground(new Color(102, 204, 153));
		contentPane.add(checkMicrofoneado);

		chckbxPedalAtenuador = new JCheckBox("Pedal atenuador");
		chckbxPedalAtenuador.setEnabled(false);
		chckbxPedalAtenuador.setBounds(457, 172, 134, 23);
		chckbxPedalAtenuador.setBackground(new Color(102, 204, 153));
		contentPane.add(chckbxPedalAtenuador);

		boxDia = new JComboBox<String>();
		boxDia.setModel(new DefaultComboBoxModel<String>(Gestion.getFechasString()));
		boxDia.setSelectedItem(Gestion.getFechasString()[0]);
		boxDia.setBounds(88, 127, 171, 22);
		contentPane.add(boxDia);

		boxDuracion = new JComboBox<String>();
		boxDuracion.setModel(new DefaultComboBoxModel<String>(new String[] { "30 minutos", "45 minutos", "1 hora",
				"1h y 15 minutos", "1h y 30 minutos", "1h y 45 minutos", "2 horas" }));
		boxDuracion.setBounds(86, 212, 86, 22);
		contentPane.add(boxDuracion);

		JLabel lblDuracin = new JLabel("Duraci\u00F3n");
		lblDuracin.setBounds(30, 216, 55, 14);
		contentPane.add(lblDuracin);
		actualizarCamposComponentes();
	}

	private int getDuracion() {
		return 30 + (15 * (boxDuracion.getSelectedIndex()));
	}
}
