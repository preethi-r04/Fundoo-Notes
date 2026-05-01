package com.fundoo.notes.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.fundoo.notes.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("➡️ Entering: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.fundoo.notes.controller.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("✅ Exiting: " + joinPoint.getSignature().getName() + " | Response: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.fundoo.notes.controller.*.*(..))", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {
        log.error("❌ Error in: " + joinPoint.getSignature().getName() + " | Message: " + ex.getMessage());
    }
}