package model;

import java.io.Serializable;
import java.util.Date;

public class Ocena implements Serializable {
	private static final long serialVersionUID = 6392109282702018807L;
	
	private Student student;
	private Predmet	 predmet;
	private int ocena;
	private Date datum;
	
	public Ocena(Student student, Predmet predmet, int ocena, Date datum) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datum = datum;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		if(ocena < 6 || ocena > 10){
			System.out.println("Ocena nije validna");
			}else {
				this.ocena = ocena;
			}
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	
}
