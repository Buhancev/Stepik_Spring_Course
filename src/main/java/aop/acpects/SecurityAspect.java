package aop.acpects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2) //каким по счету будет выполняться аспект
public class SecurityAspect {
    @Before("aop.acpects.MyPointcuts.allGetMethodsWithNoParam()")
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение");
    }
}
