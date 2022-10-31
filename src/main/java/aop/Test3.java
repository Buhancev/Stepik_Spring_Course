package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Main starts");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);

        long begin = System.currentTimeMillis();

        String bookName = library.returnBook();

        long end = System.currentTimeMillis();
        System.out.println("Метода выполнил работу за = " + (end - begin) + "ms");


        System.out.println("Вернули книгу в библиотеку " + bookName);

        System.out.println("Main ends");
        context.close();
    }
}
