package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import util.Util;

public class AppData {
	
	private static AppData instance = null;
	
	private ArrayList<Student> studenti;
	private ArrayList<Profesor> profesori;
	private ArrayList<Predmet> predmeti;
	
	public static AppData getInstance() {
		if(instance == null)
			instance = new AppData();
		return instance;
	}
	
	private AppData() {
		studenti = new ArrayList<Student>();
		profesori = new ArrayList<Profesor>();
		predmeti = new ArrayList<Predmet>();
	}
	
	public AppData(ArrayList<Student> studenti, ArrayList<Profesor> profesori, ArrayList<Predmet> predmeti) {
		this.studenti = studenti;
		this.profesori = profesori;
		this.predmeti = predmeti;
	}
	
	public void addStudent(Student s) {
		studenti.add(s);
	}
	
	public void addProfesor(Profesor p) {
		profesori.add(p);
	}
	
	public void addPredmet(Predmet p) {
		predmeti.add(p);
	}
	
	public void makeTestData() throws ParseException {
		Student s1 = new Student("ra-115-2019", "Damjan", "Dimitrijevic", 3, Student.Status.B , 8.67);
		Student s2 = new Student("ra-102-2016", "Luka", "Lukic", 4, Student.Status.S, 7.80);
		Student s3 = new Student("Mina", "Minic", Util.formatter.parse("22.2.1999."), 
				new Adresa("Bruski Put", "BB", "Krusevac", "Srbija"), "+38167787998", 
				"minicm100@gmail.com", "sw-25-2014", 2018, 4, Student.Status.B);
		Student s4 = new Student("Petar", "Petrovic", Util.formatter.parse("10.05.2000."),  
					new Adresa("Kosovska", "110", "Krusevac", "Srbija"), "+38165559558", 
					"petrovicp11@gmail.com", "sw65-2019", 2019, 3, Student.Status.B);
		
		Profesor p1 = new Profesor("Darko", "Darkovic", "Profesor", "darkod25@uns.ac.rs");
		Profesor p2 = new Profesor("Mirko", "Milutinovic", Util.formatter.parse("1.1.1975."), 
				new Adresa("Bruski Put", "BB", "Brus", "Srbija"), "+3816625361441", "mirko.milutin@uns.ac.rs", 
				new Adresa("Dusanovacka", "25", "Novi Sad", "Srbija"), "0101975781022", "Docent", 15);
		
		Predmet pr1 = new Predmet("MA2", "Matematička Analiza 1", 9, 1, "Zimski");
		Predmet pr2 = new Predmet("SE3", "OISISI", 6, 3, "Zimski");
		Predmet pr3 = new Predmet("PR1", "Objektno programiranje", 8, 2, "Letnji");
		
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		studenti.add(s4);
		
		profesori.add(p1);
		profesori.add(p2);
		
		predmeti.add(pr1);
		predmeti.add(pr2);
		predmeti.add(pr3);
	}
	
	public void createStudentAndAddToStudents(ArrayList<JTextField> textFields, ArrayList<JComboBox<String>> comboBoxes) {
		String ime = unpackStringTextField(textFields.get(0));
		String prezime = unpackStringTextField(textFields.get(1));
		Date datumRodjenja = unpackDateTextField(textFields.get(2));
		Adresa adresa = unpackAdressTextField(textFields.get(3));
		String kontaktTelefon = unpackStringTextField(textFields.get(4));
		String email = unpackStringTextField(textFields.get(5));
		String brIndeksa = unpackStringTextField(textFields.get(6));
		int godUpisa = unpackIntTextField(textFields.get(7));
		int trenutnaGodStud = unpackComboBoxGodStud(comboBoxes.get(0));
		String statusStr = (String)comboBoxes.get(1).getSelectedItem();
		Student.Status status = Student.Status.B;
		if(statusStr == "Samofinansiranje")
			status = Student.Status.S;
		Student s = new Student(ime, prezime, datumRodjenja, adresa, kontaktTelefon, email, brIndeksa, godUpisa, trenutnaGodStud, status);
		studenti.add(s);
	}
	
	public void createProfesorAndAddToProfesors(ArrayList<JTextField> textFields) {
		String ime = unpackStringTextField(textFields.get(0));
		String prezime = unpackStringTextField(textFields.get(1));
		Date datumRodjenja = unpackDateTextField(textFields.get(2));
		Adresa adresa = unpackAdressTextField(textFields.get(3));
		String kontaktTelefon = unpackStringTextField(textFields.get(4));
		String email = unpackStringTextField(textFields.get(5));
		Adresa adresaKancelarije = unpackAdressTextField(textFields.get(6));
		String brLicneKarte = unpackStringTextField(textFields.get(7));
		String zvanje = unpackStringTextField(textFields.get(8));
		int brGodinaStaza = unpackIntTextField(textFields.get(9));
		Profesor p = new Profesor(ime, prezime, datumRodjenja, adresa, kontaktTelefon, email, adresaKancelarije, brLicneKarte,
								zvanje, brGodinaStaza);
		profesori.add(p);
	}
	
	public void createPredmetAndAddToPredmets(ArrayList<JTextField> textFields, ArrayList<JComboBox<String>> comboBoxes) {
		String sifra = unpackStringTextField(textFields.get(0));
		String naziv = unpackStringTextField(textFields.get(1));
		String semestar = (String)comboBoxes.get(0).getSelectedItem();
		int godina = unpackComboBoxGodStud(comboBoxes.get(1));
		int espb = unpackIntTextField(textFields.get(2));
		Predmet p = new Predmet(sifra, naziv, espb, godina, semestar);
		predmeti.add(p);
	}
	
	public String unpackStringTextField(JTextField tf) {
		return tf.getText().trim();
	}
	
	public Date unpackDateTextField(JTextField tf) {
		Date datumRodjenja = new Date(10);
		try {
		datumRodjenja = Util.formatter.parse(tf.getText().trim());
		} catch(ParseException ex) {
			ex.printStackTrace();
		}
		return datumRodjenja;
	}
	
	public Adresa unpackAdressTextField(JTextField tf) {
		String[] adressParts1 = tf.getText().trim().split(",");
		return new Adresa(adressParts1[0].trim(), adressParts1[1].trim(), adressParts1[2].trim(), adressParts1[3].trim());
	}
	
	public int unpackIntTextField(JTextField tf) {
		return Integer.parseInt(tf.getText().trim());
	}
	
	public int unpackComboBoxGodStud(JComboBox<String> cb) {
		String selectedText1 = (String)cb.getSelectedItem();
		switch(selectedText1) {
			case "II (druga)": return 2;
			case "III (treca)": return 3; 
			case "IV (cetvrta)": return 4; 
		}
		return 1;
	}
	
	public boolean isIndexStudentaUnique(String index) {
		for(Student s : studenti)
			if(index.equals(s.getBrojIndeksa()))
				return false;
		
		return true;
	}
	
	public boolean isSifraPredmetaUnique(String sifra) {
		for(Predmet p : predmeti)
			if(sifra.equals(p.getSifraPredmeta()))
				return false;
			
		return true;
		
	}
	
	public boolean isNazivPredmetaUnique(String naziv) {
		for(Predmet p : predmeti) 
			if(naziv.equals(p.getNazivPredmeta()))
				return false;
		
		return true;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
}
