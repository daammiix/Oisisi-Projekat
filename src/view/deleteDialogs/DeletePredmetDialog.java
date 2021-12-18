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

public class DeletePredmetDialog extends JDialog {

	private static final long serialVersionUID = -9053017643463485948L;
	
	protected JPanel panel1;
	protected JPanel panel2;
	protected JButton btnDa;
	protected JButton btnNe;
	protected JLabel label;
	
	public DeletePredmetDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		

		this.setSize(parent.getWidth() / 3, parent.getHeight() - 500);
		
		panel1 =  new JPanel();
		panel2 = new JPanel();
		label = new JLabel("<html><p>Da li ste sigurni da želite da <br/> obrisete predmet?</p></html>", SwingConstants.CENTER);
		btnDa = new JButton("Da");
		btnNe = new JButton("Ne");
		
		btnDa.setPreferredSize(new Dimension(40, 40));
		label.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		panel1.add(label);
		panel2.add(btnDa);
		panel2.add(btnNe);
		panel1.setBorder(BorderFactory.createEmptyBorder(80, 40, 80, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 90, 40, 90));
		panel2.setLayout(new GridLayout(1, 2, 60, 0));
		
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		this.setResizable(false);
		
		btnDa.setActionCommand("Predmet");
		btnNe.setActionCommand("Predmet");
		
	}
	
	public void addBtnDaListener(MouseListener ml) {
		btnDa.addMouseListener(ml);
	}
	
	public void addBtnNeListener(MouseListener ml) {
		btnNe.addMouseListener(ml);
	}

}
