package resurrectionFest.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que nos dirá cuantos días queda para el inicio del festival
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class ContadorDias extends JDialog {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public ContadorDias() {
		configuracion();
	}

	/**
	 * Configura el diálogo
	 */
	private void configuracion() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ContadorDias.class.getResource("/resurrectionFest/imagenes/logo.png")));
		setTitle("Contador");
		setBounds(100, 100, 402, 315);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 205));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblQuedan = new JLabel("Queda:");
			lblQuedan.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblQuedan.setBounds(118, 0, 184, 95);
			contentPanel.add(lblQuedan);
		}
		
		JLabel label = new JLabel(String.valueOf(Gestion.getDiasRestantes())+" DÍAS");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(137, 92, 257, 41);
		contentPanel.add(label);
		{
			JLabel lblFechaInicio = new JLabel("Fecha inicio:");
			lblFechaInicio.setBounds(10, 167, 102, 14);
			contentPanel.add(lblFechaInicio);
		}
		{
			JLabel lblFechaFinal = new JLabel("Fecha final:");
			lblFechaFinal.setBounds(10, 212, 76, 14);
			contentPanel.add(lblFechaFinal);
		}
		{
			JLabel label_1 = new JLabel(Gestion.getFechaInicioString());
			label_1.setBounds(110, 167, 171, 14);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel(Gestion.getFechaFinalString());
			label_1.setBounds(108, 212, 173, 14);
			contentPanel.add(label_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 250, 205));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
