package model;

public class Ocena {
	private String student;
	private String predmet;
	private int ocena;
	private String datum;
	
	public Ocena(String student, String predmet, int ocena, String datum) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datum = datum;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getPredmet() {
		return predmet;
	}

	public void setPredmet(String predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}
	
	private void println(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setOcena(int ocena) {
		if(ocena < 6 || ocena > 10){
			println("Ocena nije validna");
			}else {
				this.ocena = ocena;
			}
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	
}
