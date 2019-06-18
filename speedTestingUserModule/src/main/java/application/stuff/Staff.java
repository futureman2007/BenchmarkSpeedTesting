package apllication.stuff;

import java.util.LinkedList;

public class Staff {

	
	private LinkedList<Angestellter> stuff;
	
	public Staff(LinkedList<Angestellter> stuff) {
		this.stuff = stuff;
	}
	public Staff() {
		this.stuff = new LinkedList<Angestellter>();
	}
	
	public boolean addAngestellten(String vorname, String nachname, String geburtsdatum, int gehalt) {
		return this.stuff.add(new Angestellter(vorname,nachname,geburtsdatum,gehalt));
	}
	public boolean addAngestellten(String vorname,String zweitname, String nachname, String geburtsdatum, int gehalt) {
		return this.stuff.add(new Angestellter(vorname,zweitname,nachname,geburtsdatum,gehalt));
	}
	
	public boolean addAngestellten(Angestellter angestellter) {
		return this.stuff.add(angestellter);
	}
	
	public Angestellter removeAngestellten(Angestellter angestellter) {
		return stuff.remove(findAngestelltenInList(angestellter.getID()));
	}
	
	public Angestellter getAngestelltenWith(long id) {
		int index = findAngestelltenInList(id);
		return this.stuff.get(index);
	}
	
	public boolean addStafflist(LinkedList<Angestellter> list) {
		return this.stuff.addAll(list);
	}
	
	private int findAngestelltenInList(long id) {
		for(int i = 0; i < this.stuff.size(); i++) {
			if(this.stuff.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}
	
}
