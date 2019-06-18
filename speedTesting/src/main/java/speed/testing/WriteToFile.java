package speed.testing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import speed.testing.benchmark.configurators.Accuracy;
import speed.testing.benchmark.configurators.Mode;

public class WriteToFile {

	
	protected static void writeTestResultsToFile(String path, String filename, Duration[] durations, Mode mode, Accuracy acc) throws IOException {
		writeTestResultsToFile(Paths.get(path), filename, durations, mode, acc);
	}
	
	protected static void writeTestResultsToFile(Path path, String filename,Duration[] durations , Mode mode, Accuracy acc) throws IOException {
		String userFile = path.toString() + "/" + filename + ".txt";
		
		if( !( Files.exists(Paths.get(userFile)) )){
			Files.createFile(Paths.get(userFile));
		}
		Path p = Paths.get(userFile).toRealPath();
		BufferedWriter w = Files.newBufferedWriter(p, Charset.forName("UTF-8"));
		//note: durations arrays last element is an AverageDuration, to speed up this code.(Why iterate trough all and calculat average, when i can do it on the fly?)
		//but: is a badly little hack of course
		w.write("\n === SPEED TEST RESULTS === \n");
		for(int q = 1; q <= durations.length -1; q++) {
			w.write("ITERATION " + q + " OF " + (durations.length -1) + " \n");
			w.write( durations[q-1].toString() );
			w.write("\n=========================================\n");
		}
		w.flush();
		if(mode.equals(Mode.EVERY_RESULT)) {
			appendAverageResultsToFile(p, durations, acc);
		}
		w.close();
	}
	protected static void writeAverageResultsToFile(String path, String filename,Duration[] durations ,Accuracy acc) throws IOException{
		 try {
			 writeAverageResultsToFile(Paths.get(path), filename, durations, acc);
			} catch(NoSuchFileException nsfe) {
	//			 versuche hier einfach den angegebenen pfad (mit allen subdirs) zu erstellen!
			}
		 
	}
	protected static void writeAverageResultsToFile(Path path, String filename,Duration[] durations, Accuracy a) throws IOException {
		String userFile = path.toString() + "/" + filename + "txt";
		
		if( !( Files.exists(Paths.get(userFile)) )){
			Files.createFile(Paths.get(userFile));
		}
		Path p = Paths.get(userFile).toRealPath();
		BufferedWriter w = Files.newBufferedWriter(p, Charset.forName("UTF-8"));
		w.write("\n === SPEED TEST AVERAGE RESULTS === \n");
		try {
			w.write( "Average in " + a.toString() + ": " + SpeedBenchmark.calculateAverage(durations, a ) );
		}catch(ClassCastException cce) {
			// should write the error message into the file
			w.write( "Could not write AverageResault! ¯\\_(ツ)_/¯ \n Cause: \n" +
					cce.getMessage() + "\n"
			); 
			for(StackTraceElement trace : cce.getStackTrace() ) {
				w.write(trace.toString() + "\n");
			}
			cce.getMessage();
			cce.getCause();
			cce.printStackTrace();
		}finally {
			w.flush();
			w.close();
		}
	}
	private static void appendAverageResultsToFile(Path p, Duration[] durations, Accuracy acc) throws IOException {
		if( !( Files.exists(p) )){
			throw new IOException("File needs to be present!");
		}
		BufferedWriter w = Files.newBufferedWriter(p, StandardOpenOption.APPEND);
		w.write("\n === SPEED TEST AVERAGE RESULTS === \n");
		w.write( "Average in " + acc.toString() + ": " + SpeedBenchmark.calculateAverage(durations, acc) );
		w.flush();
	}
	
}
