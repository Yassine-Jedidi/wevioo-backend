package com.trah.awelmara.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String nom;
    private String prenom;
    private Integer age;
    private String departement;
    private String adresse;
    private String sexe;

}
