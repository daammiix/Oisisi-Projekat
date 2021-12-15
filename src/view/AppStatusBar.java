package view;

import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AppStatusBar extends JPanel {

	private static final long serialVersionUID = 2402354191772986941L;

	JLabel label2 = new JLabel();
	
	public AppStatusBar() {
		this.setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel();
		label2 = new JLabel();
		label2.setText("Studentska služba"); 

	    DateFormat dateFormat = new SimpleDateFormat("HH:mm  dd/MM/yyyy");

	    new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            Calendar now = Calendar.getInstance();
	            String formatDateTime = dateFormat.format(now.getTime()); 
	            label1.setText(formatDateTime); 
	            //label2.setText("Studentska služba - " + state);
				
			}
	    }).start();
    
	    this.add(label1, BorderLayout.EAST);
	    this.add(label2, BorderLayout.WEST);
  
	}
	
	/*public void setName(int state)
	{
		label2.setText("Studentska služba - " + state);
	}*/


}
