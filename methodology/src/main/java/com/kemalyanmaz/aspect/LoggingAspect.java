package com.kemalyanmaz.aspect;

import java.util.Arrays;
import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("@annotation(Loggable)")
	public void executeLogging() {}
	
	
	@Around(value = "executeLogging()")
	public Object logMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object returnValue = proceedingJoinPoint.proceed();
		long totalTime = System.currentTimeMillis()-startTime;
		StringBuilder message = new StringBuilder("Method: ");
		message.append(proceedingJoinPoint.getSignature().getName());
		message.append(" totalTime: ").append(totalTime).append("ms");
		Object[] args = proceedingJoinPoint.getArgs();
		if(args!=null && args.length>0) {
			message.append(" args=[ | ");
			Arrays.asList(args).forEach(arg->{
				message.append(arg).append(" | ");
			});
			message.append("]");
		}
		if(returnValue instanceof Collection) {
			message.append(", returningValue: ").append(((Collection)returnValue).size()).append(" instance(s)");
		}else {
			message.append(", returningValue: ").append(returnValue.toString());
		}
		LOGGER.info(message.toString());
		return returnValue;
	}
}
