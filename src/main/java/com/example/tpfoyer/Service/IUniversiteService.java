package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Foyer;
import com.example.tpfoyer.Entities.Universite;

import java.util.List;

public interface IUniversiteService {

    Universite addUniversite(Universite universite);
    Universite getUniversiteById(long idUniversite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Universite universite);
    List<Universite> getAllUniversite();
    Universite affecterFoyerToUniversite(Universite universite);
    Universite desaffecterFoyerFromUniversite(Long UniversiteId) ;

    Universite affecterFoyerToUniversite( Long idUniversite, Foyer foyer) ;

}
