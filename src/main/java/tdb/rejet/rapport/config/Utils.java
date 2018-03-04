package tdb.rejet.rapport.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utils {
	
public static Long  getDateTimeFromString(String stringDate) {
	SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
    Calendar cal = Calendar.getInstance();
    try {
		cal.setTime(dateFormat.parse(stringDate));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return cal.getTimeInMillis();
}

}
