package view.changeDialogs.Profesor;

import javax.swing.*;
import view.AppFrame;
import view.changeDialogs.ChangeDialog;
import view.changeDialogs.Profesor.Informacije;


public class ChangeProfesorDialog extends JDialog {
	private JTabbedPane tabbedPane;
	private Predmeti predmeti;
	private Informacije informacije;
	private static final long serialVersionUID = -2979043114439733749L;

	public ChangeProfesorDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth()/2, parent.getHeight()-20);
			
		tabbedPane = new JTabbedPane();
		informacije = new Informacije();
		predmeti = new Predmeti();

		tabbedPane.add("Informacije", informacije);
		tabbedPane.add("Predmeti", predmeti);

		
		tabbedPane.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
		this.add(tabbedPane);
		
	}
	
	public void initComponents() {
		tabbedPane.setTitleAt(0, AppFrame.getInstance().getResourceBundle().getString("Informacije"));
		tabbedPane.setTitleAt(1, AppFrame.getInstance().getResourceBundle().getString("Predmet"));
	}
	
	// getters and setters
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public Predmeti getPredmeti() {
		return this.predmeti;
	}
	
	public Informacije getInformacije() {
		return this.informacije;
	}
}
