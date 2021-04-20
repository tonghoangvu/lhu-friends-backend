package com.tonghoangvu.lhufriendsbackend.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.tonghoangvu.lhufriendsbackend.controller.*.*(..))")
    public void logBeforeController(@NotNull JoinPoint joinPoint) {
        log.info("API: {}.{}", joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());
    }
}
