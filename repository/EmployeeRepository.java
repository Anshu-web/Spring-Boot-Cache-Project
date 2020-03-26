package com.springcaching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcaching.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
