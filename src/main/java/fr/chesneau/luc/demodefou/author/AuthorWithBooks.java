package fr.chesneau.luc.demodefou.author;

import fr.chesneau.luc.demodefou.entities.Author.Author;
import fr.chesneau.luc.demodefou.entities.Book.Book;

import java.util.List;

public class AuthorWithBooks {

    private Author author;
    private List<Book> books;

    public AuthorWithBooks() {
    }
    public AuthorWithBooks(Author author, List<Book> books) {
        this.author = author;
        this.books = books;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
