package sample.aop.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author neo.pan
 * @since 17/4/19
 */
@Aspect
@Component
public class AnchorMonitor {

    @Around(value = "@annotation(anchor)", argNames="anchor")
    // @Around(value = "@annotation(anchor)", argNames="joinPoint, anchor") // OK too.
    public Object replaceFirstArg(ProceedingJoinPoint joinPoint, Anchor anchor) throws Throwable {
        System.out.println("[AOP] joinPoint: " + joinPoint);
        System.out.println("[AOP] anchor.id: " + anchor.id());
        Object[] args = joinPoint.getArgs();
        if (args[0] == null) args[0] = anchor.id();
        return joinPoint.proceed(args);
    }

}
