package com.example.ems;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long>{
//	public List<Employee> getEmployees();
    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(double salary);

    @Query("""
        SELECT e FROM Employee e
        WHERE e.salary >
        (SELECT AVG(emp.salary) FROM Employee emp)
    """)
    List<Employee> salaryAboveAverage();
}
