package utils;

import java.util.Date;

public class CommonUtils {

	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_TIME=30;
	
	
	public String generateEmailAddress() {
		Date date = new Date();
		String datePart = date.toString().replace(" ", "_").replace(":", "_");
		String generatedEmail = "miftanyc+qa"+datePart+"@gmail.com";
		return generatedEmail;
	}
}
