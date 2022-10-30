package aop.acpects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
@Aspect //говорит, что это не простой класс, а Aspect. Поэтому Spring будет к нему относиться по другому
//Aspect - класс, отвечающий за сквозную функциональность
public class LoggingAndSecutiryAspect {
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

    //    @Before("execution(public void *(..))") - с любым кол-вом параметров

    //Book, и 0 или > параметров любого типа

    //execution(* *(..)) - для ЛЮБОГО метода
    //execution(* *()) любой access modifier, любое название, метод без параметров
    //@Before("execution(* returnBook())")
    //public void beforeReturnBookAdvice() {
    //    System.out.println("beforeReturnBookAdvice: попытка получить книгу");
    //}

    /*объявление Pointcut
    Для того чтобы не юзать копипаст когда для нескольких Advice подходит один и тот же
    pointcut, есть возможность объявить данный Pointcut и использовать его несколько раз

    @Pointcut("pointcut_exptession")
    private void pointcut_reference() {}

    теперь можно сделать так
    @Before("pointcut_exptession")
    public void advice_name() {some code}
     */

    @Pointcut("execution(* get*())")
    private void allGetMethodsWithNoParam() {}

    @Before("allGetMethodsWithNoParam()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: попытка получить книгу/журнал");
    }


    @Before("allGetMethodsWithNoParam()")
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение");
    }



}
