package seeme.project.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //하면 빈 등록이 되지만 특별대상으로 SpringConfig에 개별 등록하면 좋음
@Slf4j
public class TimeTraceAop {

    @Around("execution(* seeme.project..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("START TIME : "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            log.info("END TIME : "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }


}
