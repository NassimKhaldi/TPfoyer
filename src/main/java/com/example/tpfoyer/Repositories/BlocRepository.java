package com.example.tpfoyer.Repositories;

import com.example.tpfoyer.Entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    List<Bloc> findBlocByFoyer_Universite_IdUniversite(Long idUniversite);
}
