package aop.acpects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //говорит, что это не простой класс, а Aspect. Поэтому Spring будет к нему относиться по другому
//Aspect - класс, отвечающий за сквозную функциональность
@Order(1)//каким по счету будет выполняться аспект

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

    @Before("aop.acpects.MyPointcuts.allGetMethodsWithNoParam()allGetMethodsWithNoParam()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice:" +
                "логгирование попытки получить книгу/журнал");
    }


//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void getAllMethodsFromUniLibrary () {}
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void returnAllMethodsFromUniLibrary () {}
//
//    //кобминирование поинткатов в помощью логических операторов
//    @Pointcut("getAllMethodsFromUniLibrary() || returnAllMethodsFromUniLibrary()")
//    private void getAndReturnAllMethodsFromUniLibrary() {}
//
//    @Before("getAllMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("Logging: beforeGetLoggingAdvice: Log#1");
//    }
//
//    @Before("returnAllMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("Logging: beforeReturnLoggingAdvice: Log#2");
//    }
//
//    @Before("getAndReturnAllMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("Logging: getAndReturnAllMethodsFromUniLibrary: Log#3");
//    }


    //Создадим Pointcut для всех методов UniLibrary, кроме return Magazine
//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary() {}
//
//    @Pointcut("execution(* aop.UniLibrary.returnMagazine())")
//    private void returnMagazineMethodFromUniLibrary() {}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineMethodFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void BeforeallMethodsExceptReturnMagazineAdvice() {
//        System.out.println("Logging: beforeAllMethodsExceptReturnMagazineAdvice: log#4");
//    }


}
