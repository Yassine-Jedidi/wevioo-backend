package com.trah.awelmara.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToMany(mappedBy = "competences")
    //@JsonIgnoreProperties("competences") // Exclude the competences field from serialization (Si on met pas les competences c'est pas grave)
    @JsonIgnore
    List<Employee> employees;

    @ManyToMany(mappedBy = "competences")
    @JsonIgnoreProperties("competences") // Exclude the competences field from serialization
            @JsonIgnore
    List<Employee> cvs;



    public Competence(String nom) {
        this.nom = nom;
    }

}
