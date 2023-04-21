package fr.chesneau.luc.demodefou.reservation;

import fr.chesneau.luc.demodefou.book.BookService;
import fr.chesneau.luc.demodefou.client.ClientService;
import fr.chesneau.luc.demodefou.entities.Book.Book;
import fr.chesneau.luc.demodefou.entities.Reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;

    @Lazy
    @Autowired
    private ClientService clientService;

    @Lazy
    @Autowired
    private BookService bookService;

    public List<Book> getBooksByClient(int clientId) {
        return reservationRepository.findByClientId(clientId).stream().map(reservation -> bookService.getBookById(reservation.getBook().getId())).collect(Collectors.toList());
    }

}
