package com.example.tpfoyer.Repositories;

import com.example.tpfoyer.Entities.Chambre;
import com.example.tpfoyer.Entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findAllByTypeC(TypeChambre tc);
    Chambre findChambreByNumeroChambre(Long num);
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre>findChambreByBlocIdBlocAndAndTypeC(Long idBloc,TypeChambre typeC);
}
