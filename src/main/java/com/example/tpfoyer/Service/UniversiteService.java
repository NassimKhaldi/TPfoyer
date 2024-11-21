package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Chambre;
import com.example.tpfoyer.Entities.Foyer;
import com.example.tpfoyer.Entities.TypeChambre;
import com.example.tpfoyer.Entities.Universite;
import com.example.tpfoyer.Repositories.FoyerRepository;
import com.example.tpfoyer.Repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {

    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversiteById(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(Universite universite) {
        universiteRepository.delete(universite);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite affecterFoyerToUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }
    @Override
    public Universite affecterFoyerToUniversite(Long idUniversite, Foyer foyer) {
        Universite universite = universiteRepository.findById(idUniversite).get();
        Foyer savedFoyer = foyerRepository.save(foyer);
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);
        return universite;
    }
    public Universite desaffecterFoyerFromUniversite(Long universiteId) {
        Universite universite = universiteRepository.findById(universiteId)
                .orElseThrow(() -> new IllegalArgumentException("Universite not found with id: " + universiteId));
        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }

}
