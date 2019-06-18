package speed.testing.methods;

public interface MethodToBenchmark {
// implement a method, which you want to benchmark. 	
	public void run();
//	getTestName will return the methods name, or an other name for the implemented benchmark.
	public String getTestName();
}
