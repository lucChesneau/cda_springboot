package fr.chesneau.luc.demodefou.entities.Client;

import fr.chesneau.luc.demodefou.entities.Book.Book;
import fr.chesneau.luc.demodefou.entities.Review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    // methode jpql pour récupérer les reviews d'un client
    @Query("SELECT r FROM Review r WHERE r.client.id" +
            " = :id")
    public List<Review> getReviewsByClient(@Param("id") Integer id);

}
