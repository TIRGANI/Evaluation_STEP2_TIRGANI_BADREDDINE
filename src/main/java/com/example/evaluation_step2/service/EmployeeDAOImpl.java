package com.example.evaluation_step2.service;

import com.example.evaluation_step2.dao.EmployeeDAO;
import com.example.evaluation_step2.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */

public class EmployeeDAOImpl implements EmployeeDAO {
    private List<Employee> employees = new ArrayList<>();
    /**
     * Récupère une liste de tous les objets Employee.
     *
     * @return Une liste contenant tous les objets Employee.
     */
    @Override
    public List<Employee> getAllEmployes() {
        return new ArrayList<>(employees);
    }

    /**
     * Récupère un objet Employee par son identifiant unique.
     *
     * @param id L'identifiant unique de l'Employee à récupérer.
     * @return L'objet Employee avec l'ID spécifié, ou null s'il n'est pas trouvé.
     */
    @Override
    public Employee getEmployeById(int id) {
        Optional<Employee> optionalEmployee = employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
        return optionalEmployee.orElse(null);
    }

    /**
     * Ajoute un nouvel Employee à la liste.
     *
     * @param employe L'Employee à ajouter.
     */
    @Override
    public void addEmploye(Employee employe) {
        employees.add(employe);
    }

    /**
     * Met à jour un Employee existant dans la liste.
     *
     * @param employe L'Employee mis à jour.
     */
    @Override
    public void updateEmploye(Employee employe) {
        employees.stream()
                .filter(e -> e.getId() == employe.getId())
                .findFirst()
                .ifPresent(e -> e = employe);
    }

    /**
     * Supprime un Employee de la liste par son identifiant unique.
     *
     * @param id L'identifiant unique de l'Employee à supprimer.
     */
    @Override
    public void deleteEmploye(int id) {
        employees.removeIf(employe -> employe.getId() == id);
    }
}