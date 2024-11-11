package com.moonhotels.MoonhotelsHUB.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping; 


@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

   
    @Pointcut("execution(* com.moonhotels.MoonhotelsHUB.adapter.in.web.controller.*.*(..))")
    public void controllerMethods() {}

    
    @Pointcut("execution(* com.moonhotels.MoonhotelsHUB.application.service.*.*(..))")
    public void serviceMethods() {}

    @Before("controllerMethods()")
    public void logBeforeController(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String controllerMethod = signature.getDeclaringType().getSimpleName() + "." + signature.getMethod().getName();
        String path = getRequestMappingPath(signature);

        MDC.put("layer", "controller");
        MDC.put("controllerMethod", controllerMethod);
        MDC.put("path", path);

        logger.info("Entering controller method: {}", controllerMethod);
    }

    @After("controllerMethods()")
    public void logAfterController() {
        logger.info("Exiting controller method.");
        MDC.clear();
    }

   
    @Before("serviceMethods()")
    public void logBeforeService(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String serviceMethod = signature.getDeclaringType().getSimpleName() + "." + signature.getMethod().getName();
        
        MDC.put("layer", "service");
        MDC.put("serviceMethod", serviceMethod);

        logger.info("Entering service method: {}", serviceMethod);
    }

    @After("serviceMethods()")
    public void logAfterService() {
        logger.info("Exiting service method.");
        MDC.clear();
    }

    
    @AfterReturning(value = "serviceMethods()", returning = "result")
    public void logReturnService(Object result) {
        logger.info("Service method executed successfully, result: {}", result);
    }

   
    @AfterThrowing(value = "serviceMethods()", throwing = "exception")
    public void logExceptionService(Exception exception) {
        logger.error("Exception occurred in service layer", exception);
    }


    private String getRequestMappingPath(MethodSignature signature) {

        Annotation[] annotations = signature.getMethod().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof RequestMapping) {
                RequestMapping requestMapping = (RequestMapping) annotation;
                String[] paths = requestMapping.value();
                if (paths.length > 0) {
                    return paths[0]; 
                }
            } else if (annotation instanceof GetMapping) {
                GetMapping getMapping = (GetMapping) annotation;
                String[] paths = getMapping.value();
                if (paths.length > 0) {
                    return paths[0];
                }
            } else if (annotation instanceof PostMapping) {
                PostMapping postMapping = (PostMapping) annotation;
                String[] paths = postMapping.value();
                if (paths.length > 0) {
                    return paths[0];
                }
            }

        }
        return "No path found";
    }

}
