package model;

import java.util.ArrayList;

public class Katedra {
	private int sifraKatedre;
	private String nazivKatedre;
	private String sefKatedre;
	private ArrayList<Profesor> profesori;
	public Katedra(int sifraKatedre, String nazivKatedre, String sefKatedre, ArrayList<Profesor> profesori) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sefKatedre;
		this.profesori = profesori;
	}
	public int getSifraKatedre() {
		return sifraKatedre;
	}
	public void setSifraKatedre(int sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}
	public String getNazivKatedre() {
		return nazivKatedre;
	}
	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}
	public String getSefKatedre() {
		return sefKatedre;
	}
	public void setSefKatedre(String sefKatedre) {
		this.sefKatedre = sefKatedre;
	}
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	
}
