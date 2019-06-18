package speed.testing;

public class Duration {
	private long durationNano;
	private double durationMic;
	private double durationMil;
	private double durationSec;
	private long id = 0;
	private static long durationCount = 0;
	
	protected Duration() {
		this.durationMic = 0;
		this.durationMil = 0;
		this.durationNano= 0;
		this.durationSec = 0;
		this.id = -1; // negative and therfore invalid as Duration
	}
	
	public Duration(long startTime, long endTime) {
		this.durationNano = (endTime - startTime);
		this.durationMic = durationNano /(1000.0);
		this.durationMil= durationNano/1000000.0;
		this.durationSec = durationNano/(1000.0*1000000.0) ;
		durationCount++;
		this.id = durationCount;
	}
	
	public long getDurationNano() {
		return durationNano;
	}

	public double getDurationMic() {
		return durationMic;
	}

	public double getDurationMil() {
		return durationMil;
	}

	public double getDurationSec() {
		return durationSec;
	}
	public long getId() {
		return this.id;
	}
	

	public String toString() {
		String result = "Duration: "
				+ "\n ID: " + this.id
				+ "\n   nanoseconds: " + durationNano  
				+ "\n   microoseconds: " + durationMic
				+ "\n   milliseconds: "+ durationMil 
				+ "\n   seconds: " + durationSec;
		return result;
	}
	

}
