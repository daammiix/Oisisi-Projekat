package model;

import java.util.ArrayList;

public class Predmet {
	private int sifraPredmeta;
	private String nazivPredmeta;
	private String semestar;
	private int godinaStudija;
	private String predmetniProfesor;
	private int espb;
	private ArrayList<Student> studentiPolozili;
	private ArrayList<Student> studentiPali;
	
	
	public Predmet(int sifraPredmeta, String nazivPredmeta, String semestar, int godinaStudija,
			String predmetniProfesor, int espb, ArrayList<Student> studentiPolozili, ArrayList<Student> studentiPali) {
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


	public int getSifraPredmeta() {
		return sifraPredmeta;
	}


	public void setSifraPredmeta(int sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}


	public String getNazivPredmeta() {
		return nazivPredmeta;
	}


	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}


	public String getSemestar() {
		return semestar;
	}


	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}


	public int getGodinaStudija() {
		return godinaStudija;
	}


	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


	public String getPredmetniProfesor() {
		return predmetniProfesor;
	}


	public void setPredmetniProfesor(String predmetniProfesor) {
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
