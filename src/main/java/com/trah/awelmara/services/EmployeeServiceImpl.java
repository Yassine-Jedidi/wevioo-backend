package com.trah.awelmara.services;

import com.trah.awelmara.model.*;
import com.trah.awelmara.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompetencesRepository competencesRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    LoginRepository loginRepository;

    @Override
    public void update(Long id, Employee employee) {
        Employee employee1 = employeeRepository.getById(id);
        if (employee.getAge() != null)
            employee1.setAge(employee.getAge());
        if (employee.getNom() != null)
            employee1.setNom(employee.getNom());
        if (employee.getDepartement() != null)
            employee1.setDepartement(employee.getDepartement());
        if (employee.getPrenom() != null)
            employee1.setPrenom(employee.getPrenom());
        if (employee.getSalaire() != null)
            employee1.setSalaire(employee.getSalaire());
        if (employee.getCin() != null)
            employee1.setCin(employee.getCin());
        if (employee.getCnss() != null)
            employee1.setCnss(employee.getCnss());
        if (employee.getAdresse() != null)
            employee1.setAdresse(employee.getAdresse());
        if (employee.getCompany() != null)
            employee1.setCompany(employee.getCompany());
        if (employee.getEmail() != null)
            employee1.setEmail(employee.getEmail());
        if (employee.getEtatSocial() != null)
            employee1.setEtatSocial(employee.getEtatSocial());
        if (employee.getMatricule() != null)
            employee1.setMatricule(employee.getMatricule());
        if (employee.getNumeroTelephone() != null)
            employee1.setNumeroTelephone(employee.getNumeroTelephone());
        if (employee.getCompetences() != null)
            employee1.setCompetences(employee.getCompetences());
        if (employee.getSexe() != null)
            employee1.setSexe(employee.getSexe());
        if (employee.getJob() != null)
            employee1.setJob(employee.getJob());
        if (employee.getRole() != null)
            employee1.setRole(employee.getRole());

        employeeRepository.save(employee1);
    }

    @Override
    public void ajouter(Employee employee) {
        Optional<Company> companyOptional = companyRepository.findByName("Wevioo");

        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            employee.setCompany(company);

            // Save the competences
            for (Competence competence : employee.getCompetences()) {
                Optional<Competence> existingCompetenceOptional = competencesRepository.findByNom(competence.getNom());
                if (existingCompetenceOptional.isPresent()) {
                    competence.setId(existingCompetenceOptional.get().getId());
                    // Si le competence existe , n'ajoute pas une autre
                } else {
                    competencesRepository.save(competence);
                }
            }



            Role role = employee.getRole();
            Optional<Role> existingRoleOptional = roleRepository.findByNom(role.getNom());
            if (existingRoleOptional.isPresent()) {
                role.setId(existingRoleOptional.get().getId());
            } else {
                // Role not found, handle accordingly
            }
            //Save the login entity
            Login login = employee.getLogin();
            login.setEmployee(employee);
            loginRepository.save(login);

            // Save the Employee first
            employeeRepository.save(employee);
        } else {
            // Company does not exist, handle accordingly
        }
    }




    @Override
    public void ajouterPlusieurs(List<Employee> employee) {
        employeeRepository.saveAll(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void ajouterCompetenceAuEmploye(Long id, List<Competence> competenceList) {
        Employee employee = employeeRepository.getById(id);
        employee.getCompetences().addAll(competenceList);
        employeeRepository.save(employee);
    }
}
