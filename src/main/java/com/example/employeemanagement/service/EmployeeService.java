
package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll() {
        logger.info("Fetching all employees");
        return repo.findAll();
    }

    @Transactional
    public void save(Employee emp) {
        logger.info("Saving employee: {}", emp.getName());
        repo.save(emp);
    }

    public Employee get(Long id) {
        logger.info("Fetching employee with ID: {}", id);
        return repo.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        logger.info("Deleting employee with ID: {}", id);
        repo.deleteById(id);
    }
}
