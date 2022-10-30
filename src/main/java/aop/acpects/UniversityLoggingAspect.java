package aop.acpects;

import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("Logging: beforeGetStudentsLoggingAdvice: " +
//                "получение списка студентов перед методом getStudents");
//    }
//
//    //срабатывает после работы основного (target) метода, но ДО присвоения результата какой либо переменной
//    //есть очень мощная функциональность - может перехватывать результат и делать с ним всё что угодно
//    //тем самым может менять возвращаемое значение функции
//    @AfterReturning(pointcut = "execution(* getStudents())",
//        returning = "students") //указываем возвращаемое значение в returning и в параметры Advice
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
//        //меняем возвращаемое значение
//        Student firstStudent = students.get(0);
//
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr" + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//
//        double avgGrage = firstStudent.getAvgGrade();
//        avgGrage = avgGrage - 5;
//        firstStudent.setAvgGrade(avgGrage);
//
//        System.out.println("Logging: afterReturningGetStudentsLoggingAdvice: " +
//                "получение списка студентов после работы метода getStudents");
//    }

    //работает после генерирования исключения
    //можем получить информацию об exception, которые было выброшенно
    //для этого нужно добавить второй параметр
    //не влияет на протекание программы при выбрасывании исключения, но можно получить доступ к исключению
    @AfterThrowing(pointcut = "execution(* getStudents())",
        throwing = "exception")             //получаем исключение
    public void afterThrowingGetStudentAdvice(Throwable exception) {
        System.out.println("Logging: afterThrowingGetStudentAdvice: логируем выброс исключения " +
                exception);
    }
}
