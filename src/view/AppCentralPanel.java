package view;

import javax.swing.*;
import java.awt.*;

public class AppCentralPanel extends JTabbedPane {
	
	private static final long serialVersionUID = -3564720651093597009L;

	public AppCentralPanel() {
		this.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));
		
		// promeniti u funkcionalnosti 5
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel lStudenti = new JLabel("Studenti");
		lStudenti.setPreferredSize(new Dimension(50, 20));
		this.add("Studenti", panel1);
		this.add("Profesori", panel2);
		this.add("Predmeti", panel3);
		this.setTabComponentAt(0, lStudenti);
	}
}
