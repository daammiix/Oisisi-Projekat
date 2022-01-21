package view;

import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppStatusBar extends JPanel {
	private static AppStatusBar instance = null;
	private static final long serialVersionUID = 2402354191772986941L;
	
	public static AppStatusBar getInstance() {
		if(instance == null) 
			instance = new AppStatusBar();
		return instance;
	}

	JLabel label2;
	JLabel label1;
	DateFormat dateFormat;
	
	public AppStatusBar() {
		this.setLayout(new BorderLayout());
		
		label1 = new JLabel();
		label2 = new JLabel();

	    dateFormat = new SimpleDateFormat(AppFrame.getInstance().getResourceBundle().getString("dateFormat"));

	    new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            updateDate();
			}
	    }).start();
    
	    this.add(label1, BorderLayout.EAST);
	    this.add(label2, BorderLayout.WEST);
	    this.initComponents();
	}
	private void updateDate() {
		Calendar now = Calendar.getInstance();
        String formatDateTime = dateFormat.format(now.getTime()); 
        label1.setText(formatDateTime);
	}

	public void setNaziv(String selectedTabTitle) {
		label2.setText(AppFrame.getInstance().getResourceBundle().getString("naslovAplikacije") + " - " + selectedTabTitle);
	}
	
	public void initComponents() {
		setNaziv(AppCentralPanel.getInstance().getSelectedTabTitle());
		dateFormat = new SimpleDateFormat(AppFrame.getInstance().getResourceBundle().getString("dateFormat"));
	    updateDate();
	}
}
