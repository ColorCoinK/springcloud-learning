package com.learning.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.learning.util.IPUtils;

@Aspect
@Configuration
@Order(value = 2)
public class WebLogAspect {

	private Logger logger = Logger.getLogger(getClass());

	@Pointcut("execution(public * com.learning.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {

		// 接收到请求,记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				                                                                 .getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("URL : http://" + IPUtils.getIpAddress(request) + ":" + request.getServerPort()
				            + request.getRequestURI());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + IPUtils.getIpAddress(request));
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				            + joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturing(Object ret) throws Throwable {
		// 处理完成，返回内容
		logger.info("RESPONSE : " + ret);
	}
}
