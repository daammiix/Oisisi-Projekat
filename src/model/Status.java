package model;

public enum Status {
	B("Budžet"), S("Samofinansiranje");
	
	String name;
	
	Status(String s) {
		name = s;
	}
	
	String getName() {
		return name;
	}
}
