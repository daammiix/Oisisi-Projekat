package view.helpAndAbout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import view.AppFrame;
import view.changeDialogs.Student.Informacije;
import view.changeDialogs.Student.Nepolozeni;
import view.changeDialogs.Student.Polozeni;

public class AboutDialog extends JDialog {

	private static final long serialVersionUID = -7548137686876044922L;
	
	private JPanel panel1;
	private JPanel btnPanel;
	private JButton btnZatvori;
	private ImageIcon image1;
	private ImageIcon image2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	public AboutDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth()/2, parent.getHeight() / 2);
		this.setResizable(false);
		
		
		panel1 = new JPanel();
		btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
		btnZatvori = new JButton("Zatvori");
		btnZatvori.setActionCommand("About");

		image1 = new ImageIcon("image" + File.separator + "koleginica.png");
		label1 = new JLabel("Milana Dokic\nRA117/2019", image1, SwingConstants.HORIZONTAL);
		image2 = new ImageIcon("image" + File.separator + "kolega.png");
		label2 = new JLabel("Damjan Dimitrijevic\nRA115/2019", image2, SwingConstants.HORIZONTAL);
		label3 = new JLabel("<html><p>TIM5-grupa3<br>Asistentkinja: Marija Kovacevic</p></html>");
		
		Box box1 = Box.createHorizontalBox();
		box1.add(label1);
		Box box2 = Box.createHorizontalBox();
		box1.add(label2);
		Box box3 = Box.createHorizontalBox();
		box3.add(label3);
		
		Box mainBox = Box.createVerticalBox();
		mainBox.add(box1);
		mainBox.add(Box.createHorizontalStrut(10));
		mainBox.add(box2);
		mainBox.add(Box.createVerticalStrut(30));
		mainBox.add(box3);
		
		
		panel1.add(mainBox);
		
		btnPanel.add(btnZatvori);
		btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		panel1.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		this.add(BorderLayout.CENTER, panel1);
		this.add(BorderLayout.SOUTH, btnPanel);
	}
	
	public void initComponents() {
		btnZatvori.setText(AppFrame.getInstance().getResourceBundle().getString("btnZatvori"));
	}
	
	public void addBtnZatvoriListener(MouseListener ml) {
		btnZatvori.addMouseListener(ml);
	}

}
