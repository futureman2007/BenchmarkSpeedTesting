package speed.testing.benchmark.runner;

import speed.testing.benchmark.configurators.Accuracy;
import speed.testing.benchmark.configurators.Configuration;
import speed.testing.benchmark.configurators.Mode;
import speed.testing.methods.MethodToBenchmark;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import speed.testing.SpeedBenchmark;
public class Runner {

	private Configuration conf = null;
	
	private Runner() {}
	
	public Runner(Configuration conf) {
		this.conf = conf;
	}
	
	public Runner(String resultsFilePath, String resultsFileName, MethodToBenchmark mtb, int repeats, Mode mode,Accuracy acc) {
		this.conf = new Configuration(resultsFilePath,resultsFileName,mtb,repeats,mode,acc);
	}
	public Runner(String resultsFilePath, MethodToBenchmark mtb, int repeats ) {
		this.conf = new Configuration(resultsFilePath, mtb);
	}
	public Runner(String resultsFilePath, MethodToBenchmark mtb, int repeats, Mode mode, Accuracy acc ) {
		this.conf = new Configuration(resultsFilePath, mtb, repeats, mode, acc);
	}
	
	public void startBenchmarking() {
		String os = System.getProperty("os.name");
		if(os.contains("mac") || os.contains("MAC") || os.contains("Mac") || os.contains("mAc") || os.contains("maC") || os.contains("MaC")  || os.contains("mAC") || os.contains("MAc")) {
			System.err.println("I hate Mac. ¯\\_(ツ)_/¯");
			System.exit(1);
		}
		
		if(conf == null) {
			System.err.println("No Configurations Set. ¯\\_(ツ)_/¯");
			System.exit(1);
		}
		if(conf.resultsFilePath == null) {
			System.err.println("No Destpath Set. ¯\\_(ツ)_/¯");
			System.exit(1);
		}
		
//		catch (IOException e) {
//			System.err.println(conf.resultsFilePath + " An IOException Accured. ¯\\_(ツ)_/¯");
//			e.printStackTrace();
//			System.exit(1);
//		}
		if(conf.mtb == null) {
			System.err.println("No Method to Benchmark Set. ¯\\_(ツ)_/¯");
			System.exit(1);
		}
		
		System.out.println("===== STARTING BENCHMARKING =====");
		System.out.println("Configurations: " + "\n" +conf.toString());
		SpeedBenchmark.speedTest(this.conf);
		System.out.println("===== BENCHMARKING COMPLETED! =====");
		System.out.println("Results in: " + conf.resultsFilePath + "/" + conf.resultsFileName + ".txt");
	}
	public Configuration getConfiguration() {
		return this.conf;
	}
	
	
}
