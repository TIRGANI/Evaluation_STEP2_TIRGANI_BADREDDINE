package com.example.evaluation_step2.dao;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */

import com.example.evaluation_step2.entity.Salary;

import java.util.List;

public interface SalaryDAO {
    List<Salary> getAllSalaires();
    Salary getSalaireById(int id);
    void addSalaire(Salary salaire);
    void updateSalaire(Salary salaire);
    void deleteSalaire(int id);
}
