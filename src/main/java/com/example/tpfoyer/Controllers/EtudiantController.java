package com.example.tpfoyer.Controllers;
import com.example.tpfoyer.Entities.Etudiant;
import com.example.tpfoyer.Service.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("api/etudiant")
public class EtudiantController {

    IEtudiantService etudiantService;

    @PostMapping("addetudiant")
    public Etudiant ajoutEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @GetMapping("getetudiant/{idEtudiant}")
    public Etudiant getEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @DeleteMapping("deleteetudiant")
    public void deleteEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.deleteEtudiant(etudiant);
    }

    @PutMapping("updateetudiant")
    public Etudiant modifierEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("getalletudiant")
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.getAllEtudiant();
    }
    @GetMapping("getetudiantbycin/{cin}")
    public Etudiant getEtudiantwithcin(@PathVariable("cin") Long cin) {
        return etudiantService.getEtudiantCin(cin);
    }
    @GetMapping("getetudiantbynaissance/{datenaissance}")
    public List<Etudiant> getEtudiantByDateNaissance(@PathVariable("datenaissance")@DateTimeFormat(pattern = "dd-MM-YYYY") Date datenaissance){
        return etudiantService.getEtudiantByDateNaissance(datenaissance);
    }
}
