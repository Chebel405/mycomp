package fr.kira.formation.spring.competences.mycomp.equipes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
@CrossOrigin
public class EquipeController {

    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping("")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    @GetMapping("{id}")
    public Equipe findById(@PathVariable String id) {
        return equipeService.findById(id);
    }

    @PostMapping("")
    public Equipe save(@RequestBody Equipe entity) {
        return equipeService.save(entity);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        equipeService.deleteById(id);
    }

}