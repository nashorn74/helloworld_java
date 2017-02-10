package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExecuteTimeAspect {
	public Object measure(ProceedingJoinPoint joinPoint)
		throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature signature = joinPoint.getSignature();
			System.out.printf("%s %s 실행시간=%d\n", 
					joinPoint.getTarget().getClass().getSimpleName(),
					signature.getName(), (finish-start));
		}
	}
}
