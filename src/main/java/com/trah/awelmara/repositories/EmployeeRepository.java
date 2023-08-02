package com.trah.awelmara.repositories;

import com.trah.awelmara.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
