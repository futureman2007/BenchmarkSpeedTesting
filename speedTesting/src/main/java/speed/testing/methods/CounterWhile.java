package speed.testing.methods;

public class CounterWhile implements MethodToBenchmark {

	private final String methodName="CounterWhile";
	protected long countTo = 0;
	
	public CounterWhile(long countTo) {
		this.countTo = countTo;
	}
	public CounterWhile() {
		this.countTo = Short.MAX_VALUE;
	}
	
	@Override
	public void run() {
			long i = 0;
			while(i<=this.countTo) {
				i++;
			}
	}
	public String getTestName() {
		return this.methodName;
	}

	
}
