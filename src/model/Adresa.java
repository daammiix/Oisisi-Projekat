package model;

public class Adresa {
	private String ulica;
	private int broj;
	private String grad;
	private String drzava;
	
	public Adresa(String ulica, int broj, String grad, String drzava) {
		super();
		this.ulica = ulica;
		this.broj = broj;
		this.grad = grad;
		this.drzava = drzava;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	
	

}
