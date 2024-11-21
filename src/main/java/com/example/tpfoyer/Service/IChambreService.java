package com.example.tpfoyer.Service;

import com.example.tpfoyer.Entities.Chambre;
import com.example.tpfoyer.Entities.TypeChambre;

import java.util.List;

public interface IChambreService {

    Chambre addChambre(Chambre chambre);
    Chambre getChambreById(long idChambre);
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(Chambre chambre);
    List<Chambre> getAllChambre();
    List<Chambre> findAllByTypeChambre(TypeChambre typeChambre);
    public Chambre findByNumeroChambre(Long numC);
    public List<Chambre>recupererListChambre(Long idBloc,TypeChambre typeC);


}
