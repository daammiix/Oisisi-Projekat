package controller.addStudentOnSubjectListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.AppData;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.AppCentralPanel;
import view.AppView;
import view.studentPredmetDialogs.AddStudentOnSubjectDialog;

public class BtnDodajListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		AddStudentOnSubjectDialog asos = AppView.getInstance().getAddStudentOnSubjectDialog();
		int selectedRow = asos.getTable().getSelectedRow();
		int selectedRowStudent = AppView.getInstance().getCentralPanel().gettStudenti().getSelectedRow();
		Student student = AppData.getInstance().getStudenti().get(selectedRowStudent);
		if(selectedRow != -1) {
			String selectedId = (String)asos.getTableModel().getValueAt(selectedRow, 0);
			addPredmet(selectedId);
			AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni().refreshInfo(student);
			AppView.getInstance().getAddStudentOnSubjectDialog().removePredmet(selectedRow);
			AppView.getInstance().getAddStudentOnSubjectDialog().setVisible(false);
		} else {
			JOptionPane.showMessageDialog(asos, "Niste oznacili entitet", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void addPredmet(String selectedId) {
		int selectedRowStudent = AppView.getInstance().getCentralPanel().gettStudenti().getSelectedRow();
		Student student = AppData.getInstance().getStudenti().get(selectedRowStudent);
		ArrayList<Predmet> predmeti = AppData.getInstance().getPredmeti();
		String[] newId = selectedId.split("-");
		String id = newId[0];
		for(Predmet p : predmeti) {
			String sifraPredmeta = p.getSifraPredmeta();
			if(sifraPredmeta.equals(id)) {
				String sifra = p.getSifraPredmeta();
				String naziv = p.getNazivPredmeta();
				String semestar = p.getSemestar();
				int godina = p.getGodinaStudija();
				int espb = p.getEspb();
				Predmet predmet = new Predmet(sifra, naziv, espb, godina, semestar);
				Ocena ocena = new Ocena(student, predmet, 5, new Date(0));
				student.getNepolozeniIspiti().add(ocena);
			}
		}
		
		
	}
}
