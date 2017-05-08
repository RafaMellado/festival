package resurrectionFest.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * Diálogo ayuda
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Content Panel
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Singleton
	 */
	private static Ayuda INSTANCE = null;


	/**
	 * Create the dialog.
	 */
	private Ayuda() {
		configurar();
	}

	/**
	 * Singleton
	 * @return instance
	 */
	public static Ayuda getINSTANCE() {
		if(INSTANCE == null){
			INSTANCE = new Ayuda();
		}
		return INSTANCE;
	}
	/**
	 * Configura el diálogo
	 */
	private void configurar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/resurrectionFest/imagenes/logo.png")));
		setResizable(false);
		setTitle("Ayuda");
		setBounds((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-getSize().getWidth())/3,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-getSize().getHeight())/3, 311, 528);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAtajosDeTeclado = new JLabel("Atajos de teclado");
			lblAtajosDeTeclado.setForeground(new Color(255, 255, 255));
			lblAtajosDeTeclado.setBounds(87, 11, 133, 14);
			contentPanel.add(lblAtajosDeTeclado);
		}
		{
			JLabel lblFicheros = new JLabel("Ficheros");
			lblFicheros.setForeground(new Color(255, 255, 255));
			lblFicheros.setBounds(10, 44, 67, 14);
			contentPanel.add(lblFicheros);
		}
		{
			JLabel lblAbrir = new JLabel("Nuevo - Cntrl + N");
			lblAbrir.setForeground(new Color(255, 255, 255));
			lblAbrir.setBounds(87, 59, 99, 14);
			contentPanel.add(lblAbrir);
		}
		{
			JLabel lblAbrirCntrl = new JLabel("Abrir - Cntrl + A");
			lblAbrirCntrl.setForeground(new Color(255, 255, 255));
			lblAbrirCntrl.setBounds(87, 84, 99, 14);
			contentPanel.add(lblAbrirCntrl);
		}
		{
			JLabel lblGuardarCntrl = new JLabel("Guardar - Cntrl + G");
			lblGuardarCntrl.setForeground(new Color(255, 255, 255));
			lblGuardarCntrl.setBounds(87, 107, 142, 14);
			contentPanel.add(lblGuardarCntrl);
		}
		{
			JLabel lblGuardarComo = new JLabel("Guardar como - Cntrl + Alt + G");
			lblGuardarComo.setForeground(new Color(255, 255, 255));
			lblGuardarComo.setBounds(87, 132, 169, 14);
			contentPanel.add(lblGuardarComo);
		}
		{
			JLabel lblSalirEscape = new JLabel("Salir - Escape");
			lblSalirEscape.setForeground(new Color(255, 255, 255));
			lblSalirEscape.setBounds(87, 156, 99, 14);
			contentPanel.add(lblSalirEscape);
		}
		{
			JLabel lblCoches = new JLabel("Grupos");
			lblCoches.setForeground(new Color(255, 255, 255));
			lblCoches.setBounds(10, 188, 46, 14);
			contentPanel.add(lblCoches);
		}
		{
			JLabel lblAadirF = new JLabel("A\u00F1adir - Cntrl+Mayus+A");
			lblAadirF.setForeground(new Color(255, 255, 255));
			lblAadirF.setBounds(87, 201, 169, 14);
			contentPanel.add(lblAadirF);
		}
		{
			JLabel lblBorrarF = new JLabel("Borrar - Cntrl+Shift+W");
			lblBorrarF.setForeground(new Color(255, 255, 255));
			lblBorrarF.setBounds(87, 226, 142, 14);
			contentPanel.add(lblBorrarF);
		}
		{
			JLabel lblMostrarF = new JLabel("Modificar - Cntrl+M");
			lblMostrarF.setForeground(new Color(255, 255, 255));
			lblMostrarF.setBounds(87, 249, 142, 14);
			contentPanel.add(lblMostrarF);
		}
		{
			JLabel lblBuscarCntrl = new JLabel("Buscar - Cntrl + F");
			lblBuscarCntrl.setForeground(new Color(255, 255, 255));
			lblBuscarCntrl.setBounds(87, 272, 119, 14);
			contentPanel.add(lblBuscarCntrl);
		}
		{
			JLabel lblMostrarFestival = new JLabel("Mostrar festival - Cntrl + B");
			lblMostrarFestival.setForeground(new Color(255, 255, 255));
			lblMostrarFestival.setBounds(87, 318, 169, 14);
			contentPanel.add(lblMostrarFestival);
		}
		{
			JLabel lblMostrarPorCoste = new JLabel("Mostrar por coste - Cntrl+Shift+C");
			lblMostrarPorCoste.setForeground(new Color(255, 255, 255));
			lblMostrarPorCoste.setBounds(87, 343, 208, 14);
			contentPanel.add(lblMostrarPorCoste);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Ayuda.class.getResource("/resurrectionFest/imagenes/logaso.png")));
			lblNewLabel.setBounds(210, 11, 85, 85);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblFechas = new JLabel("Festival");
		lblFechas.setForeground(Color.WHITE);
		lblFechas.setBounds(10, 300, 46, 14);
		contentPanel.add(lblFechas);
		
		JLabel lblMostrarDiasRestantes = new JLabel("Mostrar dias restantes: Cntrl+E");
		lblMostrarDiasRestantes.setForeground(Color.WHITE);
		lblMostrarDiasRestantes.setBounds(87, 417, 184, 14);
		contentPanel.add(lblMostrarDiasRestantes);
		
		JLabel lblEditarFechasCntrlshifte = new JLabel("Editar fechas: Cntrl+Shift+E");
		lblEditarFechasCntrlshifte.setForeground(Color.WHITE);
		lblEditarFechasCntrlshifte.setBounds(87, 442, 169, 14);
		contentPanel.add(lblEditarFechasCntrlshifte);
		
		JLabel lblMostrarPorEscenario = new JLabel("Mostrar por escenario - Cntrl+E");
		lblMostrarPorEscenario.setForeground(Color.WHITE);
		lblMostrarPorEscenario.setBounds(87, 368, 194, 14);
		contentPanel.add(lblMostrarPorEscenario);
		
		JLabel lblMostrarPorDas = new JLabel("Mostrar por d\u00EDas - Cntrl + D");
		lblMostrarPorDas.setForeground(Color.WHITE);
		lblMostrarPorDas.setBounds(87, 393, 169, 14);
		contentPanel.add(lblMostrarPorDas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(128, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
