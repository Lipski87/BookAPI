package pl.coderslab.web;

import pl.coderslab.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();
    void addBook(Book book);
    Optional<Book> getBookById(Long id);
    void removeBookById(Long id);
    void updateBook (Book book);
}
