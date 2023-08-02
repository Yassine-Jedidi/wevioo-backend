package com.trah.awelmara.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "role")
    @JsonIgnoreProperties("role") // Exclude the competences field from serialization
    List<Employee> employees;

    // Constructeur prenant une chaîne de caractères pour initialiser le rôle
    public Role(String nom) {
        this.nom = nom;
    }
}