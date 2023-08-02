package com.trah.awelmara.controllers;

import com.trah.awelmara.dto.UserExistsResponse;
import com.trah.awelmara.model.Login;
import com.trah.awelmara.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    LoginRepository loginRepository;
    @GetMapping("/login")
    public List<Login> getAllUsers(){
        return loginRepository.findAll();
    }


    // Constructor injection of LoginRepository
    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<UserExistsResponse> userExists(@RequestBody Login login) {
        Login user = loginRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        boolean userExists = user != null;
        Long employeeId = userExists ? user.getEmployee().getId() : null;
        UserExistsResponse response = new UserExistsResponse(userExists, employeeId);
        return ResponseEntity.ok(response);
    }
}
