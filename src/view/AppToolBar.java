package view;

import javax.swing.*;

import util.Util;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.util.Locale;


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
	private JButton btnSrpski;
	private JButton btnEngleski;

	private static final long serialVersionUID = -7182434949988528780L;
	
	private AppToolBar() {
		super(SwingConstants.HORIZONTAL);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setFloatable(false);
		
		btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("image/image_new.png"));
		btnOpen.setBackground(new Color(229, 231, 233));
		this.add(btnOpen);
		
		addSeparator();

		btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("image/image_edit2.png"));
		btnEdit.setBackground(new Color(229, 231, 233));
		this.add(btnEdit);
		
		addSeparator();
		
		btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("image/image_delete.png"));
		btnDelete.setBackground(new Color(229, 231, 233));
		this.add(btnDelete);
		
		addSeparator();
		
		btnSrpski = new JButton();
		btnSrpski.setText("SR");
		btnSrpski.setBackground(new Color(229, 231, 233));
		btnSrpski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr", "RS"));
				AppFrame.getInstance().changeLanguage();
			}
		});
		this.add(btnSrpski);
		
		addSeparator();
		
		btnEngleski = new JButton();
		btnEngleski.setText("EN");
		btnEngleski.setBackground(new Color(229, 231, 233));
		btnEngleski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en", "US"));
				AppFrame.getInstance().changeLanguage();
			}
		});
		this.add(btnEngleski);
		this.add(Box.createHorizontalGlue());
	
		tfSearch = new JTextField(15);
		tfSearch.setMaximumSize(new Dimension(100,30));
		this.add(tfSearch);
		
		btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("image/image_search.png"));
		btnSearch.setBackground(new Color(229, 231, 233));
		this.add(btnSearch);
		
		btnOpen.setMnemonic(KeyEvent.VK_N);
		btnEdit.setMnemonic(KeyEvent.VK_T);
		btnDelete.setMnemonic(KeyEvent.VK_D);
		tfSearch.setFocusAccelerator('p');
		btnSearch.setMnemonic(KeyEvent.VK_S);
	}
	
	public void addBtnSearchActionListener(ActionListener al) {
		btnSearch.addActionListener(al);
	}
	
	// getters and setters
	
	public void initComponents() {
		btnSrpski.setToolTipText(AppFrame.getInstance().getResourceBundle().getString("Srpski_jezik"));
		btnEngleski.setToolTipText(AppFrame.getInstance().getResourceBundle().getString("Engleski_jezik"));
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
