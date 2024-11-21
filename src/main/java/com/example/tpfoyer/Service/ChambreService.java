package com.example.tpfoyer.Service;
import com.example.tpfoyer.Entities.Chambre;
import com.example.tpfoyer.Entities.TypeChambre;
import com.example.tpfoyer.Repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {

    ChambreRepository chambreRepository;
    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambreById(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Chambre chambre) {
        chambreRepository.delete(chambre);
    }
    @Override
    public List<Chambre> getAllChambre() {
        return chambreRepository.findAll();
    }
    @Override
    public List<Chambre> findAllByTypeChambre(TypeChambre typeChambre) {
        return chambreRepository.findAllByTypeC(typeChambre);
    }

    @Override
    public Chambre findByNumeroChambre(Long numC) {
        return chambreRepository.findChambreByNumeroChambre(numC);
    }
    @Override

    public List<Chambre>recupererListChambre(Long idBloc,TypeChambre typeC){
        return chambreRepository.findChambreByBlocIdBlocAndAndTypeC(idBloc,typeC);
    }

}