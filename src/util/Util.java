package util;

import java.awt.Color;
import java.text.SimpleDateFormat;

public class Util {
	
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.");
	
	// Colors
	public static final Color buttonEnteredColor = new Color(174, 214, 241);
	
	// Regex
	public static final String stringPattern = ".+";
	public static final String adressPattern = "[a-zA-z\\s]+,\\s*\\d*/?[a-zA-Z]*,\\s*[a-zA-Z\\s]+,\\s*[a-zA-Z]+\\s*";
	public static final String numberPattern = "\\d+";
	public static final String datePattern = "\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\.";
	public static final String numTelPattern = "\\+?\\d{9,25}";
	public static final String emailPattern = ".*@.*";
	public static final String brLicKartePattern = "\\d{13}";
}
