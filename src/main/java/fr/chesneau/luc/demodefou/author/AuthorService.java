package fr.chesneau.luc.demodefou.author;

import fr.chesneau.luc.demodefou.book.BookService;
import fr.chesneau.luc.demodefou.entities.Author.Author;
import fr.chesneau.luc.demodefou.entities.Author.AuthorRepository;
import fr.chesneau.luc.demodefou.entities.Book.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookService bookService;

    public String helloAuthor() {
        return "Hello Author";
    }

    public AuthorWithBooks getAuthorWithBooks(int authorId){
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()){
            List<Book> listBooks = bookService.getBooksForAuthor(authorId);
            return new AuthorWithBooks(author.get(), listBooks);
        }
        throw new EntityNotFoundException("Author with ID %d not found".formatted(authorId));
    }
}
