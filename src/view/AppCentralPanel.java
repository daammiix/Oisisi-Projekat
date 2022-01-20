package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class AppCentralPanel extends JTabbedPane {
	private static AppCentralPanel instance = null;
	
	private JTable tStudenti;
	private DefaultTableModel tmodelStudenti;
	private JTable tProfesori;
	private DefaultTableModel tmodelProfesori;
	private JTable tPredmeti;
	private DefaultTableModel tmodelPredmeti;
	private JScrollPane scStudenti;
	private JScrollPane scProfesori;
	private JScrollPane scPredmeti;
	
	private static final long serialVersionUID = -3564720651093597009L;
	
	public static AppCentralPanel getInstance() {
		if(instance == null)
			instance = new AppCentralPanel();
		return instance;
	}

	private AppCentralPanel() {
		this.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));
		
		String[] columnNamesStudenti = {"Indeks", "Ime", "Prezime", "Godina Studija", "Status", "Prosek"};
		makeTable("Studenti", columnNamesStudenti);
		
		String[] columnNamesProfesori = {"Ime", "Prezime", "Zvanje", "Email"};
		makeTable("Profesori", columnNamesProfesori);
		
		String[] columnNamesPredmeti = {"Sifra", "Naziv", "Broj ESPB", "Godina", "Semestar"};
		makeTable("Predmeti", columnNamesPredmeti);
		
		modifyAndAddTable(tStudenti, scStudenti, this, "Studenti");
		modifyAndAddTable(tProfesori, scProfesori, this, "Profesori");
		modifyAndAddTable(tPredmeti, scPredmeti, this, "Predmeti");
		
		// da nazivi tabova budu veci
		JLabel lStudenti = new JLabel("Studenti");
		lStudenti.setPreferredSize(new Dimension(50, 20));
		
		this.setTabComponentAt(0, lStudenti);	// da nazivi tabova budu veci


	}
	
	// vraca naslov selektovanog taba
		public String getSelectedTabTitle() {
			int selectedIndex = this.getSelectedIndex();
			return this.getTitleAt(selectedIndex);
		}
		
		// pravljenje tabele
		public void makeTable(String name, String[] columnNames) {
			switch(name) {
				case "Studenti" : 
					{
					
						tmodelStudenti = new DefaultTableModel(columnNames, 0) 
						{
							@Override
				            public Class getColumnClass(int col) {
								switch(col) {
								  case 0:
									  	return TableStudentIndexValue.class;
								  case 3:
										return int.class;
								  case 4:
									  	return Student.getStatusClass();
								  case 5:
									  	return double.class;
								  default:
									  return String.class;
								}
				            }
							
						}; 
						tStudenti = new JTable(tmodelStudenti); 
						tStudenti.setName("Studenti");
						tStudenti.setDefaultEditor(Object.class, null);
						tStudenti.setAutoCreateRowSorter(true);
						break;
					}
				case "Profesori" : 
					{
						tmodelProfesori = new DefaultTableModel(columnNames, 0); 
						tProfesori = new JTable(tmodelProfesori); 
						tProfesori.setName("Profesori");
						tProfesori.setDefaultEditor(Object.class, null);
						tProfesori.setAutoCreateRowSorter(true);
						break;
					}
				case "Predmeti" : 
					{
						tmodelPredmeti = new DefaultTableModel(columnNames, 0); 			
						tPredmeti = new JTable(tmodelPredmeti); 
						tPredmeti.setName("Predmeti");
						tPredmeti.setDefaultEditor(Object.class, null);
						tPredmeti.setAutoCreateRowSorter(true);
						break;
					}
				default : System.out.println("Invalid table name");
			}
		}
		
		public void filterTables(String[] parts) {
			for(int i = 0; i < parts.length; i++) 
				parts[i] = parts[i].trim().toLowerCase();
			switch(this.getSelectedIndex()) {
				case 0:
				{
					clearTableStudenti();
					for(Student s : AppData.getInstance().getSearchedStudents(parts)) 
						addStudent(s);
					
					break;
				}
				case 1:
				{
					clearTableProfesori();
					for(Profesor p : AppData.getInstance().getSearchedProfesors(parts))
						addProfesor(p);
					break;
				}
				case 2:
				{
					clearTablePredmeti();
					for(Predmet p : AppData.getInstance().getSearchedPredmets(parts))
						addPredmet(p);
				}
			}
		}
		
		// dodavanje tabele na panel
		public void modifyAndAddTable(JTable t, JScrollPane sc, AppCentralPanel acp, String naziv) {
			t.setRowHeight(25);
			t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			sc = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			sc.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 40, 15, 40), BorderFactory.createLineBorder(Color.BLACK, 2)));
			acp.add(sc, naziv);
		}
		
		// dodavanje studenta u tabelu
		public void addStudent(Student s) {
				TableStudentIndexValue indeks = new TableStudentIndexValue(s.getBrojIndeksa());
				String ime = s.getIme();
				String prezime = s.getPrezime();
				int godStudija = s.getTrenutnaGodinaStudija();
				Student.Status status = s.getStatus();
				double prosek = s.getProsecnaOcena();
			
				Object[] data = {indeks, ime, prezime, godStudija, status, prosek};
				tmodelStudenti.addRow(data);
		}
		
		// dodavanje profesora u tabelu
		public void addProfesor(Profesor p) {
			String ime = p.getIme();
			String prezime = p.getPrezime();
			String zvanje = p.getZvanje();
			String email = p.getEmail();
			
			Object[] data = {ime, prezime, zvanje, email};
			tmodelProfesori.addRow(data);
		}
		
		// dodavanje predmeta u tabelu
		public void addPredmet(Predmet p) {
			String sifra = p.getSifraPredmeta();
			String ime = p.getNazivPredmeta();
			int espb = p.getEspb();
			int god = p.getGodinaStudija();
			String semestar = p.getSemestar();
			
			Object[] data = {sifra, ime, espb, god, semestar};
			tmodelPredmeti.addRow(data);
		}
		
		// brisanje odredjenog studenta
		public void deleteStudent(int idx) {
			tmodelStudenti.removeRow(idx);
		}
		
		public void deleteProfesor(int idx) {
			tmodelProfesori.removeRow(idx);
		}
		
		public void deletePredmet(int idx) {
			tmodelPredmeti.removeRow(idx);
		}
		
		// ciscenje tabela
		public void clearTableStudenti() {
			tmodelStudenti.setRowCount(0);
		}
		
		public void clearTableProfesori() {
			tmodelProfesori.setRowCount(0);
		}
		
		public void clearTablePredmeti() {
			tmodelPredmeti.setRowCount(0);
		}
		
		// prikazivanje podataka iz modela
		public void updateStudenti(ArrayList<Student> studenti) {
			for(Student s : studenti) 
				addStudent(s);
		}
		
		public void updateProfesori(ArrayList<Profesor> profesori) {
			for(Profesor p : profesori)
				addProfesor(p);
		}
		
		public void updatePredmeti(ArrayList<Predmet> predmeti) {
			for(Predmet p : predmeti)
				addPredmet(p);
		}

		public JTable gettStudenti() {
			return tStudenti;
		}

		public void settStudenti(JTable tStudenti) {
			this.tStudenti = tStudenti;
		}

		public JTable gettProfesori() {
			return tProfesori;
		}

		public void settProfesori(JTable tProfesori) {
			this.tProfesori = tProfesori;
		}

		public JTable gettPredmeti() {
			return tPredmeti;
		}
		
		public DefaultTableModel gettmodelStudenti() {
			return tmodelStudenti;
		}
		
		public DefaultTableModel gettmodelProfesori() {
			return tmodelProfesori;
		}
		
		public DefaultTableModel gettmodelPredmeti() {
			return tmodelPredmeti;
		}

		public void settPredmeti(JTable tPredmeti) {
			this.tPredmeti = tPredmeti;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		public int getIndexStudent() {
			return tStudenti.getSelectedRow();
		}
		
		public int getIndexProfesori() {
			return tProfesori.getSelectedRow();
		}
		
		public int getIndexPredmeti() {
			return tPredmeti.getSelectedRow();
		}
}
