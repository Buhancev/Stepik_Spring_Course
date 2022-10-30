package aop.acpects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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

    @Before("aop.acpects.MyPointcuts.allAddMethodsWithNoParam()allGetMethodsWithNoParam()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        /*
        Join point - точка/момент в выполняемой программе, когда следует применять
        Advice. T.e это точка переплетения метода с дизнес-логикой и метода со
        служебным функционалом.

        Прописав Join Point в параметре метода Advice, мы палучаем доступ к информации
        о сигнатуре и параметрах метода с бизнес-логикой

         */

        //инфа о сигнатуре метода
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();


        System.out.println("beforeAddLoggingAdvice:" +
                "логгирование попытки получить книгу/журнал");
        System.out.println("methodSignature " + methodSignature);
        System.out.println("methodSignature.getMethod() " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();
            for(Object obj : args){
                if(obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println(myBook.getAuthor() +
                            myBook.getYearOfPublication() +
                            myBook.getName());
                }
            }
        }

        System.out.println("------------------------------------");
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
