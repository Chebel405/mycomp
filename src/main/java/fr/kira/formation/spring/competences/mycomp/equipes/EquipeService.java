package fr.kira.formation.spring.competences.mycomp.equipes;

import java.util.List;

public interface EquipeService {

    List<Equipe> findAll();

    Equipe save(Equipe entity);

    Equipe findById(String id);

    void deleteById(String id);

    /**
     * Ajout un membre {idmembre} à l'équipe {idEquipe}
     * @param idEquipe id de l'equipe
     * @param idMembre id de la personne qui devient membre
     * @return l'équipe avec les membres
     */
    Equipe ajoutMembre(String idEquipe, String idMembre);


    /**
     * Supprimer un membre de l'équipe
     * @param id
     * @return
     */
    Equipe supprimer(String id);
}