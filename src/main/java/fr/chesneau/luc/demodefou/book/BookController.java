package fr.chesneau.luc.demodefou.book;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import fr.chesneau.luc.demodefou.entities.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @GetMapping("/name")
    public List<Book> searchBook(@PathVariable String title){
        if(title == null)
            return null;
        else if(bookService.getBooksByTitle(title) == null)
            return null;
        else if(bookService.getBooksByTitle(title).size() == 0)
            return null;
        else
            return bookService.getBooksByTitle(title);
    }

    @GetMapping("/author")
    public List<Book> searchBookByAuthor(@PathVariable String author){
        if(author == null)
            return null;
        else if(bookService.getBooksByAuthorName(author) == null)
            return null;
        else if(bookService.getBooksByAuthorName(author).size() == 0)
            return null;
        else
            return bookService.getBooksByAuthorName(author);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody @Valid Book book) {
        bookService.saveBook(book);
    }

    @DeleteMapping("/delete")
    public void deleteBookById(@RequestBody Book book){
        bookService.deleteBook(book);
    }

    @PutMapping("/update")
    public void updateBook(
            @RequestBody Book book){
        bookService.updateBook(book);
    }

}
