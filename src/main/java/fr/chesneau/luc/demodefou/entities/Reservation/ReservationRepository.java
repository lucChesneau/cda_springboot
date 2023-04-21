package fr.chesneau.luc.demodefou.entities.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

    public List<Reservation> findByClientId(int clientId);

}
