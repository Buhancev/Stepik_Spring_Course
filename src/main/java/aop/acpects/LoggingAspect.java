package aop.acpects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //говорит, что это не простой класс, а Aspect. Поэтому Spring будет к нему относиться по другому
//Aspect - класс, отвечающий за сквозную функциональность
public class LoggingAspect {
    //advice - метод в Aspect-class, который должен опеределить что и когда должно пройзойти
    /*типы Advice
    before - до метода
    after returning - после нормального окончания метода
    after throwing - после окончания метода, если было выброшено исключение
    after/ after finallt - после окончания метода
    around - до и после метода
     */

    //point cut - выражение, описавающее где должен быть применён Advice
    /*
    Шаблон pointcut
    execution( modifiers-pattern? return-type-pattern declaring-type-pattern?
        method-name-pattern(parameters-pattern) throws-pattern? )
     */

    //    @Before("execution(public void aop.UniLibrary.getBook())")

    //@Before("execution(public void get*())")
    //@Before("execution(* get*())")
    @Before("execution(* get*())")
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

    //execution(* *()) любой access modifier, любое название, метод без параметров
    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: попытка получить книгу");
    }
}
