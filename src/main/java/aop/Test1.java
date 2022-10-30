package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary Ulibrary = context.getBean("uniLibrary", UniLibrary.class);
        //Ulibrary.getBook();

        SchoolLibrary Slibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        //Slibrary.getBook();

        Ulibrary.returnBook();
        //Ulibrary.getMagazine();
        context.close();
    }
}
