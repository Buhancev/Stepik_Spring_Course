package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(Book book) {
        System.out.println("Берем книгу из UniLibrary " + book.getName());
    }

    public String returnBook() {
        System.out.println("Возвращаем книгу в uniLibrary");
        return "OK";
    }

    public void getMagazine() {
        System.out.println("Берем журнал из UniLibrary");
    }
}
