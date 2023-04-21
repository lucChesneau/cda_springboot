package fr.chesneau.luc.demodefou.client;

import fr.chesneau.luc.demodefou.entities.Book.Book;
import fr.chesneau.luc.demodefou.entities.Client.Client;
import fr.chesneau.luc.demodefou.entities.Client.ClientRepository;
import fr.chesneau.luc.demodefou.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ReservationService reservationService;


    public String helloClient() {
        return "Hello Client";
    }

    public List<Client> getListClient() {
        return clientRepository.findAll();
    }
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    public ClientWithBooks getClientWithBooks(int clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        List<Book> listBooks = reservationService.getBooksByClient(clientId);

        if(client.isPresent() && listBooks != null){
            return new ClientWithBooks(client.get(), listBooks);
        } else {
            return null;
        }
    }

}
