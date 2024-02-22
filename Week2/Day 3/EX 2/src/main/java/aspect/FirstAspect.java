package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAspect {

    @Around("@annotation(Timelt)")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aspect called");
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Method " + joinPoint.getSignature().toShortString() + " executed in " + executionTime + " nanoseconds");
        System.out.println("Execution started at "+startTime);
        System.out.println("Execution Ended at "+endTime);
        return null;
    }

}
