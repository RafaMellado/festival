package resurrectionFest.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ListIterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Grupo;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Miembros;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.GrupoNoExisteException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreGrupoNoValidoException;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase abstracta Mostrar
 * 
 * @author Rafael Mellado Jim�nez
 * @version 1.0
 *
 */
abstract class MostrarGrupo extends JDialog {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel contenedor
	 */
	JPanel contentPane;
	/**
	 * Field para buscar
	 */
	JTextField fieldBuscar;
	/**
	 * Label para mostrar el nombre del grupo
	 */
	JLabel lblMostrarGrupoName;
	/**
	 * Label para mostrar el escenario
	 */
	JLabel lblMostrarEscenario;
	/**
	 * Label para mostrar la hora de actuaci�n del grupo
	 */
	JLabel lblMostrarHoraGrupo;
	/**
	 * Label para mostrar el estilo del grupo
	 */
	JLabel lblMostrarEstiloGrupo;
	/**
	 * Label para mostrar el d�a de actuaci�n del grupo
	 */
	JLabel lblMostrarDiaGrupo;
	/**
	 * Label para mostrar la procedencia del grupo
	 */
	JLabel lblMostrarProcedenciaGrupo;
	/**
	 * Grupo
	 */
	Grupo group;
	/**
	 * Iterador de componentes
	 */
	ListIterator<Miembros> itComp;
	/**
	 * Miembro del grupo
	 */
	Miembros miembro;
	/**
	 * Label del nombre del componente
	 */
	JLabel lblNameComp;
	/**
	 * Label del instrumento del componente
	 */
	JLabel lblInstr;
	/**
	 * Label que muestra el coste total del grupo
	 */
	JLabel lblMostrarCosteTotal;
	/**
	 * Label del coste del miembro
	 */
	JLabel lblCosteMiembro;
	/**
	 * Label que muestra el coste del componente
	 */
	JLabel lblMostrarCosteComp;
	/**
	 * Label que muestra el nombre del componente
	 */
	JLabel lblMostrarCompName;
	/**
	 * Label que muestra el instrumento del miembro
	 */
	JLabel lblMostrarInstrumento;
	/**
	 * Label del nombre del grupo
	 */
	JLabel lblNombreGrupo;
	/**
	 * Label del d�a de actuaci�n
	 */
	JLabel lblDia;
	/**
	 * Label del estilo del grupo
	 */
	JLabel lblEstilo;
	/**
	 * Label de la hora de actuaci�n del grupo
	 */
	JLabel lblHora;
	/**
	 * Label de la procedencia del grupo
	 */
	JLabel lblProcedencia;
	/**
	 * Label del escenario del grupo
	 */
	JLabel lblEscenario;
	/**
	 * Bot�n de OK
	 */
	JButton defaultButton;
	/**
	 * Bot�n de anterior del iterador de componentes
	 */
	JButton btnCompPrevious;
	/**
	 * Bot�n de siguiente del iterador de componentes
	 */
	JButton btnCompNext;
	/**
	 * Panel de componentes
	 */
	JPanel panel;
	/**
	 * Label de buscar
	 */
	JLabel lblBuscar;
	/**
	 * Bot�n buscar
	 */
	JButton btnBuscar;
	/**
	 * Label del coste del grupo
	 */
	JLabel lblCosteGrupo;
	/**
	 * Boton cancelar
	 */
	JButton cancButton;
	/**
	 * Label mostrar duracion
	 */
	JLabel lblMostrarDuracion;
	/**
	 * Label titulo duracion
	 */
	JLabel lblDuracion;

	/**
	 * Create the dialog.
	 */
	public MostrarGrupo() {
		setModal(true);
		configuracion();
		eventos();
	}

