package view;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;

public class AppMenuBar extends JMenuBar {
	private static AppMenuBar instance = null;
	private static final long serialVersionUID = -170471476436586052L;
	
	public static AppMenuBar getInstance() {
		if(instance == null) 
			instance = new AppMenuBar();
		return instance;
	}
	
	private JMenu mFile;
	private JMenu mEdit;
	private JMenu mHelp;
	private JMenu mOpen;
	private JMenuItem miNew;
	private JMenuItem miSave;
	private JMenuItem miClose;
	private JMenuItem miEdit;
	private JMenuItem miDelete;
	private JMenuItem miHelp;
	private JMenuItem miAbout;
	private JMenuItem miStudenti;
	private JMenuItem miPredmeti;
	private JMenuItem miProfesori;
	private JMenuItem miKatedre;
	
	private AppMenuBar() {
		
		mFile = new JMenu(" File");
		mEdit = new JMenu(" Edit");
		mHelp = new JMenu(" Help");
		
		mFile.setIcon(new ImageIcon("image" + File.separator + "image_file.png"));
		mEdit.setIcon(new ImageIcon("image" + File.separator + "image_edit.png"));
		mHelp.setIcon(new ImageIcon("image" + File.separator + "image_help.png"));
		
		mFile.setToolTipText("Alt + F");
		mEdit.setToolTipText("Alt + E");
		mHelp.setToolTipText("Alt + H");
		
		miNew = new JMenuItem(" New");
		miSave = new JMenuItem(" Save");
		
		mOpen = new JMenu(" Open");
		miStudenti = new JMenuItem(" Studenti");
		miPredmeti = new JMenuItem(" Predmeti");
		miProfesori = new JMenuItem(" Profesori");
		miKatedre = new JMenuItem(" Katedre");
		
		mOpen.setToolTipText("Alt + O");
		
		mOpen.add(miStudenti);
		mOpen.addSeparator();
		mOpen.add(miPredmeti);
		mOpen.addSeparator();
		mOpen.add(miProfesori);
		mOpen.addSeparator();
		mOpen.add(miKatedre);
		
		JMenuItem miClose = new JMenuItem(" Close");
		
		miNew.setIcon(new ImageIcon("image" + File.separator + "image_new.png"));
		miSave.setIcon(new ImageIcon("image" + File.separator + "image_save.png"));
		mOpen.setIcon(new ImageIcon("image" + File.separator + "image_open.png"));
		miClose.setIcon(new ImageIcon("image" + File.separator + "image_x.png"));
		
		miStudenti.setIcon(new ImageIcon("image" + File.separator + "image_student.png"));
		miPredmeti.setIcon(new ImageIcon("image" + File.separator + "image_predmet.png"));
		miProfesori.setIcon(new ImageIcon("image" + File.separator + "image_profesor.png"));
		miKatedre.setIcon(new ImageIcon("image" + File.separator + "image_katedra.png"));

		mFile.setMnemonic(KeyEvent.VK_F);
		mEdit.setMnemonic(KeyEvent.VK_E);
		mHelp.setMnemonic(KeyEvent.VK_H);

		mOpen.setMnemonic(KeyEvent.VK_O);

		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miNew.setMnemonic(KeyEvent.VK_N);
		miSave.setMnemonic(KeyEvent.VK_S);
		miClose.setMnemonic(KeyEvent.VK_C);
		
		miStudenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		miPredmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
		miProfesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.SHIFT_MASK));
		miKatedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.SHIFT_MASK));
		miStudenti.setMnemonic(KeyEvent.VK_S);
		miPredmeti.setMnemonic(KeyEvent.VK_P);
		miProfesori.setMnemonic(KeyEvent.VK_R);
		miKatedre.setMnemonic(KeyEvent.VK_K);
		
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miSave);
		mFile.addSeparator();
		mFile.add(mOpen);
		mFile.addSeparator();
		mFile.add(miClose);
		
		JMenuItem miEdit = new JMenuItem(" Edit");
		JMenuItem miDelete = new JMenuItem(" Delete");
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miDelete.setMnemonic(KeyEvent.VK_D);
		
		miEdit.setIcon(new ImageIcon("image" + File.separator + "image_edit.png"));
		miDelete.setIcon(new ImageIcon("image" + File.separator + "image_delete.png"));
		
		mEdit.add(miEdit);
		mEdit.addSeparator();
		mEdit.add(miDelete);
		mEdit.addSeparator();
		
		JMenuItem miHelp = new JMenuItem(" Help");
		JMenuItem miAbout = new JMenuItem(" About");
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miAbout.setMnemonic(KeyEvent.VK_A);
		
		miHelp.setIcon(new ImageIcon("image" + File.separator + "image_help.png"));
		miAbout.setIcon(new ImageIcon("image" + File.separator + "image_about.png"));
		
		mHelp.add(miHelp);
		mHelp.addSeparator();
		mHelp.add(miAbout);
		mHelp.addSeparator();	
		
		this.add(mFile);
		this.add(mEdit);
		this.add(mHelp);
		
	}

	public JMenu getmFile() {
		return mFile;
	}

	public void setmFile(JMenu mFile) {
		this.mFile = mFile;
	}

	public JMenu getmEdit() {
		return mEdit;
	}

	public void setmEdit(JMenu mEdit) {
		this.mEdit = mEdit;
	}

	public JMenu getmHelp() {
		return mHelp;
	}

	public void setmHelp(JMenu mHelp) {
		this.mHelp = mHelp;
	}

	public JMenu getmOpen() {
		return mOpen;
	}

	public void setmOpen(JMenu mOpen) {
		this.mOpen = mOpen;
	}

	public JMenuItem getMiNew() {
		return miNew;
	}

	public void setMiNew(JMenuItem miNew) {
		this.miNew = miNew;
	}

	public JMenuItem getMiSave() {
		return miSave;
	}

	public void setMiSave(JMenuItem miSave) {
		this.miSave = miSave;
	}

	public JMenuItem getMiClose() {
		return miClose;
	}

	public void setMiClose(JMenuItem miClose) {
		this.miClose = miClose;
	}

	public JMenuItem getMiEdit() {
		return miEdit;
	}

	public void setMiEdit(JMenuItem miEdit) {
		this.miEdit = miEdit;
	}

	public JMenuItem getMiDelete() {
		return miDelete;
	}

	public void setMiDelete(JMenuItem miDelete) {
		this.miDelete = miDelete;
	}

	public JMenuItem getMiHelp() {
		return miHelp;
	}

	public void setMiHelp(JMenuItem miHelp) {
		this.miHelp = miHelp;
	}

	public JMenuItem getMiAbout() {
		return miAbout;
	}

	public void setMiAbout(JMenuItem miAbout) {
		this.miAbout = miAbout;
	}

	public JMenuItem getMiStudenti() {
		return miStudenti;
	}

	public void setMiStudenti(JMenuItem miStudenti) {
		this.miStudenti = miStudenti;
	}

	public JMenuItem getMiPredmeti() {
		return miPredmeti;
	}

	public void setMiPredmeti(JMenuItem miPredmeti) {
		this.miPredmeti = miPredmeti;
	}

	public JMenuItem getMiProfesori() {
		return miProfesori;
	}

	public void setMiProfesori(JMenuItem miProfesori) {
		this.miProfesori = miProfesori;
	}

	public JMenuItem getMiKatedre() {
		return miKatedre;
	}

	public void setMiKatedre(JMenuItem miKatedre) {
		this.miKatedre = miKatedre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
