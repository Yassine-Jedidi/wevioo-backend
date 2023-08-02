package com.trah.awelmara.controllers;

import com.trah.awelmara.model.Company;
import com.trah.awelmara.model.Competence;
import com.trah.awelmara.model.Cv;
import com.trah.awelmara.model.Employee;
import com.trah.awelmara.repositories.CompetencesRepository;
import com.trah.awelmara.repositories.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api")
public class CvController {
    @Autowired
    CvRepository cvRepository;
    @Autowired
    CompetencesRepository competencesRepository;
    @PostMapping("/cv")
    public void ajouterCv(@RequestBody Cv cv) {
        // Vérifier si la liste des compétences est null
        if (cv.getCompetences() != null) {
            // Enregistrer les compétences
            for (Competence competence : cv.getCompetences()) {
                Optional<Competence> existingCompetenceOptional = competencesRepository.findByNom(competence.getNom());
                if (existingCompetenceOptional.isPresent()) {
                    competence.setId(existingCompetenceOptional.get().getId());
                    // Si la compétence existe, ne l'ajoute pas à nouveau
                } else {
                    competencesRepository.save(competence);
                }
            }
        }

        // Enregistrer le CV
        cvRepository.save(cv);
    }

    @GetMapping("/cv")
    public List<Cv> getCvs(){
        return cvRepository.findAll();
    }

    @GetMapping("/cv/{id}")
    public Cv getCvById(@PathVariable(name = "id") Long id){
        return cvRepository.findById(id).get();
    }

    @DeleteMapping("/cv/{id}")
    public void deleteCvById(@PathVariable(name = "id") Long id){
        cvRepository.deleteById(id);
    }



}
