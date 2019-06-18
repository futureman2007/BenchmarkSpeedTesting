package apllication.stuff;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Person {

	protected Date geburtsdatum;
	protected int alter;
	protected String vorname;
	protected String zweitname;	
	protected String nachname;
	
	protected Person() {}
	
	protected Person(String vorname, String nachname, String geburtsdatum) {
		this.geburtsdatum = dateFormatter(geburtsdatum);
		this.vorname = vorname;
		this.nachname = nachname;
		
		if(this.geburtsdatum != null) {
			this.alter = calculateAlter(this.geburtsdatum);
		}else {
			alter = -1;
		}
	}
	protected Person(String vorname, String zweitname, String nachname, String geburtsdatum) {
		this.geburtsdatum = dateFormatter(geburtsdatum);
		this.vorname = vorname;
		this.zweitname = zweitname;
		this.nachname = nachname;
		
		if(this.geburtsdatum != null) {
			this.alter = calculateAlter(this.geburtsdatum);
		}else {
			alter = -1;
		}
	}
	protected Date dateFormatter(String date) {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date d;
		try {
			d = df.parse(date);
		} catch (ParseException pe) {
			System.err.println("Could not get Birthdate! Mailformed Date: " + date);
			pe.printStackTrace();
			return null;
		}
		return d;
	}

	private int calculateAlter(Date geburtsdatum) {
		
		Calendar current = getCalendar(new Date());
		Calendar birthDate = getCalendar(geburtsdatum);
	
		
		int alter = (current.get(Calendar.YEAR) - (birthDate.get(Calendar.YEAR)));
		if(current.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)) {
			alter = alter -1;
		}if(current.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)) {
			if(current.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH)) {
				alter = alter -1;
			}
		}
		return alter;
		
	}
	protected static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.GERMAN);
	    cal.setTime(date);
	    return cal;
	}
	public static void main(String[] args) {
		Person stephan = new Person("Stephan", "Penner", "03.05.1994");
	}
}
