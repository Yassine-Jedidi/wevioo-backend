package com.trah.awelmara.repositories;

import com.trah.awelmara.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByNom(String nom);
}
