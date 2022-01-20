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
	String formatDateTime;
	DateFormat dateFormat;
	
	public AppStatusBar() {
		this.setLayout(new BorderLayout());
		
		label1 = new JLabel();
		label2 = new JLabel();

	    dateFormat = new SimpleDateFormat(AppFrame.getInstance().getResourceBundle().getString("dateFormat"));

	    new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            Calendar now = Calendar.getInstance();
	            formatDateTime = dateFormat.format(now.getTime()); 
	            label1.setText(formatDateTime); 
				
			}
	    }).start();
    
	    this.add(label1, BorderLayout.EAST);
	    this.add(label2, BorderLayout.WEST);
  
	}

	public void setNaziv(String title, String selectedTabTitle) {
		label2.setText(AppFrame.getInstance().getResourceBundle().getString("naslovAplikacije") + " - " + selectedTabTitle);
	}
	
	public void initComponents() {
		label2.setText(AppFrame.getInstance().getResourceBundle().getString("naslovAplikacije") + " - " + AppCentralPanel.getInstance().getSelectedTabTitle());
	}
}
