package fr.kira.formation.spring.competences.mycomp.personnes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonneConfiguration {

    @Bean
    public PersonneServiceImpl personneService(PersonneRepository personneRepository){
        return new PersonneServiceImpl(personneRepository);
    }

}
