package com.springcaching.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcaching.model.Employee;
import com.springcaching.repository.EmployeeRepository;

@RestController
public class MyController {
	
	@Autowired
	EmployeeRepository em;
	
	
	@GetMapping("/get")
	public String home()
	{
		return "welcome-page";
	}
	
	
	////// Without caching method......
	
	@GetMapping("/getAll")
	public List<Employee> getAll()
	{
		
		System.out.println("calling this method without cache");
		
		return em.findAll();
	}
	
	
	//// With caching method......
	@GetMapping("/getAll/empl")
	
	@Cacheable(value = "cachEmployee")
	
	public List<Employee> getAllEmployee()
	{
		
		System.out.println("calling this method using cache method");
		
		return em.findAll();
	}
	
	
	/////CachEvict.....................  
	
	@GetMapping("/remove")
	
	@CacheEvict(value="cachEmployee" , allEntries = true)
	
	public List<Employee> removeCach()
	{
		
		System.out.println("calling remove method....");
		
		return em.findAll();
	}
	

	@PostMapping("/save")
	public String save(@RequestBody Employee employee)
	{
		em.save(employee);
		
		return "Data saved successfully";
	}
	
	
	@GetMapping("/getById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id)
	{
		Optional<Employee> employee=em.findById(id);
		
		return employee;
		
	
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Employee emp=em.save(employee);
		
		return emp;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmplById(@PathVariable int id)
	{
		em.deleteById(id);
		
		return "Employee with id = "+ id+" has been deleted.";
	}
	
	
	
	
	
	
	
}
