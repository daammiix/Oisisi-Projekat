package view;

import javax.swing.*;

public class AppMenuBar extends JMenuBar {
	
	private static final long serialVersionUID = -170471476436586052L;

	public AppMenuBar() {
		
		JMenu mFile = new JMenu(" File");
		JMenu mEdit = new JMenu(" Edit");
		JMenu mHelp = new JMenu(" Help");
		
		this.add(mFile);
		this.add(mEdit);
		this.add(mHelp);
		
	}
}
