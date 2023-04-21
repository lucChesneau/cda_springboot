package fr.chesneau.luc.demodefou.client;

import fr.chesneau.luc.demodefou.entities.Client.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllBooks(){
        return clientService.getListClient();
    }


    @PostMapping("/add")
    public void addBook(@RequestBody @Valid Client client) {
        clientService.addClient(client);
    }

    @DeleteMapping("/delete")
    public void deleteBookById(@RequestBody Client client){
        clientService.deleteClient(client);
    }

    @PutMapping("/update")
    public void updateBook(
            @RequestBody Client client){
        clientService.updateClient(client);
    }

}
