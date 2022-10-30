package aop.acpects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3) //каким по счету будет выполняться аспект
public class ExceptionHandlingAspect {
    @Before("aop.acpects.MyPointcuts.allGetMethodsWithNoParam()")
    public void beforeGetExceptionHandlingAdvice()
    {
        System.out.println("beforeGetExceptionHandlingAdvice: " +
                "ловим, обрабатываем исключение при попытке " +
                "получить книгу/журнал");
    }
}
