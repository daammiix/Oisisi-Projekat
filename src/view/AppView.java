package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.AppData;
import model.Predmet;
import model.Profesor;
import view.addDialogs.*;
import view.changeDialogs.*;
import view.changeDialogs.Profesor.ChangeProfesorDialog;
import view.changeDialogs.Student.ChangeStudentDialog;
import view.deleteDialogs.*;
import view.dodavanjePredmetaProfesoruDialog.DodavanjePredmetaProfesoruDailog;
import view.helpAndAbout.AboutDialog;
import view.helpAndAbout.HelpDialog;
import view.katedraDialogs.KatedreDialog;
import view.katedraDialogs.RemoveSefKatedreDialog;
import view.katedraDialogs.SefKatedreDialog;
import view.katedraDialogs.TrenutniSefKatedre;
import view.polaganjeDialog.PolaganjeDialog;
import view.studentPredmetDialogs.AddStudentOnSubjectDialog;
import view.studentPredmetDialogs.DeleteStudentFromSubject;

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
	private AddStudentDialog addStudentDialog;
	private AddProfesorDialog addProfesorDialog;
	private AddPredmetDialog addPredmetDialog;
	private ChangeStudentDialog changeStudentDialog;
	private ChangeProfesorDialog changeProfesorDialog;
	private ChangePredmetDialog changePredmetDialog;
	private DeleteStudentDialog deleteStudentDialog;
	private DeleteProfesorDialog deleteProfesorDialog;
	private DeletePredmetDialog deletePredmetDialog;
	private NotSelectedDialog notSelectedDialog;
	private DaNeDialog ponistavanjeOceneDialog;
	private PolaganjeDialog polaganjeDialog;
	private DeleteStudentFromSubject deleteStudentFromSubject;
	private RemoveProfessorDialog removeProfessorDialog;
	private ChooseProfessorDialog chooseProfessorDialog;
	private KatedreDialog katedreDialog;
	private SefKatedreDialog sefKatedreDialog;
	private TrenutniSefKatedre trenutniSefKatedre;
	private RemoveSefKatedreDialog removeSefKatedreDialog;
	private AboutDialog aboutDialog;
	private HelpDialog helpDialog;

	private DodavanjePredmetaProfesoruDailog dodavanjePredmetaProfesoruDialog;
	private DaNeDialog uklanjanjePredmetaProfesoruDialog;

	private AddStudentOnSubjectDialog addStudentOnSubjectDialog;
	
	private AppView() {
		frame = AppFrame.getInstance();
		centralPanel = AppCentralPanel.getInstance();
		menuBar = AppMenuBar.getInstance();
		toolBar = AppToolBar.getInstance();
		statusBar = new AppStatusBar();
		addStudentDialog = new AddStudentDialog(frame, "Dodavanje studenta", true);
		addProfesorDialog = new AddProfesorDialog(frame, "Dodavanje profesora", true);
		addPredmetDialog = new AddPredmetDialog(frame, "Dodavanje predmeta", true);
		changeStudentDialog = new ChangeStudentDialog(frame, "Izmena studenta", true);
		changeProfesorDialog = new ChangeProfesorDialog(frame, "Izmena profesora", true);
		changePredmetDialog = new ChangePredmetDialog(frame, "Izmena predmeta", true);
		deleteStudentDialog = new DeleteStudentDialog(frame, "Brisanje studenta", true);
		deleteProfesorDialog = new DeleteProfesorDialog(frame, "Brisanje profesora", true);
		deletePredmetDialog = new DeletePredmetDialog(frame, "Brisanje predmeta", true);
		notSelectedDialog = new NotSelectedDialog(frame, "Greska prilikom selektovanja", true);
		ponistavanjeOceneDialog = new DaNeDialog(changeStudentDialog, "Poništavanje ocene", true, 
				"Da li ste sigurni da želite da poništite ocenu?");
		polaganjeDialog = new PolaganjeDialog(changeStudentDialog, "Unos ocene", true);
		dodavanjePredmetaProfesoruDialog = new DodavanjePredmetaProfesoruDailog(changeProfesorDialog, 
				"Dodaj predmet", true);
		uklanjanjePredmetaProfesoruDialog = new DaNeDialog(changeProfesorDialog, "Ukloni predmet", true, 
				"Da li ste sigurni da želite da uklonite predmet?");
		
		addStudentOnSubjectDialog = new AddStudentOnSubjectDialog(frame, "Dodavanje predmeta", true);
		deleteStudentFromSubject = new DeleteStudentFromSubject(frame, "Uklanjanje predmeta", true);
		removeProfessorDialog = new RemoveProfessorDialog(frame, "Ukloni Profesora", true);
		chooseProfessorDialog =  new ChooseProfessorDialog(frame, "Odaberi profesora", true);
		katedreDialog =  new KatedreDialog(frame,"Katedre", true);
		sefKatedreDialog = new SefKatedreDialog(frame, "Profesori", true);
		trenutniSefKatedre = new TrenutniSefKatedre(frame, "Trenutni sef katedre", true);
		removeSefKatedreDialog = new RemoveSefKatedreDialog(frame, "Ukloni sefa katedre", true);
		aboutDialog = new AboutDialog(frame, "About", true);
		helpDialog = new HelpDialog(frame, "Help", true);
		
		statusBar.setNaziv(frame.getTitle(), centralPanel.getSelectedTabTitle());
		
		frame.setJMenuBar(menuBar);
		
		frame.add(toolBar, BorderLayout.NORTH);
		
		frame.add(centralPanel, BorderLayout.CENTER);
		
		frame.add(statusBar, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	public void initComponents() {
		addStudentDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Dodavanje_studenta"));
		addProfesorDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Dodavanje_profesora"));
		addPredmetDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Dodavanje_predmeta"));
		changeStudentDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Izmena_studenta"));
		changeProfesorDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Izmena_profesora"));
		changePredmetDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Izmena_predmeta"));
		deleteStudentDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Brisanje_studenta"));
		deleteProfesorDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Brisanje_profesora"));
		deletePredmetDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Brisanje_predmeta"));
		ponistavanjeOceneDialog = new DaNeDialog(changeStudentDialog, AppFrame.getInstance().getResourceBundle().getString("Ponistavanje_ocene"), true, 
				AppFrame.getInstance().getResourceBundle().getString("poruka_ponisti"));
		polaganjeDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Unos_ocene"));
		dodavanjePredmetaProfesoruDialog = new DodavanjePredmetaProfesoruDailog(changeProfesorDialog, 
				AppFrame.getInstance().getResourceBundle().getString("Dodavanje_predmeta"), true);
		uklanjanjePredmetaProfesoruDialog = new DaNeDialog(changeProfesorDialog, AppFrame.getInstance().getResourceBundle().getString("Ukloni_predmet"), true, 
				AppFrame.getInstance().getResourceBundle().getString("poruka_ukloni"));
		notSelectedDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Greska_prilikom_selektovanja"));
		addStudentOnSubjectDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Dodavanje_predmeta"));
		deleteStudentFromSubject.setTitle(AppFrame.getInstance().getResourceBundle().getString("Ukloni_predmet"));
		removeProfessorDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Ukloni_Profesora"));
		chooseProfessorDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Odaberi_profesora"));
		katedreDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("tKatedre"));
		sefKatedreDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("tProfesori"));
		trenutniSefKatedre.setTitle(AppFrame.getInstance().getResourceBundle().getString("Trenutni_sef_katedre"));
		removeSefKatedreDialog.setTitle(AppFrame.getInstance().getResourceBundle().getString("Ukloni_sefa_katedre"));
	}
	
	public void tabChangedListener(ChangeListener cl) {
		centralPanel.addChangeListener(cl);
	}
	
	public void initTableStudenti() {
		centralPanel.clearTableStudenti();
		centralPanel.updateStudenti(data.getStudenti());
	}
	
	public void initTableProfesori() {
		centralPanel.clearTableProfesori();
		centralPanel.updateProfesori(data.getProfesori());
	}
	
	public void initTablePredmeti() {
		centralPanel.clearTablePredmeti();
		centralPanel.updatePredmeti(data.getPredmeti());
	}
	
	public void addAddEntityListener(ActionListener al) {
		toolBar.getBtnOpen().addActionListener(al);
		menuBar.getMiNew().addActionListener(al);
	}
	
	public void addChangeEntityListener(ActionListener cal) {
		toolBar.getBtnEdit().addActionListener(cal);
		menuBar.getMiEdit().addActionListener(cal);
	}
	
	public void addDeleteEntityListener(ActionListener dal) {
		toolBar.getBtnDelete().addActionListener(dal);
		menuBar.getMiDelete().addActionListener(dal);
	}
	
	public void addKatedraListener(ActionListener dal) {
		menuBar.getMiKatedre().addActionListener(dal);
	}
	
	public void addHelpListener(ActionListener dal) {
		menuBar.getMiHelp().addActionListener(dal);
	}
	
	public void addAboutListener(ActionListener dal) {
		menuBar.getMiAbout().addActionListener(dal);
	}
	
	public void addCloseListener(ActionListener dal) {
		menuBar.getMiClose().addActionListener(dal);
	}
	
	public void addStudentiOPenListener(ActionListener dal) {
		menuBar.getMiStudenti().addActionListener(dal);
	}
	
	public void addProfesoriOPenListener(ActionListener dal) {
		menuBar.getMiProfesori().addActionListener(dal);
	}
	
	public void addPredmetiOPenListener(ActionListener dal) {
		menuBar.getMiPredmeti().addActionListener(dal);
	}
	
	public boolean isTextFieldValid(JTextField tf, String pattern) {
		String text = tf.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		if(m.matches())
			return true;
		return false;
	}
	
	// getters and setters

	public AppFrame getFrame() {
		return frame;
	}

	public AppCentralPanel getCentralPanel() {
		return centralPanel;
	}

	public AppMenuBar getMenuBar() {
		return menuBar;
	}

	public AppToolBar getToolBar() {
		return toolBar;
	}

	public AppStatusBar getStatusBar() {
		return statusBar;
	}

	public AddStudentDialog getAddStudentDialog() {
		return addStudentDialog;
	}

	public AddProfesorDialog getAddProfesorDialog() {
		return addProfesorDialog;
	}

	public AddPredmetDialog getAddPredmetDialog() {
		return addPredmetDialog;
	}
	
	public ChangeStudentDialog getChangeStudentDialog() {
		return changeStudentDialog;
	}

	public ChangeProfesorDialog getChangeProfesorDialog() {
		return changeProfesorDialog;
	}

	public ChangePredmetDialog getChangePredmetDialog() {
		return changePredmetDialog;
	}
	
	public JDialog getDeleteStudentDialogOrNotSelected() {
		if (AppCentralPanel.getInstance().getIndexStudent() >= 0) {
			return deleteStudentDialog;
		} else {
			return notSelectedDialog;
		}
	}
	
	public JDialog getDeleteProfesorDialogOrNotSelected() {
		if (AppCentralPanel.getInstance().getIndexProfesori() >= 0) {
			return deleteProfesorDialog;
		} else {
			return notSelectedDialog;
		}
	}
	
	public JDialog getDeletePredmetDialogOrNotSelected() {
		if (AppCentralPanel.getInstance().getIndexPredmeti() >= 0) {
			return deletePredmetDialog;
		} else {
			return notSelectedDialog;
		}
	}
	
	public DeleteStudentDialog getDeleteStudentDialog() {
		return deleteStudentDialog;
	}

	public DeleteProfesorDialog getDeleteProfesorDialog() {
		return deleteProfesorDialog;
	}

	public DeletePredmetDialog getDeletePredmetDialog() {
		return deletePredmetDialog;
	}
	
	public NotSelectedDialog getNotSelectedDialog() {
		return notSelectedDialog;
	}
	
	public DaNeDialog getPonistavanjeOceneDialog() {
		return this.ponistavanjeOceneDialog;
	}
	
	public PolaganjeDialog getPolaganjeDialog() {
		return this.polaganjeDialog;
	}
	

	public DodavanjePredmetaProfesoruDailog getDodavanjePredmetaProfesoruDialog() {
		return this.dodavanjePredmetaProfesoruDialog;
	}
	
	public DaNeDialog getUklanjanjePredmetaProfesoruDialog() {
		return this.uklanjanjePredmetaProfesoruDialog;
	}

	public AddStudentOnSubjectDialog getAddStudentOnSubjectDialog() {
		return this.addStudentOnSubjectDialog;

	}
	
	public DeleteStudentFromSubject getDeleteStudentFromSubject() {
		return this.deleteStudentFromSubject;
	}
	
	public RemoveProfessorDialog getRemoveProfessorDialog() {
		return this.removeProfessorDialog;
	}
	
	public ChooseProfessorDialog getChooseProfessorDialog() {
		return this.chooseProfessorDialog;
	}
	
	public KatedreDialog getKatedreDialog() {
		return this.katedreDialog;
	}
	
	public SefKatedreDialog getSefKatedreDialog() {
		return this.sefKatedreDialog;
	}
	
	public TrenutniSefKatedre getTrenutniSefKatedre() {
		return this.trenutniSefKatedre;
	}
	
	public RemoveSefKatedreDialog getRemoveSefKatedreDialog() {
		return this.removeSefKatedreDialog;
	}
	
	public AboutDialog getAboutDialog() {
		return this.aboutDialog;
	}
	
	public HelpDialog getHelpDialog() {
		return this.helpDialog;
	}
}
