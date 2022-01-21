package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.addStudentOnSubjectListeners.BtnDodajListener;
import controller.addStudentOnSubjectListeners.BtnOdustaniListener;
import controller.addStudentOnSubjectListeners.DodajBtnListener;
import controller.changeSubject.BtnMinusListener;
import controller.changeSubject.BtnOdustaniProfesorListener;
import controller.changeSubject.BtnPlusListener;
import controller.changeSubject.BtnPotvrdiProfesoraListener;
//import controller.addStudentOnSubjectListeners.ObrisiPredmetaBtnListener;
import controller.daNeOk.BtnDaListener;
import controller.daNeOk.BtnNeListener;
import controller.daNeOk.BtnOkListener;
import controller.deleteStudentFromSubject.AddBtnDaListener;
import controller.deleteStudentFromSubject.AddBtnNeListener;
import controller.deleteStudentFromSubject.AddBtnObrisiListener;
import controller.documentsListeners.DocumentListenerPredmet;
import controller.documentsListeners.DocumentListenerProfesor;
import controller.documentsListeners.DocumentListenerStudent;
import controller.dodavanjePredmetaProfesoru.DodajPredmetBtnListener;
import controller.helpAbout.ZatvoriBtnListener;
import controller.katedra.BtnIzmeniListener;
import controller.katedra.BtnMinusSefListener;
import controller.katedra.BtnPlusSefListener;
import controller.polaganjePredmeta.PolaganjePredmetaBtnListener;
import controller.ponistavanjeOcene.*;
import controller.potvrdiOdustani.*;
import controller.uklanjanjePredmetaProfesoru.DaNeBtnListenerUkloniPredmet;
import controller.uklanjanjePredmetaProfesoru.UkloniPredmetBtnListener;
import model.AppData;
import model.Katedra;
import model.Profesor;
import model.Student;
import model.TableStudentIndexValue;
import util.Util;
import view.AppCentralPanel;
import view.AppFrame;
import view.AppView;
import view.changeDialogs.ChangePredmetDialog;
import view.changeDialogs.Profesor.ChangeProfesorDialog;
import view.changeDialogs.Student.ChangeStudentDialog;
import view.deleteDialogs.DeleteStudentDialog;
import view.deleteDialogs.NotSelectedDialog;


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
		
		this.addEntityListener();
		this.addOdustaniBtnListener();
		this.addPotvrdiBtnListener();
		this.tabChangedListener();
		this.addBtnDaListener();
		this.addBtnNeListener();
		this.addBtnOkListener();
		this.addBtnPotvrdiChangeListener();
		this.addBtnOdustaniChangeDialog();
		this.addDocumentListeners();
		this.addPonistavanjeOceneDialogListeners();
		this.addPolaganjePredmetaBtnListeners();
		this.addIzmenaProfesoraPredmetiBtnListeners();
		this.addDodajBtnListener();
		this.addBtnDodajListener();
		this.addBtnOdustaniListener();
		this.addBtnObrisiActionListener();
		this.addDeleteBtnNeListener();
		this.addDeleteBtnDaListener();
		this.addMinusBtnListener();
		this.addPlusBtnListener();
		this.addOdustaniProfesorBtnListener();
		this.addBtnPotvrdiProfesoraListener();
		this.addBtnIzmeniKatedruListener();
		this.addMinusSefBtnListener();
		this.addPlusSefBtnListener();
		this.addBtnZatvoriListener();
		this.addSearchBtnActionListener();
		this.addMainFrameWindowListener();
		this.addSaveMenuItemActionListener();
	}
	
	public void tabChangedListener() {
		appView.tabChangedListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				appView.getStatusBar().setNaziv(appView.getCentralPanel().getSelectedTabTitle());
			}
		});
	}
	
	public void addEntityListener() {
		appView.addAddEntityListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				String studenti = AppFrame.getInstance().getResourceBundle().getString("tStudenti");
				String profesori = AppFrame.getInstance().getResourceBundle().getString("tProfesori");
				String predmeti = AppFrame.getInstance().getResourceBundle().getString("tPredmeti");
				String naziv = appView.getCentralPanel().getSelectedTabTitle();
					if(naziv.equals(studenti))
						{
							appView.getAddStudentDialog().setLocationRelativeTo(appView.getFrame());
							appView.getAddStudentDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
							appView.getAddStudentDialog().getPanelInformacije().clearTextFields();
							appView.getAddStudentDialog().getPanelInformacije().refreshComboBoxes();
							appView.getAddStudentDialog().getPanelInformacije().getTextFields().get(0).requestFocus();
							appView.getAddStudentDialog().setVisible(true);
						}
					else if(naziv.equals(profesori))
						{
							appView.getAddProfesorDialog().setLocationRelativeTo(appView.getFrame());
							appView.getAddProfesorDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
							appView.getAddProfesorDialog().getPanelInformacije().clearTextFields();
							appView.getAddProfesorDialog().getPanelInformacije().getTextFields().get(0).requestFocus();
							appView.getAddProfesorDialog().setVisible(true);
						}
					else if(naziv.equals(predmeti))
						{
							appView.getAddPredmetDialog().setLocationRelativeTo(appView.getFrame());
							appView.getAddPredmetDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
							appView.getAddPredmetDialog().getPanelInformacije().clearTextFields();
							appView.getAddPredmetDialog().getPanelInformacije().refreshComboBoxes();
							appView.getAddPredmetDialog().getPanelInformacije().getTextFields().get(0).requestFocus();
							appView.getAddPredmetDialog().setVisible(true);
						}
					else 
					{
						System.out.println("Ne postoji takav tab");
					}
				}
			}
		);
		
		appView.addChangeEntityListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				String studenti = AppFrame.getInstance().getResourceBundle().getString("tStudenti");
				String profesori = AppFrame.getInstance().getResourceBundle().getString("tProfesori");
				String predmeti = AppFrame.getInstance().getResourceBundle().getString("tPredmeti");
				String naziv = appView.getCentralPanel().getSelectedTabTitle();
					if(naziv.equals(studenti))
						{
							int selectedRow = AppCentralPanel.getInstance().getIndexStudent();
							ChangeStudentDialog dialog1 =appView.getChangeStudentDialog();
							NotSelectedDialog dialog2 = appView.getNotSelectedDialog();
							if(selectedRow >= 0) {
								TableStudentIndexValue selectedValue = (TableStudentIndexValue) appView.getCentralPanel().gettStudenti().
										getValueAt(selectedRow, 0);
								String selectedStudentIndeks = selectedValue.getIndeks();
								Student selectedStudent = appData.getStudentByIndeks(selectedStudentIndeks);
								dialog1.setLocationRelativeTo(appView.getFrame());
								appView.getChangeStudentDialog().getPanelInformacije().fillInStudent(selectedStudent);
								dialog1.getPanelPolozeni().refreshInfo(selectedStudent);
								appView.getAddStudentOnSubjectDialog().initTable(selectedStudent);
								dialog1.getPanelNepolozeni().refreshInfo(selectedStudent);
								dialog1.getTabbedPane().setSelectedIndex(0);
								dialog1.setVisible(true);
							}else {
								dialog2.setLocationRelativeTo(appView.getFrame());
								dialog2.setVisible(true);
							}					
						}
					else if(naziv.equals(profesori))
						{
							int selectedRow = AppCentralPanel.getInstance().getIndexProfesori();
							ChangeProfesorDialog dialog1 =appView.getChangeProfesorDialog();
							NotSelectedDialog dialog2 = appView.getNotSelectedDialog();
							if(selectedRow >= 0) {
								String selectedProfesorEmail = (String) appView.getCentralPanel().gettProfesori().
										getValueAt(selectedRow, 3);
								Profesor selectedProfesor = appData.getProfesorByEmail(selectedProfesorEmail);
								dialog1.setLocationRelativeTo(appView.getFrame());
								appView.getChangeProfesorDialog().getInformacije().fillInProfesor(selectedProfesor);
								appView.getChangeProfesorDialog().getPredmeti().refreshInfo(selectedProfesor);
								dialog1.getPredmeti().refreshInfo(selectedProfesor);
								dialog1.getTabbedPane().setSelectedIndex(0);
								dialog1.setVisible(true);
							} else {
								dialog2.setLocationRelativeTo(appView.getFrame());
								dialog2.setVisible(true);
							}
						}
					else if(naziv.equals(predmeti))
						{
							int selectedRow = AppCentralPanel.getInstance().getIndexPredmeti();
							ChangePredmetDialog dialog1 =appView.getChangePredmetDialog();
							NotSelectedDialog dialog2 = appView.getNotSelectedDialog();
							ArrayList<JTextField> textFields = AppView.getInstance().getChangePredmetDialog().getTextFields();
							textFields = appView.getChangePredmetDialog().getTextFields();
							if(selectedRow >= 0) {
								String selectedPredmetSifra = (String) appView.getCentralPanel().gettPredmeti().
										getValueAt(selectedRow, 0);
								dialog1.setLocationRelativeTo(appView.getFrame());
								appView.getChangePredmetDialog().fillInPredmet(appData.getPredmetBySifra(selectedPredmetSifra));
								String textF = textFields.get(3).getText();
								String text = textF.trim();
								if(text.equals("")) {
									appView.getChangePredmetDialog().getBtnMinus().setEnabled(false);
									appView.getChangePredmetDialog().getBtnPlus().setEnabled(true);
								} else {
									appView.getChangePredmetDialog().getBtnMinus().setEnabled(true);
									appView.getChangePredmetDialog().getBtnPlus().setEnabled(false);
								}
								appView.getAddStudentDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
								appView.getChooseProfessorDialog().clearTable();;
								appView.getChooseProfessorDialog().initTable();
								dialog1.setVisible(true);
							} else {
								dialog2.setLocationRelativeTo(appView.getFrame());
								dialog2.setVisible(true);
							}
						}
					else 
					{
						System.out.println("Ne postoji takav tab");
					}
				}
			}
		);
		
		appView.addDeleteEntityListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				String studenti = AppFrame.getInstance().getResourceBundle().getString("tStudenti");
				String profesori = AppFrame.getInstance().getResourceBundle().getString("tProfesori");
				String predmeti = AppFrame.getInstance().getResourceBundle().getString("tPredmeti");
				String naziv = appView.getCentralPanel().getSelectedTabTitle();
					if(naziv.equals(studenti))
						{
							JDialog dialog = appView.getDeleteStudentDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);					
						}
					else if(naziv.equals(profesori))
						{
							JDialog dialog = appView.getDeleteProfesorDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
						}
					else if(naziv.equals(predmeti))
						{
							JDialog dialog = appView.getDeletePredmetDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
						}
					else
					{
						System.out.println("Ne postoji tab sa tim nazivom");
					}
				}
			}
		);
	
			appView.addKatedraListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					JDialog dialog = appView.getKatedreDialog();
					appView.getKatedreDialog().initTable();
					dialog.setLocationRelativeTo(appView.getFrame());
					dialog.setVisible(true);
				}
			});
			
			appView.addHelpListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					JDialog dialog = appView.getHelpDialog();
					dialog.setLocationRelativeTo(appView.getFrame());
					dialog.setVisible(true);
				}
			});
			
			appView.addAboutListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					JDialog dialog = appView.getAboutDialog();
					dialog.setLocationRelativeTo(appView.getFrame());
					dialog.setVisible(true);
				}
			});
			
			appView.addCloseListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					AppFrame.getInstance().setVisible(false);
				}
			});
			
			appView.addStudentiOPenListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					AppCentralPanel.getInstance().setSelectedIndex(0);
				}
			});
			
			appView.addProfesoriOPenListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					AppCentralPanel.getInstance().setSelectedIndex(1);
				}
			});
			
			appView.addPredmetiOPenListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					AppCentralPanel.getInstance().setSelectedIndex(2);
				}
			});
	
}
	
	private void addOdustaniBtnListener() {
		OdustaniBtnListener obl = new OdustaniBtnListener(appView);
		appView.getAddStudentDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		appView.getAddProfesorDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		appView.getAddPredmetDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		
		appView.getPolaganjeDialog().getPanel().addBtnOdustaniListener(obl);
		
		appView.getDodavanjePredmetaProfesoruDialog().addBtnOdustaniListener(obl);
		
	}
	
	private void addBtnOdustaniChangeDialog() {
		BtnOdustaniChangeDialog bocd = new BtnOdustaniChangeDialog(appView);
		appView.getChangeStudentDialog().getPanelInformacije().addBtnOdustaniListener(bocd);
		appView.getChangeProfesorDialog().getInformacije().addBtnOdustaniListener(bocd);
		appView.getChangePredmetDialog().addBtnOdustaniDialog(bocd);
		
	}

	private void addPotvrdiBtnListener() {
		PotvrdiBtnListener pbl = new PotvrdiBtnListener(appView, appData);
		appView.getAddStudentDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddProfesorDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddPredmetDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		
		appView.getPolaganjeDialog().getPanel().addBtnPotvrdiListener(pbl, pbl);
		
		appView.getDodavanjePredmetaProfesoruDialog().addBtnPotvrdiListener(pbl, pbl);
	}
	
	private void addBtnPotvrdiChangeListener() {
		BtnPotvrdiChangeDialog bpcd = new BtnPotvrdiChangeDialog(appView, appData);
		appView.getChangeStudentDialog().getPanelInformacije().addBtnPotvrdiListener(bpcd, bpcd);
		appView.getChangeProfesorDialog().getInformacije().addBtnPotvrdiListener(bpcd, bpcd);
		appView.getChangePredmetDialog().addBtnPotvrdiListener(bpcd, bpcd);
		
	}
	
	private void addBtnDaListener() {
		BtnDaListener bdl = new BtnDaListener(appView);
		appView.getDeleteStudentDialog().addBtnDaListener(bdl);
		appView.getDeleteProfesorDialog().addBtnDaListener(bdl);
		appView.getDeletePredmetDialog().addBtnDaListener(bdl);
	}
	
	private void addBtnNeListener() {
		BtnNeListener bnl = new BtnNeListener(appView);
		appView.getDeleteStudentDialog().addBtnNeListener(bnl);
		appView.getDeleteProfesorDialog().addBtnNeListener(bnl);
		appView.getDeletePredmetDialog().addBtnNeListener(bnl);
	}
	
	private void addBtnOkListener() {
		BtnOkListener bol = new BtnOkListener(appView);
		appView.getNotSelectedDialog().addBtnOkListener(bol);
	}
	
	private void addDocumentListeners() {
		DocumentListenerStudent dls = new DocumentListenerStudent();
		DocumentListenerProfesor dlp = new DocumentListenerProfesor();
		DocumentListenerPredmet dlpr = new DocumentListenerPredmet();
		appView.getAddStudentDialog().getPanelInformacije().connectDocumentListener(dls);
		appView.getAddProfesorDialog().getPanelInformacije().connectDocumentListener(dlp);
		appView.getAddPredmetDialog().getPanelInformacije().connectDocumentListener(dlpr);
	}
	
	private void addPonistavanjeOceneDialogListeners() {
		appView.getChangeStudentDialog().getPanelPolozeni().addBtnPonistiActionListener(new PonistiOcenuBtnListener());
		appView.getPonistavanjeOceneDialog().addBtnsActionListener(new DaNeBtnListenerPonistiOcenu());
	}
	
	private void addPolaganjePredmetaBtnListeners() {
		appView.getChangeStudentDialog().getPanelNepolozeni().addBtnPolaganjeActionListener(
			new PolaganjePredmetaBtnListener());
	}
	
	private void addIzmenaProfesoraPredmetiBtnListeners() {
		appView.getChangeProfesorDialog().getPredmeti().addBtnDodajListener(new DodajPredmetBtnListener());
		appView.getChangeProfesorDialog().getPredmeti().addBtnUkloniListener(new UkloniPredmetBtnListener());
		appView.getUklanjanjePredmetaProfesoruDialog().addBtnsActionListener(new DaNeBtnListenerUkloniPredmet());
	}
	
	private void addDodajBtnListener() {
		appView.getChangeStudentDialog().getPanelNepolozeni().addDodajBtnListener(
				new DodajBtnListener());
	}
	
	private void addBtnDodajListener() {
		appView.getAddStudentOnSubjectDialog().addBtnDodajListener(new BtnDodajListener());
	}
	
	private void addBtnOdustaniListener() {
		appView.getAddStudentOnSubjectDialog().addBtnOdustaniListener(new BtnOdustaniListener());
	}
	
	private void addBtnObrisiActionListener() {
		appView.getChangeStudentDialog().getPanelNepolozeni().addBtnObrisiActionListener(new AddBtnObrisiListener());
	}
	
	private void addDeleteBtnNeListener() {
		AddBtnNeListener abnl = new AddBtnNeListener(appView);
		appView.getDeleteStudentFromSubject().addDeleteBtnNeListener(abnl);
	}
	
	private void addDeleteBtnDaListener() {
		AddBtnDaListener abdl = new AddBtnDaListener(appView);
		appView.getDeleteStudentFromSubject().addDeleteBtnDaListener(abdl);
	}
	
	private void addMinusBtnListener() {
		BtnMinusListener bml = new BtnMinusListener(appView);
		appView.getChangePredmetDialog().addBtnMinusListener(bml);
	}
	
	private void addPlusBtnListener() {
		BtnPlusListener bpl = new BtnPlusListener(appView);
		appView.getChangePredmetDialog().addBtnPlusListener(bpl);
	}
	
	private void addOdustaniProfesorBtnListener() {
		BtnOdustaniProfesorListener bol = new BtnOdustaniProfesorListener(appView);
		appView.getRemoveProfessorDialog().addOdustaniProfesorBtnListener(bol);
		appView.getChooseProfessorDialog().addOdustaniProfesorBtnListener(bol);
		appView.getKatedreDialog().addOdustaniProfesorBtnListener(bol);
		appView.getSefKatedreDialog().addOdustaniProfesorBtnListener(bol);
		appView.getRemoveSefKatedreDialog().addOdustaniProfesorBtnListener(bol);
		appView.getTrenutniSefKatedre().addOdustaniProfesorBtnListener(bol);
	}
	
	private void addBtnPotvrdiProfesoraListener() {
		BtnPotvrdiProfesoraListener bpp = new BtnPotvrdiProfesoraListener(appView, appData);
		appView.getChooseProfessorDialog().addBtnPotvrdiProfesoraListener(bpp, bpp);
		appView.getRemoveProfessorDialog().addBtnPotvrdiProfesoraListener(bpp, bpp);
		appView.getRemoveSefKatedreDialog().addBtnPotvrdiProfesoraListener(bpp, bpp);
		appView.getSefKatedreDialog().addBtnPotvrdiProfesoraListener(bpp, bpp);
	}
	
	private void addBtnIzmeniKatedruListener() {
		BtnIzmeniListener biz = new BtnIzmeniListener(appView, appData);
		appView.getKatedreDialog().addBtnIzmeniKatedruListener(biz, biz);
	}
	
	private void addMinusSefBtnListener() {
		BtnMinusSefListener bml = new BtnMinusSefListener(appView);
		appView.getTrenutniSefKatedre().addMinusSefBtnListener(bml);
	}
	
	private void addPlusSefBtnListener() {
		BtnPlusSefListener bml = new BtnPlusSefListener(appView);
		appView.getTrenutniSefKatedre().addPlusSefBtnListener(bml);
	}
	
	private void addBtnZatvoriListener() {
		ZatvoriBtnListener zbl = new ZatvoriBtnListener(appView);
		appView.getAboutDialog().addBtnZatvoriListener(zbl);
		appView.getHelpDialog().addBtnZatvoriListener(zbl);
	}
	
	private void addSearchBtnActionListener() {
		appView.getToolBar().addBtnSearchActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = appView.getToolBar().getTfSearch().getText();
				String[] parts = text.split(",");
				// zato sto split brise prazne stringove sa kraja.
				Pattern p1 = Pattern.compile(Util.searchPattern1);
				Pattern p2 = Pattern.compile(Util.searchPattern2);
				if(p1.matcher(text).matches()) {
					String[] expandedParts = {parts[0], "", ""};
					AppView.getInstance().getCentralPanel().filterTables(expandedParts);
					return;
				}
				if(p2.matcher(text).matches()) {
					String[] expandedParts = {parts[0], parts[1], ""};
					AppView.getInstance().getCentralPanel().filterTables(expandedParts);
					return;
				}
				AppView.getInstance().getCentralPanel().filterTables(parts);
			}
		});
	}
	
	private void addMainFrameWindowListener() {
		appView.getFrame().connectWindowListener(new MainFrameListener());
	}
	
	private void addSaveMenuItemActionListener() {
		appView.getMenuBar().addSaveActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appData.saveData();
			}
			
		});
	}
}
