package ph.mramos.vcps.section09.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

//	@Pointcut("execution(public ph.mramos.vcps.section09.entity.Person ph.mra*.vcps..*Service.find*(..) throws ph.mramos.vcps.section09.service.PersonIdNotFoundException)")
	@Pointcut("execution(* ph.mramos.vcps.section09.service.*Service.*(..))")
	private void services() {}

	@Before("services()")
	public void beforeLog(JoinPoint jp) {
		System.out.println("BEFORE");
		System.out.println("Signature: " + jp.getSignature().toLongString());
		System.out.println("Params: " + Arrays.toString(jp.getArgs()));
		System.out.println();
	}

	@AfterReturning(pointcut = "services()", returning = "returnVal")
	public void afterReturningLog(JoinPoint jp, Object returnVal) {
		System.out.println("AFTER RETURNING");
		System.out.println("Signature: " + jp.getSignature().toLongString());
		System.out.println("Params: " + Arrays.toString(jp.getArgs()));
		System.out.println("Return Value: " + returnVal);
		System.out.println();
	}

	@AfterThrowing(pointcut = "services()", throwing = "throwable")
	public void afterThrowingLog(JoinPoint jp, Throwable throwable) {
		System.out.println("AFTER THROWING");
		System.out.println("Signature: " + jp.getSignature().toLongString());
		System.out.println("Params: " + Arrays.toString(jp.getArgs()));
		System.out.println("Throwable: " + throwable.getClass());
		System.out.println();
	}

	@After("services()")
	public void afterLog(JoinPoint jp) {
		System.out.println("AFTER");
		System.out.println("Signature: " + jp.getSignature().toLongString());
		System.out.println("Params: " + Arrays.toString(jp.getArgs()));
		System.out.println();
	}

	@Around("services()")
	public Object aroundLog(ProceedingJoinPoint jp) {
		System.out.println("AROUND");
		System.out.println("Signature: " + jp.getSignature().toLongString());
		System.out.println("Params: " + Arrays.toString(jp.getArgs()));
		System.out.println();
		Object returnVal = null;

		try {
			returnVal = jp.proceed();
			System.out.println("AROUND");
			System.out.println("Return Value: " + returnVal);
		} catch (Throwable throwable) {
			System.out.println("AROUND");
			System.out.println("Throwable: " + throwable.getClass());
		}

		System.out.println();
		return returnVal;
	}

}
