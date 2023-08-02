package com.trah.awelmara.repositories;

import com.trah.awelmara.model.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongeRepository extends JpaRepository<Conge,Long> {
    List<Conge> findByStatut(String status);
    List<Conge> findByEmployeeId(Long employeeId);
}
