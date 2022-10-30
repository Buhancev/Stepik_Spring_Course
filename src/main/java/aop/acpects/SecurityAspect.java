package aop.acpects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//@Order(2) //каким по счету будет выполняться аспект
//public class SecurityAspect {
//    @Before("aop.acpects.MyPointcuts.allAddMethodsWithNoParam()")
//    public void beforeAddSecurityAdvice() {
//        System.out.println("beforeAddSecurityAdvice: проверка прав на получение");
//        System.out.println("------------------------------------");
//    }
//}
