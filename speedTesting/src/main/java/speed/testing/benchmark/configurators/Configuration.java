package speed.testing.benchmark.configurators;

import speed.testing.methods.MethodToBenchmark;

public class Configuration {

	public String resultsFilePath;
	public String resultsFileName;
	public Mode mode;
	public MethodToBenchmark mtb;
	public int repeats;
	public Accuracy acc;
	
	public Configuration(String resultsFilePath, String resultsFileName, MethodToBenchmark mtb, int repeats, Mode mode,Accuracy acc ) {
		this.resultsFilePath = resultsFilePath;
		this.resultsFileName = resultsFileName;
		this.mode = mode;
		this.mtb = mtb;
		this.repeats = repeats;
		this.acc = acc;
	}
	public Configuration(String resultsFilePath, MethodToBenchmark mtb, int repeats, Mode mode, Accuracy acc ) {
		this.resultsFilePath = resultsFilePath;
		this.resultsFileName = mtb.getTestName()+ "_benchmarkTest";
		this.mode = mode;
		this.mtb = mtb;
		this.repeats = repeats;
		this.acc = acc;
	}
	
	public Configuration(String resultsFilePath, MethodToBenchmark mtb, int repeats, Mode mode ) {
		this.resultsFilePath = resultsFilePath;
		this.resultsFileName = mtb.getTestName()+ "_benchmarkTest";
		this.mode = mode;
		this.mtb = mtb;
		this.repeats = repeats;
		this.acc = Accuracy.NAN;
	}
	
	public Configuration(String resultsFilePath, MethodToBenchmark mtb, int repeats, Accuracy acc ) {
		this.resultsFilePath = resultsFilePath;
		this.resultsFileName = mtb.getTestName()+ "_benchmarkTest";
		this.mode = Mode.EVERY_RESULT;
		this.mtb = mtb;
		this.repeats = repeats;
		this.acc = acc;
	}
	public Configuration(String resultsFilePath, MethodToBenchmark mtb, int repeats ) {
		this.resultsFilePath = resultsFilePath;
		this.resultsFileName = mtb.getTestName()+ "_benchmarkTest";
		this.mode = Mode.EVERY_RESULT;
		this.mtb = mtb;
		this.repeats = repeats;
		this.acc = Accuracy.NAN;
	}
	public Configuration(String resultsFilePath, MethodToBenchmark mtb ) {
		this.resultsFilePath = resultsFilePath;
		this.resultsFileName = mtb.getTestName()+ "_benchmarkTest";
		this.mode = Mode.EVERY_RESULT;
		this.mtb = mtb;
		this.repeats = 10;
		this.acc = Accuracy.NAN;
	}
	public String toString() {
		return "resultsFilePath: " + this.resultsFilePath +"\n"
				+ "resultsFileName: " + this.resultsFileName +"\n"
				+ "Mode: " + this.mode +"\n"
				+ "MethodToBenchmark: " + mtb.getTestName() +"\n"
				+ "TestRepeats: " + this.repeats +"\n"
				+ "Accuracy: " + this.acc +"\n";
		
	}
	
}
