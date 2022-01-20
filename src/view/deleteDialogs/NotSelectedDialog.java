package view.deleteDialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.AppFrame;

public class NotSelectedDialog extends JDialog {

	private static final long serialVersionUID = -3048465983706454696L;

	protected JLabel label;
	protected JPanel panel1;
	protected JPanel panel2;
	protected JButton btn;
	protected String naziv;
	
	public NotSelectedDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() / 3, parent.getHeight() / 3);
		
		panel1 =  new JPanel();
		panel2 =  new JPanel();
		label = new JLabel("<html><p>Morate oznaciti entitet u tabeli</p></html>", SwingConstants.CENTER);
		btn = new JButton("OK");
		
		btn.setPreferredSize(new Dimension(30, 30));
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		panel1.add(label);
		panel2.add(btn);

		panel2.setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		panel1.setLayout(new GridLayout(1, 1, 0, 0));
		panel2.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		this.setResizable(false);
		
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void initComponents() {
		btn.setText(AppFrame.getInstance().getResourceBundle().getString("btnOk"));
		label.setText(AppFrame.getInstance().getResourceBundle().getString("mora_selektovati"));
	}
	
	public void addBtnOkListener(MouseListener ml) {
		btn.addMouseListener(ml);
	}
}
