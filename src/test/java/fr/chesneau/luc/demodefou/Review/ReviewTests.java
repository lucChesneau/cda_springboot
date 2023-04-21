package fr.chesneau.luc.demodefou.Review;

import fr.chesneau.luc.demodefou.entities.Client.ClientRepository;
import fr.chesneau.luc.demodefou.entities.Review.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewTests {

        @Autowired
        private ReviewRepository reviewRepository;

        @Test
        void helloClient() {
            assert true;
        }

        @Test
        void getAll() {
            assert reviewRepository.findAll().size() > 0;
        }
}
