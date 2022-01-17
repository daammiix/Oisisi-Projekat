	package model;

import java.util.ArrayList;
import java.util.Date;

public class Profesor {
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private Adresa adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private Adresa adresaKancelarije;
	private String brojLicneKarte;
	private String zvanje;
	private int godineStaza;
	private ArrayList<Predmet> predmeti;
	
	public Profesor() {	
		super();
	}
	
	public Profesor(String ime, String prezime, String zvanje, String email) {
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
		this.email = email; 
		this.datumRodjenja = new Date(0);
		this.adresaStanovanja = new Adresa();
		this.kontaktTelefon = "";
		this.adresaKancelarije = new Adresa();
		this.brojLicneKarte = "";
		this.godineStaza = 0;
		predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, Date datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
			String email, Adresa adresaKancelarije, String brojLicneKarte, String zvanje, int godineStaza) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.zvanje = zvanje;
		this.godineStaza = godineStaza;
		predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor(String prezime, String ime, Date datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
			String email, Adresa adresaKancelarije, String brojLicneKarte, String zvanje, int godineStaza,
			ArrayList<Predmet> predmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.zvanje = zvanje;
		this.godineStaza = godineStaza;
		this.predmeti = predmeti;
	}
	


	public Profesor(String prezime, String ime, Date datumRodjenja) {
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
	}
	
	public void removePredmetFromProfesor(Predmet predmet) {
		for(Predmet p : predmeti) {
		      if(p.equals(predmet)) {
		    	  this.predmeti.remove(p);
		      }
		    }
	}

	
	public void addPredmet(Predmet p) {
		predmeti.add(p);
	}
	
	public void removePredmet(Predmet p) {
		predmeti.remove(p);
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

	public Adresa getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(Adresa adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public int getGodineStaza() {
		return godineStaza;
	}

	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
}
