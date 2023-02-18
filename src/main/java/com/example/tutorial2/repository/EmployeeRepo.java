package com.example.tutorial2.repository;

import com.example.tutorial2.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
