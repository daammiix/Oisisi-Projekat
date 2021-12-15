package view;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
	private static AppFrame instance = null;
	
	public static AppFrame getInstance() {
		if(instance == null) 
			instance = new AppFrame();
		return instance;
	}
	
	private static final long serialVersionUID = -912989417505291367L;

	private AppFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		this.setSize(width * 3/4, height * 3/4);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Studentska služba");
	}
}
