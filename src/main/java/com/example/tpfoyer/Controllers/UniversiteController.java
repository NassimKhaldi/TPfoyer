package com.example.tpfoyer.Controllers;

import com.example.tpfoyer.Entities.Foyer;
import com.example.tpfoyer.Entities.Universite;
import com.example.tpfoyer.Service.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/universite")
public class UniversiteController {

    IUniversiteService universiteService;

    @PostMapping("adduniversite")
    public Universite ajoutUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @GetMapping("getuniversite/{idUniversite}")
    public Universite getUniversite(@PathVariable("idUniversite") long idUniversite) {
        return universiteService.getUniversiteById(idUniversite);
    }

    @DeleteMapping("deleteuniversite")
    public void deleteUniversite(@RequestBody Universite universite) {
        universiteService.deleteUniversite(universite);
    }

    @PutMapping("updateuniversite")
    public Universite modifierUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("getalluniversite")
    public List<Universite> getAllUniversite() {
        return universiteService.getAllUniversite();
    }
    @PostMapping("affecteruni")
    @ResponseBody
    public Universite affecterFoyerToUniversite(@RequestBody Universite universite){
        Universite uni=universiteService.affecterFoyerToUniversite(universite);
        return uni;
    }
    @PutMapping("/affecterFoyerToUniversite/{idUniversite}")
    @ResponseBody
    public Universite affecterFoyerToUniversite(
            @RequestBody Foyer foyer,
            @PathVariable("idUniversite") Long idUniversite) {
        Universite universite = universiteService.affecterFoyerToUniversite(idUniversite, foyer);
        return universite;
    }
    @DeleteMapping("desaffecteruni/{idUniversite}")
    @ResponseBody
    public Universite desaffecterFoyersFromUniversite(@PathVariable("idUniversite") Long idUniversite) {
        return universiteService.desaffecterFoyerFromUniversite(idUniversite);
    }
}
