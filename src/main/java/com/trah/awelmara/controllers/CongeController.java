package com.trah.awelmara.controllers;

import com.trah.awelmara.model.Conge;
import com.trah.awelmara.model.Employee;
import com.trah.awelmara.repositories.CongeRepository;
import com.trah.awelmara.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api")
public class CongeController {
    @Autowired
    CongeRepository congeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/conge")
    public List<Conge> getAllDemandes() {
        return congeRepository.findAll();
    }

    @GetMapping("/conge/{id}")
    public List<Conge> getCongeByEmployeeId(@PathVariable(name = "id") Long id) {
        return congeRepository.findByEmployeeId(id);
    }


    @PostMapping("/conge/{employeeId}")
    public Conge createDemande(@RequestBody Conge demandeConge,@PathVariable Long employeeId) {
        demandeConge.setStatut("En attente"); // Défaut pour une nouvelle demande
        // Set the employee associated with the congé (replace "employeeId" with the actual employee ID)
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        demandeConge.setEmployee(employee);
        return congeRepository.save(demandeConge);
    }

    @PutMapping("/conge/{congeId}")
    public void updateCongeStatut(@RequestBody Conge conge ,@PathVariable(name="congeId") Long congeId){
        Optional<Conge> congeOptional = congeRepository.findById(congeId);
        if (congeOptional.isPresent()) {
            Conge existingConge = congeOptional.get();
            existingConge.setStatut(conge.getStatut());
            congeRepository.save(existingConge);
        }
    }
}
