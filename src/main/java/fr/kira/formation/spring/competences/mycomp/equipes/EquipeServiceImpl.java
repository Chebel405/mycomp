package fr.kira.formation.spring.competences.mycomp.equipes;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;

    public EquipeServiceImpl(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe save(Equipe entity) {
        return equipeRepository.save(entity);
    }

    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        equipeRepository.deleteById(id);
    }
}