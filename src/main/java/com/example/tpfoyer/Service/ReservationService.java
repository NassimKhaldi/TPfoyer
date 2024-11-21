package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Etudiant;
import com.example.tpfoyer.Entities.Reservation;
import com.example.tpfoyer.Repositories.EtudiantRepository;
import com.example.tpfoyer.Repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    ReservationRepository reservationRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }
    @Override
    public Reservation affecterEtudiantToReservation(Long idReservation, Long idEtudiant) {
        Reservation reservation = reservationRepository.findById(idReservation).get();
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).get();

        Set<Etudiant> etudiantsMisesAJour = reservation.getEtudiants() != null ? reservation.getEtudiants() : new HashSet<>();
        etudiantsMisesAJour.add(etudiant);

        reservation.setEtudiants(etudiantsMisesAJour);
        reservationRepository.save(reservation);

        return reservation;
    }
    public void desaffecterEtudiantFromReservation(Long etudiantId, Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + reservationId));

        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new IllegalArgumentException("Etudiant not found with id: " + etudiantId));

        Set<Etudiant> etudiants = reservation.getEtudiants();
        if (etudiants != null) {
            etudiants.remove(etudiant);
            reservation.setEtudiants(etudiants);
            reservationRepository.save(reservation);
        }
    }



}
