package org.example.springdata.controller;


import org.example.springdata.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.springdata.repo.EmpRepo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("Emp")
public class EmpController {

    @Autowired
    private EmpRepo empRepo;

    @GetMapping("/al")
    public Long countEmp(){
        return empRepo.count();
    }

    @GetMapping("/id/{id}")
    public Employee getEmp(@PathVariable int id){
        return empRepo.findById(id).get(); // أو throw Exception حسب المطلوب
    }

    @GetMapping("/all")
    public List<Employee> getEmps() {
        return StreamSupport.stream(empRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/newuser")
    public Employee addEmp(@RequestBody Employee emp){
        return empRepo.save(emp);
    }

    @PutMapping("update")
    public Employee updateEmp(@RequestBody Employee emp){
        return empRepo.save(emp);
    }
}
