package view;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;

public class AppToolBar extends JToolBar{

	private static final long serialVersionUID = -7182434949988528780L;
	
	public AppToolBar() {
		super(SwingConstants.HORIZONTAL);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("image/image_new.png"));
		this.add(btnOpen);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("image/image_edit2.png"));
		this.add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("image/image_delete.png"));
		this.add(btnDelete);
		this.add(Box.createHorizontalGlue());
	
		JTextField tfSearch = new JTextField(15);
		tfSearch.setMaximumSize(new Dimension(100,30));
		this.add(tfSearch);
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("image/image_search.png"));
		this.add(btnSearch);

	}
}
