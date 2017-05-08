package resurrectionFest.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ComponentesVacioException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FormatoHoraNoValidoException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreGrupoNoValidoException;
import resurrectionFest.funcionalidad.enumeraciones.Dias;
import resurrectionFest.funcionalidad.enumeraciones.Escenarios;
import resurrectionFest.funcionalidad.enumeraciones.Estilo;
import resurrectionFest.funcionalidad.enumeraciones.Procedencia;

public class Modificar extends MostrarFestival {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField fieldName;
	private JTextField fieldHora;
	private JComboBox<Procedencia> boxProcedencia;
	private JComboBox<Dias> boxDia;
	private JComboBox<Estilo> boxEstilo;
	private JComboBox<String> boxEscenario;

	/**
	 * Create the dialog.
	 */
	public Modificar() {
		setTitle("Modificar grupo");
		defaultButton.setText("Modificar");
		defaultButton.setVisible(true);
		defaultButton.setEnabled(true);
		defaultButton.setBounds(229, cancButton.getY(), 91, 23);
		defaultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (defaultButton.getText().equals("Modificar")) {
					ocultarCampos();
					addCamposGrupo();
					defaultButton.setText("Guardar");
				} else if (defaultButton.getText().equals("Guardar")) {
					try {
						Gestion.modificarGrupo(group.getNombre(), fieldName.getText(),
								(Estilo) boxEstilo.getSelectedItem(), (Procedencia) boxProcedencia.getSelectedItem(),
								getEscenario(), (Dias) boxDia.getSelectedItem(), fieldHora.getText(),
								group.getComponentes());
						renovar();
					} catch (NombreGrupoNoValidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error en nombre",
								JOptionPane.ERROR_MESSAGE);
					} catch (FormatoHoraNoValidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error en hora",
								JOptionPane.ERROR_MESSAGE);
					} catch (ComponentesVacioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error en componentes",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});
	}

	/**
	 * Renueva los datos
	 */
	private void renovar() {
		itGroups = Gestion.getGruposIterator();
		removeCamposGrupo();
		nextGroup();
		activarCampos();
		defaultButton.setText("Modificar");
	}

	/**
	 * Devuelve el escenario
	 * 
	 * @return escenario
	 */
	protected Escenarios getEscenario() {
		if (boxEscenario.getSelectedItem().equals(Escenarios.MS.getNombre()))
			return Escenarios.MS;
		if (boxEscenario.getSelectedItem().equals(Escenarios.RS.getNombre()))
			return Escenarios.RS;
		if (boxEscenario.getSelectedItem().equals(Escenarios.CS.getNombre()))
			return Escenarios.CS;
		return Escenarios.DS;
	}

	/**
	 * Activa los campos
	 */
	private void activarCampos() {
		lblMostrarDiaGrupo.setVisible(true);
		lblMostrarEstiloGrupo.setVisible(true);
		lblMostrarHoraGrupo.setVisible(true);
		lblMostrarGrupoName.setVisible(true);
		lblMostrarProcedenciaGrupo.setVisible(true);
		lblMostrarDiaGrupo.setEnabled(true);
		lblMostrarEstiloGrupo.setEnabled(true);
		lblMostrarHoraGrupo.setEnabled(true);
		lblMostrarGrupoName.setEnabled(true);
		lblMostrarProcedenciaGrupo.setEnabled(true);
		lblMostrarEscenario.setVisible(true);
		lblMostrarEscenario.setEnabled(true);
		lblMostrarCosteComp.setEnabled(true);
		lblMostrarInstrumento.setEnabled(true);
		lblMostrarCompName.setEnabled(true);
		lblMostrarCosteComp.setVisible(true);
		lblMostrarInstrumento.setVisible(true);
		lblMostrarCompName.setVisible(true);
		if (itGroups.hasPrevious())
			previousGroup();
	}

