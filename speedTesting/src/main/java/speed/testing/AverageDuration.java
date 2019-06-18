package speed.testing;

final class AverageDuration extends Duration {

	private double averageDurationNano = 0;
	
	private AverageDuration() {
		super();
	}
	
	protected AverageDuration(double averageDurationNano) {
		super();
		this.averageDurationNano = averageDurationNano;
	}
	
	protected double getAverageDurationNano() {
		
		return this.averageDurationNano;
	}
	public String toString() {
		return this.averageDurationNano + "\n"
				+ this.getId();
	}
	
	
}
