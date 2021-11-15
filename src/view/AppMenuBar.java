package view;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class AppMenuBar extends JMenuBar {
	
	private static final long serialVersionUID = -170471476436586052L;
	public AppMenuBar() {
		
		JMenu mFile = new JMenu(" File");
		JMenu mEdit = new JMenu(" Edit");
		JMenu mHelp = new JMenu(" Help");
		
		mFile.setIcon(new ImageIcon("image" + File.separator + "image_file.png"));
		mEdit.setIcon(new ImageIcon("image" + File.separator + "image_edit.png"));
		mHelp.setIcon(new ImageIcon("image" + File.separator + "image_help.png"));
		
		mFile.setToolTipText("Alt + F");
		mEdit.setToolTipText("Alt + E");
		mHelp.setToolTipText("Alt + H");
		
		JMenuItem miNew = new JMenuItem(" New");
		JMenuItem miSave = new JMenuItem(" Save");
		
		JMenu miOpen = new JMenu(" Open");
		JMenuItem miStudenti = new JMenuItem(" Studenti");
		JMenuItem miPredmeti = new JMenuItem(" Predmeti");
		JMenuItem miProfesori = new JMenuItem(" Profesori");
		JMenuItem miKatedre = new JMenuItem(" Katedre");
		
		miOpen.setToolTipText("Alt + O");
		
		miOpen.add(miStudenti);
		miOpen.addSeparator();
		miOpen.add(miPredmeti);
		miOpen.addSeparator();
		miOpen.add(miProfesori);
		miOpen.addSeparator();
		miOpen.add(miKatedre);
		
		JMenuItem miClose = new JMenuItem(" Close");
		
		miNew.setIcon(new ImageIcon("image" + File.separator + "image_new.png"));
		miSave.setIcon(new ImageIcon("image" + File.separator + "image_save.png"));
		miOpen.setIcon(new ImageIcon("image" + File.separator + "image_open.png"));
		miClose.setIcon(new ImageIcon("image" + File.separator + "image_x.png"));
		

		mFile.setMnemonic(KeyEvent.VK_F);
		mEdit.setMnemonic(KeyEvent.VK_E);
		mHelp.setMnemonic(KeyEvent.VK_H);
		miOpen.setMnemonic(KeyEvent.VK_O);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		miStudenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		miPredmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
		miProfesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.SHIFT_MASK));
		miKatedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.SHIFT_MASK));
		
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miSave);
		mFile.addSeparator();
		mFile.add(miOpen);
		mFile.addSeparator();
		mFile.add(miClose);
		
		JMenuItem miEdit = new JMenuItem(" Edit");
		JMenuItem miDelete = new JMenuItem(" Delete");
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
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
}
