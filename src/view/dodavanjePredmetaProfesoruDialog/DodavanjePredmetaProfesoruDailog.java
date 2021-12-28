package view.dodavanjePredmetaProfesoruDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import model.AppData;
import model.Predmet;
import model.Profesor;

public class DodavanjePredmetaProfesoruDailog extends JDialog {
	
	private JList<String> lPredmeti;
	private DefaultListModel<String> lModel;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	
	private static final long serialVersionUID = -3060658621063600982L;
	
	public DodavanjePredmetaProfesoruDailog(JDialog parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(parent.getWidth()*4/5, parent.getHeight()/2);
		this.setResizable(false);
		this.init();
	}
	
	public void init() {
		JLabel label = new JLabel("Predmeti:");
		lModel = new DefaultListModel<String>();
		lPredmeti = new JList<String>(lModel);
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setActionCommand("Potvrdi dodavanje predmeta");
		btnOdustani = new JButton("Odustani");
		btnOdustani.setActionCommand("Odustani od dodavanja predmeta");
		
		JScrollPane sp = new JScrollPane(lPredmeti, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		btnPanel.add(btnPotvrdi);
		btnPanel.add(btnOdustani);
		
		label.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 0));
		sp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20),
				BorderFactory.createLineBorder(Color.BLACK, 2)));
		btnPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), 
				BorderFactory.createEmptyBorder(5, 0, 10, 5)));
		this.add(label, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
		
	}
	
	public void fillListInformation(Profesor p) {
		lModel.clear();
		ArrayList<Predmet> profesoroviPredmeti = p.getPredmeti();
		for(Predmet pr : AppData.getInstance().getPredmeti()) {
			if(profesoroviPredmeti.contains(pr))
				continue;
			lModel.addElement(pr.getSifraPredmeta() + " - " + pr.getNazivPredmeta());
		}
	}
	
	public void addBtnPotvrdiListener(ActionListener al, MouseListener ml) {
		btnPotvrdi.addActionListener(al);
		btnPotvrdi.addMouseListener(ml);
	}
	
	public void addBtnOdustaniListener(MouseListener ml) {
		btnOdustani.addMouseListener(ml);
	}

	public JList<String> getlPredmeti() {
		return lPredmeti;
	}

	public void setlPredmeti(JList<String> lPredmeti) {
		this.lPredmeti = lPredmeti;
	}

	public DefaultListModel<String> getlModel() {
		return lModel;
	}

	public void setlModel(DefaultListModel<String> lModel) {
		this.lModel = lModel;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
