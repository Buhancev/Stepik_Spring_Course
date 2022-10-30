package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Берем книгу из UniLibrary ");
        System.out.println("------------------------------------");
    }

    public void returnBook() {
        System.out.println("Возвращаем книгу в uniLibrary");
        System.out.println("------------------------------------");

    }

    public void getMagazine() {
        System.out.println("Берем журнал из UniLibrary");
        System.out.println("------------------------------------");

    }

    public void returnMagazine() {
        System.out.println("Возвращаем журнал в uniLibrary");
        System.out.println("------------------------------------");

    }

    public void addBook(String persoName, Book book) {
        System.out.println("добавляет книгу в UniLibrary ");
        System.out.println("------------------------------------");

    }

    public void addMagazine() {
        System.out.println("добавляет журнал в UniLibrary ");
        System.out.println("------------------------------------");

    }
}
