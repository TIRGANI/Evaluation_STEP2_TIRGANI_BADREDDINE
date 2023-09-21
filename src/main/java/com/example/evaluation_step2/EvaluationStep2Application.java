package com.example.evaluation_step2;

import com.example.evaluation_step2.dao.EmployeeAnnualSalaryDAO;
import com.example.evaluation_step2.entity.Employee;
import com.example.evaluation_step2.entity.EmployeeAnnualSalary;
import com.example.evaluation_step2.service.EmployeeAnnualSalaryDAOImpl;
import com.example.evaluation_step2.service.EmployeeDAOImpl;
import com.example.evaluation_step2.service.SalaryDAOImpl;
import com.example.evaluation_step2.dao.EmployeeDAO;
import com.example.evaluation_step2.dao.SalaryDAO;
import com.example.evaluation_step2.entity.Salary;


import java.util.List;
/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */
public class EvaluationStep2Application {

    public static void main(String[] args) {
        EmployeeDAO employeDAO = new EmployeeDAOImpl();
        SalaryDAO salaryDAO = new SalaryDAOImpl();
        EmployeeAnnualSalaryDAO employeSalaireDAO = new EmployeeAnnualSalaryDAOImpl();

        employeDAO.addEmploye(new Employee(1, "John", "Doe"));
        employeDAO.addEmploye(new Employee(2, "Jane", "Doe"));
        employeDAO.addEmploye(new Employee(3, "Bob", "Smith"));
        employeDAO.addEmploye(new Employee(4, "Bob", "Marley"));

        salaryDAO.addSalaire(new Salary(1, 2021, 1, 3000));
        salaryDAO.addSalaire(new Salary(2, 2021, 1, 3200));
        salaryDAO.addSalaire(new Salary(3, 2021, 1, 2800));
        salaryDAO.addSalaire(new Salary(4, 2021, 1, 3500));

        List<EmployeeAnnualSalary> listeEmployeeSalaireAnnuel = employeDAO.getAllEmployes().stream()
                .map(employe -> {
                    Thread salary;
                    double salaryAnnuel = salaryDAO.getAllSalaires().stream()
                            .filter(salaire -> salaire.getId() == employe.getId())
                            .mapToDouble(Salary::getSalaireMensuel)
                            .sum();

                    EmployeeAnnualSalary employeSalaireAnnuel = new EmployeeAnnualSalary(
                            employe.getId(), employe.getNom(), employe.getPrenom(), 2021, salaryAnnuel);

                    employeSalaireDAO.addEmployeSalaireAnnuel(employeSalaireAnnuel);
                    return employeSalaireAnnuel;
                })
                .toList();

        listeEmployeeSalaireAnnuel.forEach(employeeSalaireAnnuel -> {
            System.out.println(employeeSalaireAnnuel.getNom() + " " + employeeSalaireAnnuel.getPrenom()
                    + " a reçu un salaire annuel de " + employeeSalaireAnnuel.getSalaireAnnuel());
        });

        EmployeeAnnualSalary employeeMinSalaire = employeSalaireDAO.getMinSalaireAnnuel();
        EmployeeAnnualSalary employeeMaxSalaire = employeSalaireDAO.getMaxSalaireAnnuel();

        if (employeeMinSalaire != null && employeeMaxSalaire != null) {
            System.out.println("Le salaire annuel minimum est de " + employeeMinSalaire.getSalaireAnnuel() +
                    " attribué à " + employeeMinSalaire.getNom() + " " + employeeMinSalaire.getPrenom());

            System.out.println("Le salaire annuel maximum est de " + employeeMaxSalaire.getSalaireAnnuel() +
                    " attribué à " + employeeMaxSalaire.getNom() + " " + employeeMaxSalaire.getPrenom());
        }
    }
}
