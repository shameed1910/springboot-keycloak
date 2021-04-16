package com.example.keycloak.springbootkeycloak.controller;

import com.example.keycloak.springbootkeycloak.model.Employee;
import com.example.keycloak.springbootkeycloak.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    @RolesAllowed({"user", "admin"})
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping("/employees")
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
