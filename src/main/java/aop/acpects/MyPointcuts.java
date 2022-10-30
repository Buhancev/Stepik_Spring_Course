package aop.acpects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* add*(..))")
    public void allAddMethodsWithNoParam() {}

}
