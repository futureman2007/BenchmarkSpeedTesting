package speed.testing.methods;

public class CounterDo implements MethodToBenchmark {
	
	protected long countTo = 0;
	private final String methodName = "CounterDo";
	
	public CounterDo() {
		this.countTo = Short.MAX_VALUE;
	}
	
	public CounterDo(long countTo) {
		this.countTo = countTo;
	}
	@Override
	public void run() {
		long i = 0;
		do {
			i++;
		}while(i<=this.countTo);	
	}
	public String getTestName() {
		return this.methodName;
	}

}
