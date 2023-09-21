package com.example.evaluation_step2.test;

import com.example.evaluation_step2.dao.EmployeeDAO;
import com.example.evaluation_step2.entity.Employee;
import com.example.evaluation_step2.service.EmployeeDAOImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */
public class EmployeeTest {
    @Test
    void testGetAllEmployes() {
        EmployeeDAO dao = new EmployeeDAOImpl();

        List<Employee> employes = dao.getAllEmployes();
        assertEquals(0, employes.size());

        dao.addEmploye(new Employee(1, "John", "Doe"));
        dao.addEmploye(new Employee(2, "Jane", "Doe"));

        employes = dao.getAllEmployes();
        assertEquals(2, employes.size());
    }

    @Test
    void testGetEmployeById() {
        EmployeeDAO dao = new EmployeeDAOImpl();

        Employee employe = new Employee(1, "John", "Doe");
        dao.addEmploye(employe);

        Employee retrievedEmploye = dao.getEmployeById(1);

        assertNotNull(retrievedEmploye);
        assertEquals(employe, retrievedEmploye);
    }

    @Test
    void testUpdateEmploye() {
        EmployeeDAO dao = new EmployeeDAOImpl();

        Employee employe = new Employee(1, "John", "Doe");
        dao.addEmploye(employe);

        employe.setPrenom("Jane");
        dao.updateEmploye(employe);

        Employee updatedEmploye = dao.getEmployeById(1);

        assertNotNull(updatedEmploye);
        assertEquals("Jane", updatedEmploye.getPrenom());
    }

    @Test
    void testDeleteEmploye() {
        EmployeeDAO dao = new EmployeeDAOImpl();

        Employee employe = new Employee(1, "John", "Doe");
        dao.addEmploye(employe);

        dao.deleteEmploye(1);

        assertNull(dao.getEmployeById(1));
    }
}
