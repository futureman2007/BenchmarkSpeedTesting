package application.speed.testing.user;
import speed.testing.benchmark.runner.*;
import application.methodImpl.BenchmarkAddStaffList;
import speed.testing.benchmark.configurators.*;
public class SpeedTestingUser {
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			Runner run = new Runner("C:/users/stepen14288/Desktop/benchmarks",new BenchmarkAddStaffList(),50,Mode.EVERY_RESULT,Accuracy.MIL);
			run.startBenchmarking();
		}
		
	}
	
	
	
	

	
	
	
}
