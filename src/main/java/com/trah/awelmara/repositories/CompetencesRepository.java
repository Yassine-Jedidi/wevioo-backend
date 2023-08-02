package com.trah.awelmara.repositories;


import com.trah.awelmara.model.Competence;
import com.trah.awelmara.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompetencesRepository extends JpaRepository<Competence,Long> {
    Optional<Competence> findByNom(String competenceNom);
}
