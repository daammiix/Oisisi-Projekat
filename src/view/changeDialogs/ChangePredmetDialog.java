package view.changeDialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Predmet;
import view.AppFrame;

public class ChangePredmetDialog extends JDialog {
	

	private static final long serialVersionUID = 2872383813265693358L;
	
	private JPanel mainPanel;
	private JPanel btnPanel;
	private ArrayList<JTextField> textFields;
	private JComboBox<Integer> cbGodina;
	private JComboBox<String> cbSemestar;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JButton btnPlus;
	private JButton btnMinus;

	public ChangePredmetDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() / 2, parent.getHeight() / 2);
		this.setResizable(false);
	
		textFields = new ArrayList<JTextField>();
		mainPanel = new JPanel();
		btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setActionCommand("Predmet");
		btnOdustani = new JButton("Odustani");
		btnOdustani.setActionCommand("Predmet");
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		Integer[] godine = {1, 2, 3, 4};
		cbGodina = new JComboBox<Integer>(godine);
		String[] semestar = {"Zimski", "Letnji"};
		cbSemestar = new JComboBox<String>(semestar);
		
		JLabel lSifra = new JLabel("Sifra*");
		lSifra.setPreferredSize(new Dimension(100, 25));
		JTextField tf1 = new JTextField(30);
		textFields.add(tf1);
		
		JLabel lNaziv = new JLabel("Naziv*");
		lNaziv.setPreferredSize(new Dimension(100, 25));
		JTextField tf2 = new JTextField(30);
		textFields.add(tf2);
		
		JLabel lGodina = new JLabel("Godina*");
		lGodina.setPreferredSize(new Dimension(100, 25));
		
		JLabel lSemestar = new JLabel("Semestar*");
		lSemestar.setPreferredSize(new Dimension(100, 25));
		
		JLabel lEspb = new JLabel("ESPB*");
		lEspb.setPreferredSize(new Dimension(100, 25));
		JTextField tf3= new JTextField(30);
		textFields.add(tf3);
		
		JLabel lProfesor = new JLabel("Profesor*");
		lProfesor.setPreferredSize(new Dimension(100, 25));
		JTextField tf4 = new JTextField(20);
		textFields.add(tf4);
		
		Box box1 = createBox(lSifra, tf1);
		Box box2 = createBox(lNaziv, tf2);
		Box box3 = createBox2(lGodina, cbGodina);
		Box box4 = createBox3(lSemestar, cbSemestar);
		Box box5 = createBox(lEspb, tf3);
		Box box6 = createBox(lProfesor, tf4);
		box6.add(Box.createHorizontalStrut(15));
		box6.add(btnPlus);
		box6.add(Box.createHorizontalStrut(15));
		box6.add(btnMinus);
		
		Box mainBox = Box.createVerticalBox();
		mainBox.add(box1);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(box2);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(box3);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(box4);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(box5);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(box6);
		
		mainPanel.add(mainBox);
		
		btnPanel.add(btnPotvrdi);
		btnPanel.add(btnOdustani);
		btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		this.add(BorderLayout.CENTER, mainPanel);
		this.add(BorderLayout.SOUTH, btnPanel);
	}
	
	public void addBtnOdustaniDialog(MouseListener ml) {
		btnOdustani.addMouseListener(ml);
	}
	
	public void addBtnPotvrdiListener(MouseListener ml, ActionListener al) {
		btnPotvrdi.addMouseListener(ml);
		btnPotvrdi.addActionListener(al);
	}
	
	public void addBtnPlusListener(MouseListener ml) {
		btnPlus.addMouseListener(ml);
	}
	
	public void addBtnMinusListener(MouseListener ml) {
		btnMinus.addMouseListener(ml);
	}
	
	private Box createBox(JLabel label, JTextField tf) {
		Box box2 = Box.createHorizontalBox();
		box2.add(label);
		box2.add(Box.createHorizontalStrut(15));
		box2.add(tf);
		return box2;
	}
	
	private Box createBox2(JLabel label, JComboBox<Integer> cb) {
		Box box2 = Box.createHorizontalBox();
		box2.add(label);
		box2.add(Box.createHorizontalStrut(15));
		box2.add(cb);
		return box2;
	}
	
	private Box createBox3(JLabel label, JComboBox<String> cb) {
		Box box2 = Box.createHorizontalBox();
		box2.add(label);
		box2.add(Box.createHorizontalStrut(15));
		box2.add(cb);
		return box2;
	}
	
	public void fillInPredmet(Predmet predmet) {
		textFields.get(0).setText(predmet.getSifraPredmeta());
		textFields.get(1).setText(predmet.getNazivPredmeta());
		cbGodina.setSelectedItem(predmet.getGodinaStudija());
		cbSemestar.setSelectedItem(predmet.getSemestar());
		textFields.get(2).setText(Integer.toString(predmet.getEspb()));
		if(predmet.getPredmetniProfesor() == null) {
			textFields.get(3).setText("");
		} else {
			String[] pr = {predmet.getPredmetniProfesor().getIme(), predmet.getPredmetniProfesor().getPrezime()};
			textFields.get(3).setText(pr[0] + " " + pr[1]);
		}
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public ArrayList<JTextField> getTextFields() {
		return textFields;
	}

	public void setTextFields(ArrayList<JTextField> textFields) {
		this.textFields = textFields;
	}

	public JButton getBtnPotvrdi() {
		return btnPotvrdi;
	}

	public void setBtnPotvrdi(JButton btnPotvrdi) {
		this.btnPotvrdi = btnPotvrdi;
	}

	public JButton getBtnOdustani() {
		return btnOdustani;
	}

	public void setBtnOdustani(JButton btnOdustani) {
		this.btnOdustani = btnOdustani;
	}

	public JComboBox<Integer> getCbGodina() {
		return cbGodina;
	}

	public void setCbGodina(JComboBox<Integer> cbGodina) {
		this.cbGodina = cbGodina;
	}

	public JComboBox<String> getCbSemestar() {
		return cbSemestar;
	}

	public void setCbSemestar(JComboBox<String> cbSemestar) {
		this.cbSemestar = cbSemestar;
	}
	
	public JButton getBtnPlus() {
		return btnPlus;
	}

	public void setBtnPlus(JButton btnPlus) {
		this.btnPlus = btnPlus;
	}

	public JButton getBtnMinus() {
		return btnMinus;
	}

	public void setBtnMinus(JButton btnMinus) {
		this.btnMinus = btnMinus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
