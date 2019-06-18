package speed.testing.methods;

public class Fakulty implements MethodToBenchmark{

	
	private final String methodName="Fakulty";
	private long param = 1;
	public Fakulty(long param) {
		this.param = param;
	}
	
	@Override
	public void run() {
		fakulty(this.param);
	}
	public static long fakulty(long param) {
		long result = 0;
		if(param == 1 || param == 2) {
			return param;
		}else{
			result = param * fakulty(param -1);
			return result;
		}
	}
	public String getTestName() {
		return this.methodName;
	}
}
