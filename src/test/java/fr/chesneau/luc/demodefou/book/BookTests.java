package fr.chesneau.luc.demodefou.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.chesneau.luc.demodefou.entities.Book.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void helloBook() {
        assert bookService.helloBook().equals("Hello Book");
    }

    @Test
    void getAllBook() {
        assert bookRepository.findAll().size() > 0;
    }

    /*@Test
    void getAllBook() {
        assert bookService.getListBook().size() > 0;
    }

    @Test
    void getAllBookAPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/all");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request).andExpect(ok);
    }

    @Test
    void getBookById(){
        Book book = bookService.getListBook().get(1);
        assert book == bookService.getBookById(1);
    }

    @Test
    void getBookByIdAPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/1");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request).andExpect(ok);
    }

    @Test
    void getBookByTitle(){
        BookService testBookService = new BookService();
        Book book = testBookService.getBookByTitle("Le Hobbit");
        assert book.getTitle().equals("Le Hobbit");
    }

    @Test
    void getBookByTitleAPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/name").param("title", "Le Hobbit")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus).andReturn().getResponse().getContentAsString();

        List<Book> books = Arrays.asList(objectMapper.readValue(contentAsString, Book[].class));
        assert books.contains("Le Hobbit");
    }

    @Test
    void getBookByAuthor(){
        Book bookTemp = new Book("clc", new Author("Totoledeglingo", "firstname ITEMTODESTROY",  1000), "Un livre de malade", 100);
        bookService.addBook(bookTemp);
        String tagranmer = bookTemp.getAuthor().getName();
        Book book = bookService.getBookByAuthorName("Totoledeglingo");
        String tg = book.getAuthor().getName();
        assert book.getAuthor().getName().equals("Totoledeglingo");
        bookService.deleteBook(bookTemp.getTitle());
    }

    @Test
    void getBookByAuthorAPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/author").param("author", "Tolkien");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(resultStatus);
    }

    @Test
    void getBooksByAuthor(){
        BookService testBookService = new BookService();
        List<Book> books = testBookService.getBooksByAuthorName("Tolkien");
        assert books.size() > 0;
    }

    @Test
    void getAllBookByAPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/all");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(resultStatus);
    }



    @Test
    void addBookAPI() throws Exception {
        Book book = new Book("Book Titi", new Author("Toto", "Firstname DESTROY", 1900), "livre de fou", 100);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
    }
    @Test
    void addBookAPIFailNbPages() throws Exception {
        Book book = new Book("Book Titi", new Author("Toto", "Firstname DESTROY", 1900), "livre de fou", -10);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isBadRequest();
        mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void deleteBook() {
        int ancienSize = bookService.getListBook().size();
        Book book = new Book("Book Titi", new Author("Toto", "Firstname DESTROY", 1900), "livre de fou", 100);
        bookService.addBook(book);
        bookService.deleteBook(book.getTitle());
        assert bookService.getListBook().size() == ancienSize;
    }

    @Test
    void deleteBookByID() {
        Book book = new Book("Book Titi", new Author("Toto", "Firstname DESTROY", 1900), "livre de fou", 100);
        bookService.addBook(book);
        // Recupération de l'index du dernier livre ajouté servant d'ID
        List<Book> books = bookService.getListBook();
        int index = books.size() - 1;
        bookService.deleteBookById(index);
    }
    @Test
    void deleteBookAPI() throws Exception {
        Book book = new Book("Book Titi", new Author("Toto", "Firstname DESTROY", 1900), "livre de fou", 100);
        bookService.addBook(book);

        RequestBuilder request = MockMvcRequestBuilders.delete("/api/book/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(resultStatus);
    }

    @Test
    void updateBook() throws Exception {
        Book book = new Book("Book Titi", new Author("Toto", "Firstname DESTROY", 1900), "livre de fou", 100);
        bookService.addBook(book);
        book.setTitle("Book Titou");
        bookService.updateBook(book);
        int index = bookService.getListBook().size() - 1;
        assert bookService.getBookById(index).getTitle().equals("Book Titou");
    }

    @Test
    void updateBookAPI() throws Exception {
        Book book = new Book("Book Titi", new Author("Toto", "Firstname DESTROY", 1900), "livre de fou", 100);
        bookService.addBook(book);
        book.setTitle("Book Titou");

        RequestBuilder request = MockMvcRequestBuilders.put("/api/book/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
    }*/
}
