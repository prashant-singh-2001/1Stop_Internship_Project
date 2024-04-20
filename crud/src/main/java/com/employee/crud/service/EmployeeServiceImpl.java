package com.employee.crud.service;

import com.employee.crud.entity.Employee;
import com.employee.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	  
	@Autowired
	private EmployeeRepository empRepository;
	
	@Override 
	public Employee saveEmployee(Employee emp) {
		return empRepository.save(emp);
	}
	
	@Override
	public List<Employee> fetchAllEmployees(){
		List<Employee> allEmp = empRepository.findAll();
		return allEmp;
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp = empRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}else {
			return null;
		}
	}
	
	@Override
	public Employee updateEmployeeById(Long id,Employee emp) {
		Optional<Employee> emp1 = empRepository.findById(id);
		if(emp1.isPresent()) {
			Employee originalEmp = emp1.get();
			if(Objects.nonNull(emp.getname()) && !"".equalsIgnoreCase(emp.getname())) {
				originalEmp.setName(emp.getname());
			}
			if(Objects.nonNull(emp.getDoj()) && emp.getDoj() != "") {
				originalEmp.setDoj(emp.getDoj());
			}
			if(Objects.nonNull(emp.getSalary()) && (emp.getSalary() != 0)) {
				originalEmp.setSalary(emp.getSalary());
			}
			if(Objects.nonNull(emp.getStatus()) && (emp.getStatus() != -1)) {
				originalEmp.setStatus(emp.getStatus());
			}
			return empRepository.save(originalEmp);
		}
		return null;		
	}
	
	@Override
	public String deleteEmployeeById(Long id) {
		if(empRepository.findById(id).isPresent()) {
			empRepository.deleteById(id);
			return "Employee Deleted Successfully";
		}
		return "Employee by this id doesn't Exist !";
	}
	
}
