package com.trah.awelmara.controllers;

import com.trah.awelmara.model.Competence;
import com.trah.awelmara.repositories.CompetencesRepository;
import com.trah.awelmara.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api")
public class CompetenceController {
    @Autowired
    CompetencesRepository competencesRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/competence")
    public void ajouterCompetence(@RequestBody Competence competence){
        competencesRepository.save(competence);
    }

    @PostMapping("/competences")
    public void ajouterPlusieursCompetences(@RequestBody List<Competence> competenceList){
        competencesRepository.saveAll(competenceList);
    }

    @GetMapping("/competences")
    public List<Competence> getAll(){
        return competencesRepository.findAll();
    }

    @GetMapping("/employee/{id}/competences")
    public List<Competence> getCompetenceByEmployee(@PathVariable(name = "id") Long id){
        return employeeRepository.findById(id).get().getCompetences();
    }
}
