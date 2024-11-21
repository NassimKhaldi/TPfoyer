package com.example.tpfoyer.Controllers;
import com.example.tpfoyer.Entities.Bloc;
import com.example.tpfoyer.Entities.Chambre;
import com.example.tpfoyer.Service.IBlocService;
import com.example.tpfoyer.Service.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/bloc")
@Tag(name = "Gestion Bloc")

public class BlocController {
    IBlocService blocService;
    @Operation(description = "ajouter un Bloc dans la base de données")
    @PostMapping("addbloc")
    public Bloc ajoutBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @GetMapping("getbloc/{idBloc}")
    public Bloc getBloc(@PathVariable("idBloc") long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("deletebloc")
    public void deleteBloc(@RequestBody Bloc bloc) {
        blocService.deleteBloc(bloc);
    }

    @PutMapping("updatebloc")
    public Bloc modifierBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("getallbloc")
    public List<Bloc> getAllBloc() {
        return blocService.getAllBloc();
    }
    @PostMapping("/addBlocEtChambresAssocie")
    @ResponseBody
    public Bloc ajouterBlocEtChambresAssocie(@RequestBody Bloc bloc) {
        Bloc savedBloc = blocService.ajouterBlocEtChambresAssocie(bloc);
        return savedBloc;
    }
    @PutMapping("/assignBlocToFoyer/{idBloc}/{idFoyer}")
    @ResponseBody
    public void assignBlocToFoyer(
            @PathVariable("idBloc") Long idBloc,
            @PathVariable("idFoyer") Long idFoyer) {
        blocService.assignBlocToFoyer(idBloc, idFoyer);
    }
    @GetMapping("getblocbyiduniversite/{idUniversite}")
    public List<Bloc> getBlocsByUniversiteId(@PathVariable("idUniversite") Long idUniversite) {
        return blocService.findBlocByFoyerIdUniversite(idUniversite);
    }
}
