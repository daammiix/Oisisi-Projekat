package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = 4358325220616864185L;

	public static enum Status {S, B};
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private Adresa adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String brojIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Status status;
	private double prosecnaOcena;
	private ArrayList<Ocena> polozeniIspiti;
	private ArrayList<Ocena> nepolozeniIspiti;
	
	public static Class<Status> getStatusClass() {
		return Status.class; 
	}
	
	public Student() {
		super();
	}
	
	public Student(String brojIndeksa, String ime, String prezime, int godStudija, Status status, double prosek) {
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.trenutnaGodinaStudija = godStudija;
		this.status = status;
		this.prosecnaOcena = prosek;
		this.datumRodjenja = new Date(0);
		this.adresaStanovanja = new Adresa();
		this.kontaktTelefon = "";
		this.email = "";
		this.godinaUpisa = 0;
		this.polozeniIspiti = new ArrayList<Ocena>();
		this.nepolozeniIspiti = new ArrayList<Ocena>();
	}

	public Student(String ime, String prezime, Date datumRodjenja, Adresa a, String br, String email, String brInd, int godUpisa, int trenutnaGod, String status) {
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = a;
		this.kontaktTelefon = br;
		this.email = email;
		this.brojIndeksa = brInd;
		this.godinaUpisa = godUpisa;
		this.trenutnaGodinaStudija = trenutnaGod;
		if(status.equals("S"))
			this.status = Student.Status.S;
		else
			this.status = Student.Status.B;
		this.prosecnaOcena = 0;
		polozeniIspiti = new ArrayList<Ocena>();
		nepolozeniIspiti = new ArrayList<Ocena>();
	}
	
	public Student(String ime, String prezime, Date datumRodjenja, Adresa a, String br, String email, String brInd, int godUpisa, int trenutnaGod, Status status) {
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = a;
		this.kontaktTelefon = br;
		this.email = email;
		this.brojIndeksa = brInd;
		this.godinaUpisa = godUpisa;
		this.trenutnaGodinaStudija = trenutnaGod;
		this.status = status;
		this.prosecnaOcena = 0;
		polozeniIspiti = new ArrayList<Ocena>();
		nepolozeniIspiti = new ArrayList<Ocena>();
	}
	
	public Student(String brInd, String ime, String prezime, int trenutnaGod, Date datumRodjenja, Adresa a, String br, String email, Status status, int godUpisa) {
		this.brojIndeksa = brInd;
		this.ime = ime;
		this.prezime = prezime;
		this.trenutnaGodinaStudija = trenutnaGod;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = a;
		this.kontaktTelefon = br;
		this.email = email;
		this.status = status;
		this.godinaUpisa = godUpisa;
		this.prosecnaOcena = 0;
		polozeniIspiti = new ArrayList<Ocena>();
		nepolozeniIspiti = new ArrayList<Ocena>();
	}
	
	public Student(Student s1) {
		this.prezime = s1.prezime;
		this.ime = s1.ime;
		this.datumRodjenja = s1.datumRodjenja;
		this.adresaStanovanja = s1.adresaStanovanja;
		this.kontaktTelefon = s1.kontaktTelefon;
		this.email = s1.email;
		this.brojIndeksa = s1.brojIndeksa;
		this.godinaUpisa = s1.godinaUpisa;
		this.trenutnaGodinaStudija = s1.trenutnaGodinaStudija;
		this.status = s1.status;
		this.prosecnaOcena = s1.prosecnaOcena;
		this.polozeniIspiti = s1.polozeniIspiti;
		this.nepolozeniIspiti = s1.nepolozeniIspiti;
	}
	
	public void addPolozenIspit(Ocena o) {
		this.polozeniIspiti.add(o);
	}
	
	public void addNepolozenIspit(Ocena o) {
		this.nepolozeniIspiti.add(o);
	}

	public void removePredmetFromPolozeni(int idx) {
		this.polozeniIspiti.remove(idx);
	}
	
	
	public void removePredmetFromNepolozeni(int idx) {
		this.nepolozeniIspiti.remove(idx);
	}
	
	public void removePredmetNepolozeni(Predmet p) {
		Ocena zaBrisanje = null;
		for(Ocena o : nepolozeniIspiti) 
			if(o.getPredmet().getSifraPredmeta().equalsIgnoreCase(p.getSifraPredmeta())) {
				zaBrisanje = o;
				break;
			}
		if(zaBrisanje != null)
			nepolozeniIspiti.remove(zaBrisanje);
	}
	
	public void removePredmetPolozeni(Predmet p) {
		Ocena zaBrisanje = null;
		for(Ocena o : polozeniIspiti) 
			if(o.getPredmet().getSifraPredmeta().equalsIgnoreCase(p.getSifraPredmeta())) {
				zaBrisanje = o;
				break;
			}
		if(zaBrisanje != null)
			polozeniIspiti.remove(zaBrisanje);
	}
	
	public void calculateAvgGrade() {
		double sum = 0;
		if(polozeniIspiti.size() != 0) {
			for(Ocena o : polozeniIspiti) {
				sum += o.getOcena();
			}
			this.setProsecnaOcena(sum/polozeniIspiti.size());
			return;
		}
		this.setProsecnaOcena(0.0);
	}
	
	// getters and setters

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Adresa getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(Adresa adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}

	public void setPolozeniIspiti(ArrayList<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}

	public ArrayList<Ocena> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}

	public void setNepolozeniIspiti(ArrayList<Ocena> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
}
