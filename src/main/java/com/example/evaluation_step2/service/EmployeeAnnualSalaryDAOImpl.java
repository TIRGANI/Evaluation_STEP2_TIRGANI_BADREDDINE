package com.example.evaluation_step2.service;

import com.example.evaluation_step2.dao.EmployeeAnnualSalaryDAO;
import com.example.evaluation_step2.entity.EmployeeAnnualSalary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */

public class EmployeeAnnualSalaryDAOImpl implements EmployeeAnnualSalaryDAO {
    private List<EmployeeAnnualSalary> employeSalairesAnnuels = new ArrayList<>();
    /**
     * Récupère une liste de tous les objets EmployeeAnnualSalary.
     *
     * @return Une liste contenant tous les objets EmployeeAnnualSalary.
     */
    @Override
    public List<EmployeeAnnualSalary> getAllEmployeSalaireAnnuel() {
        return new ArrayList<>(employeSalairesAnnuels);
    }
    /**
     * Récupère un objet EmployeeAnnualSalary par son ID.
     *
     * @param id L'ID de l'objet EmployeeAnnualSalary à récupérer.
     * @return L'objet EmployeeAnnualSalary avec l'ID spécifié, ou null s'il n'est pas trouvé.
     */
    @Override
    public EmployeeAnnualSalary getEmployeSalaireAnnuelById(int id) {
        Optional<EmployeeAnnualSalary> optionalEmployeSalaireAnnuel = employeSalairesAnnuels.stream()
                .filter(salaireAnnuel -> salaireAnnuel.getId() == id)
                .findFirst();
        return optionalEmployeSalaireAnnuel.orElse(null);
    }
    /**
     * Récupère l'objet EmployeeAnnualSalary avec le salaire annuel minimum.
     *
     * @return L'objet EmployeeAnnualSalary avec le salaire annuel minimum, ou null si la liste est vide.
     */
    @Override
    public EmployeeAnnualSalary getMinSalaireAnnuel() {
        return employeSalairesAnnuels.stream()
                .min((salaire1, salaire2) -> Double.compare(salaire1.getSalaireAnnuel(), salaire2.getSalaireAnnuel()))
                .orElse(null);
    }
    /**
     * Récupère l'objet EmployeeAnnualSalary avec le salaire annuel maximum.
     *
     * @return L'objet EmployeeAnnualSalary avec le salaire annuel maximum, ou null si la liste est vide.
     */
    @Override
    public EmployeeAnnualSalary getMaxSalaireAnnuel() {
        return employeSalairesAnnuels.stream()
                .max((salaire1, salaire2) -> Double.compare(salaire1.getSalaireAnnuel(), salaire2.getSalaireAnnuel()))
                .orElse(null);
    }
    /**
     * Ajoute un EmployeeAnnualSalary à la liste.
     *
     * @param employeSalaireAnnuel L'EmployeeAnnualSalary à ajouter.
     */
    @Override
    public void addEmployeSalaireAnnuel(EmployeeAnnualSalary employeSalaireAnnuel) {
        employeSalairesAnnuels.add(employeSalaireAnnuel);
    }
    /**
     * Met à jour un EmployeeAnnualSalary dans la liste.
     *
     * @param employeSalaireAnnuel L'objet EmployeeAnnualSalary mis à jour.
     */
    @Override
    public void updateEmployeSalaireAnnuel(EmployeeAnnualSalary employeSalaireAnnuel) {
        employeSalairesAnnuels.stream()
                .filter(salaireAnnuel -> salaireAnnuel.getId() == employeSalaireAnnuel.getId() &&
                        salaireAnnuel.getAnnee() == employeSalaireAnnuel.getAnnee())
                .findFirst()
                .ifPresent(salaireAnnuel -> salaireAnnuel = employeSalaireAnnuel);
    }
    /**
     * Supprime un EmployeeAnnualSalary de la liste par ID.
     *
     * @param id L'ID de l'EmployeeAnnualSalary à supprimer.
     */
    @Override
    public void deleteEmployeSalaireAnnuel(int id) {
        employeSalairesAnnuels.removeIf(employeSalaireAnnuel -> employeSalaireAnnuel.getId() == id);
    }
}
