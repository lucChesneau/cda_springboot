package fr.chesneau.luc.demodefou.author;

import fr.chesneau.luc.demodefou.book.BookService;
import fr.chesneau.luc.demodefou.entities.Author.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorServiceTests {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void helloAuthor() {
        assert authorService.helloAuthor().equals("Hello Author");
    }

    @Test
    void getAllAuthor() {
        assert authorRepository.findAll().size() > 0;
    }
}
