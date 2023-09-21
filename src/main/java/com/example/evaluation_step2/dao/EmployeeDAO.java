package com.example.evaluation_step2.dao;

import com.example.evaluation_step2.entity.Employee;

import java.util.List;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */

public interface EmployeeDAO {
    List<Employee> getAllEmployes();
    Employee getEmployeById(int id);
    void addEmploye(Employee employe);
    void updateEmploye(Employee employe);
    void deleteEmploye(int id);
}

