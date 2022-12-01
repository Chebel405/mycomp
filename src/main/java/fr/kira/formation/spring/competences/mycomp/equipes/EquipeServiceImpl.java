package fr.kira.formation.spring.competences.mycomp.equipes;

import fr.kira.formation.spring.competences.mycomp.personnes.Personne;
import fr.kira.formation.spring.competences.mycomp.personnes.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;


    public EquipeServiceImpl(EquipeRepository equipeRepository, PersonneService personneService) {
        this.equipeRepository = equipeRepository;
        this.personneService = personneService;
    }

    private final PersonneService personneService;


    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe save(Equipe entity) {
        for (Personne membre : entity.getMembres()) {
            if (membre.getId() == null) {
                this.personneService.save(membre);
            }
        }
        return equipeRepository.save(entity);
    }

    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe ajoutMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);

        //2 meme methode
        // 1ere JAVA
        if (!equipe.getMembres().stream().anyMatch(equipeMembre -> equipeMembre.getId().equals(idMembre))) {
            equipe.getMembres().add(membre);
        }

        //2e Java plus ancien mais fonctionnel
       /* boolean isMembre = false;
        for(Personne equipeMembre: equipe.getMembres()){
            if(equipeMembre.getId().equals(idMembre)){
                isMembre = true;
                break;
            }
        }
        if(!isMembre) equipe.getMembres().add(membre);*/

        return this.save(equipe);

    }

    @Override
    public Equipe supprimerMembre(String idEquipe, String idMembre) {
        Equipe equipe = findById(idEquipe);
        equipe.getMembres().removeIf(membre -> membre.getId().equals(idMembre));
        return save(equipe);

    }

}