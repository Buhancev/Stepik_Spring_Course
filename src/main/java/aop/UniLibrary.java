package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Берем книгу из UniLibrary ");
    }

    public void returnBook() {
        System.out.println("Возвращаем книгу в uniLibrary");
    }

    public void getMagazine() {
        System.out.println("Берем журнал из UniLibrary");
    }

    public void returnMagazine() {
        System.out.println("Возвращаем журнал в uniLibrary");
    }

    public void addBook() {
        System.out.println("Берем добавляет книгу в UniLibrary ");
    }

    public void addБфпфяшту() {
        System.out.println("Берем добавляет журнал в UniLibrary ");
    }
}
