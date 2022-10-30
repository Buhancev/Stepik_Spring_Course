package aop;

import org.springframework.stereotype.Component;

@Component("LibraryBean")
public class Library {
    public void getBook() {
        System.out.println("Берем книгу");
    }
}
