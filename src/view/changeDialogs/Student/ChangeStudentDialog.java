package view.changeDialogs.Student;

import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import view.AppFrame;


public class ChangeStudentDialog extends JDialog {
	
	private JTabbedPane tabbedPane;
	private Informacije informacije;
	private Polozeni polozeni;
	private Nepolozeni nepolozeni;

	private static final long serialVersionUID = 6484156735480732897L;

	public ChangeStudentDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth()/2, parent.getHeight()-20);
			
		tabbedPane = new JTabbedPane();
		informacije = new Informacije();
		polozeni = new Polozeni();
		nepolozeni = new Nepolozeni();

		tabbedPane.add("Informacije", informacije);
		tabbedPane.add("Polozeni", polozeni);
		tabbedPane.add("Nepolozeni", nepolozeni);
		
		tabbedPane.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
		this.add(tabbedPane);
	}

	public JTabbedPane getTabbedPane() {
		return this.tabbedPane;
	}
	
	public Informacije getPanelInformacije() {
		return this.informacije;
	}
	
	public Polozeni getPanelPolozeni() {
		return this.polozeni;
	}
	
	public Nepolozeni getPanelNepolozeni() {
		return this.nepolozeni;
	}
}
