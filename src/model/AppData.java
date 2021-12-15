package model;

import java.text.ParseException;
import java.util.ArrayList;
import util.Util;

public class AppData {
	
	private static AppData instance = null;
	
	private ArrayList<Student> studenti;
	private ArrayList<Profesor> profesori;
	private ArrayList<Predmet> predmeti;
	
	public static AppData getInstance() {
		if(instance == null)
			instance = new AppData();
		return instance;
	}
	
	private AppData() {
		studenti = new ArrayList<Student>();
		profesori = new ArrayList<Profesor>();
		predmeti = new ArrayList<Predmet>();
	}
	
	public AppData(ArrayList<Student> studenti, ArrayList<Profesor> profesori, ArrayList<Predmet> predmeti) {
		this.studenti = studenti;
		this.profesori = profesori;
		this.predmeti = predmeti;
	}
	
	public void addStudent(Student s) {
		studenti.add(s);
	}
	
	public void addProfesor(Profesor p) {
		profesori.add(p);
	}
	
	public void addPredmet(Predmet p) {
		predmeti.add(p);
	}
	
	public void makeTestData() throws ParseException {
		Student s1 = new Student("ra-115-2019", "Damjan", "Dimitrijevic", 3, Status.B , 8.67);
		Student s2 = new Student("ra-102-2016", "Luka", "Lukic", 4, Status.S, 7.80);
		Student s3 = new Student("Mina", "Minic", Util.formatter.parse("22.2.1999."), 
				new Adresa("Bruski Put", "BB", "Krusevac", "Srbija"), "+38167787998", 
				"minicm100@gmail.com", "sw-25-2014", 2018, 4, Status.B);
		Student s4 = new Student("Petar", "Petrovic", Util.formatter.parse("10.05.2000."),  
					new Adresa("Kosovska", "110", "Krusevac", "Srbija"), "+38165559558", 
					"petrovicp11@gmail.com", "sw65-2019", 2019, 3, Status.B);
		
		Profesor p1 = new Profesor("Darko", "Darkovic", "Profesor", "darkod25@uns.ac.rs");
		Profesor p2 = new Profesor("Mirko", "Milutinovic", Util.formatter.parse("1.1.1975."), 
				new Adresa("Bruski Put", "BB", "Brus", "Srbija"), "+3816625361441", "mirko.milutin@uns.ac.rs", 
				new Adresa("Dusanovacka", "25", "Novi Sad", "Srbija"), "0101975781022", "Docent", 15);
		
		Predmet pr1 = new Predmet("MA2", "Matematička Analiza 1", 9, 1, "Zimski");
		Predmet pr2 = new Predmet("SE3", "OISISI", 6, 3, "Zimski");
		Predmet pr3 = new Predmet("PR1", "Objektno programiranje", 8, 2, "Letnji");
		
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		studenti.add(s4);
		
		profesori.add(p1);
		profesori.add(p2);
		
		predmeti.add(pr1);
		predmeti.add(pr2);
		predmeti.add(pr3);
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
}
