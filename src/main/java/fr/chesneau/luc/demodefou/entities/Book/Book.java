package fr.chesneau.luc.demodefou.entities.Book;

import fr.chesneau.luc.demodefou.entities.Author.Author;
import jakarta.persistence.*;


@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nb_pages")
    private Integer nbPages;

    @ManyToOne
    @JoinColumn(name = "author_id", updatable = false, insertable = false)
    private Author author;

    public Book() {
    }

    public enum State {
        EXCELLENT,
        BON,
        MOYEN,
        ABIMER,
        ECLATER
    }

    public enum Gender {
        POLICIER,
        HISTORIQUE,
        SCIENCE_FICTION,
        FANTASTIQUE,
        HORREUR,
        JEUNESSE,
        DOCUMENTAIRE,
        BD,
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