	/**
	 * Oculta los campos
	 */
	private void ocultarCampos() {
		lblMostrarDiaGrupo.setVisible(false);
		lblMostrarEstiloGrupo.setVisible(false);
		lblMostrarHoraGrupo.setVisible(false);
		lblMostrarGrupoName.setVisible(false);
		lblMostrarProcedenciaGrupo.setVisible(false);
		lblMostrarDiaGrupo.setEnabled(false);
		lblMostrarEstiloGrupo.setEnabled(false);
		lblMostrarHoraGrupo.setEnabled(false);
		lblMostrarGrupoName.setEnabled(false);
		lblMostrarProcedenciaGrupo.setEnabled(false);
		lblMostrarEscenario.setVisible(false);
		lblMostrarEscenario.setEnabled(false);
		btnAnterior.setEnabled(false);
		btnSiguiente.setEnabled(false);
	}

	/**
	 * Oculta los campos de modificación
	 */

	private void removeCamposGrupo() {
		fieldName.setEnabled(false);
		fieldName.setVisible(false);
		fieldHora.setEnabled(false);
		fieldHora.setVisible(false);

		boxProcedencia.setEnabled(false);
		boxProcedencia.setVisible(false);
		boxDia.setEnabled(false);
		boxDia.setVisible(false);

		boxEstilo.setEnabled(false);
		boxEstilo.setVisible(false);

		boxEscenario.setEnabled(false);
		boxEscenario.setVisible(false);

	}

	/**
	 * Añade los campos de modificación
	 */
	private void addCamposGrupo() {

		fieldName = new JTextField();
		fieldName.setText(group.getNombre());
		fieldName.setBounds(lblMostrarGrupoName.getX(), lblMostrarGrupoName.getY() + 4, lblMostrarGrupoName.getWidth(),
				lblMostrarGrupoName.getHeight() + 4);
		contentPane.add(fieldName);

		fieldHora = new JTextField();
		fieldHora.setText(group.getHora());
		fieldHora.setBounds(lblMostrarHoraGrupo.getX(), lblMostrarHoraGrupo.getY() + 4, lblMostrarHoraGrupo.getWidth(),
				lblMostrarHoraGrupo.getHeight() + 4);
		contentPane.add(fieldHora);

		boxProcedencia = new JComboBox<Procedencia>();
		boxProcedencia.setModel(new DefaultComboBoxModel<Procedencia>(Procedencia.values()));
		boxProcedencia.setSelectedItem(group.getProcedencia());
		boxProcedencia.setBounds(lblMostrarProcedenciaGrupo.getX(), lblMostrarProcedenciaGrupo.getY(),
				lblMostrarProcedenciaGrupo.getWidth(), lblMostrarProcedenciaGrupo.getHeight() + 4);
		contentPane.add(boxProcedencia);

		boxDia = new JComboBox<Dias>();
		boxDia.setModel(new DefaultComboBoxModel<Dias>(Dias.values()));
		boxDia.setSelectedItem(group.getDia());
		boxDia.setBounds(lblMostrarDiaGrupo.getX(), lblMostrarDiaGrupo.getY(), lblMostrarDiaGrupo.getWidth(),
				lblMostrarDiaGrupo.getHeight() + 3);
		contentPane.add(boxDia);

		boxEstilo = new JComboBox<Estilo>();
		boxEstilo.setModel(new DefaultComboBoxModel<Estilo>(Estilo.values()));
		boxEstilo.setSelectedItem(group.getEstilo());
		boxEstilo.setBounds(lblMostrarEstiloGrupo.getX(), lblMostrarEstiloGrupo.getY(),
				lblMostrarEstiloGrupo.getWidth(), lblMostrarEstiloGrupo.getHeight() + 3);
		contentPane.add(boxEstilo);

		boxEscenario = new JComboBox<String>();
		boxEscenario.setModel(new DefaultComboBoxModel<String>(Escenarios.nombreEscenarios()));
		boxEscenario.setSelectedItem(group.getEscenario());
		boxEscenario.setBounds(lblMostrarEscenario.getX(), lblMostrarEscenario.getY(), lblMostrarEscenario.getWidth(),
				lblMostrarEscenario.getHeight() + 4);
		contentPane.add(boxEscenario);
	}

}
