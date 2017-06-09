package resurrectionFest.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Festival;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase principal del entorno gráfico
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Principal extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Content Panel
	 */
	private JPanel contentPane;
	/**
	 * FileChooser
	 */
	private static JFileChooser fileChooser;

	/**
	 * Bloque estático del filechooser
	 */
	static {
		fileChooser = new JFileChooser();
		FileNameExtensionFilter extension = new FileNameExtensionFilter("Resurrection Fest", "fes");
		fileChooser.setFileFilter(extension);
	}

	/**
	 * Opcion 'Nuevo' del menú
	 */
	private JMenuItem mntmNuevo;
	/**
	 * Opcion 'Abrir' del menú
	 */
	private JMenuItem mntmAbrir;
	/**
	 * Opcion 'Guardar' del menú
	 */
	private JMenuItem mntmGuardar;
	/**
	 * Opcion 'Guardar como' del menú
	 */
	private JMenuItem mntmGuardarComo;
	/**
	 * Opcion 'Salir' del menú
	 */
	private JMenuItem mntmSalir;
	/**
	 * Opcion 'Añadir' del menú
	 */
	private JMenuItem mntmAadir;
	/**
	 * Opcion 'Borrar' del menú
	 */
	private JMenuItem mntmBorrar;
	/**
	 * Opcion 'Modificar' del menú
	 */
	private JMenuItem mntmModificar;
	/**
	 * Opcion 'Buscar' del menú
	 */
	private JMenuItem mntmBuscar;
	/**
	 * Opcion 'Ayuda' del menú
	 */
	private JMenuItem mntmAyuda;
	/**
	 * Opcion 'Acerca de' del menú
	 */
	private JMenuItem mntmAcercaDe;
	/**
	 * Menu del festival
	 */
	private JMenu mnGrupo;
	/**
	 * Menú de ficheros
	 */
	private JMenu mnFichero;
	/**
	 * Menú de ayuda
	 */
	private JMenu mnAcercaDe;
	/**
	 * Barra de menu
	 */
	private JMenuBar menuBar;
	/**
	 * Opcion del menu festival para mostrar los días restantes del mismo
	 */
	private JMenuItem mntmMostrarDasRestantes;
	/**
	 * Opción del menú festival para editar las fechas
	 */
	private JMenuItem mntmEditarFechas;
	/**
	 * Menu mostrar
	 */
	private JMenu menuMostrar;
	/**
	 * Opcion del menu mostrar para mostrar el festival
	 */
	private JMenuItem menuMostrarFestival;
	/**
	 * Opcion del menu mostrar para mostrar el festival por coste
	 */
	private JMenuItem menuMostrarPorCoste;
	/**
	 * Opcion del menu festival para mostrar por escenarios
	 */
	private JMenuItem mntmPorEscenarios;
	/**
	 * Opcion del menu festival para mostrar por días
	 */
	private JMenuItem mntmPorDias;
	/**
	 * Menu del festival
	 */
	private JMenu mnFestival;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
					Dimension ventana = frame.getSize();
					frame.setLocation((int) (pantalla.getWidth() - ventana.getWidth()) / 2,
							(int) (pantalla.getHeight() - ventana.getHeight()) / 2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		configurar();
		eventos();
	}

	/**
	 * Configura los eventos
	 */
	private void eventos() {

		/**
		 * Abre el diálogo del contador de días si pulsamos la opción
		 */
		mntmMostrarDasRestantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContadorDias contadorDias = new ContadorDias();
				contadorDias.setVisible(true);
			}
		});

		/**
		 * Abre el díalogo para editar las fechas si pulsamos la opción
		 */
		mntmEditarFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarFechas editarFecha = new EditarFechas();
				editarFecha.setVisible(true);
			}
		});

		/**
		 * Muestra el díalogo de borrado del festival
		 */
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveGrupo remove = new RemoveGrupo();
				remove.setVisible(true);
			}
		});

		/**
		 * Muestra el díalogo de modificar del festival
		 */
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.isEmpty())
					JOptionPane.showMessageDialog(null, "No hay grupos introducidos en el festival",
							"Festival sin grupos", JOptionPane.ERROR_MESSAGE);
				else {
					Modificar modificar = new Modificar();
					modificar.setVisible(true);
				}
			}
		});

		/**
		 * Evento para mostrar por dias
		 */
		mntmPorDias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.isEmpty())
					JOptionPane.showMessageDialog(null, "No hay grupos introducidos en el festival",
							"Festival sin grupos", JOptionPane.ERROR_MESSAGE);
				else {
					MostrarPorDias mostrar = new MostrarPorDias();
					mostrar.setVisible(true);
				}
			}
		});

		/**
		 * Nos pregunta si queremos guardar al cerrar la ventana si se han
		 * producido cambios
		 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (Gestion.isModificado()) {
					if (JOptionPane.showConfirmDialog(null, "Has hecho cambios... ¿quieres guardar antes de salir?",
							"Festival modificado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (Gestion.getNombre() == "Sin título - Resurrection Fest")
							guardarComo();
						else
							guardar();
					}
				}
			}
		});

		/**
		 * Crea un archivo nuevo
		 */
		mntmNuevo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});

		/**
		 * Abre un archivo
		 */
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});

		/**
		 * Guarda un archivo
		 */
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});

		/**
		 * Guarda un archivo en la ruta seleccionada
		 */
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});

		/**
		 * Cierra el programa
		 */
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/**
		 * Abre el díalogo de añadir grupos
		 */
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnnadirGrupo add = new AnnadirGrupo();
				add.setVisible(true);
			}
		});

		/**
		 * Abre el diálogo para mostrar el festival
		 */
		menuMostrarFestival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Gestion.isEmpty())
					JOptionPane.showMessageDialog(null, "No hay grupos introducidos en el festival",
							"Festival sin grupos", JOptionPane.ERROR_MESSAGE);
				else {
					Mostrar mostrar = new Mostrar();
					mostrar.setVisible(true);
				}
			}
		});

		/**
		 * Abre el diálogo para mostrar por coste
		 */
		menuMostrarPorCoste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.isEmpty())
					JOptionPane.showMessageDialog(null, "No hay grupos introducidos en el festival",
							"Festival sin grupos", JOptionPane.ERROR_MESSAGE);
				else {
					MostrarPorCoste mostrar = new MostrarPorCoste();
					mostrar.setVisible(true);
				}
			}
		});

		/**
		 * Abre el díalogo de busqueda de grupos
		 */
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar buscar = new Buscar();
				buscar.setVisible(true);
			}
		});

		/**
		 * Abre el diálogo de acerca de
		 */
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acerca acerca = new Acerca();
				acerca.setVisible(true);
			}
		});

		/**
		 * Abre el díalogo de ayuda
		 */
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ayuda ayuda = Ayuda.getINSTANCE();
				ayuda.setVisible(true);
			}
		});

		/**
		 * Abre el diálogo para mostrar por escenario
		 */
		mntmPorEscenarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.isEmpty())
					JOptionPane.showMessageDialog(null, "No hay grupos introducidos en el festival",
							"Festival sin grupos", JOptionPane.ERROR_MESSAGE);
				else {
					MostrarPorEscenario mostrar = new MostrarPorEscenario();
					mostrar.setVisible(true);
				}
			}
		});

	}

	/**
	 * Abre un fichero
	 */
	private void abrir() {
		if (askOpen()) {
			fileChooser.setSelectedFile(null);
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					Gestion.abrir(fileChooser.getSelectedFile().getAbsolutePath());
					setTitle(Gestion.getNombre());
					ContadorDias contador = new ContadorDias();
					contador.setLocationRelativeTo(null);
					contador.setVisible(true);
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "El fichero no es un festival", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Error al abrir el fichero", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	/**
	 * Guarda un fichero
	 */
	private void guardar() {
		if (getTitle() == "Sin título - Resurrection Fest") {
			guardarComo();
		} else {
			try {
				Gestion.guardar(fileChooser.getSelectedFile().getAbsolutePath());
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error inesperado al guardar", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Guarda un fichero en la ruta seleccionada
	 */
	private void guardarComo() {

		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			if (!file.exists() || testExists(file)) {
				try {
					Gestion.guardar(fileChooser.getSelectedFile().getAbsolutePath());
					setTitle(file.getName() + " - Resurrection Fest");
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) { 
					JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	/**
	 * Comprueba la existencia del fichero
	 * 
	 * @param file
	 * @return boolean
	 */
	private boolean testExists(File file) {
		if (file.exists()) {
			return (JOptionPane.showConfirmDialog(null, "Ya existe ese archivo. ¿Desea sobreescribir?", "Sobreescribir",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION);
		}
		return false;
	}

	/**
	 * Crea un nuevo festival
	 */
	protected void nuevo() {
		if (Gestion.isModificado()) {
			if (JOptionPane.showConfirmDialog(null, "Has hecho cambios... ¿seguro que quieres abrir un nuevo fichero?",
					"Festival modificado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				Gestion.festival = new Festival();
				setTitle("Sin título - Resurrection Fest");
			}
		} else {
			Gestion.festival = new Festival();
			setTitle("Sin título - Resurrection Fest");
		}
	}

	/**
	 * Comprueba si el festival ha sido modificado
	 * 
	 * @return boolean
	 */
	private boolean askOpen() {
		if (!Gestion.isModificado())
			return true;
		return (JOptionPane.showConfirmDialog(null, "Has hecho cambios... ¿seguro que quieres abrir un nuevo fichero?",
				"Festival modificado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	/**
	 * Configura el Frame
	 */
	private void configurar() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Sin título - Resurrection Fest");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Principal.class.getResource("/resurrectionFest/imagenes/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 0, 0));
		menuBar.setBounds(0, 0, 442, 21);
		contentPane.add(menuBar);

		mnFichero = new JMenu("Archivo");
		mnFichero.setMnemonic('A');
		mnFichero.setForeground(new Color(255, 255, 255));
		mnFichero.setBackground(new Color(128, 0, 0));
		menuBar.add(mnFichero);

		mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setForeground(SystemColor.windowText);
		mntmNuevo.setBackground(SystemColor.inactiveCaptionBorder);
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFichero.add(mntmNuevo);

		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setForeground(SystemColor.windowText);
		mntmAbrir.setBackground(SystemColor.inactiveCaptionBorder);
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnFichero.add(mntmAbrir);

		mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setForeground(SystemColor.windowText);
		mntmGuardar.setBackground(SystemColor.inactiveCaptionBorder);
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnFichero.add(mntmGuardar);

		mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setForeground(SystemColor.windowText);
		mntmGuardarComo.setBackground(SystemColor.inactiveCaptionBorder);
		mntmGuardarComo
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnFichero.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnFichero.add(separator);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setForeground(SystemColor.windowText);
		mntmSalir.setBackground(SystemColor.inactiveCaptionBorder);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mnFichero.add(mntmSalir);

		mnGrupo = new JMenu("Grupo");
		mnGrupo.setMnemonic('G');
		mnGrupo.setForeground(new Color(255, 255, 255));
		mnGrupo.setBackground(new Color(128, 0, 0));
		menuBar.add(mnGrupo);

		mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnGrupo.add(mntmAadir);

		mntmBorrar = new JMenuItem("Borrar");
		mntmBorrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnGrupo.add(mntmBorrar);

		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnGrupo.add(mntmModificar);

		mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mnGrupo.add(mntmBuscar);

		mnFestival = new JMenu("Festival");
		mnFestival.setMnemonic('F');
		mnFestival.setForeground(new Color(255, 255, 255));
		mnFestival.setBackground(new Color(128, 0, 0));
		menuBar.add(mnFestival);

		mntmMostrarDasRestantes = new JMenuItem("Mostrar d\u00EDas restantes");
		mntmMostrarDasRestantes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnFestival.add(mntmMostrarDasRestantes);

		mntmEditarFechas = new JMenuItem("Editar fechas");
		mntmEditarFechas
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnFestival.add(mntmEditarFechas);

		menuMostrar = new JMenu("Mostrar");
		mnFestival.add(menuMostrar);

		menuMostrarFestival = new JMenuItem("Festival");
		menuMostrarFestival.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		menuMostrar.add(menuMostrarFestival);

		menuMostrarPorCoste = new JMenuItem("Por coste");
		menuMostrarPorCoste
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuMostrar.add(menuMostrarPorCoste);

		mntmPorEscenarios = new JMenuItem("Por escenarios");
		mntmPorEscenarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		menuMostrar.add(mntmPorEscenarios);

		mntmPorDias = new JMenuItem("Por dias");
		mntmPorDias.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		menuMostrar.add(mntmPorDias);

		mnAcercaDe = new JMenu("Ayuda");
		mnAcercaDe.setMnemonic('y');
		mnAcercaDe.setForeground(new Color(255, 255, 255));
		mnAcercaDe.setBackground(new Color(128, 0, 0));
		menuBar.add(mnAcercaDe);

		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAcercaDe.add(mntmAyuda);

		mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnAcercaDe.add(mntmAcercaDe);

		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Principal.class.getResource("/resurrectionFest/imagenes/portadaAdmin.jpg")));
		imagen.setBounds(0, 21, 442, 252);
		contentPane.add(imagen);
	}
}
