package aop.acpects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    /*
    Работает и до и после метода targer, но он работает не так, как мы можем подумать.
    Если мы используем @Around Advice, то сами берем ответсвенность на запуск target method.
    Around позволяет делать всё, что могут другие методы.
     */

    @Around("execution(public String returnBook())")
    //ProceedingJoinPoint для связи с таргет методом (самое главное не забывать обрабатывать targer-method)
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
        throws Throwable {
        System.out.println("Logging: aroundReturnBookLoggingAdvice: пытаются вернуть книгу в библиотеку");


        //может выбрасывать исключение
        Object targetMethodResult = proceedingJoinPoint.proceed();


        System.out.println("Logging: aroundReturnBookLoggingAdvice: успешно вернули книгу в библиотеку");

        return targetMethodResult;
    }
}
