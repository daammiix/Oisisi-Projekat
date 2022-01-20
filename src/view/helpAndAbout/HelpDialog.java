package view.helpAndAbout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.AppFrame;

public class HelpDialog extends JDialog {

	private static final long serialVersionUID = -503872588752433673L;

	private JPanel mainPanel;
	private JPanel btnPanel;
	private JButton btnZatvori;
	private JLabel label1;
	
	public HelpDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth()/3, parent.getHeight() / 2);
		this.setResizable(false);
		
		mainPanel = new JPanel();
		btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
		btnZatvori = new JButton("Zatvori");
		btnZatvori.setActionCommand("Help");

		label1 = new JLabel("<html><p>Shortcuts:<br>"
				+ "File: Alt + F<br>"
				+ "Edit: Alt + E<br>"
				+ "Help: Alt + H<br>"
				+ "Open: Alt + O<br>"
				+ "New: Ctrl + N<br>"
				+ "Save: Ctrl + S<br>"
				+ "Close: Ctrl + C<br>"
				+ "Edit: Ctrl + E<br>"
				+ "Delete: Ctrl + D<br>"
				+ "Help: Ctrl + H<br>"
				+ "About: Ctrl + A<br><br>"
				+ "Sortiranje se vrsi pritiskom na zaglavlje zeljene kolone"
				+ "</p></html>");
		
		label1.setFont(new Font("Calibri", Font.PLAIN, 14));
		mainPanel.add(label1);
		
		btnPanel.add(btnZatvori);
		btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		this.add(BorderLayout.CENTER, mainPanel);
		this.add(BorderLayout.SOUTH, btnPanel);
	}
	
	public void initComponents() {
		btnZatvori.setText(AppFrame.getInstance().getResourceBundle().getString("btnZatvori"));
	}
	
	public void addBtnZatvoriListener(MouseListener ml) {
		btnZatvori.addMouseListener(ml);
	}
}
