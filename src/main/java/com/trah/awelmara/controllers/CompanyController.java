package com.trah.awelmara.controllers;

import com.trah.awelmara.model.Company;
import com.trah.awelmara.model.Employee;
import com.trah.awelmara.repositories.CompanyRepository;
import com.trah.awelmara.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyService companyService;

    @GetMapping("/company")
    public List<Company> get() {
        return companyService.get();
    }

    @GetMapping("/company/{companyId}/employees")
    public List<Employee> getEmployeesByCompany(@PathVariable(name = "companyId") Long companyId) {
        return companyService.getEmployeesByCompany(companyId);
    }
}
