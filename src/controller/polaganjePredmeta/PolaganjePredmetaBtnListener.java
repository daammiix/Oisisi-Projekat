package controller.polaganjePredmeta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.AppData;
import model.Ocena;
import model.Student;
import model.TableStudentIndexValue;
import view.AppView;
import view.changeDialogs.Student.Nepolozeni;

public class PolaganjePredmetaBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Nepolozeni nepolozeni = AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni();
		int selectedRow = AppView.getInstance().getCentralPanel().gettStudenti().getSelectedRow();
		TableStudentIndexValue selectedValue = (TableStudentIndexValue) AppView.getInstance().getCentralPanel().gettStudenti().
				getValueAt(selectedRow, 0); 
		String selectedStudentIndeks = selectedValue.getIndeks();
		Student s = AppData.getInstance().getStudentByIndeks(selectedStudentIndeks);
		int idxSelectedOcena = AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni().getTable()
				.getSelectedRow();
		if(nepolozeni.getTable().getSelectedRow() != -1) {
			Ocena o = s.getNepolozeniIspiti().get(idxSelectedOcena);
			AppView.getInstance().getPolaganjeDialog().setLocationRelativeTo(AppView.getInstance()
					.getChangeStudentDialog());
			AppView.getInstance().getPolaganjeDialog().fillInfo(o);
			AppView.getInstance().getPolaganjeDialog().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(nepolozeni, "Niste izabrali predmet", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
