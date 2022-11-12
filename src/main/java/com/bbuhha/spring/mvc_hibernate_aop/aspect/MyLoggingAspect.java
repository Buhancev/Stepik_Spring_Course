package com.bbuhha.spring.mvc_hibernate_aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    //с любой доступностью, из пакета DAO, любой класс любой метод, с любым кол-ом параметров
    @Around("execution(* com.bbuhha.spring.mvc_hibernate_aop.DAO.*.* (..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint)
        throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();

        System.out.println("Begin of " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed(); ///запускаем метод и получаем Result

        System.out.println("End of " + methodName);

        return targetMethodResult; //возвращаем result
    }
}
