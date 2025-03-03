package com.example.tpfoyer.Service;
import com.example.tpfoyer.Entities.Etudiant;
import com.example.tpfoyer.Repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {

    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiantById(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        etudiantRepository.delete(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantCin(Long cin) {
        return etudiantRepository.getEtudiantByCin(cin);
    }

    @Override
    public List<Etudiant> getEtudiantByDateNaissance(Date datenaissance) {
        return etudiantRepository.findEtudiantByDateNaissanceGreaterThan(datenaissance);
    }

}

