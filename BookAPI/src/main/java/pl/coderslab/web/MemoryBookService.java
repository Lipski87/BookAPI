package pl.coderslab.web;

import org.springframework.stereotype.Component;
import pl.coderslab.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService{

    private List<Book> books;
    private static Long nextId = 4L;

    public MemoryBookService() {
        books = new ArrayList<>(List.of(
                (new Book(1L,"9788324631766","Thinking in Java","Bruce Eckel", "Helion","programming")),
                (new Book(2L,"9788324627738","Rusz głową Java.","Sierra Kathy, Bates Bert","Helion","programming")),
                (new Book(3L,"9780130819338","Java 2. Podstawy","Cay Horstmann, Gary Cornell","Helion","programming"))));
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void removeBookById(Long id) {
        if (getBookById(id).isPresent()){
            books.remove(this.getBookById(id).get());
        }
    }

    @Override
    public void updateBook(Book book) {
        if (this.getBookById(book.getId()).isPresent()){
            int indexOf = books.indexOf(this.getBookById(book.getId()).get());
            books.set(indexOf, book);
        }
    }
}
