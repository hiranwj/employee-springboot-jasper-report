package io.xdoto.employeeme.repository;

import io.xdoto.employeeme.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
