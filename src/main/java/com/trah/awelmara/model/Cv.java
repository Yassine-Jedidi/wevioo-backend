package com.trah.awelmara.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Cv {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    private Integer numTelephone;
    private String email;
    private Integer age;
    private String sexe;

    @ManyToMany
    @JoinTable(
            name = "cv_competences",
            joinColumns = @JoinColumn(name="cv_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    @JsonIgnoreProperties("cvs") // Exclude the cvs field from serialization
    List<Competence> competences;
}
