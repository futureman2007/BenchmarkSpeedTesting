package apllication.stuff;

public class Angestellter extends Person {

	protected int gehalt;
	private long angestelltenID;
	private static long id;
	
	private Angestellter() {
		super();
	}
	public Angestellter(String vorname, String nachname, String geburtsdatum, int gehalt) {
		super(vorname,nachname,geburtsdatum);
		this.gehalt = gehalt;
		id++;
		this.angestelltenID = id;
	}
	public Angestellter(String vorname,String zweitname, String nachname, String geburtsdatum, int gehalt) {
		super(vorname,zweitname,nachname,geburtsdatum);
		this.gehalt = gehalt;
		id++;
		this.angestelltenID = id;
	}
	public long getID() {
		return this.angestelltenID;
	}
}
