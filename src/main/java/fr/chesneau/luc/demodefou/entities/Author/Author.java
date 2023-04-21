package fr.chesneau.luc.demodefou.entities.Author;

import fr.chesneau.luc.demodefou.entities.Book.Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "author")
@Validated
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Le prénom est obligatoire")
    @Column(name = "firstname")
    private String firstname;

    @NotBlank(message = "La date de naissance est obligatoire")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

   @OneToMany(targetEntity = Book.class , mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String firstname, Date dateOfBirth) {
        this.name = name;
        this.firstname = firstname;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
