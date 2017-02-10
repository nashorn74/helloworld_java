package chap07;

public class ExecuteTimeCalculator implements Calculator {

	private Calculator delegate;
	public ExecuteTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s 실행시간=%d\n", 
				delegate.getClass().getSimpleName(),
				(end-start));
		return result;
	}

}
