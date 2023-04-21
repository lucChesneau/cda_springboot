package fr.chesneau.luc.demodefou.entities.Reservation;

import fr.chesneau.luc.demodefou.entities.Book.Book;
import fr.chesneau.luc.demodefou.entities.Client.Client;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<Client> client;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
