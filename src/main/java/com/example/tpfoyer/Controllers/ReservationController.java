package com.example.tpfoyer.Controllers;

import com.example.tpfoyer.Entities.Reservation;
import com.example.tpfoyer.Service.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/reservation")

public class ReservationController {
    IReservationService reservationService;

    @PostMapping("addreservation")
    public Reservation ajoutReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("getreservation/{idReservation}")
    public Reservation getReservation(@PathVariable("idReservation") long idReservation) {
        return reservationService.getReservationById(idReservation);
    }

    @DeleteMapping("deletereservation")
    public void deleteReservation(@RequestBody Reservation reservation) {
        reservationService.deleteReservation(reservation);
    }

    @PutMapping("updatereservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("getallreservation")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }
    @PutMapping("/affecterEtudiantToReservation/{idReservation}/{idEtudiant}")
    @ResponseBody
    public void affecterEtudiantToReservation(
            @PathVariable("idReservation") Long idReservation,
            @PathVariable("idEtudiant") Long idEtudiant) {
        reservationService.affecterEtudiantToReservation(idReservation, idEtudiant);
    }
    @DeleteMapping("/desaffecterEtudiantFromReservation/{idReservation}/{idEtudiant}")
    @ResponseBody
    public void desaffecterEtudiantFromReservation(
            @PathVariable("idReservation") Long idReservation,
            @PathVariable("idEtudiant") Long idEtudiant) {
        reservationService.desaffecterEtudiantFromReservation(idEtudiant, idReservation);
    }

}
