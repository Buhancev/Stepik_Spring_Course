package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents()
    {
        Student st1 = new Student("Maxim", 3, 4.5);
        Student st2 = new Student("zikara", 3, 5.1);
        Student st3 = new Student("yuno", 1, 0.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents()
    {
        System.out.println("Начало работы метода getStudents");
        //System.out.println(students.get(3));
        System.out.println("inf from getStudents");
        System.out.println(students);
        return students;
    }
}
