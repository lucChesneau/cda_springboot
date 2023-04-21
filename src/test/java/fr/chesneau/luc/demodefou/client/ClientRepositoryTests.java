package fr.chesneau.luc.demodefou.client;

import static org.junit.Assert.assertEquals;

import fr.chesneau.luc.demodefou.entities.Client.ClientRepository;
import fr.chesneau.luc.demodefou.entities.Review.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTests {
    @Autowired
    private ClientRepository clientRepository;

}