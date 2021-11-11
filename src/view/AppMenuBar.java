package view;

import javax.swing.*;

public class AppMenuBar extends JMenuBar {
	
	private static final long serialVersionUID = -170471476436586052L;

	public AppMenuBar() {
		
		JMenu mFile = new JMenu(" File");
		JMenu mEdit = new JMenu(" Edit");
		JMenu mHelp = new JMenu(" Help");
		
		mFile.setIcon(new ImageIcon("image/image_file.png"));
		mEdit.setIcon(new ImageIcon("image/image_edit.png"));
		mHelp.setIcon(new ImageIcon("image/image_help.png"));
		
		mFile.setToolTipText("Ctrl + Alt + F");
		mEdit.setToolTipText("Ctrl + Alt + E");
		mHelp.setToolTipText("Ctrl + Alt + H");
		
		JMenuItem miNew = new JMenuItem(" New   Ctrl + N");
		JMenuItem miSave = new JMenuItem(" Save   Ctrl + S");
		
		JMenu miOpen = new JMenu(" Open   Ctrl + Alt + O");
		JMenuItem miStudenti = new JMenuItem(" Studenti");
		JMenuItem miPredmeti = new JMenuItem(" Predmeti");
		JMenuItem miProfesori = new JMenuItem(" Profesori");
		JMenuItem miKatedre = new JMenuItem(" Katedre");
		
		miOpen.add(miStudenti);
		miOpen.addSeparator();
		miOpen.add(miPredmeti);
		miOpen.addSeparator();
		miOpen.add(miProfesori);
		miOpen.addSeparator();
		miOpen.add(miKatedre);
		
		JMenuItem miClose = new JMenuItem(" Close   Ctrl + C");
		
		miNew.setIcon(new ImageIcon("image/image_new.png"));
		miSave.setIcon(new ImageIcon("image/image_save.png"));
		miOpen.setIcon(new ImageIcon("image/image_open.png"));
		miClose.setIcon(new ImageIcon("image/image_x.png"));
		
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miSave);
		mFile.addSeparator();
		mFile.add(miOpen);
		mFile.addSeparator();
		mFile.add(miClose);
		
		JMenuItem miEdit = new JMenuItem(" Edit   Ctrl + E");
		JMenuItem miDelete = new JMenuItem(" Delete   Ctrl + D");
		
		miEdit.setIcon(new ImageIcon("image/image_edit.png"));
		miDelete.setIcon(new ImageIcon("image/image_delete.png"));
		
		mEdit.add(miEdit);
		mEdit.addSeparator();
		mEdit.add(miDelete);
		mEdit.addSeparator();
		
		JMenuItem miHelp = new JMenuItem(" Help   Ctrl + H");
		JMenuItem miAbout = new JMenuItem(" About   Ctrl + A");
		
		miHelp.setIcon(new ImageIcon("image/image_help.png"));
		miAbout.setIcon(new ImageIcon("image/image_about.png"));
		
		mHelp.add(miHelp);
		mHelp.addSeparator();
		mHelp.add(miAbout);
		mHelp.addSeparator();
		
		
		this.add(mFile);
		this.add(mEdit);
		this.add(mHelp);
		
	}
}
