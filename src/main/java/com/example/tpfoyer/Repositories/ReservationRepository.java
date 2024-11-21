package com.example.tpfoyer.Repositories;

import com.example.tpfoyer.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
