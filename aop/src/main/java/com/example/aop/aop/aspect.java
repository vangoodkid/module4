package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Aspect
@Component
public class aspect {

    private static final Logger log = LoggerFactory.getLogger(aspect.class);
    private final AtomicLong visitCounter = new AtomicLong();

    // Count all visits: any public method in controllers and services
    @Before("execution(public * com.example.aop..*(..))")
    public void countVisit(JoinPoint jp) {
        long total = visitCounter.incrementAndGet();
        log.info("Visit #{} -> {}", total, jp.getSignature());
    }

    // Log state changes: after successful borrow/return
    @AfterReturning(pointcut = "execution(*LibraryService.borrowBook(..))", returning = "code")
    public void afterBorrow(JoinPoint jp, Object code) {
        Object[] args = jp.getArgs();
        log.info("Borrowed book id={} -> ticket={}", args[0], code);
    }

    @After("execution(*LibraryService.returnBook(..))")
    public void afterReturn(JoinPoint jp) {
        Object[] args = jp.getArgs();
        log.info("Returned book with ticket={}", args[0]);
    }

    // Log errors that change flow
    @AfterThrowing(pointcut = "within(*LibraryService)", throwing = "ex")
    public void afterError(JoinPoint jp, Throwable ex) {
        log.warn("Error in {}: {}", jp.getSignature(), ex.getMessage());
    }
}
