package view;

import javax.swing.*;
import java.awt.*;

public class AppToolBar extends JToolBar{
	private static AppToolBar instance = null;
	
	public static AppToolBar getInstance() {
		if(instance == null)
			instance = new AppToolBar();
		return instance;
	}
	
	private JButton btnOpen;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextField tfSearch;
	private JButton btnSearch;

	private static final long serialVersionUID = -7182434949988528780L;
	
	private AppToolBar() {
		super(SwingConstants.HORIZONTAL);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setFloatable(false);
		
		btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("image/image_new.png"));
		this.add(btnOpen);
		
		addSeparator();

		btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("image/image_edit2.png"));
		this.add(btnEdit);
		
		addSeparator();
		
		btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("image/image_delete.png"));
		this.add(btnDelete);
		this.add(Box.createHorizontalGlue());
	
		tfSearch = new JTextField(15);
		tfSearch.setMaximumSize(new Dimension(100,30));
		this.add(tfSearch);
		
		btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("image/image_search.png"));
		this.add(btnSearch);

	}

	public JButton getBtnOpen() {
		return btnOpen;
	}

	public void setBtnOpen(JButton btnOpen) {
		this.btnOpen = btnOpen;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JTextField getTfSearch() {
		return tfSearch;
	}

	public void setTfSearch(JTextField tfSearch) {
		this.tfSearch = tfSearch;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
