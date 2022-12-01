package fr.kira.formation.spring.competences.mycomp.equipes;

import fr.kira.formation.spring.competences.mycomp.personnes.Personne;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@Document
public class Equipe {
    @Id
    private String id;
    private String nom;
    @DBRef
    private Set<Personne> membres = new HashSet<>();

    @Override
    public boolean equals (Object other){
        if(this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Equipe equipe = (Equipe) other;

        return Objects.equals(id, equipe.id);
    }
}