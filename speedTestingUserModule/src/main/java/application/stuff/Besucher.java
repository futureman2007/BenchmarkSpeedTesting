package apllication.stuff;

import java.util.Calendar;
import java.util.Date;

public class Besucher extends Person {
	
	private Calendar[] besuchszeitraum = new Calendar[2]; //Calendar[0]: von; Calendar[1]: bis (jeweils einschließlich)
	private Besucher() {
		super();
	}
	public Besucher(String vorname, String nachname, String geburtsdatum, String[] besuchszeitraumVonBis) {
		super(vorname,nachname,geburtsdatum);
		Calendar von = super.getCalendar( super.dateFormatter(besuchszeitraumVonBis[0]) );
		Calendar bis = super.getCalendar( super.dateFormatter(besuchszeitraumVonBis[1]) );
		try {
			this.besuchszeitraum = validateZeitraum(von,bis);
		} catch (InvalidPeriodException e) {
			e.printStackTrace();
		}
		
	}
	public Besucher(String vorname,String zweitname, String nachname, String geburtsdatum, String[] besuchszeitraumVonBis) {
		super(vorname,zweitname,nachname,geburtsdatum);
	}
	
	public Calendar[] validateZeitraum(Calendar von, Calendar bis) throws InvalidPeriodException {
		if(von.after(bis)) {
			throw new InvalidPeriodException("Besucher can´t leave, befor he arrived!");
		}
		return new Calendar[] {von,bis};
	}
	
}
