package controller.uklanjanjePredmetaProfesoru;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.AppData;
import model.Predmet;
import model.Profesor;
import view.AppView;

public class DaNeBtnListenerUkloniPredmet implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn.getActionCommand().equals("Da")) {
			int[] selectedPredmeti = AppView.getInstance().getChangeProfesorDialog().getPredmeti().getTable()
					.getSelectedRows();
			int selectedProfesor = AppView.getInstance().getCentralPanel().gettProfesori().getSelectedRow();
			Profesor p = AppData.getInstance().getProfesori().get(selectedProfesor);
			for(int pr : selectedPredmeti) {
				String sfrPredmeta = (String)AppView.getInstance().getChangeProfesorDialog().getPredmeti().getTable().
					getValueAt(pr, 0);
				Predmet prZaUklanjanje = null;
				for(Predmet pred : p.getPredmeti()) {
					if(pred.getSifraPredmeta().equals(sfrPredmeta)) {
						prZaUklanjanje = pred;
						break;
					}
				}
				if(prZaUklanjanje != null) {
					prZaUklanjanje.setPredmetniProfesor(null);
					AppView.getInstance().getChangePredmetDialog().fillInPredmet(prZaUklanjanje);
					p.removePredmet(prZaUklanjanje);
				}
				else 
					System.out.println("Predmet ne postoji u predmetima profesora????????");
			}
			AppView.getInstance().getChangeProfesorDialog().getPredmeti().refreshInfo(p);
			AppView.getInstance().getUklanjanjePredmetaProfesoruDialog().setVisible(false);
		} else {
			AppView.getInstance().getUklanjanjePredmetaProfesoruDialog().setVisible(false);
		}
	}
	
}
