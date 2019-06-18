package speed.testing.benchmark.runner;

import java.util.Properties;

import speed.testing.benchmark.configurators.Accuracy;
import speed.testing.benchmark.configurators.Configuration;
import speed.testing.benchmark.configurators.Mode;
import speed.testing.methods.*;
import speed.testing.methods.MethodToBenchmark;

final class Run {
	private static void main(String[] args) {
	
		int repeats = 5;
		long maxInt = (Short.MAX_VALUE);
		long countTo = maxInt * 1;
		
		MethodToBenchmark method = new CounterWhile(countTo);
		Configuration conf = new Configuration(
				System.getProperty("user.home") + "/Desktop",
				method.getTestName() + "_benchmarking",
				method,
				repeats,
				Mode.ONLY_AVERAGE_RESULTS,
				Accuracy.NAN
			); 		
		Runner r1 = new Runner(conf);
		r1.startBenchmarking();
				
	}
}
