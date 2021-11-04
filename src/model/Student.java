package model;

import java.util.ArrayList;

enum Status{ S, B; }

public class Student {
	private String prezime;
	private String ime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String brojIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Status status;
	double prosecnaOcena;
	ArrayList<String> polozeniIspiti;
	ArrayList<String> nepolozeniIspiti;
	
	public Student() {
		super();
	}
	
	public Student(String prezime, String ime, String datumRodjenja) {
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
	}

	public Student(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, int godinaUpisa, int trenutnaGodinaStudija, Status status,
			double prosecnaOcena, ArrayList<String> polozeniIspiti, ArrayList<String> nepolozeniIspiti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.polozeniIspiti = polozeniIspiti;
		this.nepolozeniIspiti = nepolozeniIspiti;
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

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
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

	public ArrayList<String> getPolozeniIspiti() {
		return polozeniIspiti;
	}

	public void setPolozeniIspiti(ArrayList<String> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}

	public ArrayList<String> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}

	public void setNepolozeniIspiti(ArrayList<String> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
}
