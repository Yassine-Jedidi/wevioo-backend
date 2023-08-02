package com.trah.awelmara.services;

import com.trah.awelmara.model.Company;
import com.trah.awelmara.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CompanyService {
    public List<Employee> getEmployeesByCompany(Long companyId);
    public List<Company> get();
}
