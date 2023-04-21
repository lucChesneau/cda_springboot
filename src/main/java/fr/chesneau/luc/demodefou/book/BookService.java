package fr.chesneau.luc.demodefou.book;

import fr.chesneau.luc.demodefou.author.AuthorService;
import fr.chesneau.luc.demodefou.client.ClientService;
import fr.chesneau.luc.demodefou.entities.Author.AuthorRepository;
import fr.chesneau.luc.demodefou.entities.Book.Book;
import fr.chesneau.luc.demodefou.entities.Book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String helloBook() {
        return "Hello Book";
    }


    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public List<Book> getBooksForAuthor(int authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public Book getBookById(int bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> getBooksByAuthorName(String authorName) {
        List<Book> books = new ArrayList<>();
        authorRepository.findAllByName(authorName).forEach(author -> {
            books.addAll(bookRepository.findByAuthorId(author.getId()));
        });
        return books;
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}
