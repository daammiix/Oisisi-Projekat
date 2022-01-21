package view.studentPredmetDialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.AppData;
import model.Ocena;
import model.Predmet;
import model.Student;
import util.Util;
import view.AppFrame;
import view.AppView;

public class AddStudentOnSubjectDialog extends JDialog {

	private static final long serialVersionUID = -6684993967243101634L;

	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JPanel panel;
	
	public AddStudentOnSubjectDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() *2 / 5, parent.getHeight() *2 / 5);
		this.setResizable(false);
		init();
	}
	
	private void init() {
		String[] cols = {"Dozvoljeni predmeti"};
		tableModel = new DefaultTableModel(cols,0);
		table = Util.createTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnDodaj = new JButton("Dodaj");
		setButton(btnDodaj);
		btnDodaj.setPreferredSize(new Dimension(25, 25));
		btnOdustani = new JButton("Odustani");
		setButton(btnOdustani);
		btnOdustani.setPreferredSize(new Dimension(25, 25));
		
		panel = new JPanel();
		panel.add(btnDodaj);
		panel.add(btnOdustani);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		panel.setLayout(new GridLayout(1, 2, 15, 0));
		
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		this.add(panel, BorderLayout.SOUTH);
		this.add(sp, BorderLayout.CENTER);
	}
	
	public void initComponents() {
		btnDodaj.setText(AppFrame.getInstance().getResourceBundle().getString("btnDodaj"));
		btnOdustani.setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
	}
	
	private void setButton(JButton button) {
		button.setBackground(Util.buttonBackgroundColor);
		button.setForeground(Util.buttonForegroundColor);
		button.setMargin(new Insets(1, 4, 1, 4));
	}
	
	public void addBtnDodajListener(ActionListener al) {
		btnDodaj.addActionListener(al);
	}
	
	public void addBtnOdustaniListener(ActionListener al) {
		btnOdustani.addActionListener(al);
	}
	
	public void initTable(Student student) {
		clearTable();
		ArrayList<Predmet> predmeti = AppData.getInstance().getPredmeti();
		ArrayList<Ocena> sviIspiti = new ArrayList<Ocena>();
		for(Ocena o : student.getPolozeniIspiti()) {
			sviIspiti.add(o);
		}
		for(Ocena o : student.getNepolozeniIspiti()) {
			sviIspiti.add(o);
		}
		for(Predmet p : predmeti) {
			Boolean nasao = false;
			for(Ocena o : sviIspiti ) {
				if(p.getSifraPredmeta().equals(o.getPredmet().getSifraPredmeta())) {
					nasao = true;
				}
			}
			int godinaStudent = student.getTrenutnaGodinaStudija();
			int godinaPredmet = p.getGodinaStudija();
			if(!nasao & (godinaStudent >= godinaPredmet)) {
				Object[] data = {p.getSifraPredmeta() + "-" + p.getNazivPredmeta()};
				tableModel.addRow(data);

			}
		}
	}
	
	public void removePredmet(int selectedPredmet) {
		tableModel.removeRow(selectedPredmet);
	}
	
	
	public void clearTable() {
		tableModel.setRowCount(0);
	}
	
	public JTable getTable() {
		return this.table;
	}
	
	public DefaultTableModel getTableModel() {
		return this.tableModel;
	}
}
