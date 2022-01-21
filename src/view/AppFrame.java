package view;

import javax.swing.*;

import controller.AppController;
import view.panelInformacije.PanelInformacije;

import java.awt.*;

import java.awt.event.WindowListener;

import java.util.Locale;
import java.util.ResourceBundle;


public class AppFrame extends JFrame {
	private static AppFrame instance = null;
	
	private ResourceBundle resourceBundle;
	
	public static AppFrame getInstance() {
		if(instance == null) 
			instance = new AppFrame();
			instance.inItFrame();
		return instance;
	}

	private static final long serialVersionUID = -912989417505291367L;

	private AppFrame() {
		Locale.setDefault(new Locale("sr", "RS"));
		resourceBundle = ResourceBundle.getBundle("messageResources.MessageResources", Locale.getDefault());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		this.setSize(width * 3/4, height * 3/4);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		

	}
	
	public void inItFrame() {
		this.setTitle(resourceBundle.getString("naslovAplikacije"));
	}
	
	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("messageResources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("naslovAplikacije"));
		AppCentralPanel.getInstance().initComponents();
		AppMenuBar.getInstance().initComponents();
		AppStatusBar.getInstance().initComponents();
		AppToolBar.getInstance().initComponents();
		AppView.getInstance().initComponents();
		AppView.getInstance().getPonistavanjeOceneDialog().initComponents();
		AppView.getInstance().getKatedreDialog().initComponents();
		AppView.getInstance().getRemoveSefKatedreDialog().initComponents();
		AppView.getInstance().getSefKatedreDialog().initComponents();
		AppView.getInstance().getTrenutniSefKatedre().initComponents();
		AppView.getInstance().getAddStudentOnSubjectDialog().initComponents();
		AppView.getInstance().getDeleteStudentFromSubject().initComponents();
		AppView.getInstance().getAboutDialog().initComponents();
		AppView.getInstance().getHelpDialog().initComponents();
		AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni().initComponents();
		AppView.getInstance().getChangeStudentDialog().getPanelPolozeni().initComponents();
		AppView.getInstance().getChangeStudentDialog().getPanelInformacije().initComponents();
		AppView.getInstance().getChangeStudentDialog().initComponents();
		AppView.getInstance().getNotSelectedDialog().initComponents();
		AppView.getInstance().getDeletePredmetDialog().initComponents();
		AppView.getInstance().getDeleteStudentDialog().initComponents();
		AppView.getInstance().getDeleteProfesorDialog().initComponents();
		AppView.getInstance().getDodavanjePredmetaProfesoruDialog().initComponents();		
		AppView.getInstance().getAddPredmetDialog().initComponents();
		AppView.getInstance().getAddStudentDialog().initComponents();
		AppView.getInstance().getAddProfesorDialog().initComponents();
		AppView.getInstance().getChangePredmetDialog().initComponents();
		AppView.getInstance().getRemoveProfessorDialog().initComponents();
		AppView.getInstance().getChooseProfessorDialog().initComponents();
		AppView.getInstance().getChangeProfesorDialog().initComponents();
		AppView.getInstance().getChangeProfesorDialog().getInformacije().initComponents();
		AppView.getInstance().getChangeProfesorDialog().getPredmeti().initComponents();
		
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public void connectWindowListener(WindowListener wl) {
		this.addWindowListener(wl);
	}
}
