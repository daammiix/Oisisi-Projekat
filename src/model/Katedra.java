package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Katedra implements Serializable {
	private static final long serialVersionUID = 7239849069201218863L;
	
	private String sifraKatedre;
	private String nazivKatedre;
	private Profesor sefKatedre;
	private ArrayList<Profesor> profesori;
	
	public Katedra(String sifraKatedre, String nazivKatedre, Profesor sefKatedre, ArrayList<Profesor> profesori) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sefKatedre;
		this.profesori = profesori;
	}
	
	public Katedra(String sifraKatedre, String nazivKatedre) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.profesori = new ArrayList<Profesor>();
	}
	
	public Katedra(String sifraKatedre, String nazivKatedre, Profesor sef) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sef;
		this.profesori = new ArrayList<Profesor>();
	}
	
	public void removeSefFromKatedra() {
		this.sefKatedre = null; 
	}
	
	public void addSefKatedre(Profesor profesor) {
		this.sefKatedre = profesor;
	}
	
	public void addProfesor(Profesor p) {
		profesori.add(p);
	}
	
	public String getSifraKatedre() {
		return sifraKatedre;
	}
	
	public void setSifraKatedre(String sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}
	public String getNazivKatedre() {
		return nazivKatedre;
	}
	
	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}
	
	public Profesor getSefKatedre() {
		return sefKatedre;
	}
	
	public void setSefKatedre(Profesor sefKatedre) {
		this.sefKatedre = sefKatedre;
	}
	
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
}
