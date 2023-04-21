package fr.chesneau.luc.demodefou.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    public Author findByName(String name);

    public List<Author> findAllByName(String name);
}
