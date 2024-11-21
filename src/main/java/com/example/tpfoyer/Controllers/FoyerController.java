package com.example.tpfoyer.Controllers;

import com.example.tpfoyer.Entities.Foyer;
import com.example.tpfoyer.Service.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/foyer")
public class FoyerController {

    IFoyerService foyerService;

    @PostMapping("addfoyer")
    public Foyer ajoutFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @GetMapping("getfoyer/{idFoyer}")
    public Foyer getFoyer(@PathVariable("idFoyer") long idFoyer) {
        return foyerService.getFoyerById(idFoyer);
    }

    @DeleteMapping("deletefoyer")
    public void deleteFoyer(@RequestBody Foyer foyer) {
        foyerService.deleteFoyer(foyer);
    }

    @PutMapping("updatefoyer")
    public Foyer modifierFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("getallfoyer")
    public List<Foyer> getAllFoyer() {
        return foyerService.getAllFoyer();
    }
}