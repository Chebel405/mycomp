package fr.kira.formation.spring.competences.mycomp.equipes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipeRepository extends MongoRepository<Equipe, String> {
}