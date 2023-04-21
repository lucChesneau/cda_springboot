package fr.chesneau.luc.demodefou.client;

import fr.chesneau.luc.demodefou.entities.Client.Client;
import fr.chesneau.luc.demodefou.entities.Book.Book;

import java.util.List;

public class ClientWithBooks {
    private Client client;
    private List<Book> books;

    public ClientWithBooks() {
    }
    public ClientWithBooks(Client client, List<Book> books) {
        this.client = client;
        this.books = books;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
