package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import util.Util;

public class DaNeDialog extends JDialog {
	private JButton btnDa;
	private JButton btnNe;
	private static final long serialVersionUID = -3541175690656603765L;
	
	public DaNeDialog(JDialog parent, String title, boolean modal, String message) {
		super(parent, title, modal);
		this.setSize(300, 150);
		this.setLocationRelativeTo(parent);
		this.setResizable(false);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 25));

		panel.add(new JLabel(message));
		
		btnDa = new JButton("Da");
		btnDa.setBackground(Util.buttonBackgroundColor);
		btnDa.setForeground(Util.buttonForegroundColor);
		btnNe = new JButton("Ne");
		btnNe.setBackground(Util.buttonBackgroundColor);
		btnNe.setForeground(Util.buttonForegroundColor);
		
		panel.add(btnDa);
		panel.add(btnNe);
		
		
		this.add(panel);
	}
	
	public void addBtnsActionListener(ActionListener al) {
		btnDa.addActionListener(al);
		btnNe.addActionListener(al);
	}
}