	/**
	 * Configura los eventos
	 */
	private void eventos() {

		/**
		 * Retrasa una posici�n en el iterador de componentes
		 */
		btnCompPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (group != null)
					previousComponent();
			}
		});

		/**
		 * Avanza una posici�n en el iterador de componentes
		 */
		btnCompNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (group != null)
					nextComponent();
			}
		});

		/**
		 * Busca el grupo
		 */
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});

		/**
		 * Busca el grupo si pulsamos el enter
		 */
		fieldBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					buscar();
				}
			}
		});

		/**
		 * Cierra el di�logo
		 */
		cancButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	/**
	 * Renueva los datos en el dialogo
	 */
	void renovarDatos() {
		itComp = group.getComponentesIterator();
		nextComponent();
		lblMostrarDiaGrupo.setText(group.getDia());
		lblMostrarEscenario.setText(group.getNombreEscenario());
		lblMostrarEstiloGrupo.setText(group.getEstilo().toString());
		lblMostrarGrupoName.setText(group.getNombre());
		lblMostrarHoraGrupo.setText(group.getHora());
		lblMostrarCosteTotal.setText(group.getCosteGrupo() + "�");
		lblMostrarDuracion.setText(group.getDuracionString());
		lblMostrarProcedenciaGrupo.setText(group.getProcedencia().toString());
		if (lblNameComp == null || miembro == null || lblNameComp.equals(miembro.getNombre()))
			nextComponent();
		btnCompPrevious.setEnabled(false);
	}

	/**
	 * Avanza una posici�n en el iterador de componentes
	 */
	void nextComponent() {
		if (itComp.hasNext()) {
			miembro = itComp.next();
			if (miembro.getNombre() == lblMostrarCompName.getText() && itComp.hasNext())
				miembro = itComp.next();
			lblMostrarInstrumento.setText(miembro.getClass().getSimpleName());
			lblMostrarCompName.setText(miembro.getNombre());
			lblMostrarCosteComp.setText(String.valueOf(miembro.calcularCoste()) + "�");
		}
		if (!itComp.hasNext())
			btnCompNext.setEnabled(false);
		else
			btnCompNext.setEnabled(true);
		if (!itComp.hasPrevious())
			btnCompPrevious.setEnabled(false);
		else
			btnCompPrevious.setEnabled(true);

	}

	/**
	 * Retrasa una posici�n en el iterador de componentes
	 */
	void previousComponent() {
		if (itComp.hasPrevious()) {
			miembro = itComp.previous();
			if (miembro.getNombre() == lblMostrarCompName.getText() && itComp.hasPrevious())
				miembro = itComp.previous();
			lblMostrarInstrumento.setText(miembro.getClass().getSimpleName());
			lblMostrarCompName.setText(miembro.getNombre());
			lblMostrarCosteComp.setText(String.valueOf(miembro.calcularCoste()) + "�");
		}

		if (!itComp.hasPrevious())
			btnCompPrevious.setEnabled(false);
		else
			btnCompPrevious.setEnabled(true);
		if (!itComp.hasNext())
			btnCompNext.setEnabled(false);
		else
			btnCompNext.setEnabled(true);
	}

	/**
	 * Busca un grupo
	 */
	void buscar() {
		try {
			group = Gestion.buscarGrupo(fieldBuscar.getText());
			itComp = group.getComponentesIterator();
			renovarDatos();
		} catch (NombreGrupoNoValidoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error en nombre", JOptionPane.ERROR_MESSAGE);
		} catch (GrupoNoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "El grupo no existe", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Limpia los campos
	 */
	void limpiar() {
		lblMostrarDiaGrupo.setText("");
		lblMostrarEscenario.setText("");
		lblMostrarEstiloGrupo.setText("");
		lblMostrarGrupoName.setText("");
		lblMostrarHoraGrupo.setText("");
		lblMostrarProcedenciaGrupo.setText("");
		lblMostrarCosteTotal.setText("");
		lblMostrarDuracion.setText("");
		btnCompPrevious.setEnabled(false);
		btnCompNext.setEnabled(false);
		itComp = null;
		lblMostrarInstrumento.setText("");
		lblMostrarCompName.setText("");
		lblMostrarCosteComp.setText("");
		fieldBuscar.setText("");
	}

	/**
	 * Configura el di�logo
	 */
	private void configuracion() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MostrarGrupo.class.getResource("/resurrectionFest/imagenes/logo.png")));
		setBounds(100, 100, 450, 412);
		contentPane = new JPanel();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		defaultButton = new JButton("Default");
		defaultButton.setBounds(229, 348, 91, 23);
		contentPane.add(defaultButton);
		lblNombreGrupo = new JLabel("Nombre:");
		lblNombreGrupo.setBounds(27, 46, 56, 14);
		contentPane.add(lblNombreGrupo);

		lblMostrarGrupoName = new JLabel();
		lblMostrarGrupoName.setBounds(96, 46, 297, 14);
		contentPane.add(lblMostrarGrupoName);

		lblEstilo = new JLabel("Estilo:");
		lblEstilo.setBounds(27, 112, 46, 14);
		contentPane.add(lblEstilo);

		lblDia = new JLabel("Dia:");
		lblDia.setBounds(27, 81, 77, 14);
		contentPane.add(lblDia);

		lblHora = new JLabel("Hora:");
		lblHora.setBounds(27, 142, 46, 14);
		contentPane.add(lblHora);

		lblProcedencia = new JLabel("Procedencia:");
		lblProcedencia.setBounds(229, 81, 77, 14);
		contentPane.add(lblProcedencia);

		lblEscenario = new JLabel("Escenario:");
		lblEscenario.setBounds(229, 112, 66, 14);
		contentPane.add(lblEscenario);

		lblMostrarDiaGrupo = new JLabel();
		lblMostrarDiaGrupo.setBounds(57, 81, 162, 14);
		contentPane.add(lblMostrarDiaGrupo);

		lblMostrarEstiloGrupo = new JLabel();
		lblMostrarEstiloGrupo.setBounds(83, 112, 113, 14);
		contentPane.add(lblMostrarEstiloGrupo);

		lblMostrarHoraGrupo = new JLabel();
		lblMostrarHoraGrupo.setBounds(83, 142, 101, 14);
		contentPane.add(lblMostrarHoraGrupo);

		lblMostrarEscenario = new JLabel();
		lblMostrarEscenario.setBounds(316, 112, 116, 14);
		contentPane.add(lblMostrarEscenario);

		lblMostrarProcedenciaGrupo = new JLabel();
		lblMostrarProcedenciaGrupo.setBounds(316, 81, 116, 14);
		contentPane.add(lblMostrarProcedenciaGrupo);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Componentes",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(27, 197, 382, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNameComp = new JLabel("Nombre:");
		lblNameComp.setBounds(22, 27, 62, 14);
		panel.add(lblNameComp);

		lblCosteMiembro = new JLabel("Coste:");
		lblCosteMiembro.setBounds(22, 52, 46, 14);
		panel.add(lblCosteMiembro);

		lblInstr = new JLabel("Instrumento:");
		lblInstr.setBounds(22, 77, 82, 14);
		panel.add(lblInstr);

		btnCompPrevious = new JButton("<");
		btnCompPrevious.setEnabled(false);

		btnCompPrevious.setBounds(126, 106, 54, 23);
		panel.add(btnCompPrevious);

		btnCompNext = new JButton(">");
		btnCompNext.setEnabled(false);

		btnCompNext.setBounds(203, 106, 54, 23);
		panel.add(btnCompNext);

		lblMostrarCompName = new JLabel("");
		lblMostrarCompName.setBounds(81, 27, 239, 14);
		panel.add(lblMostrarCompName);

		lblMostrarCosteComp = new JLabel("");
		lblMostrarCosteComp.setBounds(91, 52, 89, 14);
		panel.add(lblMostrarCosteComp);

		lblMostrarInstrumento = new JLabel("");
		lblMostrarInstrumento.setBounds(101, 77, 186, 14);
		panel.add(lblMostrarInstrumento);

		lblBuscar = new JLabel("Buscar");
		lblBuscar.setRequestFocusEnabled(false);
		lblBuscar.setBounds(75, 11, 46, 14);
		contentPane.add(lblBuscar);

		fieldBuscar = new JTextField();
		fieldBuscar.setBounds(153, 8, 116, 20);
		contentPane.add(fieldBuscar);
		fieldBuscar.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(300, 7, 91, 23);
		contentPane.add(btnBuscar);

		lblCosteGrupo = new JLabel("Coste:");
		lblCosteGrupo.setBounds(229, 142, 46, 14);
		contentPane.add(lblCosteGrupo);

		lblMostrarCosteTotal = new JLabel("");
		lblMostrarCosteTotal.setBounds(285, 142, 124, 14);
		contentPane.add(lblMostrarCosteTotal);

		cancButton = new JButton("Salir");
		cancButton.setBounds(330, 348, 89, 23);
		contentPane.add(cancButton);
		
		lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(27, 172, 89, 14);
		contentPane.add(lblDuracion);
		
		lblMostrarDuracion = new JLabel("");
		lblMostrarDuracion.setBounds(93, 172, 77, 14);
		contentPane.add(lblMostrarDuracion);
	}
}
