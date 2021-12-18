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
	
	public NotSelectedDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() / 3, parent.getHeight() - 500);
		
		panel1 =  new JPanel();
		panel2 =  new JPanel();
		label = new JLabel("<html><p>Morate oznaciti korisnika u tabeli</p></html>", SwingConstants.CENTER);
		btn = new JButton("OK");
		
		btn.setPreferredSize(new Dimension(40, 40));
		label.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		panel1.add(label);
		panel2.add(btn);

		panel1.setBorder(BorderFactory.createEmptyBorder(80, 40, 80, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 150, 40, 150));
		panel2.setLayout(new GridLayout(1, 2, 60, 0));
		
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		this.setResizable(false);
		
	}
	
	public void addBtnOkListener(MouseListener ml) {
		btn.addMouseListener(ml);
	}
}
