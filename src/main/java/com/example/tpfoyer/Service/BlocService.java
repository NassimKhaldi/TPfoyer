package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Bloc;
import com.example.tpfoyer.Entities.Foyer;
import com.example.tpfoyer.Repositories.BlocRepository;
import com.example.tpfoyer.Repositories.ChambreRepository;
import com.example.tpfoyer.Repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class BlocService implements IBlocService {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository;
    @Override
    public void assignBlocToFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
    }

    public Bloc ajouterBlocEtChambresAssocie(Bloc bloc) {
        Bloc savedBloc = blocRepository.save(bloc);
        savedBloc.getChambres().forEach(chambre -> {
            chambre.setBloc(savedBloc);
            chambreRepository.save(chambre);
        });
        return savedBloc;
    }

    @Override
    public Bloc addBloc(Bloc bloc){return blocRepository.save(bloc);}
    @Override
    public Bloc getBlocById(long idBloc){return blocRepository.findById(idBloc).get();}
    @Override
    public Bloc updateBloc(Bloc bloc){return blocRepository.save(bloc);}
    @Override
    public void deleteBloc(Bloc bloc){blocRepository.delete(bloc);}
    @Override
    public List<Bloc> getAllBloc(){return blocRepository.findAll();}
    @Override
    public List<Bloc> findBlocByFoyerIdUniversite(Long idUniversite){
        return blocRepository.findBlocByFoyer_Universite_IdUniversite(idUniversite);
    }

}
