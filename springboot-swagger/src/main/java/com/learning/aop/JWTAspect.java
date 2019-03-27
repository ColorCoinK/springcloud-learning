package com.learning.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(value = 1)
public class JWTAspect {

	private Logger logger = Logger.getLogger(JWTAspect.class);

	@Pointcut("execution(public * com.learning.controller..*.*(..))")
	public void JWTAsp() {
	}

	@Before("JWTAsp()")
	public void doBefore(JoinPoint joinPoint) {
		logger.error("余生 · 请多指教");
	}

}
