package com.trah.awelmara.controllers;

import com.trah.awelmara.model.Role;
import com.trah.awelmara.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/roles")
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}
