package com.trah.awelmara.repositories;

import com.trah.awelmara.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByUsernameAndPassword(String username,String password);
}
