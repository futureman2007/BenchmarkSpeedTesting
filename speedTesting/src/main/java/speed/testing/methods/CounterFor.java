package speed.testing.methods;

public class CounterFor implements MethodToBenchmark {

	private final String methodName = "CounterFor";
	protected long countTo = 0;
	public CounterFor(long countTo) {
		this.countTo = countTo;
	}
	public CounterFor() {
		this.countTo = Short.MAX_VALUE;
	}
	@Override
	public void run() {
		long i = 0;
		for(;i <= countTo; i++) {
		}
	}
	public String getTestName() {
		return this.methodName;
	}
}
