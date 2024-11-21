package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);

    Etudiant getEtudiantById(long idEtudiant);

    Etudiant updateEtudiant(Etudiant etudiant);

    void deleteEtudiant(Etudiant etudiant);

    List<Etudiant> getAllEtudiant();
    Etudiant getEtudiantCin(Long cin);
    List<Etudiant>getEtudiantByDateNaissance(Date datenaissance);


}
