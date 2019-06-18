package application.methodImpl;

import java.util.LinkedList;

import apllication.stuff.Angestellter;
import apllication.stuff.Staff;
import speed.testing.methods.MethodToBenchmark;

public class BenchmarkAddStaffList implements MethodToBenchmark  {

	LinkedList<Angestellter> list = prepareListOfAngestellten();
	
	@Override
	public void run() {
		Staff staff = new Staff();
		staff.addStafflist(list);
	}

	@Override
	public String getTestName() {
		return "AddStaffListbenchmark";
	}
	public LinkedList<Angestellter> prepareListOfAngestellten() {
		list = null;
		LinkedList<Angestellter> lol = new LinkedList<Angestellter>();
		lol.add(new Angestellter("Stephan", "Penner" , "03.05.1994" , 7750));
		
		for(int i = 2; i < 9878; i++) {
			lol.add(new Angestellter("Mitarbeiter " + i, "" + i, "01.01.2000" , 750));
		}
		return lol;
	}

}
