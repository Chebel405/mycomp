package fr.kira.formation.spring.competences.mycomp.competences;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Competence {
    private String id;
    private String nom;
    private String description;
}