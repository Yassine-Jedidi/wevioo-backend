package com.trah.awelmara.services;

import com.trah.awelmara.model.Competence;
import com.trah.awelmara.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void update(Long id, Employee employee);
    public void ajouter(Employee employee);
    public void ajouterPlusieurs(List<Employee> employee);
    public void delete(Long id);
    public List<Employee> findAll();
    public Optional<Employee> findEmployee(Long id);

    public void ajouterCompetenceAuEmploye(Long id, List<Competence> competenceList);
}
