package model;

import java.io.Serializable;
import java.util.ArrayList;

enum Semestar{ L, Z; }

public class Predmet implements Serializable {
	private static final long serialVersionUID = 4098670493344095682L;
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	private int espb;
	private ArrayList<Student> studentiPolozili;
	private ArrayList<Student> studentiPali;
	
	public Predmet(String sifra, String naziv, int espb, int god, String semestar) {
		this.sifraPredmeta = sifra;
		this.nazivPredmeta = naziv;
		this.espb = espb;
		this.godinaStudija = god;
		if(semestar.equals("Letnji"))
			this.semestar = Semestar.L;
		else if(semestar.equals("Zimski"))
			this.semestar = Semestar.Z;
		studentiPolozili = new ArrayList<Student>();
		studentiPali = new ArrayList<Student>();
	}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			Profesor predmetniProfesor, int espb, ArrayList<Student> studentiPolozili, ArrayList<Student> studentiPali) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.espb = espb;
		this.studentiPolozili = studentiPolozili;
		this.studentiPali = studentiPali;
	}
	
	public Predmet(String sifra, String naziv, String semestar, int god, Profesor predmetniProfesor, int espb) {
		this.sifraPredmeta = sifra;
		this.nazivPredmeta = naziv;
		this.godinaStudija = god;
		this.espb = espb;
		this.predmetniProfesor = predmetniProfesor;
		if(semestar.equals("Letnji"))
			this.semestar = Semestar.L;
		else if(semestar.equals("Zimski"))
			this.semestar = Semestar.Z;
		studentiPolozili = new ArrayList<Student>();
		studentiPali = new ArrayList<Student>();
	}
	
	public void removeProfesorFromPredmet() {
		this.predmetniProfesor = null;
	  }
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}


	public String getNazivPredmeta() {
		return nazivPredmeta;
	}


	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}


	public String getSemestar() {
		if(this.semestar == Semestar.L)
			return "Letnji";
		else
			return "Zimski";
	}


	public void setSemestar(String semestar) {
		if(semestar.equals("Letnji"))
			this.semestar = Semestar.L;
		else
			this.semestar = Semestar.Z;
	}


	public int getGodinaStudija() {
		return godinaStudija;
	}


	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}


	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}


	public int getEspb() {
		return espb;
	}


	public void setEspb(int espb) {
		this.espb = espb;
	}


	public ArrayList<Student> getStudentiPolozili() {
		return studentiPolozili;
	}


	public void setStudentiPolozili(ArrayList<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}


	public ArrayList<Student> getStudentiPali() {
		return studentiPali;
	}


	public void setStudentiPali(ArrayList<Student> studentiPali) {
		this.studentiPali = studentiPali;
	}
	
	
}
