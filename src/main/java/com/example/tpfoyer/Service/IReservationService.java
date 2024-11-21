package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Reservation;
import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);
    Reservation getReservationById(long idReservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    List<Reservation> getAllReservation();
    Reservation affecterEtudiantToReservation(Long idReservation, Long idEtudiant);
    void desaffecterEtudiantFromReservation(Long etudiantId, Long reservationId) ;
}
