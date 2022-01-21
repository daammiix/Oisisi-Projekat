package util;

import java.awt.Color;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Util {
	
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.");
	
	// Colors
	public static final Color buttonEnteredColor = new Color(174, 214, 241);
	public static final Color buttonBackgroundColor = new Color(23, 133, 233);
	public static final Color buttonForegroundColor = new Color(236, 240, 241);
	
	// Regex
	public static final String stringPattern = "[a-zA-ZčćžđšČĆŽĐŠ]+";
	public static final String textPattern = ".+";
	public static final String adressPattern = "[a-zA-z\\sčćžđšČĆŽĐŠ]+,\\s*\\d*/?[a-zA-ZčćžđšČĆŽĐŠ]*,\\s*[a-zA-Z\\sčćžđšČĆŽĐŠ]+,\\s*[a-zA-ZčćžđšČĆŽĐŠ]+\\s*";
	public static final String numberPattern = "\\d+";
	public static final String datePattern = "\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\.";
	public static final String numTelPattern = "(\\+?\\d{3}\\/?\\d{3,5}\\-\\d{3,5})|(\\d{9,25})";
	public static final String emailPattern = ".*@.*";
	public static final String brLicKartePattern = "\\d{9}";
	public static final String godUpisaPattern = "(19\\d{2})|(20\\d{2})";
	public static final String brIndeksaPattern = "[a-zA-Z]{2}-\\d{1,3}-\\d{1,4}";
	public static final String brGodStazaPattern = "[0-9]|([1-9][0-9])";
	public static final String searchPattern1 = ".*,,";
	public static final String searchPattern2 = ".*,.*,";
	
	public static JTable createTable(DefaultTableModel model) {
		JTable ret = new JTable(model);
		ret.setRowSelectionAllowed(true);
		ret.setDefaultEditor(Object.class, null);
		ret.setRowHeight(25);
		ret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return ret;
	}
	
	public static void modifyButton(JButton btn) {
		btn.setForeground(buttonForegroundColor);
		btn.setBackground(buttonBackgroundColor);
		btn.setMargin(new Insets(1, 4, 1, 4));
	}
}
