package fr.chesneau.luc.demodefou.client;

import fr.chesneau.luc.demodefou.entities.Client.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceTests {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void helloClient() {
        assert true;
    }

    @Test
    void getAll() {
        assert clientRepository.findAll().size() > 0;
    }
/*
    @Test
    void addClientAPI() throws Exception {
        Client client = new Client("Chrysantème", "Jeannine", new ArrayList<>(){{
            add(new Book("Le Seigneur des Anneaux", authorService.getAuthorByName("Tolkien"), "Un livre de fantasy", 1000));
        }}, "jeannine@mail.com");

        RequestBuilder request = MockMvcRequestBuilders.post("/api/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
    }*/

}
