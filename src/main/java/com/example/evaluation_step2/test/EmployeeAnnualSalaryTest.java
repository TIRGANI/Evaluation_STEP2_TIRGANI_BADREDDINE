package com.example.evaluation_step2.test;

import com.example.evaluation_step2.dao.EmployeeAnnualSalaryDAO;
import com.example.evaluation_step2.entity.EmployeeAnnualSalary;
import com.example.evaluation_step2.service.EmployeeAnnualSalaryDAOImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */

public class EmployeeAnnualSalaryTest {
    @Test
    void testGetAllEmployeSalaireAnnuel() {
        EmployeeAnnualSalaryDAO dao = new EmployeeAnnualSalaryDAOImpl();

        List<EmployeeAnnualSalary> employeSalaires = dao.getAllEmployeSalaireAnnuel();
        assertEquals(0, employeSalaires.size());

        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(1, "John", "Doe", 2021, 50000.0));
        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(2, "Jane", "Doe", 2021, 60000.0));

        employeSalaires = dao.getAllEmployeSalaireAnnuel();
        assertEquals(2, employeSalaires.size());
    }

    @Test
    void testGetEmployeSalaireAnnuelById() {
        EmployeeAnnualSalaryDAO dao = new EmployeeAnnualSalaryDAOImpl();

        EmployeeAnnualSalary employeSalaire = new EmployeeAnnualSalary(1, "John", "Doe", 2021, 50000.0);
        dao.addEmployeSalaireAnnuel(employeSalaire);

        EmployeeAnnualSalary retrievedSalaire = dao.getEmployeSalaireAnnuelById(1);

        assertNotNull(retrievedSalaire);
        assertEquals(employeSalaire, retrievedSalaire);
    }

    @Test
    void testGetMinSalaireAnnuel() {
        EmployeeAnnualSalaryDAO dao = new EmployeeAnnualSalaryDAOImpl();

        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(1, "John", "Doe", 2021, 50000.0));
        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(2, "Jane", "Doe", 2021, 60000.0));
        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(3, "Bob", "Smith", 2021, 45000.0));

        EmployeeAnnualSalary minSalaire = dao.getMinSalaireAnnuel();

        assertNotNull(minSalaire);
        assertEquals(45000.0, minSalaire.getSalaireAnnuel());
    }

    @Test
    void testGetMaxSalaireAnnuel() {
        EmployeeAnnualSalaryDAO dao = new EmployeeAnnualSalaryDAOImpl();

        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(1, "John", "Doe", 2021, 50000.0));
        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(2, "Jane", "Doe", 2021, 60000.0));
        dao.addEmployeSalaireAnnuel(new EmployeeAnnualSalary(3, "Bob", "Smith", 2021, 70000.0));

        EmployeeAnnualSalary maxSalaire = dao.getMaxSalaireAnnuel();

        assertNotNull(maxSalaire);
        assertEquals(70000.0, maxSalaire.getSalaireAnnuel());
    }

    @Test
    void testUpdateEmployeSalaireAnnuel() {
        EmployeeAnnualSalaryDAO dao = new EmployeeAnnualSalaryDAOImpl();

        EmployeeAnnualSalary employeSalaire = new EmployeeAnnualSalary(1, "John", "Doe", 2021, 50000.0);
        dao.addEmployeSalaireAnnuel(employeSalaire);

        employeSalaire.setSalaireAnnuel(55000.0);
        dao.updateEmployeSalaireAnnuel(employeSalaire);

        EmployeeAnnualSalary updatedSalaire = dao.getEmployeSalaireAnnuelById(1);

        assertNotNull(updatedSalaire);
        assertEquals(55000.0, updatedSalaire.getSalaireAnnuel());
    }

    @Test
    void testDeleteEmployeSalaireAnnuel() {
        EmployeeAnnualSalaryDAO dao = new EmployeeAnnualSalaryDAOImpl();

        EmployeeAnnualSalary employeSalaire = new EmployeeAnnualSalary(1, "John", "Doe", 2021, 50000.0);
        dao.addEmployeSalaireAnnuel(employeSalaire);

        dao.deleteEmployeSalaireAnnuel(1);

        assertNull(dao.getEmployeSalaireAnnuelById(1));
    }
}
