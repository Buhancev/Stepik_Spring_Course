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

    - Можно обрабатывать исключение (в отличии от @AfterThrowing)
    - Перебрасывать исключение
     */

    @Around("execution(public String returnBook())")
    //ProceedingJoinPoint для связи с таргет методом (самое главное не забывать обрабатывать targer-method)
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
        throws Throwable {
        System.out.println("Logging: aroundReturnBookLoggingAdvice: пытаются вернуть книгу в библиотеку");

        Object targetMethodResult = null;
        try {
            //может выбрасывать исключение
            targetMethodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception e) {
            System.out.println("Logging exception: aroundReturnBookLoggingAdvice: было поймано " +
                    " исключение" + e);

            //targetMethodResult = "неизвестно название книги";
            //лучше не прятать исключение, как выше, а логгировать и пробрасывать его дальше
            throw e;
        }

        System.out.println("Logging: aroundReturnBookLoggingAdvice: успешно вернули книгу в библиотеку");

        return targetMethodResult;
    }
}
