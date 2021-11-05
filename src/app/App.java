package app;

//import controller.*;
import model.*;
import view.*;
import java.awt.*;

public class App {
	private AppFrame frame;
	private AppMenuBar menuBar;
	private AppToolBar toolBar;
	private AppCentralPanel centralPanel;
	private AppStatusBar statusBar;
	
	public static void main(String[] args) {
		App app = new App();
		app.start();
	}
	// za pokretanje i testiranje aplikacije
	public void start() {
		frame = new AppFrame();
		menuBar = new AppMenuBar();
		toolBar = new AppToolBar();
		centralPanel = new AppCentralPanel();
		statusBar = new AppStatusBar();
		
		frame.setVisible(true);
		
		frame.setJMenuBar(menuBar);
		
		frame.add(toolBar, BorderLayout.NORTH);
		
		frame.add(centralPanel, BorderLayout.CENTER);
		
		frame.add(statusBar, BorderLayout.SOUTH);
		
		
	}
}
