package view.katedraDialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.AppFrame;

public class RemoveSefKatedreDialog extends JDialog {

	private static final long serialVersionUID = 341365320431762896L;
	protected JPanel panel1;
	protected JPanel panel2;
	protected JButton btnPotvrdi;
	protected JButton btnOdustani;
	protected JLabel label;
	
	public RemoveSefKatedreDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);

		this.setSize(parent.getWidth() / 3, parent.getHeight() / 3);
		
		panel1 =  new JPanel();
		panel2 = new JPanel();
		label = new JLabel("<html><p>Da li ste sigurni?</p></html>", SwingConstants.CENTER);
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setActionCommand("RemoveSef");
		btnOdustani = new JButton("Odustani");
		btnOdustani.setActionCommand("RemoveSef");
		
		btnPotvrdi.setPreferredSize(new Dimension(40, 40));
		label.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		panel1.add(label);
		panel2.add(btnPotvrdi);
		panel2.add(btnOdustani);
		panel1.setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		panel2.setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		panel2.setLayout(new GridLayout(1, 2, 30, 0));
		
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		this.setResizable(false);

		
	}
	
	public void addBtnPotvrdiProfesoraListener(MouseListener ml, ActionListener al) {
		btnPotvrdi.addMouseListener(ml);
		btnPotvrdi.addActionListener(al);
	}
	
	public void addOdustaniProfesorBtnListener(MouseListener ml) {
		btnOdustani.addMouseListener(ml);
	}
}
