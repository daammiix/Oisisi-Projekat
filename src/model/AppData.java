package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import util.Util;
import view.AppCentralPanel;
import view.AppView;

public class AppData {
	
	private static AppData instance = null;
	
	private ArrayList<Student> studenti;
	private ArrayList<Profesor> profesori;
	private ArrayList<Predmet> predmeti;
	private ArrayList<Katedra> katedra; 
	
	public static AppData getInstance() {
		if(instance == null)
			instance = new AppData();
		return instance;
	}
	
	private AppData() {
		studenti = new ArrayList<Student>();
		profesori = new ArrayList<Profesor>();
		predmeti = new ArrayList<Predmet>();
		katedra = new ArrayList<Katedra>();
	}
	
	public AppData(ArrayList<Student> studenti, ArrayList<Profesor> profesori, ArrayList<Predmet> predmeti, ArrayList<Katedra> katedra) {
		this.studenti = studenti;
		this.profesori = profesori;
		this.predmeti = predmeti;
		this.katedra = katedra;
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
	
	public void changeStudent(String indeks, ArrayList<JTextField> textFields, ArrayList<JComboBox<String>> comboBoxes) {
		int idx = -1;
		for(int i = 0; i < studenti.size(); i++) {
			if(studenti.get(i).getBrojIndeksa().equals(indeks)) {
				idx = i;
				break;
			}
		}
		Student student = studenti.get(idx);
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
		
		student.setIme(ime);
		student.setPrezime(prezime);
		student.setDatumRodjenja(datumRodjenja);
		student.setPrezime(prezime);
		student.setAdresaStanovanja(adresa);
		student.setKontaktTelefon(kontaktTelefon);
		student.setEmail(email);
		student.setBrojIndeksa(brIndeksa);
		student.setGodinaUpisa(godUpisa);
		student.setTrenutnaGodinaStudija(trenutnaGodStud);
		student.setStatus(status);
		

	}
	
	public void changeProfesor(String pEmail, ArrayList<JTextField> textFields) {
		int idx = -1;
		for(int i = 0; i < profesori.size(); i++)
			if(profesori.get(i).getEmail().equals(pEmail)) {
				idx = i;
				break;
			}
		
		Profesor profesor = profesori.get(idx);
		
		String ime = unpackStringTextField(textFields.get(0));
		String prezime = unpackStringTextField(textFields.get(1));
		Date datum = unpackDateTextField(textFields.get(2));
		Adresa adresaS = unpackAdressTextField(textFields.get(3));
		String brTel = unpackStringTextField(textFields.get(4));
		String email = unpackStringTextField(textFields.get(5));
		Adresa adresaK = unpackAdressTextField(textFields.get(6));
		String brLicKar = unpackStringTextField(textFields.get(7));
		String zvanje = unpackStringTextField(textFields.get(8));
		int godStaza = unpackIntTextField(textFields.get(9));
		
		profesor.setIme(ime);
		profesor.setPrezime(prezime);
		profesor.setDatumRodjenja(datum);
		profesor.setAdresaStanovanja(adresaS);
		profesor.setKontaktTelefon(brTel);
		profesor.setEmail(email);
		profesor.setAdresaKancelarije(adresaK);
		profesor.setBrojLicneKarte(brLicKar);
		profesor.setZvanje(zvanje);
		profesor.setGodineStaza(godStaza);
	}
	
	public void changePredmet(String pSifra, ArrayList<JTextField> textFields, JComboBox<Integer> cbGodine, JComboBox<String> cbSemestar) {
		int idx = -1;
		for(int i = 0; i < predmeti.size(); i++)
			if(predmeti.get(i).getSifraPredmeta().equals(pSifra)) {
				idx = i;
				break;
			}
		
		Predmet predmet = predmeti.get(idx);
		
		String sifra = unpackStringTextField(textFields.get(0));
		String naziv = unpackStringTextField(textFields.get(1));
		int godina = (Integer)cbGodine.getSelectedItem();
		String semestar = (String)cbSemestar.getSelectedItem();
		int espb = unpackIntTextField(textFields.get(2));
		String nazivProfesora = unpackStringTextField(textFields.get(3));
		
		String[] pr = nazivProfesora.split(" ");
		String imeProfesora = pr[0];
		for(Profesor p : profesori) {
			if(imeProfesora.equals(p.getIme())) {
				Profesor profesor = new Profesor(p.getIme(), p.getPrezime(), p.getZvanje(), p.getEmail());
				predmet.setPredmetniProfesor(profesor);
			}
		}
		
		predmet.setSifraPredmeta(sifra);
		predmet.setNazivPredmeta(naziv);
		predmet.setGodinaStudija(godina);
		predmet.setSemestar(semestar);
		predmet.setEspb(espb);
		
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
	
	public boolean isIndexStudentaChanged(String index) {
		int idx = AppCentralPanel.getInstance().getIndexStudent();
		Student student = getStudenti().get(idx);
		String indexStudenta = student.getBrojIndeksa();
		if(index.equals(indexStudenta)) {
			return true;
		} else return isIndexStudentaUnique(index);
	}
	
	public boolean isBrLicKarProfesoraUnique(String brLicKar) {
		for(Profesor p : profesori)
			if(brLicKar.equals(p.getBrojLicneKarte()))
				return false;
		
		return true;
	}
	
	public boolean isBrLicKarProfesoraChanged(String brLicKar) {
		int index = AppCentralPanel.getInstance().getIndexProfesori();
		Profesor profesor = getProfesori().get(index);
		String brLicKarProfesora = profesor.getBrojLicneKarte();
		if(brLicKar.equals(brLicKarProfesora)) {
			return true;
		} else return isBrLicKarProfesoraUnique(brLicKar);
	}
	
	public boolean isSifraPredmetaUnique(String sifra) {
		for(Predmet p : predmeti)
			if(sifra.equals(p.getSifraPredmeta()))
				return false;
			
		return true;
		
	}
	
	public boolean isNazivPredmetaUnique(String naziv) {
		for(Predmet p : predmeti) {
			if(naziv.equals(p.getNazivPredmeta()))
				return false;
		}
		
		return true;
	}
	
	public boolean isSifraPredmetaChanged(String sifra) {
		int index = AppCentralPanel.getInstance().getIndexPredmeti();
		Predmet predmet = getPredmeti().get(index);
		String sifraPredmeta = predmet.getSifraPredmeta();
		if(sifra.equals(sifraPredmeta)) {
			return true;
		} else return isSifraPredmetaUnique(sifra);
	}
	
	public boolean isNazivPredmetaChanged(String naziv)
	{	
		int index = AppCentralPanel.getInstance().getIndexPredmeti();
		Predmet predmet = getPredmeti().get(index);
		String nazivPredmeta = predmet.getNazivPredmeta();
		if(naziv.equals(nazivPredmeta)) {
			return true;
		} else return isNazivPredmetaUnique(naziv);
		
	}
	
	
	public void deleteStudent(Student student)
	{
		for(Iterator<Student> iterator = studenti.iterator(); iterator.hasNext(); ) {
			Student value = iterator.next();
		    if (value.equals(student)) {
		        iterator.remove();
		    }
		}
	}
	
	public void poloziPredmet(int selectedPredmet, int selectedStudent, JTextField date, JComboBox<String> ocena) {
		Student s = studenti.get(selectedStudent);
		Ocena o = s.getNepolozeniIspiti().get(selectedPredmet);
		s.getNepolozeniIspiti().remove(selectedPredmet);
		
		// zato sto je u cb-u string
		o.setOcena(Integer.parseInt((String)ocena.getSelectedItem()));
		try {
			o.setDatum(Util.formatter.parse(date.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		s.getPolozeniIspiti().add(o);
	}
	
	public void deleteProfesor(Profesor profesor)
	{
		for (Iterator<Profesor> iterator = profesori.iterator(); iterator.hasNext(); ) {
			Profesor value = iterator.next();
		    if (value.equals(profesor)) {
		        iterator.remove();
		    }
		}
	}
	
	public void deletePredmet(Predmet predmet)
	{
		for (Iterator<Predmet> iterator = predmeti.iterator(); iterator.hasNext(); ) {
			Predmet value = iterator.next();
		    if (value.equals(predmet)) {
		        iterator.remove();
		    }
		}
	}

	
	public void dodajPredmetProfesoru(Predmet pr, Profesor p) {
		p.addPredmet(pr);
	}
	
	public void ukloniPredmetProfesoru(Predmet pr, Profesor p) {
		p.removePredmet(pr);
	}
	
	public ArrayList<Student> getSearchedStudents(String[] parts) {
		ArrayList<Student> ret = new ArrayList<Student>();
		switch(parts.length) {
			case 1:
			{
				for(Student s : studenti) {
					if(s.getPrezime().toLowerCase().contains(parts[0]))
						ret.add(s);
				}
				break;
			}
			case 2:
			{
				String prezime = parts[0];
				String ime = parts[1];
				
				for(Student s : studenti) {
					if(s.getPrezime().toLowerCase().contains(prezime) && s.getIme().toLowerCase().contains(ime))
						ret.add(s);
				}
				break;
				}
			case 3:
			{
				String prezime = parts[2];
				String ime = parts[1];
				String brIndeksa = parts[0];
				
				for(Student s : studenti) {
					if(s.getPrezime().toLowerCase().contains(prezime) && s.getIme().toLowerCase().contains(ime)
				       && s.getBrojIndeksa().toLowerCase().contains(brIndeksa))
						ret.add(s);
				}
				break;
			}
		}
		return ret;
	}
	
	public ArrayList<Profesor> getSearchedProfesors(String[] parts) {
		ArrayList<Profesor> ret = new ArrayList<Profesor>();
		switch(parts.length) {
			case 1:
			{
				for(Profesor p : profesori)
					if(p.getPrezime().toLowerCase().contains(parts[0]))
						ret.add(p);
				break;
			}
			case 2:
			{
				for(Profesor p : profesori)
					if(p.getPrezime().toLowerCase().contains(parts[0]) && p.getIme().toLowerCase().contains(parts[1]))
						ret.add(p);
			}
		}
		return ret;
	}
	
	public ArrayList<Predmet> getSearchedPredmets(String[] parts) {
		ArrayList<Predmet> ret = new ArrayList<Predmet>();
		switch(parts.length) {
			case 1:
			{
				for(Predmet p : predmeti)
					if(p.getNazivPredmeta().toLowerCase().contains(parts[0]))
						ret.add(p);
				break;
			}
			case 2:
			{
				for(Predmet p : predmeti)
					if(p.getNazivPredmeta().toLowerCase().contains(parts[0]) &&
					   p.getSifraPredmeta().toLowerCase().contains(parts[1]))
						ret.add(p);
				break;
			}
		}
		return ret;
	}
	
	public Student getStudentByIndeks(String indeks) {
		Student ret = null;
		for(Student s : studenti)
			if(s.getBrojIndeksa().equals(indeks)) {
				ret = s;
				break;
			}
		return ret;
	}
	
	public Profesor getProfesorByEmail(String email) {
		Profesor ret = null;
		for(Profesor p : profesori)
			if(p.getEmail().equals(email)) {
				ret = p;
				break;
			}
		return ret;
	}
	
	public Predmet getPredmetBySifra(String sifra) {
		Predmet ret = null;
		for(Predmet p : predmeti)
			if(p.getSifraPredmeta().equals(sifra)) {
				ret = p;
				break;
			}
		return ret;
	}
	
	public int getStudentIdxByIndeks(String indeks) {
		int ret = -1;
		for(int i = 0; i < studenti.size(); i++)
			if(studenti.get(i).getBrojIndeksa().equals(indeks)) {
				ret = i;
				break;
			}
		return ret;
	}
	
	public int getProfesorIdxByEmail(String email) {
		int ret = -1;
		for(int i = 0; i < profesori.size(); i++)
			if(profesori.get(i).getEmail().equals(email)) {
				ret = i;
				break;
			}
		return ret;
	}
	
	public int getPredmetIdxBySifra(String sifra) {
		int ret = -1;
		for(int i = 0; i < studenti.size(); i++)
			if(predmeti.get(i).getSifraPredmeta().equals(sifra)) {
				ret = i;
				break;
			}
		return ret;
	}
	
	public void readDataBase() {
		try(BufferedReader frAdrese = new BufferedReader(new FileReader("baza" + File.separator + "Adrese.csv"));
			BufferedReader frStudenti = new BufferedReader(new FileReader("baza" + File.separator + "Studenti.csv"));
			BufferedReader frProfesori = new BufferedReader(new FileReader("baza" + File.separator + "Profesori.csv"));
			BufferedReader frPredmeti = new BufferedReader(new FileReader("baza" + File.separator + "Predmeti.csv"));
			BufferedReader frNepolozeni = new BufferedReader(new FileReader("baza" + File.separator + "Nepoloženi_predmeti.csv"));
			BufferedReader frOcene = new BufferedReader(new FileReader("baza" + File.separator + "Ocene.csv"));
			BufferedReader frKatedre = new BufferedReader(new FileReader("baza" + File.separator + "Katedre.csv"))) {
			
			ArrayList<Adresa> adrese = new ArrayList<Adresa>();
			
			String line = frAdrese.readLine();	// da se skipuje prva
			
			while((line = frAdrese.readLine()) != null) {
				String[] parts = line.split(",");
				adrese.add(new Adresa(parts[1], parts[2], parts[3], parts[4]));
			}
			
			line = frStudenti.readLine();
			while((line = frStudenti.readLine()) != null) {
				String[] parts = line.split(",");
				String[] indeksParts = parts[1].split(" ");
				String[] partsOfIndeksParts = indeksParts[1].split("/");
				String indeks = indeksParts[0] + "-" + partsOfIndeksParts[0] + "-" + partsOfIndeksParts[1];
				Adresa a = new Adresa();
				if(!(parts[6].equals("null")))
					a = adrese.get(Integer.parseInt(parts[6])-1);
				studenti.add(new Student(parts[2], parts[3], Util.formatter.parse(parts[5]), a, parts[7], parts[8],  indeks, 
						Integer.parseInt(parts[10]), Integer.parseInt(parts[4]), parts[9]));
			}
			
			line = frProfesori.readLine();
			while((line = frProfesori.readLine()) != null) {
				String[] parts = line.split(",");
				profesori.add(new Profesor(parts[2], parts[3], Util.formatter.parse(parts[4]), 
						adrese.get(Integer.parseInt(parts[5])-1), parts[6], parts[7], 
						adrese.get(Integer.parseInt(parts[8])-1), parts[1], parts[10], Integer.parseInt(parts[9])));
			}
			
			line = frPredmeti.readLine();
			while((line = frPredmeti.readLine()) != null) {
				String[] parts = line.split(",");
				Profesor p = null;
				if(!parts[5].equals("null")) 
					p = profesori.get(Integer.parseInt(parts[5])-1);
				Predmet pr = new Predmet(parts[1], parts[2], parts[6], Integer.parseInt(parts[3]), 
						p, Integer.parseInt(parts[4]));
				predmeti.add(pr);
				if(p != null)
					p.addPredmet(pr);
			}
			
			line = frNepolozeni.readLine();
			while((line = frNepolozeni.readLine()) != null) {
				String[] parts = line.split(",");
				studenti.get(Integer.parseInt(parts[0])-1).addNepolozenIspit(new 
						Ocena(studenti.get(Integer.parseInt(parts[0])-1), predmeti.get(Integer.parseInt(parts[1])-1),
						5, new Date(0)));
			}
			
			line = frOcene.readLine();
			while((line = frOcene.readLine()) != null) {
				String[] parts = line.split(",");
				studenti.get(Integer.parseInt(parts[0])-1).addPolozenIspit(new Ocena(
						studenti.get(Integer.parseInt(parts[0])-1), predmeti.get(Integer.parseInt(parts[1])-1),
						Integer.parseInt(parts[2]), Util.formatter.parse(parts[3])));
				for(Student s : studenti) {
					s.calculateAvgGrade();
				}
			}
			
			line = frKatedre.readLine();
			while((line = frKatedre.readLine()) != null) {
				String[] parts = line.split(",");
				katedra.add(new Katedra(parts[1], parts[2], profesori.get(Integer.parseInt(parts[3])-1)));
			}
			
		} catch (Exception e) {
			System.out.println("Error reading file...");
			e.printStackTrace();
		}
	}
	
	
	// getters and setters

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
	
	public ArrayList<Katedra> getKatedra() {
		return katedra;
	}

	public void setKatedra(ArrayList<Katedra> katedra) {
		this.katedra = katedra;
	}
}
