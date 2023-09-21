package com.example.evaluation_step2.dao;

import com.example.evaluation_step2.entity.EmployeeAnnualSalary;

import java.util.List;

public interface EmployeeAnnualSalaryDAO {
    List<EmployeeAnnualSalary> getAllEmployeSalaireAnnuel();
    EmployeeAnnualSalary getEmployeSalaireAnnuelById(int id);
    EmployeeAnnualSalary getMinSalaireAnnuel();
    EmployeeAnnualSalary getMaxSalaireAnnuel();
    void addEmployeSalaireAnnuel(EmployeeAnnualSalary employeSalaireAnnuel);
    void updateEmployeSalaireAnnuel(EmployeeAnnualSalary employeSalaireAnnuel);
    void deleteEmployeSalaireAnnuel(int id);
}
