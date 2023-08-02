package com.trah.awelmara.controllers;



import com.trah.awelmara.dto.EmployeeDto;
import com.trah.awelmara.mapper.EmployeeMapper;
import com.trah.awelmara.model.Competence;
import com.trah.awelmara.model.Employee;
import com.trah.awelmara.repositories.CompanyRepository;
import com.trah.awelmara.repositories.CompetencesRepository;
import com.trah.awelmara.repositories.EmployeeRepository;
import com.trah.awelmara.repositories.LoginRepository;
import com.trah.awelmara.services.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CompetencesRepository competencesRepository;
    @Autowired
    LoginRepository loginRepository;

    @PostMapping("/employee")
    public void ajouter(@RequestBody Employee employee) {
        employeeService.ajouter(employee);
    }

    @PostMapping("/employees")
    public void ajouterPlusieurs(@RequestBody List<Employee> employees) {
        employeeService.ajouterPlusieurs(employees);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        loginRepository.deleteById(id);
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> findEmployee(@PathVariable(name = "id") Long id) {
        return employeeService.findEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }

    @PutMapping("/employee/{id}/competences")
    public void ajouterCompetenceAuEmploye(
            @PathVariable(name = "id") Long id,
            @RequestBody List<Competence> competences) {
        employeeService.ajouterCompetenceAuEmploye(id, competences);
    }

    @GetMapping("/employeeDto/{id}")
    public Optional<EmployeeDto> findbyId(@PathVariable(name = "id") Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = employeeOptional.get();
        EmployeeDto employeeDto = new EmployeeDto();
        if (employeeOptional.isPresent()) {
            employeeDto.setNom(employee.getNom());
            employeeDto.setAge(employee.getAge());
            employeeDto.setSexe(employee.getSexe());
            employeeDto.setPrenom(employee.getPrenom());
            employeeDto.setAdresse(employee.getAdresse());
            employeeDto.setDepartement(employee.getDepartement());
            return Optional.of(employeeDto);
        }
        return null;
    }

    @GetMapping("/employeeDtoMapper/{id}")
    public ResponseEntity<EmployeeDto> findByIdMapper(@PathVariable(name="id") Long id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            EmployeeDto employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee.get());
            return ResponseEntity.ok(employeeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

