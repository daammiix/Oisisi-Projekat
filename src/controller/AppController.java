package controller;

import model.AppData;
import view.AppView;

public class AppController {
	private static AppController instance = null;
	
	private static AppView appView = AppView.getInstance();
	private static AppData appData = AppData.getInstance();
	
	public static AppController getInstance() {
		if(instance == null)
			instance = new AppController();
		return instance;
	}
	
	private AppController() {
		
	}
}
