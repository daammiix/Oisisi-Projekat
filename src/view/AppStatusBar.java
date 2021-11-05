package view;

import javax.swing.*;
import java.awt.*;

public class AppStatusBar extends JPanel {

	private static final long serialVersionUID = 2402354191772986941L;

	public AppStatusBar() {
		//zameni
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEtchedBorder());
		this.add(new JLabel("Content"), BorderLayout.WEST);
		this.add(new JLabel("Content"), BorderLayout.EAST);
	}
}
