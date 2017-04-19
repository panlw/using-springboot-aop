# Spring Boot AOP Sample

```java
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
```
