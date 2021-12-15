package view;

import java.awt.*;
import model.AppData;

public class AppView {
	private static AppView instance = null;
	
	public static AppView getInstance() {
		if(instance == null)
			instance = new AppView();
		return instance;
	}
	
	private static AppData data = AppData.getInstance();
	private AppFrame frame;
	private AppCentralPanel centralPanel;
	private AppMenuBar menuBar;
	private AppToolBar toolBar;
	private AppStatusBar statusBar;
	
	private AppView() {
		frame = AppFrame.getInstance();
		centralPanel = AppCentralPanel.getInstance();
		menuBar = AppMenuBar.getInstance();
		toolBar = AppToolBar.getInstance();
		statusBar = new AppStatusBar();
		
		frame.setJMenuBar(menuBar);
		
		frame.add(toolBar, BorderLayout.NORTH);
		
		frame.add(centralPanel, BorderLayout.CENTER);
		
		frame.add(statusBar, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	public void refreshTableStudenti() {
		centralPanel.clearTableStudenti();
		centralPanel.updateStudenti(data.getStudenti());
	}
	
	public void refreshTableProfesori() {
		centralPanel.clearTableProfesori();
		centralPanel.updateProfesori(data.getProfesori());
	}
	
	public void refreshTablePredmeti() {
		centralPanel.clearTablePredmeti();
		centralPanel.updatePredmeti(data.getPredmeti());
	}
}
