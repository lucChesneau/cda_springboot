package fr.chesneau.luc.demodefou.entities.Book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    // Génération de requêtes via nommage de méthode : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Remplacement des paramètres de la méthode par ordre
    @Query("select b from Book b where b.nbPages > ?1")
    List<Book> findByBooks(Integer nbPages);

    // Remplacement des paramètres par noms
    @Query("select b from Book b where b.nbPages > :minimumPages")
    List<Book> findByBigBooksByAlias(@Param("minimumPages") Integer nbPages);

    List<Book> findByAuthorId(int authorId);

    List<Book> findByTitle(String title);

}
