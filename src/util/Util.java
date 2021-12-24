package util;

import java.awt.Color;
import java.text.SimpleDateFormat;

public class Util {
	
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.");
	
	// Colors
	public static final Color buttonEnteredColor = new Color(174, 214, 241);
	
	// Regex
	public static final String stringPattern = "[a-zA-Z]+";
	public static final String textPattern = ".+";
	public static final String adressPattern = "[a-zA-z\\s]+,\\s*\\d*/?[a-zA-Z]*,\\s*[a-zA-Z\\s]+,\\s*[a-zA-Z]+\\s*";
	public static final String numberPattern = "\\d+";
	public static final String datePattern = "\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\.";
	public static final String numTelPattern = "\\+?\\d{9,25}";
	public static final String emailPattern = ".*@.*";
	public static final String brLicKartePattern = "\\d{9}";
	public static final String godUpisaPattern = "(19\\d{2})|(20\\d{2})";
	public static final String brIndeksaPattern = "[a-zA-Z]{2}-\\d{1,3}-\\d{1,4}";
	public static final String brGodStazaPattern = "[0-9]|([1-9][0-9])";
}
