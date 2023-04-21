package fr.chesneau.luc.demodefou.entities.Review;

import fr.chesneau.luc.demodefou.entities.Book.Book;
import fr.chesneau.luc.demodefou.entities.Client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Min(value = 1, message = "La note doit être comprise entre 1 et 10")
    @Max(value = 10, message = "La note doit être comprise entre 1 et 10")
    @Column(name = "note")
    private int note;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Review() {
    }

    public Review(int note, String content) {
        this.note = note;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
