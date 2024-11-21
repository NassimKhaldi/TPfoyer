package com.example.tpfoyer.Repositories;

import com.example.tpfoyer.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant getEtudiantByCin(Long cin);
    List<Etudiant>findEtudiantByDateNaissanceGreaterThan(Date datenaissance);
}
