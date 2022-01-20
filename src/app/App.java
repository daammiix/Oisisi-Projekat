package app;

import model.*;
import view.*;
import java.text.ParseException;

import controller.AppController;

public class App {
	private AppView view;
	private AppData data;
	private AppController controller;
	
	public static void main(String[] args) {
		System.setProperty("awt.useSystemAAFontSettings","on");
		System.setProperty("swing.aatext", "true");
		App app = new App();
		app.start();
	}
	
	// za pokretanje i testiranje aplikacije
	public void start() {
		data = AppData.getInstance();
		view = AppView.getInstance();
		controller = AppController.getInstance();
		
		initState();
	}
	
	private void initState() {
		data.loadData();
		
		view.initTableStudenti();
		view.initTableProfesori();
		view.initTablePredmeti();
	}
}
