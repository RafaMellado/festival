package resurrectionFest.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

/**
 * Diálogo de acerca de..
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Acerca extends JDialog {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Content Panel
	 */
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public Acerca() {
		configurar();
	}


	/**
	 * Configura el diálogo
	 */
	private void configurar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acerca.class.getResource("/resurrectionFest/imagenes/logo.png")));
		setModal(true);
		setResizable(false);
		setTitle("Acerca de");
		setBounds((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-getSize().getWidth())/2,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-getSize().getHeight())/2, 233, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 0, 0));
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblConcesionarioDeCoches = new JLabel("Festival: Resurrection Fest");
			lblConcesionarioDeCoches.setForeground(new Color(255, 255, 255));
			lblConcesionarioDeCoches.setBounds(33, 11, 154, 14);
			contentPanel.add(lblConcesionarioDeCoches);
		}
		{
			JLabel lblRealizadoPor = new JLabel("Realizado por:");
			lblRealizadoPor.setForeground(new Color(255, 255, 255));
			lblRealizadoPor.setBounds(77, 48, 82, 14);
			contentPanel.add(lblRealizadoPor);
		}
		{
			JLabel lblRafaelMelladoJimnez = new JLabel("Rafael Mellado Jim\u00E9nez");
			lblRafaelMelladoJimnez.setForeground(new Color(255, 255, 255));
			lblRafaelMelladoJimnez.setBounds(52, 85, 135, 14);
			contentPanel.add(lblRafaelMelladoJimnez);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(128, 0, 0));
			buttonPane.setForeground(Color.WHITE);
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
