package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Bloc;
import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);
    Bloc getBlocById(long idBloc);
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Bloc bloc);
    List<Bloc> getAllBloc();
    Bloc ajouterBlocEtChambresAssocie( Bloc bloc) ;
    void assignBlocToFoyer(Long idBloc, Long idFoyer) ;
    List<Bloc> findBlocByFoyerIdUniversite(Long idUniversite);
}
