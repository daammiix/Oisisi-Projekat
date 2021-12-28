package controller.ponistavanjeOcene;

import java.awt.event.*;
import javax.swing.JOptionPane;
import view.AppView;
import view.changeDialogs.Student.*;

public class PonistiOcenuBtnListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ChangeStudentDialog editStudentDialog = AppView.getInstance().getChangeStudentDialog();
		if(editStudentDialog.getPanelPolozeni().getTableIspit().getSelectedRow() != -1) {
			AppView.getInstance().getPonistavanjeOceneDialog().setLocationRelativeTo(editStudentDialog);
			AppView.getInstance().getPonistavanjeOceneDialog().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(editStudentDialog, "Niste izabrali predmet.", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
