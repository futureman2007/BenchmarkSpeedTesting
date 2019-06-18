package speed.testing;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import speed.testing.benchmark.configurators.*;
import speed.testing.methods.MethodToBenchmark;


public final class SpeedBenchmark {
	
	private SpeedBenchmark() {}
	
	public static void speedTest(Configuration conf) {
		Duration[] results = benchmark(conf.repeats, conf.mtb);
		switch(conf.mode) {
			case ONLY_TESTS_RESULTS: 
				try {
					WriteToFile.writeTestResultsToFile(conf.resultsFilePath,conf.resultsFileName, results, Mode.ONLY_TESTS_RESULTS, conf.acc);
				} catch(AccessDeniedException ade) {
					System.err.println("Access to " + conf.resultsFilePath + " was denied from this machine. ¯\\_(ツ)_/¯");
					ade.printStackTrace();
					System.exit(1);
					
				}catch (IOException e) {
					System.err.println("An IOException accured ¯\\_(ツ)_/¯");
					System.err.println("Configuration: " + conf.toString());
					e.printStackTrace();
					System.exit(1);
				}
				break;
				
			case ONLY_AVERAGE_RESULTS:
				try {
					WriteToFile.writeAverageResultsToFile(conf.resultsFilePath, conf.resultsFileName, results, conf.acc);
				} catch(AccessDeniedException ade) {
					System.err.println("Access to " + conf.resultsFilePath + " was denied from this machine. ¯\\_(ツ)_/¯");
					ade.printStackTrace();
					System.exit(1);
				}			
				catch (IOException e) {
					System.err.println("An IOException accured ¯\\_(ツ)_/¯");
					System.err.println("Configuration: " + conf.toString());
					e.printStackTrace();
					System.exit(1);
				}
				break;
				
			case EVERY_RESULT:	
			try {
				WriteToFile.writeTestResultsToFile(conf.resultsFilePath,conf.resultsFileName, results, Mode.EVERY_RESULT, conf.acc);
			} 
			catch(AccessDeniedException ade) {
				System.err.println("Access to " + conf.resultsFilePath + " was denied from this machine. ¯\\_(ツ)_/¯");
				ade.printStackTrace();
				System.exit(1);
			}
			catch (IOException e) {
				System.err.println("An IOException accured ¯\\_(ツ)_/¯");
				System.err.println("Configuration: " + conf.toString());
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	private static Duration[] benchmark(int experimentsIterations, MethodToBenchmark method) {
		Duration[] durations = new Duration[experimentsIterations+1];
		long startTime = 0;
		long endTime = 0;
		long average = 0; //average nano seconds time
		for(int q = 1; q <= experimentsIterations; q++) {
			startTime = System.nanoTime();
			method.run();
			endTime = System.nanoTime();
			Duration duration = new Duration(startTime,endTime);
			durations[q-1] = duration;
			average+= duration.getDurationNano();
		}
		durations[(durations.length)-1] = new AverageDuration(( average / (double)experimentsIterations) );
		return durations;
	}

	
	protected static double calculateAverage(Duration[] durations, Accuracy a ) throws ClassCastException{
		AverageDuration tmp;
		//At least, check if the conversion is valid!
		//note: durations arrays last element is an AverageDuration, to speed up this code.(Why iterate trough all and calculat average, when i can do it on the fly?)
		//but: is a badly little hack of course
		if(durations[(durations.length) -1] instanceof AverageDuration) {
			tmp = (AverageDuration)durations[(durations.length) -1];
		}else {
			throw new ClassCastException("Cast to AverageDuration was not possible! Wrong Objecttype! ");
		}
		double average = tmp.getAverageDurationNano();
			switch(a) {
				case MIC: return (average/(1000) );
				case MIL: return (average/(1000*1000) );
				case SEC: return (average/(1000*1000*1000) );
				default: return average; // also, case NAN
			}

	}
}// end class
