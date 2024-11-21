package com.example.tpfoyer.Controllers;
import com.example.tpfoyer.Entities.Chambre;
import com.example.tpfoyer.Entities.TypeChambre;
import com.example.tpfoyer.Service.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/chambre")

public class ChambreController  {
    IChambreService chambreService;
    @PostMapping("addchambre")
    public Chambre ajoutChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @GetMapping("getchambre/{idChambre}")
    public Chambre getChambre(@PathVariable("idChambre") long idChambre) {
        return chambreService.getChambreById(idChambre);
    }

    @DeleteMapping("deletechambre")
    public void deleteChambre(@RequestBody Chambre chambre) {
        chambreService.deleteChambre(chambre);
    }

    @PutMapping("updatechambre")
    public Chambre modifierChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("getallchambre")
    public List<Chambre> getAllChambre() {
        return chambreService.getAllChambre();
    }
    @GetMapping("chambretype/{type}")
    public List<Chambre> getAllChambreByType(@PathVariable("type") TypeChambre type) {
        return chambreService.findAllByTypeChambre(type);
    }

    @GetMapping("numerochambre/{num}")
    public Chambre getByChambreNum(@PathVariable("num") Long num) {
        return chambreService.findByNumeroChambre(num);
    }
    @GetMapping("/filter")
    public List<Chambre> getChambresByBlocIdAndTypeC(
            @RequestParam Long idBloc,
            @RequestParam TypeChambre typeC) {
        return chambreService.recupererListChambre(idBloc, typeC);
    }
}
