package org.example.springdata.repo;

import org.example.springdata.model.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepo extends CrudRepository<Employee, Integer> {
}
