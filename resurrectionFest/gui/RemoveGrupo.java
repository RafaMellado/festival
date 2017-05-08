package resurrectionFest.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.Gestion;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.ErrorAlEliminarException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.NombreGrupoNoValidoException;

/**
 * Diálogo para borrar un grupo
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class RemoveGrupo extends MostrarGrupo {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public RemoveGrupo() {
		setTitle("Borrar grupo");
		defaultButton.setText("Borrar");
		defaultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Gestion.removeGrupo(lblMostrarGrupoName.getText());
					JOptionPane.showMessageDialog(null,"El grupo "+lblMostrarGrupoName.getText()+" ha sido borrado", "Grupo eliminado",
							JOptionPane.INFORMATION_MESSAGE);
					limpiar();
				} catch (ErrorAlEliminarException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar",
							JOptionPane.ERROR_MESSAGE);
				} catch (NombreGrupoNoValidoException e) {
					JOptionPane.showMessageDialog(null, "Debes buscar un grupo antes de borrarlo", "No se ha encontrado grupo",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
