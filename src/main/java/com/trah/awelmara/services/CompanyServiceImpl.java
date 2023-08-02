package com.trah.awelmara.services;

import com.trah.awelmara.model.Company;
import com.trah.awelmara.model.Employee;
import com.trah.awelmara.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public List<Employee> getEmployeesByCompany(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            return company.getEmployees();
        }
        else return null;
    }

    @Override
    public List<Company> get() {
        return companyRepository.findAll();
    }
}
