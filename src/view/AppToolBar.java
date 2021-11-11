package view;

import javax.swing.*;
import java.awt.Dimension;

public class AppToolBar extends JToolBar{

	private static final long serialVersionUID = -7182434949988528780L;

	public AppToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("image/image_new.png"));
		add(btnOpen);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("image/image_edit2.png"));
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("image/image_delete.png"));
		add(btnDelete);
		
		addSeparator(new Dimension(1000,10));
		
		JTextField tfSearch = new JTextField();
		add(tfSearch);
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("image/image_search.png"));
		add(btnSearch);
		
	}
}
